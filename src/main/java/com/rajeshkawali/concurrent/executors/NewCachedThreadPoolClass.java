package com.rajeshkawali.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Rajesh_Kawali
 */
public class NewCachedThreadPoolClass {

	public static void main(String[] args) {
		// We don't know how many threads going to be created for the task
		//If all threads are busy then create a new thread for the task and place it in the pool
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			executor.execute(new WorkHard()); // execute the task
		}
		System.out.println("Thread Name From Main :" + Thread.currentThread().getName());
	}

}
class WorkHard implements Runnable {
	public void run() {
		System.out.println("Thread Name :" + Thread.currentThread().getName());
	}
}

/*
 * =====================================================
 * Executors.newCachedThreadPool() in Java
 * =====================================================
 *
 * newCachedThreadPool() creates a thread pool that
 * dynamically creates and reuses worker threads.
 *
 * It is useful for executing many short-lived
 * asynchronous tasks.
 *
 * HOW IT WORKS:
 *
 * 1. Creates new threads when needed.
 *
 * 2. Reuses available idle threads instead of
 *    creating new ones.
 *
 * 3. Has no fixed maximum thread count.
 *
 * 4. Idle threads are terminated after 60 seconds.
 *
 * 5. Uses a SynchronousQueue, which does not
 *    store tasks in a normal waiting queue.
 *
 * IMPORTANT POINTS:
 *
 * 1. Suitable for many short-lived tasks when
 *    the workload is controlled.
 *
 * 2. Can create a very large number of threads
 *    if tasks arrive faster than they finish.
 *
 * 3. Long-running or blocking tasks may cause
 *    excessive thread creation.
 *
 * 4. Too many threads can increase memory usage
 *    and reduce application performance.
 *
 * 5. Always call shutdown() when the pool
 *    is no longer needed.
 *
 * 6. shutdown() stops accepting new tasks
 *    but allows submitted tasks to finish.
 *
 * EXAMPLE:
 *
 * ExecutorService executor =
 *         Executors.newCachedThreadPool();
 *
 * executor.execute(() ->
 *         System.out.println("Task executed")
 * );
 *
 * executor.shutdown();
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * CachedThreadPool -> Dynamically creates threads.
 * Thread reuse     -> Yes.
 * Maximum threads  -> No fixed limit.
 * Idle timeout     -> 60 seconds.
 * Task queue       -> SynchronousQueue.
 * Best suited for  -> Short-lived asynchronous tasks.
 *
 * =====================================================
 */

/*
Executors.newCachedThreadPool() is a factory method that creates a new thread pool using a cached thread model. 
This means that the thread pool is able to create new threads as needed to execute tasks, 
and will reuse idle threads when possible.

The thread pool created by newCachedThreadPool() is designed to be used for short-lived, 
asynchronous tasks. It is not intended for use with long-running tasks or tasks that block, 
as this may cause the pool to create an unbounded number of threads and degrade performance.

It is important to remember to shut down the thread pool when it is no longer needed, 
using the shutdown() method. This will allow the threads in the pool to 
terminate gracefully and free up resources.
*/