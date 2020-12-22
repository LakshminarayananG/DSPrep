package newAssignments;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class IntersectionOf2Arrays {
	
	/*
	 * 2) Given two arrays,find the intersection of 2 arrays.
	 * 
	 * Input: nums1 = [11,2,12,1], nums2 = [2,12] Output: [2,12]
	 * 
	 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4]
	 */
	
	@Test
	public void eg1() {
		int[] input1= {11,2,12,1};
		int[] input2= {2,12};
		System.out.println(intersection(input1, input2));
	}
	
	@Test
	public void eg2() {
		int[] input1= {9,4,9,8,4};
		int[] input2= {4,9,5};
		System.out.println(intersection(input1, input2));
	}
	
	private Set<Integer> intersection(int[] input1, int[] input2) {	
		int start=0; int end=0;
		Arrays.sort(input1);
		Arrays.sort(input2);
		Set<Integer> out= new HashSet<Integer>();
		
		while(start<input1.length&& end<input2.length) {
			if(input1[start]==input2[end]) {
				out.add(input1[start]);
				start++;
				end++;
			}
			else if(input1[start]<input2[end]) {
				start++;
			}
			else {
				end++;
			}
		}
		
		return out;
	}

}
