package week13.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class LongestSubStringWIthKDistinctCharacters {
	
	/*Given a string, find the length of the longest substring T that contains at most k distinct characters.
	e.g.:
	Input: s="eceba", k=2
	Output: 3
	Explanation: T is "ece" which its length is 3
	e.g.:2
	Input: s="aa", k=1
	Output: 2
	Explanation: T is "aa" which its length is 2*/
	
	@Test
	public void example1() {
		String s = "ecebaaaaee";
		int k = 2;
		System.out.println(longSubstring(s, k));
		// System.out.println(bruteForce(s, k));
	}

	@Test
	public void example2() {
		String s = "AAa";
		int k = 1;
		System.out.println(longSubstring(s, k));
		// System.out.println(bruteForce(s, k));
	}

	@Test
	public void example3() {
		String s = "abcd";
		int k = 5;
		System.out.println(longSubstring(s, k));
		// System.out.println(bruteForce(s, k));
	}

	@Test
	public void example4() {
		String s = "";
		int k = 1;
		System.out.println(longSubstring(s, k));
		// System.out.println(bruteForce(s, k));
	}

	@Test
	public void example5() {
		String s = "Muraleedaaran";
		int k = 3;
		System.out.println(longSubstring(s, k));
		// System.out.println(bruteForce(s, k));
	}

	@Test
	public void example6() {
		String s = "bacaaab";
		int k = 2;
		System.out.println(longSubstring(s, k));
		// System.out.println(bruteForce(s, k));
	}

	// Set
	private int longSubstring2(String s, int k) {
		Set<Character> set = new HashSet<>();
		int start = 0, end = 0, maxLen = -1;

		while (end < s.length()) {
			set.add(s.charAt(end++));

			if (set.size() <= k)
				maxLen = Math.max(maxLen, end - start);
			else {
				start++;
				if (!s.substring(start, end).contains(Character.toString(s.charAt(start - 1))))
					set.remove(s.charAt(start - 1));
			}
		}

		if (maxLen == -1)
			throw new RuntimeException("Invalid input");

		return maxLen;
	}

	// Ascii
	/*
	 * Two pointer add count of each character occurance in an ASCII array if the
	 * added character is unique, increase the counter if counter is less than or
	 * equal to k, find the max length by comparing current length with previous
	 * length else, decrease the occurance of the start character and check if the
	 * start character occurance is zero if so then decrease the count
	 */

	private int longSubstring(String s, int k) {
		int start = 0, end = 0;
		int cnt = 0;
		int maxLen = -1;
		int[] arr = new int[256];

		while (end < s.length()) {
			if (arr[s.charAt(end)] == 0) {
				cnt++;
			}
			arr[s.charAt(end++)]++;

			if (cnt <= k)
				maxLen = Math.max(maxLen, end - start);
			else {
				arr[s.charAt(start)]--;
				if (arr[s.charAt(start++)] == 0)
					cnt--;
			}
		}

		if (maxLen == -1)
			throw new RuntimeException("Invalid input");

		return maxLen;
	}

	// Pseudo Code
	// Space Complexity: O[N]
	// Time Complexity: O[N]
	// Window+Hashing
	/*
	 * add each element to a hashmap with its occurance count for each iteration
	 * check if the map keyset matches k if yes, get the max length if keyset
	 * doesn't matches k, remove start element from the map when iterated through
	 * each element from the string, return the max length
	 */
	private int longSubstring1(String s, int k) {
		if (s.length() == 0 || k <= 0)
			throw new RuntimeException("Invalid input");

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0, maxLen = Integer.MIN_VALUE;

		while (end < s.length()) {
			char c = s.charAt(end++);
			map.put(c, map.getOrDefault(c, 0) + 1);

			if (map.keySet().size() <= k)
				maxLen = Math.max(end - start, maxLen);
			else {
				if (map.get(s.charAt(start)) == 1)
					map.remove(s.charAt(start++));
				else
					map.put(s.charAt(start), map.get(s.charAt(start++)) - 1);
			}
		}
		return maxLen;
	}

	// Pseudo Code
	// Space complexity: O[N]
	// Time complexity: O[N^2]
	/*
	 * Start from first character in the string add corresponding characters to a
	 * set until it becomes greater than k if set size becomes greater than k, then
	 * set max length if current length is greater than previous one break the loop
	 * again start from second character iterate till end of the string finally
	 * return the max length
	 */
	private int bruteForce(String s, int k) {

		if (s.length() == 0 || k <= 0)
			throw new RuntimeException("Invalid input");

		Set<Character> set = new HashSet<Character>();
		int maxLen = Integer.MIN_VALUE;
		char[] carr = s.toCharArray();

		for (int i = 0; i < carr.length; i++) {
			for (int j = i; j < carr.length; j++) {
				set.add(carr[j]);
				if (set.size() > k) {
					maxLen = Math.max(maxLen, j - i);
					break;
				}
			}
			set.clear();
		}
		return maxLen;
	}

}
