package com.rajeshkawali.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Rajesh_Kawali
 */
public class NewFixedThreadPoolClass {

	public static void main(String[] args) {
		// Just create 10 threads to complete 100 task using ExecutorService
		ExecutorService executor = Executors.newFixedThreadPool(10); // Thread Pool
		for (int i = 0; i < 100; i++) {
			executor.execute(new Work()); // Submit the task
		}
		System.out.println("Thread Name From Main :" + Thread.currentThread().getName());
	}

}
class Work implements Runnable {
	public void run() {
		System.out.println("Thread Name :" + Thread.currentThread().getName());
	}
}


/*
 * =====================================================
 * Executors.newFixedThreadPool() in Java
 * =====================================================
 *
 * newFixedThreadPool(int nThreads) creates a thread
 * pool with a fixed number of worker threads.
 *
 * It reuses existing threads to execute tasks
 * instead of creating a new thread for every task.
 *
 * HOW IT WORKS:
 *
 * 1. Creates up to nThreads worker threads as needed.
 *
 * 2. Executes tasks using available worker threads.
 *
 * 3. If all threads are busy, new tasks are queued.
 *
 * 4. When a thread becomes available, it picks
 *    the next task from the queue.
 *
 * 5. Uses an unbounded LinkedBlockingQueue
 *    to store waiting tasks.
 *
 * IMPORTANT POINTS:
 *
 * 1. The maximum number of worker threads
 *    is fixed by nThreads.
 *
 * 2. Suitable for workloads requiring a controlled
 *    number of concurrent worker threads.
 *
 * 3. Supports both short-running and long-running tasks.
 *
 * 4. Blocking tasks can occupy worker threads
 *    and delay other waiting tasks.
 *
 * 5. Too many pending tasks can increase memory usage
 *    because the task queue is unbounded.
 *
 * 6. Always call shutdown() when the pool
 *    is no longer needed.
 *
 * 7. shutdown() stops accepting new tasks
 *    but allows submitted tasks to finish.
 *
 * EXAMPLE:
 *
 * ExecutorService executor = Executors.newFixedThreadPool(3);
 * executor.execute(() -> System.out.println("Task executed"));
 * executor.shutdown();
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * FixedThreadPool  -> Fixed number of worker threads.
 * Thread reuse     -> Yes.
 * Maximum threads  -> nThreads.
 * Task queue       -> Unbounded LinkedBlockingQueue.
 * Idle timeout     -> Core threads normally stay alive.
 * Best suited for  -> Controlled concurrency.
 *
 * =====================================================
 */


/*
Executors.newFixedThreadPool(int nThreads) is a factory method that 
creates a new thread pool using a fixed thread model. 
This means that the thread pool creates a fixed number of threads to execute tasks, 
and tasks are queued when all threads are busy.

The thread pool created by newFixedThreadPool() is 
designed to be used for a fixed number of short-lived or long-running tasks. 
It is not intended for use with tasks that block, as this may cause the tasks to be delayed unnecessarily.

It is important to remember to shut down the thread pool when it is no longer needed, 
using the shutdown() method. This will allow the threads in the pool to 
terminate gracefully and free up resources.
*/