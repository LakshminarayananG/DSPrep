package week8.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class P4_TrappingRain {

	@Test
	public void example1() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		trappingRain(height);
	}

	@Test
	public void example2() {
		int[] height = { 4, 2, 0, 3, 2, 5 };
		trappingRain(height);
	}

	@Test
	public void example3() {
		int[] height = { 4, 2, 3 };
		trappingRain(height);
	}

	@Test
	public void example4() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		trappingRain(height);
	}
	
	@Test
	public void example5() {
		int[] height = { 5, 4, 2, 3 };
		trappingRain(height);
	}
	
	private void trappingRain(int[] height) {
		//0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
		int left = 0, right = height.length - 1;
	    int ans = 0;
	    int left_max = 0, right_max = 0;
	    while (left < right) {
	        if (height[left] < height[right]) {
	            if(height[left] >= left_max)
	            	left_max = height[left];
	            else
	            	ans += left_max - height[left];			
	            left++;
	        }
	        else {
	            if(height[right] >= right_max)
	            	right_max = height[right];
	            else
	            	ans += right_max - height[right];
	            right--;
	        }
	    }
	    System.out.println(ans);
	}
	
	private void trappingRain1(int[] height) {
		int max = 0, op = 0, cnt = 0;

		for (int i = 0; i < height.length; i++) {
			if (height.length>0 && i == height.length - 1 && height[i] < height[i-1])
				continue;
			if (height[i] >= max) {
				max = height[i];
				cnt = 0;
			}

			if (max - height[i] > 0) {
				op += max - height[i];
				cnt++;
			}
		}

		if (cnt > 1)
			op -= cnt;

		System.out.println(op);
	}
}
