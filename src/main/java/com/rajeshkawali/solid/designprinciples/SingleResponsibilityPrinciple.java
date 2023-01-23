package com.rajeshkawali.solid.designprinciples;

class Invoice {
	public double calculateTotal() {
		// code to calculate total
		return 0;
	}
}

class InvoicePrinter {
	public void printInvoice(Invoice invoice) {
		// code to print invoice
	}
}

class InvoiceSaver {
	public void saveInvoice(Invoice invoice) {
		// code to save invoice
	}
}

public class SingleResponsibilityPrinciple {
	/*
	Single Responsibility Principle:
	A class should have one and only one reason to change.
	For example, in Java, consider a class named "Invoice" that is responsible for calculating the total amount, 
	printing and saving the invoice. To adhere to the Single Responsibility Principle, we should split the class 
	into three separate classes: "Invoice", "InvoicePrinter" and "InvoiceSaver" each class 
	should be responsible for one specific task.
	*/
	public static void main(String[] args) {

	}

}
