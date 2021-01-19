package practice.latest;

import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.Test;

public class W1_KthLargestElement {
	
	/*
	 * 4. Find the kth largest element in an unsorted array. Note: it is Kth largest
	 * element in the sorted order not the kth distinct element.
	 * 
	 * Input: [3,2,3,1,2,4,5,5,6] and k=3 Output: 5
	 */
	
	@Test
	public void eg1() {
		int[] input = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		//System.out.println(kthlarge(input, k));
		System.out.println(kthlargePriorityQueue(input, k));
	}
	
	//@Test
	public void eg2() {
		int[] input = { 3,2,1,5,6,4 };
		int k = 2;
		System.out.println(kthlarge(input, k));
		System.out.println(kthlargePriorityQueue(input, k));
	}
	
	//@Test
	public void eg3() {
		int[] input = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		System.out.println(kthlarge(input, k));
		System.out.println(kthlargePriorityQueue(input, k));
	}
	
	//@Test
	public void eg4() {
		int[] input = { 3, 3 };
		int k = 3;
		System.out.println(kthlarge(input, k));
		System.out.println(kthlargePriorityQueue(input, k));
	}
	
	//@Test
	public void eg5() {
		int[] input = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 5;
		System.out.println(kthlarge(input, k));
		System.out.println(kthlargePriorityQueue(input, k));
	}
	
	private int kthlarge(int[] nums, int k) {
		if(k>nums.length) throw new RuntimeException("Value of K is greater than length of input");
		
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
	
	
	/*
	 * Using Priority Queue
	 * 1. Keep adding the elements to the queue
	 * 2. If the queue size is greater than the k value, remove the head / root element from the queue
	 * 3. Finally at the end of iteration, return the root element of the queue
	 */
	
	
	private int kthlargePriorityQueue(int[] nums, int k) {
		if(k>nums.length) throw new RuntimeException("Value of K is greater than length of input");
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(queue.size() > k) queue.poll();
        }
        return queue.poll();
	}
	
	
	
	
}
