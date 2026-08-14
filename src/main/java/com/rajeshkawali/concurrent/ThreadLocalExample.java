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
Difference between ThreadLocal and volatile

| Feature        | ThreadLocal                          | volatile                              |
|----------------|--------------------------------------|---------------------------------------|
| Scope          | Thread-specific                      | Shared across all threads             |
| Data Sharing   | No (each thread has its own copy)    | Yes (same variable shared)            |
| Visibility     | Not shared between threads           | Changes are visible to all threads    |
| Synchronization| Not required                         | Visibility only (not atomicity)       |
| Use Case       | Per-thread data (e.g., user session) | Shared flags, status, stop signals    |
*/


/*
ThreadLocal Methods:

1. set(T value) - Stores a value for the current thread.
2. get() - Retrieves the value of the current thread.
3. remove() - Removes the value of the current thread.
4. initialValue() - Provides the default value when accessed first time.
5. withInitial(Supplier) - Creates ThreadLocal with a dynamically initialized value.

Most commonly used:
- set() → Store thread-specific data.
- get() → Access thread-specific data.
- remove() → Clear data to avoid memory leaks (especially in thread pools).
*/

/*
Key Points about ThreadLocal

1. Each thread has its own independent copy of the variable.
2. Use set() to store a value and get() to retrieve it.
3. ThreadLocal is thread-safe because data is not shared between threads.
4. Values are stored in a thread-specific ThreadLocalMap.
5. Call remove() after use (especially with thread pools) to avoid memory leaks.
6. Best for per-thread data such as user sessions, database connections, or transaction context.
*/
