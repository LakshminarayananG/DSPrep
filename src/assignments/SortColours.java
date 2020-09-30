package assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class SortColours {
	
	//Question :Sort Colors

	/*
	 * Given an array nums with n objects colored red, white, or blue, sort them
	 * in-place so that objects of the same color are adjacent, with the colors in
	 * the order red, white, and blue.
	 * 
	 * Here, use the integers 0, 1, and 2 to represent the color red, white, and
	 * blue respectively.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Example 2:
	 * 
	 * Input: nums = [2,0,1] Output: [0,1,2] Example 3:
	 * 
	 * Input: nums = [0] Output: [0] Example 4:
	 * 
	 * Input: nums = [1] Output: [1]
	 */

	@Test
	public void eg1() {
		int[] input = { 0, 2, 1, 0, 1, 2 };
		int[] sortedoutput = sortcolours(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

	@Test
	public void eg2() {
		int[] input = { 0, 2, 1, 0, 1, 2 };
		Object[] sortedoutput = sort(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

	@Test
	public void eg3() {
		int[] input = { 2, 0, 1 };
		Object[] sortedoutput = sort(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

	@Test
	public void eg4() {
		int[] input = { 0 };
		Object[] sortedoutput = sort(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

	@Test
	public void eg5() {
		int[] input = { 1 };
		Object[] sortedoutput = sort(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

	@Test
	public void eg6() {
		Integer[] input = { 0, 2, 1, 0, 1, 2 };
		Object[] sortedoutput = sortApproach(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

	@Test
	public void eg7() {
		Integer[] input = { 0, 2, 0, 1, 1, 1 };
		Object[] sortedoutput = sortApproach(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

	@Test
	public void eg8() {
		Integer[] input = { 0, 1, 0, 0, 0, 0 };
		Object[] sortedoutput = sortApproach(input);
		System.out.println(Arrays.toString(sortedoutput));
	}

//Using Built in functions. Brute force technique.
	private int[] sortcolours(int[] input) {
		Arrays.sort(input);
		return input;
	}

	// Alternate Approach using Map, & List
	/*
	 * 1.Declare count as a hashmap with Integer as key & count of integers as value
	 * 2.Iterate through the input array and add the key & values to Map 
	 * 3.Add All the keys from the map to Input List 
	 * 4.Iterate through the input list.Initialise temp variable as 0 
	 *   and check if its less than the value the frequency of current element in list 
	 * 5.Keep adding the current element from InputList to output list 
	 *   till value of temp is less than the frequency
	 * 6.Reset temp to 0 for next iteration and add all elements to output list &
	 *   return the same
	 */

	private Object[] sort(int[] input) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		List<Integer> inputList = new ArrayList<Integer>();
		List<Integer> outputList = new ArrayList<Integer>();

		// Get the numbers & total count
		for (int i : input) {
			count.put(i, count.getOrDefault(i, 0) + 1);
		}

		inputList.addAll(count.keySet());

		// Iterate through the list and add the number of occurences of the numbers in
		// order
		for (int i = 0; i < inputList.size(); i++) {
			int temp = 0;
			while (temp < count.get(inputList.get(i))) {
				outputList.add(inputList.get(i));
				temp++;
			}
		}

		return outputList.toArray();

	}

	//Alternate Approach using set & List
	/*
	 * 1. Declare an input lust and add all elements from input array to the list 
	 * 2. Add all the elements from the list to the set to get unique elements 
	 * 3. Declare another frequency list. Iterate through the list and get the
	 * 	  frequency of each element present in list using the collections inbuilt
	 * 	  functino 
	 * 4. Iterate through the set and Initialise temp variable as 0 and
	 * 	   check if its less than the value the frequency of current element in list 
	 * 5. Keep adding the current element from InputList to output list till value of
	 * 	  temp is less than the frequency 
	 * 6. Reset temp to 0 for next iteration and add
	 * 	  all elements to output list & return the same
	 */
			   
			   
	private Object[] sortApproach(Integer[] input) {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.addAll(Arrays.asList(input));
		Set<Integer> inputSet = new HashSet<Integer>();
		inputSet.addAll(inputList);
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<Integer> outputList = new ArrayList<Integer>();
		

		for (Integer integer : inputSet) {
			frequencyList.add(Collections.frequency(inputList, integer));
		}

		for (Integer integer : inputSet) {
			int temp = 0;
			while (temp < frequencyList.get(integer)) {
				outputList.add(integer);
				temp++;
			}
			
		}
		return outputList.toArray();
	}

}
