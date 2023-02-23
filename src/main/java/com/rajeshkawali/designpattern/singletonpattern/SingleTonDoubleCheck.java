package com.rajeshkawali.designpattern.singletonpattern;


/**
 * @author Rajesh_Kawali
 *
 */
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
so that minimum number of threads have to wait and that's only for first time.
*/

/*
In this pattern, the class has a private constructor, and only one instance of the class 
is allowed to be created throughout the program's lifetime.

In the code, the static variable instance is declared as volatile to make it visible to all threads. 
The volatile keyword ensures that any changes to the instance variable are visible to all threads, 
and it is not cached in any thread's local memory.

The getInstance() method checks if the instance is null or not. If it is null, the synchronized block 
is executed to create a new instance of the Singleton class.

The synchronized block ensures that only one thread enters at a time, and the instance is created only once. 
The if condition inside the synchronized block checks again if the instance is null or not, as it is possible 
that multiple threads are waiting for the lock, and another thread has already created the instance.

If the instance is not null, the method simply returns the instance. This approach of double-checked locking 
can improve performance by avoiding the overhead of obtaining the lock every time the method is called, 
as the synchronized block is executed only if the instance is null.

This pattern ensures that the Singleton object is created only when it is required, and thread-safety is 
maintained as only one thread can execute the synchronized block at a time.
*/