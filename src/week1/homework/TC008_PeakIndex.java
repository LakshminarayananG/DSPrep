package week1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/*
Find the peak index in the mountain array

Example 1:
Input: arr=[0,1,0]
Output: 1

Example 2:
Input: arr=[0,4,2,0]
Output: 1

Example 3:
Input: arr=[0,10,5,2,0]
Output: 1
*/

public class TC008_PeakIndex {

	@Test
	public void example1() {
		System.out.println("Example 1");
		int[] input = { 1, 2, 3, 4, 5, 3, 2, 1 };
		bruteForce_1(input);
	}

	@Test
	public void example2() {
		System.out.println("Example 2");
		int[] input = { -5, -2, 5, 2, 0 };
		bruteForce_1(input);
	}

	@Test
	public void example3() {
		System.out.println("Example 3");
		int[] input = { 0, 1, 0 };
		bruteForce_1(input);
	}

	@Test
	public void example4() {
		System.out.println("Example 4");
		int[] input = { 1, 5, 2, 4, 6, 8 };
		bruteForce_1(input);
	}

	@Test
	public void example5() {
		System.out.println("Example 5");
		int[] input = { 1, 1, 1 };
		bruteForce_1(input);
	}

	@Test
	public void example6() {
		System.out.println("Example 6");
		int[] input = { 0, 10, 5, 5, 2, 0 };
		bruteForce_1(input);
	}
	
	@Test
	public void example7() {
		System.out.println("Example 7");
		int[] input = { 0, 10 };
		bruteForce_1(input);
	}

	private void bruteForce_1(int[] input) {
		boolean inc = true;
		int peak = 0;
		if (input.length < 3)
			throw new RuntimeException("Given array is not a mountain array");
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] < input[i + 1] && inc) {
				inc = true;
				peak = i + 1;
			} else if (input[i] > input[i + 1]) {
				inc = false;
			} else
				throw new RuntimeException("Given array is not a mountain array");
		}

		System.out.println(peak);
	}

	
}
