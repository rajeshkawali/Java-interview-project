package com.rajeshkawali.program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparator {
	/*
	Suppose we have 2 identical files with the only difference being a 
	spelling mistake/ difference in one word between the 2 files,
	How can we find out this word?
	*/
	public static void main(String[] args) throws IOException {
		String file1 = "file1.txt";
		String file2 = "file2.txt";
		BufferedReader reader1 = new BufferedReader(new FileReader(file1));
		BufferedReader reader2 = new BufferedReader(new FileReader(file2));
		String line1 = reader1.readLine();
		String line2 = reader2.readLine();
		int lineNum = 1;
		while (line1 != null && line2 != null) {
			if (!line1.equals(line2)) {
				System.out.println("Difference found on line " + lineNum);
				System.out.println("File 1: " + line1);
				System.out.println("File 2: " + line2);
				break;
			}
			line1 = reader1.readLine();
			line2 = reader2.readLine();
			lineNum++;
		}
		reader1.close();
		reader2.close();
	}
}
/*
One way to find the difference between two identical files with only 
one word difference is to use a file comparison tool. 
There are many file comparison tools available such as 
WinMerge, Beyond Compare, and ExamDiff.
*/