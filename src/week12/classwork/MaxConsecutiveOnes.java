package week12.classwork;

import org.junit.Test;

public class MaxConsecutiveOnes {
	
	/*
	* Given an array A of 0s and 1s, you are allowed to change K values from 0
	* to 1. Return the length of the longest (contiguous) subarray that contains
	* only 1s. Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2 Output: 6
	* Input: A = * [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3 Output: 10
	*/

	/*//Approach
	1. Iterate through the input array
	2. Check if the current element is zero
	3. If so, increment total no of zeros by 1 and check if total no of zeroes is > than no. of swaps
	4. if no. of zeroes is > than total swaps, increment from left side & if the value is 0,
	decrement no.of zeros by 1
	5. find total no. of continuous 1's finding max value
	*/


	@Test
	public void eg1() {
	int[] input= {0,0,0,1,1,1,1,0};
	int k=2;
	System.out.println(maxOnes(input, k));
	}

	@Test
	public void eg2() {
	int[] input= {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
	int k=2;
	System.out.println(maxOnes(input, k));
	System.out.println("Alt approach :"+ max1(input, k));


	}


	private int maxOnes(int[] A, int K) {
	int left=0,numofzeroes=0, max1=0;
	for(int i=0;i<A.length;i++) {
	if(A[i]==0) {
	numofzeroes++;
	}

	if(numofzeroes>K) {
	if(A[left]==0) {
	numofzeroes--;
	}
	left++;
	}

	max1=Math.max(max1, i-left+1);
	}

	return max1;

	}



	/*//using 2 pointers
	Move to right, if the input[i]=0, decrement k,
	if k<0,
	if input[left]=0, increment k,
	either case increment left,
	difference between end - start will be length*/

	private int max1(int[] input, int k) {
	int left=0; int right=0;
	for(int i=0;i<input.length;i++) {
	if(input[i]==0) k--;

	if(k<0) {
	if(input[left]==0) {
	k++;
	}
	left++;
	}
	right++;
	}

	return right-left;
	}

}
