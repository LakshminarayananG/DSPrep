package week1.classwork;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class IntersectionOf2Arrays {
	
	/*
	 * Given 2 integer arrays, find the intersection of the two arrays.
	 * Intersection is the common elements between the 2 arrays
	 * Input1:[1,2,5,4] Input 2:[2,4,7,9]
	 * Output: [2,4]  
	 */
	
	/*
	 * Approach 1:
	 * 1. Use 2 for loops, one outer for loop and one inner for loop
	 * 2. Iterate through the 1st array in outer for loop, and iterate through the second array in inner for loop
	 * 3. Check if input1[i] & input2[j] are equal, if both are equal, add it to a set and return the same
	 */
	
	/*
	 * Approach 2: Using 2 pointer
	 * 1. Sort both the input arrays using arrays.sort
	 * 2. Declare pointer 1 and pointer 2 as 0
	 * 3. Iterate until pointer 1 < input1.length and pointer2 < input2.length
	 * 4. If both the values match, add the corresponding element to set and increment pointer 1 and 2
	 * 5. If input1[point1] is > input2[point2] increment point 2, else increment point1 and proceed
	 * 6. Return the final set 
	 */
	
	/*
	 * Other Approach:
	 * 1. Add all elements of input 1 to a set
	 * 2. Add all elements of input 2 to another set
	 * 3. Using collections inbuilt function, use set1.retainall(set2) and return set 1
	 */
	
	@Test
	public void eg1() {
		int[] arr1= {1,2,5,4};
		int[] arr2= {2,4,7,9};
		System.out.println(inter(arr1, arr2));
	}
	
	
	@Test
	public void eg2() {
		Integer[] arr1= {1,2,5,4};
		Integer[] arr2= {2,4,7,9};
		System.out.println(intersection(arr1, arr2));
	}
	
	
	@Test
	public void eg3() {
		Integer[] arr1= {1,2,5,4};
		Integer[] arr2= {2,4,7,9};
		System.out.println(intersectionotherapp(arr1, arr2));
	}
	
	private Set<Integer> intersectionotherapp(Integer[] arr1, Integer[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Set<Integer> set= new HashSet<Integer>();
		int p1=0,p2=0;
		while(p1<arr1.length && p2<arr2.length) {
			if(arr1[p1]==arr2[p2]) {
				set.add(arr1[p1]);
				p1++;
				p2++;
			}
			if(arr1[p1]>arr2[p2]) {
				p2++;
			}
			if(arr1[p1]<arr2[p2]) {
				p1++;
			}
		}
		
		return set;
	}
	
	private Set<Integer> inter(int[] arr1, int[] arr2) {
		Set<Integer> set= new HashSet<Integer>();
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					set.add(arr1[i]);
				}
			}
		}
		
		return set;
	}
	
	private Set<Integer> intersection(Integer[] arr1, Integer[] arr2) {
		Set<Integer> set1= new HashSet<Integer>();
		Set<Integer> set2= new HashSet<Integer>();
		Collections.addAll(set1, arr1);
		Collections.addAll(set2, arr2);
		set1.retainAll(set2);
		return set1;
		
	}
	
	
	

}
