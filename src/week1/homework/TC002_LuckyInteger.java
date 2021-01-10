package week1.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

/*2) Given an array of integers, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

Input: [1,2,3,3,4,4,4,4,5]
Output: 4
Explanation: 1, 2 and 4 are all lucky numbers, but 4 is the largest*/

public class TC002_LuckyInteger {

	@Test
	public void example1() {
		System.out.println("Method 1");
		int[] input = { 1, 2, 2, 3, 3, 4, 4, 4, 4, 5 };
		int output = bruteForce_2(input);
		System.out.println(output);
	}

	@Test
	public void example2() {
		System.out.println("Method 2");
		int[] input = { 3, 3, 3 };
		int output = bruteForce_2(input);
		System.out.println(output);
	}

	@Test
	public void example3() {
		System.out.println("Method 3");
		int[] input = { 1 };
		int output = bruteForce_2(input);
		System.out.println(output);
	}

	@Test
	public void example4() {
		System.out.println("Method 4");
		int[] input = { 5, 2,2,2,3, 3 };
		int output = bruteForce_2(input);
		System.out.println(output);
	}

	private int bruteForce_1(int[] input) {
		Map<Integer, Integer> map = new HashMap<>();

		/*
		 * for (int a : input) if (map.containsKey(a)) map.put(a, map.get(a) + 1); else
		 * map.put(a, 1);
		 */

		for (int a : input) {
			map.put(a, map.getOrDefault(a, 0)+1);
		}
		
		int max = 0;
		
		for (Map.Entry<Integer, Integer> mp : map.entrySet())
			if (mp.getKey() == mp.getValue())
				max = Math.max(max, mp.getKey());

		if (max != 0)
			return max;
		else
			return -1;

	}
	
	public int bruteForce_2(int[] input) {
		int max=0;
		int count=1;
		for (int i = 0; i < input.length; i++) {
			if(i+1!=input.length && input[i]==input[i+1]) {
				count++;
			}
			else {
				if(input[i]==count) {
					max=Math.max(count, max);
				}
				count=1;
			}
		}
		return max>0?max:-1;
	}
}
