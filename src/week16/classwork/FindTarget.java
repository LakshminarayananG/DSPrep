package week16.classwork;

import org.junit.Test;

public class FindTarget {
	
	/*
	You are given an integer array nums sorted in ascending order and an integer target.
	Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	If target is found in the array return its index, otherwise, return -1.
	Example 1:
	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
	Example 2:
	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1
	Example 3:
	Input: nums = [1], target = 0
	Output: -1
	*/
	
	@Test
	public void example1() {
		int[] nums= {4,5,6,7,0,1,2};
		int target=0;
		System.out.println(findTargetIndex(nums,target));
	}
	
	@Test
	public void example2() {
		int[] nums= {4,5,6,7,0,1,2};
		int target=3;
		System.out.println(findTargetIndex(nums,target));
	}
	
	@Test
	public void example3() {
		int[] nums= {1};
		int target=0;
		System.out.println(findTargetIndex(nums,target));
	}
	
	@Test
	public void example4() {
		int[] nums= {4,5,6,7,0,1,2};
		int target=6;
		System.out.println(findTargetIndex(nums,target));
	}
	
	@Test
	public void example5() {
		int[] nums= {0,1,2,-5,-4,-3,-2};
		int target=-3;
		System.out.println(findTargetIndex(nums,target));
	}
	
	@Test
	public void example6() {
		int[] nums= {5,1,3};
		int target=5;
		System.out.println(findTargetIndex(nums,target));
	}
	
	//Pseudo code
	/*
	 * initialize 2 variables, left and right
	 * where left as 0 and right as end index of the input array
	 * find the mid index as left+right/2
	 * if mid value is equal to target, return the mid
	 * if target is less than mid and target is greater than or equal to left, set right as mid -1
	 * else set left as mid+1
	 * if no match found return -1 
	 */
	
	private int findTargetIndex(int[] nums,int target) {
		int left=0,right=nums.length-1;
		int mid=0;
		
		while(left<=right) {
			mid=(left+right)/2;
			if(nums[mid]==target)
				return mid;
			else if(target<nums[mid] && nums[left]<=target)
				right=mid-1;
			else
				left=mid+1;
		}
		return -1;
		
	}

}
