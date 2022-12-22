package com.rajeshkawali.designpattern.singletonpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class SingleTonEagerInitialization {

	// create Single Tone class object and assign it to static final reference
	private static final SingleTonEagerInitialization instance = new SingleTonEagerInitialization(); // Eager initialisation

	// make the constructor private so that this class cannot be instantiated
	private SingleTonEagerInitialization() {
	}

	// Allow to access only available object
	public static SingleTonEagerInitialization getInstanceOfSingleTon() {
		//instance = new SingleTon(); //Lazy initialisation
		return instance;
	}

	public void showMessage() {
		System.out.println("Single ton Design Pattern");
	}

}