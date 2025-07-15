package com.rajeshkawali.concepts.cache;

import java.util.HashMap;
import java.util.Map;

//Create simple custom cache class with creating Entry class.
/**
 * 
 * @author Rajesh_Kawali
 *
 */
class CustomCacheEntry<K, V> {

	// CustomCacheEntry class implementing the Cache interface
	private final int capacity;
	private final Map<K, CacheEntry<K, V>> cache;

	public CustomCacheEntry(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>(capacity);
	}

	// Add an entry to the cache
	public void put(K key, V value) {

		CacheEntry<K, V> entry = cache.get(key);
		if (entry != null) {
			entry.setValue(value);
		} else {
			if (cache.size() >= capacity) {
				evictLeastRecentlyUsedEntry();
			}
			entry = new CacheEntry<>(key, value);
			cache.put(key, entry);
		}
	}

	// Retrieve the value for a given key from the cache
	public V get(K key) {
		CacheEntry<K, V> entry = cache.get(key);
		if (entry != null) {
			return entry.getValue();
		}
		return null;
	}

	// Remove an entry from the cache based on the key
	public void remove(K key) {
		cache.remove(key);
	}

	// Clear the entire cache
	public void clear() {
		cache.clear();
	}

	// Evict the least recently used entry from the cache
	private void evictLeastRecentlyUsedEntry() {
		K leastRecentlyUsedKey = cache.keySet().iterator().next();
		cache.remove(leastRecentlyUsedKey);
	}

	// CacheEntry class representing an entry in the cache
	private static class CacheEntry<K, V> {

		@SuppressWarnings("unused")
		private final K key;
		private V value;

		public CacheEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}
}

// Example usage
public class CustomCacheMain2 {

	public static void main(String[] args) {
		// Create an instance of CustomCache
		CustomCacheEntry<Integer, String> cache = new CustomCacheEntry<>(3);

		// Add entries to the cache
		cache.put(1, "Value 1");
		cache.put(2, "Value 2");
		cache.put(3, "Value 3");

		// Retrieve entries from the cache
		System.out.println(cache.get(1)); // Output: Value 1
		System.out.println(cache.get(2)); // Output: Value 2
		System.out.println(cache.get(3)); // Output: Value 3
		System.out.println("-----------------------------------------");
		// Add a new entry, which triggers eviction of the least recently used entry
		cache.put(4, "Value 4");

		// Retrieve entries after eviction
		System.out.println(cache.get(1)); // Output: null (evicted)
		System.out.println(cache.get(2)); // Output: Value 2
		System.out.println(cache.get(3)); // Output: Value 3
		System.out.println(cache.get(4)); // Output: Value 4
		System.out.println("-----------------------------------------");
		// Remove an entry from the cache
		cache.remove(3);

		// Retrieve entries after removal
		System.out.println(cache.get(3)); // Output: null (removed)
		System.out.println("-----------------------------------------");
	}
}
