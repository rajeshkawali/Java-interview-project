package com.rajeshkawali.concepts.exception;

class SuperClass {
	
	// If we use FileNotFoundException here Then 
	// ChildClass will show error -> Exception ClassNotFoundException is not compatible with throws clause in SuperClass.test()
	void test() throws Exception { 
		System.out.println("SuperClass");
	}
}

class ChildClass extends SuperClass {
	
	//when a SuperClass method throws a checked exception, any method that overrides it must 
	//either throw the same exception or a more specific exception.
	void test() throws ClassNotFoundException {
		System.out.println("ChildClass");
	}
}

public class SuperChildException {

	public static void main(String[] args) throws Throwable {
		ChildClass s = new ChildClass();
		s.test();
	}
}
/*
In this code snippet, there are two classes defined: SuperClass and ChildClass. 
The SuperClass defines a method called test() which throws an Exception. The ChildClass 
extends the SuperClass and overrides the test() method. In this overridden method, 
it throws a ClassNotFoundException.

When the test() method of the ChildClass is called, the overridden method in the 
ChildClass class is executed, which prints "ChildClass" to the console. However, 
the overridden method in ChildClass class throws a ClassNotFoundException instead 
of the Exception that the method in SuperClass class throws.

Therefore, if the code that calls the test() method of the ChildClass doesn't handle 
this exception, the program will terminate and print the exception message to the console.

It's worth noting that, when a class overrides a method, the overridden method is 
allowed to throw a subset of the exceptions that the original method throws. 
This is known as covariant exceptions.

It's also important to note that, when a method throws a checked exception, 
any method that overrides it must either throw the same exception or a more specific exception.
*/