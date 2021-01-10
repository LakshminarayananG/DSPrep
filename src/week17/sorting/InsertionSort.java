package week17.sorting;

import java.util.Arrays;
import org.junit.Test;

public class InsertionSort {
	
	/*
	 * 1. Compare based sorting algorithm
	 * 2. Lower part of the array is always sorted prior to other elements
	 * 3. Algorithm searches the array and move the unsorted elements into sorted array
	 * 
	 * 
	 * Steps:
	 * 1. Check if the first element is greater than neighbor, if so swap both of the elements and sort the left side
	 */

	@Test
	public void eg1() {
		int[] input = { 4, 11, 2, 17, 18, 2, 22, 1, 8 };
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	@Test
	public void eg2() {
		int[] input = { 1, 1, 2, 4, 5, 9, 11, 14 };
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	@Test
	public void eg3() {
		int[] input = { 8, 2, 5, 6, 18, -5, 12, 15 };
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	@Test
	public void test1() {
		int[] input = { 11, 4, 17, 18, 2, 22, 1, 8 };
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	@Test
	public void test2() {
		int[] input = { 2, 3, 4, 4, 5, 6, 7, 8, 5 };
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	@Test
	public void test3() {
		int[] input = { 11, 4, 17, -18, 2, 22, 1, 8 };
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	@Test
	public void test4() {
		int[] input = { 1, 5, 8, 12, 22, 35, 67, 89 };
		System.out.println(Arrays.toString(insertionSort(input)));
	}

	public int[] insertionSort(int[] input) {

		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] > input[i + 1]) {
				int temp = input[i];
				input[i] = input[i + 1];
				input[i + 1] = temp;
			}
			for (int j = i; j >= 1 && input[j] < input[j - 1]; j--) {
				int temp = input[j];
				input[j] = input[j - 1];
				input[j - 1] = temp;
			}
		}
		return input;

	}

}
