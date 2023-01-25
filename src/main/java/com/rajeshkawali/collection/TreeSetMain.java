package com.rajeshkawali.collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Rajesh_Kawali
 *
 */
public class TreeSetMain {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		// 1.It is not allow null as element.
		// 2.Duplicates elements are not allowed.
		// 3.Insertion order are not preserved Instead it stores Objects using some Default Natural sorting order.
		// 4.Iterator returned by TreeSet is of fail-fast nature. That means, If TreeSet is modified after the creation of Iterator object, you will get ConcurrentModificationException.
		// 5.It allows only Homogeneous Objects (Only TreeSet and TreeMap are allowed Homogeneous objects except this all are allows Heterogeneous Objects). 
		// 6.TreeSet internally uses TreeMap to store it's elements.
		// 7.It implements NavigableSet, Cloneable, Serializable .It extends AbstractSet class.
		// 8.TreeSet gives performance of order log(n) for insertion, removal and retrieval operations.
		// 9.Underlying data structure- it internally uses TreeMap.
		// 10.TreeSet is not synchronized. To get a synchronized TreeSet, use Collections.synchronizedSortedSet() method.
		// 11.TreeSet does not use hashing for storing Element. It internally uses TreeMap(data structure called "Red-Black tree").	
		
		TreeSet ts = new TreeSet();
		System.out.println("Size of TreeSet Before adding Objects :"+ts.size()); // zero
		
		ts.add("D");
		ts.add("U");
		ts.add("null"); // It is treated as a string. 
		ts.add("E");
		ts.add("3");
		ts.add("rajesh");
		ts.add("a");
		//ts.add(null); // return java.lang.NullPointerException
		//ts.add(2); //  return java.lang.ClassCastException : java.lang.String cannot be cast to java.lang.Integer
		ts.add("E"); // return false. Duplicate element are not allowed.
		ts.add(""); // It will accept as empty value.
		ts.add("A");
		//ts.add(20.65);  //inserting Double type element- return java.lang.ClassCastException
		
		System.out.println("To check the Letter(R) is contains or Not :" + ts.contains("R")); //false
		System.out.println("TreeSet Contains following Objects :"+ts); // [, 3, A, D, E, U, a, null, rajesh]
		System.out.println("Size of TreeSet After adding Objects :"+ts.size()); // 9
		System.out.println("------------------------------------------------------");
		Iterator itr = ts.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ,"); // ,3 ,A ,D ,E ,U ,a ,null ,rajesh ,
		}
		System.out.println("\n------------------------------------------------------");
		Object[] obj = ts.toArray();
		for (Object object : obj) {
			System.out.print(object); // 3ADEUanullrajesh
		}
		System.out.println("\n------------------------------------------------------");
		for (Object temp : ts) {
			System.out.print(temp+", "); // , 3, A, D, E, U, a, null, rajesh, 
		}
	}
}

/*
In Java, TreeSet is a class that implements the SortedSet interface and extends 
the AbstractSet class. It is a set that is ordered according to the natural 
ordering of its elements or by a Comparator provided at the time of creation. 
It uses a balanced tree data structure (typically a Red-Black Tree) to store the elements.

TreeSet provides a total ordering of its elements, which means that the elements 
are sorted in ascending order. This makes it useful for maintaining a sorted set 
of elements and for performing range searches and other operations that depend on the ordering of the elements.

TreeSet also provides additional methods like subSet(E fromElement, E toElement) which 
returns a view of the portion of this set whose elements range from fromElement, 
inclusive, to toElement, exclusive.

It's useful when the order of elements is important and also when you need to 
perform operations like range search, first, last, lower, higher, floor and ceiling.

In summary, TreeSet is a class that implements the SortedSet interface, it 
uses a balanced tree data structure (typically a Red-Black Tree) to store the 
elements and provides a total ordering of its elements. It's useful when the order 
of elements is important and when you need to perform operations like range search, 
first, last, lower, higher, floor and ceiling.
*/


/*
TreeSet is a class in Java that implements the SortedSet interface and extends the AbstractSet class.
It is a set that is ordered according to the natural ordering of its elements or by a Comparator provided at the time of creation.
It uses a balanced tree data structure (typically a Red-Black Tree) to store the elements.
TreeSet provides a total ordering of its elements, which means that the elements are sorted in ascending order.
It's useful for maintaining a sorted set of elements and for performing range searches and other operations that depend on the ordering of the elements.
TreeSet provides additional methods like subSet(E fromElement, E toElement) which returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.
TreeSet is useful when the order of elements is important and also when you need to perform operations like range search, first, last, lower, higher, floor and ceiling.
TreeSet is not thread-safe, so if multiple threads are accessing the same TreeSet object and at least one of them modifies the set, there is a risk of data corruption.
*/