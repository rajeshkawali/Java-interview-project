package com.rajeshkawali.program.pattern;

public class Pattern {

	public static void main(String[] args) {
		System.out.println("--------------------------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j >= i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j <= i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j < i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= 1; j--) {
				if (j > i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
	}
}
/*
--------------------------------------
*****
****
***
**
*
--------------------------------------
*
**
***
****
*****
--------------------------------------
*****
 ****
  ***
   **
    *
--------------------------------------
    *
   **
  ***
 ****
*****
--------------------------------------
 */
