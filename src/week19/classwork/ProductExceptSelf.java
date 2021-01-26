package week19.classwork;

import java.util.Arrays;
import org.junit.Test;

public class ProductExceptSelf {
	
	/*
	Given an array nums of n integers where n > 1,  return an array output such that output[i] 
	is equal to the product of all the elements of nums except nums[i].
	Example:
	Input:  [1,2,3,4]
	Output: [24,12,8,6]
	*/

	//Pseudo code
	//Brute force
	/*
	 * create 2 for loop
	 * multiply all the except current element and assign the current index value as product of other elements
	 * finally return the output
	 * 
	 * Space: O[N]
	 * Time: O[N^2]
	 */

	//Optimized
	/*
	 * Create a output array with same size of input array
	 * initialize first value of the output array as 1
	 * iterate from 2nd value of the input array
	 	* each index value in output array is product of previous index value of input array and previous index value of output array
	 * declare a previous variable
	 * iterate the input array from reverse direction
	 * set last value of output array is product of last value and 1 and set previous as 1
	 * current index value of output array should be product of previous value and previous index value in input array
	 * 
	 * finally return the output array
	 * 
	 * Space: O[N]
	 * Time: O[N]
	 */
	
	
	@Test
	public void example1() {
		System.out.println("Example 1");
		int[] nums = { 1, 2, 3, 4 }; // [24, 12, 8, 6]
		System.out.println(bruteForce(nums));
		System.out.println(optimizedSolution(nums));
	}

	@Test
	public void example2() {
		System.out.println("Example 2");
		int[] nums = { 1, -1, 2, -3, 1 }; // [6, -6, 3, -2, 6]
		System.out.println(bruteForce(nums));
		System.out.println(optimizedSolution(nums));
	}

	@Test
	public void example3() {
		System.out.println("Example 3");
		int[] nums = { 1, 5, 2, 3 }; // [30, 6, 15, 10]
		System.out.println(bruteForce(nums));
		System.out.println(optimizedSolution(nums));
	}

	@Test
	public void example4() {
		System.out.println("Example 4");
		int[] nums = { 0, 2, 3 }; // [6, 0, 0]
		System.out.println(bruteForce(nums));
		System.out.println(optimizedSolution(nums));
	}

	@Test
	public void example5() {
		System.out.println("Example 5");
		int[] nums = { 1 }; // [1]
		System.out.println(bruteForce(nums));
		System.out.println(optimizedSolution(nums));
	}

	private String bruteForce(int[] nums) {
		if (nums.length < 2)
			return Arrays.toString(nums);
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int prdt = 1;
			for (int j = 0; j < nums.length; j++) {
				if (j == i)
					continue;
				prdt *= nums[j];
			}
			output[i] = prdt;
		}

		return Arrays.toString(output);
	}

	private String optimizedSolution(int[] nums) {
		if (nums.length < 2)
			return Arrays.toString(nums);
		
		int len = nums.length;
		int[] output = new int[len];
		output[0] = 1;

		for (int i = 1; i < len; i++)
			output[i] = nums[i - 1] * output[i - 1];
		int prev = 1;

		for (int i = len - 2; i >= 0; i--) {
			prev *= nums[i + 1];
			output[i] *= prev;
		}
		
		return Arrays.toString(output);
	}

}
