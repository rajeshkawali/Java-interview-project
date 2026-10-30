package com.rajeshkawali.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Rajesh_Kawali
 */
public class ReentrantLockExample {

	/*
	 ReentrantLock:- is a class in Java that implements the Lock interface. It is
	 a mutual exclusion lock with the same basic behavior and semantics as the
	 built-in Java monitor lock, but with extended capabilities.
	 
	 One of the main advantages of ReentrantLock over the built-in monitor lock is
	 that it allows you to use the tryLock() method to try to acquire the lock,
	 rather than blocking until the lock is available. This can be useful in
	 situations where you want to avoid the overhead of creating a new thread to
	 handle the lock, or where you want to implement more sophisticated locking
	 behavior.
	 */
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		// Creating Thread and starting each of thread
		Thread t1 = new Thread(new ReentrantWorker(lock), "Thread 1");
		Thread t2 = new Thread(new ReentrantWorker(lock), "Thread 2");
		Thread t3 = new Thread(new ReentrantWorker(lock), "Thread 3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class ReentrantWorker implements Runnable {

	private Lock lock;

	private static int counter = 0;

	public ReentrantWorker(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();// get the lock
		System.out.println(Thread.currentThread().getName() + " - lock acquired");
		try {
			// increment the counter
			counter++;
			// print the counter value
			Thread.sleep(1500);
			System.out.println(Thread.currentThread().getName() + " - Counter: " + counter);
		} catch (Exception ex) {
			Logger.getLogger(ReentrantLockExample.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			lock.unlock();// release the lock
			System.out.println(Thread.currentThread().getName() + " - lock released");
		}
	}
}
/*
1.lock():- acquires the lock. If the lock is not available, the current thread becomes disabled for thread scheduling purposes and lies dormant until the lock has been acquired.
2.lockInterruptibly():- acquires the lock unless the current thread is interrupted.
3.tryLock():- acquires the lock only if it is free at the time of invocation.
4.tryLock(long time, TimeUnit unit):- acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.
5.unlock():- releases the lock.
6.getHoldCount():- returns the number of holds on this lock by the current thread.
7.isHeldByCurrentThread():- returns true if the current thread holds this lock and false otherwise.
8.isLocked():- returns true if this lock is held by any thread.
9.getQueueLength():- returns the number of threads waiting to acquire this lock.
10.hasQueuedThreads():- returns true if there are threads waiting to acquire the lock.
11.getOwner():- returns the thread that currently owns this lock, or null if not owned.
*/

/*
Difference between ReentrantLock class and synchronized keyword:--> 
 
1.ReentrantLock is a more flexible and powerful synchronization mechanism compared to the synchronized keyword. 
	It allows you to use the tryLock() method to try to acquire the lock, rather than blocking until the lock is available. 
	It also allows you to interrupt the thread waiting for the lock, and it provides more detailed information about the lock, 
	such as the number of holds on the lock and the thread that currently owns it.

2.ReentrantLock is more expensive to use than the synchronized keyword because it requires more overhead to operate. 
	It uses more memory and CPU resources, and it requires more code to use.

3.ReentrantLock supports fairness, which means that it allows waiting threads to acquire the lock in the order in which 
	they requested it. The synchronized keyword does not support fairness.

4.ReentrantLock can be used in a try-finally block to ensure that the lock is always released, even if an exception is thrown. 
	The synchronized keyword does not require this because it automatically releases the lock when the block exits.
*/

/*
Difference between ReentrantLock and synchronized

| Feature              | ReentrantLock                     | synchronized                  |
|----------------------|-----------------------------------|-------------------------------|
| Type                 | Class (implements Lock)           | Java keyword                  |
| Lock Handling        | Manual (lock()/unlock())          | Automatic                     |
| tryLock()            | Yes                               | No                            |
| Interruptible Lock   | Yes (lockInterruptibly())         | No                            |
| Fairness             | Supported                         | Not supported                 |
| Condition Variables  | Multiple (Condition objects)      | One (wait/notify)             |
| Performance          | Better for advanced use cases     | Simpler with less overhead    |
| Best Use Case        | Complex locking requirements      | Basic thread synchronization  |
*/



/*
 * =====================================================
 * ReentrantLock in Java
 * =====================================================
 *
 * ReentrantLock is a synchronization class from
 * java.util.concurrent.locks that implements the
 * Lock interface.
 *
 * It provides mutual exclusion, similar to synchronized,
 * but offers more flexible locking capabilities.
 *
 * REENTRANT MEANING:
 *
 * A thread that already holds the lock can acquire
 * the same lock again without causing a deadlock.
 *
 * The thread must unlock it the same number of times
 * it has successfully acquired it.
 *
 * IMPORTANT METHODS:
 *
 * lock()              -> Acquires lock, waits if unavailable.
 * tryLock()           -> Acquires lock only if immediately available.
 * tryLock(time, unit) -> Waits up to the specified timeout.
 * lockInterruptibly() -> Waits for lock, responds to interruption.
 * unlock()            -> Releases one hold of the lock.
 * isLocked()          -> Checks whether any thread holds the lock.
 * isHeldByCurrentThread() -> Checks ownership by current thread.
 * getHoldCount()      -> Returns current thread's lock hold count.
 * newCondition()      -> Creates a Condition for thread coordination.
 *
 * IMPORTANT POINTS:
 *
 * 1. Only one thread can hold a ReentrantLock at a time.
 *
 * 2. Supports reentrancy: the same thread can acquire
 *    the lock multiple times.
 *
 * 3. Supports fair and non-fair locking.
 *    Non-fair locking is the default.
 *
 * 4. tryLock() allows a thread to avoid waiting
 *    when the lock is unavailable.
 *
 * 5. lockInterruptibly() allows a waiting thread
 *    to respond to interruption.
 *
 * 6. Always call unlock() in a finally block
 *    after successfully acquiring the lock.
 *
 * 7. Unlike synchronized, ReentrantLock must
 *    be explicitly released using unlock().
 *
 * 8. ReentrantLock supports multiple Condition
 *    objects for advanced thread coordination.
 *
 * 9. Incorrect use can cause deadlocks or starvation.
 *
 * 10. ReentrantLock does not create new threads.
 *     tryLock() helps avoid blocking; it does not
 *     eliminate thread-creation overhead.
 *
 * COMMON USE CASES:
 *
 * - Protecting shared mutable data.
 * - Implementing timeout-based locking.
 * - Interruptible lock acquisition.
 * - Advanced thread coordination using Condition.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * synchronized   -> Automatic lock release.
 * ReentrantLock  -> Explicit lock() and unlock().
 *
 * ReentrantLock provides additional features like
 * tryLock(), timed locking, interruptible locking,
 * fairness options, and Condition objects.
 *
 * =====================================================
 */
