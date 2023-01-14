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
put(E e): Inserts the specified element into the queue, blocking if necessary until there is space available.
take(): Retrieves and removes the head of the queue, blocking if necessary until an element becomes available.
offer(E e): Inserts the specified element into the queue if it is possible to do so immediately without blocking.
poll(): Retrieves and removes the head of the queue, or returns null if the queue is empty.
remainingCapacity(): Returns the number of additional elements that can be added to the queue without blocking.
size(): Returns the number of elements in the queue.
isEmpty(): Returns true if the queue is empty, and false otherwise.
*/

/*
1.ArrayBlockingQueue is a thread-safe queue implementation based on an array data structure.
2.It is useful for implementing producer-consumer patterns in a multi-threaded environment.
3.ArrayBlockingQueue has blocking behavior, meaning that producers will block when trying to add elements 
	to a full queue, and consumers will block when trying to remove elements from an empty queue.
4.ArrayBlockingQueue provides a number of useful methods for adding, removing, and querying the 
	elements in the queue, as well as for adjusting the queue's capacity and blocking behavior.
5.ArrayBlockingQueue is an efficient and thread-safe way to implement producer-consumer patterns in Java.
6.ArrayBlockingQueue has a fixed capacity, which means that you need to specify the maximum number 
	of elements that the queue can hold when you create it. Once the queue is full, producers will block until space becomes available.
7.ArrayBlockingQueue provides a number of useful blocking methods, such as put and take, 
	which allow producers and consumers to block until they are able to add or remove elements from the queue, respectively.
8.ArrayBlockingQueue also provides non-blocking methods, such as offer and poll, 
	which allow producers and consumers to attempt to add or remove elements from the queue without blocking.
9.ArrayBlockingQueue supports optional fairness policies, which can be specified 
	when the queue is created. Fairness policies determine the order in which producers and consumers are allowed to access the queue.
10. is part of the java.util.concurrent package, which contains a number of other 
	useful concurrent data structures and utilities for implementing concurrent programming in Java.
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