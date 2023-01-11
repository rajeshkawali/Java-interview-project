package com.rajeshkawali.concepts.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputAndOutputExample {

	public static void main(String[] args) throws Exception {

		FileInputStream fin = new FileInputStream("inFile.ser");
		FileOutputStream fout = new FileOutputStream("outFile.ser");

		int i = 0;
		while ((i = fin.read()) != -1) {
			fout.write((byte) i);
		}
		fin.close();
		fout.close();
	}
}
