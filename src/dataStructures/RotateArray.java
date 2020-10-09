package dataStructures;

import java.util.Arrays;
import org.junit.Test;

public class RotateArray {
	@Test
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