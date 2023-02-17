package com.rajeshkawali.concepts.exception;
/**
 * @author Rajesh_Kawali
 *
 */
public class ReturnValueFromTryCatchFinally {
	public static void main(String[] args) {
		System.out.println(methodReturningValue());
	}

	static int methodReturningValue() {
		try {
			return 10;
		} catch (Exception e) {
			return 20;
		} finally {
			// Now, This block may or may not return a value
			// as both try and catch blocks are returning a value
		}
	}
}
/*
In the above code snippet, the main method calls the methodReturningValue() method, 
which returns an integer value. Inside the methodReturningValue(), there is a try-catch block. 
The try block contains a return statement that returns the value 10. 
The catch block also contains a return statement that returns the value 20. 
Finally, there is a finally block which does not contain a return statement.

When the try block is executed, it immediately returns the value 10, and the rest of the method, 
including the catch and finally blocks, is skipped. Therefore, the value 10 is returned to the 
main method and printed to the console.

In this case, the finally block does not have any effect on the return value of the method, 
because both the try and catch blocks have already returned a value. It's worth noting that, 
in general, it's not a good practice to include a return statement in the finally block 
because it can make the code harder to understand and maintain.

It's also worth noting that it's possible to return a value from the finally block, 
but you have to be careful about the value returned, since the finally block is executed 
after the try and catch blocks, so the value returned from the try or catch block will be overridden by the finally block.

*/