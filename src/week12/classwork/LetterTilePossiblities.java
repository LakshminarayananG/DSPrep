package week12.classwork;

import java.util.Arrays;

import org.junit.Test;

public class LetterTilePossiblities {
	
	/*
	 * Leetcode Problem Number 1079
	 * https://leetcode.com/problems/letter-tile-possibilities/
	 */
	
	/*
	 * You have n tiles, where each tile has one letter tiles[i] printed on it.
	 * 
	 * Return the number of possible non-empty sequences of letters you can make
	 * using the letters printed on those tiles.
	 * 
	 * 
	 * 
	 * Example 1: 
	 * Input: tiles = "AAB" Output: 8 Explanation: The possible sequences are "A",
	 * "B", "AA", "AB", "BA", "AAB", "ABA", "BAA". 
	 * 
	 * Example 2: 
	 * Input: tiles = "AAABBC" Output: 188 
	 * 
	 * Example 3: 
	 * Input: tiles = "V" Output: 1
	 */
	
	
	int count = 0;

	@Test
	public void example1() {
		String tiles = "AAB";
		System.out.println(numTilePossibilities(tiles));
	}

	@Test
	public void example2() {
		String tiles = "AAABBC";
		System.out.println(numTilePossibilities(tiles));
	}

	@Test
	public void example3() {
		String tiles = "V";
		System.out.println(numTilePossibilities(tiles));
	}

	private int numTilePossibilities(String tiles) {
		char[] arr = tiles.toCharArray();
		Arrays.sort(arr);
		recursionFunction(arr, new boolean[arr.length]);
		return count - 1;
	}

	private void recursionFunction(char[] arr, boolean[] used) {
		count++;
		for (int i = 0; i < arr.length; i++) {
			if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]))
				continue;
			used[i] = true;
			recursionFunction(arr, used);
			used[i] = false;
		}
	}

}
