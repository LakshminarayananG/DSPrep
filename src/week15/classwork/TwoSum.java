package week15.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

		/*
		Two Sum II
		int[] nums = {1,4,5,7,8,9,11};
		int k = 12
		[[0,6][1,4][2,3]]
		int[] nums = {1,4,5,7,7,9,11};
		int k = 11
		[[1,3]]
		*/
public class TwoSum {

	@Test
	public void example1() {
		int[] nums = { 1, 4, 5, 7, 8, 9, 11 };
		int k = 12;
		findIndices(nums, k);
	}
	
	@Test
	public void example2() {
		int[] nums = { 1, 4, 5, 7, 7, 9, 11 };
		int k = 11;
		findIndices(nums, k);
	}
	
	private void findIndices(int[] nums,int k) {
		int left=0,right=nums.length-1;
		List<String> list=new ArrayList<>();
		
		while(left<right) {
			if(nums[left]+nums[right]==k)
				list.add(Arrays.toString(new int[] {left++,right--}));
			else if(nums[left]+nums[right]<k)
				left++;
			else if(nums[left]+nums[right]>k)
				right--;
		}
		System.out.println(list);
	}
}
