package com.rajeshkawali.concepts.general;


/**
 * @author Rajesh_Kawali
 *
 */
class SuperClass {
	/*
	In Java, there are two types of initializer blocks: 
	static initializer blocks (SIB) and instance initializer blocks (IIB).

	Static initializer blocks (SIB) are used to initialize static variables and are executed only once when the class is loaded by the JVM. 
	SIBs are defined using the static keyword and are executed in the order in which they are defined in the class.
	
	Instance initializer blocks (IIB) are used to initialize instance variables and are executed each time an object of the class is 
	created. IIBs are not defined using the static keyword and are executed in the order in which they are defined in the class, 
	before the constructor is called.
	
	Both SIBs and IIBs are useful in cases where you need to initialize variables with non-trivial 
	expressions or perform other setup tasks that cannot be done in a single line of code.
	*/
	SuperClass() {
		System.out.println("SuperClass-constructor..");
	}

	{
		System.out.println("SuperClass-IIB..");
	}

	static {
		System.out.println("SuperClass-SIB..");
	}
}

class ChildClass extends SuperClass {
	
	ChildClass() {
		System.out.println("ChildClass-constructor..");
	}

	{
		System.out.println("ChildClass-IIB..");
	}

	static {
		System.out.println("ChildClass-SIB..");
	}
}

public class SibAndIib {

	SibAndIib() {
		System.out.println("Main-constructor");
	}

	{
		System.out.println("Main-IIB");
	}

	static {
		System.out.println("Main-SIB");
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// SuperClass a = new SuperClass();
		ChildClass s1 = new ChildClass();
		System.out.println("---------------------");
		ChildClass s2 = new ChildClass();
	}
}
/*
Main-SIB
SuperClass-SIB..
ChildClass-SIB..
SuperClass-IIB..
SuperClass-constructor..
ChildClass-IIB..
ChildClass-constructor..
---------------------
SuperClass-IIB..
SuperClass-constructor..
ChildClass-IIB..
ChildClass-constructor..

*/