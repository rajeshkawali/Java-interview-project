package com.rajeshkawali.collection;

import java.util.concurrent.LinkedBlockingQueue;
/**
*
* @author Rajesh_Kawali
* 
*/
public class LinkedBlockingQueueMain {
	/*
	 LinkedBlockingQueue is a class in Java that implements the BlockingQueue
	 interface. It is based on linked nodes and provides a thread-safe way to
	 handle a queue of elements. It's a good choice when you need a queue that can
	 grow or shrink dynamically, as it doesn't have a fixed capacity like
	 ArrayBlockingQueue.
	 
	 A LinkedBlockingQueue can be created with a specified maximum capacity or
	 with no limit on capacity, in which case the queue can grow indefinitely.
	 */
	private static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
		// Adding elements to the queue
		queue.offer("element1");
		queue.offer("element2");
		queue.offer("element3");
		// Retrieving and removing the head of the queue
		String element = queue.poll();
		System.out.println("Retrieved and removed: " + element);
		// Retrieving but not removing the head of the queue
		element = queue.peek();
		System.out.println("Retrieved but not removed: " + element);
		// Checking the size of the queue
		int size = queue.size();
		System.out.println("Size of the queue: " + size);
		// Removing all elements from the queue
		queue.clear();

		System.out.println("-------------------------------------");
		Thread producer = new Thread(new Producer());
		Thread consumer = new Thread(new Consumer());
		producer.start();
		consumer.start();
	}

	static class Producer implements Runnable {
		@Override
		public void run() {
			while (true) {
				String item = produceItem();
				try {
					queue.put(item);
					System.out.println("Produced: " + item);
				} catch (InterruptedException e) {
					// Handle interruption
				}
			}
		}

		private String produceItem() {
			// Code to produce an item
			return "item" + Math.random();
		}
	}

	static class Consumer implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					String item = queue.take();
					System.out.println("Consumed: " + item);
				} catch (InterruptedException e) {
					// Handle interruption
				}
			}
		}
	}
}
/*
LinkedBlockingQueue is a thread-safe implementation of the BlockingQueue interface that is based on linked nodes.
It allows you to add and remove elements from the queue in a thread-safe manner, and can grow or shrink dynamically.
It can be used to implement the producer-consumer pattern, where one or more producer threads add elements to the queue, and one or more consumer threads remove elements from the queue.
The put() method is used to add elements to the queue and will block if the queue is full. The take() method is used to remove elements from the queue and will block if the queue is empty.
The offer() method is used to add elements to the queue without blocking if the queue is full, and the poll() method is used to remove elements without blocking if the queue is empty.
The peek() method is used to retrieve but not remove the head of the queue, and the size() method is used to check the size of the queue.
The clear() method is used to remove all elements from the queue.
LinkedBlockingQueue is useful when you need a queue that can grow or shrink dynamically and you have to handle multi-threading, it is a good choice.
It's important to remember that, while multithreading can be useful in some situations, it's not a panacea, and it can make the code more complex and harder to debug.
It's important to be familiar with the basic synchronization mechanisms such as locks, semaphores, and monitors, as well
*/



/*
 * Difference Between ArrayBlockingQueue,
 PriorityBlockingQueue and LinkedBlockingQueue

 1. ArrayBlockingQueue:
 - Implements BlockingQueue and extends AbstractQueue.
 - Underlying data structure is a fixed-size array.
 - Capacity is fixed and cannot be changed.
 - Follows FIFO (First In, First Out).
 - Thread-safe and supports blocking operations.
 - put() blocks when full; take() blocks when empty.
 - Supports optional fairness (true/false).
 - Does not allow null; allows duplicates.
 - Best for bounded Producer-Consumer applications.

 2. PriorityBlockingQueue:
 - Implements BlockingQueue and extends AbstractQueue.
 - Underlying data structure is a priority heap.
 - Unbounded queue (grows dynamically).
 - Does NOT follow FIFO; follows priority ordering.
 - Uses natural ordering or a custom Comparator.
 - Thread-safe and supports blocking operations.
 - put() never blocks due to capacity restrictions.
 - take() blocks when the queue is empty.
 - Does not allow null; allows duplicates.
 - Elements must be mutually comparable.
 - Best for priority-based task scheduling.

 3. LinkedBlockingQueue:
 - Implements BlockingQueue and extends AbstractQueue.
 - Underlying data structure is linked nodes.
 - Can be bounded or effectively unbounded.
 - Default capacity is Integer.MAX_VALUE.
 - Follows FIFO (First In, First Out).
 - Thread-safe and supports blocking operations.
 - put() blocks when full; take() blocks when empty.
 - Does not allow null; allows duplicates.
 - Uses separate locks for putting and taking.
 - Best for Producer-Consumer and task processing.

 Important Interview Differences:-->
 1.ArrayBlockingQueue:
 -> Fixed capacity + Array + FIFO.

 2.PriorityBlockingQueue:
 -> Unbounded + Heap + Priority ordering.

 3.LinkedBlockingQueue:
 -> Optional capacity + Linked Nodes + FIFO.

 Common Features:
 1. All implement the BlockingQueue interface.
 2. All belong to java.util.concurrent package.
 3. All are thread-safe.
 4. All allow duplicate elements.
 5. None allow null elements.
 6. All support put(), take(), offer(), poll(), peek().
 7. take() blocks when the queue is empty.

 Interview Key Point:
 ArrayBlockingQueue    -> Fixed-size FIFO queue.
 PriorityBlockingQueue -> Priority-based unbounded queue.
 LinkedBlockingQueue   -> Bounded/unbounded FIFO queue.
*/
