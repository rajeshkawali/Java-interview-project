package com.rajeshkawali.program.mostasked;

import java.util.*;

public class JavaInterview46to60 {
	static void reverse(int[] a, int l, int r) {
		while (l < r) {
			int t = a[l];
			a[l++] = a[r];
			a[r--] = t;
		}
	}

	public static void main(String[] args) {
		int[] a46 = { 10, 40, 20, 50, 30, 50 };
		Long first = null, second = null, third = null;
		for (int num : a46) {
			long x = num;
			if (Objects.equals(first, x) || Objects.equals(second, x) || Objects.equals(third, x))
				continue;
			if (first == null || x > first) {
				third = second;
				second = first;
				first = x;
			} else if (second == null || x > second) {
				third = second;
				second = x;
			} else if (third == null || x > third)
				third = x;
		}
		System.out.println("46. Third largest: " + third);
		int[] a47 = { 1, 2, 3, 4, 5 }, b47 = { 3, 4, 5, 6 };
		Set<Integer> lookup = new HashSet<>(), intersection = new LinkedHashSet<>();
		for (int x : a47)
			lookup.add(x);
		for (int x : b47)
			if (lookup.contains(x))
				intersection.add(x);
		System.out.println("47. Intersection: " + intersection);
		int[] a48 = { 1, 2, 3, 4 }, b48 = { 3, 4, 5, 6 };
		Set<Integer> union = new LinkedHashSet<>();
		for (int x : a48)
			union.add(x);
		for (int x : b48)
			union.add(x);
		System.out.println("48. Union: " + union);
		int[] a49 = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3, n = a49.length;
		if (n > 0) {
			k = ((k % n) + n) % n;
			reverse(a49, 0, n - 1);
			reverse(a49, 0, k - 1);
			reverse(a49, k, n - 1);
		}
		System.out.println("49. Rotate right: " + Arrays.toString(a49));
		int[] a50 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int current = a50[0], best = a50[0];
		for (int i = 1; i < a50.length; i++) {
			current = Math.max(a50[i], current + a50[i]);
			best = Math.max(best, current);
		}
		System.out.println("50. Kadane maximum sum: " + best);
		int[] a51 = { 1, 3, 5, 7 }, b51 = { 2, 4, 6, 8 }, merged = new int[a51.length + b51.length];
		int i = 0, j = 0, p = 0;
		while (i < a51.length && j < b51.length)
			merged[p++] = a51[i] <= b51[j] ? a51[i++] : b51[j++];
		while (i < a51.length)
			merged[p++] = a51[i++];
		while (j < b51.length)
			merged[p++] = b51[j++];
		System.out.println("51. Merge sorted: " + Arrays.toString(merged));
		int[] a52 = { 2, 2, 1, 1, 2, 2, 2 };
		int candidate = 0, count = 0;
		for (int x : a52) {
			if (count == 0)
				candidate = x;
			count += (x == candidate ? 1 : -1);
		}
		int occurrences = 0;
		for (int x : a52)
			if (x == candidate)
				occurrences++;
		System.out.println("52. Majority: " + (occurrences > a52.length / 2 ? String.valueOf(candidate) : "none"));
		int[] a53 = { 16, 17, 4, 3, 5, 2 };
		List<Integer> leaders = new ArrayList<>();
		int maxRight = Integer.MIN_VALUE;
		for (i = a53.length - 1; i >= 0; i--)
			if (a53[i] >= maxRight) {
				leaders.add(a53[i]);
				maxRight = a53[i];
			}
		Collections.reverse(leaders);
		System.out.println("53. Leaders: " + leaders);
		int[] a54 = { 1, 2, 3, 7, 5 };
		int target54 = 12, left = 0, start = -1, end = -1;
		long sum = 0;
		for (int right = 0; right < a54.length; right++) {
			sum += a54[right];
			while (left <= right && sum > target54)
				sum -= a54[left++];
			if (left <= right && sum == target54) {
				start = left;
				end = right;
				break;
			}
		}
		System.out.println("54. Target subarray: "
				+ (start < 0 ? "Not found" : Arrays.toString(Arrays.copyOfRange(a54, start, end + 1))));
		int[] a55 = { 2, 0, 2, 1, 1, 0 };
		int low = 0, mid = 0, high = a55.length - 1;
		while (mid <= high) {
			if (a55[mid] == 0) {
				int t = a55[low];
				a55[low++] = a55[mid];
				a55[mid++] = t;
			} else if (a55[mid] == 1)
				mid++;
			else {
				int t = a55[mid];
				a55[mid] = a55[high];
				a55[high--] = t;
			}
		}
		System.out.println("55. Sort 0/1/2: " + Arrays.toString(a55));
		int[] a56 = { -7, 1, 5, 2, -4, 3, 0 };
		long total = 0, leftSum = 0;
		int eq = -1;
		for (int x : a56)
			total += x;
		for (i = 0; i < a56.length; i++) {
			if (leftSum == total - leftSum - a56[i]) {
				eq = i;
				break;
			}
			leftSum += a56[i];
		}
		System.out.println("56. Equilibrium index: " + eq);
		int[] a57 = { 1, 2, 3, 4 }, products = new int[a57.length];
		int prefix = 1, suffix = 1;
		for (i = 0; i < a57.length; i++) {
			products[i] = prefix;
			prefix *= a57[i];
		}
		for (i = a57.length - 1; i >= 0; i--) {
			products[i] *= suffix;
			suffix *= a57[i];
		}
		System.out.println("57. Product except self: " + Arrays.toString(products));
		int[] a58 = { 1, 1, 0, 1, 1, 1, 0, 1 };
		int streak = 0, longest = 0;
		for (int x : a58) {
			streak = x == 1 ? streak + 1 : 0;
			longest = Math.max(longest, streak);
		}
		System.out.println("58. Maximum consecutive ones: " + longest);
		int[] a59 = { 1, 5, 10, 20, 40, 80 }, b59 = { 6, 7, 20, 80, 100 }, c59 = { 3, 4, 15, 20, 30, 70, 80, 120 };
		i = 0;
		j = 0;
		k = 0;
		List<Integer> common = new ArrayList<>();
		while (i < a59.length && j < b59.length && k < c59.length) {
			if (a59[i] == b59[j] && b59[j] == c59[k]) {
				if (common.isEmpty() || common.get(common.size() - 1) != a59[i])
					common.add(a59[i]);
				i++;
				j++;
				k++;
			} else {
				int min = Math.min(a59[i], Math.min(b59[j], c59[k]));
				if (a59[i] == min)
					i++;
				if (b59[j] == min)
					j++;
				if (c59[k] == min)
					k++;
			}
		}
		System.out.println("59. Common in three arrays: " + common);
		int[] a60 = { 2, 4, 6, 8, 10, 12, 14 };
		int target60 = 10, l = 0, r = a60.length - 1, index = -1;
		while (l <= r) {
			int middle = l + (r - l) / 2;
			if (a60[middle] == target60) {
				index = middle;
				break;
			} else if (a60[middle] < target60)
				l = middle + 1;
			else
				r = middle - 1;
		}
		System.out.println("60. Binary search index: " + index);
	}
}
