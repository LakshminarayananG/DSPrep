package week7.homework;

import org.junit.Test;

public class DietPlanPerformance {

	@Test
	public void eg1() {
		int[] input = { 1, 2, 3, 4, 5 };
		int k = 1;
		int lower = 3;
		int upper = 3;
		System.out.println(perf(input, k, lower, upper));
	}
	
	
	@Test
	public void eg2() {
		int[] input = { 3,2 };
		int k = 2;
		int lower = 0;
		int upper = 1;
		System.out.println(perf(input, k, lower, upper));
	}
	
	@Test
	public void eg3() {
		int[] input = { 6,5,0,0 };
		int k = 2;
		int lower = 1;
		int upper = 5;
		System.out.println(perf(input, k, lower, upper));
	}
	
	@Test
	public void eg4() {
		int[] input = { 6,5,0,0 };
		int k = 2;
		int lower = 15;
		int upper = 5;
		System.out.println(perf(input, k, lower, upper));
	}

	public int perf(int[] input, int k, int lower, int upper) {
		if (k >= 1 && k > input.length) {
			throw new RuntimeException("Value of the k is outside of expected range");
		}

		int max_sum = 0, window_sum = 0;
		for (int i = 0; i < k; i++) {
			window_sum += input[i];
		}
		max_sum = sum(window_sum, lower, upper, max_sum);

		for (int i = k; i < input.length; i++) {
			window_sum += input[i] - input[i - k];
			max_sum = sum(window_sum, lower, upper, max_sum);
		}

		return max_sum;
	}

	public int sum(int window_sum, int lower, int upper, int max_sum) {
		if (window_sum < lower) {
			max_sum = max_sum - 1;
		} else if (window_sum > upper) {
			max_sum = max_sum + 1;
		}
		return max_sum;
	}

}
