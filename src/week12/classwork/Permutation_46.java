package week12.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Permutation_46 {
	
	/*
	 * https://leetcode.com/problems/permutations/
	 * Leetcode Problem No 46
	 */
	
	
	/*
	 * Given an array nums of distinct integers, return all the possible
	 * permutations. You can return the answer in any order.
	 * 
	 * 
	 * 
	 * Example 1: 
	 * Input: nums = [1,2,3] Output:
	 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] 
	 * 
	 * Example 2: 
	 * Input: nums = [0,1] Output: [[0,1],[1,0]] 
	 * 
	 * Example 3: 
	 * Input: nums = [1] Output: [[1]]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 6 -10 <= nums[i] <= 10 All the integers of nums are
	 * unique.
	 */
	
	
	@Test
	public void example1() {
		int[] nums = { 1, 2, 3 };
		findPermuations(nums);
		anotherMethod(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 0, 1 };
		findPermuations(nums);
		anotherMethod(nums);
	}

	@Test
	public void example3() {
		int[] nums = { 1 };
		findPermuations(nums);
		anotherMethod(nums);
	}

	private void findPermuations(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		recursionFunction(nums, output, 0);
		System.out.println(output);
	}

	private void recursionFunction(int[] nums, List<List<Integer>> output, int start) {
		if (start == nums.length) {
			List<Integer> temp = new ArrayList<Integer>();
			Arrays.stream(nums).forEach(el -> temp.add(el));
			output.add(temp);
		}
		for (int i = start; i < nums.length; i++) {
			swapping(nums, start, i);
			recursionFunction(nums, output, start + 1);
			swapping(nums, start, i);
		}
	}

	private void swapping(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	// Method 2
	private void anotherMethod(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		helperFunction(nums, output, new ArrayList<>());
		System.out.println(output);
	}

	private void helperFunction(int[] nums, List<List<Integer>> output, List<Integer> temp) {
		if (nums.length == temp.size()) {
			output.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i]))
				continue;

			temp.add(nums[i]);
			helperFunction(nums, output, temp);
			temp.remove(temp.size() - 1);
		}
	}

}
