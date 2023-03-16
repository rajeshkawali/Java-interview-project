package com.rajeshkawali.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Rajesh_Kawali
 */
class MyThreadLocal {
	/*
	ThreadLocal is a class that allows you to store a value that is local to a thread. 
	It is particularly useful in cases where you have a shared resource that is accessed 
	by multiple threads, and you want to ensure that each thread has its own copy of the resource.

	To use a ThreadLocal, you first need to create an instance of the ThreadLocal class. 
	You can then use the set() method to store a value in the ThreadLocal, 
	and the get() method to retrieve the value.
	*/
	private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

	public static void set(Integer value) {
		threadLocal.set(value);
	}

	public static Integer get() {
		return threadLocal.get();
	}
}

public class ThreadLocalExample {
	
	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadLocalWorker(1), "Thread 1");
		Thread t2 = new Thread(new ThreadLocalWorker(2), "Thread 2");
		Thread t3 = new Thread(new ThreadLocalWorker(3), "Thread 3");
		Thread t4 = new Thread(new ThreadLocalWorker(4), "Thread 4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class ThreadLocalWorker implements Runnable {

	private Integer value;

	public ThreadLocalWorker(Integer value) {
		this.value = value;
	}

	@Override
	public void run() {
		try {
			MyThreadLocal.set(value);
			System.out.println(Thread.currentThread().getName() + " - MyThreadLocal get: " + MyThreadLocal.get());
		} catch (Exception ex) {
			Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
/*
Difference between ThreadLocal and volatile are both used for managing shared state:-->

ThreadLocal is a mechanism that allows you to create variables that are local to a thread. 
Each thread that accesses the variable has its own copy of the variable, 
which is independent of the copies in other threads. This makes ThreadLocal variables useful 
for managing per-thread state, such as user sessions, transaction contexts, or thread-specific configuration settings.

volatile, on the other hand, is a keyword that is used to indicate that a 
variable should be accessed directly from main memory(Shared cache) rather than from a cache. 
This ensures that any changes made to the variable by one thread are visible to all other threads immediately. 
volatile variables are typically used for managing shared state that needs to be accessed 
frequently and concurrently by multiple threads.
*/

/*
1.set(T value): Sets the value of the ThreadLocal for the current thread.
2.get(): Returns the value of the ThreadLocal for the current thread.
3.remove(): Removes the value of the ThreadLocal for the current thread.
4.initialValue(): Returns the initial value for the ThreadLocal when it is first accessed in a new thread.
5.withInitial(Supplier<? extends S> supplier): Returns a ThreadLocal with an initial value provided by a Supplier.

The set() and get() methods are the most commonly used methods in the ThreadLocal class. 
The set() method allows you to store a value in the ThreadLocal, 
while the get() method allows you to retrieve the value.

The remove() method allows you to remove the value of the ThreadLocal for the current thread, 
while the initialValue() method allows you to specify the initial value for the ThreadLocal 
when it is first accessed in a new thread.

The withInitial() method is a static factory method that allows you to create a ThreadLocal 
with an initial value provided by a Supplier. This can be useful if you want to create a 
ThreadLocal with an initial value that is computed dynamically.
*/

/*
Some key points to remember when using the ThreadLocal class in Java:-->

1.ThreadLocal allows you to store a value that is local to a thread, and ensures 
that each thread has its own separate copy of the value.

2.You can use the set() method to store a value in the ThreadLocal, and the get() method to retrieve the value.

3.The ThreadLocal class is thread-safe, which means that multiple threads can 
access a ThreadLocal concurrently without causing any problems.

4.The value of a ThreadLocal is stored in a ThreadLocalMap, which is a map that is 
local to each thread. When a thread accesses a ThreadLocal, it retrieves the value from its local map.

5.If you are using a ThreadLocal to store a mutable object, you should be careful to 
ensure that the object's state is not modified by multiple threads concurrently. 
One way to do this is to use the ThreadLocal to store a copy of the object, rather than the object itself.

*/
