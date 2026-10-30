
package com.rajeshkawali.concepts.general;

/*
 ============================================================
 METHOD OVERLOADING WITH PRIMITIVES, WRAPPERS AND VARARGS
 ============================================================

 Method Overloading:

 1. Same method name with different parameter lists.
 2. Different parameter types create valid overloads.
 3. Overloading is resolved at COMPILE TIME.
 4. Compiler uses declared argument types, not
    the runtime classes of objects.
 5. Return type alone cannot overload a method.

 ============================================================
 JAVA METHOD OVERLOADING RESOLUTION - THREE PHASES
 ============================================================

 PHASE 1: STRICT INVOCATION

 - Exact type match.
 - Primitive widening.
 - Reference widening.
 - No boxing or unboxing.
 - No variable-arity invocation.

 Examples:

 byte -> short -> int -> long -> float -> double

 int -> long
 int -> float
 int -> double

 Integer -> Number
 Integer -> Object

 PHASE 2: LOOSE INVOCATION

 Used only if Phase 1 finds no applicable method.

 - Allows boxing and unboxing.
 - Also allows widening after boxing/unboxing
   where permitted.

 Examples:

 int -> Integer           (Boxing)
 int -> Integer -> Number (Boxing + reference widening)

 Integer -> int           (Unboxing)
 Integer -> int -> long   (Unboxing + primitive widening)

 IMPORTANT:

 byte -> Byte -> Number is allowed.
 byte -> Short is NOT allowed.
 int -> Long is NOT allowed.

 PHASE 3: VARIABLE-ARITY INVOCATION

 Used only if Phases 1 and 2 find no applicable method.

 Example:

 method(String... values)

 A varargs method can also participate in Phase 1
 or Phase 2 when called with a matching array.

 ============================================================
 MOST IMPORTANT INTERVIEW RULE
 ============================================================

 1. Find applicable methods in Phase 1.
 2. If any exist, choose the most specific applicable method.
 3. Otherwise, try Phase 2.
 4. Otherwise, try Phase 3.
 5. If no unique most-specific method exists,
    compilation fails due to ambiguity.

 The compiler does not simply choose the first
 overloaded method written in the class.
*/

/**
 * @author Rajesh_Kawali
 *
 */
public class OverloadingWithTypes {

    // ========================================================
    // 1. PRIMITIVE TYPE OVERLOADING
    // ========================================================

    /*
     * Accepts primitive byte.
     *
     * Example:
     * method((byte) 10)
     *
     * Exact match -> method(byte).
     *
     * Although byte can widen to short, int, long,
     * float and double, byte is the most specific
     * applicable primitive overload.
     */
    public void method(byte b) {
        System.out.println("byte: " + b);
    }

    /*
     * Accepts primitive short.
     *
     * Example:
     * method((short) 100)
     *
     * Exact match -> method(short).
     *
     * short can widen to int, long, float and double.
     * But method(short) is more specific.
     */
    public void method(short s) {
        System.out.println("short: " + s);
    }

    /*
     * Accepts primitive int.
     *
     * Example:
     * method(1000)
     *
     * Integer literals without suffix are int by default
     * when their values fit in int.
     *
     * Exact match -> method(int).
     *
     * IMPORTANT:
     * Java does not automatically select method(byte)
     * for method(10), even though 10 fits in a byte.
     *
     * Method invocation does not generally allow
     * narrowing int to byte.
     */
    public void method(int i) {
        System.out.println("int: " + i);
    }

    /*
     * Accepts primitive long.
     *
     * Example:
     * method(10000L)
     *
     * L suffix makes the literal long.
     *
     * Exact match -> method(long).
     *
     * int can also widen to long if needed.
     */
    public void method(long l) {
        System.out.println("long: " + l);
    }

    /*
     * Accepts primitive float.
     *
     * Example:
     * method(3.14f)
     *
     * f suffix makes the literal float.
     *
     * Exact match -> method(float).
     *
     * Without f, 3.14 is double.
     */
    public void method(float f) {
        System.out.println("float: " + f);
    }

    /*
     * Accepts primitive double.
     *
     * Example:
     * method(3.14)
     *
     * Decimal literals are double by default.
     *
     * Exact match -> method(double).
     */
    public void method(double d) {
        System.out.println("double: " + d);
    }

    // ========================================================
    // 2. WRAPPER CLASS OVERLOADING
    // ========================================================

    /*
     * Accepts Byte wrapper object.
     *
     * Example:
     * method(Byte.valueOf((byte) 10))
     *
     * Exact reference match -> method(Byte).
     *
     * Byte also extends Number and Object.
     * But method(Byte) is more specific.
     *
     * Note:
     * Byte is an object; byte is primitive.
     */
    public void method(Byte b) {
        System.out.println("Byte: " + b);
    }

