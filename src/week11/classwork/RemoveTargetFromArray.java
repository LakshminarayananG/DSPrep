package week11.classwork;

import java.util.Arrays;
import java.util.Spliterator.OfInt;
import org.junit.Test;

public class RemoveTargetFromArray {
	
	/*
	Given an array of numbers and a specific number (n), remove all instances of that number (n) and return the new length.
	Input: numbers = [0,1,2,2,3,0,4,2], number = 2
	Output: 5
	numbers = [0,1,4,0,3]
	*/
	
	@Test
	public void example1() {
		int[] arr = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int n = 2;
		System.out.println(removeInst(arr, n));
		// removeInst(arr, n);
	}

	@Test
	public void example2() {
		int[] arr = { 1, 1, 1, 1, 1 };
		int n = 1;
		System.out.println(removeInst(arr, n));
		// removeInst(arr, n);
	}

	@Test
	public void example3() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int n = 6;
		System.out.println(removeInst(arr, n));
		// removeInst(arr, n);
	}

	/*
	 * iterate through each element in an array if element is equal to number than
	 * increment the count return total array length-count
	 */
	private int removeInst2(int[] arr, int n) {
		int cnt = 0;

		for (int i : arr)
			if (i == n)
				cnt++;

		return arr.length - cnt;
	}

	/*
	 * find count of n in array create new array of size arr.length-count add
	 * elements in new array without n return size of new array
	 */
	private int removeInst1(int[] arr, int n) {
		int cnt = 0;

		for (int i : arr)
			if (i == n)
				cnt++;
		int[] arr1 = new int[arr.length - cnt];
		cnt = 0;
		for (int i : arr)
			if (i != n)
				arr1[cnt++] = i;

		System.out.println(Arrays.toString(arr1));
		return arr1.length;
	}

	/*
	 * 
	 */
	private int removeInst(int[] arr, int n) {
		int notK = 0, isK = 0;
		while (notK < arr.length) {
			if (arr[notK] != n) {
				int temp = arr[isK];
				arr[isK++] = arr[notK];
				arr[notK++] = temp;
			} else
				notK++;
		}

		//System.out.println(Arrays.toString(arr));
		int[] copyArr = Arrays.copyOfRange(arr, 0, isK);
		System.out.println(Arrays.toString(copyArr));
		return isK;
	}

}
