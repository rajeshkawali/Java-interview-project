package com.rajeshkawali.collection;

import java.util.concurrent.PriorityBlockingQueue;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class PriorityBlockingQueueMain {
	/*
	 PriorityBlockingQueue is a class in Java that implements the BlockingQueue
	 interface and provides a thread-safe way to handle a queue of elements, where
	 elements are ordered according to their natural ordering or by a comparator
	 provided at queue construction time.
	 
	 A PriorityBlockingQueue can be created with the default ordering, or with a
	 custom comparator.
	 
	 */
	private static PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

		// Adding elements to the queue
		queue.put(3);
		queue.put(1);
		queue.put(2);

		// Retrieving and removing the head of the queue
		System.out.println("Removed element: " + queue.take()); // 1
		System.out.println("Removed element: " + queue.take()); // 2
		System.out.println("Removed element: " + queue.take()); // 3

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
				int item = produceItem();
				try {
					queue.put(item);
					System.out.println("Produced: " + item);
				} catch (Exception e) {
					// Handle interruption
				}
			}
		}

		private int produceItem() {
			// Code to produce an item
			return (int) (Math.random() * 100);
		}
	}

	static class Consumer implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					int item = queue.take();
					System.out.println("Consumed: " + item);
				} catch (InterruptedException e) {
					// Handle interruption
				}
			}
		}
	}
}

/*
A PriorityBlockingQueue is a thread-safe implementation of the BlockingQueue interface that orders elements according to their natural ordering or a provided comparator.
The elements in a PriorityBlockingQueue are always removed from the head of the queue in the order of their priority.
The put() method is used to add elements to the queue and will block if the queue is full. The take() method is used to remove elements from the queue and will block if the queue is empty.
The offer() method is used to add elements to the queue without blocking if the queue is full, and the poll() method is used to remove elements without blocking if the queue is empty.
The peek() method is used to retrieve but not remove the head of the queue, and the size() method is used to check the size of the queue.
PriorityBlockingQueue can be useful when you need to order elements in the queue based on their priority and handle multithreading.
You can use a custom comparator to order the elements based on any criteria you want.
Remember that while multithreading can be useful in some situations, it's not a panacea, and it can make the code more complex and harder to debug.
Familiarize yourself with the basic synchronization mechanisms such as locks, semaphores, and monitors, as well as the thread-safe collection classes in the Java standard library.
Make sure to handle any interruption exception that may happen.
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