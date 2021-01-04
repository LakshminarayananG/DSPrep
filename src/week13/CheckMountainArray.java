package week13;

import org.junit.Test;

public class CheckMountainArray {
	
	/*
	 * Given an array of integers arr, return true if and only if it is a valid
	 * mountain array.
	 * 
	 * Recall that arr is a mountain array if and only if:
	 * 
	 * arr.length >= 3 There exists some i with 0 < i < arr.length - 1 such that:
	 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i] arr[i] > arr[i + 1] > ... >
	 * arr[arr.length - 1]
	 * 
	 * Example 1:
	 * 
	 * Input: arr = [2,1] Output: false
	 * 
	 * 
	 * Example 2: Input: arr = [3,5,5] Output: false
	 * 
	 * Example 3: Input: arr = [0,3,2,1] Output: true
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= arr.length <= 104 0 <= arr[i] <= 104
	 * 
	 */
	
	
	@Test
	public void example1() {
		int[] arr = { 0, 2, 3, 4, 5, 2, 1, 0 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 0, 2, 3, 3, 5, 2, 1, 0 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 5, 4, 3, 2, 1 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 0, 3, 2, 1 };
		System.out.println(checkArray(arr));
	}

	@Test
	public void example5() {
		int[] arr = { 1, 2 };
		System.out.println(checkArray(arr));
	}

	private boolean checkArray(int[] arr) {
		if (arr.length < 3)
			return false;

		boolean inc = false, dec = false;

		for (int cur = 1; cur < arr.length; cur++) {
			if (arr[cur] > arr[cur - 1] && !dec)
				inc = true;
			else if (arr[cur] < arr[cur - 1])
				dec = true;
			else
				return false;
		}

		if (!inc || !dec)
			return false;

		return true;
	}

}
