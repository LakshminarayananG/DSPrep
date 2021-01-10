package backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 
150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []

Example 4:
Input: candidates = [1], target = 1
Output: [[1]]

Example 5:
Input: candidates = [1], target = 2
Output: [[1,1]]

Constraints:
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
*/

public class CombinationSum_39 {

	@Test
	public void example1() {
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		findCombinations(nums, target);
	}

	@Test
	public void example2() {
		int[] nums = { 2, 3, 5 };
		int target = 8;
		findCombinations(nums, target);
	}

	@Test
	public void example3() {
		int[] nums = { 2 };
		int target = 1;
		findCombinations(nums, target);
	}

	@Test
	public void example4() {
		int[] nums = { 1 };
		int target = 1;
		findCombinations(nums, target);
	}

	@Test
	public void example5() {
		int[] nums = { 1 };
		int target = 2;
		findCombinations(nums, target);
	}

	private void findCombinations(int[] nums, int target) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		recursionFunction(nums, target, output, new ArrayList<Integer>(), 0);
		System.out.println(output);
	}

	private void recursionFunction(int[] nums, int target, List<List<Integer>> output, List<Integer> temp, int start) {
		if (target <= 0) {
			if (target == 0)
				output.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			recursionFunction(nums, target - nums[i], output, temp, i);
			temp.remove(temp.size() - 1);
		}
	}
}
