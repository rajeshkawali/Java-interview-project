package com.rajeshkawali.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	// Java code snippet that generates all permutations of the characters 'a', 'b', and 'c' and prints them in lexicographic order
	public static void main(String[] args) {
		//Input
		String str = "abc";
		//Output: abc,acb,bac,bca,cab,cba
		generatePermutations(str.toCharArray(), 0);
		System.out.println("-------------------------------------------");
		List<String> permutations = generatePermutations(str);
		for (String permutation : permutations) {
			System.out.println(permutation);
		}
	}

	public static List<String> generatePermutations(String str) {
		List<String> permutations = new ArrayList<>();
		generatePermutationsHelper("", str, permutations);
		return permutations;
	}

	private static void generatePermutationsHelper(String prefix, String remaining, List<String> permutations) {
		int length = remaining.length();
		if (length == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < length; i++) {
				String newPrefix = prefix + remaining.charAt(i);
				String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
				generatePermutationsHelper(newPrefix, newRemaining, permutations);
			}
		}
	}
	//------------------------------------------------------------------------------
	public static void generatePermutations(char[] arr, int index) {
        if (index == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                generatePermutations(arr, index + 1);
                swap(arr, index, i);
            }
        }
    }
    
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
