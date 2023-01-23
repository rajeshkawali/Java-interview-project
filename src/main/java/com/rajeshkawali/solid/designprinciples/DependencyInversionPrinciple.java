package com.rajeshkawali.solid.designprinciples;

interface Payment {
	public void pay(double amount);
}

class Order {
	private Payment payment;

	public Order(Payment payment) {
		this.payment = payment;
	}

	public void checkout(double amount) {
		payment.pay(amount);
	}
}

class PaypalPayment implements Payment {
	public void pay(double amount) {
		// code to process Paypal payment
	}
}

public class DependencyInversionPrinciple {
	/*
	Dependency Inversion Principle:
	High-level modules should not depend on low-level modules; both should depend on abstractions.
	For example, in Java, consider a class named "Order" that depends on a specific implementation 
	of a "Payment" class named "PaypalPayment". 
	To adhere to the Dependency Inversion Principle, we should create an abstraction of the "Payment" class, 
	such as an interface or abstract class named "Payment" and have the "Order" class depend on this 
	abstraction rather than a specific implementation.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
