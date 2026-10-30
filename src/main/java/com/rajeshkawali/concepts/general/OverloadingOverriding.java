
package com.rajeshkawali.concepts.general;

/*
 * ==========================================================
 * METHOD OVERLOADING VS METHOD OVERRIDING - INTERVIEW NOTES
 * ==========================================================
 *
 * METHOD OVERLOADING:
 *
 * 1. Same method name with different parameter lists.
 * 2. Parameters must differ in number, type, or order.
 * 3. Return type alone cannot overload a method.
 * 4. Inheritance is NOT required.
 * 5. Resolved at compile time (static polymorphism).
 * 6. Static, private and final methods can be overloaded.
 * 7. Constructors can be overloaded.
 * 8. Method selection uses compile-time argument types.
 *
 * METHOD OVERRIDING:
 *
 * 1. Child provides a new implementation of an inherited
 *    instance method.
 * 2. Requires inheritance or interface implementation.
 * 3. Method signature must match the inherited method.
 * 4. Return type must be same or covariant.
 * 5. Cannot reduce method visibility.
 * 6. Cannot override private, static or final methods.
 * 7. Cannot declare broader/new checked exceptions.
 * 8. Resolved at runtime (dynamic polymorphism).
 * 9. Actual object type determines which overridden
 *    instance method executes.
 * 10. @Override is recommended for compile-time checking.
 *
 * IMPORTANT:
 *
 * Parent1 p = new Child1();
 *
 * Reference type = Parent1
 * Actual object   = Child1
 *
 * Compiler checks accessible methods using Parent.
 * JVM executes overridden instance methods using Child.
 * Static methods are resolved using reference type.
 */

// ==========================================================
// PARENT CLASS
// ==========================================================

class Parent1 {

    // ------------------------------------------------------
    // SCENARIO 1: METHOD OVERLOADING - DIFFERENT PARAMETERS
    // ------------------------------------------------------

    /*
     * Method: methodInt(int)
     *
     * 1. Accepts one int parameter.
     * 2. Can be overloaded by changing parameter list.
     * 3. Child can override this method.
     */
    public void methodInt(int a) {
        System.out.println(
                "Parent: methodInt(int) = " + a);
    }

    /*
     * Method: methodInt(int, int)
     *
     * 1. Same method name as methodInt(int).
     * 2. Different number of parameters.
     * 3. Therefore, this is METHOD OVERLOADING.
     * 4. Different return type is allowed because
     *    the parameter list is already different.
     */
    int methodInt(int a, int b) {
        System.out.println(
                "Parent: methodInt(int,int) = " + (a + b));
        return a + b;
    }

    /*
     * Method: methodInt(double)
     *
     * 1. Same method name.
     * 2. Different parameter type (double instead of int).
     * 3. Therefore, this is also METHOD OVERLOADING.
     *
     * Example:
     * methodInt(10)   -> methodInt(int)
     * methodInt(10.5) -> methodInt(double)
     */
    public void methodInt(double a) {
        System.out.println(
                "Parent: methodInt(double) = " + a);
    }

    /*
     * INVALID OVERLOADING:
     *
     * public int methodInt(int a) {
     *     return a;
     * }
     *
     * WHY INVALID?
     *
     * Parent already has:
     * public void methodInt(int a)
     *
     * Both methods have identical signatures.
     * Changing only return type is NOT overloading.
     *
     * Compile-time error: Duplicate method.
     */

    // ------------------------------------------------------
    // SCENARIO 2: INHERITED INSTANCE METHOD
    // ------------------------------------------------------

    /*
     * Child does NOT override methodDouble(double).
     *
     * Therefore:
     *
     * Parent1 p = new Parent1();
     * p.methodDouble(5.0); -> Parent method
     *
     * Child1 c = new Child1();
     * c.methodDouble(5.0); -> Parent method
     *
     * Parent1 pc = new Child1();
     * pc.methodDouble(5.0); -> Parent method
     *
     * Reason:
     * Child inherits the Parent implementation.
     */
    void methodDouble(double a) {
        System.out.println(
                "Parent: methodDouble(double) = " + a);
    }

    // ------------------------------------------------------
    // SCENARIO 3: FINAL METHOD
    // ------------------------------------------------------

