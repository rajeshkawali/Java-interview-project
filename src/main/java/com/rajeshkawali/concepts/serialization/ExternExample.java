package com.rajeshkawali.concepts.serialization;
/**
 * @author Rajesh_Kawali
 *
 */
import java.io.*;

class Car implements Externalizable {
	static int age;
	String name;
	int year;

	public Car() {
		System.out.println("Default Constructor called");
	}

	Car(String n, int y) {
		this.name = n;
		this.year = y;
		age = 10;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(age);
		out.writeInt(year);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		year = in.readInt();
		age = in.readInt();
	}

	@Override
	public String toString() {
		return ("Name: " + name + "\n" + "Year: " + year + "\n" + "Age: " + age);
	}
}

public class ExternExample {
	public static void main(String[] args) {
		Car car = new Car("Shubham", 1995);
		Car newcar = null;
		// Serialize the car
		try {
			FileOutputStream fo = new FileOutputStream("gfg.txt");
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(car);
			so.flush();
			so.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("--------------------------------------------------------");
		// Deserialize the car
		try {
			FileInputStream fi = new FileInputStream("gfg.txt");
			ObjectInputStream si = new ObjectInputStream(fi);
			newcar = (Car) si.readObject();
			si.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("The original car is:\n" + car);
		System.out.println("The new car is:\n" + newcar);
	}
}
/*
Difference between Serialization and Externalization

1.In Serialization, entire object will be serialized. In Externalization, based on the requirement either full object or part of the object will be serialized.
2.In Serialization, JVM will have complete control in serializing the object. In Externalization, programmer will have complete control in serializing the object.
3.Serializable is a marker interface so it doesn't contain any methods. Externalizable contain two methods i.e writeExternal and readExternal.
4.If we implement Serializable interface, then during deserialization new object will not be created by executing any constructor. But if we implement Externalizable interface, then during deserialization new object will be created by executing No-arg Constructor.
5.In Serializable interface, Serialization won't happen if we declare a variable with transient keyword. 
So transient keyword play a major role in Serializable interface. But in Externalizable interface developers 
will have the complete control, so even if he declared variable with transient keyword and write that 
variable value in writeExternal method, then that variable state also will be serialized. 
So transient keyword doesn't play any role in Externalizable interface.

*/

/*
The main difference between the two is that while all objects that implement the 
Serializable interface are automatically serialized, objects that implement the 
Externalizable interface must explicitly define how they are to be serialized.

Serializable interface is a marker interface, which means it does not have any method. 
When an object is serialized, all its non-transient and non-static fields are saved to 
the byte stream. The default serialization process can be overridden by implementing writeObject() and readObject() methods.

Externalizable interface is a sub-interface of Serializable, 
which have two methods writeExternal(ObjectOutput) and readExternal(ObjectInput). 
The programmer must provide implementations of these methods that explicitly specify 
how the object should be serialized. This is useful when the default serialization 
process is not adequate and the programmer wants to have full control over the serialization process.

In general, serialization is used when the default serialization process is sufficient for an object, 
and externalization is used when the programmer wants to have more control over the serialization process. 
Keep in mind that Externalizable interface is rarely used and Serialization is the most common way of saving and loading objects.
*/