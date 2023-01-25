package com.rajeshkawali.collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Rajesh_Kawali
 *
 */
@SuppressWarnings("rawtypes")
public class LinkedListMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// 1.It allows multiple null elements.
		// 2.Duplicates elements are allowed.
		// 3.Insertion order are preserved.
		// 4.In LinkedList there is no default capacity at all, Instead it creates a Node dynamically.
		// 5.It allows Heterogeneous Objects.
		// 6.If we access index value which is not available in LinkedList then it return IndexOutOfBoundsException.
		// 7.It implements List, Cloneable, Serializable and Deque.It extends AbstractSequentialList class.
		// 8.The LinkedList can also be used as ArrayList, Queue, Single linked list and doubly linked list.
		// 9.Insertion and removal operations in LinkedList are faster than the ArrayList.Because in LinkedList, there is no need to shift the elements after each insertion and removal
		// 10.Retrieval of the elements is very slow in LinkedList as compared to ArrayList.Becaues in LinkedList, you have to traverse from beginning or end to reach the element.
		// 11.LinkedList is better for manipulating data.
		// 12.Underlying data structure is Doubly Linked list.
		// 13.LinkedList is not Synchronized.
		// 14. Only difference with ArrayList is LL is not having default capacity and it is best for removal/Insertion operation.
		
		LinkedList list = new LinkedList();
		System.out.println("Initial capacity :" + list.size());

		// System.out.println("Array Index[0] :"+list.get(0)); //IndexOutOfBoundsException

		list.add("rajesh");
		list.add(1234);
		list.add(null);
		list.add("NiviTech");
		list.add(null);
		list.add("rajesh");
		list.add("1234");
		list.add(1234);
		list.add(null);
		list.add("rajesh");

		// System.out.println("Array Index[17] :"+list.get(17)); //IndexOutOfBoundsException
		System.out.println(list);
		System.out.println("After adding Objects- Capacity :" + list.size());
		
		System.out.println("------------------------------------------------------");
		System.out.println("#1 iterator");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + ", ");
		}
		System.out.println("------------------------------------------------------");
		System.out.println("#2 advance for loop");
		for (Object temp : list) {
			System.out.print(temp+", "); // rajesh, 1234, null, NiviTech, null, rajesh, 1234, 1234, null, rajesh,
		}
	}
}

/*
In Java, LinkedList is a class that implements the List interface and extends the AbstractSequentialList class. 
It is an implementation of a doubly-linked list, which means that each element in the list has a 
reference to the previous and next elements.

LinkedList provides constant-time performance for the basic operations (add, get, set, remove) 
at the beginning and end of the list, but it has linear-time performance for these operations when 
performed in the middle of the list. It's useful when the elements need to be frequently inserted or 
removed at the beginning or end of the list, and when the iteration needs to be 
done in both forward and backward direction.

LinkedList also provides additional methods like addFirst(E e) and addLast(E e) 
which adds the specified element to the front and end of the list respectively 
and getFirst() and getLast() which returns the first and last element in the list respectively.

In summary, LinkedList is a class that implements the List interface and it's an 
implementation of a doubly-linked list. It provides constant-time performance for 
basic operations at the beginning and end of the list but linear-time performance 
when the operation is performed in the middle of the list. It's useful when elements 
need to be frequently inserted or removed at the beginning or end of the list and when 
the iteration needs to be done in both forward and backward direction.
*/


/*
LinkedList is a class in Java that implements the List interface and extends the AbstractSequentialList class.
It is an implementation of a doubly-linked list, which means that each element in the list has a reference to the previous and next elements.
LinkedList provides constant-time performance for basic operations (add, get, set, remove) at the beginning and end of the list, but has linear-time performance for these operations when performed in the middle of the list.
It's useful when the elements need to be frequently inserted or removed at the beginning or end of the list and when the iteration needs to be done in both forward and backward direction.
LinkedList provides additional methods like addFirst(E e), addLast(E e), getFirst(), and getLast() which can be used to add and retrieve elements to and from the front and end of the list respectively.
LinkedList is not thread-safe, so if multiple threads are accessing the same LinkedList object and at least one of them modifies the list, there is a risk of data corruption.
*/


/*
Difference between ArrayList, LinkedList, and Vector :-->

All three classes, ArrayList, LinkedList, and Vector, implement the List interface in Java and provide a way to store and manipulate a collection of elements. However, there are some key differences between them:

Data Structure: ArrayList uses an array to store its elements, LinkedList uses a doubly-linked list, and Vector uses an array as well.

Performance: ArrayList provides constant-time performance for basic operations (add, get, set, remove) when performed at the end of the list. LinkedList provides constant-time performance for basic operations (add, get, set, remove) at the beginning and end of the list, but it has linear-time performance when performed in the middle of the list. Vector provides constant-time performance for basic operations, but it is slightly slower than ArrayList in single-threaded scenarios.

Thread Safety: ArrayList is not thread-safe, while Vector is thread-safe. LinkedList is also not thread-safe.

Resizing: ArrayList increases its size by 50% when the number of elements exceeds the capacity, while Vector increases its size by 100%. LinkedList does not have a capacity and it does not need to be resized.

Additional Methods: Vector provides additional methods like capacity() and ensureCapacity(int minCapacity), while ArrayList and LinkedList do not have such methods.

In summary, all three classes, ArrayList, LinkedList, and Vector, implement the 
List interface in Java and provide a way to store and manipulate a collection of elements. 
But they are different in terms of data structure, performance, thread safety, resizing and 
additional methods. ArrayList uses an array, provides constant time performance for basic 
operations when performed at the end of the list, is not thread-safe, and increases its 
size by 50% when the number of elements exceeds the capacity. LinkedList uses a doubly-linked list, 
provides constant-time performance for basic operations at the beginning and end of the list, 
but has linear-time performance when performed in the middle of the list, is not thread-safe, 
and does not have a capacity. Vector uses an array, provides constant-time performance for basic 
operations, but is slightly slower than ArrayList in single-threaded scenarios, is thread-safe, 
increases its size by 100%, and provides additional methods like capacity() and ensureCapacity(int minCapacity).
*/