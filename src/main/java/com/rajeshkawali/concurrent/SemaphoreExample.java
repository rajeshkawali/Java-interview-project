package com.rajeshkawali.concurrent;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author Rajesh_Kawali
 */
public class SemaphoreExample {
	/*
	 Semaphore is a concurrency utility that controls the access of multiple threads to a shared resource. 
	 It is a counting semaphore, which means that it has a set of permits 
	 that are granted to threads that want to access the shared resource.
	 
	 The Semaphore class is useful for limiting the number of threads that can access a 
	 shared resource concurrently and for coordinating the access of multiple threads to the resource.
	 */
	public static void main(String[] args) {
		// create a semaphore with a limit of 3 permits, means it can allow 3 threads to access shared resource.
		Semaphore semaphore = new Semaphore(3);

		// create and start 5 threads that try to acquire a permit from the semaphore Creating Thread
		Thread t1 = new Thread(new SemaphoreWorker(semaphore), "Thread 1");
		Thread t2 = new Thread(new SemaphoreWorker(semaphore), "Thread 2");
		Thread t3 = new Thread(new SemaphoreWorker(semaphore), "Thread 3");
		Thread t4 = new Thread(new SemaphoreWorker(semaphore), "Thread 4");
		Thread t5 = new Thread(new SemaphoreWorker(semaphore), "Thread 5");
		// Starting thread
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	} 
}

class SemaphoreWorker implements Runnable {
	private Semaphore semaphore;

	public SemaphoreWorker(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			// try to acquire a permit from the semaphore
			semaphore.acquire();
			// if the permit is acquired, access the shared resource and release the permit when done
			System.out.println("Thread " + Thread.currentThread().getName() + ": acquired a permit");
			Thread.sleep(1500);
			System.out.println("Thread " + Thread.currentThread().getName() + ": releasing a permit");
			semaphore.release();
		} catch (InterruptedException ex) {
			Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

/*
1.acquire(): Tries to acquire a permit from the semaphore. If a permit is available, it is acquired and the method returns immediately. If no permits are available, the calling thread is blocked until a permit becomes available.
2.acquire(int permits): Tries to acquire the given number of permits from the semaphore. If the specified number of permits is available, they are all acquired and the method returns immediately. If not, the calling thread is blocked until the required number of permits becomes available.
3.release(): Releases a permit back to the semaphore. If there are threads waiting for a permit, one of them is unblocked and acquires a permit.
4.release(int permits): Releases the given number of permits back to the semaphore. If there are threads waiting for permits, they are unblocked and acquire the available permits.
5.availablePermits(): Returns the number of available permits in the semaphore.
6.getQueueLength(): Returns the number of threads waiting to acquire a permit from the semaphore.
7.hasQueuedThreads(): Returns true if there are threads waiting to acquire a permit from the semaphore, false otherwise.
8.drainPermits(): Acquires and returns all available permits from the semaphore. If there are no permits available, the method returns 0.
*/

/*

Mutex, Semaphore, CountDownLatch, CyclicBarrier, Phaser, Exchanger, Condition, and ReentrantLock are 
all synchronization constructs that are used in computer programming to coordinate 
the access to shared resources by multiple threads:-->

Mutex:- is a type of lock that ensures that only one thread can access a shared resource at a time. 
It is typically used to protect critical sections of code that should not be executed by multiple threads simultaneously.

Semaphore:- is a synchronization object that controls access to a shared resource that has a limited capacity. 
It allows multiple threads to access the shared resource at the same time, up to a specified limit. 
If the limit is reached, the semaphore will block any additional threads from accessing the resource 
until some other thread releases it.

CountDownLatch:- is a synchronization object that allows one or more threads to wait for a 
set of events to occur before continuing. It is typically used to coordinate the execution of 
multiple threads that need to wait for a certain condition before proceeding.

CyclicBarrier:- is a synchronization object that allows a group of threads to wait for each 
other to reach a certain point before continuing. It is typically used to coordinate the 
execution of multiple threads that need to perform a task together and need to 
synchronize their progress periodically.

Phaser:- is a synchronization construct that allows multiple threads to synchronize with 
each other at certain phases of execution. It is similar to a CyclicBarrier but with more flexibility.

Exchanger:- is a synchronization construct that allows two threads to exchange objects with each other.

Condition:- is a synchronization construct that allows a thread to wait for a certain condition 
to be true before proceeding. It is typically used in conjunction with a lock.

ReentrantLock:- is a synchronization construct that allows a thread to acquire a lock multiple 
times, as long as it releases the lock the same number of times. It provides more flexibility 
than a Mutex, but requires more careful management.
*/