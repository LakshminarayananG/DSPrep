package week16;

import org.junit.Test;

//Return the absolute square root of the input
//9->3,15->-1

public class FindSquareRoot {

	@Test
	public void example1() {
		int input = 9;
		// System.out.println("Linear approach: "+linearApproach(input));
		System.out.println("Binary approach: " + binaryApproachExact(input));
	}

	@Test
	public void example2() {
		int input = 16;
		// System.out.println("Linear approach: "+linearApproach(input));
		System.out.println("Binary approach: " + binaryApproachExact(input));
	}

	@Test
	public void example3() {
		int input = 64;
		// System.out.println("Linear approach: "+linearApproach(input));
		System.out.println("Binary approach: " + binaryApproachExact(input));
	}

	@Test
	public void example4() {
		int input = 8;
		// System.out.println("Linear approach: "+linearApproach(input));
		System.out.println("Binary approach: " + binaryApproachExact(input));
	}

	@Test
	public void example5() {
		int input = 12;
		// System.out.println("Linear approach: "+linearApproach(input));
		System.out.println("Binary approach: " + binaryApproachExact(input));
	}

	@Test
	public void example6() {
		int input = 50176;
		// System.out.println("Linear apporach: "+linearApproach(input));
		System.out.println("Binary approach: " + binaryApproachExact(input));
	}

	// Pseudo Code
	/*
	 * Iterate through each number from 1 to input/2 square each element and check
	 * if the squared number matches with the input if matched, return the element
	 * if squared value is greater than input, return -1
	 */

	private int linearApproach(int input) {
		for (int i = 1; i <= input / 2; i++)
			if ((i * i) == input)
				return i;

		return -1;
	}

	// Pseudo code
	/*
	 * initialize left is 1,right and mid pointer where right is input/2 and mid is
	 * left+right/2 if square of mid element is input, return the input or check if
	 * square of mid is less than input, change left to mid+1 in neither case change
	 * right to mid-1 continue the looping till left becomes greater than right
	 */

	private int binaryApproach(int input) {
		int left = 2, right = input / 2;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			if ((mid * mid) == input)
				return mid;
			else if ((mid * mid) < input)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}

	private float binaryApproachExact(int input) {
		float left = 0, right = input / 2;
		float mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			float squareVal = mid * mid;
			if (Math.round(squareVal) == input)
				return mid;
			if (squareVal < input)
				left = mid;
			else
				right = mid;
		}
		return -1;
	}

}
