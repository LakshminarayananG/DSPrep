package week17.weekwork;

import org.junit.Assert;
import org.junit.Test;

public class KthMissingPositiveInteger {/*
	Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
	Find the kth positive integer that is missing from this array.
	Example 1:
	Input: arr = [2,3,4,7,11], k = 5
	Output: 9
	Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
	Example 2:
	Input: arr = [1,2,3,4], k = 2
	Output: 6
	Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
	*/
	
	@Test
	public void example1() {
		int[] arr= {2,3,4,7,11};
		int k=5;
		Assert.assertEquals(9, findKthPositive(arr, k));
	}
	
	@Test
	public void example2() {
		int[] arr= {1,2,3,4};
		int k=2;
		Assert.assertEquals(6, findKthPositive(arr, k));
	}
	
	public int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (arr[mid] - mid - 1 < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo + k;
    }

}
