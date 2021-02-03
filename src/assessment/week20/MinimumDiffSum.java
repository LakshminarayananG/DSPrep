package assessment.week20;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MinimumDiffSum {

	@Test
	public void example1() {
		int[] arr = { 1, 1, 3, 2, 4 };
		Assert.assertEquals(3, minDiffSum(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 5, 1, 3, 7, 3 };
		Assert.assertEquals(6, minDiffSum(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 3, 2 };
		Assert.assertEquals(1, minDiffSum(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 4, 5, 7, 0, 1000, 10, 100, 1000, 10, 0, 0 };
		Assert.assertEquals(1000, minDiffSum(arr));
	}

	private int minDiffSum(int[] arr) {
		Arrays.sort(arr);
		int minDiffSum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			minDiffSum += (arr[i + 1] - arr[i]);
		}

		return minDiffSum;
	}
}
