package com.rajeshkawali.program;

import java.util.Scanner;

// Fibonacci series program
public class FibonacciSeries {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int sum, previous, next;
		previous = next = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.print(previous + " ");
			sum = previous + next;
			previous = next;
			next = sum;
		}

	}

}
