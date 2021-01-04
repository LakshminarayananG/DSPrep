package week11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class FirstDuplicateNumberInArray {
	
	/*
	Write a function to print the first duplicate number in the array
	Example: [4,1,2,9,1]
	Output: 1
	*/
	
	
	
	//Pseudocode
	/*
	 * add each element to hash
	 * if count of hash becomes 2 then return the number
	 */

	/*
	 * convert array to a string
	 * find if the current element is duplicate
	 * if yes return the integer
	 */

	/*
	 * add value to set
	 * if value already exists return the integer
	 */

	/*
	 * start from an element and iterate till end of the array
	 * if value found return the number
	 */
	
	
	@Test
	public void example1() {
		int[] arr= {4,1,2,9,1};
		System.out.println(printDup(arr));
	}
	
	@Test
	public void example2() {
		int[] arr= {4,4,2,9,1};
		System.out.println(printDup(arr));
	}
	
	@Test
	public void example3() {
		int[] arr= {1,2,3,4};
		System.out.println(printDup(arr));
	}
	
	
	private int printDup(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j])
					return arr[i];
			}
		}
		throw new RuntimeException("No duplicates found");
	}
	
	private int printDup3(int[] arr) {
		Set<Integer> set=new HashSet<>();
		for (int i : arr) {
			if(!set.add(i))
				return i;
		}
		throw new RuntimeException("No duplicates found");
	}
	
	private int printDup2(int[] arr) {
		String op="";
		for(int i:arr)
			op+=i;
		
		for (int i = 0; i < op.length(); i++) {
			if(op.indexOf(op.charAt(i))!=op.lastIndexOf(op.charAt(i)))
				return Integer.parseInt(Character.toString(op.charAt(i)));
		}
		throw new RuntimeException("No duplicates found");
	}
	
	private int printDup1(int[] arr) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int i:arr) {
			map.put(i, map.getOrDefault(i, 0)+1);
			if(map.get(i)==2)
				return i;
		}
		
		throw new RuntimeException("No duplicates found");
	}

}
