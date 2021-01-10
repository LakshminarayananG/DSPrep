package week12.classwork;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PalindromePartitioning {
	
	//https://leetcode.com/problems/palindrome-partitioning/
	// Leetcode Problem 131
	
	/*
	 * Given a string s, partition s such that every substring of the partition is a
	 * palindrome. Return all possible palindrome partitioning of s.
	 * 
	 * A palindrome string is a string that reads the same backward as forward.
	 * 
	 * 
	 * 
	 * Example 1: 
	 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]] 
	 * 
	 * Example 2: 
	 * Input: s = "a" Output: [["a"]]
	 */
	
	@Test
	public void example1() {
		String s = "aab";
		findPalindromeCombinations(s);
	}

	@Test
	public void example2() {
		String s = "abc";
		findPalindromeCombinations(s);
	}

	@Test
	public void example3() {
		String s = "a";
		findPalindromeCombinations(s);
	}

	private void findPalindromeCombinations(String s) {
		List<List<String>> output = new ArrayList<List<String>>();
		recursionFunction(s, output, new ArrayList<String>(), 0);
		System.out.println(output);
	}

	
	/*
	 * Approach using backtracking
	 * 1. Iterate from string length 0 to n-1
	 * 2. For each character, check if the substring is a palindrome and keep adding it to the list
	 * 3. Increment the start index and for each recursive call, increment start
	 * 4. when start matches the length of the string, add the list to output list and backtrack
	 *   (remove the inner list elements)
	 * 5. Return the output list
	 */
	
	private void recursionFunction(String s, List<List<String>> output, List<String> temp, int start) {
		if (start == s.length()) {
			output.add(new ArrayList<String>(temp));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				recursionFunction(s, output, temp, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int left, int right) {
		while (left < right)
			if (s.charAt(left++) != s.charAt(right--))
				return false;
		return true;
	}
	
	

}
