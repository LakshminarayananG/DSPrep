package week17.classwork;

import org.junit.Test;

public class NoOfRotationsInSortedArray {
	
	/*
	 * Consider an array of distinct numbers sorted in increasing order. The array
	 * has been rotated (clockwise) k number of times. Given such an array, find the
	 * value of k.
	 * 
	 * Examples: 
	 * Input : arr[] = {15, 18, 2, 3, 6, 12}
	 * Output: 2 Explanation : Initial array
	 * must be {2, 3, 6, 12, 15, 18}. We get the given array after rotating the
	 * initial array twice.
	 * 
	 * Input : arr[] = {7, 9, 11, 12, 5} Output: 4
	 * 
	 * Input: arr[] = {7, 9, 11, 12, 15}; Output: 0
	 */
	
	
	
	@Test
	public void eg1() {
		int[] input= {15,18,2,3,6,12};
		System.out.println(numberofRotations(input));
		
	}
	
	@Test
	public void eg2() {
		int[] input= {7, 9, 11, 12, 5};
		System.out.println(numberofRotations(input));
		
	}
	
	
	@Test
	public void eg3() {
		int[] input= {7, 9, 11, 12, 15};
		System.out.println(numberofRotations(input));
		
	}
	
	
	/* Approach 1:
	 * 1. Declare 2 variables, minvalue as index[0] element and min index as index 0
	 * 2. Iterate through the array from o to n-1
	 * 3. Check if the minvalue is > index element
	 * 4. If so, assign minvalue as index element and min index as the current index.
	 * 5. Return the min index 
	 */
	
	private int numberofRotations(int[] input) {
		int minvalue=input[0], minindex=0;
		
		for(int i=0;i<input.length;i++) {
			if(minvalue>input[i]) {
				minvalue=input[i];
				minindex=i;
			}
		}		
		return minindex;
	}
	
	
	private int divideConquer(int[] nums, int left, int right) {
		if (left == right || nums[right] > nums[left])
			return left;

		int mid = (left + right) / 2;

		if (mid > left && nums[mid - 1] > nums[mid])
			return mid;

		if (mid < right && nums[mid] > nums[mid + 1])
			return mid + 1;

		if (nums[right] < nums[left])
			return divideConquer(nums, left, mid);
		else
			return divideConquer(nums, mid + 1, right);

	}

}
