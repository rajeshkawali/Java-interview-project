package com.rajeshkawali.solid.designprinciples;

public class SOLID {
/*
SOLID is an acronym for five design principles for writing maintainable and scalable code. They are:

Single Responsibility Principle: A class should have one and only one reason to change.
Open-Closed Principle: A class should be open for extension but closed for modification.
Liskov Substitution Principle: A derived class should be able to replace its base class without altering the correctness of the program.
Interface Segregation Principle: A class should not be forced to implement interfaces it doesn't use.
Dependency Inversion Principle: High-level modules should not depend on low-level modules; both should depend on abstractions.
*/
	public static void main(String[] args) {

		
		
	}

}
/*
Single Responsibility Principle:
A class should have one and only one reason to change.
For example, a class named "Invoice" should only be responsible for calculating 
the total amount of an invoice and not responsible for printing or saving the invoice.

Open-Closed Principle:
A class should be open for extension but closed for modification.
For example, a class named "Shape" should be open for adding new shapes(like rectangle, circle) 
but closed for modification of existing shape(triangle)

Liskov Substitution Principle:
A derived class should be able to replace its base class without altering the correctness of the program.
For example, a class named "Bird" should be able to replace the base class "Animal" without altering the program's correctness.

Interface Segregation Principle:
A class should not be forced to implement interfaces it doesn't use.
For example, a class named "Bird" should only implement the interface methods it 
needs such as "Fly" and "Sing" instead of implementing all the methods of the "Animals" interface.

Dependency Inversion Principle:
High-level modules should not depend on low-level modules; both should depend on abstractions.
For example, a class named "Order" should not depend on a specific implementation of a 
"Payment" class, but instead depend on an abstraction of the "Payment" class, such as an interface or abstract class.
*/

/*
Single Responsibility Principle:
A class should have one and only one reason to change.
For example, in Java, consider a class named "Invoice" that is responsible 
for calculating the total amount, printing and saving the invoice. To adhere to the 
Single Responsibility Principle, we should split the class into three separate 
classes: "Invoice", "InvoicePrinter" and "InvoiceSaver" each class should be responsible for one specific task.

Open-Closed Principle:
A class should be open for extension but closed for modification.
For example, in Java, consider a class named "Shape" that can be either a 
"Triangle", "Rectangle" or "Circle". We can create a base class "Shape" that contains 
a method "calculateArea()" and extend it to create classes for "Triangle", "Rectangle" 
and "Circle". Now, if we want to add a new shape, we can do so by creating a new class 
without modifying the existing "Shape" class.

Liskov Substitution Principle:
A derived class should be able to replace its base class without altering the correctness of the program.
For example, in Java, consider a class named "Bird" that extends the base 
class "Animal". The "Bird" class should be able to replace the "Animals" class without 
altering the program's correctness. This means that the "Bird" class should override 
the methods of the "Animals" class in a way that is consistent with the behavior of the base class.

Interface Segregation Principle:
A class should not be forced to implement interfaces it doesn't use.
For example, in Java, consider an interface named "Animals" that contains 
methods for "Fly", "Swim" and "Sing". A class named "Bird" should only implement the 
"Fly" and "Sing" methods since birds can fly and sing, but they can't swim. By 
separating the interface into smaller interfaces such as "Flyable" and "Singable" we can avoid this problem.

Dependency Inversion Principle:
High-level modules should not depend on low-level modules; both should depend on abstractions.
For example, in Java, consider a class named "Order" that depends on a 
specific implementation of a "Payment" class named "PaypalPayment". To adhere to 
the Dependency Inversion Principle, we should create an abstraction of the "Payment" class, such as an interface or abstract class named "Payment" and have the "Order" class depend on this abstraction rather than a specific implementation.
*/

/*

*/