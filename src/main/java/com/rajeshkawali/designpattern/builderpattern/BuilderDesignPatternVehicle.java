package com.rajeshkawali.designpattern.builderpattern;

/**
 * @author Rajesh_Kawali
 *
 */
class Vehicle {
	// required parameter
	private String engine;
	private int wheel;

	// optional parameter
	private int airbags;

	public String getEngine() {
		return this.engine;
	}

	public int getWheel() {
		return this.wheel;
	}

	public int getAirbags() {
		return this.airbags;
	}

	private Vehicle(VehicleBuilder builder) {
		this.engine = builder.engine;
		this.wheel = builder.wheel;
		this.airbags = builder.airbags;
	}

	public static class VehicleBuilder {
		private String engine;
		private int wheel;

		private int airbags;

		public VehicleBuilder(String engine, int wheel) {
			this.engine = engine;
			this.wheel = wheel;
		}

		public VehicleBuilder setAirbags(int airbags) {
			this.airbags = airbags;
			return this;
		}

		public Vehicle build() {
			return new Vehicle(this);
		}
	}
}

public class BuilderDesignPatternVehicle {

	public static void main(String[] args) {
		Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
		Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

		System.out.println(car.getEngine());
		System.out.println(car.getWheel());
		System.out.println(car.getAirbags());

		System.out.println(bike.getEngine());
		System.out.println(bike.getWheel());
		System.out.println(bike.getAirbags());
	}
}
/*
The Builder pattern is a creational design pattern that separates the construction 
of a complex object from its representation so that the same construction process can 
create different representations. The idea is to use a builder object that receives 
instructions from a client program and constructs the object step-by-step, returning it as a finished product.

The Builder pattern is used when:-->

1.The object that needs to be constructed is complex and requires multiple steps or multiple pieces of data to construct.
2.The order of the steps in construction can vary and needs to be flexible.
3.The object to be constructed should be immutable once it has been created.
4.There are different representations of the object to be constructed, 
and the same construction process can create different representations.

For example, the Builder pattern is commonly used in software that deals with creating complex objects 
such as documents, reports, or user interfaces. By using a builder object, 
the construction of these objects can be separated from their representation, 
making the code more flexible and easier to maintain.
*/

/*

+-----------------+          +--------------------+
|     Vehicle     |          | VehicleBuilder     |
+-----------------+          +--------------------+
|  -engine: String|          |  -engine: String   |
|  -wheel: int    |          |  -wheel: int       |
|  -airbags: int  |          |  -airbags: int     |
+----------------+           +--------------------+
|  +getEngine(): String      |  +VehicleBuilder(engine: String, wheel: int) |
|  +getWheel(): int          |  +setAirbags(airbags: int): VehicleBuilder |
|  +getAirbags(): int        |  +build(): Vehicle |
+----------------+           +--------------------+
             |                            |
             |                            |
             +------------------------->  |
                                          |
                                       +----------------------------+
                                       |   BuilderPatternExample    |
                                       +----------------------------+
                                       | main(args: String[]): void |
                                       +----------------------------+
                                       
In this diagram, Vehicle represents the product that is being built, 
and VehicleBuilder represents the builder. The builder has all the required 
and optional parameters as instance variables and provides a fluent interface to set them. 
The build() method returns the final built Vehicle object.

The BuilderPatternExample class demonstrates how to use the builder to create Vehicle objects.

*/