package com.rajeshkawali.collection.implementation;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class MyTreeSet {
	// Node class representing each element in the TreeSet
	static class Node {
		int data;
		Node left, right;

		Node(int value) {
			this.data = value;
		}
	}

	private Node root;

	// Adds a value to the TreeSet (BST logic, avoids duplicates)
	public boolean add(int value) {
		if (root == null) {
			root = new Node(value);
			return true;
		}

		Node current = root;
		while (true) {
			if (value == current.data) {
				return false; // No duplicates in TreeSet
			} else if (value < current.data) {
				if (current.left == null) {
					current.left = new Node(value);
					return true;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = new Node(value);
					return true;
				}
				current = current.right;
			}
		}
	}

	// Checks if a value exists in the TreeSet
	public boolean contains(int value) {
		Node current = root;
		while (current != null) {
			if (value == current.data) {
				return true;
			} else if (value < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	// Removes a value from the TreeSet
	public boolean remove(int value) {
		root = removeNode(root, value);
		return true;
	}

	// Helper method to remove a node (standard BST deletion)
	private Node removeNode(Node node, int value) {
		if (node == null)
			return null;

		if (value < node.data) {
			node.left = removeNode(node.left, value);
		} else if (value > node.data) {
			node.right = removeNode(node.right, value);
		} else {
			// Node with one or no child
			if (node.left == null)
				return node.right;
			if (node.right == null)
				return node.left;

			// Node with two children: find in-order successor
			node.data = findMin(node.right);
			node.right = removeNode(node.right, node.data);
		}
		return node;
	}

	// Finds minimum value in a subtree
	private int findMin(Node node) {
		while (node.left != null)
			node = node.left;
		return node.data;
	}

	// In-order traversal to print TreeSet in sorted order
	public void inOrder() {
		System.out.print("TreeSet (sorted): ");
		inOrderTraversal(root);
		System.out.println();
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	// Main method to test
	public static void main(String[] args) {
		MyTreeSet treeSet = new MyTreeSet();
		treeSet.add(10);
		treeSet.add(5);
		treeSet.add(20);
		treeSet.add(15);
		treeSet.add(25);
		treeSet.inOrder(); // Output: 5 10 15 20 25
		System.out.println("Contains 15? " + treeSet.contains(15)); // true
		System.out.println("Contains 100? " + treeSet.contains(100)); // false
		treeSet.remove(10);
		treeSet.inOrder(); // Output: 5 15 20 25
	}
}
