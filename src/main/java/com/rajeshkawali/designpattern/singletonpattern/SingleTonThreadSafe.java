package com.rajeshkawali.designpattern.singletonpattern;

/**
 * @author Rajesh_Kawali
 *
 */
public class SingleTonThreadSafe {

	// private static reference instance
	private static SingleTonThreadSafe instance;

	// private constructor
	private SingleTonThreadSafe() {

	}

	// synchronized method to control simultaneous access instance
	synchronized public static SingleTonThreadSafe getInstance() {
		if (instance == null) {// if instance is null, then initialize
			instance = new SingleTonThreadSafe();
		}
		return instance;
	}
}
