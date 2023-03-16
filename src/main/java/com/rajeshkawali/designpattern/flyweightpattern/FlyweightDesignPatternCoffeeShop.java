package com.rajeshkawali.designpattern.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
//Flyweight interface
interface Coffee {
	public void serveCoffee(CoffeeContext context);
}

//Concrete flyweight
class CoffeeFlavor implements Coffee {
	private String flavor;

	public CoffeeFlavor(String flavor) {
		this.flavor = flavor;
	}

	public void serveCoffee(CoffeeContext context) {
		System.out.println("Serving coffee flavor " + flavor + " to table " + context.getTable());
	}
}

//Context object that holds extrinsic state
class CoffeeContext {
	private int table;

	public CoffeeContext(int table) {
		this.table = table;
	}

	public int getTable() {
		return table;
	}
}

//Flyweight factory
class CoffeeFlavorFactory {
	private Map<String, Coffee> flavors = new HashMap<>();

	public Coffee getCoffeeFlavor(String flavorName) {
		Coffee flavor = flavors.get(flavorName);

		if (flavor == null) {
			flavor = new CoffeeFlavor(flavorName);
			flavors.put(flavorName, flavor);
		}
		return flavor;
	}

	public int getNumberOfCoffeeFlavors() {
		return flavors.size();
	}
}

// Client code
public class FlyweightDesignPatternCoffeeShop {
	/*
	 The Flyweight design pattern is used to reduce memory usage by sharing common
	 data between multiple objects. It involves creating shared objects (called
	 flyweights) and using them to avoid creating new objects when possible.
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
/*

The Flyweight pattern is a structural design pattern that aims to reduce the memory usage 
and improve the performance of an application by sharing common parts of objects 
between multiple instances of the same object.

The pattern achieves this by creating a Flyweight Factory that manages the creation 
and sharing of these common parts. The Flyweight Factory maintains a pool of Flyweight objects 
and returns an existing Flyweight object from the pool if it already exists, or creates a new one if it does not.

Flyweight pattern is useful when an application requires a large number of similar objects 
and creating all of them would consume a lot of memory. By sharing common parts between objects, 
the pattern reduces memory consumption and makes the application more efficient.

Some common examples of where Flyweight pattern can be applied are graphics applications 
such as drawing software, where large numbers of similar objects such as lines, shapes, 
and colors are used. It can also be used in text processing applications where the same font 
and style are used throughout a document, or in games where a large number of similar objects 
such as trees, rocks, and buildings are used.

UML diagram for the Flyweight Design Pattern implementation:-->


+-------------------+                   +---------------------+
|      Coffee       |<>---------------o |     CoffeeFlavor    |
+-------------------+                   +---------------------+
|     serveCoffee   |                   |      - flavor       |
+-------------------+                   +---------------------+
         /\                                          /\
         ||                                          ||
         ||                                          ||
+--------+---------+            +---------------------+---------------------+
|   CoffeeContext  |            |     CoffeeFlavorFactory                   |
+------------------+            +-------------------------------------------+
|     - table      |            |     - flavors: HashMap<String, Coffee>    |
+------------------+            |                                           |
|    getTable()    |            |     +getCoffeeFlavor(String): Coffee      |
+------------------+            |     +getNumberOfCoffeeFlavors(): int      |
                                +-------------------------------------------+


The Coffee interface represents the Flyweight.
CoffeeFlavor is a concrete implementation of Coffee interface.
CoffeeContext is a context object that holds extrinsic state.
CoffeeFlavorFactory is the Flyweight factory that manages the creation and caching of Coffee objects.
The CoffeeShopMain class is the client that creates and uses the Flyweight objects through the factory.

Note that the CoffeeFlavorFactory class is shown as a singleton, 
which means there is only one instance of it in the system. 
However, this is not explicitly mentioned in the code, 
and it depends on the specific implementation.
*/