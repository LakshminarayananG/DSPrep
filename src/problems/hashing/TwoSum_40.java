package problems.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class TwoSum_40 {
	
	/*
	Given an array of integers say nums and an integer say target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	You can return the answer in any order.
	example:
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation:
	nums[0] + nums[1] == 9, so we
	return [0, 1].
	*/

	@Test
	public void example1() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		Assert.assertEquals(Arrays.toString(new int[] { 0, 1 }), Arrays.toString(hashingTech(nums, target)));
	}

	@Test
	public void example2() {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		Assert.assertEquals(Arrays.toString(new int[] { 1, 2 }), Arrays.toString(hashingTech(nums, target)));
	}

	@Test
	public void example3() {
		int[] nums = { 3, 2, 4 };
		int target = 10;
		hashingTech(nums, target);
	}

	private int[] hashingTech(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]))
				return new int[] { map.get(target - nums[i]), i };
			else
				map.put(nums[i], i);
		}
		throw new RuntimeException("No indices found");
	}
}
