package com.rajeshkawali.concepts.general;

import java.util.Arrays;

/**
 * @author Rajesh_Kawali
 *
 */
public class SafeVarargsExample {
	@SafeVarargs // If we remove this annotation then compiler will give warning -> Type safety: Potential heap pollution via varargs parameter elements
	public static <T> void printElements(T... elements) {
		for (T element : elements) {
			System.out.println(element);
		}
	}

	public static void main(String[] args) {
		printElements("Hello", "World", "!");
		printElements(1, 2, 3, 4, 5);
		printElements(Arrays.asList("A", "B", "C"));
	}
}
/*
The @SafeVarargs annotation is a type of annotation in Java that is used to 
suppress unchecked warnings related to varargs methods and constructors. 
A varargs method or constructor is a method or constructor that takes a variable number of arguments, 
and it is denoted by the ... syntax in the method or constructor declaration.
*/