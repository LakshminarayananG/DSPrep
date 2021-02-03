package problems.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;



public class MaxVowels_27 {
	
	/*
	Given a string s and an integer k.
	Return the maximum number of vowel letters [exact first match] in any substring of s with length k.
	Vowel letters in English are (a, e, i, o, u).
	Example 1:
	Input: s = "abciiidef", k = 3
	Output: iii
	Explanation: The substring "iii" contains 3 vowel letters.
	Example 2:
	Input: s = "aeiou", k = 2
	Output: ae
	*/

	@Test
	public void example1() {
		String s = "abciiidef";
		int k = 3;
		maxConsecVowels(s, k);
	}
	
	@Test
	public void example2() {
		String s = "aeiou";
		int k = 2;
		maxConsecVowels(s, k);
	}

	private void maxConsecVowels(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int start = 0, end = 0;
		int maxcnt = 0;
		String max = "";

		while (end < s.length()) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
			end++;
			if (end >= k) {
				if (set.containsAll(map.keySet()) && (end - start) > maxcnt) {
					maxcnt = end - start;
					max = s.substring(start, end);
				}

				if (map.get(s.charAt(start)) > 1)
					map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
				else
					map.remove(s.charAt(start));
				start++;
			}

		}
		System.out.println(max);
	}
}
