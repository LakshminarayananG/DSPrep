package problems.hashing;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;



public class SingleOccurElement_34 {
	
	/*
	Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

	Example 1:
	Input: nums = [2,2,1]
	Output: 1

	Example 2:
	Input: nums = [4,1,2,1,2]
	Output: 4

	Example 3:
	Input: nums = [1]
	Output: 1
	*/

	@Test
	public void example1() {
		int[] nums = { 2, 2, 1 };
		Assert.assertEquals(1, singleOccurEl(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 4, 1, 2, 1, 2 };
		Assert.assertEquals(4, singleOccurEl(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1 };
		Assert.assertEquals(1, singleOccurEl(nums));
	}

	private int singleOccurEl(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i : nums)
			if (!set.add(i))
				set.remove(i);

		return set.iterator().next();
	}
}
