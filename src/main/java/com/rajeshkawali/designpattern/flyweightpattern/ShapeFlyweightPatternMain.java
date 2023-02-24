package com.rajeshkawali.designpattern.flyweightpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class ShapeFlyweightPatternMain {
	/*
	The Flyweight design pattern is a structural pattern that allows you to share 
	objects to reduce the number of objects created, and to decrease memory usage and 
	increase performance. The Flyweight pattern is useful when you need to create a 
	large number of similar objects, and you want to minimize the amount of memory used by those objects.
	*/
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	public static void main(String[] args) {

		for (int i = 0; i < 20; ++i) {
			ShapeCircle circle = (ShapeCircle) ShapeFactory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}

	private static String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}

/*
In this example, The Shape interface defines a single method, draw(), 
which draws the shape on the screen. The Circle class is a concrete class 
that implements the Shape interface. The ShapeFactory class is a factory class 
that creates and manages the Circle objects. It uses a HashMap to store 
the Circle objects and it returns an existing Circle object if it already 
exists in the HashMap, or it creates a new Circle object if it doesn't exist.

The FlyweightPatternDemo class is the client that uses the ShapeFactory class 
to create a large number of Circle objects. The main() method creates 20 Circle 
objects, each with a random color, x, y, and radius, and calls the draw() method of each object.

In this example, the Shape interface is the Flyweight interface and the Circle class is the 
Concrete Flyweight class that implement the Flyweight interface. The ShapeFactory class is 
the Flyweight Factory that manage the Flyweight objects and the FlyweightPatternDemo class 
is the client that uses the Flyweight objects.

As you can see, the Flyweight design pattern allows us to create a large number of similar
objects without using a lot of memory. By using the Flyweight pattern, we only need to create 
a single instance of each unique object, and we can reuse that object multiple times by changing its state. 
This reduces the number of objects created, and thus reduces memory usage and improves performance.

In this example, the color property of the Circle object is used as the intrinsic state, 
which is shared among all objects. The x, y, and radius properties are used as the extrinsic state, 
which is specific to each object and can be set by the client. By separating the intrinsic and 
extrinsic state, we can minimize the amount of memory used by the objects, while still 
allowing them to be customized for different uses.

It is worth noting that the Flyweight pattern is often used in conjunction with the factory pattern 
to manage the creation and management of the shared objects.
*/

/*
Here are the steps to implement the Flyweight design pattern in Java:-->

Identify the intrinsic and extrinsic state: Intrinsic state is the state that is shared between flyweight objects, while extrinsic state is the state that varies between flyweight objects.

Create the Flyweight interface: This interface should define the methods that the concrete flyweights will implement. Typically, the intrinsic state is passed in to these methods as a parameter.

Create the ConcreteFlyweight class: This class implements the Flyweight interface and represents the shared object. It should store the intrinsic state and implement the methods defined in the Flyweight interface.

Create the FlyweightFactory class: This class is responsible for creating and managing the flyweights. It should maintain a pool of existing flyweights and return them when requested.

Optionally, create a client class: This class uses the flyweights and may pass in extrinsic state to the flyweights.
*/

