package com.rajeshkawali.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Rajesh_Kawali
 */
public class ConditionExample {

	/*
	 The Condition class is used to provide a blocking mechanism for threads that need to wait for a condition to be met. 
	 It is associated with a Lock object and can be obtained by calling the newCondition() method of the Lock interface.
	 
	 The Condition class is used to synchronize the execution of threads and to control the access to shared resources. 
	 It allows threads to block their execution until a certain condition is met, and to be notified when the condition is met. 
	 It is an alternative to using Object.wait() and Object.notify() for thread synchronization.
	 */
	public static void main(String[] args) {
		// create a lock and a condition
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		// create and start two threads that use the condition
		new Thread(new ThreadOne(lock, condition)).start();
		new Thread(new ThreadTwo(lock, condition)).start();
	}
}

class ThreadOne implements Runnable {

	private Lock lock;
	private Condition condition;

	public ThreadOne(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		try {
			lock.lock();
			System.out.println("Thread 1: waiting");
			condition.await();
			System.out.println("Thread 1: awake");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class ThreadTwo implements Runnable {

	private Lock lock;
	private Condition condition;

	public ThreadTwo(Lock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		try {
			lock.lock();
			System.out.println("Thread 2: signaling");
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}

/*
1.await():- Causes the calling thread to wait until it is signaled or until the specified time has elapsed.
2.signal():- Wakes up a single waiting thread.
3.signalAll():- Wakes up all waiting threads.
*/