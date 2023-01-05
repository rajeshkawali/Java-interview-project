package com.rajeshkawali.concurrent.atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rajesh_Kawali
 */
public class LongAccumulatorExample {

	/*
	LongAccumulator is a class that provides a thread-safe way to apply a binary operation 
	(such as a minimum, maximum, or sum) to a set of values.

	The LongAccumulator class works by maintaining an internal value that can be 
	updated using a specified binary function. The binary function is provided as a 
	lambda expression or a LongBinaryOperator object when the LongAccumulator object is created.
	*/
	public static void main(String[] args) {
		// Create a LongAccumulator with a lambda function that returns the sum of two long values
		/*
		The lambda function (x, y) -> x + y specifies the binary operation that will be applied to the 
		values in the accumulator. In this case, the lambda function returns the sum of its two arguments, x and y.

		The initial value 0L specifies the initial value for the accumulator. This value will be used as the 
		starting point for the binary operation specified by the lambda function.

		Once the LongAccumulator object has been created, you can use its accumulate() method to 
		add values to the accumulator and its get() method to retrieve the current value of the accumulator.
		 */
		LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0L);
		//LongAccumulator accumulator = new LongAccumulator(Math::max, Long.MIN_VALUE); // To get MAX value from the input
		
		new Thread(new AccumulatorWorker(accumulator, 10), "Thread 1").start();
		new Thread(new AccumulatorWorker(accumulator, 20), "Thread 2").start();
		new Thread(new AccumulatorWorker(accumulator, 30), "Thread 3").start();
	}
}
class AccumulatorWorker implements Runnable {

	private LongAccumulator accumulator;
	private Integer value;

	public AccumulatorWorker(LongAccumulator accumulator, Integer value) {
		this.accumulator = accumulator;
		this.value = value;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " - Before accumulator: value = " +value+", sum = "+ accumulator.get());
			// Add some values to the accumulator
			accumulator.accumulate(value);
			System.out.println(Thread.currentThread().getName() + " - After accumulator: value = " +value+", sum = "+ accumulator.get());
		} catch (Exception ex) {
			Logger.getLogger(LongAccumulatorExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

/*
accumulate(long x): Applies the accumulator function to the current value and the given value, and updates the current value with the result.
get(): Returns the current value of the accumulator.
reset(): Resets the value of the accumulator to its initial state.
longValue(): Returns the current value of the accumulator as a long.
floatValue(): Returns the current value of the accumulator as a float.
doubleValue(): Returns the current value of the accumulator as a double.

Note that LongAccumulator also provides methods for combining values, such as 
accumulate(long x, LongBinaryOperator accumulatorFunction), which can be useful for 
computing running totals or averages of a set of values.
*/