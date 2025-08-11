package com.rajeshkawali.program;
import java.util.regex.*;
import java.util.stream.IntStream;

/**
 *
 * This Java program checks if a given substring (pattern) exists
 * within a larger string using four different approaches:
 * 
 * 1. Using String.contains()
 * 2. Using String.indexOf()
 * 3. Using Regular Expressions (Pattern and Matcher)
 * 4. Manual character-by-character comparison (Brute Force)
 * 
 * It demonstrates multiple techniques to understand how substring
 * matching can be implemented using both built-in methods and custom logic.
 */

public class SubstringSearch {

    public static void main(String[] args) {
        // Main string in which we want to search
        String s = "java is best programming language";

        // Substring (pattern) we are trying to find
        String pattern = "gram";

        // -------------------------------
        // Method 1: Using String.contains()
        // -------------------------------
        // Returns true if the pattern is present in the string
        boolean contains = s.contains(pattern);
        System.out.println("1. Using contains(): " + contains);

        // -------------------------------
        // Method 2: Using String.indexOf()
        // -------------------------------
        // Returns the index of the first occurrence, or -1 if not found
        int index = s.indexOf(pattern);
        System.out.println("2. Using indexOf(): " + (index != -1));

        // --------------------------------------------------
        // Method 3: Using Regular Expressions (Pattern & Matcher)
        // --------------------------------------------------
        // Useful for more advanced pattern matching (also works for plain substrings)
        Pattern p = Pattern.compile(Pattern.quote(pattern)); // Escapes regex characters if any
        Matcher m = p.matcher(s);
        boolean found = m.find(); // Returns true if pattern found
        System.out.println("3. Using regex Pattern & Matcher: " + found);

        // -------------------------------------------
        // Method 4: Manual substring matching (Brute Force)
        // -------------------------------------------
        // Checks each possible substring manually
        boolean manualFound = false;
        for (int i = 0; i <= s.length() - pattern.length(); i++) {
            String sub = s.substring(i, i + pattern.length()); // Extract substring
            if (sub.equals(pattern)) { // Compare with target
                manualFound = true;
                break;
            }
        }
        System.out.println("4. Manual substring matching: " + manualFound);
        
        // -------------------------------------------
        // Method 5: Using Stream
        // -------------------------------------------
        // Stream-based approach: simulate a sliding window over the string
        boolean found1 = IntStream.range(0, s.length() - pattern.length() + 1)
                .anyMatch(i -> s.substring(i, i + pattern.length()).equals(pattern));

        System.out.println("5. Using Stream (IntStream): " + found1);
    }
}
