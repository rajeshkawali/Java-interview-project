package com.rajeshkawali.concepts.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Rajesh_Kawali
 */

/*
 * ==========================================================
 * SERIALIZATION AND DESERIALIZATION IN JAVA
 * ==========================================================
 *
 * SERIALIZATION:
 * Converting a Java object's state into a byte stream.
 *
 * DESERIALIZATION:
 * Reconstructing a Java object from a byte stream.
 *
 * WHY USE IT?
 * 1. Save an object's state to a file.
 * 2. Transfer objects between Java applications.
 * 3. Restore previously saved objects.
 *
 * IMPORTANT CLASSES:
 *
 * Serializable:
 *   Marker interface indicating a class supports
 *   Java's serialization mechanism.
 *
 * ObjectOutputStream:
 *   Converts an object's state into serialized bytes.
 *
 * ObjectInputStream:
 *   Reconstructs an object from serialized bytes.
 *
 * FileOutputStream:
 *   Writes bytes to a file.
 *
 * FileInputStream:
 *   Reads bytes from a file.
 *
 * serialVersionUID:
 *   Identifies the serialized class version.
 *
 * transient:
 *   Excludes a field from default serialization.
 *
 * NOTE:
 * Never deserialize untrusted data without
 * appropriate security controls.
 */

// ==========================================================
// 1. SERIALIZABLE CLASS
// ==========================================================

class Person implements Serializable {

    /*
     * Serializable is a marker interface.
     *
     * It does not declare methods that we must implement.
     *
     * serialVersionUID identifies the serialized
     * version of this class.
     *
     * If the stored version and current class version
     * are incompatible, deserialization can throw
     * InvalidClassException.
     *
     * This field is not part of normal object state.
     */
    private static final long serialVersionUID = 1L;

    // Normal instance field: serialized by default.
    private String name;

    // Primitive instance field: serialized by default.
    private int age;

    /*
     * transient fields are excluded from
     * default serialization.
     *
     * After deserialization, they receive default values:
     *
     * String -> null
     * int    -> 0
     * boolean -> false
     */
    private transient String password;

    /*
     * static belongs to the class, not the object.
     *
     * Static fields are NOT serialized as part
     * of an object's state.
     */
    private static String company = "ABC Company";

    // Constructor initializes a NEW Person object.
    public Person(String name, int age, String password) {

        this.name = name;         // Assign person's name.
        this.age = age;           // Assign person's age.
        this.password = password; // Assign transient field.

        System.out.println("Person constructor called");
    }

    // Getter returns the person's name.
    public String getName() {
        return name;
    }

    // Getter returns the person's age.
    public int getAge() {
        return age;
    }

    // Getter returns the transient password.
    public String getPassword() {
        return password;
    }

    // Static getter returns current class-level value.
    public static String getCompany() {
        return company;
    }

    // Static setter changes class-level value.
    public static void setCompany(String value) {
        company = value;
    }
}

// ==========================================================
// 2. SERIALIZATION / DESERIALIZATION EXAMPLE
// ==========================================================

public class SerializationExample {

    public static void main(String[] args) {

        // Name of the file where object bytes will be stored.
        String fileName = "person.ser";

        // ==================================================
        // STEP 1: CREATE JAVA OBJECT
        // ==================================================

        // Calls Person constructor and initializes fields.
        Person person = new Person("John", 30, "secret123");

        // Print original object values before serialization.
        System.out.println("Original Name: " + person.getName());
        System.out.println("Original Age: " + person.getAge());
        System.out.println("Original Password: " + person.getPassword());

        // ==================================================
        // STEP 2: SERIALIZATION (OBJECT -> BYTES -> FILE)
        // ==================================================

        /*
         * FileOutputStream:
         * Opens person.ser for writing raw bytes.
         *
         * ObjectOutputStream:
         * Wraps FileOutputStream and serializes objects.
         *
         * try-with-resources:
         * Automatically closes both streams.
         *
         * Closing ObjectOutputStream also closes
         * the wrapped FileOutputStream.
         */
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Converts the Person object state into
            // serialized bytes and writes them to the file.
            oos.writeObject(person);

            // Message appears if serialization succeeds.
            System.out.println("Serialization successful");

        } catch (IOException e) {

            // Handles file or serialization-related errors.
            e.printStackTrace();

            // Stop: there may be no valid serialized file.
            return;
        }

        // ==================================================
        // STEP 3: CHANGE CLASS-LEVEL STATIC FIELD
        // ==================================================

        /*
         * Static fields are not saved with object state.
         *
         * Changing this value demonstrates that
         * deserialization does not restore static fields.
         */
        Person.setCompany("XYZ Company");

        // ==================================================
        // STEP 4: DESERIALIZATION (FILE -> BYTES -> OBJECT)
        // ==================================================

