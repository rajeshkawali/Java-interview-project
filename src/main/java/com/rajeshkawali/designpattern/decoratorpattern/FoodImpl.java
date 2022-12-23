package com.rajeshkawali.designpattern.decoratorpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class FoodImpl implements Food {

	@Override
	public String prepareFood() {
		
		return "Indian Thali having";
	}
}