    /*
     * Accepts Short wrapper object.
     *
     * Example:
     * method(Short.valueOf((short) 100))
     *
     * Exact match -> method(Short).
     */
    public void method(Short s) {
        System.out.println("Short: " + s);
    }

    /*
     * Accepts Integer wrapper object.
     *
     * Example:
     * method(Integer.valueOf(1000))
     *
     * Exact match -> method(Integer).
     *
     * Integer extends Number, which extends Object.
     *
     * Since Integer is more specific than Number
     * and Object, method(Integer) is selected.
     */
    public void method(Integer i) {
        System.out.println("Integer: " + i);
    }

    /*
     * Accepts Long wrapper object.
     *
     * Example:
     * method(Long.valueOf(10000L))
     *
     * Exact match -> method(Long).
     */
    public void method(Long l) {
        System.out.println("Long: " + l);
    }

    /*
     * Accepts Float wrapper object.
     *
     * Example:
     * method(Float.valueOf(3.14f))
     *
     * Exact match -> method(Float).
     */
    public void method(Float f) {
        System.out.println("Float: " + f);
    }

    /*
     * Accepts Double wrapper object.
     *
     * Example:
     * method(Double.valueOf(3.14))
     *
     * Exact match -> method(Double).
     */
    public void method(Double d) {
        System.out.println("Double: " + d);
    }

    // ========================================================
    // 3. PARENT REFERENCE TYPE OVERLOADING
    // ========================================================

    /*
     * Number is the superclass of numeric wrappers:
     *
     * Byte, Short, Integer, Long, Float, Double.
     *
     * Example:
     *
     * Number n = Integer.valueOf(100);
     * method(n);
     *
     * Output: Number: 100
     *
     * WHY NOT method(Integer)?
     *
     * Because the declared type of n is Number.
     *
     * Compiler resolves overloads using the
     * reference type, not the runtime object type.
     *
     * An implicit downcast Number -> Integer
     * is not permitted.
     */
    public void method(Number n) {
        System.out.println("Number: " + n);
    }

    /*
     * Object is the superclass of all Java classes.
     *
     * Example:
     *
     * Object o = Integer.valueOf(100);
     * method(o);
     *
     * Output: Object: 100
     *
     * WHY?
     *
     * The declared reference type is Object.
     * Compiler cannot automatically choose
     * method(Integer) or method(Number).
     *
     * Object is not a superclass of primitives,
     * but primitives may be boxed into wrapper objects.
     */
    public void method(Object o) {
        System.out.println("Object: " + o);
    }

    // ========================================================
    // 4. VARARGS OVERLOADING
    // ========================================================

    /*
     * String... is a variable-length argument parameter.
     *
     * Internally, String... is represented as String[].
     *
     * Examples:
     *
     * method("Hello", "World");
     * method("Java");
     * method();
     *
     * All three calls can use this varargs overload,
     * but see the ambiguity warning below.
     *
     * IMPORTANT:
     *
     * Varargs is generally considered after
     * fixed-arity applicability.
     *
     * A varargs method can also be called with
     * a String[] as a fixed-arity invocation.
     */
    public void method(String... args) {
        System.out.println(
                "Varargs: " + String.join(", ", args));
    }

    // ========================================================
    // 5. MAIN METHOD - COMPLETE TEST CASES
    // ========================================================

