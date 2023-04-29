package com.rajeshkawali.concepts.cache;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public interface Cache<K, V> {

	// Cache interface defining the operations
	void put(K key, V value);

	V get(K key);

	void remove(K key);

	void clear();
}