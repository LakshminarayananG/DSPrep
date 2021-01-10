package week17.sorting;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort {
	
	/*
	 *  Merge Sort:
	 *  1. Works on Divide & conquer
	 *  2. Recursive approach
	 *  3. Efficient for large data set
	 *  4. Worst Performance is o[NlogN]
	 *  5. Stable sorting and swap doesn't occur unnecessarily
	 */
	
	@Test
	public void example() {
		int[] arr = { 4, 1, 2, 3, 7 ,2,-1};
		System.out.println(Arrays.toString(method1(arr)));
	}
	
	@Test
	public void eg1() {
		int[] input = { 4, 11, 2, 17, 18, 2, 22, 1, 8 };
		System.out.println(Arrays.toString(method1(input)));
	}

	private int[] method1(int arr[]) {
		divide(arr, 0, arr.length-1);
		return arr;
	}

	private void divide(int arr[], int start, int end) {
		if(start == end) {
			return;
		}
		int mid = (end + start) / 2;
			divide(arr, start, mid);
			divide(arr, mid+1, end);
			merge(arr, start, mid, end);

	}

	private void merge(int arr[], int start, int mid, int end) {
		int L[] = Arrays.copyOfRange(arr, start, mid+1);
		int R[] = Arrays.copyOfRange(arr, mid+1, end+1);
		
		int i = 0;
		int j = 0;

		while (i < L.length || j < R.length) {
			if (i < L.length && j < R.length) {
				if (L[i] < R[j]) {
					arr[start++] = L[i++];
				} else {
					arr[start++] = R[j++];
				} 
			}else if(i < L.length) {
				arr[start++] = L[i++];
			}else {
				arr[start++] = R[j++];
			}
		}

	}

}
