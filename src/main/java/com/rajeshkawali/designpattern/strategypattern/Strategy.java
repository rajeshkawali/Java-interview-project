package com.rajeshkawali.designpattern.strategypattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public interface Strategy {
	/*
	 The Strategy pattern is a behavioral design pattern that allows an object to
	 change its behavior at runtime by changing its strategy (algorithm) object.
	 The pattern involves creating a family of algorithms, encapsulating each one
	 as an object, and making them interchangeable.
	 */
	public int doOperation(int num1, int num2);
}
/*
The Strategy pattern is a behavioral design pattern that enables you 
to define a family of algorithms, encapsulate each one as an object, 
and make them interchangeable at runtime. The pattern lets you choose 
the algorithm to use for a particular task or situation dynamically, based on the context.

The key elements of the Strategy pattern are:-->

Context: The object that contains the context in which the strategies operate.
Strategy: The interface that defines the contract for a family of algorithms.
Concrete Strategy: The specific implementation of a strategy.

Here's an example of when you might use the Strategy pattern:-->
Suppose you have an application that provides different payment methods for customers, 
such as credit card, PayPal, or bank transfer. Each payment method has its own algorithm 
for processing payments. You could implement the different payment methods as separate classes, 
but this could result in a lot of duplicate code. Alternatively, you could use the Strategy pattern 
to define a family of algorithms for processing payments, with each algorithm implemented as a separate class. 
This would allow you to change the payment method dynamically, 
based on the customer's preferences, without having to modify 
the code for the application's core logic.
*/