    /*
     * final prevents METHOD OVERRIDING.
     *
     * 1. Child inherits this method.
     * 2. Child cannot change its implementation.
     * 3. Child CAN overload it with different parameters.
     *
     * Important:
     * final method != final class.
     */
    final void methodFinal() {
        System.out.println("Parent: final method");
    }

    // ------------------------------------------------------
    // SCENARIO 4: PRIVATE METHOD
    // ------------------------------------------------------

    /*
     * private methods:
     *
     * 1. Are accessible only inside their declaring class.
     * 2. Are NOT inherited as overridable methods.
     * 3. Cannot be overridden.
     * 4. Child may declare a separate method with
     *    the same name and parameters.
     */
    private void methodPrivate() {
        System.out.println("Parent: private method");
    }

    /*
     * Public wrapper method.
     *
     * This method allows outside code to trigger
     * Parent's private method indirectly.
     *
     * Even if called using a Child object,
     * this implementation calls Parent.methodPrivate().
     */
    public void callParentPrivate() {
        methodPrivate();
    }

    // ------------------------------------------------------
    // SCENARIO 5: STATIC METHOD
    // ------------------------------------------------------

    /*
     * static methods belong to the class.
     *
     * 1. They are NOT overridden.
     * 2. A matching static method in Child hides this method.
     * 3. Method hiding is resolved at compile time.
     *
     * Parent.methodStatic() -> Parent method
     * Child.methodStatic()  -> Child method
     */
    static void methodStatic() {
        System.out.println("Parent: static method");
    }

    // ------------------------------------------------------
    // SCENARIO 6: COVARIANT RETURN TYPE
    // ------------------------------------------------------

    /*
     * Parent returns Number.
     *
     * Child may override this method and return
     * Integer because Integer extends Number.
     *
     * This is called COVARIANT RETURN TYPE.
     */
    public Number getValue() {
        return 100;
    }

    // ------------------------------------------------------
    // SCENARIO 7: CHECKED EXCEPTION OVERRIDING
    // ------------------------------------------------------

    /*
     * Parent declares IOException.
     *
     * Child overriding method may:
     *
     * 1. Declare the same checked exception.
     * 2. Declare a narrower checked exception.
     * 3. Declare no checked exception.
     *
     * Child cannot introduce broader checked exceptions.
     */
    public void process() throws java.io.IOException {
        System.out.println("Parent: process()");
    }

    // ------------------------------------------------------
    // SCENARIO 8: SUPER KEYWORD
    // ------------------------------------------------------

    /*
     * Child overrides this method.
     *
     * Child can use super.showMessage()
     * to explicitly call this Parent implementation.
     */
    public void showMessage() {
        System.out.println("Parent: showMessage()");
    }
}

// ==========================================================
// CHILD CLASS
// ==========================================================

class Child1 extends Parent1 {

    // ------------------------------------------------------
    // SCENARIO 1: OVERRIDE PUBLIC INSTANCE METHOD
    // ------------------------------------------------------

    /*
     * Parent:
     * public void methodInt(int a)
     *
     * Child:
     * public void methodInt(int a)
     *
     * Same name + same parameters + compatible return type.
     *
     * Therefore, METHOD OVERRIDING.
     *
     * @Override tells compiler to verify overriding.
     *
     * IMPORTANT:
     *
     * Parent1 p = new Child1();
     * p.methodInt(10);
     *
     * Output -> Child: methodInt(int) = 10
     *
     * Because actual object is Child.
     */
    @Override
    public void methodInt(int a) {
        System.out.println(
                "Child: methodInt(int) = " + a);
    }

    // ------------------------------------------------------
    // SCENARIO 2: OVERRIDE PACKAGE-PRIVATE METHOD
    // ------------------------------------------------------

    /*
     * Parent method:
     * int methodInt(int a, int b)
     *
     * Child method has same signature and return type.
     *
     * Therefore, METHOD OVERRIDING.
     *
     * Parent and Child are in the same package,
     * so the package-private method is inherited
     * and can be overridden.
     */
    @Override
    int methodInt(int a, int b) {
        System.out.println(
                "Child: methodInt(int,int) = " + (a + b));
        return a + b;
    }

