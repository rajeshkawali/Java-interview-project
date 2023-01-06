package com.rajeshkawali.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 
 * @author Rajesh_Kawali
 */
public class ForkJoinPoolExample {
	/*
	ForkJoinPool class is a type of ExecutorService that is designed to execute fork/join tasks. 
	A fork/join task is a task that can be recursively divided into smaller subtasks, 
	which can be executed concurrently and then joined back together to produce the final result.

	The ForkJoinPool class uses a work-stealing algorithm to balance the workload among threads. 
	This means that if one thread finishes its tasks faster than other threads, it will "steal" 
	tasks from other threads to keep itself busy. This helps to ensure that the ForkJoinPool is 
	able to fully utilize the available CPU resources and achieve good performance.
	*/
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		ForkJoinPool pool = new ForkJoinPool();
		int sum = pool.invoke(new SumTask(array, 0, array.length - 1));
		System.out.println("Sum: " + sum);
	}
}

class SumTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	
	private static final int THRESHOLD = 3;
	private int[] array;
	private int start;
	private int end;

	public SumTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	/*
	In this example, a SumTask is created that extends RecursiveTask and 
	is designed to compute the sum of an array of integers. The SumTask is 
	recursive and divides itself into smaller subtasks until the size of the 
	task falls below a certain threshold, at which point it computes the sum of the array.

	The ForkJoinPool is used to execute the SumTask, and the result is 
	printed to the console. The ForkJoinPool uses a work-stealing algorithm 
	to balance the workload among threads, which helps to 
	ensure that the tasks are executed efficiently.
	*/
	@Override
	protected Integer compute() {
		if (end - start <= THRESHOLD) {
			// compute sum of array[start..end]
			int sum = 0;
			for (int i = start; i <= end; i++) {
				sum += array[i];
			}
			return sum;
		} else {
			int mid = (start + end) / 2;
			SumTask left = new SumTask(array, start, mid);
			SumTask right = new SumTask(array, mid + 1, end);
			left.fork();
			int rightResult = right.compute();
			int leftResult = left.join();
			return leftResult + rightResult;
		}
	}
}

/*
Some key points to remember when using the ForkJoinPool class in Java:-->

1.ForkJoinPool is a type of ExecutorService that is designed to execute fork/join tasks. 
A fork/join task is a task that can be recursively divided into smaller subtasks, 
which can be executed concurrently and then joined back together to produce the final result.

2.ForkJoinPool uses a work-stealing algorithm to balance the workload among threads. 
This means that if one thread finishes its tasks faster than other threads, 
it will "steal" tasks from other threads to keep itself busy. This helps to ensure that 
the ForkJoinPool is able to fully utilize the available CPU resources and achieve good performance.

3.To use the ForkJoinPool class, you need to create a RecursiveAction or RecursiveTask 
that represents the fork/join task. The RecursiveAction or RecursiveTask should divide itself into 
smaller subtasks until the size of the task falls below a certain threshold, at which point it should compute the final result.

4.You can submit a fork/join task to the ForkJoinPool using the invoke() or submit() method. 
The invoke() method waits for the task to complete and returns the result, while the submit() method 
returns a Future object that can be used to retrieve the result at a later time.

5.The ForkJoinPool is a useful class for cases where you have a task that can be recursively divided into 
smaller subtasks that can be executed concurrently. It can help to improve the performance of your 
application by fully utilizing the available CPU resources.
*/

/*
Most commonly used methods of the ForkJoinPool class in Java:-->

submit(ForkJoinTask<?> task) - Submits a task to the ForkJoinPool for execution and returns a Future object that can be used to retrieve the result at a later time.
invoke(ForkJoinTask<?> task) - Submits a task to the ForkJoinPool for execution and waits for it to complete. Returns the result of the task.
execute(Runnable task) - Executes the specified Runnable task asynchronously.
shutdown() - Initiates an orderly shutdown of the ForkJoinPool. Tasks that are already executing will be allowed to complete, but no new tasks will be accepted.
shutdownNow() - Attempts to cancel and stop all actively executing tasks and returns a list of tasks that were never started.
isShutdown() - Returns true if the ForkJoinPool has been shut down.
isTerminated() - Returns true if the ForkJoinPool has been shut down and all tasks have completed.
awaitTermination(long timeout, TimeUnit unit) - Waits for the ForkJoinPool to terminate for the specified amount of time. Returns true if the ForkJoinPool has terminated, or false if the timeout has been exceeded.
getFactory() - Returns the ForkJoinPool.ForkJoinWorkerThreadFactory that was used to create this ForkJoinPool.
getPoolSize() - Returns the number of worker threads in the ForkJoinPool.
getParallelism() - Returns the targeted parallelism level of this ForkJoinPool.
getActiveThreadCount() - Returns the number of worker threads that are actively executing tasks.
getRunningThreadCount() - Returns the number of worker threads that are executing tasks, including tasks that were stolen from other threads.
getStealCount() - Returns the number of tasks that have been stolen from other threads.
getQueuedTaskCount() - Returns an estimate of the number of tasks in the ForkJoinPool queue.
getQueuedSubmissionCount() - Returns an estimate of the number of tasks in the ForkJoinPool submission queue.
getQueuedTaskCount() - Returns an estimate of the number of tasks that have been queued for execution but have not yet begun.
commonPool() - Returns the common pool instance that is used by the invoke() and submit() methods of the ForkJoinTask class.
commonPoolParallelism() - Returns the targeted parallelism level of the common pool.
getCommonPoolParallelism() - Returns the targeted parallelism level of the common pool.
getCommonPoolStealCount() - Returns the number of tasks that have been stolen from other threads in the common pool.
getCommonPoolQueuedTaskCount() - Returns an estimate of the number of tasks in the common pool queue.

*/
