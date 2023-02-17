package com.rajeshkawali.concepts.exception;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
/**
 * @author Rajesh_Kawali
 *
 */
public class TryWithResources {
	/*
	 * The try and catch blocks in Java are used for exception handling, allowing
	 * you to handle errors and unexpected conditions in your code. The try block
	 * contains the code that might throw an exception, and the catch block catches
	 * any exceptions that are thrown and handles them.
	 * 
	 * The try block can also be followed by a finally block, which contains code
	 * that will be executed whether or not an exception is thrown.
	 * 
	 * The try-with-resources statement is a try statement that declares one or more
	 * resources, such as objects that implement the AutoCloseable interface, and
	 * automatically closes these resources when the try block is exited.
	 */
	public static void main(String[] args) {
		// Try block to check for exceptions
		// Writing data to a file using FileOutputStream by passing input file as a parameter
		try (FileOutputStream fos = new FileOutputStream("outputfile.txt");
				// Reading the stream of character from
				BufferedReader br = new BufferedReader(new FileReader("gfgtextfile.txt"))) {
			// Declaring a string holding the stream content of the file
			String text;
			// Condition check using readLine() method which holds true till there is content in the input file
			while ((text = br.readLine()) != null) {
				// Reading from input file passed above using getBytes() method
				byte arr[] = text.getBytes();
				// String converted to bytes
				fos.write(arr);
				// Copying the content of passed input file 'inputgfgtext' file to outputfile.txt
			}
			// Display message when file is successfully copied
			System.out.println("File content copied to another one.");
		}
		// Catch block to handle generic exceptions
		catch (Exception e) {
			System.out.println(e);
		}
		// Display message for successful execution of the program
		System.out.println("Resource are closed and message has been written into the gfgtextfile.txt");
	}
}
/*
Here are some key points about the try and try-with-resources statements in Java:-->

The try and catch blocks are used for exception handling in Java, allowing you to handle errors and unexpected conditions in your code.
The finally block contains code that will be executed whether or not an exception is thrown.
The try-with-resources statement is a try statement that declares one or more resources and automatically closes these resources when the try block is exited.
The resources declared in a try-with-resources statement must implement the AutoCloseable interface.
The try-with-resources statement helps to simplify the code and avoid resource leaks by automatically closing resources when the try block is exited.
You can have multiple resources declared in a try-with-resources statement, and each resource will be closed in the reverse order from which it was declared.
In general, the try-with-resources statement is a powerful and convenient way to handle resources in Java, and it is recommended to use it whenever possible to simplify your code and prevent resource leaks.
*/