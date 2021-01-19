package practice.latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class W1_DuplicateElementsInArray {
	
	/*
	 * Given an Integer array, return all the duplicate elements in the array
	 * 
	 */
	
	@Test
	public void eg1() {
		int[] arr = { 2, 1, 3, 1, 3, 1, 4 };
		System.out.println("Method 1");
		duplicateUsingSet(arr);
		duplicatesArrayMap(arr);
	}

	@Test
	public void eg2() {
		int[] arr = { 2, 1, 3, 1, 3, 1, 3, 4 };
		System.out.println("Method 2");
		duplicateUsingSet(arr);
		duplicatesArray(arr);
		duplicatesArrayMap(arr);
	}
	
	/* Approach 1
	 * 1. Using set, try adding the elements to the set and if we are not able to add (already present in the set),
	 * print the element
	 * 
	 */
	private void duplicateUsingSet(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (Integer integer : arr) {
			if(!set.add(integer)) System.out.println(integer+" ");
		}
	}
	
	
	/* Using Arrays Sorting Function
	 * 1. Using the inbuilt function, sort the array 
	 * 2. Iterate through the array and check if the current & previous index elements are same,
	 * 3. If they are, print the element
	 * 
	 */
	
	private void duplicatesArray(int[] arr) {
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==arr[i-1]) set.add(arr[i]);
		}
		System.out.println(set);
	}
	
	/*
	 * Using Map
	 * 1. Add all elements of the array to the map
	 * 2. Iterate over the map and get the values of each Key
	 * 3. If value is >1, print the key
	 */
	
	private void duplicatesArrayMap(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		for (Entry<Integer, Integer> i : map.entrySet()) {
			if(i.getValue()>1) System.out.print(i.getKey()+" ");
		}
		
		
	}
	
	

}
