package com.rajeshkawali.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rajesh_Kawali
 */
public class AtomicLongExample {

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
		// create an atomic long with the initial value of 0
		//AtomicInteger counter = new AtomicInteger(0);
		AtomicLong counter = new AtomicLong(0);

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
		
		private AtomicLong counter;

		public Incrementer(AtomicLong counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " - Before Incrementing: counter value = "+ counter.get());
				// increment the counter
				counter.incrementAndGet();
				System.out.println(Thread.currentThread().getName() + " - After Incrementing: counter value = "+ counter.get());
			} catch (Exception ex) {
				Logger.getLogger(AtomicLongExample.class.getName()).log(Level.SEVERE, null, ex);
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

/*
Differences between AtomicLong, LongAdder, and LongAccumulator:-->
------------------------------------------------------------------
1.AtomicLong is a thread-safe variable that can be used to store and update a single long value. 
	It provides methods for reading and updating the value, such as get() and set(), 
	as well as methods for performing atomic operations, such as compareAndSet() and incrementAndGet().

2.LongAdder is designed for scenarios where the primary goal is to compute a running total or average of a set of values. 
	It provides methods for adding and combining values, such as add() and sum(), 
	as well as a reset() method for resetting the value to its initial state.

3.LongAccumulator is designed for scenarios where the primary goal is to apply a function to a 
	set of values and return the result. It provides a accumulate() method for applying a function to a value, 
	and allows you to define a custom function to apply to the values. This can be useful in scenarios 
	where you need to perform more complex operations on the values.

4.If you need to store and update a single long value in a thread-safe manner, AtomicLong is the best choice. 
	It provides a wide range of methods for reading, updating, and performing atomic operations on the value.

5.If you need to compute a running total or average of a set of values, LongAdder is a good choice. 
	It is optimized for adding and combining values, and provides a reset() method for resetting the value to its initial state.

6.If you need to apply a function to a set of values and return the result, LongAccumulator is a good choice. 
	It allows you to define a custom function to apply to the values, and provides a accumulate() method for 
	applying the function to a value.

7.If you are not sure which class to use, it is generally a good idea to start with AtomicLong and switch to a 
	different class if you find that it is not meeting your performance or functionality requirements.
*/