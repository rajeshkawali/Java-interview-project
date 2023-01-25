package com.rajeshkawali.collection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Rajesh_Kawali
 *
 */
public class ArrayListeMain {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		// Vector - 10, ArrayList - 10, Hashtable - 11, HashMap - 16, HashSet - 16 
		
		// 1.It allows multiple null elements.
		// 2.Duplicates elements are allowed.
		// 3.Insertion order are preserved.
		// 4.ArrayList has default initial capacity 10 and load factor (new capacity=(current capacity * 3/2)+1).
		// 5.It allows Heterogeneous Objects. 
		// 6.If we access index value which is not available in ArrayList then it return IndexOutOfBoundsException.
		// 7.It implements List, Cloneable, Serializable and RandomAccess (Marker interface).It extends AbstractList class.
		// 8.ArrayList is better for storing and accessing data(retrival operation).
		// 9.ArrayList is not Synchronized.
		// 10.Underlying data structure is Resizable-array or Growable array (Dynamically grow-able and shrink-able collection of objects).
		// 11.Increasing its size by 50% when it fill with 11th element.
		
		ArrayList arlTest = new ArrayList();
		System.out.println("Size of ArrayList at creation: " + arlTest.size()); // zero
		arlTest.add("D");
		arlTest.add("U");
		System.out.println(arlTest.add("K"));
		System.out.println(arlTest.add("E"));
		arlTest.add(null);
		arlTest.add(2);
		System.out.println(arlTest.add("E"));
		arlTest.add(""); // It will accept as empty value.
		arlTest.add(null);
		//System.out.println("index of ArrayList at 22 --: " + arlTest.get(22)); //IndexOutOfBoundsException
		System.out.println("Size of ArrayList after adding elements: " + arlTest.size()); // 9
		System.out.println("List of all elements: " + arlTest); // [D, U, K, E, null, 2, E, , null]
		// Remove some elements from the list
		arlTest.remove("D");
		System.out.println("See contents after removing one element: " + arlTest); //[U, K, E, null, 2, E, , null]
		arlTest.remove(2);// Remove element by index
		System.out.println("See contents after removing element by index: " + arlTest);//[U, K, null, 2, E, , null]
		// Check size after removing elements
		System.out.println("Size of arrayList after removing elements: " + arlTest.size());// 7
		System.out.println("List of all elements after removing elements: " + arlTest);//[U, K, null, 2, E, , null]
		System.out.println(arlTest.contains("K")); // Check if the list contains "K"
		System.out.println("----------------------for loop--------------------------------");
		System.out.println("#1 normal for loop");
		for (int i = 0; i < arlTest.size(); i++) {
			System.out.print(arlTest.get(i)+", ");
		}
		System.out.println("\n---------------------for(Object temp:arlTest)---------------------------------");
		System.out.println("#2 advance for loop");
		for (Object temp : arlTest) {
			System.out.print(temp+", "); // U, K, null, 2, E, , null, 
		}
		System.out.println("\n--------------------arlTest.get(j)----------------------------------");
		System.out.println("#3 while loop");
		int j = 0;
		while (arlTest.size() > j) {
			System.out.print(arlTest.get(j)+", ");// U, K, null, 2, E, , null,
			j++;
		}
		System.out.println("\n---------------------iterator()---------------------------------");
		System.out.println("#4 iterator");
		Iterator iterator = arlTest.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+", "); // U, K, null, 2, E, , null, 
		}
		System.out.println("\n----------------------forEach((temp)--------------------------------");
		System.out.println("#5 iterator");
		arlTest.forEach((temp) -> {
			System.out.print(temp+",");
		});
		System.out.println("\n-----------------------toArray()-------------------------------");
		System.out.println("#6 iterator");
		Object[] objects = arlTest.toArray();
		for (Object obj : objects) {
			System.out.print(obj + ", "); // U, K, null, 2, E, , null, 
		}
	}
}
/*
In Java, ArrayList is a class that implements the List interface and extends the AbstractList class. 
It is a resizable-array implementation of the List interface. This means that the size of an ArrayList 
can grow or shrink dynamically as elements are added or removed.

An ArrayList uses an array to store its elements, and it automatically increases the size of the array as needed. 
It provides constant-time performance for the basic operations (add, get, set, remove) as 
well as other operations like contains, indexOf, lastIndexOf, and clear.

ArrayList is a very flexible and powerful data structure, it's suitable for most use cases 
where you need to store a collection of items and you don't know the size of the collection in advance.

It also has an initial capacity of 10, and it increases its size by 50% when 
the number of elements exceeds the capacity.

In summary, ArrayList is a class that implements the List interface, 
it's a resizable-array implementation of the List interface, 
it uses an array to store its elements, and it automatically increases the size of the array as needed. 
It provides constant-time performance for the basic operations and it's suitable for most use 
cases where you need to store a collection of items and you don't know the size of the collection in advance.
*/

/*
ArrayList is a class in Java that implements the List interface and extends the AbstractList class.
It is a resizable-array implementation of the List interface.
ArrayList uses an array to store its elements and automatically increases the size of the array as needed.
It provides constant-time performance for basic operations like add, get, set, and remove.
It's flexible and powerful data structure and suitable for most use cases where the size of the collection is unknown in advance.
It has an initial capacity of 10, and it increases its size by 50% when the number of elements exceeds the capacity.
ArrayList is not thread-safe, so if multiple threads are accessing the same ArrayList object and at least one of them modifies the list, there is a risk of data corruption.
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