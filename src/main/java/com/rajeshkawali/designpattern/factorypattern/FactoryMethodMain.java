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