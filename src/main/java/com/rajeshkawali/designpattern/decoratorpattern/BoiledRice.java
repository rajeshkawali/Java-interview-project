package com.rajeshkawali.designpattern.decoratorpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class BoiledRice extends FoodDecorator {

	public BoiledRice(Food food) {
		super(food);
	}

	@Override
	public String prepareFood() {
		return super.prepareFood() + " Boiled Rice";
	}

}
