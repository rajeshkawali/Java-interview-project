package com.rajeshkawali.concepts.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * @author Rajesh_Kawali
 *
 */
@SuppressWarnings("unused")
public class ExceptionHandlingTypesMain {
	/*
	Exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions. 
	Exceptions are typically used to handle errors or exceptional conditions that are not 
	expected to occur during normal program execution. When an exception is thrown, 
	the program's normal flow of control is interrupted and the program jumps to an 
	exception handler that is designed to handle the exception. Java provides a built-in 
	exception handling mechanism that allows developers to handle exceptions 
	in a structured and consistent manner.
	
	In Java, exception handling is used to handle errors and exceptional conditions that 
	may occur during the execution of a program. The basic structure of exception 
	handling in Java is the try-catch-finally block.

	The try block is used to enclose the code that may throw an exception. 
	If an exception is thrown within the try block, the program jumps to the catch block, 
	where the exception can be handled. The catch block takes a parameter, 
	which is the type of exception that it can handle.
	*/
	public void method1() {
		try {
			// code that may throw an exception
			int result = 5 / 0;
		} catch (ArithmeticException e) {
			// code to handle the exception
			System.out.println("Cannot divide by zero!");
		} finally {
			// code that will be executed always
			System.out.println("Finally block in method1");
		}
	}

	public int method2() {
		int data = 0;
		try {
			data = readDataFromFile();
		} catch (IOException e) {
			System.out.println("Error reading data from file: " + e.getMessage());
			return -1;
		} finally {
			closeFile();
		}
		return data;
	}

	public void method3() {
		try {
			// code that may throw an exception
			int[] numbers = new int[5];
			numbers[10] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			// code to handle the exception
			System.out.println("Array index out of bounds!");
		}
	}

	public void method4() throws FileNotFoundException, IOException {
		// code that may throw an exception
		FileInputStream fis = new FileInputStream("file.txt");
		int data = fis.read();
		fis.close();
	}

	public void method5() {
		try (FileInputStream fis = new FileInputStream("file.txt")) {
			// code that uses the FileInputStream
			int data = fis.read();
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

	private int readDataFromFile() throws IOException {
		// code that reads data from a file
		return 0;
	}

	private void closeFile() {
		// code that closes a file
	}
}
/*
In this example, the class has five methods: method1, method2, method3, method4, method5. 
Method1 has a try-catch-finally block where the try block has code that may throw an exception, 
the catch block handles the exception, and the finally block is executed always. 
Method2 has a try-catch-finally block where the try block reads data from a file, 
the catch block handles any exceptions that might be thrown, and the finally block closes the file. 
Method3 has a try-catch block where the try block has code that may throw an 
exception and the catch block handles the exception. Method4 has throws keyword in 
method signature to indicate that the method might throw certain exceptions. 
Method5 has a try-with-resources block that automatically closes the file when the block is exited.

It's worth noting that the best practice is to catch exceptions that you can handle and 
throw it up to the calling method, as shown in method4 and method5.
*/


/*
There are two types of exceptions in Java: checked exceptions and unchecked exceptions:-->

Checked exceptions:- These are exceptions that are checked at compile-time. 
Classes that extend the Exception class (except for RuntimeException and its subclasses) 
are checked exceptions. Examples of checked exceptions include IOException, SQLException, etc.

Unchecked exceptions:- These are exceptions that are not checked at compile-time. 
Classes that extend the RuntimeException class are unchecked exceptions. 
Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, etc.

It's important to note that Error and its subclasses are also unchecked exceptions. 
These are serious exceptions that are typically thrown by the Java Virtual Machine (JVM) and 
should not be caught or handled by the application.
--------------------------------------------------------------------------------------------------
Checked Exceptions:-->
IOException: This exception is thrown when an input/output operation fails, for example, when trying to read a file that doesn't exist.
SQLException: This exception is thrown when an error occurs while interacting with a database.
FileNotFoundException: This exception is thrown when a specified file could not be found on the file system.

Unchecked Exceptions:-->
NullPointerException: This exception is thrown when a null value is used where an object is required.
ArrayIndexOutOfBoundsException: This exception is thrown when an array is accessed with an index that is out of its range.
IllegalArgumentException: This exception is thrown when a method is passed an illegal or inappropriate argument.
ArithmeticException: This exception is thrown when an exceptional arithmetic condition has occurred, for example, dividing by zero.

*/



/*
It's also worth noting that there are some other important concepts related to exception handling in Java, such as:-->

Custom exceptions: You can create your own custom exception classes by extending the Exception or RuntimeException classes. This allows you to define your own exception types and handle them in a specific way.

Exception chaining: When an exception is thrown, it can include information about the exception that caused it. This is known as exception chaining, and it allows you to trace the cause of an exception.

Logging: Logging is an important aspect of exception handling, as it allows you to capture detailed information about exceptions, such as the stack trace, and use it for debugging or troubleshooting.

Best practices: It's important to follow some best practices when working with exceptions in Java, such as: Avoid using exceptions for flow control, don't catch exceptions you can't handle, and use specific exception types where possible.

Exception handling is an important aspect of programming, and it's important to understand how to use try-catch-finally blocks, throws and throw keyword, and try-with-resources statement in Java to effectively handle exceptions in your code.

Finally, it's also important to remember that exceptions should be used for exceptional conditions, not for normal program flow. It's a best practice to use other control structures such as conditional statements to handle expected conditions, and only use exceptions for unexpected or error conditions.
*/

/*
In Java, there is a hierarchy of exception classes, which allows you to handle exceptions at 
different levels of abstraction. 

At the top of the hierarchy is the Throwable class, which has two immediate subclasses: Error and Exception.

Error and its subclasses are used to indicate severe, unrecoverable problems that typically result in the termination of the program. Examples of errors include OutOfMemoryError, StackOverflowError, and VirtualMachineError.

Exception and its subclasses are used to indicate less severe problems that can often be handled by the program. Examples of exceptions include IOException, SQLException, and NullPointerException.

Exception has two main subclasses: RuntimeException and checked exceptions.

RuntimeException and its subclasses are used to indicate programming errors or other unexpected conditions that should be fixed by the developer. Examples include NullPointerException, ArrayIndexOutOfBoundsException, and IllegalArgumentException. These exceptions are called unchecked exceptions, because they do not need to be declared or caught explicitly.

Checked exceptions are any exception that is not a RuntimeException or one of its subclasses. These exceptions must be either caught by the calling method or declared in the method's signature using the throws keyword. Examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.
*/