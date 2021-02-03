package problems.hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class AbsoluteDifference_24 {
	
	/*
	Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
	and the absolute difference between i and j is at most k.
	Example 1:
	Input: nums = [1,2,3,1], k = 3
	Output: true
	Example 2:
	Input: nums = [1,0,1,1], k = 1
	Output: true
	Example 3:
	Input: nums = [1,2,3,1,2,3], k = 2
	Output: false
	Example 3:
	Input: nums = [1,2,3,2,2,3], k = 2
	Output: true
	Hint: Window Sliding
	*/

	@Test
	public void example1() {
		int[] arr = { 1, 2, 3, 3 };
		int k = 3;
		Assert.assertEquals(true, absDiff(arr, k));
	}

	@Test
	public void example2() {
		int[] arr = { 1, 0, 1, 1 };
		int k = 1;
		Assert.assertEquals(true, absDiff(arr, k));
	}

	@Test
	public void example3() {
		int[] arr = { 1, 2, 3, 1, 2, 3 };
		int k = 2;
		Assert.assertEquals(false, absDiff(arr, k));
	}

	@Test
	public void example4() {
		int[] arr = { 1, 2, 3, 2, 2, 3 };
		int k = 2;
		Assert.assertEquals(true, absDiff(arr, k));
	}

	private boolean absDiff(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int start = 0, end = 0;
		while (end < arr.length) {
			map.put(arr[end], map.getOrDefault(arr[end++], 0) + 1);
			if (end - start - 1 > k)
				map.put(arr[start], map.get(arr[start++]) - 1);
			if (map.containsValue(2))
				return true;
		}
		return false;
	}
}
