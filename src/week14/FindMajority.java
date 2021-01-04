package week14;

import java.util.Arrays;

import org.junit.Test;

public class FindMajority {
	
	/*
	 * Given an array of size n, find the majority element. The majority element is
	 * the element that appears more than n/2 times. You may assume that the array
	 * is non-empty and the majority element always exist in the array. Example 1:
	 * Input: [3,2,3] Output: 3 Example 2: Input: [2,2,1,1,1,2,2] Output: 2 Note:
	 * Should not use built-in methods
	 */
	
	@Test
	public void example1() {
		int[] nums = { 3, 2, 3 };
		System.out.println(findMajorityElement(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(findMajorityElement(nums));
	}

	public int findMajorityElement(int[] data) {

		if (data.length == 1)
			return data[0];

		int count = 0;
		int mid = data.length / 2;
		int left = findMajorityElement(Arrays.copyOfRange(data, 0, mid));
		int right = findMajorityElement(Arrays.copyOfRange(data, mid + 1, data.length));
		for (int num : data) {
			if (num == left)
				count++;

			if (count > data.length / 2)
				return left;
		}
		return right;
	}
	
	private int recursive1(int[] input, int left, int right) {
		if(input[right]==0) return 0;

		if(input[left]==1) return right-left+1;

		int mid=(right+left)/2;
		return recursive1(input, left, mid) + recursive1(input, mid+1, right);
		}

}
