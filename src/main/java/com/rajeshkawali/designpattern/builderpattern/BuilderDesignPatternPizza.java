package com.rajeshkawali.designpattern.builderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajesh_Kawali
 *
 */
class Pizza {
	
	private String size;
	private String crust;
	private List<String> toppings;

	public Pizza(String size, String crust, List<String> toppings) {
		this.size = size;
		this.crust = crust;
		this.toppings = toppings;
	}

	public String getSize() {
		return size;
	}

	public String getCrust() {
		return crust;
	}

	public List<String> getToppings() {
		return toppings;
	}
}

class PizzaBuilder {
	private String size;
	private String crust;
	private List<String> toppings;

	public PizzaBuilder() {
		this.toppings = new ArrayList<>();
	}

	public PizzaBuilder setSize(String size) {
		this.size = size;
		return this;
	}

	public PizzaBuilder setCrust(String crust) {
		this.crust = crust;
		return this;
	}

	public PizzaBuilder addTopping(String topping) {
		this.toppings.add(topping);
		return this;
	}

	public Pizza build() {
		return new Pizza(size, crust, toppings);
	}
}

public class BuilderDesignPatternPizza {

	public static void main(String[] args) {
		PizzaBuilder builder = new PizzaBuilder();
		Pizza pizza = builder.setSize("Large").setCrust("Thin").addTopping("Cheese").addTopping("Pepperoni").build();
		System.out.println(pizza);
	}

}
/*
The Builder Design Pattern is often used in software development when you need 
to create complex objects with many optional parameters.

The Builder Design Pattern is a creational design pattern that separates the construction of an object 
from its representation, allowing the same construction process to create different representations. 
It is used to construct complex objects step by step and makes the object creation process more flexible and dynamic.

In the given code example, the PizzaBuilder class acts as a builder for the Pizza class. 
It provides a flexible way to construct a Pizza object with different toppings, sizes, and crusts. 
The PizzaBuilder class defines various methods to set different attributes of a 
Pizza object and returns the builder instance after setting each attribute. 
Finally, the build() method creates and returns the Pizza object with the given attributes. 
The Pizza class has a constructor that takes in the attributes set by the builder and constructs a Pizza object. 
By using the builder pattern, the Pizza object can be created in a step-by-step process, 
and the same builder instance can be used to create different representations of the Pizza object.
*/

/*

+--------------------+          +---------------------------+
|      Pizza         |          |   PizzaBuilder            |
+--------------------+          +---------------------------+
| -size: String      |          | -size: String             |
| -crust: String     |          | -crust: String            |
| -toppings: List    |          | -toppings: List           |
+--------------------+          +---------------------------+
| +getSize():String  |          | +PizzaBuilder()           |
| +getCrust():String |          | +setSize():PizzaBuilder   |
| +getToppings():List|          | +setCrust():PizzaBuilder  |
|                    |          | +addTopping():PizzaBuilder|
|                    |          | +build():Pizza            |
+--------------------+          +---------------------------+
									^
									|
		+------------------------------------+
		|         BuilderDesignPatternPizza  |
		+------------------------------------+
		| +main(args: String[]): void        |
		+------------------------------------+         

The Pizza class has three private attributes: size, crust, and toppings, which can only be accessed 
through the getters getSize(), getCrust(), and getToppings(). 
The Pizza constructor takes these attributes as arguments.

The PizzaBuilder class has three private attributes: size, crust, and toppings, 
which can be set using the setSize(), setCrust(), and addTopping() methods, respectively. 
The PizzaBuilder class has a public method named build() which returns a Pizza object.

The PizzaBuilder class uses the method chaining technique, 
which allows the code to be more readable and concise.

The BuilderDesignPatternPizza class has a main method that demonstrates how to use 
the PizzaBuilder to create a Pizza object with specific attributes.
*/