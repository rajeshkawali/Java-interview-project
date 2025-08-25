package com.rajeshkawali.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDigitLetterSymbolInString {

	public static void main(String[] args) {
	        String input = "a9#b3Z!k2X@";

	        // Convert to IntStream, then map to Character
	        List<Character> digits = input.chars()
	            .mapToObj(c -> (char) c)
	            .filter(Character::isDigit)
	            .sorted()
	            .collect(Collectors.toList());

	        List<Character> letters = input.chars()
	            .mapToObj(c -> (char) c)
	            .filter(Character::isLetter)
	            .sorted()
	            .collect(Collectors.toList());

	        List<Character> symbols = input.chars()
	            .mapToObj(c -> (char) c)
	            .filter(c -> !Character.isLetterOrDigit(c)) // non-alphanumeric
	            .sorted()
	            .collect(Collectors.toList());

	        // Output
	        System.out.println("Digits: " + digits);
	        System.out.println("Letters: " + letters);
	        System.out.println("Symbols: " + symbols);

	        // Combine all sorted
	        String sortedCombined = Stream.concat(
	                                    Stream.concat(digits.stream(), letters.stream()),
	                                    symbols.stream())
	                                .map(String::valueOf)
	                                .collect(Collectors.joining());

	        System.out.println("Sorted Combined: " + sortedCombined);
	        System.out.println("-------------------------------------------------------");
	        Map<String, List<Character>> grouped = input.chars()
	                .mapToObj(c -> (char) c)
	                .collect(Collectors.groupingBy(c -> {
	                    if (Character.isDigit(c)) return "Digit";
	                    else if (Character.isLetter(c)) return "Letter";
	                    else return "Symbol";
	                }));

	            System.out.println("Grouped Characters:");
	            grouped.forEach((key, list) -> System.out.println(key + ": " + list));
	        System.out.println("-------------------------------------------------------");
	        List<Character> digits1 = new ArrayList<>();
	        List<Character> letters1 = new ArrayList<>();
	        List<Character> symbols1 = new ArrayList<>();

	        for (char ch : input.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                digits1.add(ch);
	            } else if (Character.isLetter(ch)) {
	                letters1.add(ch);
	            } else {
	                symbols1.add(ch);
	            }
	        }

	        // Sort each list
	        Collections.sort(digits1);
	        Collections.sort(letters1);
	        Collections.sort(symbols1);

	        // Output
	        System.out.println("Digits: " + digits1);
	        System.out.println("Letters: " + letters1);
	        System.out.println("Symbols: " + symbols1);

	        // Combine all into one sorted string
	        StringBuilder result = new StringBuilder();
	        digits1.forEach(result::append);
	        letters1.forEach(result::append);
	        symbols1.forEach(result::append);

	        System.out.println("Sorted Combined: " + result);
	    }
	}