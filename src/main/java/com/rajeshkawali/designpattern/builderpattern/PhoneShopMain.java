package com.rajeshkawali.designpattern.builderpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class PhoneShopMain {

	public static void main(String[] args) {

		//Phone p = new Phone("Android", 4, "Snapdrogan730g", 6.3, 4100);
		//System.out.println(p);
		
		//We can create only required fields other we can ignore.
		//Phone p = new PhoneBuilder().setOs("Android").setScreenSize(6.5).setRam(12).setProcessor("Snapdrogan 888").setBattery(4500).build();
		Phone p = new PhoneBuilder().setOs("Android").setProcessor("Snapdrogan 888").setBattery(4500).build();
		//Phone p = new PhoneBuilder().setOs("Android").build();
		System.out.println(p);
		System.out.println(p.getOs());
		System.out.println(p.getProcessor());
		System.out.println(p.getRam());
		System.out.println(p.getBattery());
		System.out.println(p.getScreenSize());
	}
}
/*
Builder pattern builds a complex object using simple objects and using 
a step by step approach. This type of design pattern comes under 
creational pattern as this pattern provides one of the best ways to create an object.

A Builder class builds the final object step by step. 
This builder is independent of other objects.

Builder is a creational design pattern that lets you construct complex objects 
step by step. The pattern allows you to produce different types and 
representations of an object using the same construction code.

How to create:

1. Create POJO class(Phone) with private fields which has only getter methods and parameterized constructor.
2. Create POJO Builder class(PhoneBuilder) which has same fields as POJO class.
3. Provide setter methods with POJO Builder return type for all the fields.
4. Create method(build()) which returns POJO class object from POJO Builder class.
 */


/*
Here are the general steps to implement the Builder design pattern in Java:-->

Identify the complex object you want to create and its components. Define a common interface for these components.
Create an abstract builder class that defines the interface for creating the complex object. The builder should have methods for building each component of the complex object.
Create concrete builder classes that implement the builder interface and provide specific implementations for building the complex object.
Create a director class that knows how to use the builder to build the complex object. The director should provide a method for clients to initiate the building process.
(Optional) Create a product class to represent the complex object being built. The product class should have methods for retrieving the individual components.
Use the builder pattern in client code by creating a builder object and passing it to the director to create the complex object.
*/