        /*
         * FileInputStream:
         * Opens person.ser for reading raw bytes.
         *
         * ObjectInputStream:
         * Reads serialized bytes and reconstructs objects.
         *
         * readObject():
         * Returns Object, so an explicit Person cast is used.
         */
        try (FileInputStream fis =
                     new FileInputStream(fileName);

             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {

            // Reconstruct the Person object from the file.
            Person deserializedPerson =
                    (Person) ois.readObject();

            // Normal fields are restored from the file.
            System.out.println(
                    "Deserialized Name: "
                            + deserializedPerson.getName());

            System.out.println(
                    "Deserialized Age: "
                            + deserializedPerson.getAge());

            // transient password was not serialized.
            // Therefore, it becomes null.
            System.out.println(
                    "Deserialized Password: "
                            + deserializedPerson.getPassword());

            // Static field retains its current class value.
            System.out.println(
                    "Company: " + Person.getCompany());

            /*
             * readObject() creates a separate Person object.
             *
             * The original and deserialized objects
             * have different identities.
             */
            System.out.println(
                    "Same object? "
                            + (person == deserializedPerson));

            /*
             * IMPORTANT CONSTRUCTOR RULE:
             *
             * Person's constructor is NOT called
             * during ordinary Serializable deserialization.
             *
             * The first non-Serializable superclass's
             * accessible no-argument constructor is called.
             *
             * For this example, that superclass is Object.
             */

        } catch (IOException | ClassNotFoundException e) {

            /*
             * IOException:
             * File errors, invalid serialized data,
             * version mismatch, etc.
             *
             * ClassNotFoundException:
             * Required class definition is unavailable.
             */
            e.printStackTrace();
        }
    }
}

/*
 * ==========================================================
 * EXPECTED OUTPUT
 * ==========================================================
 *
 * Person constructor called
 * Original Name: John
 * Original Age: 30
 * Original Password: secret123
 * Serialization successful
 * Deserialized Name: John
 * Deserialized Age: 30
 * Deserialized Password: null
 * Company: XYZ Company
 * Same object? false
 *
 * File created:
 * person.ser
 *
 * ==========================================================
 * IMPORTANT INTERVIEW QUESTIONS
 * ==========================================================
 *
 * Q1. What is serialization?
 * Ans: Converting an object's state into a byte stream.
 *
 * Q2. What is deserialization?
 * Ans: Reconstructing an object from serialized bytes.
 *
 * Q3. Why implement Serializable?
 * Ans: To enable Java's built-in object serialization.
 *
 * Q4. Is Serializable a marker interface?
 * Ans: Yes. It has no abstract methods.
 *
 * Q5. What is serialVersionUID?
 * Ans: A class version identifier used to check
 *      serialization compatibility.
 *
 * Q6. What if serialVersionUID changes?
 * Ans: Deserialization of older data can fail
 *      with InvalidClassException.
 *
 * Q7. Are static fields serialized?
 * Ans: No. They belong to the class, not the object.
 *
 * Q8. Are transient fields serialized?
 * Ans: Not by default.
 *      They receive default values when restored.
 *
 * Q9. Is the constructor called during deserialization?
 * Ans: Not for a normal Serializable class.
 *      The first non-Serializable superclass's
 *      accessible no-argument constructor runs.
 *
 * Q10. What happens if a nested field is not Serializable?
 * Ans: Default serialization may throw
 *      NotSerializableException.
 *
 * Q11. Does private prevent serialization?
 * Ans: No. Private instance fields are serialized
 *      by default unless excluded.
 *
 * Q12. Does final prevent serialization?
 * Ans: No. Final instance fields can be serialized.
 *
 * Q13. Can one file contain multiple objects?
 * Ans: Yes. Call writeObject() multiple times
 *      and readObject() in the same order.
 *
 * Q14. What is Externalizable?
 * Ans: An interface for explicitly controlling
 *      serialized data using writeExternal()
 *      and readExternal().
 *
 * Q15. Is Java serialization safe for untrusted data?
 * Ans: No. Untrusted deserialization can be dangerous.
 *      Prefer safer formats and validate/filter input.
 *
 * ==========================================================
 * KEY POINTS
 * ==========================================================
 *
 * ObjectOutputStream.writeObject() -> Serialization
 *
 * ObjectInputStream.readObject()   -> Deserialization
 *
 * transient -> excluded from default serialization
 *
 * static -> not part of serialized instance state
 *
 * serialVersionUID -> version compatibility
 *
 * readObject() -> creates a separate object
 */

/*
In this example, the Person class implements the Serializable interface, 
which is a marker interface that indicates that an object can be serialized. 
The main() method first creates an instance of the Person class with 
the name "John" and age 30, and then serializes it to a file called "person.ser" using an ObjectOutputStream.

To deserialize the object, the main method creates a new ObjectInputStream 
and reads an object from the "person.ser" file, then cast the Object to Person 
and prints out the name and age of the deserialized Person object.
*/