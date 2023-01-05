package com.rajeshkawali.concepts.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rajesh_Kawali
 *
 */
public class FileOutputStreamExample {
	public static void main(String args[]) {
		FileOutputStream fout = null;
		try {
			String fileName = new SimpleDateFormat("'MyFile_'dd_MM_yyyy_HH_mm'.txt'").format(new Date());
			File file = new File(fileName); // Provide file path
			fout = new FileOutputStream(file);
			String s = "Welcome to java";
			if (!file.exists()) { // check if file doesn't exist then create new file
				file.createNewFile();
			}
			byte b[] = s.getBytes();// converting string into byte array
			fout.write(b);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fout != null) {
					fout.close();
					System.out.println("success...");
				}
			} catch (IOException ioe) {
				System.out.println("Error in closing the Stream");
			}
		}
	}
}