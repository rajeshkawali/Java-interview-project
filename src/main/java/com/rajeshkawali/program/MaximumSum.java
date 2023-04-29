package com.rajeshkawali.program;

public class MaximumSum {

	public static int maxSum(int[] arr, int k) {
		
		int n = arr.length;
		int maxSum = 0;
		int currentSum = 0;

		// Check if k is greater than the array size
		if (n < k) {
			System.out.println("Invalid input: k is greater than array size.");
			return -1;
		}

		// Calculate the sum of first k elements
		for (int i = 0; i < k; i++) {
			currentSum += arr[i];
		}

		maxSum = currentSum;

		// Calculate the sum of remaining sub arrays of size k
		for (int i = k; i < n; i++) {
			currentSum += arr[i] - arr[i - k];
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr1 = { 100, 200, 300, 400 };
		int k1 = 2;
		System.out.println("Maximum sum of " + k1 + " consecutive elements in arr1: " + maxSum(arr1, k1));

		int[] arr2 = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int k2 = 4;
		System.out.println("Maximum sum of " + k2 + " consecutive elements in arr2: " + maxSum(arr2, k2));

		int[] arr3 = { 2, 3 };
		int k3 = 3;
		System.out.println("Maximum sum of " + k3 + " consecutive elements in arr3: " + maxSum(arr3, k3));
	}
}

/*
Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.

nput  : arr[] = {100, 200, 300, 400}, k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.

Input  : arr[] = {2, 3}, k = 3
Output : Invalid

There is no subarray of size 3 as size of whole array is 2
 */
