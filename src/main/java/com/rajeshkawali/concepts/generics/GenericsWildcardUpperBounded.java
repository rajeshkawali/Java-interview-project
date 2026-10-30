
package com.rajeshkawali.concepts.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * ==========================================================
 * UPPER BOUNDED WILDCARD - <? extends Number>
 * ==========================================================
 *
 * 1. <? extends Number> accepts Number or its subtypes.
 *
 *    Valid:
 *    List<Number>
 *    List<Integer>
 *    List<Double>
 *    List<Float>
 *    List<Long>
 *
 * 2. We CAN read elements as Number.
 *
 * 3. We CANNOT add non-null values because the
 *    actual list type might be Integer, Double, etc.
 *
 * 4. We CAN add null.
 *
 * 5. Mainly used when a collection PRODUCES values
 *    that we want to read.
 *
 * 6. PECS Rule:
 *    Producer Extends, Consumer Super.
 *
 * IMPORTANT:
 * <? extends Number> does NOT mean the list contains
 * every subtype of Number.
 *
 * It means the list has ONE specific element type
 * that is Number or a subtype of Number.
 */

public class GenericsWildcardUpperBounded {

    public static void main(String[] args) {

        // ==========================================
        // 1. INTEGER LIST
        // ==========================================

        List<Integer> ints = new ArrayList<>();

        ints.add(3);
        ints.add(5);
        ints.add(10);

        // Integer extends Number, so this is valid.
        double sum = sum(ints);

        System.out.println("Sum of ints = " + sum);
        // Output: Sum of ints = 18.0

        // ==========================================
        // 2. DIFFERENT NUMBER TYPES
        // ==========================================

        List<Double> doubles = new ArrayList<>();

        doubles.add(2.5);
        doubles.add(3.5);

        // Double extends Number.
        System.out.println(sum(doubles));
        // Output: 6.0

        List<Number> numbers = new ArrayList<>();

        numbers.add(10);   // Integer
        numbers.add(5.5);  // Double

        // Number itself is also allowed.
        System.out.println(sum(numbers));
        // Output: 15.5

        // ==========================================
        // 3. UPPER BOUNDED REFERENCE
        // ==========================================

        // Valid: Integer is a subtype of Number.
        List<? extends Number> list = ints;

        // Allowed: Every element is a Number.
        Number value = list.get(0);

        System.out.println(value);
        // Output: 3

        /*
         * INVALID:
         *
         * list.add(100);  // Compile-time error
         * list.add(3.14); // Compile-time error
         *
         * WHY?
         *
         * The actual list could be List<Integer>,
         * List<Double>, List<Float>, etc.
         *
         * Java does not know which exact subtype
         * the wildcard represents.
         *
         * Therefore, adding a Number or Integer
         * is not guaranteed to be safe.
         */

        // Allowed: null is valid for any reference type.
        // list.add(null);

        // ==========================================
        // 4. INVALID LIST TYPES
        // ==========================================

        /*
         * List<String> strings = new ArrayList<>();
         *
         * sum(strings); // Compile-time error
         *
         * String does not extend Number.
         */

        /*
         * List<Object> objects = new ArrayList<>();
         *
         * sum(objects); // Compile-time error
         *
         * Object is a superclass of Number,
         * not a subtype of Number.
         */

        // ==========================================
        // 5. IMPORTANT GENERICS RULE
        // ==========================================

        /*
         * INVALID:
         *
         * List<Number> numList = new ArrayList<Integer>();
         *
         * WHY?
         *
         * Java generics are invariant.
         *
         * Even though Integer extends Number,
         * List<Integer> does NOT extend List<Number>.
         *
         * CORRECT:
         *
         * List<? extends Number> numList =
         *         new ArrayList<Integer>();
         */
    }

    // ==============================================
    // 6. UPPER BOUNDED WILDCARD METHOD
    // ==============================================

    /*
     * List<? extends Number>
     *
     * Accepts List<Number>, List<Integer>,
     * List<Double>, List<Float>, etc.
     *
     * WHY IS THIS SAFE?
     *
     * Every non-null element is guaranteed
     * to be a Number.
     *
     * Therefore, we can:
     *
     * 1. Read each element as Number.
     * 2. Call Number methods such as doubleValue().
     *
     * We cannot safely add non-null elements.
     */
    public static double sum(List<? extends Number> list) {

        double sum = 0;

        // Reading as Number is safe.
        for (Number n : list) {
            sum += n.doubleValue();
        }

        return sum;
    }
}

/*
 * ==========================================================
 * IMPORTANT INTERVIEW QUESTIONS
 * ==========================================================
 *
 * Q1. What does <? extends Number> mean?
 * Ans: Unknown type that is Number or its subtype.
 *
 * Q2. Can List<Integer> be passed?
 * Ans: Yes, Integer extends Number.
 *
 * Q3. Can List<Object> be passed?
 * Ans: No, Object is not a subtype of Number.
 *
 * Q4. Can we read elements as Number?
 * Ans: Yes, every element is guaranteed to be Number
 *      or a subtype (unless the element is null).
 *
 * Q5. Can we add Integer or Double?
 * Ans: No, because the exact list element type
 *      is unknown.
 *
 * Q6. Can we add null?
 * Ans: Yes.
 *
 * Q7. Why use extends instead of List<Number>?
 * Ans: List<Number> does not accept List<Integer>
 *      or List<Double>, but <? extends Number> does.
 *
 * Q8. What is the PECS rule?
 * Ans: Producer Extends, Consumer Super.
 *
 * Q9. Is List<Integer> a subtype of List<Number>?
 * Ans: No. Java generics are invariant.
 *
 * Q10. When should we use <? extends Number>?
 * Ans: When we want to READ numeric values from
 *      lists of different Number subtypes.
 *
 * ==========================================================
 * QUICK COMPARISON
 * ==========================================================
 *
 * <?>                -> Read as Object; add only null.
 *
 * <? extends Number> -> Read as Number; add only null.
 *
 * <? super Integer>  -> Read as Object; add Integer.
 *
 * Remember:
 * EXTENDS = READ
 * SUPER   = WRITE
 */
