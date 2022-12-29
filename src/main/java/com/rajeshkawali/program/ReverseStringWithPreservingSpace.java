package com.rajeshkawali.program;

public class ReverseStringWithPreservingSpace {
	public static void main(String[] args) {
		reverseString("i am raj");
	}

	static void reverseString(String inputString) {
		char[] inputStringArray = inputString.toCharArray();

		char[] reverseStringArray = new char[inputStringArray.length];

		for (int i = 0; i < inputStringArray.length; i++) {
			if (inputStringArray[i] == ' ') {
				reverseStringArray[i] = ' ';
			}
		}
		int j = reverseStringArray.length - 1;
		for (int i = 0; i < inputStringArray.length; i++) {
			if (inputStringArray[i] != ' ') {
				// If resultArray already has space at index j then decrementing 'j'
				if (reverseStringArray[j] == ' ') {
					j--;
				}
				reverseStringArray[j] = inputStringArray[i];
				j--;
			}
		}
		System.out.println(inputString + " ---> " + String.valueOf(reverseStringArray));
	}
}