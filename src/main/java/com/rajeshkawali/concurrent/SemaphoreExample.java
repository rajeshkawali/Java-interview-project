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
 * =====================================================
 * Semaphore in Java
 * =====================================================
 *
 * Semaphore is a synchronization utility from
 * java.util.concurrent that controls how many threads
 * can access a shared resource concurrently.
 *
 * It maintains a number of permits. A thread must
 * acquire a permit before accessing the resource
 * and should release it after completing its work.
 *
 * HOW IT WORKS:
 *
 * 1. Create a Semaphore with a number of permits.
 *
 *    Semaphore semaphore = new Semaphore(3);
 *
 * 2. acquire() obtains a permit, reducing the
 *    available permit count by 1.
 *
 * 3. If no permits are available, acquire()
 *    blocks until a permit becomes available.
 *
 * 4. release() returns a permit, increasing
 *    the available permit count by 1.
 *
 * 5. With 3 permits, up to 3 threads can access
 *    the protected resource concurrently, assuming
 *    each thread acquires one permit.
 *
 * IMPORTANT METHODS:
 *
 * acquire()           -> Acquires a permit or waits.
 * tryAcquire()        -> Acquires a permit if available.
 * tryAcquire(time, unit)
 *                     -> Waits up to the given timeout.
 * release()           -> Releases a permit.
 * availablePermits()  -> Returns available permit count.
 * drainPermits()      -> Acquires all available permits.
 * getQueueLength()    -> Estimates waiting thread count.
 *
 * IMPORTANT POINTS:
 *
 * 1. Counting Semaphore:
 *    Allows multiple threads to access a resource,
 *    depending on the number of permits.
 *
 * 2. Binary Semaphore:
 *    Initialized with 1 permit, allowing one thread
 *    at a time when permits are used correctly.
 *
 * 3. Supports fair and non-fair modes.
 *    Non-fair is the default.
 *
 * 4. acquire() is interruptible and can throw
 *    InterruptedException.
 *
 * 5. acquireUninterruptibly() waits without
 *    responding to interruption by throwing.
 *
 * 6. Always release acquired permits in a finally
 *    block to avoid permit leaks.
 *
 * 7. Unlike ReentrantLock, Semaphore does not
 *    track thread ownership. Another thread
 *    can release a permit.
 *
 * 8. release() can increase the permit count
 *    beyond its initial value, so permits
 *    must be managed carefully.
 *
 * 9. Semaphore is not reentrant in the same
 *    way as ReentrantLock.
 *
 * COMMON USE CASES:
 *
 * - Limiting concurrent database connections.
 * - Controlling access to a connection pool.
 * - Restricting concurrent API requests.
 * - Managing limited shared resources.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * Semaphore     -> Controls concurrent access using permits.
 * acquire()     -> Takes a permit; waits if unavailable.
 * release()     -> Returns a permit.
 *
 * Semaphore(1)  -> Binary semaphore.
 * Semaphore(3)  -> Up to 3 concurrent permit holders.
 *
 * ReentrantLock -> Mutual exclusion with thread ownership.
 * Semaphore     -> Permit-based concurrency control.
 *
 * =====================================================
 */


/*
 * =====================================================
 * Synchronization Utilities in Java
 * =====================================================
 *
 * Synchronization utilities help multiple threads
 * safely access shared resources and coordinate
 * their execution.
 *
 * 1. Mutex:
 *    Allows only one thread to access a shared
 *    resource at a time.
 *    Used to protect critical sections of code.
 *
 * 2. Semaphore:
 *    Controls access to a resource using permits.
 *    Allows a limited number of threads to access
 *    the resource concurrently.
 *
 * 3. CountDownLatch:
 *    Allows one or more threads to wait until
 *    a specified count reaches zero.
 *    It can be used only once.
 *
 * 4. CyclicBarrier:
 *    Allows a fixed number of threads to wait
 *    for each other at a common point.
 *    It can be reused multiple times.
 *
 * 5. Phaser:
 *    Allows threads to synchronize at different
 *    phases of execution.
 *    Similar to CyclicBarrier, but supports
 *    dynamic registration and deregistration.
 *
 * 6. Exchanger:
 *    Allows two threads to exchange objects
 *    with each other at a synchronization point.
 *
 * 7. Condition:
 *    Allows threads to wait for a specific
 *    condition and be signaled when it may be met.
 *    Used with Lock implementations such as
 *    ReentrantLock.
 *
 * 8. ReentrantLock:
 *    Allows only one thread to hold the lock
 *    at a time, but the same thread can acquire
 *    it multiple times.
 *    Provides features like tryLock(),
 *    fairness, and interruptible locking.
 *
 * =====================================================
 * Quick Interview Summary
 * =====================================================
 *
 * Mutex          -> Only one thread at a time.
 * Semaphore      -> Limited number of threads.
 * CountDownLatch -> Wait until count becomes zero.
 * CyclicBarrier  -> Threads wait for each other.
 * Phaser         -> Synchronize threads in phases.
 * Exchanger      -> Exchange data between two threads.
 * Condition      -> Wait and signal between threads.
 * ReentrantLock  -> Flexible, reentrant mutual exclusion.
 *
 * NOTE:
 * Java does not have a standard Mutex class.
 * Mutex behavior can be achieved using synchronized
 * or ReentrantLock.
 *
 * =====================================================
 */
