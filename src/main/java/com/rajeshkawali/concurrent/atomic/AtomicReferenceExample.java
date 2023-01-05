package com.rajeshkawali.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
	/*
	AtomicReference class is a thread-safe utility class that provides a way to atomically update a reference to an object. 
	It works by maintaining an internal reference value that can be updated using compare-and-swap (CAS) operations, 
	which are implemented using hardware support on many modern processors. 
	*/
	public static void main(String[] args) {
		
		AtomicReference<String> atomicString = new AtomicReference<>("initial value");

		// Update the value using the set() method
		atomicString.set("new value");

		// Get the current value using the get() method
		String currentValue = atomicString.get();
		System.out.println(currentValue); // prints "new value"

		// Update the value using the compareAndSet() method
		boolean success = atomicString.compareAndSet("new value", "updated value");
		if (success) {
			System.out.println(atomicString.get()); // prints "updated value"
		} else {
			System.out.println("Update failed");
		}
		System.out.println("-------------------------------------------------");
		// Create an AtomicReference to an Integer object
        AtomicReference<Integer> atomicInt = new AtomicReference<>(0);
        
        // Use the accumulateAndGet() method to add 10 to the value
        int newValue = atomicInt.accumulateAndGet(10, (n, m) -> n + m);
        System.out.println(newValue);  // prints 10
        System.out.println(atomicInt.get());  // prints 10
        
        // Use the getAndAccumulate() method to add 20 to the value
        newValue = atomicInt.getAndAccumulate(20, (n, m) -> n + m);
        System.out.println(newValue);  // prints 10
        System.out.println(atomicInt.get());  // prints 30
	}
}
/*
get():- Returns the current value of the reference.
set(V newValue):- Sets the value of the reference to the given new value.
lazySet(V newValue):- Sets the value of the reference to the given new value, but does not guarantee immediate visibility to other threads.
compareAndSet(V expect, V update):- Atomically sets the value of the reference to the given updated value if the current value is equal to the expected value. Returns true if the update was successful, false otherwise.
getAndSet(V newValue):- Atomically sets the value of the reference to the given new value and returns the old value.
accumulateAndGet(V x, BinaryOperator<V> accumulatorFunction):- Atomically updates the current value using the given accumulation function and returns the updated value.
getAndAccumulate(V x, BinaryOperator<V> accumulatorFunction):- Atomically updates the current value using the given accumulation function and returns the old value.
setPlain(V newValue):- Sets the value of the reference to the given new value, but does not guarantee immediate visibility to other threads. This method may be more efficient than set() in some cases.
getPlain():- Returns the current value of the reference, but does not guarantee immediate visibility to other threads. This method may be more efficient than get() in some cases.
weakCompareAndSet(V expect, V update):- Like compareAndSet(), but does not guarantee immediate visibility to other threads. This method may be more efficient than compareAndSet() in some cases.
*/