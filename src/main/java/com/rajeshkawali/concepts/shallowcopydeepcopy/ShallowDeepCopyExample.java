package com.rajeshkawali.concepts.shallowcopydeepcopy;

import java.util.ArrayList;
import java.util.List;

public class ShallowDeepCopyExample {

    public static void main(String[] args) {

        // Original list contains a mutable StringBuilder.
        List<StringBuilder> original = new ArrayList<>();
        original.add(new StringBuilder("Java"));

        // SHALLOW COPY: New list, same StringBuilder object.
        List<StringBuilder> shallow = new ArrayList<>(original);

        // DEEP COPY: New list and new StringBuilder object.
        List<StringBuilder> deep = new ArrayList<>();

        for (StringBuilder value : original) {
            deep.add(new StringBuilder(value.toString()));
        }

        // Modify the nested object in the original list.
        original.get(0).append(" Spring");

        System.out.println(original.get(0)); // Java Spring
        System.out.println(shallow.get(0));  // Java Spring
        System.out.println(deep.get(0));     // Java

        // Lists themselves are different objects.
        System.out.println(original == shallow); // false

        // Shallow copy shares the nested object.
        System.out.println(original.get(0) == shallow.get(0));
        // true

        // Deep copy has a separate nested object.
        System.out.println(original.get(0) == deep.get(0));
        // false
    }
}



/*
 ==========================================================
 SHALLOW COPY VS DEEP COPY IN JAVA
 ==========================================================

 SHALLOW COPY:
 Creates a new object but shares references to nested
 objects with the original.

 DEEP COPY:
 Creates a new object and independent copies of its
 mutable nested objects.

 1. OBJECT REFERENCE

 Shallow Copy:
 Original and copied objects are different, but their
 nested mutable objects may be shared.

 Deep Copy:
 Original and copied objects have independent mutable
 object graphs (no shared mutable nested state).

 2. MODIFICATION

 Shallow Copy:
 Changing a shared nested object affects both copies.
 Changing primitive fields or reassigning a reference
 in one object does NOT affect the other.

 Deep Copy:
 Changes to mutable objects in one copy do not
 affect the other.

 3. clone() METHOD

 Shallow Copy:
 Object.clone() performs a field-by-field shallow copy.

 Deep Copy:
 Requires manually copying nested mutable objects.
 This can be done using copy constructors, factory
 methods, or a carefully implemented clone().

 4. WHEN TO USE

 Shallow Copy:
 Suitable when fields are primitives, immutable objects,
 or sharing nested objects is acceptable.

 Deep Copy:
 Suitable when an object contains mutable references
 that must remain independent.

 5. PERFORMANCE

 Shallow Copy:
 Generally faster and uses less memory.

 Deep Copy:
 Generally requires more processing and memory
 because nested objects are also copied.

 6. IMPORTANT

 - String is immutable, so sharing it is safe.
 - Arrays, lists, maps, and StringBuilder are mutable.
 - A new List<>(oldList) creates a shallow copy.
 - Deep copying does NOT require clone().
 - Copying immutable objects is usually unnecessary.

 ==========================================================
*/
