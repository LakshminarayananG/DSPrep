package week24.classwork;

import org.junit.Test;

/*
Find the maximum possible value by inserting '5'
Examples:
input: 1234 -> output: 51234
input: 7643 -> output 76543
input: 0 -> output 50
input: -661 -> output -5661
*/

public class MaxPossibleValue {

	@Test
	public void example1() {
		int inp = 1234;
		System.out.println(findMaxValue(inp));
	}

	@Test
	public void example2() {
		int inp = 7643;
		System.out.println(findMaxValue(inp));
	}

	@Test
	public void example3() {
		int inp = 0;
		System.out.println(findMaxValue(inp));
	}

	@Test
	public void example4() {
		int inp = -661;
		System.out.println(findMaxValue(inp));
	}

	@Test
	public void example5() {
		int inp = -1;
		System.out.println(findMaxValue(inp));
	}

	private int findMaxValue(int number) {
		int insertNumber = 5;

		if (number == 0)
			return insertNumber * 10;

		int neg = number / Math.abs(number);
		number = Math.abs(number);
		int n = number;

		int counter = 0;
		while (n > 0) {
			counter++;
			n /= 10;
		}

		int maxVal = Integer.MIN_VALUE;
		int position = 1;
		for (int i = 0; i <= counter; i++) {
			int newVal = ((number / position) * (position * 10)) + (insertNumber * position) + (number % position);
			if (newVal * neg > maxVal)
				maxVal = newVal * neg;

			position *= 10;
		}

		return maxVal;
	}
}
