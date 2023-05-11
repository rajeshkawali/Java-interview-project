package com.rajeshkawali.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Rajesh_Kawali
 * 
 */
public class ReverseGivenArray {
	//Ex:1
	static void reverseArray(int inputArray[]) {
		System.out.println("Array Before Reverse : " + Arrays.toString(inputArray));
		int temp;
		for (int i = 0; i < inputArray.length / 2; i++) {
			temp = inputArray[i];
			inputArray[i] = inputArray[inputArray.length - 1 - i];
			inputArray[inputArray.length - 1 - i] = temp;
		}
		System.out.println("Array After Reverse : " + Arrays.toString(inputArray));
	}
	//Ex:2
	public static void reverseTheArray(int[] arr) {
		System.out.println("Array Before Reverse : " + Arrays.toString(arr));
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		System.out.println("Array After Reverse : " + Arrays.toString(arr));
	}
	//Ex:3
	public static void reverseGivenArray(int[] arr) {
	    List<Integer> list = new ArrayList<Integer>(arr.length);
	    for (int i : arr) {
	        list.add(i);
	    }
	    Collections.reverse(list);
	    int[] reversedArray = new int[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	        reversedArray[i] = list.get(i);
	    }
	    System.out.println("Array Before Reverse : " + Arrays.toString(arr));
	    System.out.println("Array After Reverse : " + Arrays.toString(reversedArray));
	}
	//Ex:4
	public static int[] reverseArrayUsingStream(int[] arr) {
	    return IntStream.range(0, arr.length)
	                    .map(i -> arr[arr.length - 1 - i])
	                    .toArray();
	}

	public static void main(String[] args) {
		reverseArray(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("-------------------------");
		reverseTheArray(new int[] { 326, 569, 431, 876 });
		System.out.println("-------------------------");
		reverseGivenArray(new int[] { 891, 569, 921, 187, 343, 476, 555 });
		System.out.println("-------------------------");
		int[] reversedArray = reverseArrayUsingStream(new int[] { 326, 569, 431, 876 });
		System.out.println(Arrays.toString(reversedArray));
	}
}
/*
Ex:1

In this code, inputArray is the array to be reversed. The reverseArray method finds the midpoint of the array using n / 2. 
Then, it iterates through the first half of the array and swaps each element with its corresponding element 
from the second half of the array.

For example, if the array is [1, 2, 3, 4, 5], the midpoint is 2, and the loop will swap 1 with 5, 2 with 4, 
and leave 3 in place. The resulting array will be [5, 4, 3, 2, 1].
*/

/*
Ex:2

there are other ways to reverse an array in Java. One way is to use two pointers, one starting at the 
beginning of the array and the other starting at the end of the array, and swapping the elements 
until the pointers meet in the middle of the array.
*/