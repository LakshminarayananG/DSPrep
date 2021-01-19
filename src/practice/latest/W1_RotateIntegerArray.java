package practice.latest;

import java.util.Arrays;

import org.junit.Test;

public class W1_RotateIntegerArray {
	
	/*
	 * Given an Integer array, Rotate it by n number of times.
	 * 
	 * Input: [1,3,4,5,8,10] no.of rotation=3
	 * Output: [5,8,10,1,3,4]
	 */
	
	
	@Test
	public void eg1() {
		int[] input = { 1, 5, 6, 3, 4, 5,8 };
		int rotate = 3;
		int[] output = rotateArr(input, rotate);
		System.out.println("Eg1"+Arrays.toString(output));
		System.out.println("Eg1"+Arrays.toString(rotateArr2Ptr(input, rotate)));
		
	}

	@Test
	public void eg2() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 13;
		int[] output = rotateArr(input, rotate);
		System.out.println("Eg2"+Arrays.toString(output));
		System.out.println("Eg2"+Arrays.toString(rotateArr2Ptr(input, rotate)));
	}

	@Test
	public void eg3() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 6;
		int[] output = rotateArr(input, rotate);
		System.out.println("Eg3"+Arrays.toString(output));
		System.out.println("Eg3"+Arrays.toString(rotateArr2Ptr(input, rotate)));
	}

	@Test
	public void eg4() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 31;
		int[] output = rotateArr(input, rotate);
		System.out.println("Eg4"+Arrays.toString(output));
		System.out.println("Eg4"+Arrays.toString(rotateArr2Ptr(input, rotate)));
	}

	@Test
	public void eg5() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 21;
		int[] output = rotateArr(input, rotate);
		System.out.println("Eg5"+Arrays.toString(output));
		System.out.println("Eg5"+Arrays.toString(rotateArr2Ptr(input, rotate)));
	}
	
	/* Approach 1
	 * 1. Declare an output array of the same size as input array
	 * 2. If the number of rotations =0, return input array
	 * 3. If number of rotations > inpur arr.len, find the rotations as (rotations%arr.len)
	 * 4. Start from 0 to rotate and fill in the values output array with input[len-rotate+i]
	 * 5. Declare temp as 0. Start from rotate to end of array and fill output with value of input[temp]
	 * 6. return output array
	 * 
	 */
	
	
	private int[] rotateArr(int[] input, int rotate) {
		if(rotate==0) return input;
		if(rotate>input.length) rotate=rotate%input.length;
		int[] output= new int[input.length];
		int tmp=0;
		
		for(int i=0;i<rotate;i++) {
			output[i] = input[input.length-rotate+i];
		}
		
		for(int i=rotate;i<input.length;i++) {
			output[i]=input[tmp];
			tmp++;
		}
		
		return output;
	}
	
	
	/*
	 * Using 2 Pointers
	 * 
	 * 1. Rotate from 0 to rotate-1
	 * 2. Rotate from rotate to len-1
	 * 3. Rotate the whole array using 2 pointers
	 */
	//1, 5, 6, 3, 4, 5 rotation =3 O/P --> 3,4,5,1,5,6
	
	// 6 5 1  // 5 4 3 
	// 3 4 5 1 5 6
	
	private int[] rotateArr2Ptr(int[] input, int rotate) {
		if(rotate==0) return input;
		if(rotate>input.length) rotate=rotate%input.length;
		int temp=input.length-rotate;
		rotate2Ptr(input,0,temp-1);
		rotate2Ptr(input, temp, input.length-1);
		rotate2Ptr(input, 0, input.length-1);
		return input;
	}
	
	private int[] rotate2Ptr(int[] input, int start, int end) {
		while(start<end) {
			int temp=input[start];
			input[start]= input[end];
			input[end]= temp;
			start++;
			end--;
		}
		return input;
	}

}
