package week20.weekwork;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;



public class LastStoneWeight {
	
	//1046
	
	/*
	Input: [2,7,4,1,8,1]
	Output: 1
	Explanation: 
	We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
	we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
	we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
	we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
	*/

	

	/*
	 * Sort the array
	 * create a variable to get previous value i.e. difference of last 2 elements
	 * keep on subtracting until first element
	 * finally return prev value
	 * 
	 * Space: O[1]
	 * Time: O[N log N]
	 */

	@Test
	public void example1() {
		int[] nums = { 2, 7, 4, 1, 8, 1 };
		Assert.assertEquals(1, lastStoneWeight(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 2, 4, 2 };
		Assert.assertEquals(0, lastStoneWeight(nums));
	}

	private int lastStoneWeight1(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		int prev = Math.abs(nums[len - 1] - nums[len - 2]);

		for (int i = len - 3; i >= 0; i--) {
			prev = Math.abs(prev - nums[i]);
		}

		return prev;
	}

	/*
	 * create a priority queue by passing the constructor with comparator to sort the queue in descending order 
	 * add all the integers to queue
	 * create variable prev to store last 2 element difference and initialize it with first element in queue
	 * update prev by finding difference from each element
	 * iterate until queue size becomes 0
	 * finally return the prev
	 * 
	 * Space: O[N] Time: O[N log N]
	 */
	private int lastStoneWeight(int[] nums) {
		// PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());	//O[log N] -> after 1.8
		Arrays.stream(nums).forEach(each -> pq.offer(each));
		// int prev = pq.poll();

		while (pq.size() > 1) {
			// prev = Math.abs(prev - pq.poll());
			pq.offer(pq.poll() - pq.poll());
		}

		// return prev;
		return pq.poll();
	}
}
