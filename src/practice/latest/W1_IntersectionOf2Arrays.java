package practice.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class W1_IntersectionOf2Arrays {
	
	/*
	 * Given 2 Integer arrays, return their Intersection.
	 * Intersection is the common elements between the 2 arrays
	 */
	
	@Test
	public void example1() {
	Integer[] firstArray= {1,3,5,4,6,7,9,10,1,5};
	Integer[] secondArray= {0,2,4,8,9,27,4,5,0,2};
	System.out.println(findIntersection(firstArray, secondArray));
	System.out.println(findIntersectionBruteForce(firstArray, secondArray));
	System.out.println(findIntersection2ptr(firstArray, secondArray));
	
	}
	
	@Test
	public void example2() {
	Integer[] firstArray= {1,3,5,3,10,0,89,0,-2,5,-1,7,-2};
	Integer[] secondArray= {0,2,4,8,9,27,4,5,0,2,-1};
	System.out.println(findIntersection(firstArray, secondArray));
	System.out.println(findIntersectionBruteForce(firstArray, secondArray));
	System.out.println(findIntersection2ptr(firstArray, secondArray));
	}
	
	@Test
	public void example3() {
	Integer[] firstArray= {1,3,4,5,7,6,9,19,14,29};
	Integer[] secondArray= {0,2,16,27,51,44,78,90};
	System.out.println(findIntersection(firstArray, secondArray));
	System.out.println(findIntersectionBruteForce(firstArray, secondArray));
	System.out.println(findIntersection2ptr(firstArray, secondArray));
	}
	
	@Test
	public void example4() {
	Integer[] firstArray= {1,1,3,4,5,7,6,9,19,14,29};
	Integer[] secondArray= {1,3,4,5,7,6,9,19,14,29,1};
	System.out.println(findIntersection(firstArray, secondArray));
	System.out.println(findIntersectionBruteForce(firstArray, secondArray));
	System.out.println(findIntersection2ptr(firstArray, secondArray));
	
	}
	
	/*
	 * Brute Force Approach
	 * 1. Add all elements of array 1 to a set and all elements of array 2 to another set
	 * 2. Using set's inbuilt functionality, retain all common elements of set1 & 2
	 * 3. return set 1
	 */
	
	private Set<Integer> findIntersection(Integer[] firstArray, Integer[] secondArray){
		Set<Integer> set1 = new HashSet<>(new ArrayList<>(Arrays.asList(firstArray)));
		Set<Integer> set2 = new HashSet<>(new ArrayList<>(Arrays.asList(secondArray)));
		set1.retainAll(set2);
		return set1;
	}
	
	
	/* Brute Force Approach
	 * 1. Check if both arrays are equal, if so return any one of the array
	 * 2. Use 2 for loops, one to iterate over the 1st array and other to iterate over the 2nd array
	 * 3. If array1 element matches with array 2 element, add it to a set and return the same.
	 * 
	 */
	
	private Set<Integer> findIntersectionBruteForce(Integer[] firstArray,Integer[] secondArray){
		if(firstArray.equals(secondArray)) return new HashSet<>(new ArrayList<>(Arrays.asList(firstArray)));
		
		Set<Integer> set1 = new HashSet<>();
		for(int i=0;i<firstArray.length;i++) {
			for(int j=0;j<secondArray.length;j++) {
				if(firstArray[i]==secondArray[j]) set1.add(firstArray[i]);
			}
		}
		
		return set1;
	}
	
	
	
	/* Intersection using 2 pointers
	 * 1. Sort both the given arrays
	 * 2. Use 2 pointers start & end with value as 0
	 * 3. Iterate until start < arr1.len & end < arr2.len
	 * 4. check if arr1[start]=arr2[end] if so add the element from either of the array and increment start & end
	 * 5. If arr1[start] > arr2[end] increment end to see if next element of arr2 matches arr1
	 * 6. else increment start and return the set finally
	 * 
	 */
	
	private Set<Integer> findIntersection2ptr(Integer[] firstArray, Integer[] secondArray){
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		int start=0, end = 0;
		Set<Integer> set1 = new HashSet<>();
		
		while(start<firstArray.length && end < secondArray.length) {
			if(firstArray[start]==secondArray[end]) 
				{
				set1.add(firstArray[start]);
				start++;
				end++;
				}
			else if(firstArray[start]>secondArray[end]) {
				end++;
			}
			else start++;
				
		}
		
		return set1;
		
		
		}
	
	
	

}
