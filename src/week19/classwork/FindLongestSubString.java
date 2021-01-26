package week19.classwork;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class FindLongestSubString {
	
	
	/*
	Amazon
	Given a String that has only Uppercase Characters, 
	    a) You are allowed to replace any character with any specific character
	    b) But only upto K given input
	Find the longest substring containing all same character !!
	Examples
	 Input: “AABAAB” , 2
	Output: “AAAAAA” -> 6
	Input: “ABCDE” , 1
	Output: “AACDE -> 2
	Assumption:
	if k is greater than input length, return entire input
	k=0 is valid (no changes to be done)
	*/

	//Bruteforce
	/*
	iterate through each character in the string
	for each character, check its adjacent characters
		if the adjacent character doesn't match with the checking character increase the counter
		if the counter greater than k, then find the substring length and compare it with the previous max length
	finally return the max length of the substring with k replacement
	Space: O[1]
	Time:
	Best: O[N]
	Worst: O[N2]
	Average: O[N*M]
	*/

	//Sliding window
	/*
	ABCCC->2
	Add each character to the map with its occurrence
	also find the max occurrence of a character in the window
	if the window has more than K characters other than max occuring character, 
		move the window i.e. remove the character occurrence
	Space: O[N]
	Time:
	Best: O[N]
	Worst: O[N]
	Average: O[N]
	*/
	
	
	@Test
	public void example1() {
		String input = "AABAAB";
		int k = 2;
		Assert.assertEquals(6, bruteForce(input, k));
		Assert.assertEquals(6, slidingWindow(input, k));
		Assert.assertEquals(6, countOfMax(input, k));

	}

	@Test
	public void example2() {
		String input = "ABBACCA";
		int k = 2;
		Assert.assertEquals(4, bruteForce(input, k));
		Assert.assertEquals(4, slidingWindow(input, k));
		Assert.assertEquals(4, countOfMax(input, k));
	}

	@Test
	public void example3() {
		String input = "ABCCC";
		int k = 2;
		Assert.assertEquals(3, bruteForce(input, k));
		Assert.assertEquals(5, slidingWindow(input, k));
		Assert.assertEquals(5, countOfMax(input, k));
	}

	@Test
	public void example4() {
		String input = "AABBAACC";
		int k = 2;
		Assert.assertEquals(6, bruteForce(input, k));
		Assert.assertEquals(6, slidingWindow(input, k));
		Assert.assertEquals(6, countOfMax(input, k));
	}
	
	@Test
	public void example5() {
		String input = "ABCDABCCC";
		int k = 4;
		//Assert.assertEquals(8, bruteForce(input, k));
		Assert.assertEquals(8, slidingWindow(input, k));
		Assert.assertEquals(8, countOfMax(input, k));
	}
	
	@Test
	public void example6() {
		String input = "AABCBB";
		int k = 2;
		//Assert.assertEquals(8, bruteForce(input, k));
		Assert.assertEquals(5, slidingWindow(input, k));
		Assert.assertEquals(5, countOfMax(input, k));
	}

	private int bruteForce(String input, int k) {
		int len = 0, maxLen = Integer.MIN_VALUE;

		for (int i = 0; i < input.length(); i++) {
			int cnt = k;
			len = 1;
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) != input.charAt(j))
					cnt--;
				if (cnt < 0)
					break;
				len++;
			}
			maxLen = Math.max(maxLen, len);
		}
		return maxLen;
	}

	private int slidingWindow(String input, int k) {
		Map<Character, Integer> map = new HashMap<>();
		char[] carr = input.toCharArray();
		int len = carr.length;
		int start = 0, end = 0;
		int maxOcc = 0, maxLen = Integer.MIN_VALUE;

		while (end < len) {
			map.put(carr[end], map.getOrDefault(carr[end], 0) + 1);
			maxOcc = Math.max(maxOcc, map.get(carr[end++]));

			if (end - start - maxOcc > k)
				map.put(carr[start], map.get(carr[start++]) - 1);

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}

	private int slidingWindow1(String input, int k) {
		Map<Character, Integer> map = new HashMap<>();
		char[] carr = input.toCharArray();
		int start = 0, end = 0;
		int maxOcc = 0, maxLen = Integer.MIN_VALUE;
		while (end < carr.length) {
			map.put(carr[end], map.getOrDefault(carr[end], 0) + 1);
			maxOcc = Collections.max(map.values());
			if (end - start - maxOcc + 1 > k) {
				if (map.get(carr[start]) > 1)
					map.put(carr[start], map.get(carr[start]) - 1);
				else
					map.remove(carr[start]);
				start++;
			}
			maxLen = Math.max(maxLen, end - start + 1);
			end++;
		}
		return maxLen;
	}

	public int countOfMax(String s, int k) {
		int len = s.length();
		int[] count = new int[26];
		int start = 0, end = 0, maxCount = 0, maxLength = 0;
		while (end < len) {
			maxCount = Math.max(maxCount, ++count[s.charAt(end++) - 'A']);

			if (end - start - maxCount > k)
				count[s.charAt(start++) - 'A']--;

			maxLength = Math.max(maxLength, end - start);
		}
		return maxLength;
	}

}
