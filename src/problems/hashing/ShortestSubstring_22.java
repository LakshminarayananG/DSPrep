package problems.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ShortestSubstring_22 {
	
	/*
	Given a string comprised of lowercase letters in the range ascii[a-z],
	find the length shortest substring that contains at least one of each of
	the letters in the string.

	Example
	givenString = dabbcabcd
	The list of all characters in the string is [a, b, c, d].
	Two of the substrings that contain all letters are dabbc and abcd.
	The shortest substring that contains all of the letters is 4 characters
	long. Return 4 as the answer.
	*/

	@Test
	public void example1() {
		String s = "dabbcabcd";
		shortString(s);
	}

	private void shortString(String s) {
		char[] cArr = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : cArr) {
			set.add(c);
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0;
		int min = Integer.MAX_VALUE;

		while (end < cArr.length) {
			map.put(cArr[end], map.getOrDefault(cArr[end++], 0) + 1);
			boolean equals = map.keySet().equals(set);
			if (equals) {
				map.clear();
				min = Math.min(min, s.substring(start, end).length());
				start++;
				end = start;
			}
		}
		System.out.println(min);
	}
}
