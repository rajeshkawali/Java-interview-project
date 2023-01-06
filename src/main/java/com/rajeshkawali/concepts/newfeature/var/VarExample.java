package com.rajeshkawali.concepts.newfeature.var;

import java.util.List;
import java.util.Map;
//var keyword, you can declare local variables without mentioning their type. 
//Compiler will automatically detects the type based on their initializers. 

//1) var works only when you initialize the variable explicitly. Because, compiler uses this initialization to determine the type of the variable. If you don’t initialize var variable, compiler shows the error.
//2) var is only for local variables. It is not allowed for global variables.
//3) You can’t use var as method parameters and return types.
//4) You can assign another value to var variable but it should be of same type, not of different type.
//5) You can’t initialize var variable with null. Because compiler will not be able to determine the type if you assign null.
//6) var is not a keyword. It is just a reserved type name like int, float etc.

/**
 * @author Rajesh_Kawali
 *
 */
public class VarExample {
	
	//var notAllowedInGlobal = 11; //'var' is not allowed here
	
	public static void main(String[] args) {

		//var nonInitialization; // Compile time error
		//var n = null; // Compile time error for local variable initialized to 'null'
		var i = 10; // int variable
		var d = 1.1; // double variable
		var c = 'C'; // char variable
		var b = true; // boolean variable
		var str = "string"; // String variable
		var list = List.of(1, 22, 333); // List variable
		var map = Map.of(1, "Java", 2, "Python", 3, "JavaScript"); // Map variable

		System.out.println(i);
		System.out.println(d);
		System.out.println(c);
		System.out.println(b);
		System.out.println(str);
		System.out.println(list);
		System.out.println(map);
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("<---Rules To Follow While Using var In Lambdas--->");
		System.out.println("Lambda parameters declared with var must be enclosed in parentheses ( ) even though there is only one parameter");
		// var s -> Integer.valueOf(s) //Compile time error
		// (var s) -> Integer.valueOf(s) // No Error

		System.out.println("Mixing var with other non-var parameters is not allowed. It has to be all var or no var");
		// (var m, int n) -> m * n //Compile Time Error
		// (var m, var n) -> m * n //No Error

		System.out.println("Using var for one parameter and skipping for other parameters is also not allowed");
		// (var m, n) -> m * n //Compile Time Error
		// (var m, var n) -> m * n //No Error

		System.out.println("As lambda parameters are also local variables, you can assume that var can also be used in lambdas just like below");
		// (var m, var n) -> m * n;
	}
}
/*
var is a reserved type name in Java that was introduced in Java 10(JDK). 
It is used to declare a local variable with an inferred type, which means 
that the type of the variable is determined by the compiler based on the value being assigned to it.


*/

/*
Here are some key points to consider when using var in Java:

var is a reserved type name that is used to declare a local variable with an inferred type.

The type of a var variable is determined by the compiler based on the value being assigned to it.

You can only use var to declare local variables, and you cannot use it to declare class fields, method parameters, or return types.

You cannot use var to declare a variable without an initializer, and you cannot use it with a primitive type.

Using var can make your code more concise and easier to read, especially when the type of a variable is long or complex.

It is important to use var judiciously, as it can make the type of a variable less explicit and potentially harder to understand.
*/