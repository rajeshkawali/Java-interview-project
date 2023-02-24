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


/*
 here are the steps to implement Singleton design pattern in Java:-->

Create a private static variable of the Singleton class that will hold the single instance of the class.
Create a private constructor for the Singleton class to prevent other classes from instantiating it directly.
Create a public static method that returns the single instance of the class. This method should check if the private static variable is null, and if it is, it should create a new instance of the Singleton class and assign it to the private static variable. If the variable is not null, the method should simply return the existing instance.
(Optional) You can also make the private static variable final to ensure that it can only be set once during initialization.
(Optional) If you want to ensure that the Singleton class cannot be cloned, you can override the clone() method and throw a CloneNotSupportedException.
*/

