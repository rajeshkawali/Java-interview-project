package com.rajeshkawali.designpattern.singletonpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class SingleTonLazyInitialization {

	// create Single Tone class static reference
	private static SingleTonLazyInitialization instance;

	// make the constructor private so that this class cannot be instantiated
	private SingleTonLazyInitialization() {
	}

	// Allow to access only available object
	public static SingleTonLazyInitialization getInstanceOfSingleTon() {
		if (instance == null) {
			// if instance is null, initialize
			instance = new SingleTonLazyInitialization();// Lazy initialisation
		}
		return instance;
	}

	public void showMessage() {
		System.out.println("Single ton Design Pattern");
	}
}
