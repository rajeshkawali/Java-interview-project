package com.rajeshkawali.program;

public class SplitNumberWith2DigitWithPreviousAndNextOne {

	public static void main(String[] args) {
		// You have to split like – 78 84 45 52 29…………88 89.Print values- 2nd max-94 and
		// 2nd min-29

		String s1 = "7845294917697889";

		char[] c = s1.toCharArray();

		char previous = '0';

		for (char ch : c) {
			if (previous != '0') {
				System.out.print(previous + "" + ch + " ");
			}
			previous = ch;
		}
	}

}
