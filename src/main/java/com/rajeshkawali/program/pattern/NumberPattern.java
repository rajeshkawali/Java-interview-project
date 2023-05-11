package com.rajeshkawali.program.pattern;

public class NumberPattern {

	public static void main(String[] args) {
		printNumberPatternOne(5);
		System.out.println("--------------------------");
		printNumberPatternTwo(5);
		System.out.println("--------------------------");
		printNumberPatternThree(5);
		System.out.println("--------------------------");
	}

	public static void printNumberPatternOne(int n) {
		int num = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(num % 10);
				num++;
			}
			System.out.println();
		}
	}

	public static void printNumberPatternTwo(int n) {
		int count = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(count);
				count = (count + 1) % 10;
			}
			System.out.println();
		}
	}

	public static void printNumberPatternThree(int n) {
		int number = 5;
		int temp = 1;
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= i; j++) {
				if (temp == 10)
					temp = 0;
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
--------------------------
1
23
456
7890
12345
--------------------------
1
23
456
7890
12345
--------------------------
*/