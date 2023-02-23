package com.rajeshkawali.concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcardUnbounded {

	public static void main(String[] args) {
		List<Object> ints = new ArrayList<>();
		ints.add(3);
		ints.add(5);
		ints.add(10);
		//ints.add("str"); //java.lang.ClassCastException
		int sum = sum(ints);
		System.out.println("Sum of ints=" + sum);
	}

	public static int sum(List<?> list) {
		int sum = 0;
		for (Object n : list) {
			sum += (int) n;
		}
		return sum;
	}
}
/*
Upper bound:-->
An upper bound restricts the type argument to be a subtype of a specified class or interface. 
The syntax for declaring an upper bound is <? extends SomeClass>, where SomeClass is the upper bound. 


Sometimes we have a situation where we want our generic method 
to be working with all types, in this case, an unbounded 
wildcard can be used. Its same as using <? extends Object>.
*/