package com.rajeshkawali.designpattern.decoratorpattern;


/**
 * @author Rajesh_Kawali
 *
 */
public class Chapatti extends FoodDecorator {

	public Chapatti(Food food) {
		super(food);
	}

	@Override
	public String prepareFood() {
		return super.prepareFood() + " Chapatti";
	}

}
