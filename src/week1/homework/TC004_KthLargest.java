package week1.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

import javax.sound.sampled.ReverbType;

import org.junit.Test;

/*
 4. Find the kth largest element in an unsorted array.
 Note: it is Kth largest element in the sorted order not the kth distinct element.
 
 Input: [3,2,3,1,2,4,5,5,6] and k=3
 Output: 5
*/

public class TC004_KthLargest {

	@Test
	public void example1() {
		System.out.println("Method 1");
		int[] input = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		bruteForce_1(input, k);
	}

	@Test
	public void example2() {
		System.out.println("Method 2");
		int[] input = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		bruteForce_1(input, k);
	}

	@Test
	public void example3() {
		System.out.println("Method 3");
		int[] input = { 3, 3 };
		int k = 3;
		bruteForce_1(input, k);
	}

	private void bruteForce_1(int[] input, int k) {
		if (input.length > k) {
			for (int i = 0; i < input.length; i++) {
				int temp = 0;
				for (int j = i + 1; j < input.length; j++) {
					if (input[i] < input[j]) {
						temp = input[i];
						input[i] = input[j];
						input[j] = temp;
					}
				}
			}
			System.out.println(input[k - 1]);
		} else
			throw new RuntimeException(
					"There is no " + k + "th largest element in the array of " + input.length + " elements.");
	}

	private void bruteForce_2(int[] input, int k) {
		if (input.length > k) {
			Arrays.sort(input);
			System.out.println(input[input.length - k]);
		} else
			throw new RuntimeException(
					"There is no " + k + "th largest element in the array of " + input.length + " elements.");

	}

	public void bruteforce_3(int[] input, int k) {
		// Object[] array =
		// Arrays.stream(input).boxed().sorted(Comparator.reverseOrder()).toArray();
		// System.out.println(array[k-1]);
		if (input.length > k) {
			Arrays.sort(input);
			int temp = 0;
			for (int i = 0; i < input.length / 2; i++) {
				temp = input[i];
				input[i] = input[input.length - (i + 1)];
				input[input.length - (i + 1)] = temp;
			}
			System.out.println(input[k - 1]);
		} else
			throw new RuntimeException(
					"There is no " + k + "th largest element in the array of " + input.length + " elements.");
	}
}
