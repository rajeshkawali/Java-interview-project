package com.rajeshkawali.concurrent.concepts;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Rajesh_Kawali
 *
 */
class MyQueue {

	private final Queue<Integer> queue = new LinkedList<>();
	private final int capacity;
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public MyQueue(int capacity) {
		this.capacity = capacity;
	}

	public void put(int value) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == capacity) {
				notFull.await();
			}
			queue.add(value);
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public int take() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notEmpty.await();
			}
			int value = queue.remove();
			notFull.signal();
			return value;
		} finally {
			lock.unlock();
		}
	}
}

public class QueueForProducerConsumerPattern {
	public static void main(String[] args) throws InterruptedException {

		MyQueue myQueue = new MyQueue(3);

		myQueue.put(10);
		myQueue.put(20);
		myQueue.put(30);
		myQueue.put(40);
		myQueue.put(50);

		System.out.println(myQueue.take());
		System.out.println(myQueue.take());
		System.out.println(myQueue.take());
		System.out.println(myQueue.take());

	}
}

/*
What is Busy Spinning? Why will you use Busy Spinning as a wait strategy?

Busy Spinning is a wait strategy used in concurrent programming where a thread repeatedly 
checks for a condition to become true without yielding the processor to other threads. 
The thread essentially loops continuously, checking the condition in each iteration. 
This strategy is often used in situations where the expected wait time is very short 
or when the overhead of waiting for a condition to become true using other strategies 
like thread blocking is deemed too high.

One example of when busy spinning might be used is in a shared-memory parallel 
computing environment, where multiple threads are working on a shared data structure. 
In this situation, a thread may need to wait for another thread to complete a specific 
task before proceeding with its own work. Instead of yielding the processor and waiting 
for the other thread to complete, the thread can repeatedly check the shared data structure 
until the other thread signals that it has finished the task. Since the expected wait time 
is usually very short in this situation, busy spinning can be an effective wait strategy.

However, it's important to note that busy spinning can also have downsides. 
Because the thread is continuously looping, it can consume a significant amount of CPU resources, 
potentially starving other threads or processes of CPU time. Additionally, 
if the expected wait time is longer than anticipated, the thread can waste a significant 
amount of CPU time before the condition becomes true. As such, busy spinning is often only 
used in specific situations where it's deemed appropriate and effective.

Example: while loop
*/