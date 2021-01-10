package week17.weekwork;
import java.util.Arrays;

import org.junit.Test;

		/*
		An array A is larger than some array B if for the first index i where A[i] != B[i], A[i] > B[i].
		For example, consider 0-indexing:
		[1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
		[1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.
		A subarray is a contiguous subsequence of the array.
		Given an integer array nums of distinct integers, return the largest subarray of nums of length k.
		 
		Example 1:
		Input: nums = [1,4,5,2,3], k = 3
		Output: [5,2,3]
		Explanation: The subarrays of size 3 are: [1,4,5], [4,5,2], and [5,2,3].
		Of these, [5,2,3] is the largest.
		Example 2:
		Input: nums = [1,4,5,2,3], k = 4
		Output: [4,5,2,3]
		Explanation: The subarrays of size 4 are: [1,4,5,2], and [4,5,2,3].
		Of these, [4,5,2,3] is the largest.
		*/
public class LargestSubarrayLength {

	@Test
	public void example1() {
		int[] nums = { 1, 4, 5, 2, 3 };
		int k = 3;
		System.out.println(Arrays.toString(findLargestSubarray(nums, k)));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 4, 5, 2, 3 };
		int k = 4;
		System.out.println(Arrays.toString(findLargestSubarray(nums, k)));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 1, 1, 3 };
		int k = 3;
		System.out.println(Arrays.toString(findLargestSubarray(nums, k)));
	}

	@Test
	public void example4() {
		int[] nums = { 4, 6, 2, 6, 2, 2, 7 };
		int k = 4;
		System.out.println(Arrays.toString(findLargestSubarray(nums, k)));
	}
	
	@Test
	public void example5() {
		int[] nums = { 4, 0, 6, 0, 2, 6, 2, 2 };
		int k = 3;
		System.out.println(Arrays.toString(findLargestSubarray(nums, k)));
	}
	
	@Test
	public void example6() {
		int[] nums = { 4, 0, 2, 0, 2, 4, 0, 3 };
		int k = 3;
		System.out.println(Arrays.toString(findLargestSubarray(nums, k)));
	}
	
	@Test
	public void example7() {
		int[] nums = { 0, 0, 2, 0, 2, 4, 0, 2 };
		int k = 3;
		System.out.println(Arrays.toString(findLargestSubarray(nums, k)));
	}
	
	private int[] findLargestSubarray1(int[] arr,int k) {
		int maxIndex = 0;
        for(int i=1, j=0; i<=arr.length - k; i++) {
            if(j!=0) j--;
            while (j < k - 1 && arr[i + j] <= arr[maxIndex+j]) 
                j++;
            if(arr[i + j] > arr[maxIndex + j]) 
                maxIndex = i;
        }            
        return Arrays.copyOfRange(arr, maxIndex, maxIndex + k);
	}
	
	//Pseudo code
		/*
		 * Iterate through each element in array
		 * Create a variable previous to store the starting index with larger sub array and initialized as 0
		 * If previous max is less than current value, set previous max as current max
		 * Or if both previous max and current value are equal, compare rest of the elements in sub array and set previous max accordingly
		 * Finally return the larger sub array with size k
		 */
		//Space complexity: O[N]
		//Time complexity: O[N*M]
	private int[] findLargestSubarray(int[] nums, int k) {
		if (nums.length < k)
			throw new RuntimeException("Invalid input");

		int prev = 0;
		for (int i = 1, inc = 0; i <= nums.length - k; i++) {
			if (nums[prev] < nums[i])
				prev = i;
			inc = 0;
			while (nums[prev] == nums[i] && inc++ < k - 1 && nums[prev + inc] <= nums[i + inc]) {
				if (nums[prev + inc] < nums[i + inc]) {
					prev = i;
					break;
				}
			}
		}

		return Arrays.copyOfRange(nums, prev, prev + k);
	}
		
	private int[] slidingWindow(int[] nums, int k) {
		int[] copyOf = Arrays.copyOf(nums, k);
		int start = 1, end = k;

		while (end < nums.length) {
			int[] copyOfRange = Arrays.copyOfRange(nums, start, end + 1);
			for (int i = 0; i < k; i++) {
				if (copyOf[i] < copyOfRange[i]) {
					copyOf = Arrays.copyOf(copyOfRange, k);
					break;
				}
			}
			start++;
			end++;
		}
		return copyOf;
	}

}
