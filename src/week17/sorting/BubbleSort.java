package week17.sorting;

import java.util.Arrays;
import org.junit.Test;

public class BubbleSort {

	
	/*
	 * Pseudo code: 
	 * 1. use 2 for loops, outer loop to iterate from 0 to len-1 
	 * 2. Inner loop to check for the neighbour element and swap
	 * 
	 * Algorithm:
	 * 1. Compare index 0 & 1
	 * 2. If the left index is greater than the right, swap
	 * 3. Continue step 2 from 0 to n
	 * 4. Continue step 2 & 3 from 1 to (n-1)
	 *
	 */

	@Test
	public void eg1() {
		int[] input = { 4, 11, 2, 17, 18, 2, 22, 1, 8 };
		System.out.println(Arrays.toString(bubblesrt(input)));
	}

	@Test
	public void eg2() {
		int[] input = { 1, 1, 2, 4, 5, 9, 11, 14 };
		System.out.println(Arrays.toString(bubblesrt(input)));
	}

	@Test
	public void eg3() {
		int[] input = { 8, 2, 5, 6, 18, -5, 12, 15 };
		System.out.println(Arrays.toString(bubblesrt(input)));
	}

	public int[] bubblesrt(int[] input) {

		for (int i = 0; i < input.length - 1; i++) {
			for (int j = 0; j < input.length - 1 - i; j++) {
				if (input[j] > input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}
		return input;
	}
	
}
