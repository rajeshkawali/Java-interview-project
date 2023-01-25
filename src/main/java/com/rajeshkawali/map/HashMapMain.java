package com.rajeshkawali.map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Rajesh_Kawali
 *
 */
public class HashMapMain {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {

		// 1.It allows only 1 key as a null and any no of null values.
		// 2.duplicate keys are not allowed.
		// 3.Insertion order are not preserved.
		// 4.The default initial capacity (16) and the default load factor (0.75).
		// 5.when we adding value in HashMap,If that key already exist then old value replaced with new value.
		// 6.null key always going to location zero in the bucket.(because null's hashcode is 0 )
		// 7.If we access index value which is not available in HashMap then it return null.
		// 8.With the help of hashcode, it distributes objects in such a way, that both putting the object in hashmap and look up for any object within hashmap can be done very quickly, almost with O(1) time complexity.
		
		//Below Line will create HashMap with initial size 10 and 0.5 load factor  
        //Map<String, String> objMap = new HashMap<String, String>(10, 0.5f); 

		Map<String, String> objMap = new HashMap<String, String>();

		System.out.println("------------------------------------------------------");
		System.out.println("Array Index[0] :"+objMap.get(0));// null
		System.out.println("Array Index[35] :"+objMap.get(35));// null
		System.out.println("------------------------------------------------------\n");
		System.out.println("Before Size of the Map:" + objMap.size());// 0
		
		objMap.put("Name", "Suzuki");
		objMap.put("Power", "220");
		objMap.put("Type", "2-wheeler");
		objMap.put("Price", "85000");
		objMap.put("Name", "Suzuki");
		System.out.println("return value=>"+objMap.put("Name", "Honda"));//return value=>Suzuki
		System.out.println("return value=>"+objMap.get("Name"));//return value=>Honda
		objMap.put("test", null);
		objMap.put(null, null);
		objMap.put(null, "Suzuki");
		objMap.put("test2", null);
		objMap.put("test3", null);
		

		System.out.println("------------------------------------------------------");
		System.out.println("Array Index[Name] :"+objMap.get("test")); // null
		System.out.println("Array Index[35] :"+objMap.get(35)); // null
		System.out.println("Array Index[null] :"+objMap.get(null)); // Suzuki
		System.out.println("------------------------------------------------------\n");
		System.out.println("After Size of the Map:" + objMap.size()); //8
		System.out.println("------------------------------------------------------");
		System.out.println("Elements of the Map:");
		System.out.println(objMap);
		// {null=Suzuki, Type=2-wheeler, test2=null, test3=null, test=null, Price=85000, Power=220, Name=Honda}
		System.out.println("------------------------------------------------------");
		// more elegant way, this should be the standard way, recommend!
		System.out.println("\nExample 1...");
		for (Map.Entry<String, String> entry : objMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			//objMap.put("F","TestError");// java.util.ConcurrentModificationException.
		}
		System.out.println("------------------------------------------------------");
		// Map -> Set -> Iterator -> Map.Entry -> troublesome, not recommend!
		System.out.println("\nExample 2...");
		Iterator<Entry<String, String>> iterator = objMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
			System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
		}
		System.out.println("------------------------------------------------------");
		// Java 8 only, forEach and Lambda. recommend!
		System.out.println("\nExample 3...");
		objMap.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
		System.out.println("------------------------------------------------------");
		// weired, but works anyway, not recommend!
		System.out.println("\nExample 4...");
		for (String key : objMap.keySet()) {
			System.out.println("key: " + key + " value: " + objMap.get(key));
		}
	}
}
/*
In Java, HashMap is a class that implements the Map interface. 
It stores key-value pairs and uses a technique called "hashing" to efficiently map keys to values. 
The basic idea behind hashing is to take the input (i.e., the key), 
perform a mathematical operation on it (the hash function), 
and produce an output (the index in the array) that can be used to 
quickly locate the corresponding value.

A HashMap is not thread-safe, which means that if multiple threads are 
accessing the same HashMap object and at least one of them modifies the map, 
there is a risk of data corruption. Because of this, if multiple threads need 
to access the same map, it's recommended to use java.util.concurrent.ConcurrentHashMap instead.

HashMap also provides some additional methods like putIfAbsent(K key, V value), 
replace(K key, V oldValue, V newValue) and replace(K key, V value) .

It also has a default initial capacity of 16 and a load factor of 0.75 which means 
that when the number of elements in the map exceeds 75% of the initial capacity, 
the map will automatically increase its capacity to maintain good performance.

In summary, HashMap is a powerful and efficient implementation of the Map interface, 
but it is not thread-safe. If you need a thread-safe map, you should use ConcurrentHashMap.
*/

/*
Key points:-->

HashMap is a class that implements the Map interface in Java.

It stores key-value pairs and uses a technique called "hashing" 
to efficiently map keys to values.

It is not thread-safe, so multiple threads accessing the same 
HashMap object may lead to data corruption.

It provides some additional methods like putIfAbsent(K key, V value), 
replace(K key, V oldValue, V newValue) and replace(K key, V value).

It has default initial capacity of 16 and load factor of 0.75, 
when the number of elements in the map exceeds 75% of the initial capacity, 
the map will automatically increase its capacity to maintain good performance.

If you need a thread-safe map, you should use ConcurrentHashMap.
*/


