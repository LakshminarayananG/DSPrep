package week13.homework;

import org.junit.Test;

public class SecondGreatestElementInArray {
	
	/*
	 * find the 2nd greatest number in an array without using collection concepts
	 * 
	 * input : [2,1,3,5,4,11,33,26]
	 * 
	 * output: 26
	 */
	
	@Test
	public void example1() {
		int[] arr = { 2, 1, 3, 5, 4, 11, 33, 26 };
		System.out.println(secGreat(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 9, 9, 9, 9, 9 };
		System.out.println(secGreat(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 8 };
		System.out.println(secGreat(arr));
	}

	@Test
	public void example4() {
		int[] arr = { -5, -4, 0, -6, 1 };
		System.out.println(secGreat(arr));
	}
	
	//Space complexity: O[1]
	//Time complexity: O[N]
	/*
	 * Take 2 variables, first and second great. If current element is greater than
	 * first element. Then, make previous first greater as second greater and
	 * current element as first greater. If current element is lesser than first
	 * greater but greater than second greater. Then, make current element as second
	 * greater. Finally, return the second greater element.
	 */
	private int secGreat(int[] arr) {
		int fGreat = 0, sGreat = 0;

		for (int end = 0; end < arr.length; end++) {
			if (arr[end] > fGreat) {
				sGreat = fGreat;
				fGreat = arr[end];
			} else if (arr[end] < fGreat && arr[end] > sGreat)
				sGreat = arr[end];
		}

		return sGreat;
	}

}
