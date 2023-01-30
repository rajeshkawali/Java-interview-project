package com.rajeshkawali.program;

import java.util.Scanner;

/**
 * @author Rajesh_Kawali
 * 
 */
public class AllPossibleSubStringsOfGivenString {
	private static void printAllSubstrings(String inputString) {
		System.out.println("All possible substrings of " + inputString + " are : ");
		for (int i = 0; i < inputString.length(); i++) {
			for (int j = i + 1; j <= inputString.length(); j++) {
				System.out.println(inputString.substring(i, j));
			}
		}
	}

	private static void printAllSubstringsUsingStringBuilder(String inputString) {
		System.out.println("All possible substrings of " + inputString + " are : ");
		StringBuilder subSring;
		for (int i = 0; i < inputString.length(); i++) {
			subSring = new StringBuilder().append(inputString.charAt(i));
			System.out.println(subSring);
			for (int j = i + 1; j < inputString.length(); j++) {
				subSring.append(inputString.charAt(j));
				System.out.println(subSring);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Input String : ");
		String inputString = sc.next();
		printAllSubstrings(inputString);
		System.out.println("-----------------------------");
		printAllSubstringsUsingStringBuilder(inputString);
		sc.close();
	}
}