package com.rajeshkawali.collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rajesh_Kawali
 *
 */
public class QueueMain {

	/*
	 * Queue in Java - Definition
	 *
	 * Queue is an interface in Java that extends the Collection
	 * interface. It generally follows FIFO (First In, First Out),
	 * meaning the first inserted element is removed first.
	 *
	 * Exception: PriorityQueue processes elements based on priority.
	 */

	// 1. Queue is an interface that extends Collection.
	// 2. Queue generally follows FIFO (First In, First Out).
	// 3. add(e) - Inserts an element into the queue. Throws IllegalStateException if capacity restrictions prevent insertion.
	// 4. offer(e) - Inserts an element into the queue. Returns true if successful, false if capacity is full.
	// 5. peek() - Returns the head without removing it. Returns null if the queue is empty.
	// 6. element() - Returns the head without removing it. Throws NoSuchElementException if the queue is empty.
	// 7. remove() - Removes and returns the head. Throws NoSuchElementException if the queue is empty.
	// 8. poll() - Removes and returns the head. Returns null if the queue is empty.
	// 9. Null elements are generally not allowed. LinkedList allows null, but it is discouraged in queues.
	// 10. Duplicate elements are allowed in common implementations.
	// 11. Queue does not provide index-based access like get(index), set(index), or add(index, element).
	// 12. Queue is not inherently synchronized (thread-safe).
	// 13. Common implementations: LinkedList, ArrayDeque, PriorityQueue.
	// 14. PriorityQueue orders elements based on priority (natural ordering or a Comparator), not FIFO.
	// 15. Queue supports dynamic sizing in common implementations, but some queues have fixed capacity.
	// 16. size() - Returns the number of elements.
	// 17. isEmpty() - Checks whether the queue is empty.
	// 18. contains(e) - Checks whether an element exists.
	// 19. clear() - Removes all elements from the queue.
	// 20. Queue is commonly used in task scheduling, BFS algorithms, buffering, and message processing.


	public static void main(String[] args) {

		// Queue is an interface; LinkedList is implementation.
        Queue<String> queue = new LinkedList<>();

        // 1. add() - Inserts element at rear.
        queue.add("Rajesh");
        queue.add("Krishna");

        // 2. offer() - Inserts element at rear.
        // Returns true if successful.
        queue.offer("Mumbai");
        queue.offer("Pune");
        queue.offer("Rajesh"); // Duplicates allowed.

        System.out.println("Queue: " + queue);

        // 3. peek() - Returns front without removing.
        // Returns null if empty.
        System.out.println("Peek: " + queue.peek());

        // 4. element() - Returns front without removing.
        // Throws exception if empty.
        System.out.println("Element: " + queue.element());

        // 5. poll() - Removes and returns front.
        // Returns null if empty.
        System.out.println("Poll: " + queue.poll());

        // 6. remove() - Removes and returns front.
        // Throws exception if empty.
        System.out.println("Remove: " + queue.remove());

        // 7. contains() - Checks element existence.
        System.out.println("Contains Pune: "
                           + queue.contains("Pune"));

        // 8. size() - Returns number of elements.
        System.out.println("Size: " + queue.size());

        // 9. isEmpty() - Checks if queue is empty.
        System.out.println("Is Empty: " + queue.isEmpty());

        // 10. forEach() - Traverses elements.
        queue.forEach(System.out::println);

        // 11. clear() - Removes all elements.
        queue.clear();

        System.out.println("After Clear: " + queue);

        // 12. Empty queue behavior.
        System.out.println("Peek: " + queue.peek()); // null
        System.out.println("Poll: " + queue.poll()); // null

        // queue.remove();  // NoSuchElementException
        // queue.element(); // NoSuchElementException
    }
}

