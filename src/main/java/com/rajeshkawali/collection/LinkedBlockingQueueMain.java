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
Difference between ArrayBlockingQueue, PriorityBlockingQueue and LinkedBlockingQueue:-->

ArrayBlockingQueue:
1.It is a thread-safe implementation of the BlockingQueue interface that is based on an array.
2.The size of an ArrayBlockingQueue is fixed and it can't be resized.
3.It's elements are ordered in the order they are added, and elements are retrieved in the order they are added.
4.It is useful when you need a queue with a fixed size and you have to handle multithreading.

PriorityBlockingQueue:
1.It is a thread-safe implementation of the BlockingQueue interface that orders elements according to their natural ordering or a provided comparator.
2.The size of a PriorityBlockingQueue can grow or shrink dynamically.
3.It's elements are ordered by their priority, which can be determined by their natural ordering or by a provided comparator.
4.It is useful when you need to order elements in the queue based on their priority and handle multithreading.

LinkedBlockingQueue:
1.It is a thread-safe implementation of the BlockingQueue interface that is based on linked nodes.
2.The size of a LinkedBlockingQueue can grow or shrink dynamically.
3.It's elements are ordered in the order they are added, and elements are retrieved in the order they are added.
4.It is useful when you need a queue that can grow or shrink dynamically and you have to handle multithreading.
*/

/*
LinkedBlockingQueue class provides the following methods:-->

add(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.

offer(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.

put(E e): Inserts the specified element into this queue, waiting if necessary for space to become available.

offer(E e, long timeout, TimeUnit unit): Inserts the specified element into this queue, waiting up to the specified wait time if necessary for space to become available.

take(): Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.

poll(long timeout, TimeUnit unit): Retrieves and removes the head of this queue, waiting up to the specified wait time if necessary for an element to become available.

poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.

peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.

size(): Returns the number of elements in this collection.

remainingCapacity(): Returns the number of additional elements that this queue can ideally (in the absence of memory or resource constraints) accept without blocking.

remove(Object o): Removes a single instance of the specified element from this queue, if it is present.

contains(Object o): Returns true if this queue contains the specified element.

clear(): Removes all of the elements from this queue.

drainTo(Collection<? super E> c): Removes all available elements from this queue and adds them to the given collection.

drainTo(Collection<? super E> c, int maxElements): Removes at most the given number of available elements from this queue and adds them to the given collection.

iterator(): Returns an iterator over the elements in this queue in proper sequence.

toArray(): Returns an array containing all of the elements in this queue in proper sequence.

toArray(T[] a): Returns an array containing all of the elements in this queue in proper sequence; the runtime type of the returned array is that of the specified array.
*/
