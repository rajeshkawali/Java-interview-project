package com.rajeshkawali.solid.designprinciples;

abstract class Animal {
	public abstract void move();
}

class Bird extends Animal {
	@Override
	public void move() {
		// code to make the bird move
	}
}

public class LiskovSubstitutionPrinciple {
	/*
	Liskov Substitution Principle:
	A derived class should be able to replace its base class without altering the correctness of the program.
	For example, in Java, consider a class named "Bird" that extends the base class "Animal". 
	The "Bird" class should be able to replace the "Animals" class without altering the program's correctness. 
	This means that the "Bird" class should override the methods of the "Animals" 
	class in a way that is consistent with the behavior of the base class.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
