package assessment.week12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Problem2 {
	
	//Problem
	/*Find the most frequent element in an array
	
	Example:
		1. Input: 4521542101 Output: 1 is repeated 3 times
		2. Input: 1234234 Output: 2,3,4 is repeated twice*/
	
	//Approach
	/*1. Iterate through the array
	2. Declare a map with Integer as key & Integer as value
	3. Iterate through the input array and add to map
	4. Iterate through the map values and add it to list and sort it, get last element
	5. Iterate through map and if value matches the last element, add to output list and return it*/
	
	@Test
	public void eg1() {
		int[] input= {4,5,2,1,5,4,2,1,0,1};
		System.out.println("Example 1: "+maxrepeatedvalue(input));
	}
	
	@Test
	public void eg2() {
	int[] input= {1,2,3,4,2,3,4};
	System.out.println("Example 2: "+maxrepeatedvalue(input));
	}
	
	private List<Integer> maxrepeatedvalue(int[] input){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<Integer> output= new ArrayList<Integer>();
		List<Integer> listn= new ArrayList<Integer>();
		

		for(int i=0;i<input.length;i++) {
			map.put(input[i], map.getOrDefault(map.get(input[i]), 0)+1);
		}
		
		for (Entry<Integer, Integer> integer : map.entrySet()) {
			listn.add(integer.getValue());
		}
		
		Collections.sort(listn);
		
		for (Entry<Integer, Integer> value : map.entrySet()) {
			if(value.getValue()==listn.get(listn.size()-1)) output.add(value.getKey());
		}
			
		return output;
	}
	
	
	
	private String findDuplicates(int[] inp) {
		if (inp.length < 2)
			throw new RuntimeException("There is no frequent element in the array");

		int[] nums = new int[10];
		int maxOcc = Integer.MIN_VALUE;
		List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < inp.length; i++) {
			nums[inp[i]]++;

			if (nums[inp[i]] > maxOcc && nums[inp[i]] > 1) {
				maxOcc = nums[inp[i]];
				output.clear();
				output.add(inp[i]);
			} else if (nums[inp[i]] == maxOcc && nums[inp[i]] > 1)
				output.add(inp[i]);
		}

		if (maxOcc == Integer.MIN_VALUE)
			throw new RuntimeException("There is no frequent element in the array");

		return output + " repeating " + maxOcc + " times.";
	}

	// Pseudo code
	// Space complexity: O[N]
	// Time complexity: O[N]
	/*
	 * Add occurance of each element in a hash map find the max value of the
	 * occurance if max value of the occurance is 1 then return no frequent element
	 * in the array else, collect the elements with max occurance as a list using
	 * stream
	 */

	private String findDuplicates1(int[] inp) {
		Map<Integer, Integer> map = new HashMap<>();

		if (inp.length < 2)
			throw new RuntimeException("There is no frequent element in the array");

		for (int i : inp)
			map.put(i, map.getOrDefault(i, 0) + 1);

		int max = Collections.max(map.values());

		if (max < 2)
			throw new RuntimeException("There is no frequent element in the array");

		List<Integer> op = map.entrySet().stream().filter(m -> m.getValue() == max).flatMap(s -> Stream.of(s.getKey()))
				.collect(Collectors.toList());

		return op + " repeated " + max + " times";
	}

}
