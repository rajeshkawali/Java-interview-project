package com.rajeshkawali.concepts.serialization;

import java.io.*;

/*
Serialization: The mechanism for converting an object's state into a stream of bytes in order to 
store or transmit the object to network, memory, a database, or a file.

Deserialization: It is the process of converting a stream of bytes to the original state of the object 

1.Transient variable will be ignored during serialization.
2.Static variable won't even participate in Serialization.
3.Static variable will be serialized if the value is initialized during declaration itself.
4.If a variable contains both transient and static keyword, also if the value is initialized during declaration, then it will be serialized. Because here transient modifier will be ignored and static modifier will take over the actions.
5.Final variable will be serialized.
6.If a variable contains both final and transient keyword, then it will not be serialized.
7.If a parent class has implemented Serializable interface then child class doesn't need to implement it but vice-versa is not true.
8.Constructor of object is never called when an object is deserialized.
9.Static Variables: These variables are not serialized, So during deserialization static variable value will loaded from the class.(Current value will be loaded.)
*/

/**
 * @author Rajesh_Kawali
 *
 */
class parent  implements Serializable{

	private static final long serialVersionUID = 1L;
	String surename = "Kawali";
}

class Emp extends parent  {

	private static final long serialVersionUID = 1L;
	
	static long phone;
	transient final int year; // Not serializing
	transient static String email;
	transient float percentage; // Not serializing
	String name;
	final int age;

	// Default constructor
	//public Emp() {}  //Error - The blank final field year may not have been initialized
	
	// Parameterized constructor
	@SuppressWarnings("static-access")
	public Emp(String name, int age, float percentage, long phone, int year, String email) {
		this.name = name;
		this.age = age;
		this.percentage = percentage;
		this.phone = phone;
		this.year = year;
		this.email = email;
	}
}

public class SerialExample {

	@SuppressWarnings("static-access")
	public static void printdata(Emp obj) {
		System.out.println("name = " + obj.name);
		System.out.println("age = " + obj.age);
		System.out.println("percentage = " + obj.percentage);
		System.out.println("phone = " + obj.phone);
		System.out.println("year = " + obj.year);
		System.out.println("email = " + obj.email);
		System.out.println("surename = " + obj.surename);
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Emp object = new Emp("Laksh", 12, 98.5f, 9988776655L, 2021, "laksh@gmail.com");
		String filename = "Rajesh.txt";
		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(object);
			out.close();
			file.close();
			System.out.println("Object has been serialized\n" + "Data before Deserialization.");
			printdata(object);

			// value of static variable changed even though it is serializing
			object.phone = 2000;
		}
		catch (IOException ex) {
			System.out.println("IOException is caught");
		}
		object = null;
		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object = (Emp) in.readObject();

			in.close();
			file.close();
			System.out.println("\nObject has been deserialized\n" + "Data after Deserialization.");
			printdata(object);
		}
		catch (IOException ex) {
			System.out.println("IOException is caught");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
	}
}

/*
Object has been serialized
Data before Deserialization.
name = Laksh
age = 12
percentage = 98.5
phone = 9988776655
year = 2021
email = laksh@gmail.com

Object has been deserialized
Data after Deserialization.
name = Laksh
age = 12
percentage = 0.0
phone = 2000
year = 0
email = laksh@gmail.com

*/





/*
 ==========================================================
 SERIALIZATION AND DESERIALIZATION IN JAVA
 ==========================================================

 SERIALIZATION:
 The process of converting a Java object's state into
 a byte stream so it can be stored in a file, memory,
 database, or transmitted over a network.

 DESERIALIZATION:
 The process of reconstructing a Java object from
 a previously serialized byte stream.

 IMPORTANT RULES:

 1. TRANSIENT VARIABLE
    A transient instance variable is not serialized
    by Java's default serialization mechanism.

    After deserialization, it gets its default value:
    int = 0, boolean = false, Object = null.

 2. STATIC VARIABLE
    Static variables are NOT serialized because
    they belong to the class, not the object.

 3. STATIC VARIABLE INITIALIZED AT DECLARATION
    Even if a static variable is initialized during
    declaration, it is NOT serialized.

    Example:
    static int count = 100;

    During deserialization, the current class-level
    value is used, not a value from the byte stream.

 4. STATIC + TRANSIENT VARIABLE
    Static variables are never part of the serialized
    object's state, whether transient is present or not.

    Example:
    static transient int count = 100;

    This variable is NOT serialized.

 5. FINAL VARIABLE
    A final instance variable is serialized by default
    because final does not exclude it from serialization.

 6. FINAL + TRANSIENT VARIABLE
    A transient final instance variable is not serialized
    by default.

    NOTE:
    A compile-time constant may appear to retain its
    declared value after deserialization because the
    compiler can inline that constant.

 7. PARENT AND CHILD CLASS
    If a parent implements Serializable, its child
    automatically becomes Serializable.

    But if only the child implements Serializable,
    the parent does NOT become Serializable.

    The parent's non-serializable state is not
    automatically saved.

 8. CONSTRUCTOR DURING DESERIALIZATION
    The constructor of a normal Serializable class
    is NOT called during deserialization.

    However, the accessible no-argument constructor
    of the first non-Serializable superclass is called.

 9. STATIC VARIABLE AFTER DESERIALIZATION
    Static variables retain their current class-level
    values because they are not stored in the
    serialized object.

 10. SERIALIZABLE INTERFACE
     Serializable is a marker interface.
     It does not contain methods to implement.

 11. serialVersionUID
     Used to identify the serialized class version
     and check compatibility during deserialization.

 12. NotSerializableException
     Can occur if an object being serialized contains
     a required non-Serializable object reference.

 13. PRIVATE VARIABLES
     Private instance variables are also serialized
     by default unless they are transient or excluded
     through a custom serialization mechanism.

 14. OBJECT IDENTITY
     Deserialization normally creates a new object.

     original == deserialized  // Usually false

 15. SECURITY
     Avoid deserializing untrusted data.
     Java deserialization can create security risks.

 ==========================================================
 QUICK INTERVIEW REVISION
 ==========================================================

 transient       -> Not serialized by default.
 static          -> Not serialized.
 static transient-> Not serialized.
 final           -> Serialized by default.
 final transient -> Not serialized by default.
 private         -> Serialized by default.

 Parent Serializable -> Child Serializable.

 Child Serializable  -> Parent not necessarily Serializable.

 Serializable constructor -> Not called during normal
                             deserialization.

 Non-Serializable superclass constructor ->
                             Called as explained above.

 ==========================================================
*/
