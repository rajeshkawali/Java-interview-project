package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.Consumer;

/**
 * @author Rajesh_Kawali
 *
 */
public class ConsumerExample {
	public static void main(String[] args) {
		// Define some consumers
		Consumer<String> printString = str -> System.out.println(str);
		Consumer<Integer> printInteger = i -> System.out.println(i);

		// Use the accept() method
		printString.accept("Hello, Consumer!"); // Output: "Hello, Consumer!"
		printInteger.accept(5); // Output: 5

		// Use the andThen() method
		Consumer<Integer> printAndDouble = printInteger.andThen(i -> System.out.println(i * 2));
		printAndDouble.accept(5); // Output: 5, 10
	}
}
/*
Consumer interface is a functional interface that takes a single input parameter and performs a certain action, it does not return any value. It is part of the java.util.function package, and it has a single abstract method void accept(T t).

Some of the default methods of the Consumer interface include:

andThen(Consumer<T> after) : Returns a composed Consumer that performs, in sequence, this operation followed by the after operation. This method allows you to chain multiple consumers together, where the first consumer is applied first, and the result is passed as an input to the second consumer.

accept(T t) : it applies the consumer function on the input and does not return any value.
*/