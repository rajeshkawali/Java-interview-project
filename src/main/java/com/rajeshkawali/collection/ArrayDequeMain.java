package com.rajeshkawali.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeMain {

    public static void main(String[] args) {
    		
    	/*
    	ARRAYDEQUE IN JAVA
    	------------------
    	ArrayDeque (Array Double-Ended Queue) is a resizable-array 
    	implementation of the Deque interface in Java. 
    	It allows insertion and deletion of elements 
    	from both ends (front and rear) and supports 
    	both Stack (LIFO) and Queue (FIFO) operations.

    	1. ArrayDeque implements the Deque interface.
    	2. It extends the AbstractCollection class.
    	3. It uses a resizable array internally.
    	4. It supports both Stack (LIFO) and Queue (FIFO).
    	5. It allows duplicate elements.
    	6. It does NOT allow null elements.
    	7. It maintains the order of elements in the deque.
    	8. It is NOT synchronized (not thread-safe).
    	9. It grows dynamically when required.
    	10. It does NOT support index-based access like get(0).
    	11. It is generally faster than Stack for LIFO operations.
    	12. It is generally faster than LinkedList for deque operations.
    	13. Most insertion/removal operations at both ends take O(1) amortized time.
    	14. push() and pop() are used for Stack operations.
	15. offer() and poll() are used for Queue operations.
	16. peek() returns the first element without removing it.
	17. poll() and peek() return null if the deque is empty.
	18. remove(), pop() and getFirst() throw NoSuchElementException if the deque is empty.
	19. It supports forward and reverse traversal using iterator() and descendingIterator().
	20. It is NOT suitable for concurrent access without external synchronization.

    	IMPORTANT:
    	- ArrayDeque is preferred over Stack for stack operations.
    	- ArrayDeque is often preferred over LinkedList for queues.
    	- It is not designed for inserting elements in the middle.
    	*/
    		
        Deque<String> deque = new ArrayDeque<>();

        // 1. Adding elements
        deque.add("Java");           // Adds at rear
        deque.addFirst("Python");    // Adds at front
        deque.addLast("Spring");     // Adds at rear
        deque.offer("SQL");          // Adds at rear, returns boolean
        deque.offerFirst("HTML");    // Adds at front
        deque.offerLast("React");    // Adds at rear

        System.out.println(deque);
        // [HTML, Python, Java, Spring, SQL, React]

        // 2. Accessing elements (without removing)
        System.out.println(deque.peek());      // HTML
        System.out.println(deque.peekFirst()); // HTML
        System.out.println(deque.peekLast());  // React
        System.out.println(deque.getFirst());  // HTML
        System.out.println(deque.getLast());   // React

        // 3. Removing elements
        System.out.println(deque.poll());        // HTML
        System.out.println(deque.pollFirst());   // Python
        System.out.println(deque.pollLast());    // React
        System.out.println(deque.removeFirst()); // Java
        System.out.println(deque.removeLast());  // SQL

        // 4. Searching and checking
        System.out.println(deque.contains("Spring")); // true
        System.out.println(deque.size());             // 1
        System.out.println(deque.isEmpty());          // false

        // 5. Stack operations (LIFO)
        deque.push("A"); // Adds at front
        deque.push("B"); // Adds at front
        System.out.println(deque.pop()); // B

        // 6. Queue operations (FIFO)
        deque.offer("C"); // Adds at rear
        System.out.println(deque.poll()); // A

        // 7. Traversing elements
        deque.forEach(System.out::println);

        // 8. Clear all elements
        deque.clear();
        System.out.println(deque.isEmpty()); // true

        // 9. Empty deque behavior
        System.out.println(deque.peek()); // null
        System.out.println(deque.poll()); // null

        // pop(), remove(), getFirst() throw
        // NoSuchElementException when empty.

        // 10. Null values are not allowed.
        // deque.add(null); // NullPointerException
    }
}
