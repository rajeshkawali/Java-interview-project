package com.rajeshkawali.designpattern.builderpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class PhoneShop {

	public static void main(String[] args) {

		//Phone p = new Phone("Android", 4, "Snapdrogan730g", 6.3, 4100);
		//System.out.println(p);
		
		Phone p = new PhoneBuilder().setOs("Android").setProcessor("Snapdrogan730g").setBattery(4100).getPhone();
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
 */
