package com.rajeshkawali.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Rajesh_Kawali
 */
public class CyclicBarrierExample {
	/*
	 A CyclicBarrier is a synchronization mechanism that allows multiple threads
	 to wait for each other to reach a certain point before continuing. 
	 It is useful when you want to run multiple threads concurrently, but you want to
	 wait until all threads have completed some work before moving on to the next step.
	*/
	public static void main(String args[]) {

		// creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				// This task will be executed once all thread reaches barrier
				System.out.println("All parties are arrived at barrier, lets play");
			}
		});
		// Creating Thread and starting each of thread
		Thread t1 = new Thread(new CyclicBarrierWorker(cb), "Thread 1");
		Thread t2 = new Thread(new CyclicBarrierWorker(cb), "Thread 2");
		Thread t3 = new Thread(new CyclicBarrierWorker(cb), "Thread 3");

		t1.start();
		t2.start();
		t3.start();
	}
}

class CyclicBarrierWorker implements Runnable {

	private CyclicBarrier barrier;

	public CyclicBarrierWorker(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
			barrier.await();// wait for other threads to reach the barrier
			System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
		} catch (Exception ex) {
			Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
/*
1.getNumberWaiting():- returns the number of threads currently waiting at the barrier.
2.getParties():- returns the number of threads that must wait at the barrier for the barrier to be tripped.
3.await():- waits for all parties to arrive at the barrier. Returns the number of parties still waiting when the current thread was released from the barrier. If the current thread is not the last to arrive, then it is disabled for thread scheduling purposes and lies dormant until one of the following things happens:
	all parties arrive at the barrier;
	the barrier is reset; or
	the thread is interrupted.
4.await(long timeout, TimeUnit unit):- waits for all parties to arrive at the barrier, or the specified timeout expires. Returns the number of parties still waiting when the current thread was released from the barrier, or -1 if the barrier was reset or the timeout expired.
5.reset():- resets the barrier to its initial state. All threads currently waiting at the barrier are released and any subsequent calls to await() will block until the number of threads waiting at the barrier is equal to the parties given to the constructor.
6.isBroken():- returns true if the barrier is in a broken state, and false otherwise. A barrier is in a broken state if reset() has been called, or if any thread was interrupted while waiting at the barrier.
7.CyclicBarrier(int parties):- constructs a new CyclicBarrier that will trip when the given number of parties (threads) are waiting upon it.
8.CyclicBarrier(int parties, Runnable barrierAction):- constructs a new CyclicBarrier that will trip when the given number of parties (threads) are waiting upon it, and will execute the given barrier action when the barrier is tripped.
*/

/*
Differences between CountDownLatch and CyclicBarrier:

CountDownLatch is useful when you want to wait for a set of operations to complete, whereas CyclicBarrier is useful when you want to run multiple threads concurrently, but wait until all threads have completed some work before moving on to the next step.

CountDownLatch can only be used once, whereas CyclicBarrier can be reused multiple times.

CountDownLatch has a single countDown() method that decreases the count by 1, whereas CyclicBarrier has a reset() method that resets the barrier to its initial state and releases all threads waiting at the barrier.

CountDownLatch has a getCount() method that returns the current count, whereas CyclicBarrier has a getNumberWaiting() method that returns the number of threads currently waiting at the barrier.
 */