package com.rajeshkawali.designpattern.facadepattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class FacadeMain {

	public static void main(String[] args) {
		FacadeParserClass facadeParserCaller = new FacadeParserClass();
		System.out.println("Start Execution");
		facadeParserCaller.textParser();
		facadeParserCaller.csvParser();
		facadeParserCaller.pdfParser();
		System.out.println("Done Execution");
	}
}

/*
  Facade pattern hides the complexities of the system and provides an interface
  to the client using which the client can access the system. This type of
  design pattern comes under structural pattern as this pattern adds an
  interface to existing system to hide its complexities.
  
  This pattern involves a single class which provides simplified methods
  required by client and delegates calls to methods of existing system classes.
*/

/*
Here are the steps to implement the Facade design pattern in Java:-->

Identify a complex subsystem that needs to be simplified for client code.

Create a Facade class that provides a simplified interface to the subsystem. The Facade should manage the interactions between the subsystem and the client, and should shield the client from the complexity of the subsystem.

Create one or more classes to represent the subsystem. These classes should implement the actual functionality of the subsystem.

Define a set of public methods in the Facade class that provide the simplified interface for the client.

In the implementation of each public method, use the classes that represent the subsystem to perform the actual work.

The client can now use the Facade class to interact with the subsystem without needing to know about the complexity of the subsystem's implementation.
*/

