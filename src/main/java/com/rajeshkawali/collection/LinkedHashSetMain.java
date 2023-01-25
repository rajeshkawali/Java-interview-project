package com.rajeshkawali.collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author Rajesh_Kawali
 *
 */
public class LinkedHashSetMain {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		// 1.It allows only one Element as a null.
		// 2.Duplicates are not allowed.
		// 3.Insertion order are preserved.
		// 4.The default initial capacity (16) and the default load factor (0.75).
		// 5.Only one difference is, The LinkedHashSet insertion Order are Preserved but not HashSet.
		// 6.when we adding value in LinkedHashSet,If that element already exist then old element replaced with new element.
		// 7.HashSet uses HashMap object internally to store it's elements where as LinkedHashSet uses LinkedHashMap object internally to store and process it's elements.
		// 8.If we access index value which is not available in LinkedHashSet then it return null.
		// 9.LinkedHashSet underlying data structure is the Hashtable and linked list.
		LinkedHashSet lhs = new LinkedHashSet();
		System.out.println("Size of LinkedHashSet Before adding elements: " + lhs.size()); // zero
		
		lhs.add("B");
		lhs.add("C");
		lhs.add("E");
		lhs.add("K");
		lhs.add(null);
		lhs.add("B");  // Duplicate element. return false
		lhs.add(null); // Duplicate element (allows only one null). return false
		System.out.println(lhs.add("B")); // return false because B already exist in LinkedHashSet.
		lhs.add(123);
		lhs.add("");
		lhs.add("M");
		
		System.out.println("Elements of LinkedHashSet  : " + lhs); // [B, C, E, K, null, 123, , M]
		System.out.println("Size of LinkedHashSet After adding elements: " + lhs.size()); // 8
		System.out.println("------------------------------------------------------");

		Iterator iterator = lhs.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+", "); // B, C, E, K, null, 123, , M,
		}
	}
}
/*
In Java, LinkedHashSet is a class that extends the HashSet class and implements the Set interface. 
It uses a LinkedHashMap internally to store its elements, where the keys are the 
elements in the set, and the values are a constant.

LinkedHashSet provides a fast and efficient way to store unique elements in a 
collection, like HashSet, but it also maintains the order of elements in which 
they were inserted. It uses the hashCode() method of the elements to determine 
their position in the internal LinkedHashMap and uses the equals() method to check for duplicates.

LinkedHashSet is useful when you need to maintain the order of elements, 
but it's slightly slower than HashSet because it needs to maintain the order of elements.

It also provides additional methods like addAll(Collection c) which adds 
all of the elements in the specified collection to this set.

In summary, LinkedHashSet is a class that extends the HashSet class, it 
uses a LinkedHashMap internally to store its elements and provides a fast 
and efficient way to store unique elements in a collection and it maintains 
the order of elements in which they were inserted. It's useful when you need 
to maintain the order of elements, but it's slightly slower than HashSet because 
it needs to maintain the order of elements.
*/

/*
LinkedHashSet is a class in Java that extends the HashSet class and implements the Set interface.
It uses a LinkedHashMap internally to store its elements, where the keys are the elements in the set, and the values are a constant.
LinkedHashSet provides a fast and efficient way to store unique elements in a collection, like HashSet, but it also maintains the order of elements in which they were inserted.
It uses the hashCode() method of the elements to determine their position in the internal LinkedHashMap and uses the equals() method to check for duplicates.
LinkedHashSet is useful when you need to maintain the order of elements, but it's slightly slower than HashSet because it needs to maintain the order of elements.
LinkedHashSet provides additional methods like addAll(Collection c) which adds all of the elements in the specified collection to this set.
LinkedHashSet is not thread-safe, so if multiple threads are accessing the same LinkedHashSet object and at least one of them modifies the set, there is a risk of data corruption.
*/

/*
Difference between LinkedHashSet and HashSet:--> 

Both LinkedHashSet and HashSet are classes in Java that implement the Set interface and provide a fast and efficient way to store unique elements in a collection. However, there are a few key differences between the two:

Ordering: LinkedHashSet maintains the order of elements in which they were inserted, while HashSet does not. This means that the elements in a LinkedHashSet will be returned in the order in which they were added, while the elements in a HashSet will not be in any specific order.

Performance: HashSet is slightly faster than LinkedHashSet because it does not need to maintain the order of elements.

Implementation: LinkedHashSet uses a LinkedHashMap internally to store its elements, while HashSet uses a HashMap.

Additional Methods: LinkedHashSet provides additional methods like addAll(Collection c) which adds all of the elements in the specified collection to this set, while HashSet does not.

In summary, both LinkedHashSet and HashSet are classes in Java that implement the Set interface and provide a fast and efficient way to store unique elements in a collection. However, LinkedHashSet maintains the order of elements in which they were inserted, while HashSet does not. LinkedHashSet is slightly slower than HashSet because it needs to maintain the order of elements and it uses a LinkedHashMap internally to store its elements while HashSet uses HashMap. LinkedHashSet provides additional methods like addAll(Collection c) which HashSet does not.
*/