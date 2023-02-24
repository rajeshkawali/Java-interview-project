package com.rajeshkawali.designpattern.factorypattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class FactoryMethodMain {

	public static void main(String[] args) {
		ParserFactoryClass pfc = new ParserFactoryClass();
		System.out.println("Start Execution");
		//String value = pfc.getParserObject("csv");
		String value = pfc.getParserObject("pdf");
		//String value = pfc.getParserObject("txt");
		//String value = pfc.getParserObject(null);
		System.out.println("Done Execution of "+value);
	}
}
/*
Factory pattern, we create object without exposing the creation logic to the 
client and refer to newly created object using a common interface.

Design pattern comes under creational pattern as this pattern provides 
one of the best ways to create an object.
*/

/*
The steps to implement Factory Pattern in Java are:-->

Define a common interface or abstract class: Define an interface or abstract class that all concrete classes will implement.

Create concrete classes: Create concrete classes that implement the interface or extend the abstract class.

Create the factory class: Create a factory class that will create instances of the concrete classes based on some input.

Implement the factory method: Implement a method in the factory class that creates and returns the desired object.

Use the factory to create objects: Call the factory method to create objects, instead of calling the constructor of the concrete classes directly.
*/


