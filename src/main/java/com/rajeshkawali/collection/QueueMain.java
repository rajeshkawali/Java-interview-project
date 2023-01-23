package com.rajeshkawali.collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author Rajesh_Kawali
 *
 */
public class QueueMain {

	/*
	Queue is a collection in Java that represents a waiting line of elements. 
	It follows the FIFO (First-In-First-Out) ordering, 
	which means that the first element added to the queue is the first one to be removed.
	*/

   // 1.Add()-Adds an element at the tail of queue. More specifically, at the last of linkedlist if it is used, or according to the priority in case of priority queue implementation.
   // 2.peek()-To view the head of queue without removing it. Returns null if queue is empty.
   // 3.element()-Similar to peek(). Throws NoSuchElementException if queue is empty.
   // 4.remove()-Removes and returns the head of the queue. Throws NoSuchElementException when queue is impty.
   // 5.poll()-Removes and returns the head of the queue. Returns null if queue is empty.
   //6.Null elements are not allowed in the queue. 
   //7.If you try to insert null object into the queue, it throws NullPointerException.
   //8.Queue can have duplicate elements.
   //9.Unlike a normal list, queue is not random access. i.e you can’t set or insert or get elements at an arbitrary positions.
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Queue myQueue = new LinkedList();
		// add elements in the queue using offer() - return true/false
		myQueue.offer("Monday");
		myQueue.offer("Thusday");
		boolean flag = myQueue.offer("Wednesday");
		System.out.println("Wednesday inserted successfully? " + flag);
		// add more elements using add() - throws IllegalStateException
		try {
			myQueue.add("Thursday");
			myQueue.add("Friday");
			myQueue.add("Weekend");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		System.out.println("Pick the head of the queue: " + myQueue.peek());
		String head = null;
		try {
			// remove head - remove()
			head = (String) myQueue.remove();
			System.out.print("1) Push out " + head + " from the queue ");
			System.out.println("and the new head is now: " + myQueue.element());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		// remove the head - poll()
		head = (String) myQueue.poll();
		System.out.print("2) Push out " + head + " from the queue");
		System.out.println("and the new head is now: " + myQueue.peek());
		// find out if the queue contains an object
		System.out.println("Does the queue contain 'Weekend'? " + myQueue.contains("Weekend"));
		System.out.println("Does the queue contain 'Monday'? " + myQueue.contains("Monday"));
	}
}
/*
Here is a list of some of the common methods of the Queue interface in Java:-->

add(E e): Adds the specified element to the end of the queue. Throws an IllegalStateException if the queue is full.
offer(E e): Adds the specified element to the end of the queue. Returns true if the element was added successfully, false if the queue is full.
remove(): Retrieves and removes the head of the queue (the first element added). Throws a NoSuchElementException if the queue is empty.
poll(): Retrieves and removes the head of the queue (the first element added). Returns null if the queue is empty.
element(): Retrieves, but does not remove, the head of the queue. Throws a NoSuchElementException if the queue is empty.
peek(): Retrieves, but does not remove, the head of the queue. Returns null if the queue is empty.
size(): Returns the number of elements in the queue.

It's worth noting that the Queue interface extends the Collection interface, 
so it also inherits methods such as isEmpty(), contains(), clear(), etc.

It's also worth noting that some of the Queue implementations have specific methods, 
like put() and take() methods in BlockingQueue, drainTo() method in Queue and 
offer(E e, long timeout, TimeUnit unit) and poll(long timeout, TimeUnit unit) 
in BlockingQueue which are not available in other implementations.
*/