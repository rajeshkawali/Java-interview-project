package com.rajeshkawali.concurrent.atomic;

import java.util.concurrent.atomic.LongAdder;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Rajesh_Kawali
 */
public class LongAdderExample {

	/*
	 LongAdder is a class in the Java concurrency utilities that provides a way to perform numeric 
	 updates in a thread-safe manner. It is designed for scenarios where there are many threads 
	 updating a shared value concurrently, and the primary goal is to 
	 compute a running total or average of a set of values.
	 
	 LongAdder provides a number of methods for adding and combining values, as well as methods for 
	 resetting the value and converting it to different numeric types. It is a useful tool for 
	 building high-performance concurrent applications that need to perform a 
	 large number of numeric updates in a thread-safe manner.
	 
	 LongAdder uses a technique called "cellular contention-free" accumulation to provide 
	 better performance than other atomic classes, such as AtomicLong, AtomicInteger.
	 */
	public static void main(String[] args) {
		LongAdder adder = new LongAdder();

		new Thread(new AdderWorker(adder, 10), "Thread 1").start();
		new Thread(new AdderWorker(adder, 20), "Thread 2").start();
		new Thread(new AdderWorker(adder, 30), "Thread 3").start();
	}
}

class AdderWorker implements Runnable {

	private LongAdder adder;
	private Integer value;

	public AdderWorker(LongAdder adder, Integer value) {
		this.adder = adder;
		this.value = value;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " Before adding - value = " +value+", sum = "+ adder.sum());
			// Add some values to the adder
			adder.add(value);
			System.out.println(Thread.currentThread().getName() + " After adding - value = " +value+", sum = "+ adder.sum());
		} catch (Exception ex) {
			Logger.getLogger(LongAdderExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

/*
add(long x): Adds the given value to the current value of the adder.
reset(): Resets the value of the adder to its initial state.
sum(): Returns the current value of the adder.
sumThenReset(): Returns the current value of the adder and then resets the value to its initial state.
intValue(): Returns the current value of the adder as an int.
longValue(): Returns the current value of the adder as a long.
floatValue(): Returns the current value of the adder as a float.
doubleValue(): Returns the current value of the adder as a double.

Note that LongAdder also provides a number of methods for combining values, such as 
addAll(), sumThenReset(), and sumThenReset(LongAdder other), which can be useful for 
computing running totals or averages of a set of values.
*/