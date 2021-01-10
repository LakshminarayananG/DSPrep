package backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given an integer array nums, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/

public class Subsets_78 {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3 };
		findSubsets(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 1 };
		findSubsets(nums);
	}

	private void findSubsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		recursionFunction(nums, output, new ArrayList<Integer>(), 0);
		System.out.println(output);
	}

	private void recursionFunction(int[] nums, List<List<Integer>> output, List<Integer> temp, int start) {
		output.add(new ArrayList<Integer>(temp));
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			recursionFunction(nums, output, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
