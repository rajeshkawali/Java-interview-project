package com.rajeshkawali.concepts.array;
/**
 * @author Rajesh_Kawali
 *
 */
public class Array2D {

	public static void main(String[] args) {

		// int[][] intArray = new int[4][4];
		int[][] intArray = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		System.out.println(intArray[0][0]);
		System.out.println(intArray[0][1]);
		System.out.println(intArray[0][2]);
		System.out.println(intArray[0][3]);
		System.out.println(intArray[1][0]);
		System.out.println(intArray[1][1]);
		System.out.println(intArray[1][2]);
		System.out.println(intArray[1][3]);
		System.out.println(intArray[2][0]);
		System.out.println(intArray[2][1]);
		System.out.println(intArray[2][2]);
		System.out.println(intArray[2][3]);
		System.out.println(intArray[3][0]);
		System.out.println(intArray[3][1]);
		System.out.println(intArray[3][2]);
		System.out.println(intArray[3][3]);
		System.out.println("----------------------------------");
		for (int j = 0; j < intArray.length; j++) {
			// System.out.print("{"+i.length+"}");
			for (int k = 0; k < intArray[j].length; k++) {
				// System.out.print("{"+i[j].length+"}");
				System.out.print("(" + intArray[j][k] + "),");
			}
		}

	}

}
