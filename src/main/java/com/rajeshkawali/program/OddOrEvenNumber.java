package com.rajeshkawali.program;

import java.util.Scanner;

public class OddOrEvenNumber {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int number = sc.nextInt();

		if (number % 2 == 0) {
			System.out.println("It is not a Odd Number:" + number);
		} else {
			System.out.println("It is a Odd Number:" + number);
		}
	}
}
