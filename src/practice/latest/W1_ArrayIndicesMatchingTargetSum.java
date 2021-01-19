package practice.latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class W1_ArrayIndicesMatchingTargetSum {
	
	/*
	 * Given an Integer Array, return the first 2 indices matching the target sum. In case of no matching indices, 
	 * throw exception .
	 * 
	 * Eg: Input: [2,3,1,4,7,5,19] Target Sum=6
	 * O/p: index 0 and index 3 has values 2 & 4 that matches the sum 6.
	 */
	
	
	@Test
	public void example1() {
		int[] numbers = { 2, 3, 1, 4, 7, 5, 19 };
		int target = 6;
		int[] indices = getIndicesMap(numbers, target);
		System.out.println(Arrays.toString(indices));
	}

	@Test
	public void example2() {
		int[] numbers = { 2, 3, 0, 5, 7, 5, 19, 0, -2, 1 };
		int target = 6;
		int[] indices = getIndices(numbers, target);
		System.out.println(Arrays.toString(indices));
	}

	@Test
	public void example3() {
		int[] input = {1,3,4,7,10,12};
		int target = 14;
		int[] indices = getIndices(input, target);
		System.out.println(Arrays.toString(indices));
	}

	@Test
	public void example4() {
		int[] numbers = { 2, 3, 1, 4, 7, 5, 19, 0, -2, 2, 1, 3 };
		int target = 60;
		int[] indices = getIndices(numbers, target);
		System.out.println(Arrays.toString(indices));
	}
	
	
	/*
	 * Brute Force Approach
	 * 1. Iterate from index 0 to len-1
	 * 2. Use 2 for loops, one outer loop and 1 inner loop
	 * 3. Outer for loop to iterate from 0 to len-1 and inner loop to iterate from value of 1st for loop
	 *    to len -1
	 * 4. If sum of the value of outer index and inner index matches the target, return the indices
	 * 5. In case of matching indices found, throw exception
	 */
	
	private int[] getIndices(int[] numbers, int target) {
		// Outer For loop to iterate from 0-len-1
		for(int i=0;i<numbers.length;i++) {
			//Inner For loop to iterate from i to len-1
			for(int j=i+1;j<numbers.length;j++) {
				
				//Check if the sum of index value [i] and [j] matches target
				if(numbers[i]+numbers[j]==target) return new int[] {i,j};
			}
		}
		
		throw new RuntimeException("No Matching Indices Found");
	}
	
	
	/* Alternate Approach Using Hashing
	 * 
	 * 1. Declare a map with integer as key and value
	 * 2. Iterate through the array
	 * 3. Check if the map already has the array element as a key, if it has, get the value of the element and return
	 *    value and current index and return the same.
	 * 4. If it does not have, add target-current index value as key and current index as value
	 * 5. In case of matching indices found, throw exception
	 * 
	 */
	
	private int[] getIndicesMap(int [] numbers, int target) {
		
		Map<Integer,Integer> map = new HashMap<>();
		
		//Iterate through the array
		
		for(int i=0;i<numbers.length;i++) {
			//check if map contains the current index element as key and return value and current index
			if(map.containsKey(numbers[i])) return new int[] {map.get(numbers[i]),i};
			map.put(target-numbers[i], i);
		}
		
		throw new RuntimeException("No Matching Indices");
		
	}
	
	
	
}
