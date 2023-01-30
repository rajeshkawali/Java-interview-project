package com.rajeshkawali.program;

import java.util.Scanner;
/**
 * @author Rajesh_Kawali
 * 
 */
public class RemoveWhiteSpaces {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input string to remove white spaces: ");
		String inputString = sc.nextLine();
		//System.out.println("Removed White Spaces: "+ inputString.replaceAll("\\s+", ""));
		char[] charArray = inputString.toCharArray();
		String stringWithoutSpaces = "";
		for (int i = 0; i < charArray.length; i++) {
			if ((charArray[i] != ' ') && (charArray[i] != '\t')) {
				stringWithoutSpaces = stringWithoutSpaces + charArray[i];
			}
		}
		System.out.println("Input String : " + inputString);
		System.out.println("Input String Without Spaces : " + stringWithoutSpaces);
		sc.close();
	}
}