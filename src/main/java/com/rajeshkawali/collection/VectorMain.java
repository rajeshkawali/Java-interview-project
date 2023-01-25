package com.rajeshkawali.collection;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Rajesh_Kawali
 *
 */
public class VectorMain {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// Vector - 10, ArrayList - 10, Hashtable - 11, HashMap - 16, HashSet - 16 
		
		// 1.It allows multiple null elements.
		// 2.Duplicates elements are allowed.
		// 3.Insertion order are preserved.
		// 4.Vector has default initial capacity 10 and Vector will be re-sized when the 11th element is inserted into Vector,it will Double its size(new capacity=(current capacity * 2)).
		// 5.It allows Heterogeneous Objects. 
		// 6.If we access index value which is not available in Vector then it return ArrayIndexOutOfBoundsException.
		// 7.It implements List, Cloneable, Serializable and RandomAccess (Marker interface).It extends AbstractList class.
		// 8.Vector is better for storing and accessing data.
		// 9.Vector is Synchronized.(only difference between ArrayList and Vector)
		// 10.Underlying data structure is Resizable-array or Growable array (Dynamically grow-able and shrink-able collection of objects).
		// 11.Vector class is that it is thread safety. All methods of Vector class are synchronized so that only one thread can execute them at any given time.
		// 12.Vector class effects the performance of an application as it makes threads to wait for object lock.
		
		Vector v = new Vector();
		System.out.println("Size of Vector at creation: " + v.size());
		System.out.println("Capacity Before adding Objects is: "+v.capacity());
		
		v.addElement("Rajesh");
		v.addElement(null);
		v.addElement(4477);
		v.addElement("12345");
		v.add("Rajesh");
		v.addElement(null);
		v.addElement("Test");
		v.addElement(""); // It will accept as empty value.
		v.addElement(null);
		v.addElement("Koli");
		v.add("Hari");
		v.addElement(54321);
		
		//System.out.println("index of ArrayList at 22 --: " + v.get(22)); // ArrayIndexOutOfBoundsException
		System.out.println("Capacity Before adding Objects is: "+v.capacity());
		System.out.println("Size of Vector after Adding Objects :" + v.size());
		System.out.println(v);
		
		System.out.println("----------------------------------------------------");
        Enumeration en = v.elements();
        while (en.hasMoreElements())
        {
            System.out.println(en.nextElement());
        }
	}
}


/*
In Java, Vector is a class that implements the List interface and extends the AbstractList class. 
It is similar to an ArrayList, but it is synchronized, which means that it is thread-safe. 
It uses an array to store its elements and automatically increases the size of the array as needed. 
It provides constant-time performance for the basic operations (add, get, set, remove) as 
well as other operations like contains, indexOf, lastIndexOf, and clear.

Vector is similar to an ArrayList in terms of functionality, but its methods are synchronized, 
which makes it suitable for use in a multi-threaded environment. However, this synchronization 
comes at the cost of performance, making Vector slightly slower than ArrayList in single-threaded scenarios.

Vector also has an initial capacity of 10 and it increases its size by 100% when 
the number of elements exceeds the capacity.

In summary, Vector is similar to an ArrayList, it uses an array to store its elements 
and automatically increases the size of the array as needed. It provides constant-time 
performance for basic operations, but it is thread-safe, which makes it suitable for use 
in multi-threaded environment. it's slower than ArrayList in single-threaded scenarios.
*/

/*
Vector is a class in Java that implements the List interface and extends the AbstractList class.
It is similar to an ArrayList, but it is synchronized, which means that it is thread-safe.
It uses an array to store its elements and automatically increases the size of the array as needed.
It provides constant-time performance for the basic operations (add, get, set, remove) as well as other operations like contains, indexOf, lastIndexOf, and clear.
Vector is suitable for use in a multi-threaded environment but it is slower than ArrayList in single-threaded scenarios.
It has an initial capacity of 10 and it increases its size by 100% when the number of elements exceeds the capacity.
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