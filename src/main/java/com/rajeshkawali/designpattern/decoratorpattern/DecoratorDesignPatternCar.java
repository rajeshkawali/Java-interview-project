package com.rajeshkawali.designpattern.decoratorpattern;

// Component interface
interface Car {
	void assemble();
}

// Concrete Component class
class BasicCar implements Car {

	@Override
	public void assemble() {
		System.out.print("Basic Car.");
	}
}

// Decorator abstract class
abstract class CarDecorator implements Car {
	protected Car car;

	public CarDecorator(Car c) {
		this.car = c;
	}

	@Override
	public void assemble() {
		this.car.assemble();
	}
}

// Concrete Decorator class 1
class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}

// Concrete Decorator class 2
class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
}

// Client code
public class DecoratorDesignPatternCar {
	/*
	The Decorator pattern is a structural design pattern that allows behavior 
	to be added to an individual object, either statically or dynamically, 
	without affecting the behavior of other objects from the same class.
	*/
	public static void main(String[] args) {

		Car car = new BasicCar();
		car.assemble();
		System.out.println();

		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println();

		Car luxurySportsCar = new LuxuryCar(new SportsCar(new BasicCar()));
		luxurySportsCar.assemble();
	}
}

/*
UML diagram for the Decorator design pattern:-->

+----------------+                      +------------------+
|     Component  <---------------------+      Decorator    |
+----------------+                      +------------------+
| +operation()    |                      | +operation()     |
+----------------+                      +------------------+
                ^                                    ^
                |                                    |
                |                                    |
+------------------------+          +------------------------+
|      ConcreteComponent |          |     ConcreteDecorator   |
+------------------------+          +------------------------+
| +operation()           |          | +operation()            |
+------------------------+          | +addedBehavior()        |
                                     +------------------------+
                                     
*/

/*
In this diagram, Component is the interface or abstract class that defines the base functionality 
for all concrete components. Decorator is the abstract class that serves as the base class for 
all concrete decorators, and it also implements the Component interface. ConcreteComponent is the 
actual component class that provides the base functionality. Finally, ConcreteDecorator is the 
concrete decorator class that adds new behavior to the component.

The arrows indicate the direction of the relationship between classes. 
For example, Decorator has a "has a" relationship with Component, which means that it contains 
an instance of the Component class. The diamond-shaped arrowhead represents the "is a" relationship, 
which means that ConcreteComponent and ConcreteDecorator are both specialized types of 
Component and Decorator, respectively.
*/

/*
The Decorator pattern is a structural design pattern that allows behavior to be 
added to an individual object, either statically or dynamically, without affecting 
the behavior of other objects from the same class. The Decorator pattern is used to 
extend or modify the behavior of an object at runtime without affecting its implementation.

In this pattern, a decorator is an object that wraps another object to provide new behavior. 
The decorator itself conforms to the interface of the object it is wrapping, and it forwards 
method calls to the wrapped object. The decorator can add new behavior before or after the 
method calls, or it can replace the method calls altogether.

One common use case for the Decorator pattern is when you have a base class or interface with a 
number of methods, and you want to add behavior to individual instances of that class or 
interface without changing the class itself. For example, you might have a class that represents a 
basic window in a GUI toolkit, and you want to add decorations like borders, scrollbars, 
or menus to individual windows at runtime.

Another use case is when you want to add functionality to an object without creating a 
new subclass or modifying its implementation directly. This can be useful when you're working 
with legacy code that you can't modify, or when you want to avoid creating a large number of 
new subclasses for each possible combination of behaviors. The Decorator pattern allows you 
to add new behavior dynamically without changing the object's original implementation.
*/