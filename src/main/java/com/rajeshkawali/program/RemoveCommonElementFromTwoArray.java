package com.rajeshkawali.program;

import java.util.HashSet;
/**
 * @author Rajesh_Kawali
 * 
 */
public class RemoveCommonElementFromTwoArray {

	public static void main(String[] args) {

		String[] s1 = { "Rajesh", "Mohan", "Laksh", "Tiwari", "pankaj", "Tiwari" };
		String[] s2 = { "Sonu", "Mahesh", "Kiran", "Rajesh", "Keshav", "Tiwari" };

		HashSet<String> sh = new HashSet<>();
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				if (s1[i].equals(s2[j])) {
					sh.add(s1[i]);
				}
			}
		}
		System.out.println(sh);
	}
}
