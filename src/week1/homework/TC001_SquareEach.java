package week1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*1) Given an array of integers sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Input: [-8,-3,4,3,10]
Output: [9,9,16,64,100]
*/		

public class TC001_SquareEach {
	
	@Test
	public void testData1() {
		System.out.println("Method 1");
		int[] input= {-8,-3,4,3,10};
		int[] output = bruteForce_1(input);
		System.out.println(Arrays.toString(output));
	}
	
	@Test
	public void testData2() {
		System.out.println("Method 2");
		int[] input= {0,6,11,13,15,16,18};
		int[] output = bruteForce_2(input);
		System.out.println(Arrays.toString(output));
	}
	
	private int[] bruteForce_1(int[] input) {
		
		for (int i = 0; i < input.length; i++) {
			input[i]=(int) Math.pow(input[i], 2);
		}
		Arrays.sort(input);
		return input;
	}
	
	private int[] bruteForce_2(int[] input) {
		Arrays.setAll(input, i->input[i]*input[i]);
		Arrays.sort(input);
		return input;
	}
}
