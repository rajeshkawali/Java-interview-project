package com.rajeshkawali.concepts.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rajesh_Kawali
 *
 */
public class FileWriterAndFileReader {
	public static void main(String[] args) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		File iFile = new File("\\input.txt"); // Provide file path
		//iFile.createNewFile();
		File oFile = new File("\\output.txt"); // Provide file path
		//oFile.createNewFile();
		try {
			in = new FileReader(iFile);
			out = new FileWriter(oFile);

			int c = 0;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error in closing the Stream");
			}
		}
	}
}