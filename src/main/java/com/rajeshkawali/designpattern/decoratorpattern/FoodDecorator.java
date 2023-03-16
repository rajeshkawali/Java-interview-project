package com.rajeshkawali.designpattern.decoratorpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public abstract class FoodDecorator implements Food {

	private Food food;

	public FoodDecorator(Food food) {
		this.food = food;
	}

	@Override
	public String prepareFood() {
		return food.prepareFood();
	}

}