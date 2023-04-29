package com.rajeshkawali.program;

import java.util.HashMap;
import java.util.Scanner;
/**
 * @author Rajesh_Kawali
 * 
 */
public class FirstRepeatedAndNonRepeatedChar {
	static void firstRepeatedNonRepeatedChar(String inputString) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		char[] strArray = inputString.toCharArray();
		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				charCountMap.put(c, 1);
			}
		}
		// checking for first non-repeated character
		for (char c : strArray) {
			if (charCountMap.get(c) == 1) {
				System.out.println("First Non-Repeated Character In '" + inputString + "' is '" + c + "'");
				break;
			}
		}
		// checking for first repeated character
		for (char c : strArray) {
			if (charCountMap.get(c) > 1) {
				System.out.println("First Repeated Character In '" + inputString + "' is '" + c + "'");
				break;
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string :");
		String input = sc.next();
		firstRepeatedNonRepeatedChar(input);
	}
}