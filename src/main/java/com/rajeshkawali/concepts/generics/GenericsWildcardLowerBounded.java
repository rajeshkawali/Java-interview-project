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

In Java, a wildcard with a lower bound is represented by the "? super" syntax. 
It specifies that the type argument must be a superclass of the lower bound, 
which can be any class. For example, if we have a class "Animal" and a 
class "Cat" that extends "Animal", the declaration "List<? super Cat>" means 
that the list can hold elements of type "Cat" or any superclass of "Cat", 
such as "Animal". This type of wildcard is useful when you need to write methods 
that can take a list of objects of a specific superclass.

*/