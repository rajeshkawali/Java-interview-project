package com.rajeshkawali.collection;
import java.util.HashSet;

/**
 * @author Rajesh_Kawali
 *
 */
public class HashSetMain {

	@SuppressWarnings({ "rawtypes", "unchecked",  })
	public static void main(String[] args) {
		
		// 1.It allows only one null elements.
		// 2.Duplicates elements are not allowed.
		// 3.Insertion order are not preserved.
		// 4.HashSet has default initial capacity (16) and the default load factor (0.75).
		// 5.It allows Heterogeneous Objects (Only TreeSet and TreeMap are not allowed). 
		// 6.null element always going to location zero.
		// 7.It implements Set, Cloneable, Serializable .It extends AbstractSet class.
		// 8.HashSet offers constant time performance for insertion, removal and retrieval operations.
		// 9.Underlying data structure- it internally uses HashMap.
		// 10.when we adding elements in HashSet,If that element already exist then old element replaced with new element.
		// 11.Set interface is that add() method will return false if you try to insert an element which is already present in the set.
		// 12.HashSet internally uses HashMap to store the objects. The elements you insert in HashSet will be stored as keys of that HashMap object and their values will be a constant called PRESENT.
		// 13.HashSet class is not synchronized. If you want synchronized HashSet, use Collections.synchronizedSet() method.
			
		
		HashSet hs = new HashSet();
		System.out.println("Size of HashSet Before adding Objects :"+hs.size()); // zero
		
		hs.add("D");
		hs.add("U");
		hs.add("K");
		hs.add("E");
		hs.add("L");
		//System.out.println("Inserting duplicate element in HashSet  :"+hs.add("L")); // false
		hs.add(null);
		hs.add(2);
		hs.add("E"); // return false.
		hs.add(null); // return false.
		hs.add(""); // It will accept as empty value.
		hs.add(null);
		System.out.println("To check the Letter(R) is contains or Not :" + hs.contains("R")); //false
		System.out.println("HashSet Contains following Objects :"+hs); // [null, , 2, D, U, E, K, L]
		System.out.println("Size of HashSet After adding Objects :"+hs.size()); // 8
		System.out.println("------------------------------------------------------");

		for (Object temp : hs) {
			System.out.print(temp+", ");// null, , 2, D, U, E, K, L, 
		}
	}
}

/*
In Java, HashSet is a class that implements the Set interface and extends the AbstractSet class. 
It uses a HashMap internally to store its elements, where the keys are the elements in the set, and the values are a constant.

HashSet provides a fast and efficient way to store unique elements in a collection. 
It uses the hashCode() method of the elements to determine their position in the 
internal HashMap and uses the equals() method to check for duplicates.

HashSet is not ordered, which means that the order of the elements in the set 
is not guaranteed to be the same as the order in which they were added.

HashSet also provides some additional methods like addAll(Collection c) which 
adds all of the elements in the specified collection to this set.

It has a default initial capacity of 16 and a load factor of 0.75 which means 
that when the number of elements in the set exceeds 75% of the initial capacity, 
the set will automatically increase its capacity to maintain good performance.

In summary, HashSet is a class that implements the Set interface, 
it uses a HashMap internally to store its elements and provides a fast 
and efficient way to store unique elements in a collection. 
It is not ordered and it's useful when the uniqueness of elements is important.
*/


/*
HashSet is a class in Java that implements the Set interface and extends the AbstractSet class.
It uses a HashMap internally to store its elements, where the keys are the elements in the set, and the values are a constant.
HashSet provides a fast and efficient way to store unique elements in a collection.
It uses the hashCode() method of the elements to determine their position in the internal HashMap and uses the equals() method to check for duplicates.
HashSet is not ordered, which means that the order of the elements in the set is not guaranteed to be the same as the order in which they were added.
HashSet is useful when the uniqueness of elements is important.
It has a default initial capacity of 16 and a load factor of 0.75, which means that when the number of elements in the set exceeds 75% of the initial capacity, the set will automatically increase its capacity to maintain good performance.
HashSet is not thread-safe, so if multiple threads are accessing the same HashSet object and at least one of them modifies the set, there is a risk of data corruption.
*/


/*
Difference between LinkedHashSet and HashSet:--> 

Both LinkedHashSet and HashSet are classes in Java that implement the Set interface and 
provide a fast and efficient way to store unique elements in a collection. However, 
there are a few key differences between the two:

Ordering: LinkedHashSet maintains the order of elements in which they were inserted, 
while HashSet does not. This means that the elements in a LinkedHashSet will be returned 
in the order in which they were added, while the elements in a HashSet will not be in any specific order.

Performance: HashSet is slightly faster than LinkedHashSet because it does not need to maintain the order of elements.

Implementation: LinkedHashSet uses a LinkedHashMap internally to store its elements, while HashSet uses a HashMap.

Additional Methods: LinkedHashSet provides additional methods like addAll(Collection c) which 
adds all of the elements in the specified collection to this set, while HashSet does not.

In summary, both LinkedHashSet and HashSet are classes in Java that implement the Set interface 
and provide a fast and efficient way to store unique elements in a collection. 
However, LinkedHashSet maintains the order of elements in which they were inserted, while HashSet does not. 
LinkedHashSet is slightly slower than HashSet because it needs to maintain the order of elements 
and it uses a LinkedHashMap internally to store its elements while HashSet uses HashMap. 
LinkedHashSet provides additional methods like addAll(Collection c) which HashSet does not.
*/