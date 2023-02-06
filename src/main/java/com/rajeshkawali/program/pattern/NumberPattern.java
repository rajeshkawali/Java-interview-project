package com.rajeshkawali.program.pattern;

public class NumberPattern {

	public static void main(String[] args) {

		int number = 5;
		int temp = 1;
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= i; j++) {
				if (temp == 10)
					temp=0;
					System.out.print(temp++);
			}
			System.out.println();
		}
	}
}
/*

1
23
456
7890
12345

*/