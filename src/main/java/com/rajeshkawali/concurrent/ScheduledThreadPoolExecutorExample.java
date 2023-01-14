package com.rajeshkawali.concurrent;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class ScheduledThreadPoolExecutorExample {

	/*
	ScheduledThreadPoolExecutor is a class in the Java standard library that extends 
	the ThreadPoolExecutor class, and it's used for scheduling tasks to be executed at some point in the future. 
	It allows you to schedule tasks to run periodically, or after a delay, or at a specific point in time.
	*/
	public static void main(String[] args) {
		
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
		MyTask task = new MyTask();
		
		//You can schedule a task to run after a delay using the schedule() method:
		//executor.schedule(new MyTask(), 5, TimeUnit.SECONDS);
		
		//You can schedule a task to run periodically using the scheduleAtFixedRate() method:
		executor.scheduleAtFixedRate(task, 5, 5, TimeUnit.SECONDS); // schedule task to run every 5 seconds.
	}

	static class MyTask implements Runnable {
		@Override
		public void run() {
			// Perform a task
			System.out.println("Running task at " + System.currentTimeMillis());
		}
	}
}
/*
In this example, we first create a ScheduledThreadPoolExecutor with a core pool size of 2. Then we create an instance of the task that we want to schedule, in this case MyTask.
Then we schedule the task to run every 5 seconds using the scheduleAtFixedRate() method. The ScheduledThreadPoolExecutor will create 2 threads to run the task, and will run the task every 5 seconds.
It's worth noting that the ScheduledThreadPoolExecutor has more methods to schedule and control tasks than the ThreadPoolExecutor.
It also supports scheduling tasks based on a specific time using schedule() method, or using scheduleWithFixedDelay() method that run the task with a fixed delay, not a fixed rate.
It's important to note that the scheduled tasks will continue running even after the main thread has completed execution.
*/

/*
schedule(Runnable command, long delay, TimeUnit unit): Creates and executes a one-shot action that becomes enabled after the given delay.
schedule(Callable callable, long delay, TimeUnit unit): Creates and executes a ScheduledFuture that becomes enabled after the given delay.
scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit): Creates and executes a periodic action that becomes first enabled after the given initial delay, and subsequently with the given period; that is executions will commence after initialDelay then initialDelay+period, then initialDelay + 2 * period, and so on.
scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit): Creates and executes a periodic action that becomes first enabled after the given initial delay, and subsequently with the given delay between the termination of one execution and the commencement of the next.
shutdown(): Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
shutdownNow(): Attempts to stop all actively executing tasks and halts the processing of waiting tasks.
isShutdown(): Returns true if this executor has been shut down.
isTerminated(): Returns true if all tasks have completed following shut down.
awaitTermination(long timeout, TimeUnit unit): Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
getQueue(): Returns the task queue used by this executor.
getPoolSize(): Returns the current number of threads in the pool.
getActiveCount(): Returns the approximate number of threads that are actively executing tasks.
getCorePoolSize(): Returns the core number of threads.
getMaximumPoolSize(): Returns the maximum allowed number of threads.
getLargestPoolSize(): Returns the largest number of threads that have ever simultaneously been in the pool.
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