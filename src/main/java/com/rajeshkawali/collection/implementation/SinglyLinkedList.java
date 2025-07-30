package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Node class for singly linked list
class Node1 {
    int data;
    Node1 next;

    public Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List implementation
public class SinglyLinkedList {
    private Node1 head;  // Points to the first node
    private int size;   // Number of elements in the list
    // Constructor
    public SinglyLinkedList() {
        head = null;    // List starts empty
        size = 0;
    }
    // Add a new node at the beginning
    public void addFirst(int value) {
        Node1 newNode = new Node1(value);
        newNode.next = head;  // Link new node to current head
        head = newNode;       // Move head to new node
        size++;
    }

    // Add a new node at the end
    public void addLast(int value) {
        Node1 newNode = new Node1(value);
        if (head == null) {
            // List is empty, so new node becomes head
            head = newNode;
        } else {
            // Traverse to the last node
            Node1 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;  // Link last node to new node
        }
        size++;
    }

    // Remove the first node
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next; // Move head to next node
        size--;
    }

    // Remove the last node
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            // Only one node in the list
            head = null;
        } else {
            // Traverse to the second last node
            Node1 current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null; // Remove reference to last node
        }
        size--;
    }

    // Check if a value exists in the list
    public boolean contains(int value) {
        Node1 current = head;
        while (current != null) {
            if (current.data == value) {
                return true; // Found
            }
            current = current.next;
        }
        return false; // Not found
    }

    // Print all elements in the list
    public void printList() {
        Node1 current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Return number of elements in the list
    public int size() {
        return size;
    }

    // Main method to test SinglyLinkedList
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);     // 10
        list.addFirst(20);     // 20 -> 10
        list.addLast(30);      // 20 -> 10 -> 30
        list.printList();

        list.removeFirst();    // 10 -> 30
        list.printList();

        list.removeLast();     // 10
        list.printList();

        System.out.println("Contains 10? " + list.contains(10)); // true
        System.out.println("Contains 99? " + list.contains(99)); // false
        System.out.println("Size: " + list.size());              // 1
    }
}
