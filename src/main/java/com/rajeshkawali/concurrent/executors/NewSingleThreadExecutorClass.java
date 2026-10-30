package com.rajeshkawali.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Rajesh_Kawali
 */
public class NewSingleThreadExecutorClass {

	public static void main(String[] args) {
		// Only one thread will be created to execute the task
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 100; i++) {
			executor.execute(new MyTask()); // Execute the task
		}
		System.out.println("Thread Name From Main :" + Thread.currentThread().getName());
	}

}
class MyTask implements Runnable {
	public void run() {
		System.out.println("Thread Name :" + Thread.currentThread().getName());
	}
}


/*
 * =====================================================
 * Executors.newSingleThreadExecutor() in Java
 * =====================================================
 *
 * newSingleThreadExecutor() creates an ExecutorService
 * that uses a single worker thread to execute tasks.
 *
 * Tasks are executed sequentially, one at a time,
 * in the order they are submitted.
 *
 * HOW IT WORKS:
 *
 * 1. Uses only one worker thread at a time.
 *
 * 2. Tasks are stored in an unbounded FIFO queue
 *    when the worker thread is busy.
 *
 * 3. Executes tasks one by one, not concurrently.
 *
 * 4. If the worker thread fails, a new thread
 *    is created to execute remaining tasks.
 *
 * IMPORTANT POINTS:
 *
 * 1. Useful when tasks must execute sequentially.
 *
 * 2. Maintains task execution order.
 *
 * 3. Long-running or blocking tasks can delay
 *    all other waiting tasks.
 *
 * 4. An unbounded queue may increase memory usage
 *    if tasks are submitted faster than executed.
 *
 * 5. Always call shutdown() when the executor
 *    is no longer needed.
 *
 * 6. shutdown() stops accepting new tasks
 *    but allows submitted tasks to finish.
 *
 * EXAMPLE:
 *
 * ExecutorService executor = Executors.newSingleThreadExecutor();
 * executor.execute(() -> System.out.println("Task 1"));
 * executor.execute(() -> System.out.println("Task 2"));
 * executor.shutdown();
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * SingleThreadExecutor -> One worker thread.
 * Thread reuse         -> Yes.
 * Concurrent tasks     -> 1.
 * Task queue           -> Unbounded FIFO queue.
 * Execution order      -> Sequential.
 * Best suited for      -> Ordered task execution.
 *
 * =====================================================
 */


/*
Executors.newSingleThreadExecutor() is a factory method that creates a 
new thread pool that uses a single worker thread to execute tasks. 
Tasks are queued in a First-In-First-Out (FIFO) manner, and the single worker thread executes them one at a time.

The thread pool created by newSingleThreadExecutor() is designed to be used for tasks 
that should be executed sequentially, or for environments where it is 
necessary to limit the number of concurrent threads. It is not intended 
for use with tasks that can be executed concurrently.

It is important to remember to shut down the thread pool when it is no longer needed, 
using the shutdown() method. This will allow the threads in the pool to 
terminate gracefully and free up resources.
*/