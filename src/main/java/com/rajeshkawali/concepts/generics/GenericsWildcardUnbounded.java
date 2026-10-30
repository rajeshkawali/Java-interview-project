
package com.rajeshkawali.concepts.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * ==========================================================
 * UNBOUNDED WILDCARD - <?>
 * ==========================================================
 *
 * 1. <?> means unknown element type.
 *
 * 2. Accepts lists of any type:
 *    List<Integer>, List<String>, List<Number>,
 *    List<Object>, etc.
 *
 * 3. We can READ elements as Object.
 *
 * 4. We CANNOT add non-null values because the
 *    actual element type is unknown.
 *
 * 5. We CAN add null.
 *
 * 6. Useful for operations that do not depend
 *    on the element type, such as printing,
 *    counting or checking if a list is empty.
 *
 * 7. List<?> is effectively equivalent to
 *    List<? extends Object> for ordinary use.
 *
 * IMPORTANT:
 * <?> does NOT guarantee that elements are Integer.
 */

public class GenericsWildcardUnbounded {

    public static void main(String[] args) {

        // ==========================================
        // 1. LIST<Object> - MIXED TYPES ALLOWED
        // ==========================================

        List<Object> ints = new ArrayList<>();

        // int values are autoboxed into Integer objects.
        ints.add(3);
        ints.add(5);
        ints.add(10);

        // Works because all elements are Integer.
        int sum = sum(ints);
        System.out.println("Sum of ints = " + sum);
        // Output: Sum of ints = 18

        /*
         * IMPORTANT:
         *
         * ints.add("str"); is NOT a compile-time error.
         *
         * List<Object> accepts String, Integer, etc.
         *
         * But calling sum(ints) after adding "str"
         * will throw ClassCastException because
         * String cannot be cast to Integer.
         */

        // ==========================================
        // 2. UNBOUNDED WILDCARD - ANY LIST TYPE
        // ==========================================

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Spring");

        // Both work because printList accepts List<?>.
        printList(numbers); // [10, 20]
        printList(names);   // [Java, Spring]

        // ==========================================
        // 3. READING AND ADDING
        // ==========================================

        List<?> list = numbers;

        // Allowed: reading as Object.
        Object value = list.get(0);
        System.out.println(value); // 10

        // Integer num = list.get(0); // Compile error

        // list.add(100);   // Compile error
        // list.add("Java"); // Compile error

        // Allowed: null is valid for any reference type.
        // Note: this modifies the underlying numbers list.
        list.add(null);

        // ==========================================
        // 4. USEFUL OPERATIONS
        // ==========================================

        System.out.println(list.size());    // 3
        System.out.println(list.isEmpty()); // false
    }

    // ==============================================
    // 5. YOUR ORIGINAL SUM METHOD
    // ==============================================

    /*
     * List<?> accepts ANY list type.
     *
     * Reading returns Object.
     *
     * (int) n requires the runtime object to be
     * compatible with unboxing to int (Integer).
     *
     * Therefore, this method is NOT type-safe.
     *
     * A String or Double element will cause
     * ClassCastException.
     */
    public static int sum(List<?> list) {

        int sum = 0;

        for (Object n : list) {
            sum += (int) n; // Cast to Integer + unboxing
        }

        return sum;
    }

    // ==============================================
    // 6. BETTER SUM METHOD - UPPER BOUND
    // ==============================================

    /*
     * Use <? extends Number> when reading numbers.
     *
     * It accepts List<Integer>, List<Double>,
     * List<Float>, List<Number>, etc.
     *
     * Every element is guaranteed to be a Number
     * (unless it is null).
     */
    public static int safeSum(List<? extends Number> list) {

        int sum = 0;

        for (Number n : list) {
            sum += n.intValue();
        }

        return sum;
    }

    // ==============================================
    // 7. BEST USE CASE FOR <?>
    // ==============================================

    /*
     * We only print the list.
     * We do not need to know its element type.
     *
     * Therefore, List<?> is appropriate.
     */
    public static void printList(List<?> list) {
        System.out.println(list);
    }
}


/*
Tricky interview Q&A:

Q1. What is the difference between List<Object> and List<?>?
List<Object> allows adding any object, but List<?> does not allow adding non-null values because the element type is unknown.

Q2. Why does List<?> accept List<String> but List<Object> does not?
Because <?> represents an unknown type. Java generics are invariant, so List<String> is not a subtype of List<Object>.

Q3. Is <?> the same as <? extends Object>?
Yes, for ordinary unbounded wildcard usage, both express an unknown reference type whose upper bound is Object.

Q4. Why can sum(List<?>) throw ClassCastException?
Because <?> accepts lists containing any type, but your implementation assumes every element is an Integer.

Q5. When should we use <?>?
When the operation does not need to add elements or depend on their specific 
type—for example, printing, counting, or checking whether a collection is empty.

Remember: <?> = unknown type, <? extends Number> = read as Number, <? super Integer> = add Integer safely.

*/