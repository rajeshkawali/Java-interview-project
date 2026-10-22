package com.rajeshkawali.designpattern.decoratorpattern;


/**
 * @author Rajesh_Kawali
 *
 */
public class FoodDecoratorMain {

	public static void main(String[] args) {

		 //Food food = new BoiledRice(new FoodImpl());
		 //Food food = new BoiledRice(new Dal(new FoodImpl()));
		 //Food food = new Chapatti(new VegetableCurry(new FoodImpl()));
		Food food = new Dal(new VegetableCurry(new Chapatti(new BoiledRice(new FoodImpl()))));
		System.out.println(food.prepareFood());
	}
}

/*
The Decorator Design Pattern is a structural design pattern that 
allows us to dynamically add additional functionality or behavior 
to an object without modifying its original class. It uses composition 
and wrapping instead of relying only on inheritance, making it more 
flexible when we need different combinations of features at runtime.

Decorator pattern is used a lot in Java IO classes, like FileReader, BufferedReader, etc.
*/

/*


Decorator Design Pattern - Definition:
The Decorator Design Pattern is a structural design pattern that allows 
us to dynamically add new functionality or behavior to an object without changing its original class.

In simple words:
Decorator Pattern = Add extra features to an existing object at runtime without modifying the original object.

Why do we need it?
Normally, we can use inheritance to add new behavior to a class
However, inheritance works at compile time, and the new behavior applies to all objects of that subclass.

The Decorator Pattern provides more flexibility because 
we can add or remove behavior at runtime and choose exactly 
which objects should have the additional functionality.



Advantages:
1. Adds functionality at runtime
We can dynamically add behavior to an object without modifying its original class.

2. More flexible than inheritance
When there are many possible combinations of features, using decorators is often more flexible than creating many subclasses.

3. Follows the Open/Closed Principle
The original class can remain unchanged while new functionality is added through new decorator classes.

4. Easy to extend
We can create a new decorator whenever we need to add a new feature.

Disadvantages:
1. Creates many small classes
A Decorator-based design can result in many similar decorator classes.

2. Can become difficult to understand
When many decorators are wrapped around each other, the code can become harder to read and debug.
*/










