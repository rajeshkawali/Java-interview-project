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
//------------------------------------------Example2-----------------------------------------
interface ILogger {
    void log(String message);
}

class ConsoleLogger implements ILogger {
    public void log(String message) {
        System.out.println("[ConsoleLogger] " + message);
    }
}

class FileLogger implements ILogger {
    public void log(String message) {
        System.out.println("[FileLogger] " + message);
    }
}

class Client {
    private ILogger logger;
    
    public Client(ILogger logger) {
        this.logger = logger;
    }
    
    public void doSomething() {
        logger.log("Doing something...");
    }
}

class Main {
    public static void main(String[] args) {
        ILogger logger = new FileLogger();
        Client client = new Client(logger);
        client.doSomething();
        
        logger = new ConsoleLogger();
        client = new Client(logger);
        client.doSomething();
    }
}
/*
In this example, we have an interface ILogger that defines a log method. 
We also have two concrete classes ConsoleLogger and FileLogger that implement the ILogger interface.

The Client class takes an ILogger object as a constructor argument and 
uses it to log a message in the doSomething method. By depending on the ILogger interface, 
the Client class is not tightly coupled to any specific implementation of the ILogger.

In the Main class, we create instances of FileLogger and ConsoleLogger and pass 
them to the Client object. The Client object uses the ILogger object to log a message, 
but it does not know or care which specific implementation of ILogger is being used.
*/