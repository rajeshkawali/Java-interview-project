package com.rajeshkawali.program;

import java.util.Scanner;

public class NumberPattern {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter input one: ");
		int inputOne = scanner.nextInt();

		System.out.print("Enter input two: ");
		int inputTwo = scanner.nextInt();

		generatePattern(inputOne, inputTwo);
		scanner.close();
	}

	public static void generatePattern(int start, int end) {
		int count = 1;
		for (int i = start; i <= end; i++) {
			System.out.print(i + " ");

			if (count % 2 == 0) {
				System.out.println();
			}
			count++;
		}
	}
}
/*
Enter input one: 1
Enter input two: 9
1 2 
3 4 
5 6 
7 8 
9 
*/