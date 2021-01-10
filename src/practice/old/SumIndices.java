package practice.old;

import java.util.Arrays;
import org.junit.Test;
public class SumIndices {

	@Test
	public void example1() {
		int[] numbers = { 2, 3, 1, 4, 7, 5, 19 };
		int target = 6;
		int[] indices = getIndices(numbers, target);
		System.out.println(Arrays.toString(indices));
	}

	@Test
	public void example2() {
		int[] numbers = { 2, 3, 0, 5, 7, 5, 19, 0, -2, 1 };
		int target = 6;
		int[] indices = getIndices(numbers, target);
		System.out.println(Arrays.toString(indices));
	}

	@Test
	public void example3() {
		int[] input = {1,3,4,7,10,12};
		int target = 14;
		int[] indices = getIndices(input, target);
		System.out.println(Arrays.toString(indices));
	}

	@Test
	public void example4() {
		int[] numbers = { 2, 3, 1, 4, 7, 5, 19, 0, -2, 2, 1, 3 };
		int target = 60;
		int[] indices = getIndices(numbers, target);
		System.out.println(Arrays.toString(indices));
	}

	private int[] getIndices(int[] numbers, int target) {
		// Outer for loop
		for (int i = 0; i < numbers.length; i++) {
			// Inner for loop
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					System.out.println("Value of indices are " + i + " and " + j);
					return new int[] { i, j };
				}
			}

		}
		throw new RuntimeException("No matching values found");
	}

}
