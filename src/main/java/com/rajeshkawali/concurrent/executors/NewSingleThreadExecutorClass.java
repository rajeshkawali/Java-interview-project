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