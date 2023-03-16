package com.rajeshkawali.designpattern.decoratorpattern;


/**
 * @author Rajesh_Kawali
 *
 */
public class FoodDecoratorMain {

	public static void main(String[] args) {

		// Food food = new BoiledRice(new FoodImpl());
		 Food food = new BoiledRice(new Dal(new FoodImpl()));
		// Food food = new Chapatti(new VegetableCurry(new FoodImpl()));
		//Food food = new Dal(new VegetableCurry(new Chapatti(new BoiledRice(new FoodImpl()))));
		System.out.println(food.prepareFood());
	}
}

/*
Decorator design pattern allows us to dynamically add functionality and behavior 
to an object without affecting the behavior of other existing objects within the same class. 
We use inheritance to extend the behavior of the class. This takes place at compile-time, 
and all the instances of that class get the extended behavior.

1.Decorator design pattern is useful in providing runtime modification abilities and hence more flexible. 
  Its easy to maintain and extend when the amount of choices are more.
2.The disadvantage of decorator design pattern is that it uses plenty of similar kind of objects (decorators)
3.Decorator pattern is used a lot in Java IO classes, like FileReader, BufferedReader, etc.
*/

/*
Here are the steps to implement the Decorator design pattern in Java:-->

Create a common interface: Create an interface that defines the methods that both the original class and the decorator classes will implement.

Create the base class: Create a base class that implements the common interface. This class will be the starting point for the decorator classes.

Create the decorator classes: Create the decorator classes that will add additional functionality to the base class. Each decorator class should extend the base class and include an instance of the common interface.

Implement the methods: Implement the methods of the common interface in the base class.

Implement the methods in the decorator classes: Implement the methods of the common interface in the decorator classes by calling the same method on the instance of the common interface and adding any additional functionality.

Create an object: Create an object of the base class and assign it to a variable of the common interface type.

Create decorator objects: Create one or more decorator objects by passing the base object to the constructor of the decorator class.

Call the methods: Call the methods on the decorator objects. The methods will be executed in the order that the decorator objects were created.
*/

