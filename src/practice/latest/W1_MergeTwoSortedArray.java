package practice.latest;

import java.util.Arrays;

import org.junit.Test;

public class W1_MergeTwoSortedArray {
	
	
	/*
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
	 * one sorted array.
	 * 
	 * The number of elements initialized in nums1 and nums2 are m and n
	 * respectively. You may assume that nums1 has enough space (size that is equal
	 * to m + n) to hold additional elements from nums2.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
	 * Output:
	 * [1,2,2,3,5,6] 
	 * 
	 * Example 2: 
	 * Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 0 <= n, m <= 200 1 <= n + m <= 200 nums1.length == m + n nums2.length == n
	 * -109 <= nums1[i], nums2[i] <= 109
	 */
	
	
	@Test
	public void eg1() {
		int[] arr1= {1,2,3,0,0,0};
		int[] arr2= {2,5,6};
		//mergeSortedArr(arr1, arr2);
		merge(arr1, arr2);
	}
	
	
	private void mergeSortedArr(int[] arr1, int[] arr2) {
		
		for(int i=0;i<arr2.length;i++) {
			arr1[arr1.length-1-i]=arr2[i];
		}
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	
	
	private void merge(int[] arr1, int[] arr2) {
		int len1=arr1.length-1;
		int len2=arr2.length-1;
		int p1=len1-len2; int p2=len2;
		
		while(p2>=0) {
			if(p1<0 && p2>=0) {
				arr1[p2--]=arr2[p2--];
				}
			else if (arr1[p1] > arr2[p2])
				arr1[len1--] = arr1[p1--];
			else
				arr1[len1--] = arr2[p2--];
		}
		
		System.out.println(Arrays.toString(arr1));
	}
	
	

}
