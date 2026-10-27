package com.rajeshkawali.concepts.general;

import java.util.Objects;

class Address {

    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Compare Address objects based on their values.
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Address other = (Address) obj;

        return Objects.equals(city, other.city)
                && Objects.equals(state, other.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, state);
    }
}

public class EmployeeEqualsHashCode {

    // Primitive field
    private final int id;

    // Wrapper fields
    private Integer age;
    private Double salary;

    // String field
    private String name;

    // Custom object field
    private Address address;

    public EmployeeEqualsHashCode(int id, Integer age, Double salary,
                    String name, Address address) {

        this.id = id;
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.address = address;
    }

    /*
     * Custom equals() Method
     *
     * 1. Checks whether two references point to the same object.
     * 2. Checks null and class compatibility.
     * 3. Typecasts Object into Employee.
     * 4. Compares primitive fields using ==.
     * 5. Compares wrapper, String and custom object
     *    fields using Objects.equals().
     * 6. Returns true only when all selected fields match.
     */
    @Override
    public boolean equals(Object obj) {

        // 1. Same reference means same object.
        if (this == obj) {
            return true;
        }

        // 2. Null or different class means not equal.
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 3. Typecast Object to Employee.
        EmployeeEqualsHashCode other = (EmployeeEqualsHashCode) obj;

        // 4. Compare all fields.
        return id == other.id
                && Objects.equals(age, other.age)
                && Objects.equals(salary, other.salary)
                && Objects.equals(name, other.name)
                && Objects.equals(address, other.address);
    }

    /*
     * Custom hashCode() Method - Manual Implementation
     *
     * 1. Start with an initial hash value.
     * 2. Multiply the result by 31.
     * 3. Add each field's hash code.
     * 4. Use Objects.hashCode() for null safety.
     * 5. Include the SAME fields used in equals().
     */
    @Override
    public int hashCode() {

        int result = 1;

        // Primitive int field
        result = 31 * result + Integer.hashCode(id);

        // Wrapper Integer field
        result = 31 * result + Objects.hashCode(age);

        // Wrapper Double field
        result = 31 * result + Objects.hashCode(salary);

        // String field
        result = 31 * result + Objects.hashCode(name);

        // Custom Address object
        result = 31 * result + Objects.hashCode(address);

        return result;
    }

    /*
     * Alternative hashCode() using Java utility method:
     *
     * @Override
     * public int hashCode() {
     *     return Objects.hash(id, age, salary, name, address);
     * }
     *
     * Note: Use either implementation, not both.
     */

    public static void main(String[] args) {

        EmployeeEqualsHashCode e1 = new EmployeeEqualsHashCode(
                101, 25, 50000.0, "Rahul",
                new Address("Mumbai", "MH"));

        EmployeeEqualsHashCode e2 = new EmployeeEqualsHashCode(
                101, 25, 50000.0, "Rahul",
                new Address("Mumbai", "MH"));

        EmployeeEqualsHashCode e3 = new EmployeeEqualsHashCode(
                102, 30, 60000.0, "Amit",
                new Address("Pune", "MH"));

        // Different references
        System.out.println(e1 == e2);          // false

        // Same field values
        System.out.println(e1.equals(e2));     // true

        // Different field values
        System.out.println(e1.equals(e3));     // false

        // Equal objects must have equal hash codes.
        System.out.println(
                e1.hashCode() == e2.hashCode()); // true

        // HashSet uses equals() and hashCode().
        java.util.HashSet<EmployeeEqualsHashCode> set =
                new java.util.HashSet<>();

        set.add(e1);
        set.add(e2);
        set.add(e3);

        System.out.println(set.size());        // 2
    }
}
