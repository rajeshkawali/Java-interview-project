package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Node class for Doubly Linked List
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List implementation
public class DoublyLinkedList {
    private Node head;   // Start of the list
    private Node tail;   // End of the list
    private int size;    // Track number of elements
    // Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add node to the beginning
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            // List is empty
            head = tail = newNode;
        } else {
            newNode.next = head; // Link newNode to current head
            head.prev = newNode; // Link current head back to newNode
            head = newNode;      // Update head
        }
        size++;
    }

    // Add node to the end
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            // List is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;  // Link tail to new node
            newNode.prev = tail;  // Link new node back to tail
            tail = newNode;       // Update tail
        }
        size++;
    }

    // Remove node from the beginning
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == tail) {
            // Only one element
            head = tail = null;
        } else {
            head = head.next;    // Move head forward
            head.prev = null;    // Remove reference to old head
        }
        size--;
    }

    // Remove node from the end
    public void removeLast() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == tail) {
            // Only one element
            head = tail = null;
        } else {
            tail = tail.prev;    // Move tail back
            tail.next = null;    // Remove reference to old tail
        }
        size--;
    }

    // Print the list from head to tail
    public void printForward() {
        System.out.print("Forward: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Print the list from tail to head
    public void printBackward() {
        System.out.print("Backward: ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) System.out.print(" -> ");
            current = current.prev;
        }
        System.out.println();
    }
    // Return size of the list
    public int size() {
        return size;
    }

    // Main method to test
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(10);     // 10
        dll.addFirst(20);     // 20 -> 10
        dll.addLast(30);      // 20 -> 10 -> 30
        dll.printForward();   // Forward: 20 -> 10 -> 30
        dll.printBackward();  // Backward: 30 -> 10 -> 20
        dll.removeFirst();    // Remove 20
        dll.printForward();   // Forward: 10 -> 30
        dll.removeLast();     // Remove 30
        dll.printForward();   // Forward: 10
        System.out.println("Size: " + dll.size()); // 1
    }
}
