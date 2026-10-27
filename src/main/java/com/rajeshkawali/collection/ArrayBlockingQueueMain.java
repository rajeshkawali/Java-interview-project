package com.rajeshkawali.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class ArrayBlockingQueueMain {
	/*
	ArrayBlockingQueue is a blocking queue implementation that is based on an array data structure. 
	It is useful for implementing producer-consumer patterns in a multi-threaded environment, 
	where producers add elements to the queue and consumers remove elements from the queue.

	One of the key features of ArrayBlockingQueue is that it is thread-safe, 
	meaning that multiple threads can access it concurrently without the risk of data corruption. 
	This makes it a good choice for implementing thread-safe queues in Java.
	*/
	private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) {
		// define capacity of ArrayBlockingQueue
		int capacity = 10;

		// Create a queue with a capacity of 10 elements
		BlockingQueue<Integer> aAueue = new ArrayBlockingQueue<>(capacity);

        // Add elements to the queue
		aAueue.add(1);
		aAueue.add(2);
		aAueue.add(3);

        // Remove and return the head of the queue
        int head = aAueue.poll();
        System.out.println("Head of queue: " + head);  // Outputs "Head of queue: 1"

        // Return the head of the queue without removing it
        head = aAueue.peek();
        System.out.println("Head of queue: " + head);  // Outputs "Head of queue: 2"

        // Check if the queue is empty
        boolean isEmpty = aAueue.isEmpty();
        System.out.println("Queue is empty: " + isEmpty);  // Outputs "Queue is empty: false"

        // Get the size of the queue
        int size = aAueue.size();
        System.out.println("Size of queue: " + size);  // Outputs "Size of queue: 2"

        // Check if the queue contains a specific element
        boolean contains = aAueue.contains(3);
        System.out.println("Queue contains 3: " + contains);  // Outputs "Queue contains 3: true"

        // Remove all elements from the queue
        aAueue.clear();
        isEmpty = aAueue.isEmpty();
        System.out.println("Queue is empty: " + isEmpty);  // Outputs "Queue is empty: true"
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
 * ArrayBlockingQueue in Java
 
  ArrayBlockingQueue is a thread-safe, fixed-capacity
  implementation of the BlockingQueue interface.
  It follows FIFO (First In, First Out) ordering.
 
  It is mainly used in multithreaded applications
  to implement the Producer-Consumer pattern.
 
  Important Features:
  1. It implements BlockingQueue and extends AbstractQueue.
  2. It uses an array as its underlying data structure.
  3. It follows FIFO (First In, First Out).
  4. It has a fixed capacity specified at creation.Capacity cannot be changed after creation.
  5. It is thread-safe and uses locking internally.
  6. It allows duplicate elements but NOT null values.
  7. It maintains insertion order (FIFO).
  8. put() blocks when the queue is full.
  9. take() blocks when the queue is empty.
  10. offer() returns false if the queue is full.
  11. poll() returns null if the queue is empty.
  12. It supports optional fairness (true/false)for ordering waiting producer/consumer threads.
  13. It does NOT support index-based access.
  14. It is best suited for Producer-Consumer problemsand multithreaded task processing.
 
  Important Methods:
  put(e)             - Inserts; waits if full.
  take()             - Removes; waits if empty.
  offer(e)           - Inserts; returns false if full.
  poll()             - Removes; returns null if empty.
  add(e)             - Inserts; throws exception if full.
  remove()           - Removes; throws exception if empty.
  peek()             - Reads head; null if empty.
  remainingCapacity()- Returns available slots.
  size()             - Returns number of elements.
  isEmpty()          - Checks whether queue is empty.
 
  Timed Methods:
  offer(e, time, unit) - Waits up to specified time for available space.
  poll(time, unit)     - Waits up to specified time  for an element.
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