package com.rajeshkawali.designpattern.flyweightpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Client code
public class CoffeeShopMain {
	/*
	The Flyweight design pattern is used to reduce memory usage by sharing common data between multiple objects. 
	It involves creating shared objects (called flyweights) and using them to avoid creating new objects when possible. 
	*/
	private static Coffee[] flavors = new CoffeeFlavor[100];
	private static CoffeeContext[] tables = new CoffeeContext[100];
	private static int ordersMade = 0;
	private static CoffeeFlavorFactory flavorFactory;

	public static void takeOrder(String flavorName, int table) {
		flavors[ordersMade] = flavorFactory.getCoffeeFlavor(flavorName);
		tables[ordersMade] = new CoffeeContext(table);
		ordersMade++;
	}

	public static void main(String[] args) {
		flavorFactory = new CoffeeFlavorFactory();

		takeOrder("Cappuccino", 2);
		takeOrder("Latte", 1);
		takeOrder("Espresso", 1);
		takeOrder("Cappuccino", 3);
		takeOrder("Espresso", 2);
		takeOrder("Latte", 3);
		takeOrder("Cappuccino", 4);
		takeOrder("Espresso", 3);

		for (int i = 0; i < ordersMade; i++) {
			flavors[i].serveCoffee(tables[i]);
		}

		System.out.println("Number of coffee flavors: " + flavorFactory.getNumberOfCoffeeFlavors());
	}
}