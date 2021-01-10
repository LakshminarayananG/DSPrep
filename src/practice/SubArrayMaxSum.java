package practice;

import java.util.Arrays;
import org.junit.Test;

public class SubArrayMaxSum {
	
	/*
	 * Write a program to fetch the sub array of length k from a given array and the
	 * sub array must have maximum sum of all combinations (without sorting the
	 * array)
	 * 
	 * Input: [4,2,11,1,23,2,3,15,14] , k = 3 Output: [11,1,23]
	 * 
	 * Input: [4,2,1,-7,23,2,-3,15,14], k = 4 Output: [2,-3,15,14]
	 * 
	 * Algorithm: Sliding Window
	 */
	
	@Test
	public void eg1() {
		int[] input= {4,2,11,1,23,2,3,15,14};
		int k=3;
		System.out.println(Arrays.toString(subArrayMaxSum(input, k)));
	}
	
	@Test
	public void eg2() {
		int[] input= {4,2,1,-7,23,2,-3,15,14};
		int k=4;
		System.out.println(Arrays.toString(subArrayMaxSum(input, k)));
	}
	
	private int[] subArrayMaxSum(int[] input, int k) {
		int max_sum=0;int start=0, end=0;
		for(int i=0;i<k;i++) {
			max_sum+=input[i];
		}
		
		int current_sum=max_sum;
		for(int i=k;i<input.length;i++) {
			current_sum+=input[i]-input[i-k];
			if(current_sum>max_sum) {
				start=i-k+1;
				end=i;
				max_sum=current_sum;
			}
			
		}
		
		return Arrays.copyOfRange(input, start, end+1);
	}
		
	
}
