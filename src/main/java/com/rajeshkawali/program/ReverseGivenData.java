package com.rajeshkawali.program;

import java.util.Scanner;

public class ReverseGivenData {

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
		System.out.println("Reversed data is: " +reverse);
	}
}
