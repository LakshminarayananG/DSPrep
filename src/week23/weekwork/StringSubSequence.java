package week23.weekwork;

import org.junit.Test;

public class StringSubSequence {
	
	/**
	 * Problem 5)
	 * 
	 * Given two strings s and t, check if s is a subsequence of t.
	 * 
	 * A subsequence of a string is a new string that is formed from the original
	 * string by deleting some (can be none) of the characters without disturbing
	 * the relative positions of the remaining characters. (i.e., "ace" is a
	 * subsequence of "abcde" while "aec" is not).
	 * 
	 * Example 1:
	 * 
	 * Input: s = "abc", t = "ahbgdc" Output: true Example 2:
	 * 
	 * Input: s = "axc", t = "ahbgdc" Output: false
	 */
	
	@Test
	public void eg1() {
		String s="abc";
		String t="ahbgdc";
		System.out.println(subsequence(s, t));
	}
	
	@Test
	public void eg2() {
		String s="axc";
		String t="ahbgdc";
		System.out.println(subsequence(s, t));
	}
	
	
	private boolean subsequence(String s,String t){
		if (t.length() < s.length()) return false;
		if (s.length() == 0) return true;

		int i = 0;
		int j = 0;

		while (i < t.length() && j < s.length()) {
			if (s.charAt(j) == t.charAt(i)) {
				if (j == s.length() - 1) return true;

				i++;
				j++;
			} else
				i++;
		}

		return false;
	}

}
