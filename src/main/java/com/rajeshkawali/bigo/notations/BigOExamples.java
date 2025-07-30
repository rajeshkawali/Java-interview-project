package com.rajeshkawali.bigo.notations;



/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class BigOExamples {

	// O(1) - Constant Time
	// No matter the input size, this method always takes the same time.
	public void constantTime(int[] arr) {
		// Accessing the first element takes constant time.
		if (arr.length > 0) {
			System.out.println("First element: " + arr[0]);
		}
	}

	// O(log n) - Logarithmic Time
	// The input is divided by 2 each time - example: Binary Search
	public int logarithmicTime(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			// Middle element index
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid; // Target found
			} else if (arr[mid] < target) {
				left = mid + 1; // Search right half
			} else {
				right = mid - 1; // Search left half
			}
		}
		return -1; // Not found
	}

	// O(n) - Linear Time
	// Time grows directly with input size. One operation per element.
	public void linearTime(int[] arr) {
		for (int value : arr) {
			System.out.println("Value: " + value);
		}
	}

	// O(n log n) - Linearithmic Time
	// Used in efficient sorting algorithms like Merge Sort or Quick Sort
	public void linearithmicTime(int[] arr) {
		// We'll just call Arrays.sort() which uses Dual-Pivot QuickSort in Java
		java.util.Arrays.sort(arr); // Avg time complexity: O(n log n)
		for (int value : arr) {
			System.out.println("Sorted: " + value);
		}
	}

	// O(n^2) - Quadratic Time
	// Nested loops — grows quickly as input increases
	public void quadraticTime(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println("(" + arr[i] + ", " + arr[j] + ")");
			}
		}
	}

	// O(2^n) - Exponential Time
	// Recursive algorithm where each call makes two more calls (like Fibonacci)
	public int exponentialTime(int n) {
		if (n <= 1)
			return n;

		return exponentialTime(n - 1) + exponentialTime(n - 2);
		// Very slow for large n — number of calls doubles each time
	}

	// O(n!) - Factorial Time
	// Used in permutations — time explodes very fast with n
	public void factorialTime(int n) {
		permute("", "123456789".substring(0, n));
	}

	// Helper for factorialTime — prints all permutations of a string
	private void permute(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			System.out.println("Permutation: " + prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
			}
		}
	}

	// O(n^3) - Triple Nested Loop
	// Time grows cubically as input increases
	public void cubicTime(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
				}
			}
		}
	}
	
	// O(√n) - Square Root Time
	// Often seen in algorithms like checking prime numbers
	public boolean isPrime(int n) {
	    if (n < 2) return false;

	    for (int i = 2; i * i <= n; i++) {
	        if (n % i == 0) return false;
	    }
	    return true;
	}

	// O(n + m) - Linear Time with two inputs
	// Example: Merge two arrays
	public void mergeArrays(int[] a, int[] b) {
	    for (int num : a) {
	        System.out.println("From A: " + num);
	    }
	    for (int num : b) {
	        System.out.println("From B: " + num);
	    }
	}


	// Main method to run examples
	public static void main(String[] args) {
		BigOExamples bigO = new BigOExamples();

		int[] exampleArray = { 5, 2, 8, 1, 3 };

		System.out.println("\nO(1) - Constant Time");
		bigO.constantTime(exampleArray);

		System.out.println("\nO(log n) - Logarithmic Time (Binary Search on sorted array)");
		java.util.Arrays.sort(exampleArray);
		System.out.println("Index of 3: " + bigO.logarithmicTime(exampleArray, 3));

		System.out.println("\nO(n) - Linear Time");
		bigO.linearTime(exampleArray);

		System.out.println("\nO(n log n) - Linearithmic Time (Sort)");
		bigO.linearithmicTime(exampleArray);

		System.out.println("\nO(n^2) - Quadratic Time (Print Pairs)");
		bigO.quadraticTime(exampleArray);

		System.out.println("\nO(2^n) - Exponential Time (Fibonacci of 5)");
		System.out.println("Fib(5): " + bigO.exponentialTime(5));

		System.out.println("\nO(n!) - Factorial Time (Permutations of 3 digits)");
		bigO.factorialTime(3);
	}
}
/*
Big-O notation describes the performance or complexity of an algorithm.
It helps estimate how an algorithm behaves as the input size grows.
Time complexity shows how runtime changes with input size.
Space complexity shows how memory usage changes.

Big-O		Name				Method Name					Where it's Used
-----------------------------------------------------------------------------------------
O(1)		Constant			constantTime				HashMap get, simple return
O(log n)	Logarithmic			logarithmicTime				Binary Search
O(n)		Linear				linearTime					Loop over array
O(n + m)	Linear(2 arrays)	mergeArrays					Two loops side-by-side
O(√n)		Square Root			isPrime						Prime number check
O(n log n)	Linearithmic		mergeSort,linearithmicTime	Merge sort, QuickSort
O(n^2)		Quadratic			quadraticTime				Bubble sort, nested loop
O(n^3)		Cubic				cubicTime					Triple nested loop
O(2^n)		Exponential			exponentialTime				Fibonacci naive recursion
O(n!)		Factorial			factorialTime				Permutations

*/





/*
Common Time Complexities
O(1) - Constant Time: Executes in same time regardless of input size.
Example: Accessing array element by index.

O(log n) - Logarithmic Time: Input size is reduced by half each iteration.
Example: Binary Search.

O(n) - Linear Time: Time grows linearly with input.
Example: Loop through an array.

O(n log n) - Linearithmic Time: Common in efficient sorting like Merge Sort, Quick Sort.

O(n^2) - Quadratic Time: Nested loops over input.
Example: Bubble Sort.

O(2^n) - Exponential Time: Doubles each step, seen in recursion problems like Fibonacci.

O(n!) - Factorial Time: All permutations, very slow.
Example: Solving Traveling Salesman Problem using brute force.
*/