package com.rajeshkawali.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Rajesh_Kawali
 *
 */
public class TreeMapMain {
	public static void main(String[] args) {
		
		// 1.key should not be null and allows any no of null values.
		// 2.duplicates are not allowed.
		// 3.Insertion order are not preserved Instead it stores Objects using some Default Natural sorting order.
		// 4.TreeMap don't have default initial capacity .
		// 5.when we adding value in TreeMap,If that key already exist then old value replaced with new value.
		// 6.If we access key's value which is not available in TreeMap then it return null.
		// 7.It implements NavigableMap, Cloneable and Serializable.It extends AbstractMap class.
		// 8.TreeMap does not use hashing for storing keys. It uses a data structure called "Red-Black tree".
		
		TreeMap<String, String> map = new TreeMap<String, String>();
		System.out.println("Before -Initial capacity of TreeMap :"+map.size());
		System.out.println("get the index TreeMap :"+map.get("Name"));// It will return null because still Objects are not added in TreeMap.
		System.out.println("------------------------------------------------------\n");
		map.put("Name", "old value");
		//System.out.println("--map.get(Name)--------->"+map.get("Name"));
		map.put("Power", "220");
		map.put("Type", "2-wheeler");
		map.put("Price", "85000");
		map.put("Name", "New value");//this key already exist then old value replaced with new value.
		map.put("test", null);
		map.put("null", null); // It treated as a String Object not a null.
		//map.put(null, "Suzuki"); // key not allows null.
		//map.put(null, null); // key not allows null.
		map.put("test2", null);
		//map.replace("test2", null, "rajesh"); // To replace "null" value with "Rajesh" of a given key.
		map.put("test4", null);
		map.put("123", "Testing");
		System.out.println("get the index TreeMap :"+map.get("Name")); // New value
		System.out.println("get the index TreeMap :"+map.get("xyz")); // It returns null because "xyz" key is not available.
		System.out.println("After -Initial capacity of TreeMap :"+map.size());// 9
		System.out.println(map);// {123=Testing, Name=New value, Power=220, Price=85000, Type=2-wheeler, null=null, test=null, test2=null, test4=null}
		System.out.println("------------------------------------------------------\n");
		map.remove("test4");  // Removing "test4" from TreeMap.
		System.out.println("After -Initial capacity of TreeMap :"+map.size()); // 8
		System.out.println(map);// {123=Testing, Name=New value, Power=220, Price=85000, Type=2-wheeler, null=null, test=null, test2=null}
		System.out.println("------------------------------------------------------\n");
		
		// more elegant way, this should be the standard way, recommend!
		System.out.println("\nExample 1...");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + "\t Value : " + entry.getValue());
		}
	}
}
/*
In Java, TreeMap is a class that implements the SortedMap interface and extends the AbstractMap class. 
It is a map that is ordered according to the natural ordering of its keys or by a 
Comparator provided at the time of creation. It uses a balanced tree 
data structure (typically a Red-Black Tree) to store the keys and values.

TreeMap provides a total ordering of its elements, which means that the elements are 
sorted in ascending key order. This makes it useful for maintaining a sorted list of 
key-value pairs and for performing range searches and other operations that depend on the ordering of the elements.

TreeMap also provides additional methods like subMap(K fromKey, K toKey) which returns a 
view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.

It also has a default initial capacity of 16 and a load factor of 0.75 which means that 
when the number of elements in the map exceeds 75% of the initial capacity, the map will
automatically increase its capacity to maintain good performance.

In summary, TreeMap is a class that implements the SortedMap interface, 
it uses a balanced tree data structure (typically a Red-Black Tree) to store the 
keys and values and provides a total ordering of its elements. 
It's useful when the order of insertion or access is important
*/

/*
Key Points:-->
 
TreeMap is a class that implements the SortedMap interface and extends the AbstractMap class.
It is a map that is ordered according to the natural ordering of its keys or by a Comparator provided at the time of creation.
It uses a balanced tree data structure (typically a Red-Black Tree) to store the keys and values.
TreeMap provides a total ordering of its elements, which means that the elements are sorted in ascending key order.
It's useful for maintaining a sorted list of key-value pairs and for performing range searches and other operations that depend on the ordering of the elements.
TreeMap provides additional methods like subMap(K fromKey, K toKey) which returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.
TreeMap is useful when the order of insertion or access is important
It's slower than HashMap and ConcurrentHashMap due to the overhead of maintaining the tree structure.
*/

/*
The TreeMap class in Java provides several methods for interacting with the map. 
Some of the most commonly used methods include:-->

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

containsKey(Object key): Returns true if this map contains a mapping for the specified key.

firstKey(): Returns the first (lowest) key currently in this sorted map.

lastKey(): Returns the last (highest) key currently in this sorted map.

subMap(K fromKey, K toKey): Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.

headMap(K toKey): Returns a view of the portion of this map whose keys are strictly less than toKey.

tailMap(K fromKey): Returns a view of the portion of this map whose keys are greater than or equal to fromKey.

descendingMap(): Returns a reverse order view of the mappings contained in this map.

navigableKeySet(): Returns a navigable set view of the keys contained in this map.
*/