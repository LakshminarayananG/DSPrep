package assessment.week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FW_Anagram {
	
	/*
	 * Given 2 strings, check if string 2 is an anagram of String 1
	 */

	@Test
	public void example1() {
		String s1 = "anagram";
		String s2 = "nagaram";
		System.out.println(isAnagram(s1, s2));
	}

	@Test
	public void example2() {
		String s1 = "rat";
		String s2 = "car";
		System.out.println(isAnagram(s1, s2));
	}

	private boolean isAnagram1(String s1, String s2) {
		if (s2.length() != s1.length())
			return false;

		int[] c1 = new int[26];
		int[] c2 = new int[26];

		for (char c : s1.toCharArray())
			c1[c - 'a']++;

		for (char c : s2.toCharArray())
			c2[c - 'a']++;

		return Arrays.equals(c1, c2);
	}

	private boolean isAnagram2(String s1, String s2) {
		if (s2.length() != s1.length())
			return false;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : s1.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		for (char c : s2.toCharArray()) {
			if (map.containsKey(c) && map.get(c) > 1)
				map.put(c, map.get(c) - 1);
			else if (map.containsKey(c) && map.get(c) == 1)
				map.remove(c);
		}

		return map.isEmpty();
	}

	private boolean isAnagram3(String s1, String s2) {
		if (s2.length() != s1.length())
			return false;

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);

		return Arrays.equals(c1, c2);
	}

	private boolean isAnagram4(String s1, String s2) {
		if (s2.length() != s1.length())
			return false;

		List<String> lst = new ArrayList<String>(Arrays.asList(s2.split("")));

		for (String s : s1.split(""))
			if (lst.contains(s))
				lst.remove(s);

		return lst.isEmpty();
	}

	private boolean isAnagram(String s1, String s2) {
		if (s2.length() != s1.length())
			return false;
		
		StringBuilder sb = new StringBuilder(s2);

		for (String s : s1.split("")) {
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == s.charAt(0))
					sb.deleteCharAt(i);
			}
		}
		return sb.length() == 0 ? true : false;
	}
}
