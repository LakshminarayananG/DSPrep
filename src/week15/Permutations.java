package week15;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Permutations {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3 };
		findPermutations(nums);
		getPermutations(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 3, 4 };
		findPermutations(nums);
		getPermutations(nums);
	}

	@Test
	public void example3() {
		int[] nums = { 0, 1 };
		findPermutations(nums);
		getPermutations(nums);
	}
	
	private void getPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helperFunc(result, nums, 0);
		System.out.println(result);
	}
	
	private void helperFunc(List<List<Integer>> result,int[] nums,int start) {
		if(start==nums.length) {
			List<Integer> temp=new ArrayList<Integer>();
			for(int i:nums)
				temp.add(i);
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			helperFunc(result, nums, start+1);
			swap(nums, start, i);
		}
	}
	
	private void swap(int[] nums,int left,int right) {
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
		return;
	}
	
	private void findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		recursion(result, new ArrayList<Integer>(), nums);
		System.out.println(result);
	}

	private void recursion(List<List<Integer>> result, List<Integer> temp, int[] nums) {
		if (nums.length == temp.size()) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i]))
				continue;

			temp.add(nums[i]);
			recursion(result, temp, nums);
			temp.remove(temp.size() - 1);
		}
	}
}