package com.rajeshkawali.concurrent.concepts;

public class SynchronizedCounter {

	/*
	 Synchronization is used to control the access of shared resources or critical
	 sections of code by multiple threads to avoid race conditions and maintain
	 thread safety. There are three ways to achieve synchronization in Java:-->
	 
	 Static Synchronization:- Static synchronization is used when we want to
	 synchronize a block or method for the entire class rather than individual
	 objects. It uses the "synchronized" keyword with a static method or a static
	 block. This ensures that only one thread can execute the synchronized block
	 or method at a time for the entire class.
	 
	 Synchronized Method:- Synchronized method is used when we want to synchronize
	 a method for a specific object. It uses the "synchronized" keyword with a
	 method. This ensures that only one thread can execute the synchronized method
	 at a time for that object.
	 
	 Synchronized Block:- Synchronized block is used when we want to synchronize a
	 block of code rather than an entire method. It uses the "synchronized"
	 keyword with a block of code enclosed within curly braces. This ensures that
	 only one thread can execute the synchronized block of code at a time.
	 
	 */

	private static int count = 0;
	private Object lock = new Object();

	public static synchronized void incrementStatic() {
		count++;
	}

	public synchronized void increment() {
		count++;
	}

	public void incrementBlock() {
		synchronized (lock) {
			count++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedCounter counter = new SynchronizedCounter();
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				SynchronizedCounter.incrementStatic();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter.increment();
			}
		});

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter.incrementBlock();
			}
		});

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println("Count: " + count);
	}
}

/*
 In this example, incrementStatic() is a static synchronized method,
 increment() is an instance synchronized method, and incrementBlock() is a
 synchronization block using an instance variable lock. All three methods
 increment a static variable count by 1, and the main method starts three
 threads to call each method 10,000 times. The output should be Count: 30000
 if all three synchronization methods work correctly.
 
 */

/*
 synchronized block: A synchronized block is used to synchronize access to a
 block of code or object. It requires a lock object on which the thread will
 synchronize. Multiple threads can access different synchronized blocks of the
 same object simultaneously.
 
 synchronized method: A synchronized method is used to synchronize access to
 an entire method. It requires a lock on the object itself, and only one
 thread can execute the method at a time.
 
 static synchronized method: A static synchronized method is used to
 synchronize access to a static method, which means the lock is held on the
 Class object of the class. This allows only one thread to execute the static
 synchronized method at a time, regardless of the number of instances of the class.
 */
