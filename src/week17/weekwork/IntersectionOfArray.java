package week17.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class IntersectionOfArray {
	
	/*
	* 2 Integer Arrays
	* Both can have dups, give intersection between the two, result can be in any order and should
	* not contain dups
	*/


	/*
	* \pseudo code:
	* 1. Sort 2 integer arrays using inbuilt function
	* 2. Declare 2 points start and end as 0
	* 3. Iterate until start< arr1 length and end < arr2 length
	* 4. If both value matches, increment start & end and add element to set
	* 5. if arr1[start] < arr2[end] increment start
	* 6. else increment end
	* 7. return set
	*/
	
	/*
	 * Approach :
	 * 1. Use 2 for loops, one outer for loop and one inner for loop
	 * 2. Iterate through the 1st array in outer for loop, and iterate through the second array in inner for loop
	 * 3. Check if input1[i] & input2[j] are equal, if both are equal, add it to a set and return the same
	 */

	@Test
	public void eg1() {
	int[] input1= {1,4,7,10,11};
	int[] input2= {1,3};
	System.out.println(intersection(input1, input2));
	}

	@Test
	public void eg2() {
	int[] input1= {1,4,7,10,11,3};
	int[] input2= {1,4,3,13,9,10};
	System.out.println(intersection(input1, input2));
	}

	private Set<Integer> intersectionset(Integer[] input1, Integer[] input2){
		Set<Integer> set= new HashSet<>();
		Set<Integer> set1= new HashSet<>();
		set.addAll(new ArrayList<>(Arrays.asList(input1)));
		set1.addAll(new ArrayList<>(Arrays.asList(input2)));
		set1.retainAll(set);
		return set1;
	}
	
	
	private Set<Integer> intersection(int[] input1, int[] input2) {
		int start = 0;
		int end = 0;
		Arrays.sort(input1);
		Arrays.sort(input2);
		Set<Integer> out = new HashSet<Integer>();

		while (start < input1.length && end < input2.length) {
			if (input1[start] == input2[end]) {
				out.add(input1[start]);
				start++;
				end++;
			} else if (input1[start] < input2[end]) {
				start++;
			} else {
				end++;
			}
		}

		return out;
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

}
