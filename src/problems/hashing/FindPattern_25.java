package problems.hashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;


public class FindPattern_25 {
	
	/*
	 * Given a pattern and a string s, find if s follows the same pattern. Here
	 * follow means a full match, such that there is a bijection between a letter in
	 * pattern and a non-empty word in s. Example 1: Input: pattern = "abba", s =
	 * "dog cat cat dog" Output: true Example 2: Input: pattern = "abba", s =
	 * "dog cat cat fish" Output: false Input: pattern = "abc", s =
	 * "hello world world" Output: false Algorithm: HashMap
	 */

	@Test
	public void example1() {
		String pattern = "abba";
		String s = "dog cat cat dog";
		Assert.assertEquals(true, findPattern(pattern, s));
	}

	@Test
	public void example2() {
		String pattern = "abba";
		String s = "dog cat cat fish";
		Assert.assertEquals(false, findPattern(pattern, s));
	}

	@Test
	public void example3() {
		String pattern = "abc";
		String s = "hello world world";
		Assert.assertEquals(false, findPattern(pattern, s));
	}

	@Test
	public void example4() {
		String pattern = "abc";
		String s = "hello world World";
		Assert.assertEquals(true, findPattern(pattern, s));
	}

	@Test
	public void example5() {
		String pattern = "abc";
		String s = "a b c";
		Assert.assertEquals(true, findPattern(pattern, s));
	}

	private boolean findPattern(String pattern, String s) {
		Map<String, Character> map = new HashMap<>();

		String[] split = s.split(" ");

		if (split.length != pattern.length())
			return false;

		int ind = 0;

		while (ind < split.length) {
			if (map.containsKey(split[ind]) && map.get(split[ind]) != pattern.charAt(ind))
				return false;
			else if (!map.containsKey(split[ind]) && map.containsValue(pattern.charAt(ind)))
				return false;
			else
				map.put(split[ind], pattern.charAt(ind));
			ind++;
		}

		return true;
	}
}
