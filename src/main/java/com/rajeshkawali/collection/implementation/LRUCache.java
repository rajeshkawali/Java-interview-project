package com.rajeshkawali.collection.implementation;
import java.util.HashMap;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Node class for Doubly Linked List
class Node3 {
    int key;
    int value;
    Node3 prev;
    Node3 next;

    public Node3(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// LRU Cache class
public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node3> map;
    private Node3 head;  // Most Recently Used (MRU)
    private Node3 tail;  // Least Recently Used (LRU)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail to avoid null checks
        head = new Node3(0, 0);
        tail = new Node3(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Get the value from cache
    public int get(int key) {
        if (map.containsKey(key)) {
        	Node3 node = map.get(key);
            moveToHead(node); // Recently used
            return node.value;
        }
        return -1; // Not found
    }

    // Put key-value pair into cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
        	Node3 node = map.get(key);
            node.value = value; // Update value
            moveToHead(node);   // Move to MRU
        } else {
            if (map.size() == capacity) {
                // Remove LRU node from list and map
            	Node3 lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }

            // Add new node to head
            Node3 newNode = new Node3(key, value);
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    // Move existing node to head (most recently used)
    private void moveToHead(Node3 node) {
        removeNode(node);
        addToHead(node);
    }

    // Remove node from its position
    private void removeNode(Node3 node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node just after head
    private void addToHead(Node3 node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Print cache from most to least recently used
    public void printCache() {
    	Node3 current = head.next;
        System.out.print("Cache: ");
        while (current != tail) {
            System.out.print("[" + current.key + "=" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the LRU Cache
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);  // Cache: 1
        cache.put(2, 20);  // Cache: 2 -> 1
        cache.put(3, 30);  // Cache: 3 -> 2 -> 1

        cache.printCache();

        cache.get(1);      // Access 1, move to head -> 1 -> 3 -> 2
        cache.printCache();

        cache.put(4, 40);  // Cache full, remove LRU (2) -> 4 -> 1 -> 3
        cache.printCache();

        System.out.println("Get 2: " + cache.get(2)); // Should return -1 (removed)
        System.out.println("Get 1: " + cache.get(1)); // Should return 10
        cache.printCache();
    }
}


/*

What is LRU Cache?
LRU = Least Recently Used

An LRU cache removes the least recently accessed item when capacity is full.
To make it efficient:

HashMap gives O(1) access by key

Doubly Linked List tracks usage order.


*/