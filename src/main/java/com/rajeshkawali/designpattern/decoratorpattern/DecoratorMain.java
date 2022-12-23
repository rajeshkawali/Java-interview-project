package com.rajeshkawali.designpattern.decoratorpattern;


/**
 * @author Rajesh_Kawali
 *
 */
public class DecoratorMain {

	public static void main(String[] args) {

		// Food food = new BoiledRice(new FoodImpl());
		// Food food = new BoiledRice(new Dal(new FoodImpl()));
		// Food food = new Chapatti(new VegetableCurry(new FoodImpl()));
		Food food = new Dal(new VegetableCurry(new Chapatti(new BoiledRice(new FoodImpl()))));
		System.out.println(food.prepareFood());
	}
}

/*
Decorator design pattern allows us to dynamically add functionality and behavior 
to an object without affecting the behavior of other existing objects within the same class. 
We use inheritance to extend the behavior of the class. This takes place at compile-time, 
and all the instances of that class get the extended behavior.

1.Decorator design pattern is useful in providing runtime modification abilities and hence more flexible. Its easy to maintain and extend when the amount of choices are more.
2.The disadvantage of decorator design pattern is that it uses plenty of similar kind of objects (decorators)
3.Decorator pattern is used a lot in Java IO classes, like FileReader, BufferedReader, etc.
*/