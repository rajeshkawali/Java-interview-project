package com.rajeshkawali.program;
/**
 * Q: Group words that are anagrams of each other.
 *
 * Given a list of words, group them into sets where each set contains words
 * that are anagrams of each other.
 *
 * For example:
 * Input: ["listen", "silent", "hello", "enlist", "world"]
 * Output: [["listen", "silent", "enlist"], ["hello"], ["world"]]
 */

import java.util.*;

public class AnagramGrouper {
    public static void main(String[] args) {
        // List of input words
        List<String> words = Arrays.asList("listen", "silent", "dlwor", "hello", "enlist", "world");

        // Map to hold groups of anagrams
        // Key = sorted characters of the word; Value = Set of anagrams with that key
        Map<String, Set<String>> map = new HashMap<>();

        for (String word : words) {
            // Convert the word to a char array
            char[] chars = word.toCharArray();

            // Sort the characters to create a common key for anagrams
            Arrays.sort(chars);

            // Convert the sorted char array back to a string (the key)
            String key = new String(chars);

            // If the key is not present, create a new set; then add the word to the set
            map.computeIfAbsent(key, k -> new HashSet<>()).add(word);
        }

        // Extract the grouped sets of anagrams from the map
        Set<Set<String>> output = new HashSet<>(map.values());

        // Print the result
        System.out.println(output);
    }
}