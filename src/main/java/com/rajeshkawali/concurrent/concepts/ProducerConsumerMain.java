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
/*
 * Producer-Consumer Pattern using ReentrantLock and Condition.
 *
 * Producer waits when the queue is full. Consumer waits when the queue is
 * empty.
 */

class MyCustomQueue {

	private final Queue<Integer> queue = new LinkedList<>();
	private final int capacity;
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();	/* Condition for producer threads. */
	private final Condition notEmpty = lock.newCondition();  /* Condition for consumer threads. */

	public MyCustomQueue(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive");
		}
		this.capacity = capacity;
	}

	public void put(int value) throws InterruptedException {
		lock.lock();
		try {
			/* Wait while the queue is full. */
			while (queue.size() == capacity) {
				notFull.await();
			}
			queue.add(value);
			System.out.println("Produced: " + value);
			/* Notify a waiting consumer. */
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public int take() throws InterruptedException {
		lock.lock();
		try {
			/* Wait while the queue is empty. */
			while (queue.isEmpty()) {
				notEmpty.await();
			}
			int value = queue.remove();
			System.out.println("Consumed: " + value);
			/* Notify a waiting producer. */
			notFull.signal();
			return value;
		} finally {
			lock.unlock();
		}
	}
}

public class ProducerConsumerMain {

	public static void main(String[] args) throws InterruptedException {
		MyCustomQueue myQueue = new MyCustomQueue(3);
		/* Producer inserts 5 elements. */
		Thread producer = new Thread(() -> {
			try {
				for (int i = 1; i <= 5; i++) {
					myQueue.put(i * 10);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		/* Consumer removes 5 elements. */
		Thread consumer = new Thread(() -> {
			try {
				for (int i = 1; i <= 5; i++) {
					myQueue.take();
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		producer.start();
		consumer.start();
		/* Wait for both threads to finish. */
		producer.join();
		consumer.join();
		System.out.println("Execution completed.");
	}
}

/*
 * POSSIBLE OUTPUT:
 *
 * Produced: 10
 * Produced: 20
 * Produced: 30
 * Consumed: 10
 * Consumed: 20
 * Consumed: 30
 * Produced: 40
 * Produced: 50
 * Consumed: 40
 * Consumed: 50
 * Execution completed.
 *
 * NOTE:
 * The output order may vary depending on thread scheduling.
 *
 * IMPORTANT POINTS:
 * 1. ReentrantLock protects the shared queue.
 * 2. notFull.await() waits when the queue is full.
 * 3. notEmpty.await() waits when the queue is empty.
 * 4. signal() wakes one waiting thread.
 * 5. await() releases the lock while waiting and reacquires it before returning.
 * 6. Always use while instead of if with await() because threads may wake up unexpectedly.
 * 7. Always release the lock inside finally.
 * 8. In real applications, ArrayBlockingQueue or LinkedBlockingQueue is usually preferred.
 */
