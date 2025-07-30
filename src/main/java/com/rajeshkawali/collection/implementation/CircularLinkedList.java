package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Node2 class for Circular Linked List
class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

// Circular Linked List implementation using Node2
public class CircularLinkedList {
    private Node2 head;  // Points to the first node
    private Node2 tail;  // Points to the last node
    private int size;    // Number of elements

    // Constructor
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a node at the beginning
    public void addFirst(int value) {
        Node2 newNode = new Node2(value);
        if (head == null) {
            // List is empty, so newNode points to itself
            head = tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;  // Point newNode to current head
            tail.next = newNode;  // Tail should point to new head
            head = newNode;       // Update head
        }
        size++;
    }

    // Add a node at the end
    public void addLast(int value) {
        Node2 newNode = new Node2(value);
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;   // New node should point to head
            tail.next = newNode;   // Old tail should point to new node
            tail = newNode;        // Update tail
        }
        size++;
    }

    // Remove the first node
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            // Only one node in the list
            head = tail = null;
        } else {
            head = head.next;      // Move head forward
            tail.next = head;      // Update tail's next pointer
        }
        size--;
    }

    // Remove the last node
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            // Only one node
            head = tail = null;
        } else {
            Node2 current = head;
            // Traverse until the second last node
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head;  // Point to head (make circular)
            tail = current;       // Update tail
        }
        size--;
    }

    // Print the circular linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Circular List: ");
        Node2 current = head;
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != head) System.out.print(" -> ");
        } while (current != head);
        System.out.println();
    }

    // Return the number of elements
    public int size() {
        return size;
    }
    
    // Traverse the list and perform any action per node
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty. Nothing to traverse.");
            return;
        }
        System.out.println("Traversing Circular Linked List:");
        Node2 current = head;
        // do-while ensures we visit head at least once and stop when we return to it
        do {
            // Custom logic: you can modify this to do more than just print
            System.out.println("Visited Node: " + current.data);
            current = current.next;
        } while (current != head); // Stop when we've come full circle
    }

    // Main method to test the CircularLinkedList
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addLast(10);      // 10
        cll.addFirst(20);     // 20 -> 10
        cll.addLast(30);      // 20 -> 10 -> 30
        //cll.traverse();		  // 20, 10, 30
        cll.printList();      // Circular List: 20 -> 10 -> 30
        cll.removeFirst();    // 10 -> 30
        cll.printList();
        cll.removeLast();     // 10
        cll.printList();
        System.out.println("Size: " + cll.size()); // 1
    }
}
