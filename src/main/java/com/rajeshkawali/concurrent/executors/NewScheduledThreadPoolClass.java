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
 * =====================================================
 * Executors.newScheduledThreadPool() in Java
 * =====================================================
 *
 * newScheduledThreadPool(int corePoolSize) creates
 * a thread pool that executes tasks after a delay
 * or repeatedly at scheduled intervals.
 *
 * It returns a ScheduledExecutorService.
 *
 * HOW IT WORKS:
 *
 * 1. Creates up to corePoolSize worker threads
 *    as needed and reuses them for scheduled tasks.
 *
 * 2. Tasks can execute after an initial delay.
 *
 * 3. Tasks can execute repeatedly at a fixed rate
 *    or with a fixed delay.
 *
 * 4. Uses an unbounded DelayedWorkQueue internally
 *    to store scheduled tasks.
 *
 * IMPORTANT METHODS:
 *
 * schedule()              -> Executes once after a delay.
 *
 * scheduleAtFixedRate()   -> Executes repeatedly based
 *                            on a fixed time interval.
 *
 * scheduleWithFixedDelay()-> Executes repeatedly with
 *                            a fixed delay after the
 *                            previous execution finishes.
 *
 * shutdown()              -> Stops accepting new tasks
 *                            and begins graceful shutdown.
 *
 * IMPORTANT POINTS:
 *
 * 1. Useful for periodic tasks, background jobs,
 *    cleanup operations, and scheduled monitoring.
 *
 * 2. Fixed Rate:
 *    Scheduling is based on the initial execution
 *    time and a fixed period.
 *
 * 3. Fixed Delay:
 *    The delay starts after the previous
 *    execution finishes.
 *
 * 4. Repeated executions of the same periodic task
 *    do not overlap.
 *
 * 5. If a periodic task throws an uncaught exception,
 *    its future executions are suppressed.
 *
 * 6. Long-running tasks may delay scheduled executions.
 *
 * 7. It does not guarantee exact execution times
 *    because scheduling depends on thread availability.
 *
 * 8. Always call shutdown() when the executor
 *    is no longer needed.
 *
 * EXAMPLE:
 *
 * ScheduledExecutorService executor =
 *         Executors.newScheduledThreadPool(2);
 *
 * executor.schedule(
 *     () -> System.out.println("Task executed"),
 *     5,
 *     TimeUnit.SECONDS
 * );
 *
 * executor.shutdown();
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * ScheduledThreadPool -> Executes delayed/periodic tasks.
 * Core threads        -> corePoolSize.
 * Task queue          -> Unbounded DelayedWorkQueue.
 * schedule()          -> One-time delayed execution.
 * Fixed Rate          -> Fixed interval between
 *                        scheduled start times.
 * Fixed Delay         -> Fixed delay after completion.
 *
 * =====================================================
 */


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