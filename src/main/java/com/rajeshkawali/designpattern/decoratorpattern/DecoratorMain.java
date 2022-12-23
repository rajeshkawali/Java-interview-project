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
