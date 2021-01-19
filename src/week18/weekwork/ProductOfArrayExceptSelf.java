package week18.weekwork;

import java.util.Arrays;

import org.junit.Test;

public class ProductOfArrayExceptSelf {
	
	/*
	 * Given an array nums of n integers where n > 1, return an array output such
	 * that output[i] is equal to the product of all the elements of nums except
	 * nums[i].
	 * 
	 * Example:
	 * 
	 * Input: [1,2,3,4] Output: [24,12,8,6] Constraint: It's guaranteed that the
	 * product of the elements of any prefix or suffix of the array (including the
	 * whole array) fits in a 32 bit integer.
	 * 
	 * Note: Please solve it without division and in O(n).
	 */
	
	
	/* Brute Force Approach
	 * 1. Use 2 for loops, both outer & inner loop starting from 0 to n-1
	 * 2. Multiply each element if outer loop index != inner loop index
	 * 3. Return output array
	 */
	
	private int [] arraymultiplication(int[] input) {
		int[] output= new int[input.length];
		for(int i=0;i<input.length;i++) {
			int value=1;
			for(int j=0;j<input.length;j++) {
				if(i!=j) {
					value*=input[j];
				}
			}
			output[i]=value;
		}
		
		return output;
	}
	
	/* Alternate Approach
	 * 1. Declare 2 temporary array of same size as input array
	 * 2. Assign temparr[0] =1 & temparr2[len-1]=1
	 * 3. Iterate from 0 to n-1, temparr[i+1]= temparr[i] * input[i]
	 * 4. Iterate from n-1 to 0, temparr2[i-1]= temparr2[i]* input[1]
	 * 5. Iterate from 0 to n-1, multiply both temp arr indices and store in output
	 * 
	 */
	
	private int[] arraymul(int[] input) {
		int[] output= new int[input.length];
		int[] temp1= new int[input.length];
		int[] temp2= new int[input.length];
		
		temp1[0]=1;
		temp2[input.length-1]=1;
		
		for(int i=0;i<input.length-1;i++) {
			temp1[i+1]=temp1[i]*input[i];
		}
		
		for(int j=input.length-1;j>0;j--) {
			temp2[j-1]=temp2[j]*input[j];
		}
		
		for(int i=0;i<input.length;i++) {
			output[i]=temp1[i]*temp2[i];
		}
		
		return output;
	}
	
	
	/* Alternate Approach
	 * 1. Similar to the previous approach
	 * 2. Instead of 2nd temp array, store the product in a variable and update the same
	 * 
	 */

	private int[] productexceptSelf(int[] nums) {
		int[] output= new int[nums.length];
		output[0]=1;
		for(int i=1;i<nums.length;i++) {
			output[i]=output[i-1]*nums[i-1];
		}
		
		int prod=1;
		for(int i=nums.length-1;i>=0;i--) {
			output[i]=output[i]*prod;
			prod=prod*nums[i];
		}
		
		return output;
	}
	
	@Test
	public void eg1() {
		int[] input= {1,2,3,4};
		System.out.println(Arrays.toString(productexceptSelf(input)));
	}
	
}