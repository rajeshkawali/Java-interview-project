package com.rajeshkawali.concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcardLowerBounded {

	public static void main(String[] args) {

		List<Number> ints = new ArrayList<>();
		ints.add(3);
		ints.add(5);
		ints.add(10);
		int sum = sum(ints);
		System.out.println("Sum of ints=" + sum);
	}

	public static int sum(List<? super Integer> list) {
		int sum = 0;
		for (Object n : list) {
			sum += (Integer) n;
		}
		return sum;
	}
}
/*
List<? super Integer> list :--> Here we are restricting any value passed to ? (wildcard should be a super class of Integer class) 

List<? super Number> list1 = new ArrayList<Number>(); // Number is a "super" of Number
List<? super Number> list2 = new ArrayList<Object>(); // Object is a "super" of Number
*/