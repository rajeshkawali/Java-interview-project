package com.rajeshkawali.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;


/**
 * @author Rajesh_Kawali
 *
 */
class WeakAndIdentityAndHashMapExample {

	public static void main(String[] args) {

		Key k1 = new Key("Hello");
		Key k2 = new Key("World");
		Key k3 = new Key("Java");
		Key k4 = new Key("Programming");
		Key k5 = new Key("Language");
		
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Using HashMap");
		Map<Key, String> hm = new HashMap<Key, String>();
		hm.put(k1, "Hello");
		hm.put(k2, "World");
		hm.put(k3, "Java");
		hm.put(k4, "Programming");
		hm.put(k5, "Language");
		k1 = null;
		k2 = null;
		k3 = null;
		k4 = null;
		k5 = null;
		System.gc();
		System.out.println("HashMap : " + hm);

		System.out.println("------------------------------------------------------------------------");
		System.out.println("Using IdentityHashMap");
		k1 = new Key("Hello");
		k2 = new Key("World");
		k3 = new Key("Java");
		k4 = new Key("Programming");
		k5 = new Key("Language");
		Map<Key, String> ihm = new IdentityHashMap<Key, String>();
		ihm.put(k1, "Hello");
		ihm.put(k2, "World");
		ihm.put(k3, "Java");
		ihm.put(k4, "Programming");
		ihm.put(k5, "Language");
		k1 = null;
		k2 = null;
		k3 = null;
		k4 = null;
		k5 = null;
		System.gc();
		System.out.println("IdentityHashMap : " + ihm);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Using WeakHashMap");
		k1 = new Key("Hello");
		k2 = new Key("World");
		k3 = new Key("Java");
		k4 = new Key("Programming");
		k5 = new Key("Language");
		Map<Key, String> wm = new WeakHashMap<Key, String>();
		wm.put(k1, "Hello");
		wm.put(k2, "World");
		wm.put(k3, "Java");
		wm.put(k4, "Programming");
		wm.put(k5, "Language");
		k1 = null;
		k2 = null;
		k3 = null; // When we assign null to k1,k2,k3 objects It will eligible for garbage collector.
		//k4 = null;
		k5 = null;
		System.gc();
		System.out.println("WeakHashMap : " + wm);
		System.out.println("------------------------------------------------------------------------");
	}
}

class Key {

	private String key;

	public Key(String key) {
		this.key = key;
	}

	@Override
	public boolean equals(Object obj) {
		return this.key.equals((String) obj);
	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

	@Override
	public String toString() {
		return key;
	}

	public void finalize() {
		System.out.println("Finalize method is called");
	}
}


/*
 * =====================================================
 * HashMap vs WeakHashMap vs IdentityHashMap in Java
 * =====================================================
 *
 * All three classes implement the Map interface,
 * but they differ in key comparison and memory handling.
 *
 * 1. HashMap:
 *
 *    - Uses hashCode() and equals() to compare keys.
 *    - Stores key-value pairs using a hash table.
 *    - Allows one null key and multiple null values.
 *    - Does not maintain insertion order.
 *    - Keys remain strongly referenced by the map.
 *    - Not thread-safe.
 *
 *    USE CASE:
 *    General-purpose key-value storage.
 *
 * 2. WeakHashMap:
 *
 *    - Uses hashCode() and equals() to compare keys.
 *    - Stores keys using weak references.
 *    - Keys can be garbage collected when they
 *      are no longer strongly reachable elsewhere.
 *    - Entries may be removed automatically after GC.
 *    - Allows null keys and values.
 *    - Not thread-safe.
 *
 *    USE CASE:
 *    Storing metadata associated with objects
 *    without preventing their garbage collection.
 *
 * 3. IdentityHashMap:
 *
 *    - Uses == instead of equals() to compare keys.
 *    - Uses System.identityHashCode() for hashing.
 *    - Two keys are equal only if they refer
 *      to the exact same object.
 *    - Allows null keys and values.
 *    - Not thread-safe.
 *
 *    USE CASE:
 *    Object identity tracking, object graph
 *    processing, and reference-based mappings.
 *
 * =====================================================
 * IMPORTANT INTERVIEW POINTS
 * =====================================================
 *
 * 1. HashMap and WeakHashMap use logical equality.
 *
 * 2. IdentityHashMap uses reference equality.
 *
 * 3. WeakHashMap entries may disappear after GC,
 *    even without explicitly calling remove().
 *
 * 4. Garbage collection is not guaranteed
 *    to happen immediately.
 *
 * 5. WeakHashMap values are strongly referenced.
 *    If a value strongly references its own key,
 *    the key may remain reachable and not be collected.
 *
 * 6. IdentityHashMap can store two different
 *    objects even when their equals() returns true.
 *
 * 7. None of these three maps is thread-safe.
 *
 * =====================================================
 * INTERVIEW SUMMARY
 * =====================================================
 *
 * HashMap         -> Uses equals() and hashCode().
 *
 * WeakHashMap     -> Uses weak references for keys.
 *
 * IdentityHashMap -> Uses == for key comparison.
 *
 * =====================================================
 */


/*
WeakHashMap, IdentityHashMap, and HashMap are all implementations of the Map interface in Java, 
but they have different characteristics and use cases:-->

1.HashMap: is the standard implementation of the Map interface in Java. 
It uses the hashCode() and equals() methods of the keys to determine 
equality and store the key-value pairs in a hash table. HashMap is suitable 
for most use cases and is the most commonly used implementation of the Map interface.

2.WeakHashMap: is similar to HashMap, but it uses weak references for the keys. 
This means that if the only reference to a key is held by a WeakHashMap, 
the key can be garbage collected. This makes WeakHashMap useful for caching, 
where you want to automatically remove entries that are no longer being used.

3.IdentityHashMap: is also similar to HashMap, but it uses the == operator to compare keys 
instead of the equals() method. This means that two keys are considered equal only 
if they are the same object, not just equal according to the equals() method. 
This makes IdentityHashMap useful in situations where you need to use object 
identity to compare keys, such as when working with proxy objects.

In summary:-->
HashMap uses hashCode() and equals() methods of the keys to determine equality and store the key-value pairs in a hash table.
WeakHashMap uses weak references for the keys, making the keys eligible for garbage collection if the only reference to a key is held by the WeakHashMap.
IdentityHashMap uses == operator to compare keys, making two keys equal only if they are the same object.

*/