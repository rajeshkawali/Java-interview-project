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

public class BuilderPatternExample {

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
The Builder design pattern is a creational pattern that separates the construction of a complex object 
from its representation, allowing the same construction process to create various representations.

In this example, the Vehicle class is a complex object that requires multiple parameters to be set for its creation. 
The VehicleBuilder class separates the construction process from the representation of the Vehicle object. 
It takes in the required parameters in its constructor and has additional methods to set the optional parameters. 
The build() method constructs the Vehicle object using the builder object's values and returns it.

The Vehicle class has a private constructor that takes in a VehicleBuilder object and sets its fields using the builder's values. 
It has getter methods to retrieve the fields.

In the main() method, the Vehicle object is constructed using the VehicleBuilder object by 
setting the required parameters in the builder's constructor and calling the builder's methods to set the optional parameters. 
Finally, the build() method constructs and returns the Vehicle object.
*/