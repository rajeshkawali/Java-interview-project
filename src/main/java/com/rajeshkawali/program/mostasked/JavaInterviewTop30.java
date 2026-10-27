package com.rajeshkawali.program.mostasked;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaInterviewTop30 {
	
	static class Employee {
		String name, department;
		int salary;

		Employee(String name, String department, int salary) {
			this.name = name;
			this.department = department;
			this.salary = salary;
		}

		public String toString() {
			return name + "=" + salary;
		}
	}

	public static void main(String[] args) {
		String s = "Java";
		System.out.println("1. Reverse String: " + new StringBuilder(s).reverse());
		String pal = "madam";
		System.out.println("2. Palindrome: " + pal.equals(new StringBuilder(pal).reverse().toString()));
		String dup = "programming";
		Map<Character, Long> charCount = dup.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("3. Duplicate characters: " + charCount.entrySet().stream().filter(e -> e.getValue() > 1)
				.map(e -> e.getKey().toString()).collect(Collectors.toList()));
		String banana = "banana";
		Map<Character, Long> freq = banana.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("4. Character frequency: " + freq);
		String swiss = "swiss";
		Map<Character, Long> swissFreq = swiss.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("5. First non-repeated: " + swissFreq.entrySet().stream().filter(e -> e.getValue() == 1)
				.map(Map.Entry::getKey).findFirst().orElse(null));
		String a = "listen", b = "silent";
		char[] aa = a.toCharArray(), bb = b.toCharArray();
		Arrays.sort(aa);
		Arrays.sort(bb);
		System.out.println("6. Anagrams: " + Arrays.equals(aa, bb));
		String sentence = "Java is fun";
		System.out.println("7. Reverse each word: " + Arrays.stream(sentence.split(" "))
				.map(w -> new StringBuilder(w).reverse().toString()).collect(Collectors.joining(" ")));
		String vowelsInput = "Interview".toLowerCase(Locale.ROOT);
		long vowels = vowelsInput.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
		long consonants = vowelsInput.chars().filter(c -> c >= 'a' && c <= 'z' && "aeiou".indexOf(c) < 0).count();
		System.out.println("8. Vowels and consonants: " + vowels + ", " + consonants);
		String repeated = "banana";
		System.out.println("9. Remove duplicate characters: "
				+ repeated.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining()));
		int[] arr = { 1, 2, 3, 2, 4, 3 };
		Set<Integer> seen = new HashSet<>(), duplicateNums = new LinkedHashSet<>();
		for (int x : arr)
			if (!seen.add(x))
				duplicateNums.add(x);
		System.out.println("10. Array duplicates: " + duplicateNums);
		int[] values = { 10, 40, 20, 30, 40 };
		OptionalInt second = Arrays.stream(values).distinct().sorted()
				.skip(Arrays.stream(values).distinct().count() - 2).findFirst();
		System.out.println("11. Second largest distinct: " + (second.isPresent() ? second.getAsInt() : "none"));
		int[] missing = { 1, 2, 4, 5 };
		int n = 5, sum = 0;
		for (int x : missing)
			sum += x;
		System.out.println("12. Missing number: " + (n * (n + 1) / 2 - sum));
		int[] extremes = { 7, 2, 9, 4 };
		int min = extremes[0], max = extremes[0];
		for (int x : extremes) {
			min = Math.min(min, x);
			max = Math.max(max, x);
		}
		System.out.println("13. Min and max: " + min + ", " + max);
		int[] sortable = { 5, 2, 4, 1 };
		for (int i = 0; i < sortable.length - 1; i++)
			for (int j = 0; j < sortable.length - 1 - i; j++)
				if (sortable[j] > sortable[j + 1]) {
					int t = sortable[j];
					sortable[j] = sortable[j + 1];
					sortable[j + 1] = t;
				}
		System.out.println("14. Bubble sort: " + Arrays.toString(sortable));
		int[] zeroes = { 0, 1, 0, 3, 12 };
		int write = 0;
		for (int x : zeroes)
			if (x != 0)
				zeroes[write++] = x;
		while (write < zeroes.length)
			zeroes[write++] = 0;
		System.out.println("15. Move zeroes: " + Arrays.toString(zeroes));
		int[] pairArray = { 2, 7, 11, 15 };
		int target = 9;
		Set<Integer> visited = new HashSet<>();
		List<String> pairs = new ArrayList<>();
		for (int x : pairArray) {
			if (visited.contains(target - x))
				pairs.add("(" + (target - x) + ", " + x + ")");
			visited.add(x);
		}
		System.out.println("16. Pair sum: " + pairs);
		int[] reverseArray = { 1, 2, 3, 4 };
		for (int l = 0, r = reverseArray.length - 1; l < r; l++, r--) {
			int t = reverseArray[l];
			reverseArray[l] = reverseArray[r];
			reverseArray[r] = t;
		}
		System.out.println("17. Reverse array: " + Arrays.toString(reverseArray));
		List<Integer> streamNums = Arrays.asList(1, 2, 2, 3, 3, 4);
		System.out.println("18. Stream distinct: " + streamNums.stream().distinct().collect(Collectors.toList()));
		Map<Integer, Long> streamFreq = streamNums.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("19. Stream duplicates: " + streamFreq.entrySet().stream().filter(e -> e.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toList()));
		String words = "java is fun java is java";
		System.out.println("20. Word frequency: " + Arrays.stream(words.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())));
		System.out.println("21. Stream second highest: "
				+ streamNums.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null));
		List<Employee> employees = Arrays.asList(new Employee("Asha", "IT", 60000), new Employee("Ravi", "HR", 45000),
				new Employee("Neha", "IT", 75000));
		Map<String, List<String>> byDept = employees.stream().collect(Collectors.groupingBy(e -> e.department,
				TreeMap::new, Collectors.mapping(e -> e.name, Collectors.toList())));
		System.out.println("22. Group employees: " + byDept);
		System.out.println("23. Employees by salary: " + employees.stream()
				.sorted(Comparator.comparingInt((Employee e) -> e.salary).reversed()).collect(Collectors.toList()));
		System.out.println("24. Stream first non-repeated: "
				+ swiss.chars().mapToObj(c -> (char) c).filter(c -> swissFreq.get(c) == 1).findFirst().orElse(null));
		int prime = 29;
		boolean isPrime = prime > 1;
		for (int i = 2; i <= prime / i; i++)
			if (prime % i == 0) {
				isPrime = false;
				break;
			}
		System.out.println("25. Prime: " + isPrime);
		int f0 = 0, f1 = 1;
		List<Integer> fibonacci = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			fibonacci.add(f0);
			int next = f0 + f1;
			f0 = f1;
			f1 = next;
		}
		System.out.println("26. Fibonacci: " + fibonacci);
		int factorialN = 5;
		long factorial = 1;
		for (int i = 2; i <= factorialN; i++)
			factorial *= i;
		System.out.println("27. Factorial: " + factorial);
		int armstrong = 153, temp = armstrong, digits = String.valueOf(armstrong).length(), cubeSum = 0;
		while (temp > 0) {
			int d = temp % 10;
			cubeSum += (int) Math.pow(d, digits);
			temp /= 10;
		}
		System.out.println("28. Armstrong: " + (cubeSum == armstrong));
		int x = 5, y = 9;
		x ^= y;
		y ^= x;
		x ^= y;
		System.out.println("29. Swap: " + x + ", " + y);
		System.out.println("30. Star pyramid:");
		for (int row = 1; row <= 4; row++) {
			for (int space = 4 - row; space > 0; space--)
				System.out.print(" ");
			for (int star = 0; star < 2 * row - 1; star++)
				System.out.print("*");
			System.out.println();
		}
	}
}

