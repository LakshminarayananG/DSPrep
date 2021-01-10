package week17.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TwoSum {
	/*
	 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output:
	 * Because nums[0] + nums[1] == 9, we return [0, 1]. Example 2: Input: nums =
	 * [3,2,4], target = 6 Output: [1,2]
	 */

	/*
	 * Approach: 
	 * 
	 * 1. Iterate over the array with 2 for loops, 1 outer & 1 inner for loop 
	 * 2. Outer for loop to start with 0-arr.len-1 and inner for loop from outerloop index+1 to arr.len-1 
	 * 3. If the sum of outer loop index & inner loop index matches, return the indexes, 
	 *    else finally throw an exception with no matching indices
	 */

		/*
	 * Using 2 Pointers (Works only if array is sorted) 
	 * 1. Declare 2 pointers, start & end (0, input.len-1) 
	 * 2. Iterate until start< end 
	 * 3. if start+ end= target,return start & end indices 
	 * 4. If start+end < target, increment start, else increment end
	 * 
	 */

	@Test
	public void eg1() {
		int[] input = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(twosumhash(input, target));
	}

	
	//Brute Force Approach
	private int[] twosumbruteforce(int[] input, int target) {

		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == target) {
					return new int[] { i, j };
				}
			}
		}

		throw new RuntimeException("No Matching Indices");
	}

	
	//Using Hashing concept
	
	/*
	 * Approach 2: Using Hashing 
	 * 1. Iterate over the array 
	 * 2. Declare a map with int, int as key-value pair 
	 * 3. Over the Iteration, check if the map contains key as current index value, 
	 * if not add target-curr index as key and index as value 
	 * 4. If map already has, return the map value of current index value and the current index.
	 *
	 */
	private int[] twosumhash(int[] input, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			if (map.containsKey(input[i])) {
				return new int[] { map.get(input[i]), i };
			}
			map.put(target - input[i], i);
		}

		throw new RuntimeException("No Matching Indices");
	}

}
