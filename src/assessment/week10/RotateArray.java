package assessment.week10;

import java.util.Arrays;

import org.junit.Test;


/*
Given an integer array perform right rotation a given number of times, N
and print the output. N < length of array.

Input: [4,6,3,8,2,9,1,36]
N = 4
Output: [2,9,1,36,4,6,3,8]
*/

public class RotateArray {

	@Test
	public void example1() {
		int[] arr = { 4, 2, 6, 5, 7, 10, 1, 3 };
		int k = 4;
		System.out.println(rotateArray(arr, k));
	}

	@Test
	public void example2() {
		int[] arr = { 4, 2, 6, 5, 7, 10, 1, 3 };
		int k = 5;
		System.out.println(rotateArray(arr, k));
	}

	@Test
	public void example3() {
		int[] arr = { 1, 2, 3 };
		int k = -1;
		System.out.println(rotateArray(arr, k));
	}

	@Test
	public void example4() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 12;
		System.out.println(rotateArray(arr, k));
	}
	
	private String rotateArray(int[] arr, int k) {
		int present,last;
		for (int i = 0; i < k; i++) {
			last=arr[arr.length-1];
			for (int j = 0; j < arr.length; j++) {
				present=arr[j];
				arr[j]=last;
				last=present;
			}
		}
		return Arrays.toString(arr);
	}
	
	private String rotateArray2(int[] arr, int k) {
		if (k < 0 || arr.length == 0)
			throw new RuntimeException("Invalid input");

		if (k % arr.length == 0)
			return Arrays.toString(arr);

		if (k > arr.length)
			k = k % arr.length;

		int l = 0, r = k;

		while (r < arr.length) {
			int temp = arr[l];
			arr[l++] = arr[r];
			arr[r++] = temp;
		}

		if (k < arr.length && k > arr.length / 2) {
			l = arr.length - k;
			int t = l;
			r = arr.length - t;
			while (l < arr.length) {
				int temp = arr[l];
				arr[l++] = arr[r];
				arr[r] = temp;
				r += (r + 1 >= arr.length) ? -(t - 1) : 1;
			}
		}

		return Arrays.toString(arr);

	}

	private String rotateArray1(int[] arr, int k) {

		if (k < 0 || arr.length == 0)
			throw new RuntimeException("Invalid input");

		if (k % arr.length == 0)
			return Arrays.toString(arr);

		if (k > arr.length)
			k = k % arr.length;

		int[] op = new int[arr.length];
		int ind = 0;

		for (int i = k; i < op.length; i++)
			op[ind++] = arr[i];

		for (int i = 0; i < k; i++)
			op[ind++] = arr[i];

		return Arrays.toString(op);
	}
}
