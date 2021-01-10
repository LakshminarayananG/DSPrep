package assessment.week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FW_MatchingSubarray {

	public List<Integer[]> getIndicesMatchingSum(int[] nums, int target) {

		List<Integer[]> lst = new ArrayList<Integer[]>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				lst.add(new Integer[] { map.get(complement), i });
			}
			map.put(nums[i], i);
		}
		return lst;
	}

	@Test
	public void example1() {

		int[] nums = { 2, 1, 3, 4 };
		int target = 5;

		List<Integer[]> indicesMatchingSum = getIndicesMatchingSum(nums, target);
		for (int i = 0; i < indicesMatchingSum.size(); i++) {
			System.out.println(Arrays.toString(indicesMatchingSum.get(i)));
		}
	}

}
