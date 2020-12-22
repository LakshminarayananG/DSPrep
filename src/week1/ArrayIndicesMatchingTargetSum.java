package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ArrayIndicesMatchingTargetSum {
	
	/*
	 * Given an Integer Array, return the 2 indices matching the target sum. In case of no matching indices, 
	 * throw exception .
	 * 
	 * Eg: Input: [2,3,1,4,7,5,19] Target Sum=6
	 * O/p: index 0 and index 3 has values 2 & 4 that matches the sum 6.
	 */
	
	/*
	 * Brute Force Approach
	 * 1. Iterate through the input array 
	 * 2. Use another for loop and check if index value of outer for loop & index value of inner for loop matches
	 *    the sum value.
	 * 3. If it matches the sum value, return the same, else throw exception finally.
	 */
	
	/*
	 * Alternate approach using hashing
	 * 1. Iterate through the input array
	 * 2. Against each value, reduce it from the target sum and store the value as key and index as value in map
	 * 3. Check if map contains key of the value of current index and if its present, return current index
	 *    and the corresponding value from map
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

	
	//Brute Force Approach
	private int[] getIndices(int[] numbers, int target) {
		// Outer For loop
		for (int i = 0; i < numbers.length; i++) {
			// Inner for loop
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new RuntimeException("No Matching indices");
	}
	
	
	//Using Hashing Approach
	private int[] getIndicesMap(int[] numbers, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<numbers.length;i++) {
			if(map.containsKey(numbers[i])) {
				return new int[] {map.get(numbers[i]),i};
			}
			else {
				map.put(target-numbers[i], i);
			}
		}
		
		throw new RuntimeException("No Matching indices");
	}


}
