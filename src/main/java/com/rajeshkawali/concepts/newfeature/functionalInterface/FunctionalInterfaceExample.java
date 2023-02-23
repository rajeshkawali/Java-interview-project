package com.rajeshkawali.concepts.newfeature.functionalInterface;
/**
 * @author Rajesh_Kawali
 *
 */
//Define a functional interface named Foo with a single abstract method named bar
//and two optional methods: a default method named HelloWorld and a static method named CustomMessage
@FunctionalInterface // Annotation is optional
interface Foo {
	
	/*
	A functional interface is an interface that contains exactly one abstract method. 
	This method is known as the functional method, and it defines the single method 
	that can be implemented by lambdas or method references. 
	Functional interfaces are the foundation of lambda expressions and the functional 
	programming features introduced in Java 8 and later versions.

	Functional interfaces can be annotated with the @FunctionalInterface annotation 
	to indicate that they are intended to be used as functional interfaces. 
	This annotation is optional, but it is recommended to use it as it allows 
	the Java compiler to check that the interface contains exactly one abstract 
	method and raise a compilation error if it doesn't.
	*/
	
	// Default Method - Optional can be 0 or more
	public default String HelloWorld() {
		return "Hello World";
	}

	// Static Method - Optional can be 0 or more
	public static String CustomMessage(String msg) {
		return msg;
	}

	// Single Abstract Method
	public void bar();
}

//Implement the Foo interface in a class named FooImplementation

public class FunctionalInterfaceExample implements Foo {
	// Override the default method named HelloWorld
	@Override
	public String HelloWorld() {
		return "Hello Java 8";
	}

	// Implement the single abstract method named bar
	@Override
	public void bar() {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		// Create an instance of the FooImplementation class
		FunctionalInterfaceExample fi = new FunctionalInterfaceExample();

		// Call the HelloWorld method on the instance
		System.out.println(fi.HelloWorld());

		// Call the CustomMessage static method on the interface
		System.out.println(Foo.CustomMessage("Hi"));

		// Call the bar method on the instance
		fi.bar();
	}
}

/*
Here are some of the important rules, do's and don'ts of using the @FunctionalInterface annotation:

Rules:-->
1.A functional interface must have exactly one abstract method. If an interface has more than one abstract method, the @FunctionalInterface annotation will cause a compilation error.
2.The @FunctionalInterface annotation can only be applied to interfaces, not to classes or enums.
3.Default methods and static methods in an interface do not count as abstract methods, so an interface can have multiple default or static methods in addition to its single abstract method.
4.If an interface extends another interface, and the combined set of abstract methods satisfies the requirements of a functional interface, the child interface can be annotated with the @FunctionalInterface annotation.

Do's:-->
1.Always use the @FunctionalInterface annotation when creating a functional interface. This will help to ensure that the interface has the correct structure and avoid accidental introduction of extra abstract methods.
2.Use descriptive names for the functional method and for the interface itself. This will make the code more readable and understandable.

Don'ts:-->
1.Don't add extra abstract methods to a functional interface. This will cause a compilation error if the interface is annotated with @FunctionalInterface.
2.Don't use the @FunctionalInterface annotation on interfaces that don't meet the requirements of a functional interface, i.e., interfaces with zero or more than one abstract method. This can cause confusion and make the code harder to understand.
3.Don't use the @FunctionalInterface annotation on interfaces that are intended to be used as marker interfaces, i.e., interfaces with no methods.
*/


/*
The code which have provided defines a functional interface named Foo, which has a single abstract method named bar, and two optional methods: a default method named HelloWorld and a static method named CustomMessage.

The FunctionalInterfaceExample class implements the Foo interface and provides an implementation for the bar method. It also overrides the HelloWorld default method.

The main method creates an instance of the FunctionalInterfaceExample class and calls the HelloWorld, CustomMessage, and bar methods on it.
*/