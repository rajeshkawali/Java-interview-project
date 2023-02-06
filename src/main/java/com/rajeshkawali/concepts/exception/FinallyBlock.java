package com.rajeshkawali.concepts.exception;

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
