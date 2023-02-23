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

/*
This code prints a diamond shape using asterisks '*' and spaces ' '.

It takes an integer as input from the user to determine the size of the diamond. 
The variable oddNumber is used to keep track of the number of asterisks on each line, 
while noOfSpaces is used to keep track of the number of spaces to print before the asterisks.

The outer for loop iterates from 1 to size and is responsible for printing each line of the diamond. 
For each line, the first inner for loop prints the spaces before the asterisks, 
and the second inner for loop prints the asterisks.

The if-else block inside the outer loop is used to adjust the values of oddNumber and noOfSpaces for each line, 
depending on whether the line is in the upper half or lower half of the diamond. In the upper half, 
oddNumber is increased by 2 and noOfSpaces is decreased by 1 for each line, while in the lower half, 
oddNumber is decreased by 2 and noOfSpaces is increased by 1.
*/