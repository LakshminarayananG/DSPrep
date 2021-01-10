package week1.homework;

import java.util.Arrays;

import org.junit.Test;

/*
 Given an array nums of n integers where n>1, return an array output such that output[i] 
 is equal to the product of all the elements of nums except nums[i]
 
 Input: [1,2,3,4]
 Output: [24,12,8,6]
 
 Interview Question from Amazon
*/

// Question: what if the array has a 0? need to be considered?

public class TC006_ProductOfAll {

	@Test
	public void example1() {
		System.out.println("Method 1");
		int[] input = { 1, 2, 3, 4 };
		int[] bruteForce_1 = bruteForce_1(input);
		System.out.println(Arrays.toString(bruteForce_1));
	}

	@Test
	public void example2() {
		System.out.println("Method 2");
		int[] input = { 2, 2, 2, 3 };
		int[] bruteForce_2 = bruteForce_2(input);
		System.out.println(Arrays.toString(bruteForce_2));
	}

	@Test
	public void example3() {
		System.out.println("Method 3");
		int[] input = { 1 };
		int[] bruteForce_2 = bruteForce_2(input);
		System.out.println(Arrays.toString(bruteForce_2));
	}

	@Test
	public void example4() {
		System.out.println("Method 4");
		int[] input = { 1, 3, 9, 0, 8, 4, 5 };
		int[] bruteForce_3 = bruteForce_3(input);
		System.out.println(Arrays.toString(bruteForce_3));
	}

	private int[] bruteForce_1(int[] input) {
		int[] temp = new int[input.length];
		int product;
		for (int i = 0; i < input.length; i++) {
			product = 1;
			for (int j = 0; j < input.length; j++) {
				if (j != i)
					product *= input[j];
			}
			temp[i] = product;
		}

		return temp;
	}

	private int[] bruteForce_2(int[] input) {
		if (input.length > 1) {
			int product = 1;
			for (int i = 0; i < input.length; i++)
				product *= input[i];

			for (int j = 0; j < input.length; j++)
				input[j] = product / input[j];

			return input;
		} else {
			throw new RuntimeException("Array size should be more than 1");
		}
	}

	private int[] bruteForce_3(int[] input) {
		if (input.length > 1) {
			int product = 1;
			for (int i = 0; i < input.length; i++) {
				product *= input[i];
				if (product == 0) {
					throw new RuntimeException("Array contains 0");
				}
			}

			for (int j = 0; j < input.length; j++)
				input[j] = product / input[j];

			return input;
		} else {
			throw new RuntimeException("Array size should be more than 1");
		}
	}
}
