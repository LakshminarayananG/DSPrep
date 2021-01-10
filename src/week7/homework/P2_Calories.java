package week7.homework;

import org.junit.Test;

public class P2_Calories {

	@Test
	public void example1() {
		int[] input = { 1, 2, 3, 4, 5 }; // 0
		int k = 1, low = 3, up = 3;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example2() {
		int[] input = { 3, 2 }; // 1
		int k = 2, low = 0, up = 1;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example3() {
		int[] input = { 6, 5, 0, 0 }; // 0
		int k = 2, low = 1, up = 5;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example4() {
		int[] input = { 6, 5 };
		int k = 3, low = 1, up = 5;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example5() {
		int[] input = { 6, 5, 6, 5, 6 };
		int k = 2, low = 11, up = 11;
		checkCalories(input, k, low, up);
	}

	private void checkCalories(int[] input, int k, int low, int up) {

		int sum = 0, cal = 0;

		if (input.length < k)
			throw new RuntimeException("Invalid input");

		for (int i = 0; i < k; i++)
			sum += input[i];

		for (int i = k; i <= input.length; i++) {
			if (sum < low)
				cal--;
			else if (sum > up)
				cal++;

			sum += i < input.length ? input[i] - input[i - k] : 0;
		}

		System.out.println(cal);
	}

	private void checkCalories1(int[] input, int k, int low, int up) {

		int i = 0;
		int sum = 0, cal = 0;

		while (i < k)
			sum += input[i++];

		if (sum < low)
			cal--;
		else if (sum > up)
			cal++;

		while (i < input.length) {
			sum += input[i] - input[i - k];
			if (sum < low)
				cal--;
			else if (sum > up)
				cal++;

			i++;
		}

		System.out.println(cal);
	}
}
