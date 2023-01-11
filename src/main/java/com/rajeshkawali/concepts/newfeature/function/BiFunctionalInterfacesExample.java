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
