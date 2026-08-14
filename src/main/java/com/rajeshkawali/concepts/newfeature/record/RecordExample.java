package com.rajeshkawali.concepts.newfeature.record;


/**
 * @author Rajesh_Kawali
 *
 */
record Point(int x, int y) {

	/*
	What is a Record?
	A Record is a special type of class in Java introduced to represent immutable data.
	 
	It automatically generates common methods such as the constructor, accessor methods, 
	equals(), hashCode(), and toString(), reducing boilerplate code.
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
What is a Record in Java?

A Record is a special type of class introduced in Java 16 (preview in Java 14) that is used to store immutable data.

It automatically generates:

-->Constructor
-->Getters (called accessor methods)
-->toString()
-->equals()
-->hashCode()

This reduces boilerplate code.
*/


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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
| POJO Class                                                                                | Record Class                                                                                       |
| ----------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| Regular Java class used to represent objects.                                             | Special class introduced in Java 16 to represent immutable data.                                   |
| Can be mutable or immutable.                                                              | Immutable by default.                                                                              |
| Requires manual constructor, getters/setters, `equals()`, `hashCode()`, and `toString()`. | Automatically generates constructor, accessor methods, `equals()`, `hashCode()`, and `toString()`. |
| Can have setter methods.                                                                  | No setter methods.                                                                                 |
| Can declare additional instance fields.                                                   | Cannot declare additional instance fields.                                                         |
| Can extend another class.                                                                 | Cannot extend another class (extends `java.lang.Record`).                                          |
| Can be inherited (unless declared `final`).                                               | Implicitly `final`; cannot be inherited.                                                           |
| Best for objects with business logic and mutable state.                                   | Best for DTOs, Value Objects, and immutable data holders.                                          |
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
============================================================
*/


/*
==========================
Records in Java (Java 16)
==========================

Definition:
- A Record is a special type of class used to represent immutable data.
- It automatically generates the constructor, accessor methods, equals(), hashCode(), and toString().

Syntax:
record Employee(int id, String name) {}
--------------------------------------------------
Key Points

1. Introduced in Java 16 (Preview in Java 14).
2. Used to create immutable data classes with less boilerplate code.
3. Record components are implicitly:
   - private
   - final
4. Java automatically generates:
   - Canonical constructor
   - Accessor methods (id(), name())
   - equals()
   - hashCode()
   - toString()
5. Records are immutable by default.
   - No setter methods.
   - State cannot be changed after object creation.
6. Records are implicitly final.
   - Cannot be extended or inherited.
7. Every Record implicitly extends java.lang.Record.
8. Records cannot extend another class.
9. Records can implement one or more interfaces.
10. Records can contain:
    - Instance methods
    - Static methods
    - Static fields
    - Static initialization blocks
11. Records cannot declare additional instance fields.
    - Only record components are allowed as instance fields.
12. You can define your own:
    - Compact (Canonical) constructor
    - equals()
    - hashCode()
    - toString()
13. Compact constructor is mainly used for:
    - Validation
    - Input normalization
14. Accessor methods are generated automatically.
    Example:
    Employee emp = new Employee(101, "John");

    emp.id();
    emp.name();
15. Record components are final, but if a component is a mutable object
    (List, Map, Set, etc.), its contents can still be modified unless
    defensive copies are used.
16. Records reduce boilerplate code and improve readability.
--------------------------------------------------
Advantages:
1. Less boilerplate code.
2. Immutable by default.
3. Auto-generated methods.
4. Easy to read and maintain.
5. Good for thread-safe data objects.
6. Ideal for DTOs and Value Objects.
--------------------------------------------------
Limitations

1. Cannot extend another class.
2. Cannot be subclassed.
3. Cannot have additional instance fields.
4. Not suitable for mutable objects.
5. Not suitable for classes with complex business logic.
--------------------------------------------------
Best Use Cases

- DTO (Data Transfer Object)
- Value Object
- API Request/Response
- Configuration Objects
- Immutable Data Holders
--------------------------------------------------

Interview Questions

Q. What is a Record?
A. A special immutable data class introduced in Java 16.

Q. Which Java version introduced Records?
A. Java 16 (Preview in Java 14).

Q. Are Records immutable?
A. Yes.

Q. What is the superclass of every Record?
A. java.lang.Record.

Q. Can a Record extend another class?
A. No.

Q. Can a Record implement interfaces?
A. Yes.

Q. Can Records have constructors?
A. Yes.

Q. Can Records have methods?
A. Yes.

Q. Can Records have static members?
A. Yes.

Q. Can Records have setter methods?
A. No.

Q. Can Records have additional instance variables?
A. No.

Q. What methods does Java generate automatically?
A.
- Constructor
- Accessor methods
- equals()
- hashCode()
- toString()

--------------------------------------------------

Memory Trick

Record = Immutable Data Class

R → Reduced Boilerplate
E → Extends java.lang.Record
C → Constructor Generated
O → One-line Data Class
R → Read-only (Immutable)
D → DTO / Data Holder
*/