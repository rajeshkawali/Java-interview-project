package com.rajeshkawali.concurrent;

import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author Rajesh_Kawali
 */
public class PhaserExample {
	/*
	 * Phaser is a class that represents a reusable synchronization barrier, similar
	 * to a CyclicBarrier. It allows multiple threads to wait for each other to
	 * reach a certain point (called a "phase") before continuing.
	 */
	public static void main(String[] args) {

		// int numThreads = 3;
		// Phaser phaser = new Phaser(numThreads);
		
		Phaser phaser = new Phaser();
		phaser.register();
		int currentPhase;
		
		// Creating Thread
		Thread t1 = new Thread(new PhaserWorker(phaser), "Thread 1");
		Thread t2 = new Thread(new PhaserWorker(phaser), "Thread 2");
		Thread t3 = new Thread(new PhaserWorker(phaser), "Thread 3");
		// Starting thread
		t1.start();
		t2.start();
		t3.start();

		// Wait for all threads to complete phase Zero.
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		System.out.println("Phase Zero Ended");

		// Wait for all threads to complete phase One.
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		System.out.println("Phase One Ended");

		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.println("Phase " + currentPhase + " Complete");
		System.out.println("Phase Two Ended");

		// Deregister the main thread.
		phaser.arriveAndDeregister();
		if (phaser.isTerminated()) {
			System.out.println("Phaser is terminated");
		}

		// wait for all threads to complete phase 1
		//phaser.awaitAdvance(phaser.getPhase());
		// all threads have completed phase 1, do some work
		//System.out.println("Completed phase 1");
		// advance to phase 2
		//phaser.arriveAndAwaitAdvance();
		// all threads have completed phase 2, do some more work
		//System.out.println("Completed phase 2");
		// advance to phase 3
		//phaser.arriveAndAwaitAdvance();
		// all threads have completed phase 3
		//System.out.println("Completed phase 3");
		// get the current phase number
		//int phase = phaser.getPhase();
		//System.out.println("Current phase: " + phase);
		// get the number of registered parties
		//int parties = phaser.getRegisteredParties();
		//System.out.println("Number of registered parties: " + parties);
		// get the number of arrived parties
		//int arrived = phaser.getArrivedParties();
		//System.out.println("Number of arrived parties: " + arrived);
		// get the number of unarrived parties
		//int unarrived = phaser.getUnarrivedParties();
		//System.out.println("Number of unarrived parties: " + unarrived);
	}
}

class PhaserWorker implements Runnable {
	private Phaser phaser;
	public PhaserWorker(Phaser barrier) {
		this.phaser = barrier;
	}
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " is waiting on phase 1 of code");
		phaser.arriveAndAwaitAdvance();// creating a barrier for other threads to reach the barrier
		System.out.println(Thread.currentThread().getName() + " has crossed the phase 1 of code");
		try {
			Thread.sleep(99);
		} catch (Exception ex) {
			Logger.getLogger(PhaserExample.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(Thread.currentThread().getName() + " is waiting on phase 2 of code");
		phaser.arriveAndAwaitAdvance();// creating a barrier for other threads to reach the barrier
		System.out.println(Thread.currentThread().getName() + " has crossed the phase 2 of code");
		try {
			Thread.sleep(499);
		} catch (InterruptedException ex) {
			Logger.getLogger(PhaserExample.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(Thread.currentThread().getName() + " is waiting on phase 3 of code");
		phaser.arriveAndAwaitAdvance();// creating a barrier for other threads to reach the barrier
		System.out.println(Thread.currentThread().getName() + " has crossed the phase 3 of code");
		
		System.out.println(Thread.currentThread().getName() + " is Deregister from barrier");
		phaser.arriveAndDeregister();
		if (phaser.isTerminated()) {
			System.out.println(Thread.currentThread().getName() + " is terminated");
		}
	}
}
/*
1.register() – This method is used to register parties after a phaser has been constructed. It returns the phase number of the phase to which it is registered.

2.arrive() – This method signals that a thread has completed some portion of the task. It does not suspend the execution of the calling thread. It returns the current phase number or a negative value if the phaser has been terminated.

3.arriveAndDeregister() – This method enables a thread to arrive at a phase and deregister itself, without waiting for other threads to arrive. It returns the current phase number or a negative value if the phaser has been terminated.

4.arriveAndAwaitAdvance() – This method suspends the execution of the thread at a phase, to wait for other threads. It returns the current phase number or a negative value if the phaser has been terminated.

5.getPhase() – This method returns the current phase number. A negative value is returned if the invoking phasers terminated.

6.onAdvance(int phase, int parties) – This method helps in defining how a phase advancement should occur. To do this, the user must override this method. To terminate the phaser, onAdvance() method returns true, otherwise, it returns false;

*/

/*
CountDownLatch:- is a one-shot synchronization mechanism. 
It allows one or more threads to wait for a set of operations to complete. 
Once the latch reaches count zero, all waiting threads are released. 
A CountDownLatch cannot be reset, so it must be created anew if you want to use it again.

CyclicBarrier:- is a reusable synchronization mechanism. 
It allows multiple threads to wait for each other to reach a certain point 
before continuing. Once all threads have reached the barrier, 
they are released and the barrier is reset, allowing the process to be repeated.

Phaser:- is a reusable synchronization mechanism similar to CyclicBarrier, 
but it is more flexible and can be used to synchronize threads across multiple phases. 
Like CyclicBarrier, it allows multiple threads to wait for each other to reach a 
certain point before continuing. However, a Phaser can be advanced to the next phase explicitly, 
rather than having to wait for all threads to arrive at the barrier.

*/

/*
Key differences between CountDownLatch, CyclicBarrier, and Phaser:

1.CountDownLatch is useful when you want to wait for a set of operations to complete, 
	whereas CyclicBarrier and Phaser are useful when you want to run multiple threads concurrently, 
	but wait until all threads have completed some work before moving on to the next step.

2.CountDownLatch can only be used once, whereas CyclicBarrier and Phaser can be reused multiple times.

3.CountDownLatch has a single countDown() method that decreases the count by 1, 
	whereas CyclicBarrier has a reset() method that resets the barrier to its initial state and 
	releases all threads waiting at the barrier, and Phaser has an arriveAndAwaitAdvance() method 
	that causes the current thread to arrive at the phaser and wait for all other registered parties to arrive, 
	and an arriveAndDeregister() method that causes the current thread to arrive at the phaser and deregister from it, 
	so it is not required to wait for future phases.

4.CountDownLatch has a getCount() method that returns the current count, 
	whereas CyclicBarrier has a getNumberWaiting() method that returns the number of threads 
	currently waiting at the barrier, and Phaser has a getRegisteredParties() method 
	that returns the number of parties registered with this phaser.
*/


/*
In a hypothetical theater:-

Mutex:- It is called Mutex if only one person is allowed to watch the play.

Semaphore:- It is called Semaphore if N number of people are allowed to watch the play. If anybody leaves the 
	Theater during the play then other person can be allowed to watch the play.

CountDownLatch:- It is called CountDownLatch if no one is allowed to enter until every person vacates the theater. 
	Here each person has free will to leave the theater.

CyclicBarrier:- It is called CyclicBarrier if the play will not start until every person enters the theater. 
	Here a showman can not start the show until all the persons enter and grab the seat. Once the play is 
	finished the same barrier will be applied for next show.

Here, a person is a thread, a play is a resource.
*/
