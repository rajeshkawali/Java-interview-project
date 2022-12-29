package com.rajeshkawali.program;

public class SortArrayElements {

	public static void main(String[] args) {
		int[] inNumber = { 3, 2, 5, 4, 1 };
		System.out.println("Ascending Order:");
		int[] a = sortingArrayElements(inNumber);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

	private static int[] sortingArrayElements(int[] inNumber) {
		for (int i = 0; i < inNumber.length; i++) {
			for (int j = i + 1; j < inNumber.length; j++) {
				if (inNumber[i] > inNumber[j]) {
					int temp = inNumber[j];
					inNumber[j] = inNumber[i];
					inNumber[i] = temp;
				}
			}
		}
		return inNumber;
	}
}