    /*
     * INVALID: REDUCING ACCESS MODIFIER
     *
     * @Override
     * protected void methodInt(int a) {
     * }
     *
     * Parent method is public.
     * Child cannot change it to protected,
     * package-private, or private.
     *
     * Rule:
     * Overriding cannot reduce visibility.
     *
     * Allowed examples:
     *
     * protected -> protected or public
     * public    -> public only
     */

    // ------------------------------------------------------
    // SCENARIO 3: FINAL METHOD CANNOT BE OVERRIDDEN
    // ------------------------------------------------------

    /*
     * INVALID:
     *
     * @Override
     * void methodFinal() {
     *     System.out.println("Child final method");
     * }
     *
     * Compile-time error:
     * Cannot override final method from Parent.
     *
     * Even writing final again does NOT make it valid.
     */

    /*
     * VALID: OVERLOADING INHERITED FINAL METHOD
     *
     * Parent has:
     * methodFinal()
     *
     * Child declares:
     * methodFinal(String)
     *
     * Different parameters -> Overloading.
     *
     * final prevents overriding, not overloading.
     */
    void methodFinal(String message) {
        System.out.println(
                "Child: overloaded final method = " + message);
    }

    // ------------------------------------------------------
    // SCENARIO 4: PRIVATE METHOD IS NOT OVERRIDDEN
    // ------------------------------------------------------

    /*
     * Parent has private methodPrivate().
     *
     * Child declares its own private methodPrivate().
     *
     * These are TWO INDEPENDENT methods.
     *
     * It is NOT method overriding.
     *
     * Adding @Override here causes a compile-time error.
     */
    private void methodPrivate() {
        System.out.println("Child: private method");
    }

    /*
     * Calls Child's own private method.
     */
    public void callChildPrivate() {
        methodPrivate();
    }

    // ------------------------------------------------------
    // SCENARIO 5: STATIC METHOD HIDING
    // ------------------------------------------------------

    /*
     * Parent and Child both have methodStatic().
     *
     * This is METHOD HIDING, NOT OVERRIDING.
     *
     * Parent p = new Child();
     *
     * p.methodStatic()      -> Parent method
     * Parent.methodStatic() -> Parent method
     * Child.methodStatic()  -> Child method
     *
     * WHY?
     *
     * Static method selection uses reference type,
     * not actual object type.
     *
     * @Override cannot be used on this method.
     */
    static void methodStatic() {
        System.out.println("Child: static method");
    }

    // ------------------------------------------------------
    // SCENARIO 6: COVARIANT RETURN TYPE
    // ------------------------------------------------------

    /*
     * Parent returns Number.
     * Child returns Integer.
     *
     * Integer is a subtype of Number.
     *
     * Therefore, valid overriding.
     *
     * Parent p = new Child();
     * p.getValue(); -> Executes Child method, returns 200.
     *
     * However, compiler sees declared return type Number
     * when calling through a Parent reference.
     */
    @Override
    public Integer getValue() {
        return 200;
    }

    // ------------------------------------------------------
    // SCENARIO 7: CHECKED EXCEPTION
    // ------------------------------------------------------

    /*
     * Parent declares IOException.
     * Child declares no checked exception.
     *
     * This is valid overriding.
     *
     * INVALID:
     *
     * @Override
     * public void process() throws Exception { }
     *
     * Exception is broader than IOException.
     *
     * Note:
     * Unchecked exceptions (RuntimeException subclasses)
     * are not subject to this restriction.
     */
    @Override
    public void process() {
        System.out.println("Child: process()");
    }

    // ------------------------------------------------------
    // SCENARIO 8: CHILD-ONLY METHOD
    // ------------------------------------------------------

    /*
     * This method exists only in Child.
     *
     * Child c = new Child();
     * c.childOnly(); -> Valid
     *
     * Parent p = new Child();
     * p.childOnly(); -> Compile-time error
     *
     * WHY?
     *
     * Compiler checks method availability using
     * the declared reference type (Parent).
     *
     * Downcasting is required to access childOnly().
     */
    public void childOnly() {
        System.out.println("Child: childOnly()");
    }

    // ------------------------------------------------------
    // SCENARIO 9: CALL PARENT METHOD USING SUPER
    // ------------------------------------------------------

