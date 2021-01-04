package week14;

import org.junit.Test;

public class CountNumberOf1s {
	
	@Test
	public void example1() {
		int[] nums = { 0, 0, 1, 1, 1, 1, 1 };
		System.out.println(count1(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 0, 0, 0, 0, 1, 1, 1 };
		System.out.println(count1(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 1, 1, 1, 1 };
		System.out.println(count1(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 0, 0, 0, 0, 0 };
		System.out.println(count1(nums));
	}
	
	private int count1(int[] nums) {
		return recursive1(nums, 0, nums.length-1);
	}
	
	private int recursive1(int[] input, int left, int right) {
		if(input[right]==0) return 0;

		if(input[left]==1) return right-left+1;

		int mid=(right+left)/2;
		return recursive1(input, left, mid) + recursive1(input, mid+1, right);
		}

}
