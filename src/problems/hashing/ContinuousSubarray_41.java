package problems.hashing;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;


public class ContinuousSubarray_41 {
	
	/*
	 * Given an array of integers nums and an integer k, return the total number of
	 * continuous subarrays whose sum equals to k.
	 * 
	 * Example 1: Input: nums = [1,1,1], k = 2 Output: 2
	 * 
	 * Example 2: Input: nums = [1,2,3], k = 3 Output: 2
	 */


	@Test
	public void example1() {
		int[] arr = { 1, 1, 1 };
		int k = 2;
		System.out.println("Input array is " + Arrays.toString(arr) + " and expected sum is " + k);
		System.out
				.println("Number of continious subarray(s) using effective method is " + contSubarrayEffective(arr, k));
	}

	@Test
	public void example2() {
		int[] arr = { 1, 2, 3 };
		int k = 3;
		System.out.println("Input array is " + Arrays.toString(arr) + " and expected sum is " + k);
		System.out
				.println("Number of continious subarray(s) using effective method is " + contSubarrayEffective(arr, k));
	}

	@Test
	public void example3() {
		int[] arr = { 3, 1, 1, 2, 1, 5 };
		int k = 5;
		System.out.println("Input array is " + Arrays.toString(arr) + " and expected sum is " + k);
		System.out
				.println("Number of continious subarray(s) using effective method is " + contSubarrayEffective(arr, k));
	}

	@Test
	public void example4() {
		int[] arr = { -1, -1, 1 };
		int k = 0;
		System.out.println("Input array is " + Arrays.toString(arr) + " and expected sum is " + k);
		System.out
				.println("Number of continious subarray(s) using effective method is " + contSubarrayEffective(arr, k));
	}

	@Test
	public void example5() {
		int[] arr = { 1 };
		int k = 1;
		System.out.println("Input array is " + Arrays.toString(arr) + " and expected sum is " + k);
		System.out
				.println("Number of continious subarray(s) using effective method is " + contSubarrayEffective(arr, k));
	}

	// Hashing technique
	private int contSubarrayEffective(int[] arr, int k) {
		if (arr.length == 0)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt = 0, sum = 0;

		map.put(0, 1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (map.containsKey(sum - k))
				cnt += map.get(sum - k);

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return cnt;
	}

	// Brute force
	private int contSubarrayBruteForce(int[] arr, int k) {
		if (arr.length == 0)
			return 0;

		int sum = 0, cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == k)
					cnt++;
			}
		}
		return cnt;
	}
}
