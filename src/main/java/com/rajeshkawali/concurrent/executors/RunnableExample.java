package com.rajeshkawali.concurrent.executors;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author Rajesh_Kawali
 */
public class RunnableExample {
	/*
	 Runnable is a functional interface that represents a task that can be executed by an Executor. 
	 It has a single void method called run() that represents the code to be executed by the task. 
	 Runnable tasks do not return a value.
	 */
    public static void main(String[] args) {
        // create a single-threaded executor
        Executor executor = Executors.newSingleThreadExecutor();

        // create a runnable task
        Runnable task = () -> {
            // task code goes here
        };

        // execute the task
        executor.execute(task);
    }
}
//execute() is a method of the Executor interface that accepts a Runnable task and executes it asynchronously. 
//It does not return a value.