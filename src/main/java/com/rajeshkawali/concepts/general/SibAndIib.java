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


/*
SIB (Static Initialization Block)
---------------------------------
1. Executes only once when the class is loaded into memory.
2. Used to initialize static variables/resources.
3. Executes before main().
4. If multiple SIBs exist, they execute in the order they are written(Top to Bottom).

IIB (Instance Initialization Block)
-----------------------------------
1. Executes every time an object is created.
2. Executes before the constructor.
3. Used for common initialization code shared by all constructors.
4. If multiple IIBs exist, they execute in the order they are written(Top to Bottom).

Constructor
-----------
1. Executes after the IIB.
2. Used to initialize object-specific data.
3. Runs every time an object is created.
4. Parent constructor executes before the child constructor.

Execution Order
---------------
Class Loading:
1. Parent SIB
2. Child SIB
3. Main Class SIB

Object Creation:
1. Parent IIB
2. Parent Constructor
3. Child IIB
4. Child Constructor

Important Points
----------------
- SIB executes only once per class.
- IIB and Constructor execute for every object.
- Constructors are not inherited, but they are called using super().
- Static members belong to the class, whereas IIB and constructors belong to objects.
- Java automatically calls the parent constructor first (super()) if not specified.

Easy Trick:
-----------
Class Loading  : SIB (Once)
Object Creation: Parent IIB -> Parent Constructor -> Child IIB -> Child Constructor
*/