/*
1. Reverse String: avaJ
2. Palindrome: true
3. Duplicate characters: [r, g, m]
4. Character frequency: {b=1, a=3, n=2}
5. First non-repeated: w
6. Anagrams: true
7. Reverse each word: avaJ si nuf
8. Vowels and consonants: 4, 5
9. Remove duplicate characters: ban
10. Array duplicates: [2, 3]
11. Second largest distinct: 30
12. Missing number: 3
13. Min and max: 2, 9
14. Bubble sort: [1, 2, 4, 5]
15. Move zeroes: [1, 3, 12, 0, 0]
16. Pair sum: [(2, 7)]
17. Reverse array: [4, 3, 2, 1]
18. Stream distinct: [1, 2, 3, 4]
19. Stream duplicates: [2, 3]
20. Word frequency: {java=3, is=2, fun=1}
21. Stream second highest: 3
22. Group employees: {HR=[Ravi], IT=[Asha, Neha]}
23. Employees by salary: [Neha=75000, Asha=60000, Ravi=45000]
24. Stream first non-repeated: w
25. Prime: true
26. Fibonacci: [0, 1, 1, 2, 3, 5, 8, 13]
27. Factorial: 120
28. Armstrong: true
29. Swap: 9, 5
30. Star pyramid:
   *
  ***
 *****
*******
========================================================================================

*/


