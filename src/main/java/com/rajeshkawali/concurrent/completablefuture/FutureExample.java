package com.rajeshkawali.concurrent.completablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
	/*
	 Future is an interface that represents the result of an asynchronous computation. 
	 It allows you to start a task in a separate thread, and then get the result of the task at a later time.
	 */
	public static void main(String[] args) {
		// Create an executor to start the task in a separate thread
		ExecutorService executor = Executors.newSingleThreadExecutor();
		// Submit the task for execution and get a Future to access the result
		Future<String> future = executor.submit(() -> {
			// Simulate a long-running task by sleeping for a few seconds
			Thread.sleep(2000);
			return "future result returned";
		});
		try {
			// Do other work while the task is being executed
			System.out.println("Doing other work...");
			// Get the result of the task (blocks until the result is available)
			String result = future.get();
			// Print the result
			System.out.println("Response from future : " + result);
		} catch (InterruptedException e) {
			// The thread was interrupted while waiting for the task to complete
			e.printStackTrace();
		} catch (ExecutionException e) {
			// The task completed abnormally (e.g. threw an exception)
			e.printStackTrace();
		}
		// Shut down the executor
		executor.shutdown();
	}
}
/*
1.cancel(boolean mayInterruptIfRunning): Attempts to cancel the execution of the task. Returns true if the task was successfully cancelled, or false if the task could not be cancelled.
2.isCancelled(): Returns true if the task was cancelled before it completed normally, or false otherwise.
3.isDone(): Returns true if the task has completed, either normally or abnormally.
4.get() throws InterruptedException, ExecutionException: Waits if necessary for the computation to complete, and then retrieves the result of the task. If the task completed abnormally, this method throws an ExecutionException.
5.get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException: Waits if necessary for the computation to complete, up to the specified wait time, and then retrieves the result of the task. If the task did not complete within the specified time, this method throws a TimeoutException.
*/