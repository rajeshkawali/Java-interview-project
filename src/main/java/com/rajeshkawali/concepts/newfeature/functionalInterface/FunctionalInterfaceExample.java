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
@FunctionalInterface Rules

1. Must have exactly one abstract method.
2. Can have multiple default and static methods.
3. Can extend another interface if it still has only one abstract method.
4. Applying @FunctionalInterface to an invalid interface causes a compile-time error.

Do's
1. Always use @FunctionalInterface for functional interfaces.
2. Use meaningful interface and method names.

Don'ts
1. Don't add more than one abstract method.
2. Don't use it on interfaces with zero abstract methods (marker interfaces).
3. Don't use it on interfaces that have more than one abstract method.

Interview Tip:
A functional interface = One Abstract Method (SAM)
SAM = Single Abstract Method
*/


/*
Functional Interface Example

1. Foo is a functional interface because it has only one abstract method: bar().
2. The @FunctionalInterface annotation is optional but recommended.
3. It can have any number of default and static methods.
4. FunctionalInterfaceExample implements Foo and provides an implementation for bar().
5. It also overrides the default method HelloWorld().
6. Static methods belong to the interface and are called using the interface name.

Method Calls:
- fi.HelloWorld()         -> Calls overridden default method.
- Foo.CustomMessage("Hi") -> Calls static method.
- fi.bar()                -> Calls implemented abstract method.

Output:
Hello Java 8
Hi
Hello World

Interview Points:
- Functional Interface = One Abstract Method (SAM).
- Default methods can be overridden.
- Static methods cannot be overridden and are called using the interface name.
- Functional interfaces are mainly used with Lambda Expressions and Method References.
*/