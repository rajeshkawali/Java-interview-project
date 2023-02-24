package com.rajeshkawali.designpattern.templatemethodpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Concrete class implementing a specific step of the algorithm
public class PayPalPaymentProcessor extends PaymentProcessor {
	@Override
	protected void performPayment(double amount) {
		// Perform the PayPal payment
		System.out.println("Processing PayPal payment for amount: " + amount);
	}
}