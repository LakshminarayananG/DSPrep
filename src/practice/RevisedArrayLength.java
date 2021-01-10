package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

public class RevisedArrayLength {
	
	/*
	 * P2) Given an array of numbers and a specific number (n), remove all instances
	 * of that number (n) and return the new length. Input: numbers =
	 * [0,1,2,2,3,0,4,2], number = 2 Output: 5 numbers = [0,1,4,0,3]
	 */
	
	/*
	 * 1. Get the length of the array 
	 * 2. Iterate through the array 
	 * 3. If the current element of the array is = target value mentioned, reduce one from the length of the array 
	 * 4. return revised length of the array
	 */
	
	//Alternate BF approach
	/*
	 * 1. Iterate through the elements of array and add it to map 
	 * 2. Return array length - map.get(element)
	 */
			
	@Test
	public void eg1() {
		int[] input= {6,5,2,8,5,2,0,6,2};
		int target=3;
		System.out.println(revisedArrayLength(input, target));
	}
	
	@Test
	public void eg2() {
		int[] input= {0,1,2,2,3,0,4,2};
		int target=2;
		System.out.println(altrevisedArrayLength(input, target));
	}
	
	private int revisedArrayLength(int[] input, int target) {
		int len = input.length;
		List<Integer> outputlist= new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == target) {
				len -= 1;
			}
			else
				outputlist.add(input[i]);
		}
		System.out.println(outputlist);
		return len;
	}
	
	private int altrevisedArrayLength(int[] input, int target) {
		HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
		List<Integer> outputlist= new ArrayList<Integer>();
		for(int i=0;i<input.length;i++) {
			map.put(input[i], map.getOrDefault(input[i], 0)+1);
			if(input[i]!=target)
				outputlist.add(input[i]);
				
		}
		System.out.println(outputlist);
		return input.length-map.get(target);
	}

}
