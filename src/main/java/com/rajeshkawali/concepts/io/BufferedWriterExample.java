package com.rajeshkawali.concepts.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rajesh_Kawali
 *
 */
public class BufferedWriterExample {
	public static void main(String[] args) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("\\output.txt"));
			writer.write("This is the first line of the file.");
			writer.newLine();
			writer.write("This is the second line of the file.");
			writer.newLine();
			writer.write("This is the third line of the file.");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.flush();
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
