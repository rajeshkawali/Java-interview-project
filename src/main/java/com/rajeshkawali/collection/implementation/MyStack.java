package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Custom implementation of Stack using array
public class MyStack<T> {

    private Object[] data;   // Array to store stack elements
    private int top;         // Index of top element
    private int capacity;    // Current capacity of stack

    private static final int INITIAL_CAPACITY = 10;  // Default size

    // Constructor to initialize stack
    public MyStack() {
        capacity = INITIAL_CAPACITY;
        data = new Object[capacity];
        top = -1;  // Stack is empty initially
    }

    // Push (add) an element onto the stack
    public void push(T element) {
        ensureCapacity();           // Grow the stack if full
        top++;                      // Move top pointer
        data[top] = element;        // Place the element on top
    }

    // Pop (remove and return) the top element of the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }

        @SuppressWarnings("unchecked")
        T element = (T) data[top];  // Get the top element
        data[top] = null;           // Clear reference (good for memory)
        top--;                      // Move top pointer down
        return element;
    }

    // Peek (view) the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }

        @SuppressWarnings("unchecked")
        T element = (T) data[top];  // Return the top element
        return element;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Return the number of elements in the stack
    public int size() {
        return top + 1;
    }

    // Ensure there is space in the stack, grow if needed
    private void ensureCapacity() {
        if (top + 1 == capacity) {
            capacity = capacity * 2;              // Double the capacity
            Object[] newData = new Object[capacity];

            // Copy old data to new array
            for (int i = 0; i <= top; i++) {
                newData[i] = data[i];
            }

            data = newData;  // Replace old array
        }
    }

    // Print stack elements from top to bottom
    public void printStack() {
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i]);
            if (i > 0) System.out.print(" -> ");
        }
        System.out.println();
    }

    // Main method to test the custom stack
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack(); // Stack (top to bottom): 30 -> 20 -> 10

        System.out.println("Top element is: " + stack.peek());  // 30

        System.out.println("Popped: " + stack.pop()); // 30
        stack.printStack(); // Stack (top to bottom): 20 -> 10

        System.out.println("Stack size: " + stack.size()); // 2

        System.out.println("Is empty? " + stack.isEmpty()); // false
    }
}
