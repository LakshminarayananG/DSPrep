package week8.homework;

import org.junit.Test;

public class P5_PaintHouse {

	@Test
	public void example1() {
		int[][] cost = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } }; // 10
		System.out.println(paintHouse(cost));
	}

	@Test
	public void example2() {
		int[][] cost = {}; // 0
		System.out.println(paintHouse(cost));
	}

	@Test
	public void example3() {
		int[][] cost = { { 7, 6, 2 } }; // 2
		System.out.println(paintHouse(cost));
	}

	@Test
	public void example4() {
		int[][] cost = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 19, 3 } }; // 10
		System.out.println(paintHouse(cost));
	}

	private int paintHouse(int[][] cost) {
		int l = cost.length;
		if (l == 0)
			return 0;

		for (int j = 1; j < l; j++) {
			cost[j][0] += Math.min(cost[j - 1][1], cost[j - 1][2]);
			cost[j][1] += Math.min(cost[j - 1][0], cost[j - 1][2]);
			cost[j][2] += Math.min(cost[j - 1][0], cost[j - 1][1]);
		}

		int op = Math.min(Math.min(cost[l - 1][0], cost[l - 1][1]), cost[l - 1][2]);
		return op;
	}
}
