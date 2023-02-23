package com.rajeshkawali.program;
/**
 * @author Rajesh_Kawali
 * 
 */
public class FactorialOfNumber {

	public static int factorial(int number) {
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		int factorial = factorial(5);
		System.out.println(factorial);
	}
}
/*
The FactorialOfNumber class has a method factorial() that takes an integer 
argument number and returns the factorial of that number. The method uses a 
for loop to calculate the factorial by iterating from 1 to the number and 
multiplying the current value with the previous factorial. The factorial of a 
number is the product of all positive integers from 1 to that number.

In the main() method, the factorial() method is called with the argument 5, 
and the result is printed on the console. In this case, the output will be 120, 
which is the factorial of 5.
*/