package com.rajeshkawali.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigits {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number :");
		int number = Integer.parseInt(rd.readLine());
		int sum = 0;
		while (number != 0) {
			int digit = number % 10; // This will give last digit from given data
			System.out.print(digit); // Reverse the digit
			sum = sum + digit;
			number = number / 10; // This will remove the last digit
		}
		System.out.println("\nSum Of Digits=" + sum);
	}
}
