package com.rajeshkawali.program;
import java.util.*;

/**
 * Question:
 * 
 * Given a list of books, where each book is represented as a List<String> containing words,
 * we want to collect the count of occurrences of each word per book.
 * 
 * Example:
 * 
 * Input:
 * List<List<String>> wordsPerBook = Arrays.asList(
 *     Arrays.asList("My", "team", "is", "Orange", "Orange", "fruit"),
 *     Arrays.asList("team", "team", "fruit", "fruit", "fruit"),
 *     Arrays.asList("Orange", "Orange", "Orange", "team", "fruit")
 * );
 * 
 * Output:
 * {
 *   "My":     [1, 0, 0],
 *   "team":   [1, 2, 1],
 *   "is":     [1, 0, 0],
 *   "Orange": [2, 0, 3],
 *   "fruit":  [1, 3, 1]
 * }
 * 
 * We use Map<String, List<Integer>> to represent:
 *   - Each unique word as a key.
 *   - A list of counts per book (aligned by book index) as the value.
 */

public class WordOccurrencesPerBook {

    public static Map<String, List<Integer>> countWordOccurrences(List<List<String>> wordsPerBook) {
        Map<String, List<Integer>> wordCounts = new HashMap<>();

        for (int i = 0; i < wordsPerBook.size(); i++) {
            List<String> book = wordsPerBook.get(i);
            Map<String, Integer> localCount = new HashMap<>();

            // Count frequency of each word in this book
            for (String word : book) {
                localCount.put(word, localCount.getOrDefault(word, 0) + 1);
            }

            // Update global wordCounts map
            for (Map.Entry<String, Integer> entry : localCount.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();

                // Initialize list of counts for this word if not already present
                wordCounts.putIfAbsent(word, new ArrayList<>(Collections.nCopies(wordsPerBook.size(), 0)));

                // Set the count at the index corresponding to the current book
                wordCounts.get(word).set(i, count);
            }
        }

        return wordCounts;
    }

    // Sample main method to test
    public static void main(String[] args) {
        List<List<String>> wordsPerBook = Arrays.asList(
            Arrays.asList("My", "team", "is", "Orange", "Orange", "fruit"),
            Arrays.asList("team", "team", "fruit", "fruit", "fruit"),
            Arrays.asList("Orange", "Orange", "Orange", "team", "fruit")
        );

        Map<String, List<Integer>> result = countWordOccurrences(wordsPerBook);

        // Print the result
        for (Map.Entry<String, List<Integer>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
