package com.rajeshkawali.concepts.cache;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Rajesh_Kawali
 *
 */

/**
 * TimeAwareLRUCache is a thread-safe in-memory cache with:
 * - Time-to-live (TTL) expiration
 * - Least Recently Used (LRU) eviction strategy
 */
public class TimeAwareLRUCache<K, V> {

    // Maximum number of active cache entries
    private final int capacity;

    // Time-to-live for each cache entry (in milliseconds)
    private final long ttlInMillis;

    // Lock to ensure thread safety
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * Underlying storage using LinkedHashMap to maintain access order.
     * The `true` flag enables access-order (for LRU eviction).
     */
    private final LinkedHashMap<K, TimedValue<V>> storage;

    /**
     * Constructor for TimeAwareLRUCache
     *
     * @param capacity     Maximum number of entries in the cache
     * @param ttlInSeconds TTL (Time-to-live) in seconds for each entry
     */
    @SuppressWarnings("serial")
	public TimeAwareLRUCache(int capacity, long ttlInSeconds) {
        this.capacity = capacity;
        this.ttlInMillis = ttlInSeconds * 1000;

        // LinkedHashMap with access-order for LRU
        this.storage = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, TimedValue<V>> eldest) {
                // Automatically remove least recently used item if capacity exceeded
                return size() > TimeAwareLRUCache.this.capacity;
            }
        };
    }

    /**
     * Stores a key-value pair in the cache.
     * Replaces existing value if key already present.
     */
    public void save(K key, V value) {
        lock.lock();
        try {
            storage.put(key, new TimedValue<>(value));
        } finally {
            lock.unlock();
        }
    }

    /**
     * Retrieves a value from the cache if present and not expired.
     * Returns null otherwise.
     */
    public V retrieve(K key) {
        lock.lock();
        try {
            TimedValue<V> timedValue = storage.get(key);
            if (timedValue == null || timedValue.hasExpired(ttlInMillis)) {
                storage.remove(key); // Clean up expired entry
                return null;
            }
            return timedValue.value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Deletes a specific key from the cache, if present.
     */
    public void discard(K key) {
        lock.lock();
        try {
            storage.remove(key);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Clears all entries from the cache.
     */
    public void flush() {
        lock.lock();
        try {
            storage.clear();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns the number of currently valid (non-expired) entries in the cache.
     */
    public int activeSize() {
        lock.lock();
        try {
            return (int) storage.entrySet().stream()
                .filter(entry -> !entry.getValue().hasExpired(ttlInMillis))
                .count();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Represents a value stored in the cache along with its insertion timestamp.
     */
    private static class TimedValue<V> {
        final V value;
        final long timestamp;

        TimedValue(V value) {
            this.value = value;
            this.timestamp = System.currentTimeMillis();
        }

        /**
         * Checks if the entry has expired based on TTL.
         */
        boolean hasExpired(long ttlInMillis) {
            return System.currentTimeMillis() - timestamp > ttlInMillis;
        }
    }
}
