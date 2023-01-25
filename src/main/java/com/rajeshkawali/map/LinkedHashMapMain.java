package com.rajeshkawali.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Rajesh_Kawali
 *
 */
public class LinkedHashMapMain {

	public static void main(String[] args) {

		// 1.It allows only 1 key as a null and any no.of values as a null.
		// 2.duplicates are not allowed.
		// 3.Insertion order are preserved.
		// 4.The default initial capacity (16) and the default load factor (0.75).
		// 5.Only one difference is, The LinkedHashMap insertion Order are Preserved but not HashMap.
		// 6.when we adding value in LinkedHashMap,If that key already exist then old value replaced with new value.
		// 7.null key always going to location zero.
		// 8.If we access index value which is not available in LinkedHashMap then it return null.

		Map<String, String> map = new LinkedHashMap<String, String>();

		System.out.println("Before Put :Size of the Map:" + map.size()); // zero

		map.put("Name", "Suzuki");
		map.put("Power", "222"); 
		map.put("Power", "220"); // duplicates not allowed.(222 is replaced by 220)
		map.put("Type", "2-wheeler");
		map.put("Price", "85000");
		map.put("Name", "Suzuki");
		map.put("test", null);
		map.put(null, "Suzuki");
		map.put("test2", null);
		map.put("test3", null);
		map.put(null, null);

		System.out.println("After Put :Size of the Map:" + map.size()); // 8
		System.out.println("------------------------------------------------------");
		System.out.println(map); //{Name=Suzuki, Power=220, Type=2-wheeler, Price=85000, test=null, null=null, test2=null, test3=null}
		System.out.println("------------------------------------------------------");
		
		// more elegant way, this should be the standard way, recommend!
		System.out.println("\nExample 1...");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + "\t Value : " + entry.getValue());
		} 
		System.out.println("------------------------------------------------------");
		// Java 8 only, forEach and Lambda. recommend!
		System.out.println("\nExample 2...");
		map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
		System.out.println("------------------------------------------------------");
		// weired, but works anyway, not recommend!
		System.out.println("\nExample 3...");
		System.out.println("------------------------------------------------------");
		for (String key : map.keySet()) {
			System.out.println("key: " + key + " value: " + map.get(key));
		}
		System.out.println("------------------------------------------------------");
		System.out.println("\nExample 4...");
		@SuppressWarnings("rawtypes")
		Iterator itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pair = (Map.Entry) itr.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
			// System.out.println(pair);
			itr.remove(); // avoids a ConcurrentModificationException
		}
		System.out.println("------------------------------------------------------");
	}
}

/*
In Java, LinkedHashMap is a class that extends the HashMap class. 
It is a combination of a HashMap and a doubly-linked list, 
which maintains the order of the elements in the map. 
This means that the elements in a LinkedHashMap are ordered according 
to the order in which they were inserted, or according to the order of 
last access for a LinkedHashMap that is constructed with the accessOrder parameter set to true.

It is similar to HashMap in terms of the basic functionality, 
but it also provides an additional feature of maintaining the order of the elements.

LinkedHashMap also provides some additional methods like 
removeEldestEntry(Map.Entry<K,V> eldest) which is called after a new entry has 
been added to the map and it can be used to control the size of the map.

It also has a default initial capacity of 16 and a load factor of 0.75 which 
means that when the number of elements in the map exceeds 75% of the initial capacity, 
the map will automatically increase its capacity to maintain good performance.

In summary, LinkedHashMap is a combination of a HashMap and a doubly-linked list, 
which maintains the order of the elements in the map and it also provides additional 
methods like removeEldestEntry(Map.Entry<K,V> eldest) to control the size of the map. 
It's useful when the order of insertion or access is important.
*/


/*
The internal working of LinkedHashMap in Java can be broken down into the following steps:-->

When a new LinkedHashMap object is created, an array is allocated to store the key-value pairs, similar to HashMap. The array is called the "bucket array."

In addition to the bucket array, LinkedHashMap also uses a doubly-linked list to keep track of the order of the elements. When a new key-value pair is added to the map using the put(K key, V value) method, it is added to the linked list in addition to the bucket array.

The order of the elements in the linked list is determined by the order in which they were added to the map, or by the order of last access if the LinkedHashMap is constructed with the accessOrder parameter set to true.

When a value is retrieved from the map using the get(Object key) method, the key is passed through the same hash function used by HashMap, and the resulting integer is used to locate the appropriate bucket in the array. If the bucket contains more than one key-value pair, the linked list is searched for the key.

When a key-value pair is removed from the map using the remove(Object key) method, the key is passed through the hash function and the resulting integer is used to locate the appropriate bucket. If the bucket contains more than one key-value pair, the linked list is searched for the key.

The LinkedHashMap uses a technique called "resizing" to increase the capacity of the array when the number of elements exceeds a certain threshold (determined by a load factor), in order to avoid performance degradation due to hash collisions.

LinkedHashMap also uses a technique called "rehashing" to redistributes all key-value pairs across the bucket array, when the capacity of the array is increased.

Additionally, LinkedHashMap uses a technique called "open addressing" when a key collision occurs, where an empty cell in the bucket array is found using a probing sequence and the key-value pair is placed in that cell.

LinkedHashMap also provides a method called removeEldestEntry(Map.Entry<K,V> eldest) which is called after a new entry has been added to the map and it can be used to control the size of the map.

Because of the additional feature of doubly-linked list, `LinkedHashMaphas a slightly higher overhead compared toHashMap` but it can be useful in cases where maintaining the order of insertion or access is important.

In summary, the internal working of LinkedHashMap is similar to HashMap, but it also uses a doubly-linked list to maintain the order of the elements. Additionally, it uses the same techniques of "resizing", "rehashing" and "open addressing" as HashMap to handle collisions and maintain good performance. The removeEldestEntry(Map.Entry<K,V> eldest) method can be used to control the size of the map, and it can be useful in cases where maintaining the order of insertion or access is important.
*/



/*
The LinkedHashMap class in Java provides several methods for interacting with the map. Some of the most commonly used methods include:

put(K key, V value): Associates the specified value with the specified key in this map. If the key is already in the map, the old value is replaced by the specified value.

get(Object key): Returns the value to which the specified key is mapped in this map, or null if the key is not mapped to any value.

remove(Object key): Removes the key (and its corresponding value) from this map.

clear(): Removes all of the mappings from this map.

size(): Returns the number of key-value mappings in this map.

isEmpty(): Returns true if this map contains no key-value mappings.

keySet(): Returns a set view of the keys contained in this map.

values(): Returns a collection view of the values contained in this map.

entrySet(): Returns a set view of the mappings contained in this map.

putAll(Map<? extends K,? extends V> m): Copies all of the mappings from the specified map to this map.

containsKey(Object key): Tests if the specified object is a key in this LinkedHashMap.
*/