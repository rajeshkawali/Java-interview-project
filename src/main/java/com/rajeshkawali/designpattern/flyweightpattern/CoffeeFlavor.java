package com.rajeshkawali.designpattern.flyweightpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class CoffeeFlavor implements Coffee {
	private String flavor;

	public CoffeeFlavor(String flavor) {
		this.flavor = flavor;
	}

	public void serveCoffee(CoffeeContext context) {
		System.out.println("Serving coffee flavor " + flavor + " to table " + context.getTable());
	}
}