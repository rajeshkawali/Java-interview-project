package com.rajeshkawali.map;

import java.util.HashMap;
import java.util.IdentityHashMap;

//1. IdentityHashMap uses equality operator == for comparing keys and values while HashMap uses equals method for comparing keys and values inside Map.
//2. Since IdentityHashMap doesn't use equals() its comparatively faster than HashMap for object with expensive equals().
//3. IdentityHashMap doesn't require keys to be immutable as it is not relied on equals().
//4. IdentityHashMap implements Map, Serializable and Clonable interfaces and extends AbstractMap class.

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class IdentityHashMapMain {
	/*
	IdentityHashMap is a hash map that is similar to java.util.HashMap, but with
	one important difference: it uses reference-equality in place of
	object-equality when comparing keys (and values). This means that two keys k1
	and k2 are considered equal if and only if (k1==k2) is true. By contrast, in
	a HashMap, two keys k1 and k2 are considered equal if and only if
	k1.equals(k2) is true.
	*/
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();
		IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();

		String key1 = new String("key");
		String key2 = new String("key");

		hashMap.put(key1, "value1");
		hashMap.put(key2, "value2");
		identityHashMap.put(key1, "value1");
		identityHashMap.put(key2, "value2");

		// in a HashMap, key1 and key2 are considered equal because
		// key1.equals(key2) is true, so the second put overrides the first
		System.out.println("hashMap size: "+hashMap.size()); // prints "1"
		System.out.println(hashMap.get(key1)); // prints "value2"
		System.out.println(hashMap.get(key2)); // prints "value2"

		// in an IdentityHashMap, key1 and key2 are considered different
		// because (key1==key2) is false, so both key-value pairs are added
		System.out.println("identityHashMap size: "+identityHashMap.size()); // prints "2"
		System.out.println(identityHashMap.get(key1)); // prints "value1"
		System.out.println(identityHashMap.get(key2)); // prints "value2"
	}
}

/*
1) IdentityHashMap uses equality operator "==" for comparing keys and values inside Map while WeakHashMap uses equals method for comparing keys and values.

2) IdentityHashMap also doesn't use hashCode() instead it uses System.identityHashCode(object).

3) IdentityHashMap doesn't require keys to be immutable as it is not relied on equals and hashCode.

4) IdentityHashMap doesn't use equals() its comparatively faster than HashMap for object with expensive equals() and hashCode().
*/


/*
1) IdentityHashMap uses equality operator "==" for comparing keys and values
inside Map while WeakHashMap uses equals method for comparing keys and
values.

2) IdentityHashMap also doesn't use hashCode() instead it uses
System.identityHashCode(object).

3) IdentityHashMap doesn't require keys to be immutable as it is not relied
on equals and hashCode.

4) IdentityHashMap doesn't use equals() its comparatively faster than HashMap
for object with expensive equals() and hashCode().

5) IdentityHashMap is useful when you need to use reference-equality instead of object-equality to compare keys (or values).

6) IdentityHashMap is not thread-safe. If multiple threads will be accessing an IdentityHashMap, 
you should use Collections.synchronizedMap(IdentityHashMap) to wrap the map in a thread-safe wrapper.

7) IdentityHashMap is generally slower than HashMap, because it uses reference-equality comparisons 
instead of object-equality comparisons.
*/

