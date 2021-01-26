package week19.classwork;

import java.util.Arrays;
import java.util.Iterator;
import org.junit.Test;

public class FindMinSumSubArray {
	
	/*
	Amazon
	Given an integer array, find the contiguous sub array of length k, with the minimum sum !!
	Return Sub array
	Return empty array when you k > array.length
	Return the first minimum sub array when multiple matches
	*/

	//Pseudo code
	//Brute force
	/*
	 * create 2 for loop -> one for starting and another one for ending
	 * from starting add k elements to get the sum of the window
	 * if the sum is less than previous minimum, set the current window as window with min sum
	 * iterate till array length-k elements in start loop
	 * finally return the min window array
	 * 
	 * Space: O[N]
	 * Time: O[N^2]
	 */

	//Sliding window
	/*
	 * add k elements and find the sum of first window and set first window as window with min sum
	 * slide through the array
	 	* add end element to window
	 	* remove start element from window
	 * if the sum of subarray is less than the previous sum then set the current window as window with min sum
	 * iterate till end of the array and return the window with min sum
	 * 
	 * Space:O[N]
	 * Time: O[N]
	 */

	//Kandane
	/*
	 * 
	 */
	
	@Test
	public void example1() {
		System.out.println("Example 1");
		int[] nums = { 5, 1, 7, 3, 1, 2, 4, 6 };
		int k = 3;
		System.out.println(findMinSumWindow(nums, k));
	}

	@Test
	public void example2() {
		System.out.println("Example 2");
		int[] nums = { 1, 2, 3, 4 };
		int k = 4;
		System.out.println(findMinSumWindow(nums, k));
	}

	@Test
	public void example3() {
		System.out.println("Example 3");
		int[] nums = { 1, 2 };
		int k = 3;
		System.out.println(findMinSumWindow(nums, k));
	}

	@Test
	public void example4() {
		System.out.println("Example 4");
		int[] nums = { 4, 2, 1, 1, 2, 1, 3 };
		int k = 3;
		System.out.println(findMinSumWindow(nums, k));
	}

	@Test
	public void example5() {
		System.out.println("Example 5");
		int[] nums = { 4, 2, 3, 1, 2, 1, 3 };
		int k = -1;
		System.out.println(findMinSumWindow(nums, k));
	}

	@Test
	public void example6() {
		System.out.println("Example 5");
		int[] nums = { 1, 2, -4, 5, -6, -1, 3 };
		int k = 2;
		System.out.println(findMinSumWindow(nums, k));
	}

	private String findMinSumWindow(int[] nums, int k) {
		if (nums.length == 0 || k <= 0 || k > nums.length)
			return Arrays.toString(new int[] {});

		if (nums.length == k)
			return Arrays.toString(nums);

		int sum = 0, minSum = 0;

		for (int i = 0; i < k; i++)
			minSum += nums[i];

		sum = minSum;
		int[] output = Arrays.copyOfRange(nums, 0, k);

		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			if (sum < minSum) {
				minSum = sum;
				output = Arrays.copyOfRange(nums, i - k + 1, i + 1);
			}
		}

		return Arrays.toString(output);
	}

	private String findMinSumWindow1(int[] nums, int k) {
		if (nums.length == 0 || k <= 0 || k > nums.length)
			return Arrays.toString(new int[] {});

		if (nums.length == k)
			return Arrays.toString(nums);

		int sum = 0, minSum = Integer.MAX_VALUE;
		int[] output = null;
		for (int start = 0; start < nums.length - k; start++) {
			sum = 0;
			for (int end = start; end < start + k; end++) {
				sum += nums[end];
			}

			if (sum < minSum) {
				minSum = sum;
				output = Arrays.copyOfRange(nums, start, start + k);
			}
		}

		return Arrays.toString(output);
	}
	
	
	@Test
	public void data1() {
		int[] input= {1,2,4,5,2,4,7,0,1};
		int k=3;
		System.out.println(Arrays.toString(minSumArray(input,k)));
		System.out.println(Arrays.toString(minSumArray_WS(input,k)));
	}
	
	@Test
	public void data2() {
		int[] input= {1,2,4,5,2,4,7,0,1,4,2};
		int k=3;
		System.out.println(Arrays.toString(minSumArray(input,k)));
		System.out.println(Arrays.toString(minSumArray_WS(input,k)));
	}
	
	/*Pseudo Code - Brute Force
	 * 
	 * Declare variable: MinSum-Ineteger.Max
	 * 
	 * Two For Loops:
	 * 		Outer for loop - 0 to len-k
	 * 		Inner for loop - i to i+k
	 * 		int currMin = sum of inner for loop (i to k)
	 * 		if(currMin < MinSum) -> Start = i-k, End=i
	 * 		
	 * Return the subArray by using copyOfRange using indexes
	 * 
	 * Time - O(N2)
	 * Space - O(1)
	 */
	
	public int[] minSumArray(int[] input,int k) {
		
		if(k > input.length) return new int[] {};
		
		int minSum=Integer.MAX_VALUE;
		int start=0;int end=0;
		
		for (int i = 0; i <= input.length-k; i++) {
			int currMin=0;
			for (int j = i; j < i+k; j++) {
				currMin=currMin+input[j];
			}
			if(minSum>currMin) {
				minSum=currMin;
				start=i;end=i+k-1;
			}
			
		}
		return Arrays.copyOfRange(input, start, end+1);
	}
	
	/*Pseudo Code - Window Sliding
	 * 
	 * Declare variable: MinSum, Start, end
	 * 
	 * calculate MinSum value iterating from 0 to k
	 * 
	 * 
	 * another for loop - from k to len-1
	 * 		
	 * 		if min > currSum
	 * 			get the start and end
	 * 			
	 */
	
	public int[] minSumArray_WS(int[] input,int k) {
		if(k > input.length) return new int[] {};
		
		int minSum=0;
		
		for (int i = 0; i < k; i++) {
			minSum=minSum+input[i];
		}
		int winSum=minSum;
		int start=0;int end=k-1;
		
		for (int i = k; i < input.length; i++) {
			winSum=winSum+input[i]-input[i-k];
			if(winSum <minSum) {
				minSum=winSum;
				start=i-k+1;end=i;
			}
		}
		return Arrays.copyOfRange(input, start, end+1);
	}

}
