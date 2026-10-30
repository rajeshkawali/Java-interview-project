
package com.rajeshkawali.concepts.serialization;

import java.io.*;

/*
 * =========================================================
 * EXTERNALIZABLE IN JAVA
 * =========================================================
 *
 * Externalizable extends Serializable.
 *
 * It gives full control over which fields are saved
 * and how they are restored.
 *
 * Two methods must be implemented:
 *
 * writeExternal() -> Manually writes object data.
 * readExternal()  -> Manually restores object data.
 *
 * IMPORTANT:
 * 1. Public no-argument constructor is required.
 * 2. Write and read fields in the same order.
 * 3. Fields are not serialized automatically.
 * 4. Even transient fields can be written manually.
 */

class Employee implements Externalizable {

    private static final long serialVersionUID = 1L;

    private int id;              // We will save this.
    private String name;         // We will save this.
    private String department;   // We will NOT save this.
    private transient String password; // Also NOT saved.

    /*
     * MANDATORY PUBLIC NO-ARG CONSTRUCTOR
     *
     * During deserialization, Java creates the object
     * using this constructor BEFORE readExternal().
     *
     * Without this constructor, deserialization fails.
     */
    public Employee() {
        System.out.println("1. No-arg constructor called");
    }

    // Used to create the original Employee object.
    public Employee(int id, String name,
                    String department, String password) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.password = password;
    }

    /*
     * SERIALIZATION
     *
     * Called automatically when:
     * oos.writeObject(employee);
     *
     * Only fields written here are saved.
     */
    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {

        System.out.println("2. writeExternal() called");

        out.writeInt(id);      // Save id.
        out.writeUTF(name);    // Save name.

        // department is skipped even though not transient.
        // password is skipped intentionally.

        /*
         * IMPORTANT:
         * transient does not stop us from manually
         * writing a field with Externalizable.
         *
         * For example:
         * out.writeUTF(password);
         *
         * But do not serialize passwords in plain text.
         */
    }

    /*
     * DESERIALIZATION
     *
     * Called automatically when:
     * ois.readObject();
     *
     * Java first calls the public no-arg constructor.
     * Then readExternal() restores the saved fields.
     */
    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {

        System.out.println("3. readExternal() called");

        id = in.readInt();      // Read id first.
        name = in.readUTF();    // Read name second.

        // department was not saved -> null.
        // password was not saved   -> null.

        /*
         * Read order MUST match write order.
         *
         * Wrong:
         * name = in.readUTF();
         * id = in.readInt();
         *
         * This would interpret the bytes incorrectly.
         */
    }

    @Override
    public String toString() {

        return "Employee{id=" + id
                + ", name='" + name + "'"
                + ", department=" + department
                + ", password=" + password + "}";
    }
}

public class ExternalizableExample {

    public static void main(String[] args) {

        // Create object using parameterized constructor.
        Employee employee = new Employee(
                101, "John", "IT", "secret123");

        System.out.println("Original: " + employee);

        // =================================================
        // 1. SERIALIZATION
        // =================================================

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream("employee.ser"))) {

            // Internally invokes writeExternal().
            oos.writeObject(employee);

            System.out.println("Serialization successful");

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // =================================================
        // 2. DESERIALIZATION
        // =================================================

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream("employee.ser"))) {

            /*
             * Internally:
             *
             * Step 1: Calls Employee() constructor.
             * Step 2: Calls readExternal().
             * Step 3: Returns reconstructed Employee.
             */
            Employee restored =
                    (Employee) ois.readObject();

            System.out.println("Restored: " + restored);

            // Deserialization creates a separate object.
            System.out.println(
                    "Same object? " + (employee == restored));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
 * =========================================================
 * EXPECTED OUTPUT
 * =========================================================
 *
 * Original: Employee{id=101, name='John',
 * department=IT, password=secret123}
 *
 * 2. writeExternal() called
 * Serialization successful
 *
 * 1. No-arg constructor called
 * 3. readExternal() called
 *
 * Restored: Employee{id=101, name='John',
 * department=null, password=null}
 *
 * Same object? false
 *
 * =========================================================
 */
