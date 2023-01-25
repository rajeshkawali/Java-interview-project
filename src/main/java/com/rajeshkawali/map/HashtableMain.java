package com.rajeshkawali.map;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Rajesh_Kawali
 *
 */
public class HashtableMain {

	// 1.It is not allowed null ( Both Key and Value ).
	// 2.duplicates key are not allowed.
	// 3.Insertion order are not preserved.
	// 4.Hashtable has default initial capacity 11 (11 is prime number it is easy to generate hash value) and load factor (0.75).
	// 5.when we adding value in Hashtable,If that key already exist then old value replaced with new value.
	// 6.If we access index value which is not available in Hashtable then it return null.
	// 7.It implements Map, Cloneable and Serializable.It extends Dictionary Abstract class.

	//Hashtable  is quite similar to HashMap except few differences.
    //1.Hashtable methods are synchronized while HashMap methods are not synchronized.
    //2.Hashtable is slower whereas HashMap is faster because it does not have to deal with synchronization.
    //3.Hashtable is a fail-safe collection while HashMap is fail-fast.
    //4.Hashtable does not allow any null key or null value whereas HashMap allows one null key and many null values.

	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		System.out.println("Initial capacity of Hashtable :"+ht.size()); // return zero.
		System.out.println("Get the index of Hashtable :"+ht.get("Name"));// It will return null because still Objects are not added in Hashtable.

		ht.put("124", "Rajesh");
		ht.put("Name", "Rajesh");
		//System.out.println("--ht.get(Name)--------->"+ht.get("Name"));
		ht.put("243", "12345");
		ht.put("Name", "RajeshKoli");
		//ht.put(null, null); // null not allowed. we will get NullPointerException.
		//ht.put("456", null); // null not allowed. we will get NullPointerException.
		//ht.put(null, "test"); // null not allowed. we will get NullPointerException.
		ht.put("n15", "Keshav");
		ht.put("498", "Mahesh");
		//System.out.println("\n value=====>"+ht.put("498", "Mahesh333")); // value=====>Mahesh
		System.out.println("Get the index of Hashtable :"+ht.get("notkey")); // It returns null because "notkey" key is not available.
		System.out.println("----------------------------------------------");
		System.out.println("\nExample 1...");
		for(Map.Entry<String, String> entry: ht.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key :"+ key + "\t Value :"+value);
		}
		System.out.println("------------------------------------------------------");
		System.out.println("\nExample 2...");
		for (String key : ht.keySet()) {
			System.out.println("key :" + key + "\t value :" +ht.get(key));
		}
		System.out.println("------------------------------------------------------");
		String s1 ="a";
		Hashtable<String, Integer> ht2 = new Hashtable<String, Integer>();
		ht2.put(s1, 1);
		ht2.put("b", 2);
		ht2.put("c", 3);
		ht2.put("d", 4);
		// We have changed s1 value to upper case but we are getting correct value because String is immutable.
		// If you make any changes with String literal, it will be creating new object in Heap.
		System.out.println("Changed to upper case s1 = "+s1.toUpperCase());
		//Object obj = ht2.get("A"); // java.lang.NullPointerException
		Object obj = ht2.get("a");
		System.out.println(obj.toString());
		
	}

}
/*
In Java, Hashtable is a class that is similar to the HashMap class, but it is thread-safe. It also stores key-value pairs and uses a technique called "hashing" to efficiently map keys to values. However, unlike HashMap, Hashtable uses synchronization to ensure that only one thread can access the table at a time, which makes it thread-safe.

Hashtable was a legacy class in Java before the introduction of ConcurrentHashMap and HashMap, now it's mostly used in legacy systems.

The methods of Hashtable are similar to HashMap with the difference of being thread-safe and the methods are synchronized, which can make it slower than the ConcurrentHashMap when multiple threads are accessing it.

Additionally, Hashtable doesn't allow null keys or values, while HashMap allows one null key and any number of null values.

In summary, Hashtable is an older class that provides thread-safety by synchronizing all of its methods. While it is thread-safe and it's not recommended to use it in new systems, it can be used in cases when the null keys or values are not allowed and thread-safety is required.
*/


/*
The main difference between Hashtable and HashMap:-->

In Java is that Hashtable is thread-safe, while HashMap is not.

Hashtable is an older class that provides thread-safety by synchronizing all of its methods, which makes it slower than HashMap when multiple threads are accessing it. It also doesn't allow null keys or values.

HashMap is a more recent class that is not thread-safe, which means that if multiple threads are accessing the same HashMap object and at least one of them modifies the map, there is a risk of data corruption. It allows one null key and any number of null values.

Another difference is that the methods of Hashtable are synchronized, which can make it slower than HashMap when multiple threads are accessing it. On the other hand, HashMap is unsynchronized, which can make it faster than Hashtable in the single-threaded environment.

Also, HashMap has been introduced in JDK 1.2, while Hashtable is present since JDK 1.0.

In summary, Hashtable is an older class that provides thread-safety by synchronizing all of its methods, and it doesn't allow null keys or values. While HashMap is more recent, not thread-safe, allows one null key and any number of null values and it's faster in single-threaded environment. It's recommended to use HashMap in new systems, unless thread-safety is required, in that case ConcurrentHashMap or synchronizedMap should be used.
*/


/*
The Hashtable class in Java provides several methods for interacting with the table. 
Some of the most commonly used methods include:-->

put(Object key, Object value): Associates the specified value with the specified key in this hashtable. If the key is already in the hashtable, the old value is replaced by the specified value.

get(Object key): Returns the value to which the specified key is mapped in this hashtable, or null if the key is not mapped to any value.

remove(Object key): Removes the key (and its corresponding value) from this hashtable.

clear(): Clears this hashtable so that it contains no keys.

size(): Returns the number of keys in this hashtable.

isEmpty(): Tests if this hashtable maps no keys to values.

keys(): Returns an enumeration of the keys in this hashtable.

elements(): Returns an enumeration of the values in this hashtable.

contains(Object value): Tests if some key maps into the specified value in this hashtable.

containsKey(Object key): Tests if the specified object is a key in this hashtable.

toString(): Returns a string representation of this Hashtable object in the form of a set of entries, enclosed in braces and separated by the ASCII characters ", " (comma and space).

All the methods are thread-safe and synchronized, which makes it slower than the ConcurrentHashMap when multiple threads are accessing it. Additionally, Hashtable doesn't allow null keys or values, while HashMap allows one null key and any number of null values.
*/

