package com.rajeshkawali.solid.designprinciples;

abstract class Shape {
	public abstract double calculateArea();
}

class Triangle extends Shape {
	public double calculateArea() {
		return 0;
		// code to calculate area of triangle
	}
}

class Rectangle extends Shape {
	public double calculateArea() {
		return 0;
		// code to calculate area of rectangle
	}
}

class Circle extends Shape {
	public double calculateArea() {
		return 0;
		// code to calculate area of circle
	}
}

public class OpenClosedPrinciple {
	/*
	Open-Closed Principle:
	A class should be open for extension but closed for modification.
	For example, in Java, consider a class named "Shape" that can be either a "Triangle", "Rectangle" or "Circle". 
	We can create a base class "Shape" that contains a method "calculateArea()" and extend it to 
	create classes for "Triangle", "Rectangle" and "Circle". 
	Now, if we want to add a new shape, we can do so by creating a 
	new class without modifying the existing "Shape" class.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
