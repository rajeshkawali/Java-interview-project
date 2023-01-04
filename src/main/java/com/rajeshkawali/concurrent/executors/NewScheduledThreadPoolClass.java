package com.rajeshkawali.concurrent.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Rajesh_Kawali
 */
public class NewScheduledThreadPoolClass {

	public static void main(String[] args) {
		//It uses DelayQueue . It has 3 methods 1.schedule 2.scheduleAtFixedRate 3.scheduleAtFixedDelay
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
		executor.schedule(new CPUTask(), 10, TimeUnit.SECONDS);//run after 10 seconds
		executor.scheduleAtFixedRate(new CPUTask(), 15, 10, TimeUnit.SECONDS);//run repeatedly every 10 seconds
		executor.scheduleWithFixedDelay(new CPUTask(), 15, 10, TimeUnit.SECONDS);//run repeatedly 10 seconds after previous task complete
		System.out.println("Thread Name From Main :" + Thread.currentThread().getName());
	}

}

class CPUTask implements Runnable {
	public void run() {
		System.out.println("Thread Name :" + Thread.currentThread().getName());
	}
}
/*
Executors.newScheduledThreadPool(int corePoolSize) is a factory method that 
creates a new thread pool that is able to schedule tasks to be executed 
after a certain delay, or at a fixed rate.

The thread pool created by newScheduledThreadPool() is designed to be 
used for tasks that need to be executed at a specific time or with a fixed 
delay between executions. It is not intended for use with short-lived or 
long-running tasks that do not have a scheduling requirement.

It is important to remember to shut down the thread pool when it is no longer needed, 
using the shutdown() method. This will allow the threads in the pool to 
terminate gracefully and free up resources.
*/