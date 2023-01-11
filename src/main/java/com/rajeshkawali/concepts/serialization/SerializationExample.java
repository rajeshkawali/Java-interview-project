package com.rajeshkawali.concepts.serialization;

import java.io.*;

/**
 * 
 * @author Rajesh_Kawali
 */
class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class SerializationExample {
	public static void main(String[] args) {
		// Serialization
		Person person = new Person("John", 30);
		try (FileOutputStream fos = new FileOutputStream("person.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(person);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Deserialization
		try (FileInputStream fis = new FileInputStream("person.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Person deserializedPerson = (Person) ois.readObject();
			System.out.println("Name: " + deserializedPerson.getName());
			System.out.println("Age: " + deserializedPerson.getAge());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
/*
In this example, the Person class implements the Serializable interface, 
which is a marker interface that indicates that an object can be serialized. 
The main() method first creates an instance of the Person class with 
the name "John" and age 30, and then serializes it to a file called "person.ser" using an ObjectOutputStream.

To deserialize the object, the main method creates a new ObjectInputStream 
and reads an object from the "person.ser" file, then cast the Object to Person 
and prints out the name and age of the deserialized Person object.
*/