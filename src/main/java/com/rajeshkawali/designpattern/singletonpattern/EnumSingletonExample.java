
package com.rajeshkawali.designpattern.singletonpattern;

/*
 * =====================================================
 * ENUM SINGLETON IN JAVA
 * =====================================================
 *
 * Enum Singleton ensures that only one instance
 * exists within the application.
 *
 * It is thread-safe, serialization-safe,
 * and protected against reflection-based
 * creation of additional enum instances.
 */

enum Singleton {

    INSTANCE;

    private int count = 0;

    /*
     * Enum constructor is implicitly private.
     * It is called when the enum is initialized.
     */
    Singleton() {
        System.out.println("Singleton instance created");
    }

    /* Business method. */
    public void showMessage() {
        System.out.println("Hello from Enum Singleton");
    }

    /* Synchronized method for thread-safe updates. */
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class EnumSingletonExample {
    public static void main(String[] args) {
        /* Access the same singleton instance. */
        Singleton obj1 = Singleton.INSTANCE;
        Singleton obj2 = Singleton.INSTANCE;
        obj1.showMessage();
        /* Both references point to the same instance. */
        System.out.println(obj1 == obj2);
        obj1.increment();
        obj2.increment();
        System.out.println("Count: " + obj1.getCount());
        System.out.println("Instance: " + Singleton.INSTANCE);
    }
}

/*
 * =====================================================
 * ENUM SINGLETON - IMPORTANT POINTS
 * =====================================================
 *
 * 1. Enum Singleton was popularized by Joshua Bloch
 *    in Effective Java.
 *
 * 2. Uses a single enum constant:
 *
 *    INSTANCE;
 *
 * 3. Thread-safe initialization:
 *    Java guarantees safe initialization of
 *    enum constants.
 *
 * 4. Serialization-safe:
 *    Deserialization returns the existing
 *    enum constant, not a new instance.
 *
 * 5. Reflection-safe:
 *    Java reflection cannot create additional
 *    enum instances using constructors.
 *
 * 6. No need for double-checked locking,
 *    volatile, or synchronized getInstance().
 *
 * 7. Enum constructors cannot be public
 *    or protected.
 *
 * 8. Enum cannot extend another class because
 *    it already extends java.lang.Enum.
 *
 * 9. Enum can implement interfaces.
 *
 * 10. Initialization is lazy at the class level:
 *     The instance is created when the enum
 *     class is initialized.
 *
 * 11. Thread-safe initialization does NOT make
 *     mutable fields automatically thread-safe.
 *     Shared mutable state still needs protection.
 *
 * 12. Best suited when exactly one shared instance
 *     is required and enum limitations are acceptable.
 *
 * =====================================================
 */
