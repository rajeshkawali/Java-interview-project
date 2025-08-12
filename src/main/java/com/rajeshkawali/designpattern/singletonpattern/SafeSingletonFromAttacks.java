package com.rajeshkawali.designpattern.singletonpattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author Rajesh_Kawali
 *
 */

/**
 * SafeSingleton class
 *
 * Implements Singleton Pattern with:
 *  - Double-Checked Locking (Thread Safety)
 *  - Protection from Reflection
 *  - Protection from Serialization
 *  - Protection from Cloning
 */
public final class SafeSingletonFromAttacks implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	// Volatile ensures visibility of changes across threads
    private static volatile SafeSingletonFromAttacks instance = null;

    // Flag to prevent reflection-based attacks
    private static boolean instanceCreated = false;

    /**
     * Private constructor to prevent object creation from outside.
     * Throws RuntimeException if instance is already created — stops Reflection attacks.
     */
    private SafeSingletonFromAttacks() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance() method to create singleton");
        }
        instanceCreated = true;
    }

    /**
     * Public method to provide global access to the singleton instance.
     * Uses Double-Checked Locking to ensure:
     *  - Thread safety
     *  - High performance (synchronization happens only on first call)
     */
    public static SafeSingletonFromAttacks getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (SafeSingletonFromAttacks.class) { // Lock only when needed
                if (instance == null) { // Second check (with locking)
                    instance = new SafeSingletonFromAttacks();
                }
            }
        }
        return instance;
    }

    /**
     * readResolve() is called during deserialization.
     * This method ensures that the same singleton instance is returned,
     * instead of creating a new one.
     */
    protected Object readResolve() {
        return getInstance();
    }

    /**
     * clone() method is overridden to prevent cloning.
     * If cloning is attempted, it throws CloneNotSupportedException.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning is not supported for singleton");
    }

    
    // Test the singleton against various attacks
    public static void main(String[] args) throws Exception {
        System.out.println("----- Normal Access -----");
        SafeSingletonFromAttacks instance1 = SafeSingletonFromAttacks.getInstance();
        System.out.println("Instance1 hash: " + instance1.hashCode());

        System.out.println("\n----- Reflection Attack -----");
        try {
            Constructor<SafeSingletonFromAttacks> constructor = SafeSingletonFromAttacks.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SafeSingletonFromAttacks reflectionInstance = constructor.newInstance(); // Should fail
            System.out.println("Reflection instance hash: " + reflectionInstance.hashCode());
        } catch (Exception e) {
            System.out.println("Reflection attack failed: " + e.getMessage());
        }

        System.out.println("\n----- Serialization Attack -----");
        try {
            // Serialize to a file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            out.writeObject(instance1);
            out.close();

            // Deserialize from the file
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
            SafeSingletonFromAttacks instance2 = (SafeSingletonFromAttacks) in.readObject();
            in.close();

            System.out.println("Deserialized instance hash: " + instance2.hashCode());
        } catch (Exception e) {
            System.out.println("Serialization attack failed: " + e.getMessage());
        }

        System.out.println("\n----- Cloning Attack -----");
        try {
            SafeSingletonFromAttacks clonedInstance = (SafeSingletonFromAttacks) instance1.clone(); // Should fail
            System.out.println("Cloned instance hash: " + clonedInstance.hashCode());
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning attack failed: " + e.getMessage());
        }

        // Cleanup: delete the serialized file
        new File("singleton.ser").delete();
    }
}

/**
 * Protections Explained:
 *
 * This Singleton class is designed to be safe from common attacks and threading issues.
 * Below is how each potential problem is mitigated:
 *
 * -----------------------------------------------------------------------------------------------------
 * Attack Type      | How It's Prevented
 * -----------------|-----------------------------------------------------------------------------------
 * Reflection       | An internal static flag (instanceCreated) is used in the private constructor.
 *                  | If an attempt is made to create a second instance using reflection, 
 *                  | it throws a RuntimeException to block the attack.
 *
 * Serialization    | Normally, deserialization creates a new object instance.
 *                  | By implementing the readResolve() method, we ensure that deserialization 
 *                  | returns the same singleton instance instead of creating a new one.
 *
 * Cloning          | The clone() method is overridden to throw CloneNotSupportedException.
 *                  | This prevents duplication of the singleton instance via the Object.clone() method.
 *
 * Thread Safety    | The instance is declared 'volatile' to ensure visibility across threads.
 *                  | The getInstance() method uses Double-Checked Locking to ensure that 
 *                  | only one thread creates the instance, making it efficient and thread-safe.
 *
 * ----------------------------------------------------------------------------------------------------
 */
