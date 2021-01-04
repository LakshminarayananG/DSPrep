package week12;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortedArray {
	
	/*
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
	 * one sorted array.
	 * 
	 * Note:
	 * 
	 * The number of elements initialized in nums1 and nums2 are m and n
	 * respectively. You may assume that nums1 has enough space (size that is equal
	 * to m + n) to hold additional elements from nums2. 
	 * 
	 * Example: 
	 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
	 * 
	 * Output: [1,2,2,3,5,6]
	 */
	
	
	/*
	'=========================================================================================
	' Category	                 : Arrays
	' Approach                   : 2 Pointers
	' Input Parameter            : Input Array1, Input Array 2, Int m, Int n
	' Return Value               : None
	'=========================================================================================
	*/
	
	
	@Test
	public void eg1() {
		int[] nums1= {1,2,3,0,0,0};
		int[] nums2= {2,5,6};
		int m=3;
		int n=3;
		mergeBruteForce(nums1, m, nums2, n);
	}
	
	@Test
	public void eg2() {
		int[] nums1= {1,2,3,0,0,0};
		int[] nums2= {2,5,6};
		int m=3;
		int n=3;
		merge(nums1, m, nums2, n);
	}
	
	
	
	/*
	 * Brute Force Approach
	 * 1. Iterate from 0 to either m or n
	 * 2. add value of nums1[length-1-i] as nums2[i]
	 * 3. Using arrays.sort, sort the nums1 array
	 * 
	 * Time Complexity:O[NlogN]
	 */
	
	private void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[nums1.length-1-i]=nums2[i];
        }
          Arrays.sort(nums1);
          System.out.println(Arrays.toString(nums1));
    }
	
	
	
	/* Using 2 Pointers
	 * 1. Declare 2 variables with values m-1 and n-1
	 * 2. Iterate until var1+var2 >=0 and check if var2<0, when this condition matches, break the loop
	 * 3. Check if var1 >=0 & input1[var1] > input2[var2]
	 * 4. If condition satisfies, assign input1[i] = input1[var1] and decrement var1
	 * 5. Else assign input1[i] = input2[var2] and decrement var2
	 * 
	 */
	private void merge(int[] nums1, int m, int[] nums2, int n) {
		int first = m - 1;
		int second = n - 1;
		for (int i = m + n - 1; i >= 0; i--) {
			if (second < 0) {
				break;
			}
			if (first >= 0 && nums1[first] > nums2[second]) {
				nums1[i] = nums1[first];
				first--;
			} else {
				nums1[i] = nums2[second];
				second--;
			}

		}
		
		System.out.println(Arrays.toString(nums1));
	}

}
