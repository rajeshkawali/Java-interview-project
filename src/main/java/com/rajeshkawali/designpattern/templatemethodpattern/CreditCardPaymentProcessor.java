package com.rajeshkawali.designpattern.templatemethodpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Concrete class implementing a specific step of the algorithm
public class CreditCardPaymentProcessor extends PaymentProcessor {
	@Override
	protected void performPayment(double amount) {
		// Perform the credit card payment
		System.out.println("Processing credit card payment for amount: " + amount);
	}
}