/*

String programs (1–9)
1. Reverse a String

Input: "Java" → Output: "avaJ"

Logic: StringBuilder.reverse() reverses the characters. In a manual solution, start at the last index and move backward until index zero.

Time: O(n) | Space: O(n)

Interview tip: Be prepared to reverse a String without using reverse().


2. Check palindrome String

Input: "madam" → Output: true

Logic: Reverse the String and compare it with the original using equals(). A palindrome reads identically forward and backward.

Time: O(n) | Space: O(n)

Optimization: Use two pointers, one at each end, to achieve O(1) auxiliary space.


3. Find duplicate characters

Input: "programming" → Output: [r, g, m]

Logic: Count characters using a LinkedHashMap. Filter entries with frequency greater than one. LinkedHashMap preserves first-appearance order.

Time: O(n) average | Space: O(k), where k is the number of distinct characters.


4. Count character frequency

Input: "banana" → Output: { b=1, a=3, n=2 }

Logic: Iterate through the characters and count occurrences. The Stream solution uses Collectors.groupingBy() and Collectors.counting().

Time: O(n) average | Space: O(k)


5. Find first non-repeated character

Input: "swiss" → Output: w

Logic: First count all characters. Then examine them in their original order and return the first character whose frequency equals one.

Time: O(n) average | Space: O(k)

Interview tip: A normal HashMap does not guarantee insertion order. Use LinkedHashMap or scan the original String again.


6. Check anagram Strings

Input: "listen", "silent" → Output: true

Logic: Convert both Strings to character arrays, sort them, and compare the sorted arrays. Anagrams contain the same characters with identical frequencies.

Time: O(n log n) | Space: O(n) for the character arrays.

Optimization: A character frequency array can achieve O(n) time for a fixed-size alphabet.


7. Reverse each word in a sentence

Input: "Java is fun" → Output: "avaJ si nuf"

Logic: Split the sentence into words, reverse each word separately, then join them with spaces. The word order remains unchanged.

Time: O(n) | Space: O(n)


8. Count vowels and consonants

Input: "Interview" → Output: 4, 5

Logic: Convert the text to lowercase. Check each English letter against a, e, i, o, u. Count matching letters as vowels and other alphabetic letters as consonants.

Time: O(n) | Space: O(n) for the lowercase String copy.

Optimization: A single loop over the original String can use O(1) auxiliary space.


9. Remove duplicate characters

Input: "banana" → Output: "ban"

Logic: chars().distinct() keeps the first occurrence of each character in encounter order. Convert each retained character back into a String and join them.

Time: O(n) average | Space: O(n)


Array programs (10–17)
10. Find duplicate elements in an array

Input: [1, 2, 3, 2, 4, 3] → Output: [2, 3]

Logic: Add each number to a HashSet. If add() returns false, the number already exists. Store duplicates in a LinkedHashSet to avoid printing the same duplicate multiple times.

Time: O(n) average | Space: O(n)


11. Find second largest number

Input: [10, 40, 20, 30, 40] → Output: 30

Logic: Remove duplicates, sort in ascending order, and select the second-last distinct element.

Time: O(n log n) | Space: O(n)

Optimization: Track the largest and second-largest distinct values in one pass for O(n) time and O(1) space. This is a common follow-up.


12. Find missing number

Input: [1, 2, 4, 5] → Output: 3

Logic: For numbers from 1 through N, calculate the expected sum using N*(N+1)/2. Subtract the actual array sum.

Time: O(n) | Space: O(1)

Assumption: Exactly one number is missing, with no duplicates. Use long for sums that may exceed the integer range.


13. Find minimum and maximum

Input: [7, 2, 9, 4] → Output: 2, 9

Logic: Initialize minimum and maximum with the first element. Compare each remaining element and update the appropriate value.

Time: O(n) | Space: O(1)


14. Sort an array without built-in sorting

Input: [5, 2, 4, 1] → Output: [1, 2, 4, 5]

Logic: Bubble Sort compares adjacent elements and swaps them when they are out of order. Each pass moves the largest remaining element toward the end.

Time: O(n²) worst case | Space: O(1)

Interview tip: Explain how Merge Sort or Quick Sort improves performance on large inputs.


15. Move all zeros to the end

Input: [0, 1, 0, 3, 12] → Output: [1, 3, 12, 0, 0]

Logic: Maintain a write index. Copy nonzero elements forward, preserving their relative order. Fill the remaining positions with zeros.

Time: O(n) | Space: O(1)


16. Find pairs with a given sum

Input: [2, 7, 11, 15], target 9 → Output: [(2, 7)]

Logic: For each element x, check whether target - x is already in a HashSet. If found, a valid pair exists. Otherwise, add x to the set.

Time: O(n) average | Space: O(n)

Interview tip: Clarify whether the interviewer wants one pair, all pairs, distinct value pairs, or index pairs. The provided example reports matches encountered during traversal.


17. Reverse an array

Input: [1, 2, 3, 4] → Output: [4, 3, 2, 1]

Logic: Use two pointers, left and right. Swap their elements and move both pointers inward until they meet.

Time: O(n) | Space: O(1)


Java 8 Streams programs (18–24)
18. Remove duplicates using Streams

Input: [1, 2, 2, 3, 3, 4] → Output: [1, 2, 3, 4]

Logic: stream().distinct() eliminates duplicate elements, preserving encounter order for an ordered Stream. Collect the results into a List.

Time: O(n) average | Space: O(n)


19. Find duplicate elements using Streams

Input: [1, 2, 2, 3, 3, 4] → Output: [2, 3]

Logic: Group numbers using groupingBy(), count them using counting(), and filter values with counts greater than one.

Time: O(n) average | Space: O(n)


20. Count word frequency using Streams

Input: "java is fun java is java"

Output: { java=3, is=2, fun=1 }

Logic: Split the sentence into words. Group identical words and count their occurrences. LinkedHashMap preserves the order of their first appearance.

Time: O(n) average | Space: O(n), where n is the input text length.


21. Find second highest number using Streams

Input: [1, 2, 2, 3, 3, 4] → Output: 3

Logic: Apply distinct(), sort in descending order, skip the largest value, and select the next value with findFirst().

Time: O(n log n) | Space: O(n)

Important: The second highest distinct number differs from the second element of a descending sorted List when duplicates exist.


22. Group employees by department

Input: Asha (IT), Ravi (HR), Neha (IT)

Output: { HR=[Ravi], IT=[Asha, Neha] }

Logic: Use Collectors.groupingBy() on the department field. Collectors.mapping() extracts employee names into Lists. The TreeMap sorts department names.

Time: O(n log d) | Space: O(n), where d is the number of departments.

Interview tip: Be able to explain groupingBy(), mapping(), and counting().


23. Sort employees by salary

Input: Asha ₹60,000, Ravi ₹45,000, Neha ₹75,000

Output: [Neha=75000, Asha=60000, Ravi=45000]

Logic: Use Comparator.comparingInt() to compare salaries. Apply reversed() to obtain descending order.

Time: O(n log n) | Space: O(n), including the resulting List.


24. Find first non-repeated character using Streams

Input: "swiss" → Output: w

Logic: First build a frequency map. Stream through the original characters, filter those with count one, and return the first match.

Time: O(n) average | Space: O(n)

Interview tip: findFirst() respects encounter order, unlike selecting an arbitrary entry from an unordered HashMap.


Number and pattern programs (25–30)
25. Check prime number

Input: 29 → Output: true

Logic: A prime number is greater than one and divisible only by one and itself. Check potential divisors from 2 through the square root of the number.

Time: O(√n) | Space: O(1)

Interview tip: Explain why checking divisors beyond √n is unnecessary.


26. Print Fibonacci series

Input: 8 terms

Output: [0, 1, 1, 2, 3, 5, 8, 13]

Logic: Start with 0 and 1. Each next number is the sum of the previous two. Update the pair in each iteration.

Time: O(n) | Space: O(n) for the output List, O(1) working space.


27. Find factorial

Input: 5 → Output: 120

Logic: Multiply all integers from 1 through n.
\[
5! = 5\times4\times3\times2\times1 = 120
\]

Time: O(n) | Space: O(1)

Interview tip: 0! = 1. A Java long cannot represent factorials greater than 20! exactly.


28. Check Armstrong number

Input: 153 → Output: true

Logic: Count the digits. Raise each digit to that count and add the results. Compare the sum with the original number.
\[
1^3 + 5^3 + 3^3 = 153
\]

Time: O(d) arithmetic operations | Space: O(d) in the provided implementation because of String conversion, where d is the digit count.

Interview tip: Handle zero, negative numbers, and numeric overflow explicitly in a production-ready implementation.


29. Swap two numbers without a third variable

Input: x=5, y=9 → Output: 9, 5

Logic: Use the XOR swap technique:

x ^= y;
y ^= x;
x ^= y;



Time: O(1) | Space: O(1)

Interview tip: XOR avoids arithmetic overflow. Explain that the variables must be separate storage locations.


30. Print star pyramid

Input: 4 rows

Output:

   *
  ***
 *****
*******



Logic: For each row i, print n-i leading spaces, followed by 2*i-1 stars. Use nested loops for rows, spaces, and stars.

Time: O(n²) | Space: O(1) auxiliary space when printing directly.

*/