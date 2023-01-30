package com.rajeshkawali.program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * @author Rajesh_Kawali
 * 
 */
public class FindDuplicateElementsInArrayUsing {

	public static void main(String[] args) {

		String[] inStr = { "abc", "abc", "raj", "esh", "jay", "esh", "jay" };
		int[] intNumber = { 2, 1, 6, 4, 3, 7, 8, 3, 2, 5, 3, 9, 1 };
		System.out.println("------------------------------------------------");
		findDuplicatesUsingSorting(intNumber);
		System.out.println("------------------------------------------------");
		findDuplicatesUsingHashSet(inStr);
		System.out.println("------------------------------------------------");
		findDuplicatesUsingJava8(intNumber);
		System.out.println("------------------------------------------------");
		findDuplicatesUsingHashMap(intNumber);
		System.out.println("------------------------------------------------");
		findDuplicatesUsingBruteForce(intNumber);
		System.out.println("------------------------------------------------");
	}

	private static void findDuplicatesUsingSorting(int[] inputArray) {
		Arrays.sort(inputArray);

		for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] == inputArray[i]) {
				System.out.println("Duplicate Element : " + inputArray[i]);
			}
		}
	}

	private static void findDuplicatesUsingHashSet(String[] inputArray) {
		HashSet<String> set = new HashSet<String>();
		for (String element : inputArray) {
			if (!set.add(element)) {
				System.out.println("Duplicate Element : " + element);
			}
		}
	}

	public static void findDuplicatesUsingJava8(int[] inputArray) {
		Set<Integer> uniqueElements = new HashSet<>();
		Set<Integer> duplicateElements = Arrays.stream(inputArray).filter(i -> !uniqueElements.add(i)).boxed()
				.collect(Collectors.toSet());
		System.out.println(duplicateElements);
	}

	public static void findDuplicatesUsingHashMap(int[] inputArray) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int element : inputArray) {
			if (map.get(element) == null) {
				map.put(element, 1);
			} else {
				map.put(element, map.get(element) + 1);
			}
		}
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.println("Duplicate Element : " + entry.getKey() + " - found " + entry.getValue() + " times.");
			}
		}
	}

	private static void findDuplicatesUsingBruteForce(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[i] == inputArray[j]) {
					System.out.println("Duplicate Element : " + inputArray[i]);
				}
			}
		}
	}
}