/*
Difference between HashMap and ConcurrentHashMap:-->

In Java is that HashMap is not thread-safe, while ConcurrentHashMap is thread-safe.

HashMap is a regular implementation of the Map interface that stores key-value pairs 
and uses a technique called "hashing" to efficiently map keys to values. It allows 
multiple threads to access the map at the same time, but there is a risk of data 
corruption if two or more threads try to modify the map simultaneously.

ConcurrentHashMap on the other hand is a thread-safe implementation of the Map 
interface that also uses a technique called "hashing" to efficiently map keys to values. 
It uses a technique called "lock striping" to divide the map into segments and locks 
each segment separately. This allows multiple threads to access the map simultaneously 
without the risk of data corruption.

Additionally, ConcurrentHashMap also provides some advanced features like lock-free reads, 
weakly consistent iterators, and support for atomic operations which HashMap doesn't support.

In summary, if you need a map that can be accessed and modified by multiple threads at the same time, 
and you want to ensure that the data will not be corrupted, you should use ConcurrentHashMap. 
If you only need a map that can be accessed by multiple threads, and you don't mind the risk 
of data corruption, you can use HashMap.
*/


/*
The internal working of HashMap in Java can be broken down into the following steps:-->

1.When a new HashMap object is created, an array is allocated to store the key-value pairs. 
The array is called the "bucket array."

2.When a key-value pair is added to the map using the put(K key, V value) method, 
the key is passed through a hash function, which produces an integer value. 
This integer value is used to determine the index in the bucket array 
where the key-value pair should be stored.

3.If the array index is already occupied by another key-value pair, 
the key-value pair is added to a linked list at that index. This is called a "bucket."

4.When a value is retrieved from the map using the get(Object key) method, 
the key is passed through the same hash function, and the resulting integer is 
used to locate the appropriate bucket. If the bucket contains more than one 
key-value pair, the linked list is searched for the key.

5.When a key-value pair is removed from the map using the remove(Object key) method, 
the key is passed through the hash function, and the resulting integer is used to locate 
the appropriate bucket. If the bucket contains more than one key-value pair, 
the linked list is searched for the key.

6.The HashMap uses a technique called "resizing" to increase the capacity of the 
array when the number of elements exceeds a certain threshold (determined by a load factor), 
in order to avoid performance degradation due to hash collisions.

7.HashMap also uses a technique called "rehashing" to redistributes all key-value pairs 
across the bucket array, when the capacity of the array is increased.

8.It also uses a technique called "open addressing" when a key collision occurs, 
where an empty cell in the bucket array is found using a probing sequence 
and the key-value pair is placed in that cell.

9.Additionally, HashMap uses a technique called "compare and swap" to update the 
values in the map, which allows for atomic operations without the need for locks.

10.Because of the multiple steps involve the internal working of HashMap it is not thread-safe, 
if multiple threads are accessing the same HashMap object and at least one of them modifies the map, 
there is a risk of data corruption.
*/


/*
Difference between Hashtable and HashMap and ConcurrentHashMap:-->

Hashtable: is a thread-safe class that provides thread-safety by synchronizing all of its methods, 
which makes it slower than HashMap and ConcurrentHashMap when multiple threads are accessing it. 
It also doesn't allow null keys or values. It is an older class and mostly used in legacy systems.

HashMap: is a more recent class that is not thread-safe, which means that if multiple 
threads are accessing the same HashMap object and at least one of them modifies the map, 
there is a risk of data corruption. It allows one null key and any number of null values. 
It's faster in single-threaded environment.

ConcurrentHashMap: is a thread-safe class that uses a technique called "lock striping" 
to divide the map into segments and locks each segment separately, which allows multiple 
threads to access the map simultaneously without the risk of data corruption. 
It provides some advanced features like lock-free reads, weakly consistent iterators, 
and support for atomic operations. It's recommended to use in new systems when thread-safety is required.

In summary, if you need a map that can be accessed and modified by multiple 
threads at the same time, and you want to ensure that the data will not be corrupted, 
you should use ConcurrentHashMap. If you only need a map that can be accessed by multiple threads, 
and you don't mind the risk of data corruption, you can use HashMap. Hashtable is an older class, 
mostly used in legacy systems, and it's slower than HashMap and `ConcurrentHashMap due to 
the synchronization of its methods. Additionally,Hashtable doesn't allow null keys or values, 
while HashMap and ConcurrentHashMap` allows one null key and any number of null values respectively.

In summary, 
Hashtable is an older class that provides thread-safety by synchronizing 
all of its methods, and it doesn't allow null keys or values. 
While HashMap and ConcurrentHashMap: are more recent, HashMap is not thread-safe and ConcurrentHashMap is thread-safe. 
HashMap allows one null key and any number of null values and it's faster in single-threaded environment, 
ConcurrentHashMap provides some advanced features and it's recommended 
to use in new systems when thread-safety is required.

*/