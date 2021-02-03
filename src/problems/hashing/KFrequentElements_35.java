package problems.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;



public class KFrequentElements_35 {
	
	/*
	Given a non-empty array of integers, return the k most frequent elements.

	Example 1:
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]

	Example 2:
	Input: nums = [1], k = 1
	Output: [1]

	Example 3:
	Input: nums = [1,2], k = 2
	Output: [1,2]
	*/

	@Test
	public void example1() {
		int[] nums= {1,1,1,2,2,3};
		int k=2;
		findFrequentElements(nums,k);
	}
	
	@Test
	public void example2() {
		int[] nums= {1};
		int k=1;
		findFrequentElements(nums,k);
	}
	
	@Test
	public void example3() {
		int[] nums= {1,2};
		int k=2;
		findFrequentElements(nums,k);
	}

	private void findFrequentElements(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(b)-map.get(a)));
        for(int ch: map.keySet()) {
            pq.add(ch);
        }
        
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        
        System.out.println(Arrays.toString(result));
	}
}
