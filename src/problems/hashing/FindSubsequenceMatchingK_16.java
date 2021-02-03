package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindSubsequenceMatchingK_16 {

	//Question:
	/*
	 	Given the integer array, return index of 2 digits whose sum matches the k
		Input: [2, 1, 3, 4]	
		k=5	
		Output: [[0, 2], [1, 3]]
	 */
	
	@Test
	public void example1() {
		int[] nums= {2, 1, 3, 4};
		int k=5;
		System.out.println(bruteForce(nums, k));
		System.out.println(hashingTechnique(nums, k));
	}
	
	//Pseudo code
	/*
	 * Create 2 loop, one for current element and another one to find element whose sum with current element matches target
	 * if sum matches target, add the indices to a list
	 * finally return the list
	 */
	//Space complexity: O[N]
	//Time complexity: O[N^2]
	
	private List<String> bruteForce(int[] nums,int k) {
		List<String> output=new ArrayList<String>();
		for (int cur = 0; cur < nums.length; cur++) {
			for (int other = cur+1; other < nums.length; other++) {
				if(nums[cur]+nums[other]==k)
					output.add(Arrays.toString(new int[] {cur,other}));
			}
		}
		
		return output;
	}
	
	//Pseudo code
	/*
	 * Create a map to store element as key and index as value
	 * if difference of target and current value is present in the map, add its index (value) and current index to list
	 * finally return the output list
	 */
	
	private List<String> hashingTechnique(int[] nums,int k){
		List<String> output=new ArrayList<String>();
		Map<Integer, Integer> elements=new HashMap<Integer, Integer>();

		for(int cur=0;cur<nums.length;cur++) {
			if(elements.containsKey(k-nums[cur]))
				output.add(Arrays.toString(new int[] {elements.get(k-nums[cur]),cur}));
			else
				elements.put(nums[cur], cur);
		}
		return output;
	}
}
