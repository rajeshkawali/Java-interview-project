package com.rajeshkawali.program;

import java.util.HashMap;

//Find duplicate elements in array without using Map.
public class FindDuplicateElementsInArray {

	public static void main(String[] args) {
		String[] strArray = { "abc", "xyz", "def", "mno", "pqr", "xyz", "def" };
		for (int i = 0; i < strArray.length - 1; i++) {
			for (int j = i + 1; j < strArray.length; j++) {
				if (strArray[i].equalsIgnoreCase(strArray[j])) {
					System.out.println(strArray[i]);
				}
			}
		}

		System.out.println("---------------------------------------------");
		//Find duplicate elements in array using Map.
		HashMap<String, Integer> hm = new HashMap<>();
		for (String string : strArray) {
			if (hm.containsKey(string)) {
				System.out.println(string);
				 //hm.put(string, hm.get(string)+1);
			} else {
				hm.put(string, 1);
			}
		}
		//System.out.println(hm);
	}
}
