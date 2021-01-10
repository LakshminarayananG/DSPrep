package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Subsetsii_90 {
	@Test
	public void example1() {
		int[] nums = { 1, 2, 2 };
		findSubset(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 3 };
		findSubset(nums);
	}

	private void findSubset(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		recursionFunction(nums, output, new ArrayList<Integer>(), 0);
		System.out.println(output);
	}

	private void recursionFunction(int[] nums, List<List<Integer>> output, List<Integer> temp, int start) {
		output.add(new ArrayList<Integer>(temp));

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			temp.add(nums[i]);
			recursionFunction(nums, output, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
