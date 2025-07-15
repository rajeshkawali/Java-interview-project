package com.rajeshkawali.solid.designprinciples;

interface Payment {
    void pay(double amount);
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
    @Override
    public void pay(double amount) {
        // code to process Paypal payment
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        // code to process Credit Card payment
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

public class DependencyInversionPrinciple {
    /*
     Dependency Inversion Principle (DIP):

     High-level modules should not depend on low-level modules; both should depend on abstractions.
     For example, consider a class named "Order" that depends on a specific implementation 
     of a "Payment" class named "PaypalPayment". 

     To follow DIP, we create an abstraction "Payment" (interface) and have "Order" depend on this
     abstraction rather than a concrete implementation.

     This allows us to change payment methods without modifying the "Order" class.
    */
    public static void main(String[] args) {
        // Using Paypal payment
        Payment paypal = new PaypalPayment();
        Order order1 = new Order(paypal);
        order1.checkout(100);

        // Using Credit Card payment
        Payment creditCard = new CreditCardPayment();
        Order order2 = new Order(creditCard);
        order2.checkout(250);
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