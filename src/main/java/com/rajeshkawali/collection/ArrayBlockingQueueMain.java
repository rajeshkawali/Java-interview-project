package com.rajeshkawali.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
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
	public static void main(String[] args) {
		// define capacity of ArrayBlockingQueue
		int capacity = 10;

		// Create a queue with a capacity of 10 elements
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Remove and return the head of the queue
        int head = queue.poll();
        System.out.println("Head of queue: " + head);  // Outputs "Head of queue: 1"

        // Return the head of the queue without removing it
        head = queue.peek();
        System.out.println("Head of queue: " + head);  // Outputs "Head of queue: 2"

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Queue is empty: " + isEmpty);  // Outputs "Queue is empty: false"

        // Get the size of the queue
        int size = queue.size();
        System.out.println("Size of queue: " + size);  // Outputs "Size of queue: 2"

        // Check if the queue contains a specific element
        boolean contains = queue.contains(3);
        System.out.println("Queue contains 3: " + contains);  // Outputs "Queue contains 3: true"

        // Remove all elements from the queue
        queue.clear();
        isEmpty = queue.isEmpty();
        System.out.println("Queue is empty: " + isEmpty);  // Outputs "Queue is empty: true"
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
