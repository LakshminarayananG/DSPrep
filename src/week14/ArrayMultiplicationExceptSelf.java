package week14;

import java.util.Arrays;

import org.junit.Test;

public class ArrayMultiplicationExceptSelf {
	
	/*
	 * Given an array nums of n integers where n > 1, return an array output such
	 * that output[i] is equal to the product of all the elements of nums except
	 * nums[i]. Example: Input: [1,2,3,4] Output: [24,12,8,6] Constraint: It's
	 * guaranteed that the product of the elements of any prefix or suffix of the
	 * array (including the whole array) fits in a 32 bit integer. Note: Please
	 * solve it without division and in O(n). Follow up: Could you solve it with
	 * constant space complexity? (The output array does not count as extra space
	 * for the purpose of space complexity analysis.)
	 */
	
	
	@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(prdtOfArray(nums)));
	}

	@Test
	public void example2() {
		int[] nums = { 4, 5, 1, 8, 2 };
		System.out.println(Arrays.toString(prdtOfArray(nums)));
	}

	private int[] prdtOfArray(int[] nums) {

		int len = nums.length;
		int[] ouput = new int[len];

		ouput[0] = 1;
		for (int i = 1; i < len; i++)
			ouput[i] = ouput[i - 1] * nums[i - 1];

		int rightVar = 1;
		for (int i = len - 2; i >= 0; i--) {
			ouput[i] *= nums[i + 1] * rightVar;
			rightVar *= nums[i + 1];
		}

		return ouput;
	}

	private int[] prdtOfArray2(int[] nums) {
		int l = nums.length;
		int[] temp1 = new int[l];
		int[] temp2 = new int[l];
		temp1[0] = 1;
		temp2[l - 1] = 1;

		for (int start = 1, end = l - 2; start < l && end >= 0; start++, end--) {
			temp1[start] = temp1[start - 1] * nums[start - 1];
			temp2[end] = temp2[end + 1] * nums[end + 1];
		}

		for (int i = 0; i < l; i++)
			nums[i] = temp1[i] * temp2[i];

		return nums;
		/*
		 * int l=nums.length; int temp1[]=new int[l]; temp1[0]=1; for (int i = 1; i < l;
		 * i++) temp1[i]=temp1[i-1]*nums[i-1];
		 * 
		 * int temp2[]=new int[l]; temp2[l-1]=1; for (int i = l-2; i >=0; i--)
		 * temp2[i]=temp2[i+1]*nums[i+1];
		 * 
		 * for (int i = 0; i < l; i++) nums[i]=temp1[i]*temp2[i];
		 */
	}

	private int[] prdtOfArray1(int[] nums) {
		if (nums.length < 2)
			return nums;

		int allPrdt = 1;

		for (int ieach : nums)
			allPrdt *= ieach;

		for (int i = 0; i < nums.length; i++)
			nums[i] = allPrdt / nums[i];

		return nums;
	}

}
