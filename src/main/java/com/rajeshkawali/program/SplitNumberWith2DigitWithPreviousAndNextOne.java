package com.rajeshkawali.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rajesh_Kawali
 * 
 */
public class SplitNumberWith2DigitWithPreviousAndNextOne {

	public static void main(String[] args) {
		// You have to split like – 78 84 45 52 29…………88 89. Print values- 2nd max-94 and 2nd min-29
		String s1 = "7845294917697889";
		List<String> integerList = new ArrayList<>();
		char[] c = s1.toCharArray();
		char previous = '0';
		for (char ch : c) {
			if (previous != '0') {
				System.out.print(previous + "" + ch + " ");
				integerList.add(previous + "" + ch);
			}
			previous = ch;
		}
		System.out.println();
		String max = integerList.stream().max(String::compareTo).get();
	    String min = integerList.stream().min(String::compareTo).get();
	    System.out.println("Max: " + max);
	    System.out.println("Min: " + min);
		System.out.println("------------------------------------------------");
		printMinAndMaxUsingJava8();
	}
	
	public static void printMinAndMaxUsingJava8() {
		String s1 = "7845294917697889";
	    List<Integer> numbers = Arrays.stream(s1.split(""))
	        .map(s -> Integer.parseInt(s))
	        .collect(Collectors.toList());
	    
	    System.out.println(numbers);
	    int max = numbers.stream().max(Integer::compareTo).get();
	    int min = numbers.stream().min(Integer::compareTo).get();
	    int secondMax = numbers.stream().filter(i -> i < max).max(Integer::compareTo).orElse(-1);
	    int secondMin = numbers.stream().filter(i -> i > min).min(Integer::compareTo).orElse(-1);
	    System.out.println("Max: " + max);
	    System.out.println("Min: " + min);
	    System.out.println("Second Max: " + secondMax);
	    System.out.println("Second Min: " + secondMin);
	}
}
