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