package week24.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
		 
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]*/

public class Permutations47 {

	@Test
	public void example1() {
		int[] nums = { 1, 1, 2 };
		System.out.println(permuteUnique(nums));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		Arrays.sort(nums);
		recursion(nums, output, new ArrayList<>(), new boolean[nums.length]);
		return output;
	}

	private void recursion(int[] nums, List<List<Integer>> output, List<Integer> temp, boolean[] flag) {
		if (temp.size() == nums.length) {
			output.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (flag[i] || i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])
				continue;
			flag[i] = true;
			temp.add(nums[i]);
			recursion(nums, output, temp, flag);
			flag[i] = false;
			temp.remove(temp.size() - 1);
		}
	}
}
