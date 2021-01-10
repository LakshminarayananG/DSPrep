package ds.assignments;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class LongestSubString1 {

	@Test
	public void example1() {
		String str = "abcabcbb";
		System.out.println(longestSubString(str));
	}

	@Test
	public void example2() {
		String str = "bbbbb";
		System.out.println(longestSubString(str));
	}

	private int longestSubString(String str) {
		int n = str.length();
		int maxLength = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(str, i, j)) {
					maxLength = Math.max(maxLength, j - i);
				}
		return maxLength;
	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) return false;
			set.add(ch);
		}
		return true;
	}

}
