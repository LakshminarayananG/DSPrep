package week1.homework;

import org.junit.Test;

/*
 Given an array, return true if and only if the given array A is monotonic
 An array is monotonic if it is either monotone increasing or monotone decreasing.
 
 Input: [1,2,3,3,4,4,4,4,5]
 Output: true
 
 Input: [1,2,5,3,4,4,4,4,5]
 Output: false
 
 Input: [5,4,4,2,1]
 Output: true
*/

public class TC003_Monotonic {

	@Test
	public void example1() {
		System.out.println("Example 1");
		int[] input = { 1, 2, 3, 3, 4, 4, 4, 4, 5 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);

	}

	@Test
	public void example2() {
		System.out.println("Example 2");
		int[] input = { 1, 2, 5, 3, 4, 4, 4, 4, 5 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example3() {
		System.out.println("Example 3");
		int[] input = { 5, 4, 4, 2, 1 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example4() {
		System.out.println("Example 4");
		int[] input = { 5 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example5() {
		System.out.println("Example 5");
		int[] input = { 7, 7, 7 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example6() {
		System.out.println("Example 6");
		int[] input = { -7, -3, 0, 5, 7, 11 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example7() {
		System.out.println("Example 7");
		int[] input = { 8, 5, 3, 1, 0, -6, -5, -4 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example8() {
		System.out.println("Example 8");
		int[] input = { 8, 5, 3, 1, 0, -2, -7, -10 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example9() {
		System.out.println("Example 9");
		int[] input = { -9, -9, -6, -3, -3, -2, -1, 0 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	@Test
	public void example10() {
		System.out.println("Example 10");
		int[] input = { -2, -2, -2, -3, -5, -6, -7, -8, -8, -9, -9, -9, -9 };
		boolean checkMonotone = checkMonotone_1(input);
		System.out.println(checkMonotone);
	}

	private boolean checkMonotone(int[] input) {
		boolean flag = false;
		int len = input.length;
		if (input[0] < input[len - 1]) {
			for (int i = 1; i < len; i++) {
				if (input[i] >= input[i - 1])
					flag = true;
				else {
					flag = false;
					break;
				}
			}
			return flag;
		} else if (input[0] > input[len - 1]) {
			for (int i = 1; i < len; i++) {
				if (input[i] <= input[i - 1])
					flag = true;
				else {
					flag = false;
					break;
				}
			}
			return flag;
		} else
			return false;
	}

	private boolean checkMonotone_1(int[] arr) {

		boolean inc = false;
		boolean dec = false;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i])
				inc = true;
			else if (arr[i - 1] > arr[i])
				dec = true;
			if (inc && dec)
				return false;
		}
		return true;

	}
}
