
package com.rajeshkawali.concepts.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * ==========================================================
 * LOWER BOUNDED WILDCARD - <? super Integer>
 * ==========================================================
 *
 * 1. ? super Integer accepts Integer or its supertypes.
 *
 *    Valid:
 *    List<Integer>
 *    List<Number>
 *    List<Object>
 *
 * 2. We CAN add Integer values safely.
 *
 * 3. When reading, the guaranteed type is Object.
 *    We cannot directly read an element as Integer.
 *
 * 4. Used when a collection CONSUMES/ACCEPTS values.
 *
 * 5. PECS Rule:
 *    Producer Extends, Consumer Super.
 *
 * IMPORTANT:
 *
 * <? super Integer> does NOT mean that every element
 * stored in the list must be an Integer.
 *
 * A List<Number> may also contain Double or Float.
 */

public class GenericsWildcardLowerBounded {

    public static void main(String[] args) {

        // Number is a superclass of Integer.
        // Therefore, List<Number> is accepted by
        // a method expecting List<? super Integer>.
        List<Number> numbers = new ArrayList<>();

        numbers.add(3);  // int autoboxed to Integer
        numbers.add(5);
        numbers.add(10);

        /*
         * This returns 18 because the current elements
         * are all Integer objects.
         *
         * But the implementation is not safe for
         * every valid List<? super Integer>.
         */
        int sum = sum(numbers);
        System.out.println("Sum = " + sum); // 18

        // ==========================================
        // 1. VALID LOWER-BOUNDED LIST TYPES
        // ==========================================

        List<Integer> integers = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        // All three calls compile.
        addInteger(integers);
        addInteger(numberList);
        addInteger(objects);

        // ==========================================
        // 2. ADDING VALUES - ALLOWED
        // ==========================================

        List<? super Integer> list = new ArrayList<Number>();

        list.add(100);                  // Allowed: Integer
        list.add(Integer.valueOf(200)); // Allowed: Integer

        // list.add(3.14); // ERROR: Double not guaranteed safe
        // list.add(10L);  // ERROR: Long not guaranteed safe

        // null can be added to reference-type lists.
        list.add(null);

        // ==========================================
        // 3. READING VALUES - OBJECT ONLY
        // ==========================================

        Object value = list.get(0); // Allowed

        // Integer num = list.get(0); // Compile-time error
        // Number num = list.get(0);  // Compile-time error

        /*
         * WHY?
         *
         * The underlying list might be List<Object>.
         * It may contain String, Double, etc.
         *
         * Therefore, Java only guarantees Object
         * when reading from List<? super Integer>.
         */

        System.out.println("First value = " + value);
    }

    // ==============================================
    // 4. LOWER BOUND - BEST USE CASE
    // ==============================================

    /*
     * This is the correct/common use of super.
     *
     * We are ADDING Integer values to the list.
     *
     * The method accepts:
     * List<Integer>, List<Number>, List<Object>.
     */
    public static void addInteger(List<? super Integer> list) {

        list.add(10);
        list.add(20);
        list.add(30);
    }

    // ==============================================
    // 5. YOUR ORIGINAL SUM METHOD
    // ==============================================

    /*
     * This compiles, but is NOT fully type-safe.
     *
     * Reason:
     * Reading gives Object, not Integer.
     *
     * The cast may throw ClassCastException if
     * the list contains another type.
     */
    public static int sum(List<? super Integer> list) {

        int sum = 0;

        for (Object n : list) {
            sum += (Integer) n; // Unsafe cast
        }

        return sum;
    }

    // ==============================================
    // 6. BETTER SUM METHOD - UPPER BOUND
    // ==============================================

    /*
     * For reading and summing numbers, use extends.
     *
     * <? extends Number> guarantees every element
     * can be read as Number.
     *
     * Number.intValue() converts it to int.
     */
    public static int safeSum(List<? extends Number> list) {

        int sum = 0;

        for (Number n : list) {
            sum += n.intValue();
        }

        return sum;
    }
}


/*
Tricky interview Q&A:

Q1. Why can we add Integer to List<? super Integer>?
Because the underlying list is guaranteed to accept Integer values, 
whether it is List<Integer>, List<Number>, or List<Object>.

Q2. Why can't we read directly as Integer?
Because the underlying list may contain other types, so the compiler only guarantees Object.

Q3. Can we add Double to List<? super Integer>?
No. The actual list might be List<Integer>, which cannot accept a Double.

Q4. Is List<Number> a superclass of List<Integer>?
No. Java generics are invariant. However, both are compatible with List<? super Integer>.

Q5. Why is sum(List<? super Integer>) risky?
Because a List<Number> can contain Double, and casting a Double to Integer throws ClassCastException.

Remember: extends = read safely, super = add safely (PECS).

*/