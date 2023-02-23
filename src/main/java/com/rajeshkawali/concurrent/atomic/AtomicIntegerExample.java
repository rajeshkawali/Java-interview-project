package com.rajeshkawali.concurrent.atomic;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	/*
	AtomicInteger class is a type of integer variable that can be read and written atomically, 
	without the need for locking. This is useful in multithreaded environments where multiple 
	threads may need to access and update the same variable concurrently.

	The AtomicInteger class provides various methods for reading, writing, and updating 
	the value of the integer in an atomic way. For example, the get() and set() methods can be 
	used to read and write the value of the integer, respectively. The compareAndSet() method 
	can be used to update the value of the integer only if it is equal to a certain value, 
	and the addAndGet() method can be used to atomically add a value to the current value and return the new value.
	 */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        // Create an AtomicInteger with an initial value of 0
        AtomicInteger counter = new AtomicInteger(0);
        
        // Increment the value by 1 using the incrementAndGet() method
        int newValue = counter.incrementAndGet();
        System.out.println(newValue);  // prints 1
        
        // Decrement the value by 1 using the decrementAndGet() method
        newValue = counter.decrementAndGet();
        System.out.println(newValue);  // prints 0
        
        // Add 10 to the value using the addAndGet() method
        newValue = counter.addAndGet(10);
        System.out.println(newValue);  // prints 10
        
        // Get the value and then set it to 100 using the getAndSet() method
        int oldValue = counter.getAndSet(100);
        System.out.println(oldValue);  // prints 10
        System.out.println(counter.get());  // prints 100
        System.out.println("-----------------------------------------------");
     // Create an AtomicInteger with an initial value of 10
        AtomicInteger atomicInteger = new AtomicInteger(10);
        
        // Get the current value and update it to 20 if it is equal to 10
        boolean updateSuccessful = atomicInteger.compareAndSet(10, 20);
        System.out.println(updateSuccessful);  // prints true
        System.out.println(atomicInteger.get());  // prints 20
        
        // Get the current value and update it to 30 if it is equal to 20
        updateSuccessful = atomicInteger.compareAndSet(20, 30);
        System.out.println(updateSuccessful);  // prints true
        System.out.println(atomicInteger.get());  // prints 30
        
        // Get the current value and update it to 40 if it is equal to 50 (update will fail)
        updateSuccessful = atomicInteger.compareAndSet(50, 40);
        System.out.println(updateSuccessful);  // prints false
        System.out.println(atomicInteger.get());  // prints 30
        
        // Atomically add 5 to the current value and return the new value
        int newValue2 = atomicInteger.addAndGet(5);
        System.out.println(newValue2);  // prints 35
        
        // Get the current value and update it to 40 if it is less than 50
        boolean updated = atomicInteger.weakCompareAndSet(30, 40);
        System.out.println(updated);  // prints true
        System.out.println(atomicInteger.get());  // prints 40
        
        boolean success = atomicInteger.compareAndSet(35, 20);
		if (success) {
			System.out.println("Value was updated to 20 = "+ atomicInteger.get());
		} else {
			System.out.println("Value was not updated = "+ atomicInteger.get());
		}
    }
}
/*
Both "volatile" and "AtomicInteger" in Java provide thread-safe access to shared variables, 
but they differ in how they achieve thread-safety:-->

volatile:- is a keyword in Java that can be used to mark a variable as being shared between threads. 
When a variable is marked as volatile, any writes to it are immediately visible to other threads, 
and any reads from it are guaranteed to see the most recent value. This ensures that multiple 
threads can safely read and write the variable without running into synchronization issues.

AtomicInteger:- is a class in Java's java.util.concurrent.atomic package that provides thread-safe 
access to an int value. It provides a range of atomic operations such as incrementAndGet(), 
decrementAndGet(), and compareAndSet() that can be executed atomically without the need for 
external synchronization. This ensures that multiple threads can safely manipulate the value 
of the AtomicInteger without running into synchronization issues.

*/