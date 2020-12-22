package assignments;

import org.junit.Test;

public class MaxContinuous1 {

	
	/*
	 * P4) Given an array A of 0s and 1s, you are allowed to change K values from 0
	 * to 1. Return the length of the longest (contiguous) subarray that contains
	 * only 1s. Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2 Output: 6 
	 * Input: A = * [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3 Output: 10
	 */
	
	
	
	@Test
	public void eg1() {
		int[] input= {1,1,1,0,0,0,1,1,1,1,0};
		int k=2;
		System.out.println(maxOnes(input, k));
	}
	
	@Test
	public void eg2() {
		int[] input= {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k=2;
		System.out.println(maxOnes(input, k));
	}
	
	
	private int maxOnes(int[] input, int k) {
		int left=0,numofzeroes=0, max1=0;		
		for(int i=0;i<input.length;i++) {
			if(input[i]==0) {
				numofzeroes++;
			}
			
			if(numofzeroes>k) {
				if(input[left]==0) {
				numofzeroes--;
				}
				left++;
			}
			
			max1=Math.max(max1, i-left+1);
		}
		
		return max1;
		
	}
}
