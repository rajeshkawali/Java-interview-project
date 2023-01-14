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

/*
Multithreading refers to the ability of a program or a platform to handle more 
than one thread of execution simultaneously. Java provides built-in support for 
multithreading through the java.util.concurrent package and the java.util.concurrent.atomic package.
---------------------------------------------------
The main classes for multithreading in Java are:-->
---------------------------------------------------
Thread: The Thread class allows a programmer to create a new thread of execution.
Runnable: The Runnable interface is used to create a task that can be executed by a Thread.
Executor: The Executor interface is used to execute Runnable tasks.
ExecutorService: The ExecutorService interface is a subinterface of Executor and provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
Future: The Future interface is used to represent the result of an asynchronous computation.
Callable: The Callable interface is similar to Runnable, but it can return a value and throw a checked exception.
CountDownLatch: The CountDownLatch class allows one or more threads to wait for a set of operations to complete.
CyclicBarrier: The CyclicBarrier class allows a set of threads to all wait for each other to reach a common barrier point.
Semaphore: The Semaphore class controls access to a shared resource through the use of a counter.
ThreadPoolExecutor: The ThreadPoolExecutor class is an implementation of the ExecutorService interface that can be used to manage a pool of threads. It allows you to set the size of the thread pool, the maximum size, the keep-alive time for idle threads, and the queue to hold tasks that are waiting to be executed.
ScheduledThreadPoolExecutor: The ScheduledThreadPoolExecutor class is a specialized implementation of the ThreadPoolExecutor that can be used to schedule tasks to run at a later time, either once or repeatedly.
ThreadLocal: The ThreadLocal class is used to create variables that are specific to a thread. This means that each thread has its own copy of the variable, and changes made to the variable by one thread do not affect the other threads.
BlockingQueue: The BlockingQueue interface represents a queue that is thread-safe and can block the put and take operations.
LinkedBlockingQueue: The LinkedBlockingQueue class is an implementation of the BlockingQueue interface that is based on linked nodes.
PriorityBlockingQueue: The PriorityBlockingQueue class is an implementation of the BlockingQueue interface that orders its elements according to their natural ordering or according to a provided comparator.
ArrayBlockingQueue: The ArrayBlockingQueue class is an implementation of the BlockingQueue interface that is based on an array.
Lock: The Lock interface provides a way to lock and unlock a shared resource, similar to synchronized blocks.
ReentrantLock: The ReentrantLock class is an implementation of the Lock interface that can be used to provide exclusive access to a shared resource.
ReadWriteLock: The ReadWriteLock interface provides a mechanism for multiple threads to read a shared resource simultaneously, while only allowing one thread to write to the resource at a time.
ReentrantReadWriteLock: The ReentrantReadWriteLock class is an implementation of the ReadWriteLock interface that can be used to provide concurrent access to a shared resource for multiple readers and exclusive access for a single writer.
StampedLock: The StampedLock class is a more advanced lock that provides different modes of lock, such as optimistic read mode and write mode, that can be used to improve performance in some cases.
Phaser: The Phaser class is a synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point, similar to CyclicBarrier.
ForkJoinPool: The ForkJoinPool class is a special kind of ExecutorService that is designed to take advantage of multiple processors and allows you to split a large task into smaller, more manageable subtasks that can be executed in parallel.
ForkJoinTask: The ForkJoinTask is the base class for tasks that can be executed by a ForkJoinPool.
RecursiveAction: The RecursiveAction is a task that does not return a result, similar to a Runnable.
RecursiveTask: The RecursiveTask is a task that returns a result, similar to a Callable.
ForkJoinWorkerThread: The ForkJoinWorkerThread is a Thread that is managed by a ForkJoinPool and is used to execute ForkJoinTask.
CompletableFuture: The CompletableFuture is a class that represents the result of an asynchronous computation and allows you to chain together multiple asynchronous operations and handle the results of those operations when they are complete.
CompletionStage: The CompletionStage is an interface that represents the result of an asynchronous computation and allows you to chain together multiple asynchronous operations.
CompletableFuture.allOf(): This method is used to run multiple completableFuture in parallel and return when all of them are completed.
CompletableFuture.anyOf(): This method is used to run multiple completableFuture in parallel and return the first one that is completed.
ThreadFactory: The ThreadFactory is an interface that is used to create new Threads.
ThreadPoolExecutor.AbortPolicy: The AbortPolicy is a predefined policy that is used to handle cases where the thread pool is unable to process a task.
ThreadPoolExecutor.CallerRunsPolicy: The CallerRunsPolicy is a predefined policy that is used to handle cases where the thread pool is unable to process a task.
ThreadPoolExecutor.DiscardOldestPolicy: The DiscardOldestPolicy is a predefined policy that is used to handle cases where the thread pool is unable to process a task.
ThreadPoolExecutor.DiscardPolicy: The DiscardPolicy is a predefined policy that is used to handle cases where the thread pool is unable to process a task.
ThreadPoolExecutor.RejectedExecutionHandler: The RejectedExecutionHandler is an interface that is used to handle cases where the thread pool is unable to process a task.
Executors: This class provide factory methods for creating various types of ExecutorServices, ScheduledExecutorServices and ThreadFactories.

*/