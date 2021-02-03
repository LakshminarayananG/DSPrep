package problems.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class CheckUniqueOccurrences_33 {
	
	/*
	 * Given an array of integers arr, write a function that returns true if and
	 * only if the number of occurrences of each value in the array is unique.
	 * 
	 * Example 1: Input: arr = [1,2,2,1,1,3] Output: true Explanation: The value 1
	 * has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of
	 * occurrences.
	 * 
	 * Example 2: Input: arr = [1,2] Output: false
	 * 
	 * Example 3: Input: arr = [-3,0,1,-3,1,1,1,-3,10,0] Output: true
	 */


	@Test
	public void example1() {
		int[] arr = { 1, 2, 2, 1, 1, 3 };
		System.out.println(isHavingUniqueOccurrences(arr));
		Assert.assertEquals(true, isHavingUniqueOccurrences(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 1, 2 };
		System.out.println(isHavingUniqueOccurrences(arr));
		Assert.assertEquals(false, isHavingUniqueOccurrences(arr));
	}

	@Test
	public void example3() {
		int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
		System.out.println(isHavingUniqueOccurrences(arr));
		Assert.assertEquals(true, isHavingUniqueOccurrences(arr));
	}

	private boolean isHavingUniqueOccurrences(int[] arr) {
		Map<Integer, Integer> arrElOcc = new HashMap<>();

		for (int each : arr)
			arrElOcc.put(each, arrElOcc.getOrDefault(each, 0) + 1);

		Set<Integer> temp = new HashSet<>(arrElOcc.values());

		return arrElOcc.size() == temp.size();

	}
}
