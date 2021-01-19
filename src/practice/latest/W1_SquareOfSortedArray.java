package practice.latest;

import java.util.Arrays;
import org.junit.Test;

public class W1_SquareOfSortedArray {

	
	/*
	 * Given an array in sorted order, return the square of the array in sorted order
	 */
	
	
	@Test
	public void eg1() {
		int[] input= {-8,-3,-2,1,2,4,10};
		System.out.println(Arrays.toString(squares(input)));
	}
	
	
	@Test
	public void eg2() {
		int[] input= {-8,-3,-2,1,2,4,7,11};
		System.out.println(Arrays.toString(squares2ptr(input)));
	}
	
	
	/* Approach 1:
	 * 1. Replace each element in the array with the square of the element
	 * 2. Using Arrays.sort, return the sorted square of elements in the array
	 * 
	 */
	
	private int[] squares(int[] input) {
		for (int i = 0; i < input.length; i++) {
			input[i]=input[i]*input[i];
		}
		
		Arrays.sort(input);		
		return input;
	}
	
	
	/* Using 2 Pointers
	 * 1. Declare another array of the same size as input array
	 * 2. Use 2 pointers start=0 and end= len-1
	 * 3. Iterate in reverse order (len-1 to 0)
	 * 4.check if abs value of start > end, if so, put last element as square of start and increment start, 
	 * else put square of end and decrement end. 
	 *  
	 */
	
	private int[] squares2ptr(int[] input) {
		int start=0,end=input.length-1;
		int[] output= new int[input.length];
		for(int i=input.length-1;i>=0;i--) {
			if(Math.abs(input[start]) > Math.abs(input[end])) {
				output[i]=input[start]*input[start];
				start++;
			}
			else {
				output[i]=input[end]*input[end];
				end--;
			}
		}
		
		return output;
	}
}
