package asssignments;

import java.util.Arrays;

import org.junit.Test;

public class ArrayMultiplication {

	/*
	 * Given an array nums of n integers where n > 1, return an array output such
	 * that output[i] is equal to the product of all the elements of nums except
	 * nums[i].
	 * 
	 * Input: [1,2,3,4] Output: [24,12,8,6]
	 */

	@Test
	public void example1() {
		int[] numbers = { 1, 2, 3, 4 };
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}

	@Test
	public void example2() {
		int[] numbers = { 1, 8, 2 };
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}

	@Test
	public void example3() {
		int[] numbers = { 0, 0, 0, 0 };
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}

	@Test
	public void example4() {
		int[] numbers = { 6, 5, 2, 8, 5, 2, 0, 6 };
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}

	@Test
	public void example5() {
		int[] numbers = { 6, -5, 2, 8, 5, -2, 1, 6 };
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}

	@Test
	public void example6() {
		int[] numbers = { 1, 2 };
		int[] multiplyArrayElements = multiplyArray(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}

	// Brute Force Approach
	/*
	 * 1. Iterate through the array 2. Initialize a value as 1 3. Create another for
	 * loop and start with value as 1 4. Check if inner and outer for loop values
	 * are not equal 5. If values are not equal, multiply them till end of loop 6.
	 * return resulting array
	 */

	// Complexity --> O[N^2]
	public int[] multiplyArrayElements(int[] numbers) {
		int[] multipliedArr = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int val = 1;
			for (int j = 0; j < numbers.length; j++) {
				if (i != j) {
					val = val * numbers[j];
				}
			}
			multipliedArr[i] = val;
		}
		return multipliedArr;
	}

	// Alternate APproach -- using temporary array
	// Complexity --> O[N]+O[N]+O[N]
	private int[] multiplyArray(int[] nums) {
		int[] result = new int[nums.length];
		int[] temp1 = new int[nums.length];
		int[] temp2 = new int[nums.length];

		temp1[0] = 1;
		temp2[nums.length - 1] = 1;

		for (int i = 0; i < nums.length - 1; i++) { // O[N]
			temp1[i + 1] = nums[i] * temp1[i];
		}

		for (int i = nums.length - 1; i > 0; i--) { // O[N]
			temp2[i - 1] = temp2[i] * nums[i];
		}

		// multiply two temp arrays
		for (int i = 0; i < nums.length; i++) { // O[N]
			result[i] = temp1[i] * temp2[i];
		}

		return result;
	}

}
