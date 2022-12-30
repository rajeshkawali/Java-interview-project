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
*/