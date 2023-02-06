package com.rajeshkawali.concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcardUpperBounded {

	public static void main(String[] args) {
		
		List<Integer> ints = new ArrayList<>();
		ints.add(3);
		ints.add(5);
		ints.add(10);
		double sum = sum(ints);
		System.out.println("Sum of ints=" + sum);
	}

	public static double sum(List<? extends Number> list) {
		double sum = 0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}
}
/*

List<? extends Number> list :--> Here we are restricting any value passed to ? (wildcard should be a subclass of Number class)

List<? extends Number> list1 = new ArrayList<Number>();  // Number "extends" Number
List<? extends Number> list2 = new ArrayList<Integer>(); // Integer extends Number
List<? extends Number> list3 = new ArrayList<Double>();  // Double extends Number

In Java, a wildcard with an upper bound is represented by the "? extends" syntax. 
It specifies that the type argument must be a subclass of the upper bound, 
which can be any class. For example, if we have a class "Animal" and a class "Cat" 
that extends "Animal", the declaration "List<? extends Animal>" means that the 
list can hold elements of type "Animal" or any subclasses of "Animal", such as "Cat". 
This type of wildcard is useful when you need to write methods that can accept a list 
of objects of any subclass of a specific class.

An upper bounded wildcard is typically used in situations where you need to 
retrieve objects from a list, but don't need to modify the list itself. 
This allows for maximum flexibility, as the method can be used with lists 
of any type that is a subclass of the upper bound.

*/