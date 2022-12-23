package com.rajeshkawali.designpattern.decoratorpattern;


/**
 * @author Rajesh_Kawali
 *
 */
public class Dal extends FoodDecorator {

	public Dal(Food food) {
		super(food);
	}

	@Override
	public String prepareFood() {
		return super.prepareFood() + " Dal";
	}

}
