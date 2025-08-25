package com.rajeshkawali.program;

//Class to find the first non-repeated character in a string
public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		String input = "rajesh ab";
		// Remove spaces from the string (optional step)
		input = input.replace(" ", "");
		// Loop through each character in the string
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i); // Get the character at position i

			// Check if this character appears only once in the entire string
			if (input.indexOf(c) == input.lastIndexOf(c)) {
				// If yes, print it and exit the program
				System.out.println("First non-repeated character: " + c);
				return;
			}
		}
		// If no non-repeated character was found
		System.out.println("No non-repeated character found.");
	}
}