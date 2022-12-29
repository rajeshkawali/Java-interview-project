package com.rajeshkawali.program.pattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Diamond {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the number: ");
		Integer size = Integer.parseInt(bf.readLine());
		int oddNumber = 1;
		int noOfSpaces = size / 2;

		for (int i = 1; i <= size; i++) {

			for (int j = noOfSpaces; j >= 1; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= oddNumber; k++) {
				System.out.print("*");
			}
			System.out.println();
			if (i < (size / 2) + 1) {
				oddNumber = oddNumber + 2;
				noOfSpaces = noOfSpaces - 1;
			} else {
				oddNumber = oddNumber - 2;
				noOfSpaces = noOfSpaces + 1;
			}
		}
	}
}

/*
Enter the number: 9

    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

*/