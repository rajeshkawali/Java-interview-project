package com.rajeshkawali.program.pattern;

public class PatternTriangle {

	public static void main(String[] args) {

		int size = 7;
		int noOfSpaces = size - 1;
		for (int i = 1; i <= size; i++) {
			for (int j = noOfSpaces; j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
			noOfSpaces = noOfSpaces - 1;
		}
	}
}
/*

      * 
     * * 
    * * * 
   * * * * 
  * * * * * 
 * * * * * * 
* * * * * * * 

*/