package week12.weekwork;

import java.util.Arrays;

import org.junit.Test;

public class TrapRainWater {
	
	/*
	Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	compute how much water it can trap after raining.
	Input:
	height=[0,1,0,2,1,0,1,3,2,1,2,1]
	output=6
	explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
	In this case, 6 units of rain water (blue section) are being trapped.
	*/
	
	/*
	'=========================================================================================
	' Category	                 : Arrays
	' Approach                   : 2 Pointer
	' Input Parameter            : Input Array
	' Return Value               : Integer
	'=========================================================================================
	*/
	
	
	@Test
	public void eg1() {
		int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Brute Force Approach: "+trap(height));
	}
	
	@Test
	public void eg2() {
		int[] height= {4,2,0,3,2,5};
		System.out.println("Brute Force Approach: "+trap(height));
	}
	
	@Test
	public void eg3() {
		int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Using 2 Pointers "+trapUsing2Pointer(height));
	}
	
	@Test
	public void eg4() {
		int[] height= {4,2,0,3,2,5};
		System.out.println("Using 2 Pointers "+trapUsing2Pointer(height));
	}
	
	
	/*
	 * Brute Force Approach
	 * 1. Declare 3 variables leftmax, rightmax & maxhold
	 * 2. Iterate from the start to the end of array
	 * 3. For each iteration, assign value of leftmax & rightmax to 0
	 * 4. Use 2 inner for loops, one from 0 to current index of i (to find left max)
	 *    and another from i to end of array (to find right max)
	 * 5. For each iteration, get left max as maximum from 0 to current index & right max as maximum from i to end 
	 *    of array
	 * 6. Get the max hold value from left & right max (minimum of left & right max - current index value)
	 * 7. Return the maxhold value
	 * 
	 * Time Complexity: O[N^2]
	 * 
	 */
	
	private int trap(int[] height) {
		int leftmax = 0, rightmax = 0;
		int maxhold = 0;

		for (int i = 0; i < height.length; i++) {
			leftmax = 0;
			rightmax = 0;
			for (int j = 0; j <= i; j++) {
				leftmax = Math.max(leftmax, height[j]);
			}

			for (int k = i; k < height.length; k++) {
				rightmax = Math.max(rightmax, height[k]);
			}

			maxhold += Math.min(leftmax, rightmax) - height[i];
		}
		return maxhold;
	}
	
	
	/*
	 * Alternate Approach using 2 pointer
	 * 
	 * 1. Declare left and right with values of left=0 & right= length-1.
	 * 2. Iterate until value of left < right
	 * 3. Declare temp as 0 and check if input[left]<=input[right]
	 * 4. if input[left]<=input[right] assign value of temp as maximum of temp & input[left]
	 *    add the maxhold as temp-input[i] and increment left
	 * 5. If input[left]> input[right] assign value of temp as maximum of temp & input[right]
	 *    add the maxhold as temp-input[i] and decrement left
	 * 6. Return maxhold
	 * 
	 * Time Complexity: O[N]
	 */
	
	private int trapUsing2Pointer(int[] height){
        int left = 0, right = height.length-1, max = 0, temp = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                temp = Math.max(temp, height[left]);
                max += temp - height[left++];
            } else {
                temp = Math.max(temp, height[right]);
                max += temp - height[right--];
            }
        }
        
        return max;
    }

}
