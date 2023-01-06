package com.rajeshkawali.concepts.newfeature.sealed;

/**
 * @author Rajesh_Kawali
 *
 */
sealed interface Shape permits Circle, Square, Triangle {
	/**
	Sealed classes are a new feature introduced in Java as part of the Java
	Development Kit (JDK) 15. They allow you to specify which classes are allowed
	to extend a given class, creating restricted class hierarchies in which only
	certain classes can extend a given class.

	To define a sealed class, you use the sealed modifier followed by the class
	or interface declaration and a permits clause that lists the permitted
	subclasses.
	 */
	public void printMessage();
}

//The type Printer that implements a sealed interface Shape should be a permitted subtype of Shape
//final class Printer implements Shape {} // Compile time error - not permitted

final class Circle implements Shape {
	@Override
	public void printMessage() {
		System.out.println("Circle.printMessage()");
	}
}

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

sealed class Square implements Shape permits Rectangle {
	@Override
	public void printMessage() {
		System.out.println("Square.printMessage()");
	}
}

final class Rectangle extends Square {
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
1.Sealed classes must have a restricted class hierarchy, which means that
they must have a permits clause that lists the permitted subclasses.

2.The permitted subclasses of a sealed class must be final or sealed
themselves.

3.A sealed class can only be subclassed by its permitted subclasses, and any
other class that tries to extend the sealed class will result in a
compile-time error.

4.A sealed class can be declared as an interface or as a class. If it is
declared as an interface, the permitted subclasses must implement the
interface.

5.A sealed class can be declared with a in clause that specifies the packages
where the permitted subclasses can be defined. If the in clause is not
present, the permitted subclasses can be defined anywhere.

6.A sealed class can be declared as abstract, in which case the permitted
subclasses must be final.

7.A sealed class can have a superclass, in which case the superclass must be
final or sealed itself.

8.A sealed class cannot be declared as private, protected, or static. It must
have at least package-private access.
*/