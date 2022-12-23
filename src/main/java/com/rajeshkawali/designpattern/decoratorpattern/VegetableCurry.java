package com.rajeshkawali.designpattern.decoratorpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class VegetableCurry extends FoodDecorator {

	public VegetableCurry(Food food) {
		super(food);
	}

	@Override
	public String prepareFood() {
		return super.prepareFood() + " Vegetable Curry";
	}

}