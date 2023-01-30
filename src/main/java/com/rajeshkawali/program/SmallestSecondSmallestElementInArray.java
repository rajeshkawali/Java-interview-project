package com.rajeshkawali.program;

import java.util.Arrays;
/**
 * @author Rajesh_Kawali
 * 
 */
public class SmallestSecondSmallestElementInArray {
	
	public static void main(String[] args) {
		getSmallestSecondSmallestJava8(new int[] { 17, 11, 23, 64, 41, 88, 35 });
		System.out.println("--------------------------------------------------------------");
		getSmallestSecondSmallestJava8(new int[] { -9, 3, 36, -25, -9, 71, 0 });
		System.out.println("--------------------------------------------------------------");
		getSmallestAndSecondSmallestElement(new int[] { 21, 21, -18, -4, -11, 85, 7 });
		System.out.println("--------------------------------------------------------------");
		getSmallestAndSecondSmallestElement(new int[] { 21, 21, -18, -4, -11, 85, 7 });
		System.out.println("--------------------------------------------------------------");
	}

	private static void getSmallestSecondSmallestJava8(int[] inputArray) {
		System.out.println("Input Array : " + Arrays.toString(inputArray));
		System.out.println("Smallest And Second Smallest Elements Are :");
		Arrays.stream(inputArray).sorted().limit(2).forEach(System.out::println);
	}

	private static void getSmallestAndSecondSmallestElement(int[] inputArray) {
		int smallest = inputArray[0];
		int secondSmallest = inputArray[0];
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < smallest) {
				secondSmallest = smallest;
				smallest = inputArray[i];
			} else if (inputArray[i] > smallest && inputArray[i] < secondSmallest) {
				secondSmallest = inputArray[i];
			}
		}
		System.out.println("Input Array : " + Arrays.toString(inputArray));
		System.out.println("Smallest Element : " + smallest);
		System.out.println("Second Smallest Element : " + secondSmallest);
	}
}