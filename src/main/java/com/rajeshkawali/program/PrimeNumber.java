package com.rajeshkawali.program;

import java.util.Scanner;

/**
 * @author Rajesh_Kawali
 * 
 */
public class PrimeNumber {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int i = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int number = sc.nextInt();
		for (i = 2; i < number; i++) {
			if (number % i == 0) {
				break;
			}
		}
		if (number == i) {
			System.out.println(number + " is a Prime number");
		} else {
			System.out.println(number + " is not a Prime number");
		}
		System.out.println("--------------------------");
		primeNumber1(number);
		System.out.println("--------------------------");
		primeNumber2(number);
		System.out.println("--------------------------");
		primeNumber3(number);
		System.out.println("--------------------------");
	}

	public static void primeNumber1(int number) {
		if (isPrime1(number)) {
			System.out.println(number + " is a prime number.");
		} else {
			System.out.println(number + " is not a prime number.");
		}
	}
	
	public static boolean isPrime1(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void primeNumber2(int n) {

		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(i + " ");
			}
		}
	}

	public static void primeNumber3(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
