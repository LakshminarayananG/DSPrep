package week1;

import java.util.Arrays;
import org.junit.Test;

public class RotateAnArray {
	
	/*
	 * Given an Integer array, Rotate it by n number of times.
	 * 
	 * Input: [1,3,4,5,8,10] no.of rotation=3
	 * Output: [5,8,10,1,3,4]
	 */
	
	/*
	 * Approach 1
	 * 1. Create an integer array of size equivalent to the input array
	 * 2. If number of rotation is greater than the length of array, divide the number of rotation by length of array
	 *    and the remainder is the number of rotation
	 * 3. Assign a variable temp=0 
	 * 4. Iterate from 0 to value of rotation and fill in the new array[i] with value of input array[length-rotation+i]
	 * 5. Iterate from value of rotation to length of array and fill in the new array[temp] with value of input array[i]
	 *    and increment temp
	 * 6. return the array created
	 */
	
	/*
	 * Alternate approach using 2 pointers
	 * 1. Using 2 pointer, reverse the array from 0 to rotate
	 * 2. rotate again from value of rotation to length of array
	 * 3. rotate the whole array
	 */
	
	
	//@Test
	public void eg1() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 3;
		int[] output = rotate(input, rotate);
		System.out.println(Arrays.toString(output));
	}

	@Test
	public void eg2() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 13;
		int[] output = rotate(input, rotate);
		System.out.println(Arrays.toString(output));
	}

	@Test
	public void eg3() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 6;
		int[] output = rotate(input, rotate);
		System.out.println(Arrays.toString(output));
	}

	@Test
	public void eg4() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 31;
		int[] output = rotate(input, rotate);
		System.out.println(Arrays.toString(output));
	}

	@Test
	public void eg5() {
		int[] input = { 1, 5, 6, 3, 4, 5 };
		int rotate = 21;
		int[] output = rotateArr(input, rotate);
		System.out.println(Arrays.toString(output));
	}
	
	
	private int[] rotate(int[] input, int rotatetime) {
		if (rotatetime > input.length) {
			rotatetime = rotatetime % input.length;
		}

		int[] temp = new int[input.length];

		for (int i = 0; i < rotatetime; i++) {
			temp[i] = input[input.length - rotatetime + i];
		}

		int val = 0;
		for (int j = rotatetime; j < input.length; j++) {
			temp[j] = input[val];
			val++;
		}

		return temp;
	}
	
	
	private int[] rotateArr(int[] input, int rotate) {
		if (rotate > input.length) {
			rotate = rotate % input.length;
		}

		int tempval = input.length - rotate;
		reverseArray(input, 0, tempval - 1);
		reverseArray(input, tempval, input.length - 1);
		reverseArray(input, 0, input.length - 1);
		return input;
	}

	private int[] reverseArray(int[] input, int startIndex, int endIndex) {
		while (startIndex < endIndex) {
			int temp = input[startIndex];
			input[startIndex] = input[endIndex];
			input[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		return input;

	}
	

}
