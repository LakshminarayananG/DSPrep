package practice.latest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class W1_LuckyInteger {

	/*
	 * 2) Given an array of integers, a lucky integer is an integer which has a
	 * frequency in the array equal to its value. Return a lucky integer in the
	 * array. If there are multiple lucky integers return the largest of them. If
	 * there is no lucky integer return -1. Input: [1,2,3,3,4,4,4,4,5] Output: 4
	 * Explanation: 1, 2 and 4 are all lucky numbers, but 4 is the largest
	 */
	
	@Test
	public void eg1() {
		int[] input = { 1, 2, 2, 3, 3, 4, 4, 4, 4, 5 };
		System.out.println(luckyInt(input));
	}
	
	@Test
	public void eg2() {
		int[] input = { 3, 3, 3 };
		System.out.println(luckyInt(input));
	}
	
	@Test
	public void eg3() {
		int[] input = { 1 };
		System.out.println(luckyInt(input));
	}
	
	@Test
	public void eg4() {
		int[] input = { 5, 2,2,2,3, 3 };
		System.out.println(luckyInt(input));
	}
	
	private int luckyInt(int[] input) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int temp=-1;
		
		for (int val : input) {
			map.put(val, map.getOrDefault(val, 0)+1);
		}
		
		for (Entry<Integer, Integer> mapval : map.entrySet()) {
			if(mapval.getKey()==mapval.getValue() && mapval.getValue()>temp) temp=mapval.getKey();
		}
		
		return temp;
		
		
		
	}
	
	
}
