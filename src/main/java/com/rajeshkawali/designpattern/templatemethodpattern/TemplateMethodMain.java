package com.rajeshkawali.designpattern.templatemethodpattern;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class TemplateMethodMain {

	/*
	The Template Method Pattern is a behavioral design pattern that allows subclasses 
	to redefine certain steps of an algorithm without changing the algorithm's structure. 
	The pattern is used to define a skeleton of an algorithm in a superclass and allow 
	subclasses to provide concrete implementations for certain steps.
	*/
	public static void main(String[] args) {
		// Create a credit card payment processor and process a payment
		PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
		creditCardProcessor.processPayment(100.0);

		// Create a PayPal payment processor and process a payment
		PaymentProcessor payPalProcessor = new PayPalPaymentProcessor();
		payPalProcessor.processPayment(50.0);
	}
}
/*
In this example, the PaymentProcessor class defines a template method processPayment that performs 
some pre-processing, calls an abstract method performPayment to process the payment, and performs 
some post-processing. The performPayment method is left abstract and must be implemented by subclasses.

Two concrete subclasses are defined: CreditCardPaymentProcessor and PayPalPaymentProcessor, 
which implement the performPayment method to process payments using credit cards and PayPal, respectively.

The example usage code demonstrates how to use the template method to process payments using 
both credit cards and PayPal. The CreditCardPaymentProcessor and PayPalPaymentProcessor objects 
are created and used to process payments, but the template method handles the common algorithmic 
steps of pre-processing and post-processing, while allowing the subclasses to provide specific 
implementations for processing the payments.
*/


/*
Here are the steps to implement the Template Method pattern in Java:-->

Create an abstract class that defines the template method and the abstract methods that the subclasses will implement. This class will define the algorithm and the sequence of steps to follow.
Create concrete implementations of the abstract class that implement the abstract methods. These classes will define the specific implementation of the steps in the algorithm.
Create an object of the concrete implementation classes and call the template method to execute the algorithm.

*/