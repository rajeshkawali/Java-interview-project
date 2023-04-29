package com.rajeshkawali.concepts.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
class CustomCache<K, V> implements Cache<K, V> {
	
	// Create simple custom cache class using HashMap or LinkedHashMap
	private Map<K, V> cache;

	public CustomCache() {
		this.cache = new HashMap<>();
		//this.cache = new ConcurrentHashMap<>(); //works in a multi-threaded environment
	}

	@Override
	public void put(K key, V value) {
		cache.put(key, value);
	}

	@Override
	public V get(K key) {
		return cache.get(key);
	}

	@Override
	public void remove(K key) {
		cache.remove(key);
	}

	@Override
	public void clear() {
		cache.clear();
	}
}

public class CustomCacheMain {
	public static void main(String[] args) {
		
		Cache<String, Integer> cache = new CustomCache<>();

		cache.put("key1", 10);
		cache.put("key2", 20);

		System.out.println(cache.get("key1")); // Output: 10

		cache.remove("key2");

		cache.clear();
	}
}
/*
Define the Cache Interface: Start by defining the contract or interface for your cache class. 
This interface should include methods for adding, retrieving, and removing items 

Create a Cache Implementation: Implement the cache interface with your custom cache logic. 
You can choose a suitable data structure, such as a HashMap or LinkedHashMap, to store the cache entries.

Add Additional Functionality: Depending on your requirements, you can enhance the cache 
implementation with additional features. For example, you might want to implement eviction 
policies based on cache size, time-to-live (TTL), or implement cache statistics tracking.

Usage of Custom Cache: Once your custom cache class is implemented, you can use it in your 
application by instantiating an instance of the cache and utilizing its methods. 

*/