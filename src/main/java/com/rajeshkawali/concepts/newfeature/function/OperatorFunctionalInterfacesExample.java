package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author Rajesh_Kawali
 *
 */
public class OperatorFunctionalInterfacesExample {

	public static void main(String[] args) {

		// BinaryOperator: takes two operands of the same type and returns a result of the same type
		BinaryOperator<Integer> sum = (a, b) -> a + b;
		Integer result = sum.apply(2, 3); // Adds 2 and 3
		System.out.println(result); // Output: 5

		// UnaryOperator: takes one operand and returns a result of the same type
		UnaryOperator<Integer> doubleIt = num -> num * 2;
		Integer result3 = doubleIt.apply(5); // Doubles 5
		System.out.println(result3); // Output: 10
	}
}
/*

UnaryOperator:- is a functional interface that takes one argument of a certain type and returns a result of the same type. 
			The apply method defined by this interface takes a single argument of type T and returns a result of the same type T.

BinaryOperator:- is a functional interface that takes two arguments of a certain type and returns a result of the same type. 
			The apply method defined by this interface takes two arguments of type T and returns a result of the same type T.

*/

/*
BinaryOperator:- 
static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) :-->
Description: Returns a BinaryOperator that returns the smaller of two elements based on the provided comparator.

static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)
Description: Returns a BinaryOperator that returns the greater of two elements based on the provided comparator.

apply(T t1, T t2)
Description: Applies the binary operation to two operands.
-----------------------------------------------------------------------------------------
UnaryOperator:-

static <T> UnaryOperator<T> identity()
Description: Returns a UnaryOperator that always returns its input argument unchanged.

*/
