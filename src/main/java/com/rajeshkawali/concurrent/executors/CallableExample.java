package com.rajeshkawali.concurrent.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Rajesh_Kawali
 */
public class CallableExample {
	/*
	 Callable is a functional interface that represents a task that can be
	 executed by an Executor and returns a value. It has a single V call() method
	 that represents the code to be executed by the task, and returns a value of type V.
	 */
	public static void main(String[] args) throws Exception {
		// create a single-threaded executor service
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		// create a callable task
		Callable<Integer> task = () -> {
			// task code goes here
			return 12;
		};

		// submit the task to the executor service
		Future<Integer> future = executorService.submit(task);

		// get the result of the task
		int result = future.get();
		System.out.println(result);
		
		// shutdown the executor service
		executorService.shutdown();
	}
}
//submit() is a method of the ExecutorService interface that accepts a Callable task and submits it for execution. 
//It returns a Future object that can be used to obtain the result of the task.