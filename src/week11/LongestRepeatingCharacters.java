package week11;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LongestRepeatingCharacters {
	
	/*
	Given a string s that consists of only upper case letters, you can perform at most k operations on that string.
	In one operation, you can choose any character of the string and change it to any other upper case character.
	Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
	Example 1:
	Input:
	s = "ABAB", k = 2
	Output:
	4
	Explanation:
	Replace the two 'A's with two 'B's or vice versa.
	Example 2:
	Input:
	s = "AABABBA", k = 1
	Output:
	4
	Explanation:
	Replace the one 'A' in the middle with 'B' and form "AABBBBA".
	The substring "BBBB" has the longest repeating letters, which is 4.
	*/
	
	@Test
	public void example1() {
		String s = "ABAB";
		int k = 2;
		longestRepeating(s, k);
	}

	@Test
	public void example2() {
		String s = "AABABBA";
		int k = 1;
		longestRepeating(s, k);
	}

	@Test
	public void example3() {
		String s = "ABBC";
		int k = 2;
		longestRepeating(s, k);
	}

	private void longestRepeating(String s, int k) {
		int start = 0, maxLen = 0, repeat = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int end = 0; end < s.length(); end++) {
			char right = s.charAt(end);
			map.put(right, map.getOrDefault(right, 0) + 1);
			repeat = Math.max(repeat, map.get(right));

			if (end - start + 1 - repeat > k) {
				char left = s.charAt(start);
				map.put(left, map.getOrDefault(left, 0) - 1);
				start++;
			}

			maxLen = Math.max(maxLen, end - start + 1);
		}
		System.out.println(maxLen);
	}

}
