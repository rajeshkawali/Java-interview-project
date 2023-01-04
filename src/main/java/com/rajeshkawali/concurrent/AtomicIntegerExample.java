package com.rajeshkawali.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajesh_Kawali
 */
public class AtomicIntegerExample {

	/*
	 Atomic variables are variables that are guaranteed to be updated atomically,
	 meaning that the update is performed in a single indivisible operation.
	 Atomic variables are useful for ensuring thread-safety in multi-threaded
	 programs, as they allow threads to access and update shared variables
	 concurrently without the need for explicit synchronization.

	 1.AtomicBoolean: an atomic boolean value. 
	 2.AtomicInteger: an atomic integer value.
	 3.AtomicLong: an atomic long value. 
	 4.AtomicReference<V>: an atomic reference to an object of type V.
	 */
	public static void main(String[] args) {
		// create an atomic integer with the initial value of 0
		AtomicInteger counter = new AtomicInteger(0);

		// create and start three threads that increment the counter
		new Thread(new Incrementer(counter), "Thread 1").start();
		new Thread(new Incrementer(counter), "Thread 2").start();
		new Thread(new Incrementer(counter), "Thread 3").start();

		//System.out.println("-------------------------------------------");
		// create an atomic integer
		//AtomicInteger atomicInt = new AtomicInteger(0);

		// increment the value of the atomic integer by 1
		//int result = atomicInt.incrementAndGet();
		//System.out.println("Result: " + result); // Output: 1

		// decrement the value of the atomic integer by 1
		//result = atomicInt.decrementAndGet();
		//System.out.println("Result: " + result); // Output: 0

		// add 10 to the value of the atomic integer
		//result = atomicInt.addAndGet(10);
		//System.out.println("Result: " + result); // Output: 10

		// get the value of the atomic integer
		//result = atomicInt.get();
		//System.out.println("Result: " + result); // Output: 10

		// compare and set the value of the atomic integer
		/*boolean success = atomicInt.compareAndSet(10, 20);
		if (success) {
			System.out.println("Value was updated to 20");
		} else {
			System.out.println("Value was not updated");
		}
		*/
	}

	static class Incrementer implements Runnable {
		
		private AtomicInteger counter;

		public Incrementer(AtomicInteger counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			try {
				// increment the counter
				counter.incrementAndGet();
				System.out.println(Thread.currentThread().getName() + " Incrementer: new value = "+ counter.get());
			} catch (Exception ex) {
				Logger.getLogger(AtomicIntegerExample.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}

/*
Some key points to consider when using AtomicInteger in Java:-

1.AtomicInteger is a class in the java.util.concurrent.atomic package that provides atomic operations on an int value.

2.AtomicInteger is useful for improving the performance of multi-threaded programs by eliminating the need for synchronization when accessing a shared int variable.

3.AtomicInteger provides methods for atomically updating the value of the int variable, such as incrementAndGet(), addAndGet(), getAndSet(), and compareAndSet().

4.AtomicInteger also provides methods for retrieving the current value of the int variable, such as get() and getAndIncrement().

5.AtomicInteger is not suitable for long-term blocking, as it does not provide the same level of fairness as synchronized blocks and Lock objects. For long-term blocking, it is better to use other synchronization mechanisms such as CountDownLatch, CyclicBarrier, or Semaphore.

*/