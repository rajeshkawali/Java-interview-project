package com.rajeshkawali.solid.designprinciples;

class Invoice {
    // Responsible only for calculating the total amount
    public double calculateTotal() {
        // simple fixed amount for example
        return 1000 + 150; // amount + tax
    }
}

class InvoicePrinter {
    // Responsible only for printing the invoice
    public void printInvoice(Invoice invoice) {
        System.out.println("Total amount: " + invoice.calculateTotal());
    }
}

class InvoiceSaver {
    // Responsible only for saving the invoice
    public void saveInvoice(Invoice invoice) {
        System.out.println("Invoice saved with total: " + invoice.calculateTotal());
    }
}

public class SingleResponsibilityPrinciple {
	 /*
    Single Responsibility Principle (SRP):
    A class should have only one reason to change, meaning it should have one responsibility.
    For example, an "Invoice" class should only calculate the total amount.
    Printing and saving the invoice should be handled by separate classes,
    such as "InvoicePrinter" and "InvoiceSaver", respectively.
   */
    public static void main(String[] args) {
        Invoice invoice = new Invoice();

        InvoicePrinter printer = new InvoicePrinter();
        InvoiceSaver saver = new InvoiceSaver();

        printer.printInvoice(invoice); // prints total
        saver.saveInvoice(invoice);     // saves invoice
    }
}