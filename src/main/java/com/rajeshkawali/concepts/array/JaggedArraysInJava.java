package com.rajeshkawali.concepts.array;
/**
 * @author Rajesh_Kawali
 *
 */
public class JaggedArraysInJava {
	
	public static void main(String[] args) {
		// One Dimensional Array of lenghth 3
		int[] OneDimensionalArray1 = { 1, 2, 3 };
		// One Dimensional Array of lenghth 4
		int[] oneDimensionalArray2 = { 4, 5, 6, 7 };
		// One Dimensional Array of lenghth 5
		int[] oneDimensionalArray3 = { 8, 9, 10, 11, 12 };
		// Jagged Two Dimensional Array
		int[][] twoDimensionalArray = { OneDimensionalArray1, oneDimensionalArray2, oneDimensionalArray3 };
		// Printing elements of Two Dimensional Array
		for (int i = 0; i < twoDimensionalArray.length; i++) {
			for (int j = 0; j < twoDimensionalArray[i].length; j++) {
				System.out.print(twoDimensionalArray[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------");
		jaggedArraysTwoDimention();
		System.out.println("------------------------------------------------------------------------------");
		jaggedArraysThreeDimention();
	}

	public static void jaggedArraysTwoDimention() {
		// Jagged Two Dimensional Array, No need to mention the size of it's contained arrays
		int[][] jaggedTwoDimensionalArray = new int[3][];
		// One Dimensional Array of lenghth 3
		int[] OneDimensionalArray1 = { 1, 2, 3 };
		// One Dimensional Array of lenghth 4
		int[] oneDimensionalArray2 = { 4, 5, 6, 7 };
		// One Dimensional Array of lenghth 5
		int[] oneDimensionalArray3 = { 8, 9, 10, 11, 12 };
		// Initializing elements of Jagged Array
		jaggedTwoDimensionalArray[0] = OneDimensionalArray1;
		jaggedTwoDimensionalArray[1] = oneDimensionalArray2;
		jaggedTwoDimensionalArray[2] = oneDimensionalArray3;
		for (int i = 0; i < jaggedTwoDimensionalArray.length; i++) {
			System.out.print("{");
			for (int j = 0; j < jaggedTwoDimensionalArray[i].length; j++) {
				System.out.print(jaggedTwoDimensionalArray[i][j] + "\t");
			}
			System.out.print("}");
			System.out.println();
		}
	}
	
	public static void jaggedArraysThreeDimention() {
		// One Dimensional Arrays
		int[] fisrtArray = { 1, 2, 3 };
		int[] secondArray = { 4, 5, 6 };
		int[] thirdArray = { 7, 8, 9 };
		int[] fourthArray = { 10, 11, 12 };
		int[] fifthArray = { 13, 14, 15 };
		int[] sixthArray = { 16, 17, 18 };
		int[] seventhArray = { 19, 20, 21 };
		int[] eighthArray = { 22, 23, 24 };
		int[] ninthArray = { 25, 26, 27 };
		// Two Dimensional Arrays
		int[][] twoDimensionalArray1 = { fisrtArray, secondArray, thirdArray };
		int[][] twoDimensionalArray2 = { fourthArray, fifthArray, sixthArray };
		int[][] twoDimensionalArray3 = { seventhArray, eighthArray, ninthArray };
		// Three Dimensional Array
		int[][][] threeDimensionalArray = { twoDimensionalArray1, twoDimensionalArray2, twoDimensionalArray3 };
		// Printing elements of three dimensional array
		for (int i = 0; i < threeDimensionalArray.length; i++) {
			System.out.print("{");
			for (int j = 0; j < threeDimensionalArray[i].length; j++) {
				System.out.print("{");
				for (int k = 0; k < threeDimensionalArray[i][j].length; k++) {
					System.out.print(threeDimensionalArray[i][j][k] + "\t");
				}
				System.out.print("} ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
}