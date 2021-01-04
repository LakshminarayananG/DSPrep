package week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class UniqueTriplets {
	
	/*
	 * Given an array nums of n integers, are there elements a, b, c in nums such
	 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Notice that the solution set must not contain duplicate triplets.
	 * 
	 * Example 1:
	 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] 
	 * 
	 * Example 2:
	 * Input: nums = [] Output: [] 
	 * 
	 * Example 3:
	 * Input: nums = [0] Output: []
	 */
	
	
	/*
	'=========================================================================================
	' Category	                 : Arrays
	' Approach                   : 2 Pointers
	' Input Parameter            : Input Array
	' Return Value               : List of combinations having sum equivalent to Zero
	'=========================================================================================
	*/
	
	@Test
	public void eg1() {
		int[] nums= {-1,0,1,2,-1,-4};
		System.out.println("Using 2 Pointers :"+threeSum(nums));
	}
	
	@Test
	public void eg2() {
		int[] nums= {};
		System.out.println("Using 2 Pointers :"+threeSum(nums));
	}
	
	@Test
	public void eg3() {
		int[] nums= {0};
		System.out.println("Using 2 Pointers :"+threeSum(nums));
	}
	
	@Test
	public void eg4() {
		int[] nums= {-1,0,1,2,-1,-4};
		System.out.println("Using Brute Force :"+threeSumBruteForce(nums));
	}

	
	
	/*
	 * Brute Force Approach
	 * 1. Use 3 for loops and iterate through the array
	 * 2. 1st for loop (I) starting from index, inner for loop (J) starting from I+1 and inner most for loop
	 *    starting from J+1
	 * 3. If sum of nums[I]+nums[J]+nums[K]==0
	 * 4. Add value of nums[I], nums[J] and nums[K] to a list
	 * 5. Using collections.sort, sort the elements and add it to set
	 * 6. Add the set to output list and return the output
	 * 
	 * Time Complexity: O[N^2]
	 */
	private List<List<Integer>> threeSumBruteForce(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		if(nums.length<3) return output;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						Collections.sort(list);
						set.add(list);
					}
				}
			}
		}
		output.addAll(set);
		return output;
	}
	
	
	/*  Using 2 Pointer Approach
	 * 
	 * 1. Exit early if the length of the array is less that 3 
	 * 2. Sort the nums array
	 * 3. Continue with your iteration if you find any element nums[i] same as the
	 *    previous element nums[i-1] 
	 * 4. From each index of nums array, Run through another
	 *    iteration from the immediate next index left till the length of nums array
	 * 5. Compute the sum and if sum == 0 then we add that to our result. Increment the
	 *    left and right pointer to skip the duplicates 
	 * 6. If the sum is less than 0
	 *    increase the left pointer otherwise decrement the right pointer
	 *    
	 * Time Complexity: O[N*M]
	 */
	
	
	private List<List<Integer>> threeSum(int[] nums) {
	       List<List<Integer>> output= new ArrayList<List<Integer>>();
		   Set<List<Integer>> set= new HashSet<List<Integer>>();
			if(nums.length<3) return output;
			Arrays.sort(nums);
			
			for(int i=0;i<nums.length;i++) {
				int start=i+1,end=nums.length-1;
				while(start<end) {
				if(nums[i]+nums[start]+nums[end]==0) {
					set.add(Arrays.asList(nums[i],nums[start],nums[end]));
					start++;
					end--;
			}
				if(nums[i]+nums[start]+nums[end]<0) start++;
				if(nums[i]+nums[start]+nums[end]>0) end--;
				}
			}
			
			output.addAll(set);
			return output;
	    }

}
