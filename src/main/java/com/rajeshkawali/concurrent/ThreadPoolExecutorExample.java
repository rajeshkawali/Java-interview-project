package com.rajeshkawali.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Rajesh_Kawali
 *
 * @see https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html
 */
public class ThreadPoolExecutorExample {
	/*
	 ThreadPoolExecutor is a class in the Java standard library that provides an
	 implementation of the Executor interface. It allows you to run tasks
	 asynchronously using a pool of worker threads. The main advantage of using a
	 thread pool is that it can greatly reduce the overhead of creating and
	 destroying threads, which can improve the performance of your application.
	 
	 ThreadPoolExecutor is created by providing the number of core threads, the
	 maximum number of threads, and the keep-alive time for idle threads, as well
	 as a thread factory and a handler for rejected tasks.
	 
	 Here's an example of creating a ThreadPoolExecutor with a core pool 
	 size of 2, a maximum pool size of 4, and a keep-alive time of 10 seconds,
	 Then we submit 10 tasks to the thread pool using the execute() method. 
	 The ThreadPoolExecutor will create 2 threads to run the tasks, 
	 and as more tasks are submitted, it will create additional 
	 threads up to a maximum of 4.
	 */
	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10));

		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.shutdown();
	}

	static class MyTask implements Runnable {
		public void run() {
			// Perform a simple computation
			double result = 0;
			for (int i = 0; i < 1_000_000; i++) {
				result += Math.sqrt(i);
			}
			System.out.println("Result: " + result);
		}
	}
}
/*
Here are some of the most commonly used methods in the ThreadPoolExecutor class:-->

execute(Runnable command): Submits a Runnable task for execution and returns immediately.
submit(Runnable task): Submits a Runnable task for execution and returns a Future representing that task.
submit(Callable task): Submits a Callable task for execution and returns a Future representing the pending results of the task.
shutdown(): Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
shutdownNow(): Attempts to stop all actively executing tasks and halts the processing of waiting tasks.
awaitTermination(long timeout, TimeUnit unit): Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
isShutdown(): Returns true if this executor has been shut down.
isTerminated(): Returns true if all tasks have completed following shut down.
getQueue(): Returns the task queue used by this executor.
getPoolSize(): Returns the current number of threads in the pool.
getActiveCount(): Returns the approximate number of threads that are actively executing tasks.
getCorePoolSize(): Returns the core number of threads.
getMaximumPoolSize(): Returns the maximum allowed number of threads.
getLargestPoolSize(): Returns the largest number of threads that have ever simultaneously been
*/

/*
Difference between ScheduledThreadPoolExecutor and ThreadPoolExecutor:-->

ScheduledThreadPoolExecutor: is a specialized version of ThreadPoolExecutor that provides 
support for scheduling tasks to run at some point in the future. It allows you to schedule 
tasks to run periodically, or after a delay, or at a specific point in time. It also has 
more methods to schedule and control tasks than the ThreadPoolExecutor.

ThreadPoolExecutor: is a more general-purpose class that allows you to run tasks 
asynchronously using a pool of worker threads. It provides a way to submit tasks for 
execution and manage the pool of worker threads. It allows you to control the number 
of threads in the pool, the maximum number of threads, and the keep-alive time for idle threads.
*/