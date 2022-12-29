package com.rajeshkawali.concepts.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Rajesh_Kawali
 *
 */
public class FileInputStreamExample {

	public static void main(String args[]) {
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("\\newfile.txt");
			int i = 0;
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fin != null) {
					fin.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error in closing the Stream");
			}
		}
	}
}
