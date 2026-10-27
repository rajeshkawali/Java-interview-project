package com.rajeshkawali.collection.implementation;

public class MyLinkedList<T> {

    /*
     * Node represents one element in the LinkedList.
     *
     * data -> Stores the element.
     * next -> Reference to the next node.
     */
    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head points to the first node.
    private Node<T> head;

    // Tail points to the last node.
    private Node<T> tail;

    // Stores total number of nodes.
    private int size = 0;

    // ==========================================
    // 1. addFirst() - Insert at beginning
    // Time Complexity: O(1)
    // ==========================================
    public void addFirst(T data) {

        Node<T> newNode = new Node<>(data);

        // New node points to the current head.
        newNode.next = head;

        // Update head to the new node.
        head = newNode;

        // If list was empty, tail is also new node.
        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    // ==========================================
    // 2. addLast() - Insert at end
    // Time Complexity: O(1)
    // ==========================================
    public void addLast(T data) {

        Node<T> newNode = new Node<>(data);

        // If list is empty, both head and tail
        // point to the new node.
        if (head == null) {
            head = tail = newNode;
        } else {

            // Connect current last node to new node.
            tail.next = newNode;

            // Update tail reference.
            tail = newNode;
        }

        size++;
    }

    // ==========================================
    // 3. add(index, data) - Insert at index
    // Time Complexity: O(n)
    // ==========================================
    public void add(int index, T data) {

        checkPositionIndex(index);

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> newNode = new Node<>(data);

        // Find node before insertion position.
        Node<T> temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // Connect new node to next node.
        newNode.next = temp.next;

        // Connect previous node to new node.
        temp.next = newNode;

        size++;
    }

    // ==========================================
    // 4. get(index) - Retrieve element
    // Time Complexity: O(n)
    // ==========================================
    public T get(int index) {

        checkElementIndex(index);

        Node<T> temp = head;

        // Traverse to required index.
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    // ==========================================
    // 5. set(index, data) - Update element
    // Time Complexity: O(n)
    // ==========================================
    public T set(int index, T data) {

        checkElementIndex(index);

        Node<T> temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        T oldData = temp.data;
        temp.data = data;

        return oldData;
    }

    // ==========================================
    // 6. removeFirst() - Delete first node
    // Time Complexity: O(1)
    // ==========================================
    public T removeFirst() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException(
                    "LinkedList is empty");
        }

        T removedData = head.data;

        // Move head to second node.
        head = head.next;

        size--;

        // If list becomes empty, reset tail.
        if (head == null) {
            tail = null;
        }

        return removedData;
    }

    // ==========================================
    // 7. removeLast() - Delete last node
    // Time Complexity: O(n)
    // ==========================================
    public T removeLast() {

        if (isEmpty()) {
            throw new java.util.NoSuchElementException(
                    "LinkedList is empty");
        }

        // If only one node exists.
        if (size == 1) {
            return removeFirst();
        }

        Node<T> temp = head;

        // Find second-last node.
        while (temp.next != tail) {
            temp = temp.next;
        }

        T removedData = tail.data;

        // Disconnect last node.
        temp.next = null;

        // Update tail.
        tail = temp;

        size--;

        return removedData;
    }

    // ==========================================
    // 8. remove(index) - Delete node at index
    // Time Complexity: O(n)
    // ==========================================
    public T remove(int index) {

        checkElementIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<T> temp = head;

        // Find node before the target.
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node<T> deletedNode = temp.next;

        // Skip the target node.
        temp.next = deletedNode.next;

        size--;

        return deletedNode.data;
    }

    // ==========================================
    // 9. contains() - Search for element
    // Time Complexity: O(n)
    // ==========================================
    public boolean contains(T data) {

        Node<T> temp = head;

        while (temp != null) {

            // Objects.equals handles null safely.
            if (java.util.Objects.equals(temp.data, data)) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // ==========================================
    // 10. indexOf() - Find first matching index
    // Time Complexity: O(n)
    // ==========================================
    public int indexOf(T data) {

        Node<T> temp = head;
        int index = 0;

        while (temp != null) {

            if (java.util.Objects.equals(temp.data, data)) {
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    // ==========================================
    // 11. reverse() - Reverse entire LinkedList
    // Time Complexity: O(n), Space: O(1)
    // ==========================================
    public void reverse() {

        Node<T> previous = null;
        Node<T> current = head;

        // Old head becomes the new tail.
        tail = head;

        while (current != null) {

            // Save next node before changing link.
            Node<T> nextNode = current.next;

            // Reverse current node's link.
            current.next = previous;

            // Move previous and current forward.
            previous = current;
            current = nextNode;
        }

        // Previous becomes new head.
        head = previous;
    }

    // ==========================================
    // 12. size() - Number of elements
    // Time Complexity: O(1)
    // ==========================================
    public int size() {
        return size;
    }

    // ==========================================
    // 13. isEmpty() - Check empty list
    // Time Complexity: O(1)
    // ==========================================
    public boolean isEmpty() {
        return size == 0;
    }

    // ==========================================
    // 14. clear() - Remove all nodes
    // Time Complexity: O(1)
    // ==========================================
    public void clear() {

        // Unreachable nodes become eligible
        // for garbage collection.
        head = null;
        tail = null;
        size = 0;
    }

    // ==========================================
    // 15. display() - Print all elements
    // Time Complexity: O(n)
    // ==========================================
    public void display() {

        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Validate index for get, set and remove.
    private void checkElementIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    // Validate index for add (allows index == size).
    private void checkPositionIndex(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    // ==========================================
    // MAIN METHOD - TEST ALL OPERATIONS
    // ==========================================
    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();

        // Add elements at end.
        list.addLast("Java");
        list.addLast("Python");
        list.addLast("Spring");

        list.display();
        // Java -> Python -> Spring -> null

        // Insert at beginning.
        list.addFirst("HTML");
        list.display();
        // HTML -> Java -> Python -> Spring -> null

        // Insert at index 2.
        list.add(2, "SQL");
        list.display();
        // HTML -> Java -> SQL -> Python -> Spring -> null

        // Retrieve element.
        System.out.println("Get: " + list.get(1));
        // Java

        // Update element.
        System.out.println("Old: " + list.set(1, "Core Java"));
        list.display();

        // Search element.
        System.out.println("Contains SQL: "
                           + list.contains("SQL"));

        System.out.println("Index of Python: "
                           + list.indexOf("Python"));

        // Remove first element.
        System.out.println("Remove First: "
                           + list.removeFirst());

        // Remove last element.
        System.out.println("Remove Last: "
                           + list.removeLast());

        // Remove element at index.
        System.out.println("Remove Index 1: "
                           + list.remove(1));

        list.display();

        // Reverse the LinkedList.
        list.reverse();
        System.out.println("Reversed List:");
        list.display();

        // Size and empty check.
        System.out.println("Size: " + list.size());
        System.out.println("Is Empty: " + list.isEmpty());

        // Clear the LinkedList.
        list.clear();
        list.display();

        System.out.println("Size: " + list.size());
    }
}
