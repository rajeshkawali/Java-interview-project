package com.rajeshkawali.designpattern.builderpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class Phone {

	private String os;
	private int ram;
	private String processor;
	private double screenSize;
	private int battery;

	public String getOs() {
		return os;
	}

	public int getRam() {
		return ram;
	}

	public String getProcessor() {
		return processor;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public int getBattery() {
		return battery;
	}

	public Phone(String os, int ram, String processor, double screenSize, int battery) {
		super();
		this.os = os;
		this.ram = ram;
		this.processor = processor;
		this.screenSize = screenSize;
		this.battery = battery;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [os=");
		builder.append(os);
		builder.append(", ram=");
		builder.append(ram);
		builder.append(", processor=");
		builder.append(processor);
		builder.append(", screenSize=");
		builder.append(screenSize);
		builder.append(", battery=");
		builder.append(battery);
		builder.append("]");
		return builder.toString();
	}
}
/*
The Builder pattern is a creational design pattern that provides a way to construct complex objects step by step. 
It allows you to create objects by specifying only the required parameters, while providing flexibility 
to set optional parameters or configure the object in different ways.

The key idea behind the Builder pattern is to separate the construction of an object from its 
representation, so that the same construction process can be used to create different representations. 
This is useful when you need to create objects with different configurations or 
when the object has many optional parameters.

In the Builder pattern, there is a separate builder class that is responsible for creating and configuring the object. 
The builder class has methods for setting the required and optional parameters of the object, 
and a build method that returns the final object. The builder class can also have methods for 
validating the configuration or performing other operations.
*/