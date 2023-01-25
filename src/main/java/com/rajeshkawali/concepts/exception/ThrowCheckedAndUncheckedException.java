package com.rajeshkawali.concepts.exception;

import java.io.File;
import java.io.FileNotFoundException;

@SuppressWarnings("unused")
public class ThrowCheckedAndUncheckedException {

	
	public static void main(String[] args) {
		System.out.println("Start...");
		if (true) {
			throw new NullPointerException();
			// throw new ClassNotFoundException(); // Unhandled exception type ClassNotFoundException
		}
		System.out.println("End...");
	}
	
	public void readFile(String fileName) throws FileNotFoundException { // For Checked exception it is compulory to use throws with signature.
	    File file = new File(fileName);
	    if (!file.exists()) {
	        throw new FileNotFoundException("The file " + fileName + " does not exist.");
	    }
	    // code to read the file
	}
	
	public void multiply(int a, int b) {// For UnChecked exception it is not compulory to use throws with signature.
	    if (b == 0 && a == 0) {
	        throw new ArithmeticException("Cannot multiply by zero's.");
	    }
	    int result = a * b;
	    // code to use the result
	} 
	
	public void divide(int a, int b) throws ArithmeticException {// For UnChecked exception it is not compulory to use throws with signature.
	    if (b == 0) {
	        throw new ArithmeticException("Cannot divide by zero.");
	    }
	    int result = a / b;
	    // code to use the result
	} 
	//In this example, the divide method takes two integers as arguments and divides the first argument by the second. If the second argument is zero, it throws a new instance of the ArithmeticException with a custom error message. 
	//Since the ArithmeticException is an unchecked exception, the method does not need to handle it or declare it in the method signature.

}
/*
In the above code snippet, the main method starts by printing "Start...", 
then it uses an if statement to check if the condition is true. 
Inside the if statement, there is a throw statement that throws a new instance of the 
NullPointerException. Since the condition is true, the throw statement will be executed, 
and the program will stop executing the rest of the code in the main method. As a result, 
the "End..." message will not be printed.

It's worth noting that in this case, the program will not terminate immediately 
after throwing the exception, but it will go through the process of looking for 
an appropriate exception handler to handle the exception. If it doesn't find any, 
the program will terminate and the exception will be printed to the console.

Also, if you try to use throw new ClassNotFoundException(); it will throw an error 
because the ClassNotFoundException is a checked exception and it should be handled or 
declared in the method signature using the throws keyword.
*/