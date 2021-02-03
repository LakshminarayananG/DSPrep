package problems.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;



public class UniqueTriplets_29 {
	
	/*
	Given an array nums of n integers, 
	are there elements a, b, c in nums such that a + b + c = 0? 
	Find all unique triplets in the array which gives the sum of zero.

	Note that the solution set must not contain duplicate triplets.

	Example 1:

	Input: nums = [-1,0,1,2,-1,-4]
	Output: [[-1,-1,2],[-1,0,1]]

	Example 2:

	Input: nums = []
	Output: []
	*/

	@Test
	public void example1() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(uniqueTriplets(nums));
	}

	@Test
	public void example2() {
		int[] nums = {};
		System.out.println(uniqueTriplets(nums));
	}

	private Set<List<Integer>> uniqueTriplets(int[] nums) {
		if (nums.length < 3) return new HashSet<>();
        Arrays.sort(nums); 
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }

        }

        return set;
	}
}
