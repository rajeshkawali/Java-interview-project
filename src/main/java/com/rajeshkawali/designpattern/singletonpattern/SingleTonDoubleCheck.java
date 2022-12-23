package com.rajeshkawali.designpattern.singletonpattern;


/**
 * @author Rajesh_Kawali
 *
 */
//Thread Safe Singleton in Java.
public class SingleTonDoubleCheck {
	
	private static volatile SingleTonDoubleCheck instance; // We have to use static and volatile.
	
	// private constructor
	private SingleTonDoubleCheck() {
	}

	public static SingleTonDoubleCheck getInstance() {
		if (instance == null) { // if instance is null then get inside
			synchronized (SingleTonDoubleCheck.class) { // Make sure to allow only one thread into the block
				if (instance == null) {
					instance = new SingleTonDoubleCheck();
				}
			}
		}
		return instance;
	}
}

/*
we overcome the overhead problem of synchronized code. 
In this method, getInstance is not synchronized but the block which creates instance is synchronized 
so that minimum number of threads have to wait and that’s only for first time.
*/