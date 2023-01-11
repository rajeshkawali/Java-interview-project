package com.rajeshkawali.concurrent.thread;

/**
 *
 * @author Rajesh_Kawali
 */
public class ThreadClass {

	/*
	  A Thread represents a separate path of execution within a Java program, 
	  and is often used to perform concurrent processing or to perform tasks in 
	  the background while the main program continues to run.
	 */
	public static void main(String[] args) {
		// If we want to create 100 threads to complete 100 task then this is tedious task for JVM to create threads instead use ExecutorService
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new Task());
			thread.start();
		}
		System.out.println("Thread Name From Main :" + Thread.currentThread().getName());
	}
}

class Task implements Runnable {
	public void run() {
		System.out.println("Thread Name :" + Thread.currentThread().getName());
	}
}

/*
A Thread in a Java program can be in one of the following states:-

NEW:- the thread has been created, but has not yet started.
RUNNABLE:- the thread is executing in the Java Virtual Machine (JVM).
BLOCKED:- the thread is blocked and waiting for a monitor lock.
WAITING:- the thread is waiting indefinitely for another thread to perform a particular action.
TIMED_WAITING:- the thread is waiting for another thread to perform an action for up to a specified waiting time.
TERMINATED:- the thread has completed execution.

*/

/*
public void start():- starts the thread and executes the run() method of the Runnable object passed to the Thread constructor.
public void run():- the entry point for the thread. This method is called by the start() method and should contain the code to be executed by the thread.
public void join():- waits for the thread to complete.
public void join(long millis):- waits for the thread to complete or for the specified number of milliseconds to elapse, whichever comes first.
public void join(long millis, int nanos):- waits for the thread to complete or for the specified number of milliseconds and nanoseconds to elapse, whichever comes first.
public void interrupt():- interrupts the thread.
public boolean isInterrupted():- returns true if the thread has been interrupted, false otherwise.
public static boolean interrupted():- returns true if the current thread has been interrupted, false otherwise.
public void setName(String name):- sets the name of the thread.
public String getName():- returns the name of the thread.
public long getId():- returns the unique ID of the thread.
public Thread.State getState():- returns the state of the thread.
public boolean isAlive():- returns true if the thread is alive, false otherwise.
public static void sleep(long millis):- causes the current thread to sleep for the specified number of milliseconds.
public static void sleep(long millis, int nanos):- causes the current thread to sleep for the specified number of milliseconds and nanoseconds.
*/