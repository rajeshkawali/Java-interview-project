package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 
 * @author Rajesh_Kawali
 */
public class FunctionalInterfacesExample {
	/*
	 functional interface is an interface that has exactly one abstract method.
	 This single abstract method is known as the functional method of the
	 functional interface. Functional interfaces are used as the basis for lambda
	 expressions and method references in Java 8 and later versions of the
	 language. Functional interfaces can have any number of default and static
	 methods, but they can have only one abstract method. 
	 
	 Java provides several built-in functional interfaces in the java.util.function package, such as
	 Function, Consumer, Supplier, Predicate, etc. You also can define your own
	 functional interfaces by annotating an interface with @FunctionalInterface,
	 this is optional but it's a good practice to use it to avoid accidental
	 addition of abstract methods.
	 
	 */
	public static void main(String[] args) {
		/*
		Function is a functional interface that takes a single input parameter and returns a single output. 
		It is also part of the java.util.function package, it has a single abstract method R apply(T t).
		*/
		Function<Integer, String> intToString = num -> Integer.toString(num);
		String str = intToString.apply(5);
		System.out.println(str); // Output: "5"

		/*
		Consumer is a functional interface that takes a single input parameter and does not return any value. 
		It is also part of the java.util.function package, it has a single abstract method void accept(T t).
		*/
		Consumer<String> println = System.out::println;
		println.accept("Hello, Consumer!"); // Output: "Hello, Consumer!"
		/*
		Supplier is a functional interface that does not take any input parameters, but returns a single output value. 
		It is also part of the java.util.function package, and it has a single abstract method T get().
		*/
		Supplier<String> currentDate = () -> new java.util.Date().toString();
		System.out.println(currentDate.get());
		/*
		Predicate is a functional interface that takes a single input parameter and returns a boolean value indicating whether the input satisfies a certain condition. 
		It is also part of the java.util.function package, and it has a single abstract method boolean test(T t).
		*/
		Predicate<Integer> isEven = num -> num % 2 == 0;
		System.out.println(isEven.test(5)); // Output: false
		System.out.println(isEven.test(6)); // Output: true

		System.out.println("---------------------------------------------");
		// Function usage
		Function<String, Integer> stringToInt = Integer::parseInt;
		int num = stringToInt.apply("123");
		System.out.println("Parsed to Integer : " + num); // Output: 123

		// Consumer usage
		Consumer<String> stringPrinter = System.out::println;
		stringPrinter.accept("Hello, Consumer!"); // Output: "Hello, Consumer!"

		// Supplier usage
		Supplier<String> randomString = () -> java.util.UUID.randomUUID().toString();
		System.out.println("Random String: " + randomString.get());

		// Predicate usage
		Predicate<String> isNotEmpty = s -> !s.isEmpty();
		System.out.println(isNotEmpty.test("")); // Output: false
		System.out.println(isNotEmpty.test("not empty")); // Output: true
	}
}
/*
Function takes a single input and produces a single output.
The Consumer takes a single input and produces no output.
The Supplier doesn’t take any input and produces a single output.
The Predicate takes a single input and returns a Boolean value.
*/
