package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ArrayIntersection {
	
	/*
	Given two arrays,find the intersection of 2 arrays.
	Input: nums1 = [11,2,12,1], nums2 = [2,12]
	Output: [2,12]
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [9,4]
	Algorithm: Use 2 Pointer
	*/

	//Pseudo code
	/*
	sort both the array
	create 2 pointer p1 and p2 for each array respectively
	if p1==p2 add to list
	if p1<p2 increment p1
	else increment p2
	*/
	
	@Test
	public void example1() {
		int[] arr1 = { 11, 2, 12, 1 };
		int[] arr2 = { 2, 12 };
		arrInter(arr1, arr2);
	}

	@Test
	public void example2() {
		int[] arr1 = { 4, 9, 5, 4 };
		int[] arr2 = { 9, 4, 9, 8, 4 };
		arrInter(arr1, arr2);
	}
	
	@Test
	public void example3() {
		int[] arr1 = { 4, 9, 5 };
		int[] arr2 = { 3, 8, 1 };
		arrInter(arr1, arr2);
	}
	
	private void arrInter(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int p1 = 0, p2 = 0;
		List<Integer> list = new ArrayList<>();

		while (p1 < arr1.length && p2 < arr2.length) {
			if (arr1[p1] == arr2[p2]) {
				list.add(arr1[p1++]);
				p2++;
			} else if (arr1[p1] < arr2[p2])
				p1++;
			else
				p2++;
		}
		System.out.println(list);
	}

}
