package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Custom HashMap implementation
public class MyHashMap<K, V> {

	// Default capacity of the hash map
    private static final int DEFAULT_CAPACITY = 16;
    
    // Node class to store key-value pairs
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = DEFAULT_CAPACITY;  // Initial capacity
    private Node<K, V>[] buckets;
    private int size = 0;       // Track size of map

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        // Create an array of Node references
        buckets = new Node[capacity];
    }

    // Hash function to convert key to index
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Add or update key-value pair in the hashmap
    public void put(K key, V value) {
        // Compute the bucket index for the given key using the hash function
        int index = getBucketIndex(key); // e.g., index 3
        // Start traversing the linked list at the computed bucket index
        Node<K, V> head = buckets[index];
        // Traverse the linked list to check if the key already exists
        while (head != null) {
            // If the current node's key matches the given key
            if (head.key.equals(key)) {
                // Update the value for the existing key
                head.value = value;
                // Exit since update is complete
                return;
            }
            // Move to the next node in the list
            head = head.next;
        }
        // Key not found, so create a new node to insert at the bucket's head
        Node<K, V> newNode = new Node<>(key, value); // e.g., newNode("God", 100)
        // Set the new node's next to the current head of the bucket's list
        newNode.next = buckets[index];               // points to existing nodes or null if empty
        // Update the bucket to point to the new node (insert at beginning)
        buckets[index] = newNode;                     // e.g., insert at index 3
        // Increment size as new key-value pair is added
        size++;
    }

    // Get value for a given key
    public V get(K key) {
        // Compute the bucket index for the key using the hash function
        int index = getBucketIndex(key);
        // Start at the head of the linked list at the computed bucket index
        Node<K, V> head = buckets[index];
        // Traverse the linked list to find the key
        while (head != null) {
            // If the current node's key matches the requested key
            if (head.key.equals(key)) {
                // Return the corresponding value
                return head.value;
            }
            // Move to the next node in the list
            head = head.next;
        }
        // If key is not found in the linked list, return null
        return null;
    }

    // Remove key-value pair from the hashmap
    public void remove(K key) {
        // Compute the index for the given key using the hash function
        int index = getBucketIndex(key);
        // Start traversing the linked list at the computed bucket index
        Node<K, V> head = buckets[index];
        // 'prev' will keep track of the previous node while traversing
        Node<K, V> prev = null;
        // Traverse the linked list until the end or until the key is found
        while (head != null) {
            // Check if the current node's key matches the key to remove
            if (head.key.equals(key)) {
                // If the node to remove is the first node in the list
                if (prev == null) {
                    // Update the bucket to point to the next node, effectively removing the head node
                    buckets[index] = head.next;
                } else {
                    // If the node to remove is not the first,
                    // link the previous node to the next node, bypassing the removed node
                    prev.next = head.next;
                }
                // Decrement the size as we have successfully removed a key-value pair
                size--;
                // Exit the method as removal is done
                return;
            }
            // Move 'prev' and 'head' forward in the list to continue searching
            prev = head;
            head = head.next;
        }
        // If key not found, method ends here without making any changes
    }

    // Check if a key exists
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Return number of entries in map
    public int size() {
        return size;
    }
    
    // isEmpty method
    public boolean isEmpty() {
        return size == 0;
    }

    // clear method
    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    // Print all key-value pairs
    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> head = buckets[i];
            while (head != null) {
                System.out.println(head.key + " => " + head.value);
                head = head.next;
            }
        }
    }

    // Main method to test the map
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        System.out.println("Value of apple: " + map.get("apple")); // 10
        System.out.println("Contains banana? " + map.containsKey("banana")); // true
        map.remove("banana");
        System.out.println("Contains banana? " + map.containsKey("banana")); // false
        map.printMap();
        System.out.println("Size: " + map.size()); // 2
        map.clear();
        System.out.println("Is Empty: " + map.isEmpty()); // true
    }
}
