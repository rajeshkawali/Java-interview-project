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
/*
Singleton is a creational design pattern that lets you ensure that a 
class has only one instance, while providing a global access point to this instance.

How to create:
1.Make the default constructor private, to prevent other objects from using the 
new operator with the Singleton class.

2.Create a static creation method that acts as a constructor. 
Under the hood, this method calls the private constructor to create an 
object and saves it in a static field. All following calls to this method 
return the cached object.
*/