    public static void main(String[] args) {

        OverloadingWithTypes obj =
                new OverloadingWithTypes();

        System.out.println("=== PRIMITIVE EXACT MATCH ===");

        /*
         * CASE 1: BYTE
         *
         * (byte) 10 explicitly converts int literal to byte.
         *
         * Applicable primitive overloads include:
         * byte, short, int, long, float, double.
         *
         * method(byte) is most specific.
         */
        obj.method((byte) 10);
        // Output: byte: 10

        /*
         * CASE 2: SHORT
         *
         * (short) 100 explicitly converts int to short.
         *
         * method(short) is more specific than
         * method(int), method(long), etc.
         */
        obj.method((short) 100);
        // Output: short: 100

        /*
         * CASE 3: INT
         *
         * 1000 is an int literal.
         *
         * Exact match -> method(int).
         *
         * No automatic narrowing to byte or short.
         */
        obj.method(1000);
        // Output: int: 1000

        /*
         * CASE 4: LONG
         *
         * L suffix makes the literal long.
         *
         * Exact match -> method(long).
         */
        obj.method(10000L);
        // Output: long: 10000

        /*
         * CASE 5: FLOAT
         *
         * f suffix makes the literal float.
         *
         * Exact match -> method(float).
         */
        obj.method(3.14f);
        // Output: float: 3.14

        /*
         * CASE 6: DOUBLE
         *
         * Decimal literal without f is double.
         *
         * Exact match -> method(double).
         */
        obj.method(3.14);
        // Output: double: 3.14

        System.out.println("=== WRAPPER EXACT MATCH ===");

        /*
         * CASE 7: BYTE WRAPPER
         *
         * Byte.valueOf() returns Byte object.
         *
         * method(Byte) is selected instead of
         * method(Number) or method(Object).
         */
        obj.method(Byte.valueOf((byte) 10));
        // Output: Byte: 10

        /*
         * CASE 8: SHORT WRAPPER
         */
        obj.method(Short.valueOf((short) 100));
        // Output: Short: 100

        /*
         * CASE 9: INTEGER WRAPPER
         *
         * Integer.valueOf() is preferred over
         * deprecated Integer constructors.
         */
        obj.method(Integer.valueOf(1000));
        // Output: Integer: 1000

        /*
         * CASE 10: LONG WRAPPER
         */
        obj.method(Long.valueOf(10000L));
        // Output: Long: 10000

        /*
         * CASE 11: FLOAT WRAPPER
         */
        obj.method(Float.valueOf(3.14f));
        // Output: Float: 3.14

        /*
         * CASE 12: DOUBLE WRAPPER
         */
        obj.method(Double.valueOf(3.14));
        // Output: Double: 3.14

        System.out.println("=== REFERENCE TYPE ===");

        /*
         * CASE 13: NUMBER REFERENCE
         *
         * Declared type = Number.
         * Runtime object = Integer.
         *
         * Compiler selects method(Number).
         *
         * It does NOT select method(Integer)
         * based on runtime object type.
         */
        Number number = Integer.valueOf(500);

        obj.method(number);
        // Output: Number: 500

        /*
         * CASE 14: OBJECT REFERENCE
         *
         * Declared type = Object.
         * Runtime object = Integer.
         *
         * Compiler selects method(Object).
         */
        Object object = Integer.valueOf(600);

        obj.method(object);
        // Output: Object: 600

        /*
         * CASE 15: DIRECT OBJECT
         *
         * new Object() has type Object.
         *
         * Exact match -> method(Object).
         */
        obj.method(new Object());
        // Output: Object: java.lang.Object@...
        // The identity-style suffix varies by run.

        System.out.println("=== VARARGS ===");

        /*
         * CASE 16: MULTIPLE STRING ARGUMENTS
         *
         * No fixed-arity method accepts two Strings.
         *
         * Compiler uses method(String...).
         */
        obj.method("Hello", "World");
        // Output: Varargs: Hello, World

        /*
         * CASE 17: SINGLE STRING
         *
         * method(String...) accepts one String
         * using variable-arity invocation.
         *
         * method(Object) is also applicable by
         * reference widening in Phase 1.
         *
         * IMPORTANT:
         * Phase 1 wins before Phase 3 is considered.
         *
         * Therefore method(Object) is selected!
         */
        obj.method("Java");
        // Output: Object: Java

        /*
         * CASE 18: STRING ARRAY
         *
         * String[] exactly matches the array parameter
         * of method(String...).
         *
         * It is applicable as a fixed-arity call.
         *
         * method(String[]) is more specific than
         * method(Object).
         */
        obj.method(new String[]{"A", "B"});
        // Output: Varargs: A, B

        /*
         * CASE 19: ZERO ARGUMENTS
         *
         * Only method(String...) can accept zero
         * arguments in this class.
         */
        obj.method();
        // Output: Varargs:

        System.out.println("=== TRICKY SCENARIOS ===");

        /*
         * CASE 20: INTEGER LITERAL
         *
         * Even though 10 fits in byte and short,
         * an int literal is treated as int here.
         *
         * method(int) is selected.
         */
        obj.method(10);
        // Output: int: 10

        /*
         * CASE 21: CHAR ARGUMENT
         *
         * No method(char) exists.
         *
         * char can widen to:
         * int -> long -> float -> double.
         *
         * method(int) is the most specific applicable.
         */
        obj.method('A');
        // Output: int: 65

        /*
         * CASE 22: BOOLEAN ARGUMENT
         *
         * No method(boolean) exists.
         *
         * boolean cannot widen to numeric primitives.
         *
         * It can box to Boolean, then widen to Object.
         *
         * Therefore method(Object) is selected.
         */
        obj.method(true);
        // Output: Object: true

        /*
         * CASE 23: NULL ARGUMENT - AMBIGUOUS
         *
         * obj.method(null);
         *
         * COMPILE-TIME ERROR!
         *
         * Why?
         *
         * Several reference overloads accept null:
         *
         * Byte, Short, Integer, Long, Float, Double,
         * Number, Object, String[].
         *
         * No unique most-specific overload exists.
         *
         * Explicit casting resolves the ambiguity.
         */
        obj.method((Integer) null);
        // Output: Integer: null

        obj.method((Number) null);
        // Output: Number: null

        obj.method((Object) null);
        // Output: Object: null

        /*
         * CASE 24: NULL STRING ARRAY
         *
         * Explicit cast selects method(String...).
         *
         * But the method body calls String.join()
         * with a null array, causing NPE.
         *
         * Uncomment to observe:
         *
         * obj.method((String[]) null);
         *
         * Runtime: NullPointerException.
         */

        /*
         * CASE 25: WRAPPER VS PRIMITIVE
         *
         * Integer reference selects method(Integer).
         *
         * Primitive int selects method(int).
         */
        Integer wrapper = 100;
        int primitive = 100;

        obj.method(wrapper);
        // Output: Integer: 100

        obj.method(primitive);
        // Output: int: 100

        /*
         * CASE 26: EXPLICIT CAST CHANGES OVERLOAD
         *
         * Casting changes the compile-time type
         * of the argument expression.
         */
        obj.method((double) 100);
        // Output: double: 100.0

        obj.method((long) 100);
        // Output: long: 100

        obj.method((short) 100);
        // Output: short: 100

        System.out.println("=== COMPLETED ===");
    }
}