    /*
     * This method overrides Parent.showMessage().
     *
     * super.showMessage() explicitly calls Parent's
     * implementation.
     *
     * super is used inside an instance method or
     * constructor of a subclass.
     */
    @Override
    public void showMessage() {

        System.out.println("Child: showMessage()");

        super.showMessage();
    }
}

// ==========================================================
// MAIN CLASS - EXECUTION SCENARIOS
// ==========================================================

public class OverloadingOverriding {

    public static void main(String[] args)
            throws java.io.IOException {

        // ==================================================
        // CASE 1: PARENT REFERENCE + PARENT OBJECT
        // ==================================================

        /*
         * Reference type = Parent
         * Actual object   = Parent
         *
         * Both reference and object belong to Parent.
         *
         * Therefore, Parent implementations execute.
         */
        Parent1 p = new Parent1();

        // Exact overload methodInt(int).
        p.methodInt(5);
        // Output: Parent: methodInt(int) = 5

        // Overloaded method with two int arguments.
        p.methodInt(5, 4);
        // Output: Parent: methodInt(int,int) = 9

        // Overloaded method with double argument.
        p.methodInt(5.5);
        // Output: Parent: methodInt(double) = 5.5

        // Parent's normal instance method.
        p.methodDouble(5.0);
        // Output: Parent: methodDouble(double) = 5.0

        // Parent's final method.
        p.methodFinal();
        // Output: Parent: final method

        // Parent's public wrapper invokes private method.
        p.callParentPrivate();
        // Output: Parent: private method

        /*
         * INVALID:
         *
         * p.methodPrivate();
         *
         * Private method is not accessible from here.
         */

        // Static method called using class name.
        Parent.methodStatic();
        // Output: Parent: static method

        // Parent version of getValue().
        System.out.println(p.getValue());
        // Output: 100

        // Parent version of process().
        p.process();
        // Output: Parent: process()

        // Parent version of showMessage().
        p.showMessage();
        // Output: Parent: showMessage()

        System.out.println("-------------------------");

        // ==================================================
        // CASE 2: CHILD REFERENCE + CHILD OBJECT
        // ==================================================

        /*
         * Reference type = Child
         * Actual object   = Child
         *
         * Child reference can access:
         *
         * 1. Child's own accessible methods.
         * 2. Inherited accessible Parent methods.
         * 3. Overridden methods in Child.
         *
         * Overridden methods execute Child implementation.
         * Non-overridden methods execute Parent implementation.
         */
        Child1 c = new Child1();

        // Child overrides methodInt(int).
        c.methodInt(3);
        // Output: Child: methodInt(int) = 3

        // Child overrides methodInt(int,int).
        c.methodInt(3, 6);
        // Output: Child: methodInt(int,int) = 9

        // Child does not override methodInt(double).
        c.methodInt(7.5);
        // Output: Parent: methodInt(double) = 7.5

        // Child does not override methodDouble().
        c.methodDouble(7.0);
        // Output: Parent: methodDouble(double) = 7.0

        // Child inherits Parent's final method.
        c.methodFinal();
        // Output: Parent: final method

        // Child overloads the inherited final method.
        c.methodFinal("Hello");
        // Output: Child: overloaded final method = Hello

        /*
         * Calls Parent's public wrapper.
         *
         * The wrapper invokes Parent's private method.
         * It does NOT invoke Child's private method.
         */
        //c.callParentPrivate();
        // Output: Parent: private method

        // Calls Child's own private method via wrapper.
        c.callChildPrivate();
        // Output: Child: private method

        // Child's hidden static method.
        Child.methodStatic();
        // Output: Child: static method

        // Child's covariant return implementation.
        System.out.println(c.getValue());
        // Output: 200

        // Child overrides process().
        c.process();
        // Output: Child: process()

        // Child-only method.
        c.childOnly();
        // Output: Child: childOnly()

        // Child method then Parent method using super.
        c.showMessage();
        // Output:
        // Child: showMessage()
        // Parent: showMessage()

        System.out.println("-------------------------");

        // ==================================================
        // CASE 3: PARENT REFERENCE + CHILD OBJECT
        // ==================================================

        /*
         * MOST IMPORTANT INTERVIEW SCENARIO
         *
         * Parent pc = new Child();
         *
         * Reference type = Parent
         * Actual object   = Child
         *
         * This is UPCASTING.
         *
         * COMPILATION:
         * Compiler checks accessible methods using Parent.
         *
         * RUNTIME:
         * JVM selects Child implementation for
         * overridden instance methods.
         *
         * STATIC METHODS:
         * Selected using Parent reference type.
         */
        Parent1 pc = new Child1();

        // Overridden instance method -> Child executes.
        pc.methodInt(6);
        // Output: Child: methodInt(int) = 6

        // Overridden instance method -> Child executes.
        pc.methodInt(3, 2);
        // Output: Child: methodInt(int,int) = 5

        // Child does not override this overload.
        pc.methodInt(8.5);
        // Output: Parent: methodInt(double) = 8.5

        // Child does not override methodDouble().
        pc.methodDouble(8.0);
        // Output: Parent: methodDouble(double) = 8.0

        // final method cannot be overridden.
        pc.methodFinal();
        // Output: Parent: final method

        /*
         * INVALID:
         *
         * pc.methodFinal("Hello");
         *
         * WHY?
         *
         * Parent reference cannot see Child-only
         * methodFinal(String).
         *
         * Even though actual object is Child,
         * compiler checks Parent's available methods.
         */

        // Parent wrapper invokes Parent private method.
        pc.callParentPrivate();
        // Output: Parent: private method

        /*
         * INVALID:
         *
         * pc.callChildPrivate();
         *
         * Method exists only in Child.
         */

        // Static method called using Parent class.
        Parent.methodStatic();
        // Output: Parent: static method

        /*
         * If written:
         *
         * pc.methodStatic();
         *
         * Output: Parent: static method
         *
         * WHY?
         *
         * pc is declared as Parent.
         * Static methods are hidden, not overridden.
         *
         * Calling static methods using object references
         * is allowed but discouraged.
         */

        // Explicit Child static method.
        Child.methodStatic();
        // Output: Child: static method

        /*
         * Covariant return type.
         *
         * Child implementation executes.
         * But Parent reference sees Number return type.
         */
        Number value = pc.getValue();

        System.out.println(value);
        // Output: 200

        /*
         * INVALID without cast:
         *
         * Integer value2 = pc.getValue();
         *
         * WHY?
         *
         * Compiler sees Parent.getValue()
         * returning Number, not Integer.
         */

        // Explicit cast is valid for this implementation.
        Integer value2 = (Integer) pc.getValue();

        System.out.println(value2);
        // Output: 200

        // Runtime overriding executes Child method.
        pc.process();
        // Output: Child: process()

        /*
         * IMPORTANT:
         *
         * Even though Child.process() does not declare
         * IOException, the call through Parent reference
         * is checked against Parent.process().
         *
         * Therefore, IOException must be handled
         * or declared by this main method.
         */

        // Runtime overriding executes Child showMessage().
        pc.showMessage();
        // Output:
        // Child: showMessage()
        // Parent: showMessage()

        /*
         * INVALID:
         *
         * pc.childOnly();
         *
         * Compile-time error:
         * Method childOnly() is undefined for Parent.
         */

        // Downcasting Parent reference to Child.
        ((Child1) pc).childOnly();
        // Output: Child: childOnly()

        /*
         * Safe downcasting using instanceof.
         */
        if (pc instanceof Child1) {
            Child1 childRef = (Child1) pc;
            childRef.childOnly();
        }

        System.out.println("-------------------------");

        // ==================================================
        // CASE 4: OVERLOADING - COMPILE-TIME RESOLUTION
        // ==================================================

        /*
         * Parent has:
         *
         * methodInt(int)
         * methodInt(double)
         * methodInt(int,int)
         *
         * Compiler selects the most applicable overload
         * based on method signatures and argument types.
         */

        Parent1 overload = new Child1();

        // Argument is int -> selects methodInt(int).
        // Runtime implementation is Child.
        overload.methodInt(10);
        // Output: Child: methodInt(int) = 10

        // Argument is double -> selects methodInt(double).
        // Child does not override this signature.
        overload.methodInt(10.5);
        // Output: Parent: methodInt(double) = 10.5

        // byte widens to int.
        byte number = 5;

        overload.methodInt(number);
        // Output: Child: methodInt(int) = 5

        /*
         * IMPORTANT:
         *
         * Step 1: Compiler chooses methodInt(int).
         * Step 2: JVM chooses Child implementation.
         *
         * Overloading -> compile-time selection.
         * Overriding -> runtime implementation.
         */

        System.out.println("-------------------------");

        // ==================================================
        // CASE 5: REFERENCE TYPE VS OBJECT TYPE
        // ==================================================

        /*
         * Parent reference cannot directly access
         * Child-only methods.
         *
         * But the actual object remains Child.
         */

        Parent1 reference = new Child1();

        // Allowed: method declared in Parent.
        reference.methodInt(100);
        // Output: Child: methodInt(int) = 100

        // Invalid: method not declared in Parent.
        // reference.childOnly();

        // Valid: cast after checking actual object.
        if (reference instanceof Child1) {
            ((Child1) reference).childOnly();
        }

        /*
         * DANGEROUS DOWNCASTING:
         *
         * Parent normalParent = new Parent();
         * Child invalid = (Child) normalParent;
         *
         * This compiles but throws ClassCastException
         * at runtime because the object is not a Child.
         */

        System.out.println("-------------------------");

        // ==================================================
        // CASE 6: WIDENING VS BOXING VS VARARGS
        // ==================================================

        /*
         * Java overload resolution generally prefers:
         *
         * 1. Applicable methods without boxing/varargs
         *    (including primitive widening).
         * 2. Boxing/unboxing if needed.
         * 3. Varargs if needed.
         *
         * This is a useful interview rule, but
         * overload specificity can also matter.
         */

        OverloadRules.show(10);
        // Output: Widening: long

        OverloadRules.show(Integer.valueOf(10));
        // Output: Boxing: Integer

        OverloadRules.show(1, 2, 3);
        // Output: Varargs: int...

        System.out.println("-------------------------");

        // ==================================================
        // CASE 7: NULL OVERLOADING
        // ==================================================

        /*
         * null can be passed to reference-type parameters.
         *
         * If String and Object overloads exist,
         * String is more specific.
         */

        OverloadRules.print(null);
        // Output: String overload

        /*
         * AMBIGUOUS OVERLOADING:
         *
         * void test(String s) { }
         * void test(Integer i) { }
         *
         * test(null);
         *
         * Compile-time error: ambiguous method call.
         *
         * String and Integer are unrelated types.
         */

        System.out.println("-------------------------");

        // ==================================================
        // CASE 8: FINAL INTERVIEW REVISION
        // ==================================================

        /*
         * 1. Overloading -> Same name, different parameters.
         *
         * 2. Overriding -> Same signature, new child behavior.
         *
         * 3. Return type alone cannot overload.
         *
         * 4. final methods can be overloaded,
         *    but cannot be overridden.
         *
         * 5. private methods cannot be overridden.
         *
         * 6. static methods are hidden, not overridden.
         *
         * 7. Overriding cannot reduce visibility.
         *
         * 8. Covariant reference return types are allowed.
         *
         * 9. Overriding cannot broaden checked exceptions.
         *
         * 10. Parent p = new Child():
         *     Parent reference controls accessible methods.
         *     Child object controls overridden behavior.
         *
         * 11. super.method() invokes parent implementation.
         *
         * 12. Downcasting exposes child-specific methods,
         *     but the actual object must be compatible.
         *
         * 13. Widening is generally preferred over boxing,
         *     and varargs is considered last.
         *
         * 14. null can make overloaded calls ambiguous.
         */
    }
}

// ==========================================================
// EXTRA CLASS: OVERLOADING RULES
// ==========================================================

class OverloadRules {

    /*
     * SCENARIO: Primitive widening
     *
     * int argument can widen to long.
     */
    static void show(long value) {
        System.out.println("Widening: long");
    }

    /*
     * SCENARIO: Wrapper parameter
     *
     * Integer argument matches this overload.
     */
    static void show(Integer value) {
        System.out.println("Boxing: Integer");
    }

    /*
     * SCENARIO: Varargs
     *
     * Accepts zero or more int arguments.
     */
    static void show(int... values) {
        System.out.println("Varargs: int...");
    }

    /*
     * SCENARIO: Object vs String
     *
     * String is more specific than Object.
     */
    static void print(Object value) {
        System.out.println("Object overload");
    }

    static void print(String value) {
        System.out.println("String overload");
    }
}
