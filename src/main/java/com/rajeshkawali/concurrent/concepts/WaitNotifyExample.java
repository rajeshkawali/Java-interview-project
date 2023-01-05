package com.rajeshkawali.concurrent.concepts;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Rajesh_Kawali
 */
public class WaitNotifyExample {
	/*
	The wait() and notify() methods are used to synchronize the execution of threads and to communicate between them. 
	The wait() method causes the calling thread to wait until it is notified, while the notify() method wakes up a single waiting thread, 
	and the notifyAll() method wakes up all waiting threads.

	These methods are part of the Object class and are called on an object that is used for synchronization. 
	When a thread calls the wait() method on an object, it releases the lock on the object and goes to sleep. 
	When another thread calls the notify() or notifyAll() method on the same object, it wakes up one or all waiting threads, respectively. 
	The waiting threads reacquire the lock on the object and continue execution.
	*/
	public static void main(String[] args) {
		// create an object to be used for synchronization
		final Object sync = new Object();
		// create and start two threads that use the object for synchronization
		new Thread(new Thread1(sync)).start();
		new Thread(new Thread2(sync)).start();
	}
}

class Thread1 implements Runnable {
	private Object sync;

	public Thread1(Object sync) {
		this.sync = sync;
	}

	@Override
	public void run() {
		try {
			// lock the object
			synchronized (sync) {
				// wait for the signal
				sync.wait();
				System.out.println("Thread 1: received signal");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread2 implements Runnable {
	
	private Object sync;

	public Thread2(Object sync) {
		this.sync = sync;
	}

	@Override
	public void run() {
		try {
			// sleep for a while
			TimeUnit.SECONDS.sleep(2);

			// lock the object
			synchronized (sync) {
				// send the signal
				sync.notify();
				System.out.println("Thread 2: sent signal");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/*

Some key points to consider while implementing the wait() and notify() methods for inter-thread communication:-

1.The wait(), notify(), and notifyAll() methods must be called within a synchronized block. This ensures that the 
	lock on the object is held by the current thread, and that the methods are called in a thread-safe manner.

2.The wait() method releases the lock on the object, allowing other threads to acquire 
	the lock and access the shared resource. Therefore, it should be called after the shared resource has been updated.

3.The notify() and notifyAll() methods should be called after the shared resource has been updated and 
	before the current thread exits the synchronized block. This ensures that the waiting threads are 
	notified and have a chance to acquire the lock and access the updated resource.

4.It is recommended to use the wait(), notify(), and notifyAll() methods only for short-term waiting, 
	as they can lead to deadlock and livelock if used improperly. For long-term waiting, it is better 
	to use other synchronization mechanisms such as CountDownLatch, CyclicBarrier, or Semaphore.

5.It is also recommended to use the wait(), notify(), and notifyAll() methods only when the 
	shared resource is in a consistent state. If the shared resource is in an inconsistent state, 
	it is better to use other synchronization mechanisms that provide a more structured way of waiting and signaling, such as Condition.
*/