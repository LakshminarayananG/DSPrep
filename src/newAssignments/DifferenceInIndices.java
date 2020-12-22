package newAssignments;

import java.util.HashMap;

import org.junit.Test;

public class DifferenceInIndices {
	
	/*
	 * Given an array of integers and an integer k,
	 * 
	 * find out whether there are two distinct indices i and j in the array such
	 * that nums[i] = nums[j] and the absolute difference between i and j is at most
	 * k. Example 1: Input: nums = [1,2,3,1], k = 3 Output: true Example 2: Input:
	 * nums = [1,0,1,1], k = 1 Output: true Example 3: Input: nums = [1,2,3,1,2,3],
	 * k = 2 Output: false Example 3: Input: nums = [1,2,3,2,2,3], k = 2 Output:
	 * false Hint: Window Sliding from Aravind to everyone: 4:08 AM nums = [0,1,1],
	 * k = 1, is it true?
	 */
	
	/* Approach using sliding window
	 * 1. Declare a hashmap 
	 * 2. Iterate through the array 
	 * 3. Check if map contains the array element, if not add it as key and index as value 
	 * 4. If available already, check if the current index and map value diff is less than k, if so,
	 * true, if not false
	 */
	

	@Test
	public void eg1() {
		int[] input= {1,2,3,1};
		int k=1;
		System.out.println("Example 1: "+indicesdiff(input, k));
	}
	
	@Test
	public void eg2() {
		int[] input= {1,0,1,1};
		int k=1;
		System.out.println("Example 2: "+indicesdiff(input, k));
	}
	
	@Test
	public void eg3() {
		int[] input= {1,2,3,1,2,3,4,2};
		int k=1;
		System.out.println("Example 3: "+indicesdiff(input, k));
	}
	
	@Test
	public void eg4() {
		int[] input= {0,1,1};
		int k=1;
		System.out.println("Example 4: "+indicesdiff(input, k));
	}
	
	private boolean indicesdiff(int[] input, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        boolean result=false;
        for(int i=0;i<input.length;i++) {
        	if(map.containsKey(input[i])) {
        		if(i-map.get(input[i])<=k) {
        			result=true;
        		}
        	}
        	map.put(input[i], i);
        }
        return result;
    }
	
}
