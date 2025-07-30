package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Custom implementation of Queue using array
public class MyQueue<T> {

    private Object[] data;    // Array to store elements
    private int front;        // Index for front element
    private int rear;         // Index for rear (next insert position)
    private int size;         // Number of elements in queue
    private int capacity;     // Current array capacity

    private static final int INITIAL_CAPACITY = 10;

    // Constructor to initialize queue
    public MyQueue() {
        capacity = INITIAL_CAPACITY;
        data = new Object[capacity];
        front = 0;       // Points to first element
        rear = 0;        // Points to next available position
        size = 0;        // No elements yet
    }

    // Add element to the end of the queue
    public void enqueue(T element) {
        ensureCapacity();              // Grow if array is full
        data[rear] = element;          // Add element at rear
        rear = (rear + 1) % capacity;  // Move rear pointer circularly
        size++;                        // Increase size
    }

    // Remove and return the front element
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }

        @SuppressWarnings("unchecked")
        T element = (T) data[front];   // Get front element
        data[front] = null;            // Clear the reference
        front = (front + 1) % capacity;// Move front pointer circularly
        size--;                        // Decrease size
        return element;
    }

    // View the front element without removing it
    @SuppressWarnings("unchecked")
	public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return (T) data[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return number of elements in queue
    public int size() {
        return size;
    }

    // Ensure there's space to insert a new element
    private void ensureCapacity() {
        if (size == capacity) {
            // Double the capacity
            int newCapacity = capacity * 2;
            Object[] newData = new Object[newCapacity];

            // Copy elements from old array to new array in correct order
            for (int i = 0; i < size; i++) {
                newData[i] = data[(front + i) % capacity]; // wrap around circularly
            }

            data = newData;
            front = 0;
            rear = size;
            capacity = newCapacity;
        }
    }

    // Print all queue elements from front to rear
    public void printQueue() {
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % capacity]);
            if (i < size - 1) System.out.print(" -> ");
        }
        System.out.println();
    }

    // Main method to test the custom queue
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");

        queue.printQueue(); // Apple -> Banana -> Cherry

        System.out.println("Front element: " + queue.peek()); // Apple

        System.out.println("Dequeued: " + queue.dequeue());   // Apple
        queue.printQueue(); // Banana -> Cherry

        System.out.println("Queue size: " + queue.size());    // 2
        System.out.println("Is empty? " + queue.isEmpty());   // false
    }
}
