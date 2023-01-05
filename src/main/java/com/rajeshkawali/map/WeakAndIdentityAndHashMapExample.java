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

1) IdentityHashMap uses equality operator "==" for comparing keys and values inside Map while WeakHashMap uses equals method for comparing keys and values.

2) IdentityHashMap also doesn't use hashCode() instead it uses System.identityHashCode(object).

3) IdentityHashMap doesn't require keys to be immutable as it is not relied on equals and hashCode.

4) IdentityHashMap doesn't use equals() its comparatively faster than HashMap for object with expensive equals() and hashCode().
*/