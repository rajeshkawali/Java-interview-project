package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author Rajesh_Kawali
 *
 */
public class OperatorFunctionalInterfacesExample {

	public static void main(String[] args) {

		BinaryOperator<Integer> sum = (a, b) -> a + b;
		Integer result = sum.apply(2, 3);
		System.out.println(result); // Output: 5

		UnaryOperator<Integer> doubleIt = num -> num * 2;
		Integer result3 = doubleIt.apply(5);
		System.out.println(result3); // Output: 10
	}
}
