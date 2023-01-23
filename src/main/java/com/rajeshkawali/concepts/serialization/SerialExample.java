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
