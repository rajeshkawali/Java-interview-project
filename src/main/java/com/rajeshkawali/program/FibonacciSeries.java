package com.rajeshkawali.program;

import java.util.Scanner;

/**
 * @author Rajesh_Kawali
 * 
 */
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
		System.out.println("--------------------------");
		for (int i = 1; i < number; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		System.out.println("--------------------------");
	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
/*
The Fibonacci series is a series of numbers where each number is the sum of the two preceding ones, 
starting from 0 and 1. In this code, the first two numbers in the series are initialized to 1, 
and then the for loop is executed for the number of times equal to the entered number.

Inside the loop, the current number (i.e., the sum of the previous two numbers) is printed, 
and the values of the previous and next numbers are updated for the next iteration. Finally, 
a separator is printed after the loop.
*/