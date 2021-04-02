package week24.weekwork;
//https://leetcode.com/problems/maximum-subarray/discuss/981146/Java-approach-Recursive-DP-Kadane-Divide-and-Conquer
import java.util.Arrays;

import org.junit.Test;

public class HighestSum {

	private int maxsum=Integer.MIN_VALUE;
	
	@Test
	public void example1() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(divideAndConquer(nums));
		System.out.println(kandaneAlgorithm(nums));
	}

	@Test
	public void example2() {
		int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(divideAndConquer(nums));
		//System.out.println(kandaneAlgorithm(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, -5, 2, -3, 7, 1 };
		System.out.println(divideAndConquer(nums));
		//System.out.println(kandaneAlgorithm(nums));
	}

	@Test
	public void example4() {
		int[] nums = { -2, -1 };
		System.out.println(divideAndConquer(nums));
		//System.out.println(kandaneAlgorithm(nums));
	}
	
	private int divideAndConquer(int[] nums) {
		
		return recursion(nums, 0, nums.length-1);
	}
	
	private int recursion(int[] num,int left,int right) {
		
		if(right == left) 
    	{
    		return num[left];
    	}
    	
    	int mid = (left + right)/2;

    	int l = recursion(num, left, mid);
    	int r = recursion(num, mid+1, right);
    	int m = recurseMid(num,left,mid,right);
    	return Math.max(Math.max(l,r), m);
	
	}
	
	private int recurseMid(int[] s, int left, int mid, int right) 
	{
		int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
		int sum = 0, sum1 = 0;
		
		for (int i = mid; i >= left; i--) 
		{
			sum+=s[i];
			if(sum > leftSum) leftSum = sum;
		}
		
		for (int i = mid+1; i <= right; i++) 
		{
			sum1+=s[i];
			if(sum1 > rightSum) rightSum = sum1;
		}
		
		return leftSum+rightSum;
	}
	
	private int kandaneAlgorithm(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int sum = 0, maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxSum = Math.max(sum, maxSum);
			if (sum < 0)
				sum = 0;
		}

		return maxSum;
	}
}
