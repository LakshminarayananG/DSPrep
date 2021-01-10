package week17.sorting;

import java.util.Arrays;
import org.junit.Test;

public class SelectionSort {
	
	/*
	 * 1. Take the pivot element (left index element)
	 * 2. Find the lowest element in the array
	 * 3. Swap Pivot with the lowest element
	 * 4. Continue step 2 and 3 for next pivot
	 * 
	 * 
	 * Algorithm:
	 * 1. Set Minimum to location 0
	 * 2. Search the minimum element in the list / array
	 * 3. Swap with value at location Minimum
	 * 4. Increment Min to point to the next element
	 * 5. Repeat until the array / list is sorted
	 */

	@Test
	public void eg1() {
		int[] input = { 4, 11, 2, 17, 18, 2, 22, 1, 8 };
		System.out.println(Arrays.toString(selectsort(input)));
	}

	@Test
	public void eg2() {
		int[] input = { 1, 1, 2, 4, 5, 9, 11, 14 };
		System.out.println(Arrays.toString(selectsort(input)));
	}

	@Test
	public void eg3() {
		int[] input = { 8, 2, 5, 6, 18, -5, 12, 15 };
		System.out.println(Arrays.toString(selectsort(input)));
	}

	private int[] selectsort(int[] input) {
		int min;
		for (int i = 0; i < input.length; i++) {
			min = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[min]) {
					min = j;
				}
			}
			int temp = input[i];
			input[i] = input[min];
			input[min] = temp;
		}
		return input;
	}

}
