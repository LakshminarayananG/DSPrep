package backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
*/

public class PalindromePartitioning_131 {
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
