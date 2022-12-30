package com.rajeshkawali.concepts.array;

import java.util.Arrays;
/**
 * @author Rajesh_Kawali
 *
 */
public class ArrayCopyAndCloneAndCopyOf {

	public static void main(String[] args) {
		// Declaring and initializing an array of array
		int[] array = { 17, 31, 47, 4, 8 }; 
		// Creating an array object of same length as array 'arrayResult'
		int[] arrayResult = new int[array.length];
		System.out.println("Uncomment only one at a time");
		System.out.println("-----------|arrayAssignOperator|-----------");
		//arrayAssignOperator(array, arrayResult);
		System.out.println("-----------|arrayCopy|-----------");
		//arrayCopy(array, arrayResult);
		System.out.println("-----------|arrayClone|-----------");
		//arrayClone(array, arrayResult);
		System.out.println("-----------|arrayCopyOf|-----------");
		arrayCopyOf(array, arrayResult);
		System.out.println("-----------------------------------");
	}

	public static void arrayAssignOperator(int[] array, int[] arrayResult) {
		// copy 'array' into 'arrayResult' 
		arrayResult = array;
		// Printing elements of array 'arrayResult'
		for (int i = 0; i < arrayResult.length; i++) {
			System.out.print(arrayResult[i]+" ");
		}
		System.out.println();
		// Now changing values of one array will reflect in other array
		array[2] = 56; // Changing value of 3rd element in array 'array'
		System.out.println("arrayResult[2]=" + arrayResult[2]); // value of 3rd element in array 'arrayResult' will change
		arrayResult[4] = 100; // Changing value of 5th element in array 'arrayResult'
		System.out.println("array[4]=" + array[4]); // value of 5th element in array 'array' will change
	}
	
	public static void arrayCopy(int[] array, int[] arrayResult) {
		// creating a copy of 'array' using arraycopy() method of System class
		System.arraycopy(array, 0, arrayResult, 0, array.length);
		// Printing elements of array 'arrayResult'
		for (int i = 0; i < arrayResult.length; i++) {
			System.out.print(arrayResult[i]+" ");
		}
		System.out.println();
		// Now changing values of one array will not reflect in other array
		array[2] = 56; // Changing value of 3rd element in array 'array'
		System.out.println("arrayResult[2]=" + arrayResult[2]); // value of 3rd element in array 'arrayResult' will not change
		arrayResult[4] = 100; // Changing value of 5th element in array 'arrayResult'
		System.out.println("array[4]=" + array[4]); // value of 5th element in array 'array' will not change
	}

	public static void arrayClone(int[] array, int[] arrayResult) {
		// creating a copy of 'array' using clone() method of Object class
		arrayResult = array.clone();
		// Printing elements of array 'arrayResult'
		for (int i = 0; i < arrayResult.length; i++) {
			System.out.print(arrayResult[i]+" ");
		}
		System.out.println();
		// Now changing values of one array will not reflect in other array
		array[2] = 56; // Changing value of 3rd element in array 'array'
		System.out.println("arrayResult[2]=" + arrayResult[2]); // value of 3rd element in array 'arrayResult' will not change
		arrayResult[4] = 100; // Changing value of 5th element in array 'arrayResult'
		System.out.println("array[4]=" + array[4]); // value of 5th element in array 'array' will not change
	}
	
	public static void arrayCopyOf(int[] array, int[] arrayResult) {
		// creating a copy of 'array' using copyOf() method of Arrays class
		arrayResult = Arrays.copyOf(array, array.length);
		
		// Printing elements of array 'arrayResult'
		for (int i = 0; i < arrayResult.length; i++) {
			System.out.print(arrayResult[i]+" ");
		}
		System.out.println();
		// Now changing values of one array will not reflect in other array
		array[2] = 56; // Changing value of 3rd element in array 'array'
		System.out.println("arrayResult[2]=" + arrayResult[2]); // value of 3rd element in array 'arrayResult' will not change
		arrayResult[4] = 100; // Changing value of 5th element in array 'arrayResult'
		System.out.println("array[4]=" + array[4]); // value of 5th element in array 'array' will not change
	}
}
