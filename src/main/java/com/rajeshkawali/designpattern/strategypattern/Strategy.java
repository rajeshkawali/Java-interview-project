package com.rajeshkawali.designpattern.strategypattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
interface Strategy {
	/*
	 The Strategy pattern is a behavioral design pattern that allows an object to
	 change its behavior at runtime by changing its strategy (algorithm) object.
	 The pattern involves creating a family of algorithms, encapsulating each one
	 as an object, and making them interchangeable.
	 */
	public int doOperation(int num1, int num2);
}

