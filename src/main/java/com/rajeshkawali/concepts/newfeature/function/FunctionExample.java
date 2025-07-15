package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.Function;

/**
 * @author Rajesh_Kawali
 *
 */
public class FunctionExample {
	
	public static void main(String[] args) {
		
		// Define a Function that takes a String and returns its length
		Function<String, Integer> stringLength = str -> str.length();

		// Define a Function that doubles an Integer
		Function<Integer, Integer> doubleIt = x -> x * 2;

		// Define a Function that adds 1 to an Integer
		Function<Integer, Integer> addOne = x -> x + 1;

		// Test each function individually
		System.out.println(stringLength.apply("Hello, Function!")); // Output: 17
		System.out.println(doubleIt.apply(5)); // Output: 10
		System.out.println(addOne.apply(5)); // Output: 6

		// andThen(): applies doubleIt first, then addOne
		// i.e., (5 * 2) + 1 = 11
		Function<Integer, Integer> andThenDefault = doubleIt.andThen(addOne);
		System.out.println(andThenDefault.apply(5)); // Output: 11

		// compose(): applies addOne first, then doubleIt
		// i.e., (5 + 1) * 2 = 12
		Function<Integer, Integer> composeDefault = doubleIt.compose(addOne);
		System.out.println(composeDefault.apply(5)); // Output: 12

		// identity(): returns the input as is
		Function<Integer, Integer> identity = Function.identity();
		System.out.println(identity.apply(5)); // Output: 5
	}
}
/*
Function interface is a functional interface that takes a single input parameter 
and returns a single output. It is part of the java.util.function package, 
and it has a single abstract method R apply(T t).

Some of the static and default methods of the Function interface include:-->

default andThen(Function after) :- Returns a composed function that first applies this function to its input, 
			  and then applies the after function to the result. This method allows you to chain multiple 
			  functions together, where the first function is applied first, and the result is passed as an 
			  input to the second function.

default compose(Function before) :- Returns a composed function that first applies the before function 
			  to its input, and then applies this function to the result. This method also allows you to chain 
			  multiple functions together but the difference from andThen is the order of execution.

static identity() :- Returns a function that always returns its input argument. This method is useful 
			  in situations where the data is not changed but you still want to use the Function interface.

R apply(T t) :- it applies this function to the given argument.
*/