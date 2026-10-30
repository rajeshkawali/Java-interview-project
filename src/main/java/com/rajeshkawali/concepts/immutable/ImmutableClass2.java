
package com.rajeshkawali.concepts.immutable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * ==========================================================
 * IMMUTABLE CLASS IN JAVA - COMPLETE INTERVIEW EXAMPLE
 * ==========================================================
 *
 * Rules:
 * 1. Make class final (simple way to prevent subclassing).
 * 2. Make fields private and final.
 * 3. Initialize fields in constructor.
 * 4. Do not provide setters or mutating methods.
 * 5. Defensively copy mutable constructor arguments.
 * 6. Never expose mutable internal objects.
 * 7. Deep-copy nested mutable objects when necessary.
 * 8. Validate constructor arguments.
 * 9. Avoid leaking "this" during construction.
 *
 * NOTE:
 * final reference != immutable object.
 */

// ==========================================================
// 1. IMMUTABLE CLASS
// ==========================================================

final class Test {

    private final String name;
    private final int regNo;

    // Map<String, String>: String keys and values are immutable.
    private final Map<String, String> metadata;

    // Date is mutable, so it requires defensive copying.
    private final Date joiningDate;

    public Test(
            String name,
            int regNo,
            Map<String, String> metadata,
            Date joiningDate) {

        // Validate inputs before storing them.
        this.name = Objects.requireNonNull(name, "name");
        this.regNo = regNo;

        // Constructor copy prevents changes through original map.
        this.metadata = new HashMap<>(
                Objects.requireNonNull(metadata, "metadata"));

        // Date copy prevents changes through original Date object.
        this.joiningDate = new Date(
                Objects.requireNonNull(joiningDate, "joiningDate")
                        .getTime());
    }

    public String getName() {
        return name; // String is immutable.
    }

    public int getRegNo() {
        return regNo; // Primitive value.
    }

    public Map<String, String> getMetadata() {
        // Return copy, not internal map.
        return new HashMap<>(metadata);
    }

    public Date getJoiningDate() {
        // Return copy, not internal Date.
        return new Date(joiningDate.getTime());
    }
}

// ==========================================================
// 2. TEST CLASS
// ==========================================================

public class ImmutableClass2 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");

        Date date = new Date(0L);

        Test obj = new Test("ABC", 101, map, date);

        // ==========================================
        // CASE 1: READ ORIGINAL VALUES
        // ==========================================

        System.out.println(obj.getName());  // ABC
        System.out.println(obj.getRegNo()); // 101
        System.out.println(obj.getMetadata());
        // Contains {1=first, 2=second}

        // ==========================================
        // CASE 2: MODIFY ORIGINAL MAP
        // ==========================================

        map.put("3", "third");

        // Internal map remains unchanged because
        // constructor created a defensive copy.
        System.out.println(obj.getMetadata());
        // Contains only {1=first, 2=second}

        // ==========================================
        // CASE 3: MODIFY RETURNED MAP
        // ==========================================

        obj.getMetadata().put("4", "fourth");

        // Internal map remains unchanged because
        // getter returns a new map.
        System.out.println(obj.getMetadata());
        // Contains only {1=first, 2=second}

        // ==========================================
        // CASE 4: MODIFY ORIGINAL DATE
        // ==========================================

        date.setTime(100000L);

        // Original Date changed, but internal Date did not.
        System.out.println(obj.getJoiningDate().getTime());
        // Output: 0

        // ==========================================
        // CASE 5: MODIFY DATE RETURNED BY GETTER
        // ==========================================

        Date returnedDate = obj.getJoiningDate();
        returnedDate.setTime(200000L);

        // Internal Date remains unchanged.
        System.out.println(obj.getJoiningDate().getTime());
        // Output: 0

        // ==========================================
        // CASE 6: FINAL DOES NOT MAKE OBJECT IMMUTABLE
        // ==========================================

        final Map<String, String> finalMap = new HashMap<>();

        finalMap.put("A", "Apple"); // Allowed!

        // finalMap = new HashMap<>(); // Compile error

        /*
         * final prevents reassignment of the reference.
         * It does not prevent modifying the map contents.
         */

        // ==========================================
        // CASE 7: UNMODIFIABLE VIEW IS NOT A COPY
        // ==========================================

        Map<String, String> source = new HashMap<>();
        source.put("A", "Apple");

        Map<String, String> view =
                Collections.unmodifiableMap(source);

        // view.put("B", "Ball");
        // Runtime: UnsupportedOperationException

        source.put("B", "Ball");

        // View reflects changes to the original source.
        System.out.println(view);
        // Contains {A=Apple, B=Ball}

        /*
         * Collections.unmodifiableMap(source)
         * creates an unmodifiable VIEW.
         *
         * It does not copy the source map.
         */

        // ==========================================
        // CASE 8: UNMODIFIABLE SNAPSHOT - JAVA 10+
        // ==========================================

        Map<String, String> snapshot = Map.copyOf(source);

        source.put("C", "Cat");

        System.out.println(snapshot);
        // Contains A and B, but not C.

        // snapshot.put("D", "Dog");
        // Runtime: UnsupportedOperationException

        /*
         * Map.copyOf() creates an unmodifiable snapshot.
         *
         * It rejects null keys and values.
         *
         * It is a shallow copy:
         * mutable nested objects are not deep-copied.
         */

        // ==========================================
        // CASE 9: NULL VALIDATION
        // ==========================================

        /*
         * new ImmutableClass2("ABC", 101, null, date);
         *
         * Runtime: NullPointerException
         *
         * Because constructor uses requireNonNull().
         */

        // ==========================================
        // CASE 10: MUTABLE NESTED VALUES
        // ==========================================

        Map<String, StringBuilder> nested = new HashMap<>();

        StringBuilder builder = new StringBuilder("Java");
        nested.put("language", builder);

        Map<String, StringBuilder> shallowCopy =
                new HashMap<>(nested);

        builder.append(" Spring");

        System.out.println(
                shallowCopy.get("language"));
        // Output: Java Spring

        /*
         * WHY?
         *
         * new HashMap<>(nested) copies the map structure,
         * but both maps still refer to the SAME
         * mutable StringBuilder object.
         *
         * For true immutability, copy nested mutable
         * objects or store immutable representations.
         */

        // ==========================================
        // CASE 11: SAFE NESTED COPY
        // ==========================================

        Map<String, String> safeNested = new HashMap<>();

        for (Map.Entry<String, StringBuilder> entry
                : nested.entrySet()) {

            // Convert mutable StringBuilder to immutable String.
            safeNested.put(
                    entry.getKey(),
                    entry.getValue().toString());
        }

        builder.append(" Boot");

        System.out.println(safeNested.get("language"));
        // Output: Java Spring
        // Later StringBuilder changes do not affect it.
    }
}

