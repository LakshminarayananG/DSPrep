package week3.homework;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
1) Longest substring without repeating characters

Input: s="abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3

Input: s="bbbbb"
Output: 1
Explanation: The aswer is "b", with the length of 1

Input: s="pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3

Notice that the answer must be a substring, "pwke" is a subsequence not a substring.
*/

public class P1_LongestSubstring {

	@Test
	public void example1() {
		String input = "pwwkew";
		System.out.println(longestSubstring(input));
	}
	
	@Test
	public void example2() {
		String input = "abcabcbb";
		System.out.println(longestSubstring(input));
	}
	
	@Test
	public void example3() {
		String input = "bbbbb";
		System.out.println(longestSubstring(input));
	}
	
	
	private int longestSubstring(String input) {
		int n = input.length();
		Set<Character> set = new HashSet<Character>();
		int i = 0, j = 0, maxValue = 0;
		
		while (i < n && j < n) {
			if (set.contains(input.charAt(i))) {
				set.remove(input.charAt(j++));
			} else {
				set.add(input.charAt(i++));
				maxValue = Math.max(maxValue, i - j);
			}
		}
		return maxValue;
	}
}
