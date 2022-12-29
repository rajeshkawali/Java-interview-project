package com.rajeshkawali.program;

import java.util.Scanner;

public class PalindromOfNumber {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String original = "";
		String reverse = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter anything you want to reverse:");
		original = sc.next();
		int length = original.length();
		for (int i = length - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}
		if (original.equalsIgnoreCase(reverse)) {
			System.out.println(reverse + " is palindrom");
		} else {
			System.out.println(reverse + " is not palindrom");
		}
	}
}
