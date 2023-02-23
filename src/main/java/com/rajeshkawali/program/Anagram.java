package com.rajeshkawali.program;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Anagram {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("dog", "cat", "god", "act", "pet");
		Set<Set<String>> output = new HashSet<>();
		for (String word : words) {
			boolean added = false;
			for (Set<String> set : output) {
				if (set.stream().anyMatch(s -> isAnagram(word, s))) {
					set.add(word);
					added = true;
					break;
				}
			}
			if (!added) {
				Set<String> set = new HashSet<>();
				set.add(word);
				output.add(set);
			}
		}
		System.out.println(output);
		
		System.out.println("------------------------------------");
		Set<Set<String>> anagramGroups = words.stream()
	            .collect(Collectors.groupingBy(Anagram::sortString))
	            .values().stream()
	            .filter(group -> group.size() > 1)
	            .map(HashSet::new)
	            .collect(Collectors.toSet());
	        
	        System.out.println(anagramGroups);
	}

	// Helper function to check if two strings are anagrams
	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		return Arrays.equals(chars1, chars2);
	}
	
	public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

/*
In this code, we first define the helper function isAnagram that takes two strings 
and checks if they are anagrams of each other by sorting their characters and comparing the sorted arrays.

We then iterate over the input list and for each word, we check if it belongs to an 
existing set of anagrams by checking if there is any word in the set that is an 
anagram of the current word. If we find such a set, we add the current word to the set. 
Otherwise, we create a new set with the current word and add it to the output.
*/