package com.rajeshkawali.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajesh_Kawali
 */
public class CountDownLatchExample {
	/*
	A CountDownLatch is a concurrency utility in the Java concurrency library 
	that allows one or more threads to wait for a given number of events to occur. 
	It is initialized with a count, and the count can be decremented using the countDown method. 
	Threads can call the await method to block until the count reaches zero.
	*/
	public static void main(String args[]) {
		
		// Create a CountDownLatch with a count of 3
		final CountDownLatch latch = new CountDownLatch(3);
		
		// Create and start three threads that will decrement the CountDownLatch
		Thread orderRequest = new Thread(new Service("OrderRequestService", 1000, latch));
		Thread orderPayment = new Thread(new Service("OrderPaymentService", 1000, latch));
		Thread orderNotification = new Thread(new Service("OrderNotificationService", 1000, latch));

		orderRequest.start(); // separate thread will initialize for OrderRequest
		orderPayment.start(); // another thread for OrderPayment for initialization
		orderNotification.start();// another thread for OrderNotification for initialization

		// application should not start processing any thread until all service is up
		// and ready to do there job.
		// Countdown latch is idle choice here, main thread will start with count 3
		// and wait until count reaches zero. each thread once up and read will do
		// a count down. this will ensure that main thread is not started processing
		// until all services is up.

		// count is 3 since we have 3 Threads (Services)
		try {
			latch.await(); // main thread is waiting on CountDownLatch to finish
			// The main thread will continue execution when the CountDownLatch count reaches to zero
			System.out.println("All services are up and running, Now you can start ordering");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

/**
 * Service class which will be executed by Thread using CountDownLatch
 * synchronizer.
 */
class Service implements Runnable {
	
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;

	public Service(String name, int timeToStart, CountDownLatch latch) {
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException ex) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(name + " is Up");
		latch.countDown(); // reduce count of CountDownLatch by 1
	}
}
/*
1.countDown():- This method decrements the count of the latch, releasing all waiting threads if the count reaches to zero.

2.getCount():- This method returns the current count of the latch.

3.await():- This method causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted.

4.await(long timeout, TimeUnit unit):- This method causes the current thread to wait until the latch has counted down to zero, 
	unless the thread is interrupted or the specified waiting time elapses.
*/

/*
Differences between CountDownLatch and CyclicBarrier:-->

CountDownLatch is useful when you want to wait for a set of operations to complete, 
whereas CyclicBarrier is useful when you want to run multiple threads concurrently, 
but wait until all threads have completed some work before moving on to the next step.

CountDownLatch can only be used once, whereas CyclicBarrier can be reused multiple times.

CountDownLatch has a single countDown() method that decreases the count by 1, 
whereas CyclicBarrier has a reset() method that resets the barrier to its initial state 
and releases all threads waiting at the barrier.

CountDownLatch has a getCount() method that returns the current count, 
whereas CyclicBarrier has a getNumberWaiting() method that returns the number of threads currently waiting at the barrier.
 */

