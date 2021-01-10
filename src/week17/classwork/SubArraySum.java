package week17.classwork;
import org.junit.Test;

public class SubArraySum {

	/*
	 * Given an integer array nums, find the contiguous subarray (containing at
	 * least one number) which has the largest sum and return its sum
	 *
	 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has
	 * the largest sum = 6.
	 */

	/*
	 * Approach 
	 * 1: Using sliding window 1. Iterate from 1 to len-1 
	 * 2. Declare 2 variables, current max and max -> Both to index 0 of arr 
	 * 3. Check if current max + input[i] < input[i], if so current max = input[i], else current max=
	 * current max+input[i] 4. max -> maximum of currmax and max 5. return max
	 *
	 * If all values are -ve, sliding window will not work.Kandane only will work
	 */

	/*
	 * Brute Force: 
	 * 1. Assign max to index 0 
	 * 2. Iterate form 0 to n-1 in outer for loop, and from outer index to n-1 in inner loop 
	 * 3. Calculate sum 
	 * 4. check max of sum & max value and return max value
	 */

	@Test
	public void eg1() {
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(contiguousbrute(input));
	}

	@Test
	public void eg2() {
		int[] input = { -2, 1, 8, 9, -12, 5 };
		System.out.println(contiguousmaxsum(input));
		System.out.println(contiguousdivide(input));
		
	}

	//Sliding Window Approach
	private int contiguousmaxsum(int[] input) {
		int currsum = input[0];
		int maxsum = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {
			if (currsum + input[i] < input[i])
				currsum = input[i];
			else
				currsum += input[i];

			maxsum = Math.max(currsum, maxsum);

		}
		return maxsum;
	}

	
	//Brute Force Approach
	private int contiguousbrute(int[] input) {
		int maxsum = input[0];
		for (int i = 0; i < input.length; i++) {
			int currsum = 0;
			for (int j = i; j < input.length; j++) {
				currsum += input[j];
				maxsum = Math.max(maxsum, currsum);
			}
		}
		return maxsum;
	}

	
	
	//Kandane Algorithm
	public int maxSubArrayKandane(int[] nums) {
        int max = nums[0];
        int maxOverall = nums[0];
         for (int i=1;i<nums.length;i++){
             max = Math.max(nums[i], max + nums[i]);
             maxOverall = Math.max(maxOverall, max);
         }
        return maxOverall;
   }
	
	
	/*
	 * Divide & Conquer Approach
	 * 
	 * 1. Divide the array and identify the mid point
	 * 2. Calculate the left array sum and right array sum
	 * 3. Calculate the sum of array on the whole
	 */
	
	private int contiguousdivide(int[] input) {
		return divideconq(input, 0, input.length-1);
	}

	private int divideconq(int[] input, int left, int right) {
		if (left == right)
			return input[left];

		int mid = left+ (right-left)/ 2;
		int leftSum = divideconq(input, left, mid);
        int rightSum = divideconq(input, mid+1, right);
        int crossSum = calculatesum(input, left, right,mid);
        
        return Math.max(leftSum, Math.max(rightSum, crossSum));
	}

	private int calculatesum(int[] input, int left, int right, int mid) {
		int leftsum = Integer.MIN_VALUE;
		int rightsum = Integer.MIN_VALUE;

		int sum = 0;
		for (int i = mid; i >= left; i--) {
			sum += input[i];
			leftsum = Math.max(sum, leftsum);
		}

		 sum = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum += input[i];
			rightsum = Math.max(sum, rightsum);
		}

		return leftsum+rightsum;
	}

}