/*
 * ==========================================================
 * IMPORTANT INTERVIEW QUESTIONS
 * ==========================================================
 *
 * Q1. Is final class mandatory?
 * Ans: No, but final is the simplest approach.
 *      Carefully controlled inheritance can also work.
 *
 * Q2. Does final Map make it immutable?
 * Ans: No, final prevents reference reassignment only.
 *
 * Q3. Shallow copy vs deep copy?
 * Ans: Shallow copy copies the container but shares
 *      nested object references.
 *      Deep copy also copies mutable nested objects.
 *
 * Q4. Is Collections.unmodifiableMap() immutable?
 * Ans: It prevents changes through the view, but the
 *      backing map can still be modified elsewhere.
 *
 * Q5. Does Map.copyOf() create a deep copy?
 * Ans: No. It creates an unmodifiable snapshot of
 *      the mappings, not deep copies of values.
 *
 * Q6. Why copy Date in constructor and getter?
 * Ans: Date is mutable. Both copies prevent changes
 *      through external references.
 *
 * Q7. Is String immutable?
 * Ans: Yes. No defensive copy is needed.
 *
 * Q8. Must immutable classes override clone()?
 * Ans: No. It is not required for immutability.
 *
 * Q9. Is an immutable class automatically thread-safe?
 * Ans: A properly constructed and safely published
 *      immutable object is safe for concurrent reads.
 *
 * Q10. Can an immutable class contain mutable fields?
 * Ans: Yes, if those objects cannot be modified
 *      through any exposed reference or method.
 *
 * Q11. Can an immutable class have mutable local variables?
 * Ans: Yes. Local variables do not change the
 *      observable state of the immutable object.
 *
 * Q12. What does "this escape" mean?
 * Ans: Exposing this object before construction finishes.
 *      Avoid registering listeners or publishing "this"
 *      from the constructor.
 *
 * Q13. Is an unmodifiable collection always immutable?
 * Ans: No. Its backing data or contained objects may
 *      still be mutable.
 *
 * Q14. Why is immutability useful?
 * Ans: Easier concurrency, predictable state,
 *      safe sharing, and simpler reasoning.
 *
 * Q15. What about records?
 * Ans: Java records are shallowly immutable by default.
 *      Mutable record components still need defensive copies.
 *
 * ==========================================================
 * REMEMBER
 * ==========================================================
 *
 * private + final + no setters
 *          +
 * defensive copies
 *          +
 * no mutable state exposure
 *          =
 * immutable object
 */
