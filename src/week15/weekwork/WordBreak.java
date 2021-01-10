package week15.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

public class WordBreak {

	@Test
	public void example1() {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
		System.out.println(WordBreaks(s, wordDict));
	}

	@Test
	public void example2() {
		String s = "applepenapple";
		List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
		System.out.println(WordBreaks(s, wordDict));
	}

	@Test
	public void example3() {
		String s = "catsandog";
		List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
		System.out.println(WordBreaks(s, wordDict));
	}

	@Test
	public void example4() {
		String s = "aaaaaaa";
		List<String> wordDict = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
		System.out.println(WordBreaks(s, wordDict));
	}
	
	@Test
	public void example5() {
		String s = "goalspecial";
		List<String> wordDict = new ArrayList<>(Arrays.asList("go","goal","goals","special"));
		System.out.println(WordBreaks(s, wordDict));
	}

	private boolean WordBreaks2(String s, List<String> wordDict) {
		return recursion(s, wordDict, 0);
	}

	private boolean recursion(String s, List<String> wordDict, int k) {
		if (k == s.length())
			return true;

		for (int i = k + 1; i <= s.length(); i++) {
			if (wordDict.contains(s.substring(k, i)) && recursion(s, wordDict, i))
				return true;
		}
		return false;
	}

	private boolean WordBreaks(String s, List<String> wordDict) {
		StringBuilder sb=new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if (wordDict.contains(sb.substring(0, i + 1))) {
				if (wordDict.contains(sb.substring(i + 1, sb.length())))
					sb = sb.replace(i+1, sb.length(), "");
				sb = sb.replace(0, i+1, "");
				i = -1;
			}
		}

		if (sb.length() == 0)
			return true;

		return false;
	}

	private boolean WordBreaks1(String s, List<String> wordDict) {
		boolean res = false;
		int left = 0, right = 0, count = 0;

		for (; right < s.length(); right++) {
			if (wordDict.contains(s.substring(left, right + 1))) {
				count++;
				res = true;
				left = ++right;

			} else {
				res = false;
			}
			if (count == wordDict.size())
				break;
		}
		return res;
	}
}
