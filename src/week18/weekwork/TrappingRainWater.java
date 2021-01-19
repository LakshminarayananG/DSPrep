package week18.weekwork;

import org.junit.Test;

public class TrappingRainWater {
	
	// Leetcode Problem Number 42
	
	/*
	 * Given n non-negative integers representing an elevation map where the width
	 * of each bar is 1, compute how much water it can trap after raining.
	 * 
	 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] 
	 * Output: 6 
	 * Explanation: The above
	 * elevation map (black section) is represented by array
	 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
	 * are being trapped. Example 2:
	 * 
	 * Input: height = [4,2,0,3,2,5] Output: 9
	 * 
	 * 
	 * Constraints:
	 * 
	 * n == height.length 0 <= n <= 3 * 104 0 <= height[i] <= 105
	 */
	
	
	/*
	 * Brute Force Approach
	 * 1. Iterate from 0 to n-1
	 * 2. For each iteration, calculate the maximum value to its left and also to its right
	 * 3. The amount of water that can be stored is the minimum of left & right max - current index value
	 */
	
	
	/* Approach Using 2 Pointer
	 * 1. Declare left pointer as 0 & right as len-1
	 * 2. Iterate until left< right
	 * 3. Check if the value in left <= right, if so, calculate left max and then max value as left max - input val
	 * 4. If not, calculate right max and then max val as right max - input val
	 * 5. return max value
	 */
	
	
	@Test
	public void eg1() {
		int[] input= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(maxrainTrap(input));
		System.out.println(maxTrap2Ptr(input));
		
	}
	
	
	private int maxrainTrap(int[] input) {
		int maxtrap=0;
		for(int i=0;i<input.length;i++) {
			int left_max=0,right_max=0;
			for(int j=0;j<=i;j++) {
				left_max=Math.max(left_max, input[j]);
			}
			
			for(int k=i;k<input.length;k++) {
				right_max=Math.max(right_max, input[k]);
			}
			
			maxtrap+=Math.min(left_max, right_max)- input[i];
		}
		
		return maxtrap;
	}

	
	private int maxTrap2Ptr(int[] input) {
		int max=0, leftmax=0,rightmax=0, left=0,right=input.length-1;
		
		while(left<right) {
			if(input[left]<=input[right]) {
				leftmax=Math.max(leftmax, input[left]);
				max+=leftmax-input[left++];
			}
			else {
				rightmax=Math.max(rightmax, input[right]);
				max+=rightmax-input[right--];
			}
		}
		
		return max;
	}
}