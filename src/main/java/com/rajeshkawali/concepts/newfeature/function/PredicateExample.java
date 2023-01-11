package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.Predicate;

/**
 * @author Rajesh_Kawali
 *
 */
public class PredicateExample {
	public static void main(String[] args) {
		// Define some predicates
		Predicate<Integer> isPositive = x -> x > 0;
		Predicate<Integer> isEven = x -> x % 2 == 0;
		Predicate<Integer> isGreaterThanFive = x -> x > 5;

		// Test the predicates
		System.out.println(isPositive.test(5)); // Output: true
		System.out.println(isEven.test(4)); // Output: true
		System.out.println(isGreaterThanFive.test(8)); // Output: true

		// Use the and() method
		Predicate<Integer> isPositiveEven = isPositive.and(isEven);
		System.out.println(isPositiveEven.test(6)); // Output: true

		// Use the or() method
		Predicate<Integer> isPositiveOrGreaterThanFive = isPositive.or(isGreaterThanFive);
		System.out.println(isPositiveOrGreaterThanFive.test(3)); // Output: true

		// Use the negate() method
		Predicate<Integer> isNotPositive = isPositive.negate();
		System.out.println(isNotPositive.test(-5)); // Output: true

		// Use the isEqual() method
		Predicate<Integer> isEqual = Predicate.isEqual(5);
		System.out.println(isEqual.test(5)); // Output: true

		// Use the static not() method
		Predicate<Integer> isNotGreaterThanFive = Predicate.not(isGreaterThanFive);
		System.out.println(isNotGreaterThanFive.test(3)); // Output: true

	}
}
/*
Predicate interface is a functional interface that takes a single input parameter and returns a boolean value indicating whether the input meets certain criteria. It is part of the java.util.function package, and it has a single abstract method boolean test(T t).

Some of the static and default methods of the Predicate interface include:

and(Predicate other) : Returns a composed predicate that represents a short-circuiting logical AND of this predicate and other. This method allows you to chain multiple predicates together. The input will be passed through both predicates and only if both of them return true, the final output is true.

or(Predicate other) : Returns a composed predicate that represents a short-circuiting logical OR of this predicate and other. The input will be passed through both predicates and only if at least one of them return true, the final output is true.

negate() : Returns a predicate that represents the logical negation of this predicate. The input will be passed through the predicate and the opposite boolean value will be returned.

isEqual(Object targetRef) : Returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object).

not(Predicate target) : Returns a predicate that is the negation of the supplied predicate.

test(T t) : it applies the predicate function on the input and returns the boolean value.

*/