/*
 * ============================================================
 * IMPORTANT INTERVIEW Q&A
 * ============================================================
 *
 * Q1. Is overloading compile-time or runtime polymorphism?
 * Ans: Compile-time polymorphism.
 *
 * Q2. Can return type alone overload a method?
 * Ans: No. Parameter lists must differ.
 *
 * Q3. Does Java always prefer primitive over wrapper?
 * Ans: No. It depends on argument type and overload
 *      applicability. Exact Integer selects Integer.
 *
 * Q4. Why does method(10) call method(int)?
 * Ans: 10 is an int literal, and method(int) matches.
 *
 * Q5. Why does method('A') call method(int)?
 * Ans: char widens to int, and no char overload exists.
 *
 * Q6. Why does method(true) call method(Object)?
 * Ans: boolean boxes to Boolean, which widens to Object.
 *
 * Q7. Why does method("Java") call method(Object)?
 * Ans: Reference widening to Object is applicable in
 *      Phase 1. Varargs expansion is considered later.
 *
 * Q8. Why does method(new String[]{"A","B"})
 *     call method(String...)?
 * Ans: String... is String[] internally. It is an exact
 *      array match during fixed-arity resolution.
 *
 * Q9. Why is method(null) ambiguous?
 * Ans: Multiple unrelated reference overloads match
 *      and no unique most-specific method exists.
 *
 * Q10. Does Java choose overloads by runtime object type?
 * Ans: No. It uses compile-time argument types.
 *
 * Q11. Can byte widen to short?
 * Ans: Yes.
 *
 * Q12. Can byte box to Short?
 * Ans: No. Boxing byte produces Byte, not Short.
 *
 * Q13. Can int box to Integer and widen to Number?
 * Ans: Yes.
 *
 * Q14. Can int widen to long and then box to Long?
 * Ans: Not as a method-invocation conversion.
 *
 * Q15. Can a varargs method accept zero arguments?
 * Ans: Yes.
 *
 * Q16. Can varargs be selected in Phase 1?
 * Ans: Yes, when called as a fixed-arity array method.
 *
 * Q17. Which is preferred: widening or boxing?
 * Ans: Primitive widening is considered in Phase 1,
 *      while boxing is considered in Phase 2.
 *
 * Q18. Can overloading become ambiguous?
 * Ans: Yes, when no unique most-specific applicable
 *      method exists.
 *
 * Q19. Does the order of method declarations matter?
 * Ans: No.
 *
 * Q20. Can private, static and final methods be overloaded?
 * Ans: Yes.
 *
 * ============================================================
 * FINAL INTERVIEW SUMMARY
 * ============================================================
 *
 * Java overload resolution:
 *
 * Phase 1 -> Strict invocation (no boxing, no varargs expansion)
 * Phase 2 -> Loose invocation (boxing/unboxing allowed)
 * Phase 3 -> Variable-arity invocation
 *
 * Select the most specific applicable method in the
 * first phase that contains applicable methods.
 *
 * If no unique most-specific method exists:
 * Compile-time error.
 *
 * Most important:
 *
 * Overloading depends on COMPILE-TIME argument types,
 * not runtime object types.
 */
