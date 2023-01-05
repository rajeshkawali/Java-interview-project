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