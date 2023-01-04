package com.rajeshkawali.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Rajesh_Kawali
 */
public class NewFixedThreadPoolWithPSCount {

	public static void main(String[] args) {
		// Create only available processors in the system
		int processorCount = Runtime.getRuntime().availableProcessors();// give count of CPU cores
		ExecutorService executor = Executors.newFixedThreadPool(processorCount); // Thread Pool
		for (int i = 0; i < 100; i++) {
			executor.execute(new CPUIntensiveTask()); // Execute the task
		}
		System.out.println("Thread Name From Main :" + Thread.currentThread().getName());
	}

}
class CPUIntensiveTask implements Runnable {
	public void run() {
		System.out.println("Thread Name :" + Thread.currentThread().getName());
	}
}
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