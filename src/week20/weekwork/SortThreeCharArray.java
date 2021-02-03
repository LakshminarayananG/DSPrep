package week20.weekwork;


import java.util.Arrays;

import org.junit.Test;



public class SortThreeCharArray {
	
	/*
	Given a character array of three characters A, M and D, sort the given array in ascii order
	Input: ['A','M','D']
	Output: ['A','D','M']

	Note: there can be multiple occurrences
	No built-in methods!! 
	*/
	
	//Pseudo code

	//Brute force - Use Arrays.sort(input array) to sort the flag
	//Space: O[1] Time: O[N log N]

	/*
	 * To be solved using Dutch Flag algorithm
	 * Take 3 pointers, left,right and mid
	 * both left and mid starts at 0
	 * right starts at end of the array
	 * if mid equals A, swap mid and left. increment both
	 * if mid equals D, increment mid
	 * if mid equals M, swap right and left and decrement right
	 * iterate till mid crosses right
	 * 
	 * Space: O[1]
	 * Time:
	 * Best: O[N]
	 * Worst: O[N]
	 * Average: O[N]
	 */

	/*
	 * create another array of same length of input
	 * have left and right variable initialized as 0 and array len respectively 
	 * have D counter 
	 * iterate through input array if,
	 	* the character is A, then add it to left index and increment left
	 	* the character is M, then add it to right index and decrement right
	 	* the character is D, then increment the counter 
	 * if the D counter is greater than 1, then add D from the left index and increment left
	 * 
	 * Space: O[N] Time: O[N] (best) O[N] (worst) O[N] (average)
	 */

	@Test
	public void example1() {
		char[] input = { 'A', 'M', 'D' };
		sortArray(input);
	}

	@Test
	public void example2() {
		char[] input = { 'D', 'A', 'A', 'D', 'M', 'A', 'D' };
		sortArray(input);
	}

	@Test
	public void example3() {
		char[] input = { 'D', 'D', 'D' };
		sortArray(input);
	}

	@Test
	public void example4() {
		char[] input = { 'A', 'A', 'D', 'M' };
		sortArray(input);
	}

	@Test
	public void example5() {
		char[] input = { 'M', 'M', 'A', 'D', 'A' };
		sortArray(input);
	}

	private void sortArray1(char[] input) {

		int left = 0, right = input.length - 1, mid = 0;

		while (mid <= right) {
			if (input[mid] == 'A') {
				char temp = input[left];
				input[left++] = input[mid];
				input[mid++] = temp;
			} else if (input[mid] == 'M') {
				char temp = input[right];
				input[right--] = input[mid];
				input[mid] = temp;
			} else
				mid++;
		}

		System.out.println(Arrays.toString(input));
	}

	private void sortArray2(char[] input) {
		char[] output = new char[input.length];
		int left = 0, right = input.length - 1, dCnt = 0;

		for (char c : input) {
			switch (c) {
			case 'A':
				output[left++] = 'A';
				break;
			case 'M':
				output[right--] = 'M';
				break;
			default:
				dCnt++;
			}
		}

		while (dCnt-- > 0)
			output[left++] = 'D';

		System.out.println(Arrays.toString(output));
	}

	/*
	 * create 2 pointer, left and right iterate through each element in the array if
	 * element is A, swap it with left if element is M swap it with right finally
	 * return the output Space: O[1] Time: O[N]
	 */
	private void sortArray(char[] input) {
		int left = 0, right = input.length - 1;
		int lp = 0, rp = input.length - 1;
		while (left < input.length && right >= 0) {
			if (input[left] == 'A') {
				char temp = input[lp];
				input[lp++] = input[left];
				input[left] = temp;
			}

			if (input[right] == 'M') {
				char temp = input[rp];
				input[rp--] = input[right];
				input[right] = temp;
			}

			left++;
			right--;
		}

		System.out.println(Arrays.toString(input));
	}
}
