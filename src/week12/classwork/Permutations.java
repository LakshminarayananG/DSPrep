package week12.classwork;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class Permutations {

	
	/*
	 * https://leetcode.com/problems/permutations-ii/
	 * Problem No: 47
	 */
	
	
	/*
	 * 
	 * Given a collection of numbers, nums, that might contain duplicates, return
	 * all possible unique permutations in any order. Example 1: Input: nums =
	 * [1,1,2] Output: [[1,1,2], [1,2,1], [2,1,1]] Example 2: Input: nums = [1,2,3]
	 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] Constraints: 1 <=
	 * nums.length <= 8 -10 <= nums[i] <= 10
	 */
	
	@Test
	public void example1() {
		int[] nums = { 1, 1, 2 };
		findPermutations(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 3 };
		findPermutations(nums);
	}

	private void findPermutations(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		recursionFunction(nums, output, new ArrayList<Integer>(), new boolean[nums.length]);
		System.out.println(output);
	}

	private void recursionFunction(int[] nums, List<List<Integer>> output, List<Integer> temp, boolean[] used) {
		if (temp.size() == nums.length) {
			output.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for (int i = 0; i < used.length; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
				continue;

			temp.add(nums[i]);
			used[i] = true;
			recursionFunction(nums, output, temp, used);
			temp.remove(temp.size() - 1);
			used[i] = false;
		}
	}
	
}
