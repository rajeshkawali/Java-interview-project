package com.rajeshkawali.designpattern.templatemethodpattern;

// Abstract class defining a template method for an algorithm
public abstract class PaymentProcessor {
	// Template method that defines the algorithm
	public final void processPayment(double amount) {
		// Perform some pre-processing
		System.out.println("Performing pre-processing for payment...");

		// Call the abstract method for processing the payment
		performPayment(amount);

		// Perform some post-processing
		System.out.println("Performing post-processing for payment...");
	}
	// Abstract method to be implemented by subclasses
	protected abstract void performPayment(double amount);
}