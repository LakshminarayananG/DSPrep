package practice.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MoveAllZeroes {
	
	@Test
	public void example1() {
		int[] input= {1,5,0,2,0,7,12,6,9};
		int[] movezeroes = movezeroes(input);
		System.out.println(Arrays.toString(movezeroes));
	}
	
	
	@Test
	public void example2() {
		int[] input= {0,0,1,0,2,6,7,1,0,5};
		
		/*
		 * int[] moveZeroes = moveZeroes(input);
		 * System.out.println(Arrays.toString(moveZeroes));
		 */}
	
	
	@Test
	public void example3() {
		int[] input= {0,0,1,0,2,6,7,1,0,5};
		int[] moveZeroes = zeros(input);
		System.out.println(Arrays.toString(moveZeroes));
	}
	
	
	//Approach 1 Complexity --> O[N]
	private int[] movezeroes(int[] input) {
		int[] temp= new int[input.length];
		int val=0;
		for(int i=0;i<input.length;i++) {
			if(input[i]!=0) {
				temp[val]=input[i];
				val++;
			}
		}
		return temp;
	}
	
	
	
	/*
	 * //Alternate Approach using swapping private int[] moveZeroes(int[] nums) {
	 * int i = 0; int j = 0; while (j < nums.length) { if (nums[j] != 0) { nums[i++]
	 * = nums[j]; } j++; } while (i < nums.length) { nums[i++] = 0; } return nums; }
	 */ 
	
	
	//Other Approach by moving all non zero elements to first and then adding all other elements to zero
	private int[] zeros(int[] input) {
		int count = 0; 
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) 
                input[count++] = input[i]; 
        }
        while (count <input.length) {
            input[count++] = 0; 
        }
        
        
        return input;
        
	}
	

}
