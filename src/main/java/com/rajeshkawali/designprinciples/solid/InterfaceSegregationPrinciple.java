package com.rajeshkawali.designprinciples.solid;

interface Flyable {
	public void fly();
}

interface Singable {
	public void sing();
}

class Bird1 implements Flyable, Singable {
	public void fly() {
		// code to make the bird fly
	}

	public void sing() {
		// code to make the bird sing
	}
}

public class InterfaceSegregationPrinciple {
	/*
	Interface Segregation Principle:
	A class should not be forced to implement interfaces it doesn't use.
	For example, in Java, consider an interface named "Animals" that contains methods for "Fly", "Swim" and "Sing". 
	A class named "Bird" should only implement the "Fly" and "Sing" methods since birds can fly and sing, but they can't swim. 
	By separating the interface into smaller interfaces such as "Flyable" and "Singable" we can avoid this problem.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
