package com.rajeshkawali.concepts.immutable;

/**
 * @author Rajesh_Kawali
 * 
 * @See https://javaconceptoftheday.com/example-to-prove-strings-are-immutable/
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 1. Declare your class as final, So other classes can't extend it and break its immutability
final class ImmutableEmployee {

    // 2. Make all your fields private they can't be accessed outside your class
    // 3. Mark them as final so no one can modify them anywhere else apart from the constructor, if you do not have any specific requirement to not do so
    private final int id;
    private final String name;
    private final Date dob;

    // 4. Create an constructor with argument so you can assign instantiate your object with a proper state
    public ImmutableEmployee(int id, String name, Date dob) {
        this.id = id;
        this.name = name;
        // 5. Initialise all your fields by deeply copying them if they are not immutable in nature
        this.dob = new Date(dob.getTime());
    }

    // 6. Do not provide setters for your fields, or define them private if you have some requirement
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 7. Instead of returning objects from the getters return deep copy them if your objects are not immutable
    public Date getDob() {
        return new Date(dob.getTime());
    }

    @Override
    public String toString() {
        return "ImmutableEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }

}

public class ImmutableClass1 {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
        Date dob = new SimpleDateFormat("dd-mm-yyyy").parse("10-12-1993");
        ImmutableEmployee employee = new ImmutableEmployee(1, "Naresh", dob);

        System.out.println(employee); // Prints - ImmutableEmployee{id=1, name='Naresh', dob=Sun Jan 10 00:12:00 IST 1993}

        dob.setMonth(1);
        System.out.println(dob); // Prints - Wed Feb 10 00:12:00 IST 1993

        Date temp = employee.getDob();
        temp.setMonth(2);
        System.out.println(temp); // Prints - Wed Mar 10 00:12:00 IST 1993

        System.out.println(employee.getDob()); // Prints - Sun Jan 10 00:12:00 IST 1993
        System.out.println(employee); // Prints - ImmutableEmployee{id=1, name='Naresh', dob=Sun Jan 10 00:12:00 IST 1993}
    }
}

/*
Immutable Class Rules

1. Make the class final.
2. Make fields private and final.
3. Initialize fields using constructor.
4. Don't provide setters.
5. Make defensive copies of mutable objects in constructor.
6. Return defensive copies (or unmodifiable views) in getters.
7. Immutable objects are thread-safe.
8. String is immutable, so no defensive copy is required.
*/

/*
How to Create an immutable class in Java?

1.Declare the class as final so it can't be extended.
2.Make all fields private so that direct access is not allowed.
3.Don't provide setter methods for variables.
4.Make all mutable fields final so that its value can be assigned only once.
5.Initialize all the fields via a constructor performing deep copy.
6.Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
---------------------------------------------------------
1.The class must be declared as final (So that child classes can't be created)
2.Data members in the class must be declared as private (So that direct access is not allowed)
3.Data members in the class must be declared as final (So that we can't change the value of it after object creation)
4.A parameterized constructor should initialize all the fields performing a deep copy (So that data members can�t be modified with object reference)
5.Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
6.No setters (To not have the option to change the value of the instance variable)

*/

/**
 * @author Rajesh_Kawali
 *
 */