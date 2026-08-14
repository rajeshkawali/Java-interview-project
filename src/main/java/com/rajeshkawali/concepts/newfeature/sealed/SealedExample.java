package com.rajeshkawali.concepts.newfeature.sealed;

/**
 * @author Rajesh_Kawali
 *
 */
sealed interface Shape permits Circle, Square, Triangle {
	/**
	Sealed classes introduced in Java 15 as a preview feature and standardized in Java 17.
	
	A sealed class is a special kind of class that restricts which other classes or interfaces can 
	extend or implement it. By declaring a class as sealed, the developer explicitly 
	specifies a fixed set of permitted subclasses, thereby controlling the class hierarchy 
	and improving code safety, maintainability, and pattern matching.

	To define a sealed class, you use the sealed modifier followed by the class
	or interface declaration and a permits clause that lists the permitted
	subclasses.
	 */
	public void printMessage();
}

//Compile-time Error - Not listed in the permits clause.
//final class Pentagon implements Shape {
//
//  @Override
//  public void printMessage() {
//  }
//}

//Cannot be extended further.
final class Circle implements Shape {
	@Override
	public void printMessage() {
		System.out.println("Circle.printMessage()");
	}
}

//Can be extended by any class.
non-sealed class Triangle implements Shape {
	@Override
	public void printMessage() {
		System.out.println("Triangle.printMessage()");
	}
}

class EquilateralTriangle extends Triangle {
	@Override
	public void printMessage() {
		System.out.println("EquilateralTriangle.printMessage()");
	}
}

//Restricts inheritance again.
sealed class Square implements Shape permits Rectangle {
	@Override
	public void printMessage() {
		System.out.println("Square.printMessage()");
	}
}

//Cannot be extended further.
final class Rectangle extends Square {
	
	@Override
	public void printMessage() {
		System.out.println("Rectangle.printMessage()");
	}
}

public class SealedExample {
	public static void main(String[] args) {
		Shape shape1 = new Circle();
		Shape shape2 = new Rectangle();
		Shape shape3 = new Square();
		Shape shape4 = new Triangle();
		Shape shape5 = new EquilateralTriangle();
		//Shape shape6 = new Printer(); // compile-time error

		if (shape1 instanceof Circle) {
			shape1.printMessage();
		}
		if (shape2 instanceof Rectangle) {
			shape2.printMessage();
		}
		if (shape3 instanceof Square) {
			shape3.printMessage();
		}
		if (shape4 instanceof Triangle) {
			shape4.printMessage();
		}
		if (shape5 instanceof EquilateralTriangle) {
			shape5.printMessage();
		}
	}
}
/*
Rules of Sealed Classes/Interfaces (Java 17)

1. A sealed class/interface uses the 'sealed' keyword and a 'permits'
   clause to specify the allowed subclasses or implementations.

2. Every permitted subclass must declare one of these modifiers:
   - final      -> Cannot be extended.
   - sealed     -> Restricts inheritance further.
   - non-sealed -> Removes the restriction and allows normal inheritance.

3. Only the classes listed in the 'permits' clause can extend or implement
   the sealed class/interface. Any other class causes a compile-time error.

4. A sealed type can be either a class or an interface.
   - A sealed class is extended.
   - A sealed interface is implemented.

5. Permitted subclasses must directly extend or implement the sealed type.

6. Permitted subclasses must be in the same package (or the same named module)
   as the sealed class/interface.

7. A sealed class may also be abstract.

8. A sealed class can extend another class, and a sealed interface can extend
   other interfaces, following normal Java inheritance rules.
*/



/*
====================================
Sealed Classes / Interfaces (Java 17)
====================================

Definition:
A sealed class or interface restricts which classes can extend or implement it.
Only the classes listed in the 'permits' clause are allowed.

Introduced:
- Preview: Java 15
- Standard: Java 17

Syntax:
sealed class A permits B, C {}
sealed interface Shape permits Circle, Square {}

--------------------------------------------------

Rules

1. Use the 'sealed' keyword to declare a sealed class/interface.

2. Use the 'permits' clause to specify the allowed subclasses.

3. Every permitted subclass must explicitly declare one of:
   - final       -> Cannot be extended.
   - sealed      -> Restricts inheritance further.
   - non-sealed  -> Removes the restriction and allows normal inheritance.

4. Permitted subclasses must directly extend or implement the sealed class/interface.

5. A class not listed in the 'permits' clause cannot extend or implement it.
   -> Results in a compile-time error.

--------------------------------------------------

In this Example

Shape (sealed interface)
        |
        |-- Circle (final)
        |
        |-- Triangle (non-sealed)
        |        |
        |        ---> EquilateralTriangle (Allowed)
        |
        ---> Square (sealed)
                  |
                  ---> Rectangle (final)

--------------------------------------------------

Meaning of Keywords

final
-----
Stops inheritance completely.

Example:
final class Circle implements Shape {}

----------------------------------------

sealed
------
Allows inheritance only by the permitted subclasses.

Example:
sealed class Square implements Shape
        permits Rectangle {}

----------------------------------------

non-sealed
----------
Removes the sealing restriction.
The class behaves like a normal class and can be extended freely.

Example:
non-sealed class Triangle implements Shape {}

--------------------------------------------------

Advantages

1. Restricts unwanted inheritance.
2. Improves code safety.
3. Makes APIs easier to maintain.
4. Gives better control over class hierarchy.
5. Works well with Pattern Matching and Switch expressions.

--------------------------------------------------

Limitations

1. Only permitted classes can extend/implement it.
2. Every permitted subclass must be:
   - final
   - sealed
   - non-sealed
3. Cannot be extended by arbitrary classes.

--------------------------------------------------

Interview Questions

Q. What is a sealed class?
A. A class that restricts which classes can inherit from it.

Q. Which Java version introduced sealed classes?
A. Java 17 (Preview in Java 15).

Q. What is the purpose of the permits keyword?
A. It specifies the allowed subclasses.

Q. What are the three modifiers used with permitted subclasses?
A. final, sealed, non-sealed.

Q. Can a class not listed in permits extend a sealed class?
A. No. It causes a compile-time error.

Q. Difference between final and sealed?

final
- No inheritance allowed.

sealed
- Inheritance allowed only for permitted classes.

Q. What does non-sealed mean?

A.
It removes the sealing restriction and allows normal inheritance.

--------------------------------------------------

Memory Trick

sealed      -> Limited inheritance
final       -> No inheritance
non-sealed  -> Unlimited inheritance

sealed -> choose who can inherit
final -> nobody can inherit
non-sealed -> anybody can inherit
*/