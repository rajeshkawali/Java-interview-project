package com.rajeshkawali.program;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


// Print the word count map for each sublist, including both duplicates and non-duplicates
public class WordCountPerSublist {
    public static void main(String[] args) {

        // Sample input: list of lists (e.g., each sublist could represent a book, sentence, or document)
        List<List<String>> wordsPerBook = Arrays.asList(
            Arrays.asList("My", "team", "is", "Orange", "Orange", "fruit"),
            Arrays.asList("team", "team", "fruit", "fruit", "fruit"),
            Arrays.asList("Orange", "Orange", "Orange", "team", "fruit")
        );

        // -------------------- Version 1: Using for-loop --------------------

        // Process each sublist using traditional for-loop
        for (int i = 0; i < wordsPerBook.size(); i++) {
            // Get the current sublist
            List<String> wordList = wordsPerBook.get(i);

            // Count all words in this sublist using groupingBy and counting
            Map<String, Long> wordCountMap = wordList.stream()
                .collect(Collectors.groupingBy(
                    Function.identity(),        // group by the word itself
                    Collectors.counting()       // count each word
                ));

            // Format the wordCountMap as a custom string like: (key=Orange, value=2)
            String formatted = wordCountMap.entrySet().stream()
                .map(e -> "(key=" + e.getKey() + ", value=" + e.getValue() + ")")
                .collect(Collectors.joining(", "));

            // Print the formatted result with key number (starting from 1)
            System.out.println("key " + (i + 1) + " -> Map(" + formatted + ")");
        }

        System.out.println("-----------------------------------------------------------------");

        // -------------------- Version 2: Stream-only version --------------------

        // Use IntStream.range to simulate index-based loop using streams
        IntStream.range(0, wordsPerBook.size())
            .mapToObj(i -> {
                // Get the i-th sublist
                List<String> wordList = wordsPerBook.get(i);

                // Count occurrences of each word in the current sublist
                Map<String, Long> wordCountMap = wordList.stream()
                    .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                    ));

                // Format the wordCountMap entries as strings
                String formatted = wordCountMap.entrySet().stream()
                    .map(e -> "(key=" + e.getKey() + ", value=" + e.getValue() + ")")
                    .collect(Collectors.joining(", "));

                // Return the full formatted string for this sublist
                return "key " + (i + 1) + " -> Map(" + formatted + ")";
            })
            // Print each formatted result
            .forEach(System.out::println);
    }
}

