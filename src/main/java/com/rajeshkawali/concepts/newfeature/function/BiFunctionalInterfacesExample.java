package com.rajeshkawali.concepts.newfeature.function;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * @author Rajesh_Kawali
 *
 */
public class BiFunctionalInterfacesExample {

	public static void main(String[] args) {
		/*
		BiFunction is a functional interface that takes two input parameters and returns a single output. 
		It is part of the java.util.function package and has a single abstract method R apply(T t, U u).
		*/
		BiFunction<Integer,Integer,Integer> sum = (a, b) -> a + b;
        Integer result = sum.apply(2, 3);
        System.out.println(result);  // Output: 5
        
        //BiConsumer: This functional interface takes two input parameters and doesn't return any value.
        BiConsumer<String,String> printConcatenation = (a, b) -> System.out.println(a+b);
        printConcatenation.accept("Hello ", "BiConsumer!");
		
        //BiPredicate: This functional interface takes two input parameters and returns a boolean value.
        BiPredicate<String,String> isEqual = (a, b) -> a.equals(b);
        boolean isEqualStr = isEqual.test("hello","hello");
        System.out.println(isEqualStr);  // Output: true

	}
}
/*
Difference between BiFunction and BinaryOperator :-->

Return type: BiFunction takes two arguments of different types and returns a result of a third type, while 
BinaryOperator takes two arguments of the same type and returns a result of the same type.

Purpose: BiFunction is used for general purpose operations that take two arguments and return a result, while 
BinaryOperator is used specifically for arithmetic or logical operations that take two arguments 
of the same type and return a result of the same type.
*/