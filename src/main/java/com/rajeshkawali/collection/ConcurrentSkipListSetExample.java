package com.rajeshkawali.collection;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetExample {

	public static void main(String[] args) {

		ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

		/* Add elements in random order. */
		set.add(30);
		set.add(10);
		set.add(50);
		set.add(20);
		set.add(40);

		/* Duplicate elements are ignored. */
		set.add(20);

		System.out.println("Set: " + set);

		/* Navigation methods. */
		System.out.println("First: " + set.first());
		System.out.println("Last: " + set.last());
		System.out.println("Lower: " + set.lower(30));
		System.out.println("Higher: " + set.higher(30));
		System.out.println("Floor: " + set.floor(25));
		System.out.println("Ceiling: " + set.ceiling(25));

		/* Remove an element. */
		set.remove(30);

		System.out.println("After removal: " + set);
	}
}


/*
 * =====================================================
 * ConcurrentSkipListSet in Java
 * =====================================================
 *
 * ConcurrentSkipListSet is a thread-safe and sorted
 * Set implementation from java.util.concurrent.
 *
 * It stores unique elements in ascending order
 * by default using a concurrent skip-list structure.
 *
 * IMPORTANT POINTS:
 *
 * 1. Thread-safe and supports concurrent operations.
 *
 * 2. Does not allow duplicate elements.
 *
 * 3. Maintains elements in sorted order.
 *
 * 4. Does not allow null elements.
 *
 * 5. Implements NavigableSet and SortedSet.
 *
 * 6. Uses a skip-list data structure internally.
 *
 * 7. add(), remove(), and contains() have
 *    expected O(log n) time complexity.
 *
 * 8. Iterators are weakly consistent and do not
 *    throw ConcurrentModificationException.
 *
 * 9. Supports navigation methods:
 *    first(), last(), lower(), higher(),
 *    floor(), ceiling(), pollFirst(), pollLast().
 *
 * 10. Supports custom sorting using Comparator.
 *
 * 11. Useful when sorted data must be accessed
 *     and modified by multiple threads.
 *
 * 12. Internally backed by ConcurrentSkipListMap.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * HashSet               -> Unsorted, not thread-safe.
 *
 * TreeSet               -> Sorted, not thread-safe.
 *
 * CopyOnWriteArraySet   -> Thread-safe, snapshot iterator,
 *                          suitable for read-heavy sets.
 *
 * ConcurrentSkipListSet -> Thread-safe, sorted,
 *                          weakly consistent iterator.
 *
 * =====================================================
 */
