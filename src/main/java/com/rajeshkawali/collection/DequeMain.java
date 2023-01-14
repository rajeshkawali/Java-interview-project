package com.rajeshkawali.collection;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Rajesh_Kawali
 *
 */
public class DequeMain {

	/*
		The java.util.Deque interface is a subtype of the java.util.Queue interface. 
		The Deque is related to the double-ended queue that supports addition or removal of elements 
		from either end of the data structure, it can be used as a queue (first-in-first-out/FIFO) 
		or as a stack (last-in-first-out/LIFO).
		
		Deque (double-ended queue) interface extends the Queue interface and 
		represents a data structure that allows insertion and removal of elements from both ends. 
		It is a subtype of Queue that supports insertion, removal, and inspection of elements at both the front 
		and back of the queue. Some common implementation classes for Deque are ArrayDeque and LinkedList.
	*/
	
    //1.add(element): Adds an element to the tail.
    //2.addFirst(element): Adds an element to the head.
    //3.addLast(element): Adds an element to the tail.
    //4.offer(element): Adds an element to the tail and returns a boolean to explain if the insertion was successful.
    //5.offerFirst(element): Adds an element to the head and returns a boolean to explain if the insertion was successful.
    //6.offerLast(element): Adds an element to the tail and returns a boolean to explain if the insertion was successful.
    //7.iterator(): Returna an iterator for this deque.
    //8.descendingIterator(): Returns an iterator that has the reverse order for this deque.
    //9.push(element): Adds an element to the head.
    //10.pop(element): Removes an element from the head and returns it.
    //11.removeFirst(): Removes the element at the head.
    //12.removeLast(): Removes the element at the tail.

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Deque deque = new LinkedList<>();
		//Deque<String> deque = new ArrayDeque<>();

		// We can add elements to the queue in various ways
		deque.add("Element 1 (Tail)"); // add to tail
		deque.addFirst("Element 2 (Head)");
		deque.addLast("Element 3 (Tail)");
		deque.push("Element 4 (Head)"); // add to head
		deque.offer("Element 5 (Tail)");
		deque.offerFirst("Element 6 (Head)");
		deque.offerLast("Element 7 (Tail)");

		System.out.println(deque + "\n");
		
		// remove elements from the Deque
		deque.pollFirst();
		deque.pollLast();

        // inspect elements at the front and back of the Deque
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());
        
     // remove elements from the Deque
        deque.removeFirst();
        deque.removeLast();
        deque.pollFirst();
        deque.pollLast();

        // inspect elements at the front and back of the Deque
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());

		// Iterate through the queue elements.
		System.out.println("Standard Iterator");
		Iterator iterator = deque.iterator();
		while (iterator.hasNext())
			System.out.println("\t" + iterator.next());

		// Reverse order iterator
		Iterator reverse = deque.descendingIterator();
		System.out.println("Reverse Iterator");
		while (reverse.hasNext())
			System.out.println("\t" + reverse.next());

		// Peek returns the head, without deleting it from the deque
		System.out.println("Peek " + deque.peek());
		System.out.println("After peek: " + deque);

		// Pop returns the head, and removes it from the deque
		System.out.println("Pop " + deque.pop());
		System.out.println("After pop: " + deque);

		deque.add("Element 3 (Tail)"); 
		// We can check if a specific element exists in the deque
		System.out.println("Contains element 3: " + deque.contains("Element 3 (Tail)"));

		deque.addFirst("Element 2 (Head)");
		deque.addLast("Element 3 (Tail)");
		
		// We can remove the first / last element.
		deque.removeFirst();
		deque.removeLast();
		System.out.println("Deque after removing " + "first and last: " + deque);
		System.out.println("-----------------------------------------------");
	}
}
/*
Here are some key points to remember when using the Deque interface in Java:-->

Deque is a double-ended queue, which means elements can be inserted and removed from both ends.

Common implementation classes for Deque include ArrayDeque and LinkedList.

To add elements to the Deque, you can use methods such as addFirst(), addLast(), offerFirst(), and offerLast().

To remove elements from the Deque, you can use methods such as removeFirst(), removeLast(), pollFirst(), and pollLast().

To inspect elements at the front and back of the Deque, you can use methods such as getFirst(), getLast(), peekFirst(), and peekLast().

When removing or inspecting elements from the Deque, it's important to check if the Deque is empty. removeFirst(), removeLast(), getFirst(), getLast() will throw NoSuchElementException if deque is empty, you can use pollFirst(), pollLast(), peekFirst(), peekLast() which will return null if deque is empty.

To control the concurrency of a Deque you can use the synchronizedDeque() method of the Collections class to create a thread-safe version of a Deque.

The Deque interface also provides some additional methods such as push(), pop(), descendingIterator() which are useful in certain use cases.

You should also consider the performance characteristics of different Deque implementations when choosing an implementation class. For example, ArrayDeque is typically faster for certain operations than LinkedList.
*/