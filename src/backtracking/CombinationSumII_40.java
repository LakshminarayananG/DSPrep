package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
*/

public class CombinationSumII_40 {

	@Test
	public void example1() {
		int[] nums= {10,1,2,7,6,1,5};
		int target=8;
		findCombinations(nums, target);
	}
	
	@Test
	public void example2() {
		int[] nums= {2,5,2,1,2};
		int target=5;
		findCombinations(nums, target);
	}
	
	private void findCombinations(int[] nums,int target) {
		List<List<Integer>> output=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		recursionFunction(nums, target, output, new ArrayList<Integer>(), 0);
		System.out.println(output);
	}
	
	private void recursionFunction(int[] nums,int target,List<List<Integer>> output,List<Integer> temp,int start) {
		if(target<=0) {
			if(target==0)
				output.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			if(i>start && nums[i]==nums[i-1])
				continue;
			
			temp.add(nums[i]);
			recursionFunction(nums, target-nums[i], output, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}
}
