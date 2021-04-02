package week23.weekwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class MaxSubArray {
	
	/**
	 * P1) You are given an array of integers nums, there is a sliding window of
	 * size k which is moving from the very left of the array to the very right. You
	 * can only see the k numbers in the window. Each time the sliding window moves
	 * right by one position.
	 * 
	 * Return the max sliding window.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7]
	 * 
	 * Explanation: Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3
	 * 1 [3 -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3
	 * [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7
	 */
	
	
	@Test
	public void eg1() {
		int[] arr= {1,3,-1,-3,5,3,6,7};
		int k=3;
		System.out.println(maxslidingWind(arr, k));
		System.out.println(maxslidingWind1(arr, k));
	}
	
	@Test
	public void eg2() {
		int[] arr= {3,3,3,3,3,3,3};
		int k=3;
		System.out.println(maxslidingWind(arr, k));
		System.out.println(maxslidingWind1(arr, k));
	}
	
	@Test
	public void eg3() {
		int[] arr= {1,2,3,4,5,6,7};
		int k=2;
		System.out.println(maxslidingWind(arr, k));
		System.out.println(maxslidingWind1(arr, k));
	}
	
	@Test
	public void eg4() {
		int[] arr = {5,4,3,5,4,4,5,3};
		int k = 3;
		System.out.println(maxslidingWind(arr, k));
		System.out.println(maxslidingWind1(arr, k));
	}
	
	
	
	
	private List<Integer> maxslidingWind(int[] arr, int k){
		if(k>arr.length) throw new RuntimeException("Value of K is greater than array");
		int maxval=Integer.MIN_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		for(int i=0;i<k;i++){
			maxval=Math.max(maxval,arr[i]);
			list.add(arr[i]);
		}
		output.add(maxval);
		
		for(int i=k;i<arr.length;i++){
			list.remove(0);
			list.add(arr[i]);
			output.add(Collections.max(list));
		}
		return output;
	}
	
	private List<Integer> maxslidingWind1(int[] arr, int k){
		if(k>arr.length) throw new RuntimeException("Value of K is greater than array");
		int maxval=Integer.MIN_VALUE;
		
		List<Integer> output = new ArrayList<Integer>();
		for(int i=0;i<k;i++){
			maxval=Math.max(maxval,arr[i]);
		}
		output.add(maxval);
		
		for(int i=k;i<arr.length;i++){
			maxval=Math.max(maxval, arr[i]);
			output.add(maxval);
		}
		return output;
	}


}
