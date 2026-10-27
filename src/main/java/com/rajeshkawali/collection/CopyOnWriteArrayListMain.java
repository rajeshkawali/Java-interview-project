package com.rajeshkawali.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Rajesh_Kawali
 *
 */
public class CopyOnWriteArrayListMain {


	/*
     * CopyOnWriteArrayList is a thread-safe List implementation.
     * It creates a new array copy for modification operations.
     * Best for frequent reads and fewer writes.
     */

	// 1. It implements List, RandomAccess, Cloneable, and Serializable interfaces.
	// 2. It allows duplicate elements.
	// 3. It allows multiple null elements.
	// 4. It maintains insertion order.
	// 5. It allows heterogeneous objects using CopyOnWriteArrayList<Object>.
	// 6. It is thread-safe and belongs to java.util.concurrent.
	// 7. It uses an array as its underlying data structure.
	// 8. For every modification (add, set, remove), a new array copy is generally created.
	// 9. It is best for frequent read and rare write operations.
	// 10. Reading elements using get(index) takes O(1) time.
	// 11. Modification operations are costly, usually O(n), because the underlying array is copied.
	// 12. Its Iterator is fail-safe in the common interview sense: it uses a snapshot of the array.
	// 13. Its Iterator does NOT throw ConcurrentModificationException when another thread modifies the list.
	// 14. Iterator does not reflect modifications made after the Iterator was created.
	// 15. Iterator does NOT support remove(), set(), or add(). These operations throw UnsupportedOperationException.
	// 16. It supports index-based access using get(index).
	// 17. Invalid index access throws IndexOutOfBoundsException.
	// 18. It provides addIfAbsent() and addAllAbsent() to insert elements only if they are not present.
	// 19. It is generally slower than ArrayList for frequent modifications.
	// 20. It is useful for event listeners, shared read-heavy collections, and concurrent applications.


	public static void main(String[] args) {

        List<Object> list = new CopyOnWriteArrayList<>();

        // 1. Allows duplicates, null and heterogeneous objects.
        list.add("raj1");
        list.add('B');
        list.add('c');
        list.add(null);
        list.add(11.55f);
        list.add(11.55);
        list.add(null);
        list.add('B');
        list.add(24);
        list.add("raj1");

        System.out.println("Original List: " + list);

        // 2. add(index, element) - Inserts at specified index.
        list.add(1, "Java");

        // 3. get(index) - Returns element at index.
        System.out.println("Get: " + list.get(0));

        // 4. set(index, element) - Replaces element.
        list.set(0, "Updated Raj");

        // 5. contains() - Checks element existence.
        System.out.println("Contains B: " + list.contains('B'));

        // 6. indexOf() - Returns first matching index.
        System.out.println("IndexOf B: " + list.indexOf('B'));

        // 7. lastIndexOf() - Returns last matching index.
        System.out.println("LastIndexOf B: "
                           + list.lastIndexOf('B'));

        // 8. size() - Returns total elements.
        System.out.println("Size: " + list.size());

        // 9. isEmpty() - Checks whether list is empty.
        System.out.println("Is Empty: " + list.isEmpty());

        // ==========================================
        // 10. SNAPSHOT ITERATOR (IMPORTANT)
        // ==========================================

        // Iterator captures a snapshot at creation time.
        Iterator<Object> itr = list.iterator();
        int i = 0;
        while (itr.hasNext()) {
            // Adds to original list, NOT iterator snapshot.
            list.add("Add = " + (i++));
            System.out.println("Read = " + itr.next());
            // itr.remove(); // UnsupportedOperationException
        }
        // No ConcurrentModificationException occurs.
        System.out.println("After Iteration: " + list);

        // ==========================================
        // 11. ADD AND REMOVE OPERATIONS
        // ==========================================

        // add() - Adds element, returns true.
        System.out.println("Add: " + list.add("D"));

        // remove(Object) - Removes first matching element.
        // Character 'B' is different from String "B".
        System.out.println("Remove B: " + list.remove('B'));

        // remove(index) - Removes element at given index.
        System.out.println("Remove Index: " + list.remove(0));

        // ==========================================
        // 12. SPECIAL METHODS
        // ==========================================

        // These methods belong to CopyOnWriteArrayList.
        CopyOnWriteArrayList<Object> cowList = new CopyOnWriteArrayList<>(list);

        // addIfAbsent() - Adds only if element is absent.
        System.out.println("AddIfAbsent: " + cowList.addIfAbsent("Spring"));

        // Returns false because Spring already exists.
        System.out.println("AddIfAbsent Again: " + cowList.addIfAbsent("Spring"));

        // addAllAbsent() - Adds only missing elements.
        System.out.println("AddAllAbsent: "  + cowList.addAllAbsent(Arrays.asList("Java", "SQL", "Spring")));

        // ==========================================
        // 13. NEW ITERATOR
        // ==========================================

        // New iterator sees all current elements.
        System.out.println("Updated List:");

        for (Object element : cowList) {
            System.out.println(element);
        }

        // 14. forEach() - Traverses using lambda.
        cowList.forEach(System.out::println);

        // 15. toArray() - Converts List into array.
        Object[] array = cowList.toArray();

        System.out.println("Array: " + Arrays.toString(array));

        // 16. removeIf() - Removes matching elements.
        cowList.removeIf(e -> "Spring".equals(e));

        // 17. clear() - Removes all elements.
        cowList.clear();

        System.out.println("After Clear: " + cowList);

        // ==========================================
        // 18. IMPORTANT EXCEPTIONS
        // ==========================================

        // Invalid index throws IndexOutOfBoundsException.
        // cowList.get(100);

        // Iterator removal is not supported.
        // cowList.iterator().remove();
        // UnsupportedOperationException
    }
}

/*
 CopyOnWriteArrayList in Java
 
  CopyOnWriteArrayList is a thread-safe implementation of
  the List interface that uses a copy-on-write mechanism.
 
  Whenever an element is added, updated, or removed,
  a new copy of the underlying array is generally created.
  This allows safe concurrent reading and writing.
 
  It is best suited for frequent reads and infrequent writes.
 
  Internal Working:
  1. Elements are stored in an internal array.
  2. Read operations access the existing array without locking.
  3. Write operations create a new copy of the array.
  4. Changes are applied to the new array.
  5. The new array replaces the old array atomically.
  6. Existing iterators continue reading the old snapshot.
 
  Advantages:
  1. Thread-safe without external synchronization for individual operations.
  2. Fast read operations - O(1) for get(index).
  3. Snapshot iterator avoids ConcurrentModificationException.
  4. Allows duplicates, null values and maintains insertion order.
 
  Disadvantages:
  1. Write operations are expensive - usually O(n).
  2. Requires additional memory for array copies.
  3. Iterator does not reflect changes after its creation.
  4. Iterator modification methods are unsupported.
 
  Best Use Cases:
  Event listeners, configuration lists and read-heavy
  multithreaded applications.
*/

