package com.rajeshkawali.concepts.generics;

public class GenericsMethodExample {

	// Java Generic Method
	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
		return g1.get().equals(g2.get());
	}

	public static void main(String args[]) {
		GenericsType<String> g1 = new GenericsType<>();
		g1.set("Laksh");

		GenericsType<String> g2 = new GenericsType<>();
		g2.set("Laksh");
		
		GenericsType<Integer> i1 = new GenericsType<>();
		i1.set(11);

		GenericsType<Integer> i2 = new GenericsType<>();
		i2.set(11);

		boolean isEqual = GenericsMethodExample.<String>isEqual(g1, g2);
		// above statement can be written simply as
		isEqual = GenericsMethodExample.isEqual(g1, g2);
		System.out.println("String type: "+isEqual);
		isEqual = GenericsMethodExample.isEqual(i1, i2);
		System.out.println("Integer type: "+isEqual);
		// This feature, known as type inference, allows you to invoke a generic method
		// as an ordinary method, without specifying a type between angle brackets.
		// Compiler will infer the type that is needed
	}
}
/*

The code you provided is a static method called isEqual that takes two arguments of 
type GenericsType<T>, where T is a type parameter. The method returns a boolean value 
indicating whether the values of the two GenericsType instances are equal.

The method uses the get() method of each GenericsType instance to retrieve their respective 
values, and then compares the values using the equals() method. Note that equals() is 
a method defined in the Object class, so it must be overridden in the class of T to 
properly compare the values.
*/