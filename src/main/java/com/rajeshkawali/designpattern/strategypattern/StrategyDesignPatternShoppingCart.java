package com.rajeshkawali.designpattern.strategypattern;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
interface PaymentStrategy {
	void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card");
	}
}

class PayPalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;

	public PayPalStrategy(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using PayPal");
	}
}

class ShoppingCart {

	List<Item> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int calculateTotal() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay(PaymentStrategy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}

class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}

public class StrategyDesignPatternShoppingCart {
	public static void main(String[] args) {

		Item item1 = new Item("Samsung Galaxy S21", 899);
		Item item2 = new Item("Apple AirPods Pro", 249);

		ShoppingCart cart = new ShoppingCart();
		cart.addItem(item1);
		cart.addItem(item2);

		// Pay using credit card
		PaymentStrategy creditCardStrategy = new CreditCardStrategy("Laksh Kawali", "1234567890123456", "123", "12/24");
		cart.pay(creditCardStrategy);

		// Pay using PayPal
		PaymentStrategy payPalStrategy = new PayPalStrategy("rajesh@gmail.com", "password");
		cart.pay(payPalStrategy);
	}
}
/*
The Strategy pattern is a behavioral design pattern that enables you to define a family of algorithms, 
encapsulate each one as an object, and make them interchangeable at runtime. 
The pattern lets you choose the algorithm to use for a particular 
task or situation dynamically, based on the context.

The key elements of the Strategy pattern are:-->

Context: The object that contains the context in which the strategies operate.
Strategy: The interface that defines the contract for a family of algorithms.
Concrete Strategy: The specific implementation of a strategy.
Here's an example of when you might use the Strategy pattern:

Suppose you have an application that provides different payment methods for customers, 
such as credit card, PayPal, or bank transfer. Each payment method has its own algorithm for processing payments. 
You could implement the different payment methods as separate classes, but this could result in a lot of duplicate code. 
Alternatively, you could use the Strategy pattern to define a family of algorithms for processing payments, 
with each algorithm implemented as a separate class. This would allow you to change the payment method dynamically, 
based on the customer's preferences, without having to modify the code for the application's core logic.
*/

/*

+----------------+                  +-----------------------+
| PaymentStrategy|<-----------------|CreditCardStrategy     |
+----------------+                  +-----------------------+
| -pay(int)      |                  | -name: String         |
+----------------+                  | -cardNumber: String   |
    ^                               | -cvv: String          |
    |                               | -dateOfExpiry: String |
    |                               +-----------------------+
	|
	|
	|
+---------------------+
| PayPalStrategy      |
+---------------------+
| -emailId: String    |
| -password: String   |
+---------------------+
                                     
+-----------------------+                     	+--------------+
|  ShoppingCart			|                     	|      Item    |
+-----------------------+                     	+--------------+
| -items: List<Item>    |            			| -name: String|
+-----------------------+                    	| -price: int  |
| +addItem(Item) 		|                   	+--------------+
| +removeItem(Item) 	|
| +calculateTotal(): int|
| +pay(PaymentStrategy)	|
+-----------------------+


*/