package practice.latest;

import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.Test;

public class W1_ThirdMaxElement {
	
	/*
	 * Given integer array nums, return the third maximum number in this array. If
	 * the third maximum does not exist, return the maximum number.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,2,1] Output: 1 Explanation: The third maximum is 1. Example
	 * 2:
	 * 
	 * Input: nums = [1,2] Output: 2 Explanation: The third maximum does not exist,
	 * so the maximum (2) is returned instead. Example 3:
	 * 
	 * Input: nums = [2,2,3,1] Output: 1 Explanation: Note that the third maximum
	 * here means the third maximum distinct number. Both numbers with value 2 are
	 * both considered as second maximum.
	 */
	
	//@Test
	public void eg1() {
		int[] input = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(thirdLargest(input));
	}
	
	//@Test
	public void eg2() {
		int[] input = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(thirdLargest(input));
	}
	
	//@Test
	public void eg3() {
		int[] input = { 3, 2, 1 };
		System.out.println(thirdLargest(input));
	}
	
	//@Test
	public void eg4() {
		int[] input = { 1,2 };
		System.out.println(thirdLargest(input));
	}
	
	@Test
	public void eg5() {
		int[] input = { 2,2,3,1 };
		System.out.println(thirdLargest(input));
	}
	
	
	
	private int thirdLargest(int [] input) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < input.length; i++) {
            if(!queue.contains(input[i])) queue.add(input[i]);
            if(queue.size() > 3) queue.poll();
        }
        
        if(queue.size()<3){
        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (Integer integer : queue) {
			queue1.add(integer);
		}
            return queue1.peek();
        }
        
        return queue.poll();
	}
	
	
	
	

}
