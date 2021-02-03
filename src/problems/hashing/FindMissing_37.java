package problems.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;


public class FindMissing_37 {
	
	/*
	The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, 
	one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
	Given an array nums representing the data status of this set after the error. 
	Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

	Example 1:
	Input: nums = [1,2,2,4]
	Output: [2,3]
	*/

	@Test
	public void example1() {
		int[] nums = { 1, 2, 2, 4 };
		System.out.println(Arrays.toString(findMissingValue(nums)));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 2, 3, 4 };
		System.out.println(Arrays.toString(findMissingValue(nums)));
	}
	
	@Test
	public void example3() {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(findMissingValue(nums)));
	}

	private int[] findMissingValue(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i = 1; i <= nums.length; i++) {
			set.add(i);
		}

		int dup = 0;
		for (int each : nums) {
			if (set.add(each))
				dup = each;
			set.remove(each);
		}
		
		if(set.isEmpty())
			throw new RuntimeException("No duplicates found");
		
		return new int[] { dup, set.iterator().next() };
	}
}
