package com.rajeshkawali.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rajesh_Kawali
 *
 */
public class ConcurrentHashMapMain {

	/*
	The ConcurrentHashMap class in Java is a thread-safe implementation of the HashMap class, 
	which allows multiple threads to access it simultaneously without the risk of data corruption. 
	It achieves thread-safety by using a technique called "lock striping," which divides the map 
	into segments and uses locks to protect each segment separately. This allows for better performance 
	than if a single lock were used to protect the entire map.
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		// 1.It is not allows key as a null and not allows null values.
		// 2.Duplicates are not allowed.
		// 3.Insertion order are not preserved.
		// 4.ConcurrentHashMap have default initial capacity (16) and Load factor (0.75) .
		// 5.when we adding value in ConcurrentHashMap,If that key already exist then old value replaced with new value.
		// 6.If we access key's value which is not available in ConcurrentHashMap then it return null.
		// 7.It implements ConcurrentMap and Serializable.It extends AbstractMap class.
		// 8.ConcurrentHashMap uses hashing for storing keys.
		// 9.ConcurrentHashMap is Synchronized.
		// 10.ConcurrentHashMap uses the Segment.ConcurrentHashMap added Array of HashMap's called Segment. 
		// 11.default Segments array size is 16, So maximum 16 threads can simultaneously put data in map.
		// 12.concurrencyLevel(default 16)- the estimated number of threads to allow concurrently to update the map. 
		// 13.ConcurrentHashMap allows Heterogeneous objects.
		
		
		ConcurrentHashMap map = new ConcurrentHashMap();
		System.out.println("Initial capacity of ConcurrentHashMap :"+map.size()); // zero
		System.out.println("get the index of ConcurrentHashMap :"+map.get("Name"));// It will return null because still Objects are not added in ConcurrentHashMap.
		map.put("B", "Raavan1");
		map.put("e", 123);
		map.put("Name","Rajesh");
		map.put("3", "Trimax");
		map.put("D", 123.12);
		map.put("B", "Raavan2"); // key (B) already exist then it replace with Raavan1 to Raavan2.
		map.put("A", "85000");
		map.put("C", 123);
		//map.put("F", null); // java.lang.NullPointerException
		//map.put(null, "testNull"); // java.lang.NullPointerException
		
		System.out.println("Initial capacity of ConcurrentHashMap :"+map.size()); // 7
		System.out.println("get the index ConcurrentHashMap :"+map.get("Name"));// It will return Rajesh.
		System.out.println(map); //{A=85000, B=Raavan2, 3=Trimax, C=123, D=123.12, e=123, Name=Rajesh}
		System.out.println("----------------------------------------------");
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry= (Entry) it.next();
			System.out.println("key :"+entry.getKey()+"\t\t value :"+entry.getValue());
			//map.put("F","TestError"); // There is no ConcurrentModificationException but Exception in HashMap.(fail-safe)
		}
		System.out.println("----------------------------------------------");

	}

}
/*
Difference between ConcurrentHashMap and HashMap in java:-->

The main difference between ConcurrentHashMap and HashMap in Java is that ConcurrentHashMap is thread-safe, while HashMap is not.

HashMap is a regular implementation of the Map interface, which allows multiple threads to access the map at the same time, 
but there is a risk of data corruption if two or more threads try to modify the map simultaneously.

ConcurrentHashMap, on the other hand, is a thread-safe implementation of the Map interface, 
which uses a technique called "lock striping" to divide the map into segments and locks each segment separately. 
This allows multiple threads to access the map simultaneously without the risk of data corruption.

Additionally, ConcurrentHashMap also provides some advanced features like lock-free reads, 
weakly consistent iterators, and support for atomic operations which HashMap doesn't support.

In summary, if you need a map that can be accessed and modified by multiple threads at the same time, 
and you want to ensure that the data will not be corrupted, you should use ConcurrentHashMap. 
If you only need a map that can be accessed by multiple threads, and you don't mind the 
risk of data corruption, you can use HashMap.
*/


/*
1.ConcurrentHashMap is a thread-safe implementation of HashMap in Java
2.Allows multiple threads to access the map simultaneously without data corruption
3.Uses a technique called "lock striping" to divide the map into segments and locks each segment separately
4.This improves performance compared to using a single lock to protect the entire map
5.ConcurrentHashMap also support some advanced features like lock-free reads and weakly consistent iterators.
*/


/*
The internal working of ConcurrentHashMap in Java can be broken down into the following steps:-->

The map is divided into a fixed number of segments, each with its own lock. The number of segments is determined by the initial capacity of the map and a load factor.

When a thread wants to perform an operation on the map (e.g., put, get, remove), it first acquires the lock for the segment that the key maps to. This is done using a technique called lock striping, where a hash function is used to determine the segment that the key belongs to.

Once the thread has acquired the lock for the segment, it can perform the operation on the map. For example, if the operation is a put, the thread will add the key-value pair to the segment's hash table.

After the operation is complete, the thread releases the lock for the segment.

This allows other threads to acquire the lock for the same segment and perform their own operations.

The use of multiple locks allows for better performance than if a single lock were used to protect the entire map, since multiple threads can access different segments of the map simultaneously.

ConcurrentHashMap also support some advanced features like lock-free reads and weakly consistent iterators.

ConcurrentHashMap also uses a technique called "compare and swap" to update the values in the map, which allows for atomic operations without the need for locks.

Additionally, ConcurrentHashMap uses a technique called "resizing" to increase the capacity of the map when the number of elements exceeds the load factor, in order to avoid performance degradation due to hash collisions.
*/


/*
The ConcurrentHashMap class in Java provides several methods for interacting with the map. 
Some of the most commonly used methods include:-->

put(K key, V value): Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced by the specified value.

get(Object key): Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

remove(Object key): Removes the mapping for a key from this map if it is present.

putIfAbsent(K key, V value): Associates the specified value with the specified key in this map only if it is not already associated with a value.

replace(K key, V oldValue, V newValue): Replaces the entry for a key only if currently mapped to a given value.

replace(K key, V value): Replaces the entry for a key only if it is present.

clear(): Removes all of the mappings from this map.

size(): Returns the number of key-value mappings in this map.

isEmpty(): Returns true if this map contains no key-value mappings.

keySet(): Returns a Set view of the keys contained in this map.

values(): Returns a Collection view of the values contained in this map.

entrySet(): Returns a Set view of the mappings contained in this map.

containsKey(Object key): Returns true if this map contains a mapping for the specified key.

containsValue(Object value): Returns true if this map maps one or more keys to the specified value.

*/
