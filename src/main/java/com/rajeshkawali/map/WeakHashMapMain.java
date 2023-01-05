package com.rajeshkawali.map;

import java.util.WeakHashMap;

/**
 * @author Rajesh_Kawali
 *
 */
public class WeakHashMapMain {

	/*
	 WeakHashMap is a hash map that stores key-value pairs and uses weak
	 references for the keys. This means that the key-value pair will be
	 automatically removed from the map when the key is no longer in use by any
	 other part of the program.
	 */
	public static void main(String[] args) {

		Key k1 = new Key("Hello");
		Key k2 = new Key("World");
		Key k3 = new Key("Java");
		Key k4 = new Key("Programming");
		Key k5 = new Key("Language");

		WeakHashMap<Key, String> wMap = new WeakHashMap<>();

		wMap.put(k1, "Hello");
		wMap.put(k2, "World");
		wMap.put(k3, "Java");
		wMap.put(k4, "Programming");
		wMap.put(k5, "Language");
		System.out.println("Before gc() called - WeakHashMap : " + wMap);
		k1 = null; // key is no longer in referenced 
		k2 = null; // key is no longer in referenced 
		//k3 = null; // key is in referenced 
		//k4 = null; // key is in referenced 
		k5 = null; // key is no longer in referenced 
		System.gc();
		System.out.println("After gc() called - WeakHashMap : " + wMap);

		System.out.println("------------------------------------------------------");
		wMap.forEach((k, v) -> System.out.println("Key : " + k + " ,Value : " + v));
		System.out.println("------------------------------------------------------");

	}

}
/*
 1.WeakHashMap stores key-value pairs and uses weak references for the keys.
 
 2.When a key is no longer in use by any other part of the program, the
 key-value pair is automatically removed from the map.
  
 3.WeakHashMap is useful
 for maintaining a cache of values that should be automatically removed when
 they are no longer needed. 
 
 4.WeakHashMap is not thread-safe. If multiple
 threads will be accessing a WeakHashMap, you should use
 Collections.synchronizedMap(WeakHashMap) to wrap the map in a thread-safe
 wrapper.
 
 WeakHashMap is exactly same as HashMap except the following difference. In
 case of HashMap an Object is not eligible for garbage collection if it is
 associated with HashMap even though it doesn't have any external references.
 i,e HashMap dominates garbage collector. But in case of WeakHashMap , if an
 Object is not having any external references then it is always eligible for
 garbage collection even though it is associated with weakHashMap. ie garbage
 collector dominates WeakHashMap
 
 An entry in a WeakHashMap will automatically be removed when its key is no
 longer referenced.
 */

/*
put(K key, V value): This method associates the specified value with the specified key in this map.
get(Object key): This method returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
containsKey(Object key): This method returns true if this map contains a mapping for the specified key.
remove(Object key): This method removes the mapping for the specified key from this map if present.
clear(): This method removes all of the mappings from this map.
*/