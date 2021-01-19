package week18.weekwork;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class TwoSum {
	
	/*
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * You can return the answer in any order.
	 * 
	 * 
	 * 
	 * Example 1: 
	 * Input: nums = [2,7,11,15], target = 9 
	 * 
	 * Output: [0,1] Output: Because nums[0] +
	 * nums[1] == 9, we return [0, 1]. 
	 * 
	 * Example 2: 
	 * Input: nums = [3,2,4], target = 6 Output: [1,2] 
	 * 
	 * Example 3: 
	 * Input: nums = [3,3], target = 6 Output: [0,1]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 2 <= nums.length <= 103 -109 <= nums[i] <= 109 -109 <= target <= 109 Only one
	 * valid answer exists.
	 */
	
	
	/*
	 * Approach
	 * 1. Using Brute Force, 2 for loops, one outer loop & one inner loop
	 * 2. Outer loop to iterate from 0 to n-1 and inner loop to iterate from outer loop +1 to n-1
	 * 3. When outer & inner loop index value matches, return the indices
	 */
	
	/*
	 * Alternate Approach using Hashing
	 * 1. Declare a map and check if the map contains the key as the current index value
	 * 2. If it contains, return the value of the key and the current index
	 * 3. If it doesn't contain, add difference between target and current index value as key and current index
	 *    as value  
	 */
	
	
	@Test
	public void eg1() {
		int[] input= {2,7,11,15};
		int target=9;
		System.out.println(Arrays.toString(twosumbrute(input, target)));
		System.out.println(Arrays.toString(twosumHash(input, target)));
	}
	
	@Test
	public void eg2() {
		int[] input= {3,2,4};
		int target=6;
		System.out.println(Arrays.toString(twosumbrute(input, target)));
		System.out.println(Arrays.toString(twosumHash(input, target)));
	}
	
	@Test
	public void eg3() {
		int[] input= {3,3};
		int target=6;
		System.out.println(Arrays.toString(twosumbrute(input, target)));
		System.out.println(Arrays.toString(twosumHash(input, target)));
	}
	
	
	private int[] twosumbrute(int[] input, int target) {
		if(input.length<2) throw new RuntimeException("Size of Array is less than one");
		for(int i=0;i<input.length;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[i]+input[j]==target) {
					return new int[] {i,j};
				}
			}
		}
		
		throw new RuntimeException("No Matching Indices Found");
	}
	
	
	private int[] twosumHash(int [] input,int target) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<input.length;i++) {
			if(map.containsKey(input[i])) {
				return new int[] {map.get(input[i]),i};
			}
			
			map.put(target-input[i],i);
		}
		
		throw new RuntimeException("No Matching Indices Found");
	}

}