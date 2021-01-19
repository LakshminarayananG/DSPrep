package week1.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

public class LuckyInteger {
	
	/*
	 * 2) Given an array of integers, a lucky integer is an integer which has a
	 * frequency in the array equal to its value. Return a lucky integer in the
	 * array. If there are multiple lucky integers return the largest of them. If
	 * there is no lucky integer return -1. Input: [1,2,3,3,4,4,4,4,5] Output: 4
	 * Explanation: 1, 2 and 4 are all lucky numbers, but 4 is the largest
	 */
	
	@Test
	public void example1() {
		int[] numbers= {0,2,3,4,4,4,5,5,6};
		int findLuckyNum = findLuckyNum(numbers);
		System.out.println(findLuckyNum);
	}
	
	
	@Test
	public void example2() {
		int[] numbers= {2,3,4,4,4,5,5,5,5,5,6,7,7,7,7,7,7};
		int findLuckyNum = findLuckyNumOther(numbers);
		System.out.println(findLuckyNum);
	}
	
	@Test
	public void example3() {
		int[] numbers= {2,3,4,4,4,5,5,6,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8};
		int findLuckyNum = findLuckyNumOther(numbers);
		System.out.println(findLuckyNum);
	}
	
	@Test
	public void example4() {
		int[] numbers= {2,3,7,7,7,4,4,4,5,5,6,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8};
		int findLuckyNum = findLuckyNumOther(numbers);
		System.out.println(findLuckyNum);
	}
	
	@Test
	public void example5() {
		int[] numbers= {2,3,7,10,7,7,4,4,4,5,5,6,77,7,7,7,7,8,8,8,8,8,85};
		int findLuckyNum = findLuckyNumOther(numbers);
		System.out.println(findLuckyNum);
	}
	
	
	/* Approach
	 * 1. Iterate through the array and add all the elements to map & occurence as value. Declare initial 
	 *    value of temp as -1 incase if there is no lucky integer, need to return the temp
	 * 2. Iterate through the map and check if integer equals value and if its > temp
	 *    If greater, reassign temp and after all the iteration is completed, return temp
	 * 
	 */
		
	// Overall complexity --> O[1] + O[N] + O[N]
	private int findLuckyNumOther(int[] numbers) {
		Map<Integer,Integer> num = new HashMap<Integer,Integer>(); //O[1]
		int temp=-1; 
		for (int i = 0; i < numbers.length; i++) {  //O[N]
			num.put(numbers[i], num.getOrDefault(numbers[i],0)+1);
		}
		
		for (Entry<Integer, Integer> i : num.entrySet()) { //O[N]
			if(i.getKey().equals(i.getValue())&&i.getValue()>temp) {
				temp=i.getValue();
			}
		}
		return temp;
		
	}
	
	//Brute Force
	private int findLuckyNum(int[] numbers) {
		Map<Integer,Integer> num = new HashMap<Integer,Integer>(); 
		int temp=-1;
		for (int i = 0; i < numbers.length; i++) {
			if(num.containsKey(numbers[i])) {
				num.put(numbers[i], num.get(numbers[i])+1);
			}
			else {
				num.put(numbers[i], 1);
			}
		}
		
		for (Entry<Integer, Integer> i : num.entrySet()) {
			if(i.getKey().equals(i.getValue())&&i.getValue()>temp) {
				temp=i.getValue();
			}
		}
		return temp;
	}
	
	

}
