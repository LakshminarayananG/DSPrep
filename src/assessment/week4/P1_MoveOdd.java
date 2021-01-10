package assessment.week4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P1_MoveOdd {
	
	/*
	Given an array numbers , write a function to move all odd numbers to
	the end of it while maintaining the relative order of all elements.

	Example:
	Input: [2,1,5,3,12]
	Output: [2,12,1,5,3]

	Note:
	1. You must do this in-place without making a copy of the array.
	2. Minimize the total number of operations.
	*/

	@Test
	public void example() {
		int[] input = { 2, 1, 5, 3, 12 };
		moveOdd(input);
	}

	private void moveOdd1(int[] input) {
		int odd = 0, even = 0;

		while (even < input.length) {
			if (input[even] % 2 == 0) {
				int temp = input[odd];
				input[odd++] = input[even];
				input[even++] = temp;
			} else {
				even++;
			}
		}

		System.out.println(Arrays.toString(input));
	}

	private void moveOdd2(int[] input) {
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();

		for (int i : input)
			if (i % 2 == 0)
				even.add(i);
			else
				odd.add(i);

		even.addAll(odd);

		System.out.println(even);
	}

	private void moveOdd(int[] input) {
		int[] output = new int[input.length];
		List<Integer> odd = new ArrayList<>();
		int ind = 0;
		for (int i : input) {
			if (i % 2 == 0)
				output[ind++] = i;
			else
				odd.add(i);
		}
		int j = 0;
		for (int i = ind; i < output.length; i++) {
			output[i] = odd.get(j++);
		}

		System.out.println(Arrays.toString(output));
	}
}
