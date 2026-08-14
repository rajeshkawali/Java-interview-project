package com.rajeshkawali.program;

/**
 * @author Rajesh_Kawali
 * 
 */
/**
 * Q: How do you reverse the characters in a string while keeping all the spaces in their original positions?
 *
 * Example:
 * Input : "i am raj"
 * Output: "j ar mai"
 *
 * The characters are reversed, but spaces stay exactly where they were in the original string.
 */

public class ReverseStringWithPreservingSpace {
	
    public static void main(String[] args) {
        // Calling the method with the input string
        reverseString("i am raj");
    }

    static void reverseString(String input) {
        // Convert the input string to a character array
        char[] inputArr = input.toCharArray();

        // Create a new array to store the result (same length as input)
        char[] result = new char[input.length()];

        // Step 1: Copy spaces from input to the same positions in result
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == ' ') {
                result[i] = ' '; // Preserve the space in its original index
            }
        }

        // Step 2: Fill the result array with characters from the end of input, skipping spaces
        int j = inputArr.length - 1; // Start from the end of result array
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] != ' ') {
                // Move backward until we find a non-space position in result
                while (result[j] == ' ') {
                    j--;
                }
                result[j] = inputArr[i]; // Place the character in correct reversed position
                j--; // Move to next position from the end
            }
        }

        // Print the original and reversed string with preserved spaces
        System.out.println(input + " --> " + new String(result));
    }
}