package week13.homework;

import org.junit.Test;

public class GreatestSum {
	
	/*
	 * find the greatest sum of numbers based on the k value given:
	 * 
	 * 
	 * input : [10,3,33,5,2,32,21,14,17,8,9] & k=3
	 * 
	 * output :
	 * 
	 * 1) first step you should add every 3 numbers (10,3,33) (3,33,5) (33,5,2)
	 * (5,2,32) (2,32,21) etc.....
	 * 
	 * then you should find the greatest sum out of all these and print it
	 * 
	 * if suppose k=2 then you should go with (10,3) (3,33) (33,5) (5,2) etc.....
	 * 
	 * Note : array values and k value will be provided at the runtime
	 */
	
	@Test
	public void example1() {
		int[] arr = { 10, 3, 33, 5, 2, 32, 21, 14, 17, 8, 9 };
		int k = 3;
		System.out.println(maxSum(arr, k));
		// System.out.println(bruteForce(arr, k));
	}

	@Test
	public void example2() {
		int[] arr = { 10, 3, 33, 5, 2, 32, 21, 14, 17, 8, 9 };
		int k = 1;
		System.out.println(maxSum(arr, k));
		// System.out.println(bruteForce(arr, k));
	}

	@Test
	public void example3() {
		int[] arr = { 2, 2, 2, 2, 2, 2 };
		int k = 3;
		System.out.println(maxSum(arr, k));
		// System.out.println(bruteForce(arr, k));
	}

	@Test
	public void example4() {
		int[] arr = { 10, 3, 33, 5, 2 };
		int k = 10;
		System.out.println(maxSum(arr, k));
		// System.out.println(bruteForce(arr, k));
	}

	@Test
	public void example5() {
		int[] arr = { -10, 3, 33, -5, 2, 1, 5, -6 };
		int k = 3;
		System.out.println(maxSum(arr, k));

	}

	// Window sliding
	// Space complexity: O[1]
	// Time complexity: O[N]
	/*
	 * add first k elements and set it as max sum. when adding k+1 element to the
	 * window, remove first element from the window compare the sum with the max sum
	 * and assign max value to max sum. iterate till end of the array and return the
	 * max sum
	 */
	private int maxSum(int[] arr, int k) {
		if (k <= 0 || arr.length < k) // edge case
			return 0;

		int sum = 0, mSum = 0, start = 0;

		for (int end = 0; end < arr.length; end++) {
			sum += arr[end]; // add sum until end reaches k

			if (end >= k) // if k becomes equal or more than k
				sum -= arr[start++]; // move the window

			mSum = Math.max(mSum, sum); // find max sum for each iteration
		}

		return mSum; // finally return the max value
	}

	// Space complexity: O[1]
	// Time complexity: O[N*M]
	private int bruteForce(int[] arr, int k) {
		if (k <= 0 || arr.length < k)
			return 0;

		int max = 0, sum = 0;
		for (int start = 0; start <= arr.length - k; start++) {
			for (int end = start; end < start + k; end++) {
				sum += arr[end];
			}
			max = Math.max(max, sum);
			sum = 0;
		}

		return max;
	}

}
