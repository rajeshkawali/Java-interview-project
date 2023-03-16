package com.rajeshkawali.concepts.exception;
/**
 * @author Rajesh_Kawali
 *
 */
@SuppressWarnings("unused")
public class FinallyBlock {

	public static void main(String[] args) {
		method1();
		method2();
	}

	public static void method1() {
		try {
			// code that may throw an exception
			int result = 5 / 0;
		} catch (NumberFormatException e) { // ArithmeticException
			// code to handle the exception
			System.out.println("Cannot divide by zero!");
		} finally {
			// code that will be executed always
			System.out.println("Finally block in method1");
		}
	}

	public static void method2() {
		try {
			// code that may throw an exception
			int result = 5 / 0;
		} catch (ArithmeticException e) { //If we use "Exception" here than we get below compile time error
			// code to handle the exception
			System.out.println("Cannot divide by zero!");
		} catch (NumberFormatException e) { //Unreachable catch block for NumberFormatException. It is already handled by the catch block for Exception
			// code to handle the exception
			System.out.println("Cannot divide by zero!");
		} catch (Exception e) { //Unreachable catch block for ArithmeticException. It is already handled by the catch block for Exception
			// code to handle the exception
			System.out.println("Cannot divide by zero!");
		} finally {
			// code that will be executed always
			System.out.println("Finally block in method1");
		}
	}
}
/*
In Java, try-catch-finally blocks are used to handle exceptions that might occur during program execution. 
Here are the basic rules for using try-catch-finally:-->

1.A try block must be followed by either a catch or finally block, or both.

2.A catch block must immediately follow the try block, and it must specify the type of 
exception it can handle using the catch keyword followed by the exception type in parentheses. 
It can also specify a variable name to refer to the exception object.

3.Multiple catch blocks can be used to handle different types of exceptions, 
but they must be ordered from most specific to least specific. 
If a catch block handles a more general exception type before a more specific type, 
it will catch the more specific exception too.

4.A finally block is optional, but if it is present, it will be 
executed after the try and catch blocks, regardless of whether an exception was thrown or not.

5.A finally block is typically used to clean up resources that were acquired in the try block, 
such as closing files or network connections.

6.The code in the finally block will execute even if a return statement is 
encountered in the try or catch blocks.

7.If an exception is thrown in the try block and not caught by any of the catch blocks, 
the finally block will still be executed before the exception is propagated up the call stack.

8.If a method throws a checked exception, the caller must either handle the exception 
using a try-catch block or declare the exception in the method signature using the throws keyword. 
Unchecked exceptions, such as NullPointerException or ArrayIndexOutOfBoundsException, do not need to be declared or caught.

9.If a catch block does not need to use the exception object, you can use the catch keyword 
followed by an empty pair of parentheses, like this: catch () { // handle the exception  }. 
This is useful if you want to catch an exception but do not need to take any action based on the exception object itself.

10.The try block can contain multiple statements or blocks, separated by braces {}. 
This allows you to group related code together and apply exception handling to the entire block. 

*/