package com.rajeshkawali.concepts.newfeature.record;


/**
 * @author Rajesh_Kawali
 *
 */
record Point(int x, int y) {

	/*
	What is a Record?
	A record in Java is a special class introduced in Java 14 (preview), and finalized in Java 16. 
	It is designed to simplify the creation of immutable data carriers, like DTOs (Data Transfer Objects).
	 
	They are a concise way of creating simple, immutable data classes that represent records, 
	such as a point on a coordinate system or an account in a bank. Record classes have a 
	public accessor method for each component and also have a toString(), hashCode(), and equals() 
	method that is generated automatically based on the components of the record.
	*/
	public int xMethod() {
		return x;
	}

	public int yMethod() {
		return y;
	}

	public int multiply() {
		return x * x;
	}

	public int addition() {
		return x + y;
	}
}

public class RecordExample {
	public static void main(String[] args) {
		Point p1 = new Point(5, 2);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(5, 2);

		System.out.println(p1.xMethod()); // prints "5"
		System.out.println(p1.yMethod()); // prints "2"
		System.out.println(p1.addition()); // prints "7
		System.out.println(p1.multiply()); // prints "25"

		System.out.println(p1.equals(p2)); // prints "false"
		System.out.println(p1.equals(p3)); // prints "true"
		System.out.println(p1.toString()); // prints "Point[x=5, y=2]"
	}
}
/*
Some key points to consider when implementing a record class in Java:-->

1.A record is defined using the record keyword, with a name and a list of fields (called components).
→ Example: record Person(String name, int age) {}

2.Components are implicitly private and final. Records are immutable by default.

3.Java automatically provides: A constructor, Getters (named after the fields, e.g., person.name()) and 
toString(), equals(), and hashCode() methods

4.You cannot declare additional instance fields, but you can add methods, 
override generated methods, and add static fields/methods.

5.Records are implicitly final — they cannot be extended or subclassed.

6.Records cannot extend other classes, but they can implement interfaces.

7.You can write a compact constructor (called a canonical constructor) 
to validate or transform inputs, but you can't define your own fields outside of the record components.
*/



/*
============================================================
 Key Differences Between POJO and Record Classes in Java
============================================================

1. Mutability:
   - POJOs are typically mutable (fields can be changed via setters).
   - Records are immutable by default — their fields are implicitly final and cannot be changed after construction.

2. Accessors:
   - POJOs use traditional getter and setter methods (e.g., getName(), setName()).
   - Records automatically generate public accessor methods with the same name as the field (e.g., name()), but no setters.

3. Generated Methods:
   - POJOs require manual implementation or IDE-generated code for toString(), equals(), and hashCode().
   - Records automatically generate toString(), equals(), and hashCode() based on all components.

4. Class Structure:
   - POJOs can have custom fields, multiple constructors, methods, and can extend other classes.
   - Records define all fields (called components) in the record header and cannot define additional instance variables.
   - Records can include custom methods, static fields/methods, and compact constructors for validation.
   - Records cannot extend any other class (they implicitly extend java.lang.Record), but can implement interfaces.

5. Inheritance and Finality:
   - POJOs can be abstract, final, or non-final, and can be subclassed or extended.
   - Records are implicitly final — they cannot be abstract or extended.

6. Constructors:
   - POJOs can define multiple overloaded constructors.
   - Records automatically get a canonical constructor and allow custom or compact constructors for input validation, but these must only initialize declared components.

7. Serialization:
   - Both POJOs and records can implement Serializable.
   - Records, due to their immutability and simplicity, are often a better fit for safe and predictable serialization.

8. Immutability Enforcement:
   - POJO immutability is manual (requires final fields and no setters).
   - Record immutability is enforced by the language — all components are final and private.

9. Use Cases:
   - POJOs are suited for complex business logic, mutable models, and full control over structure.
   - Records are ideal for simple, immutable data carriers (e.g., DTOs, event messages, config objects) with minimal boilerplate.

============================================================
*/