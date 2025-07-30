package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Custom implementation of ArrayList in Java without using built-in classes
public class MyArrayList<T> {

    // Array to store elements (generic type T)
    private Object[] data;

    // Current number of elements in the list
    private int size;

    // Current capacity of the array
    private int capacity;

    // Initial capacity when list is created
    private static final int INITIAL_CAPACITY = 10;

    // Constructor to initialize the array
    public MyArrayList() {
        capacity = INITIAL_CAPACITY;         // Set default capacity
        data = new Object[capacity];         // Create the array
        size = 0;                            // Initially list is empty
    }

    // Add an element at the end of the list
    public void add(T element) {
        ensureCapacity();                    // Check and grow array if full
        data[size] = element;                // Add element at the current size index
        size++;                              // Increase size
    }

    // Get the element at a specific index
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);                  // Check if index is valid
        return (T) data[index];             // Return the element
    }

    // Remove element from a specific index
    public T remove(int index) {
        checkIndex(index);                  // Check if index is valid
        @SuppressWarnings("unchecked")
        T removedElement = (T) data[index]; // Store the element to return later
        // Shift all elements to the left from that index
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;              // Remove last duplicate element (optional for memory cleanup)
        size--;                             // Decrease size of list
        return removedElement;              // Return removed element
    }

    // Return the current size (number of elements)
    public int size() {
        return size;
    }

    // Ensure there's space in array, if size is full - Increase by 50% 
    private void ensureCapacity() {
        if (size == capacity) {
        	capacity = capacity + (capacity / 2);       // Increase by 50%
            Object[] newData = new Object[capacity];  // Create new larger array
            // Copy old elements to new array one by one
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;                      // Replace old array with new one
        }
    }

    // Check if index is within valid range
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            // Throw an error if index is invalid
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
    }

    // Print all elements in the list
    public void printAll() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Main method to test the MyArrayList class
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");    // Add element
        list.add("Banana");
        list.add("Cherry");
        list.printAll();      // Output: [Apple, Banana, Cherry]
        list.remove(1);       // Remove element at index 1 (Banana)
        list.printAll();      // Output: [Apple, Cherry]
        System.out.println("Element at index 1: " + list.get(1)); // Cherry
        System.out.println("Size: " + list.size());               // 2
    }
}
/*
"How does Java's ArrayList grow internally?"

In modern Java, ArrayList increases its size by 50% when full using the formula:
newCapacity = oldCapacity + (oldCapacity / 2)

In older versions, ((capacity * 3) / 2) + 1 was commonly used, especially in Vector.

*/