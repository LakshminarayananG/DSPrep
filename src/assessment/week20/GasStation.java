package assessment.week20;

import org.junit.Assert;
import org.junit.Test;

/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

Example 2:
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
*/

public class GasStation {

	@Test
	public void example1() {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		Assert.assertEquals(3, getMinIndex(gas, cost));
	}

	@Test
	public void example2() {
		int[] gas = { 2, 3, 4 };
		int[] cost = { 3, 4, 3 };
		Assert.assertEquals(-1, getMinIndex(gas, cost));
	}

	@Test
	public void example3() {
		int[] gas = { 3, 2, 5, 4 };
		int[] cost = { 2, 3, 4, 2 };
		Assert.assertEquals(0, getMinIndex(gas, cost));
	}

	@Test
	public void example4() {
		int[] gas = { 2, 4, 5, 2 };
		int[] cost = { 4, 3, 1, 3 };
		Assert.assertEquals(1, getMinIndex(gas, cost));
	}

	@Test
	public void example5() {
		int[] gas = { 8, 4, 1, 9 };
		int[] cost = { 10, 9, 3, 5 };
		Assert.assertEquals(-1, getMinIndex(gas, cost));
	}

	private int getMinIndex(int[] gas, int[] cost) {
		int gasSum = 0, costSum = 0;
		int start = 0, totalTank = 0;

		for (int i = 0; i < gas.length; i++) {
			gasSum += gas[i];
			costSum += cost[i];

			totalTank += gas[i] - cost[i];

			if (totalTank < 0) {
				totalTank = 0;
				start = i + 1;
			}
		}

		if (gasSum < costSum)
			return -1;

		return start;
	}
}
