package problems.hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;



public class CheckIsomorphic_38 {
	
	/*
	Given two strings s and t, determine if they are isomorphic.
	Two strings are isomorphic if the characters in s can be replaced to get t.
	All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

	Example 1:
	Input: s = "egg", t = "add"
	Output: true
	Example 2:
	Input: s = "foo", t = "bar"
	Output: false
	Example 3:
	Input: s = "paper", t = "title"
	Output: true
	Note:
	You may assume both s and t have the same length.
	*/

	@Test
	public void example1() {
		String s = "egg";
		String t = "add";
		Assert.assertEquals(true, isIsomorphic(s, t));
	}

	@Test
	public void example2() {
		String s = "foo";
		String t = "bar";
		Assert.assertEquals(false, isIsomorphic(s, t));
	}

	@Test
	public void example3() {
		String s = "paper";
		String t = "title";
		Assert.assertEquals(true, isIsomorphic(s, t));
	}

	private boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<Character, Character>();

		for (int p = 0; p < s.length(); p++) {
			if (map.containsKey(s.charAt(p)) && map.get(s.charAt(p)) != t.charAt(p))
				return false;
			else if (!map.containsKey(s.charAt(p)) && map.containsValue(t.charAt(p)))
				return false;
			else
				map.put(s.charAt(p), t.charAt(p));
		}
		return true;
	}
}
