package com.rajeshkawali.designpattern.singletonpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class SingleToneMain {

	public static void main(String[] args) {
		// illegal construct Compile Time Error: The constructor SingleObject() is not visible
		// SingleTon object = new SingleTon();

		// Get the only object available
		SingleTonEagerInitialization object = SingleTonEagerInitialization.getInstanceOfSingleTon();

		// show the message
		object.showMessage();

	}

}
