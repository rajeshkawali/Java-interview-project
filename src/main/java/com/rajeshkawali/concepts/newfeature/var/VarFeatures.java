package com.rajeshkawali.concepts.newfeature.var;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * ===============================================================
 * var (Local Variable Type Inference) - Java 10
 * ===============================================================
 *
 * Definition:
 * var allows the Java compiler to automatically infer the type
 * of a local variable from its initializer.
 *
 * Introduced:
 * - Java 10
 *
 * Lambda Support:
 * - Java 11
 *
 * Advantages:
 * ✔ Reduces boilerplate code.
 * ✔ Improves readability.
 * ✔ Useful with complex generic types.
 * ✔ Compiler still performs type checking.
 *
 * Note:
 * ✔ var is NOT a keyword.
 * ✔ var is a reserved type name.
 * ✔ Java is still statically typed.
 * ✔ The inferred type is fixed at compile time.
 */
/**
 * @author Rajesh_Kawali
 *
 */
public class VarFeatures {

	// ==========================================================
	// NOT ALLOWED
	// ==========================================================

	// var global = 10;
	// Compile-time Error:
	// 'var' can only be used for local variables.

	public static void main(String[] args) {

		// ==========================================================
		// 1. Basic Examples
		// ==========================================================

		var id = 101; // int
		var salary = 55000.75; // double
		var grade = 'A'; // char
		var active = true; // boolean
		var name = "Rajesh"; // String

		System.out.println(id);
		System.out.println(salary);
		System.out.println(grade);
		System.out.println(active);
		System.out.println(name);

		// ==========================================================
		// 2. Generic Collections
		// ==========================================================

		var languages = new ArrayList<String>();

		languages.add("Java");
		languages.add("Spring");
		languages.add("Hibernate");

		System.out.println(languages);

		var list = List.of(10, 20, 30);

		var map = Map.of(
				1, "Java",
				2, "Python",
				3, "Spring");

		System.out.println(list);
		System.out.println(map);

		// ==========================================================
		// 3. Arrays
		// ==========================================================

		var numbers = new int[] { 10, 20, 30 };

		for (var number : numbers) {
			System.out.println(number);
		}

		// ==========================================================
		// 4. Anonymous Object
		// ==========================================================

		var object = new Object();

		System.out.println(object.getClass().getSimpleName());

		// ==========================================================
		// 5. var in Traditional for Loop
		// ==========================================================

		for (var i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		// ==========================================================
		// 6. var in Enhanced for Loop
		// ==========================================================

		for (var language : languages) {
			System.out.println(language);
		}

		// ==========================================================
		// 7. Type Inference
		// ==========================================================

		var value = 100;

		System.out.println(value);

		// value = "Java";
		// Compile-time Error:
		// The inferred type cannot be changed.

		// ==========================================================
		// 8. Initialization Rules
		// ==========================================================

		// var x;
		// Compile-time Error:
		// Local variables declared with var must be initialized.

		// var n = null;
		// Compile-time Error:
		// Compiler cannot infer the type from null.

		// ==========================================================
		// 9. var with Method Calls
		// ==========================================================

		var text = "java programming";

		var upperCase = text.toUpperCase();

		System.out.println(upperCase);

		// ==========================================================
		// 10. var with Complex Generic Types
		// ==========================================================

		var employeeMap = Map.of(
				101, List.of("Java", "Spring"),
				102, List.of("Python", "Django"));

		System.out.println(employeeMap);

		// ==========================================================
		// 11. Lambda Parameters (Java 11)
		// ==========================================================

		/*
		 * Lambda parameters declared with 'var' must always be enclosed
		 * in parentheses.
		 */

		// var s -> s.length();
		// Compile-time Error

		// (var s) -> s.length();
		// Valid

		/*
		 * Mixing 'var' with explicit types is NOT allowed.
		 */

		// (var a, int b) -> a + b;
		// Compile-time Error

		// (var a, var b) -> a + b;
		// Valid

		/*
		 * Mixing 'var' with omitted parameter types is also NOT allowed.
		 */

		// (var a, b) -> a + b;
		// Compile-time Error

		// (var a, var b) -> a + b;
		// Valid

		// ==========================================================
		// 12. Where var CANNOT be Used
		// ==========================================================

		/*
		 * Instance Variable
		 */

		// var age = 20;
		// Compile-time Error

		/*
		 * Static Variable
		 */

		// static var count = 100;
		// Compile-time Error

		/*
		 * Method Parameter
		 */

		// public void display(var id){}
		// Compile-time Error

		/*
		 * Return Type
		 */

		// public var getName(){}
		// Compile-time Error

		/*
		 * Catch Block
		 */

		/*
		try {

		} catch (var e) {

		}
		*/

		// Compile-time Error

		// ==========================================================
		// 13. Runtime Type
		// ==========================================================

		var city = "Mumbai";

		System.out.println(city.getClass().getSimpleName());

		var integerList = List.of(1, 2, 3);

		System.out.println(integerList.getClass().getSimpleName());

		// ==========================================================
		// Interview Summary
		// ==========================================================

		/*
		 * Q. Which Java version introduced var?
		 * A. Java 10.
		 *
		 * Q. Which Java version added lambda support?
		 * A. Java 11.
		 *
		 * Q. Is var a keyword?
		 * A. No. It is a reserved type name.
		 *
		 * Q. Does var make Java dynamically typed?
		 * A. No. Java is still statically typed.
		 *
		 * Q. Can var be initialized with null?
		 * A. No.
		 *
		 * Q. Can var be used for instance variables?
		 * A. No.
		 *
		 * Q. Can var be used as a method parameter?
		 * A. No.
		 *
		 * Q. Can var be used as a return type?
		 * A. No.
		 *
		 * Q. Can var be used in for loops?
		 * A. Yes.
		 *
		 * Q. Can var be used in enhanced for loops?
		 * A. Yes.
		 *
		 * Q. Can var be used in lambda parameters?
		 * A. Yes (Java 11).
		 */

		// ==========================================================
		// Memory Trick
		// ==========================================================

		/*
		 * var = Local Variables Only
		 *
		 * ✔ Local Variables
		 * ✔ for Loop
		 * ✔ Enhanced for Loop
		 * ✔ Lambda Parameters (Java 11)
		 *
		 * ✘ Instance Variable
		 * ✘ Static Variable
		 * ✘ Method Parameter
		 * ✘ Return Type
		 * ✘ Catch Parameter
		 * ✘ Null Initialization
		 */
	}
}