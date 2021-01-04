package week11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class AnagramIndices {
	
	/*
	Given 2 strings, find all the start indices of second string anagrams in first string.
	Note:
	Strings consists of lowercase letters only 
	The order of output does not matter.
	Input:
	s: "abab" p: "ab"
	Output:
	[0, 1, 2]
	Input:
	s: "testetr" p: "te"
	Output:
	[0, 3, 4]
	Sliding Window + HashMap 
	*/
	
	
	//Pseudocode
	/*
	 * add all characters in p including its occuerances in a map
	 * slide through each element in s and add it another map  and compare both maps
	 * if matches, return the start index  
	 */

	/*
	 * take 2 pointers where one starts with 0 and another starts with length of second string
	 * take the substring of range start to end from s and replace characters from p in the substring as null
	 * if the output string returns 0 size then add start index to list
	 * increment both the pointers
	 * finally return the list with all the indexes
	 */
	
	
	@Test
	public void example1() {
		String s = "abab";
		String p = "ab";
		returnIndex(s, p);
	}

	@Test
	public void example2() {
		String s = "testetr";
		String p = "te";
		returnIndex(s, p);
	}
	
	@Test
	public void example3() {
		String s = "ab";
		String p = "ba";
		returnIndex(s, p);
	}

	private void returnIndex(String s, String p) {
		List<Integer> list = new ArrayList<>();
		int start=0,end=p.length();
		while(end<=s.length()) {
			String re = s.substring(start, end).replaceAll("["+p+"]+", "");
			if(re.length()==0)
				list.add(start);
			start++;
			end++;
		}
		System.out.println(list);
	}
	
	@Test
	public void eg1() {
		String s = "abab";
		String p = "ab";
		System.out.println("One:" + findStartOfAnangram(s, p));
		System.out.println("One:" + findanagram(s, p));
	}

	@Test
	public void eg2() {
		String s = "testetr";
		String p = "te";
		System.out.println("Two:" + findStartOfAnangram(s, p));
		System.out.println("Two:" + findanagram(s, p));
	}

	@Test
	public void eg3() {
		String s = "abcabc";
		String p = "abc";
		System.out.println("Three:" + findStartOfAnangram(s, p));
		System.out.println("Three:" + findanagram(s, p));
	}

	@Test
	public void eg4() {
		String s = "aabcdcs";
		String p = "saabcdc";
		System.out.println("Four:" + findStartOfAnangram(s, p));
		System.out.println("Four:" + findanagram(s, p));
	}

	@Test
	public void eg5() {
		String s = "abc";
		String p = "abcd";
		System.out.println("Five:" + findStartOfAnangram(s, p));
		System.out.println("Five:" + findanagram(s, p));
	}

	@Test
	public void eg7() {
		String s = "abbefaab";
		String p = "aab";
		System.out.println("Seven:" + findanagram(s, p));
	}

	@Test
	public void eg8() {
		String s = "abab";
		String p = "ba";
		System.out.println("Eight:" + findanagram(s, p));
	}
	
	
	private void returnIndex1(String s, String p) {
		List<Integer> list = new ArrayList<>();
		Map<Character, Integer> smap = new HashMap<>();
		Map<Character, Integer> pmap = new HashMap<>();

		for (char c : p.toCharArray())
			pmap.put(c, pmap.getOrDefault(c, 0) + 1);

		int k = p.length();
		int start = 0, end = 0;

		while (end < s.length()) {
			smap.put(s.charAt(end), smap.getOrDefault(s.charAt(end), 0) + 1);

			if (end >= k) {
				if (smap.get(s.charAt(start)) > 1)
					smap.put(s.charAt(start), smap.get(s.charAt(start)) - 1);
				else
					smap.remove(s.charAt(start));
				start++;
			}

			if (smap.equals(pmap))
				list.add(start);

			end++;
		}
		System.out.println(list);
	}
	
	
	private List<Integer> findanagram(String input, String anag) {
		HashMap<Character, Integer> anagram = new HashMap<Character, Integer>();
		HashMap<Character, Integer> inputtext = new HashMap<Character, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < anag.length(); i++) {
			anagram.put(anag.charAt(i), anagram.getOrDefault(anag.charAt(i), 0) + 1);
		}

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			inputtext.put(ch, inputtext.getOrDefault(ch, 0) + 1);

			if (i >= anag.length()) {
				ch = input.charAt(i - anag.length());
				if (inputtext.get(ch) == 1) {
					inputtext.remove(ch);
				} else {
					inputtext.put(ch, inputtext.get(ch) - 1);
				}
			}

			if (inputtext.equals(anagram)) {
				list.add(i - anag.length() + 1);
			}
		}
		return list;

	}
	
	
	private List<Integer> findStartOfAnangram(String s, String p) {
		List<Integer> output = new ArrayList<>();

		if (p.length() <= s.length()) {
			int[] refArray = new int[26];
			for (int i = 0; i < p.length(); i++) {
				refArray[p.charAt(i) - 'a']++;
			}
			int start = 0;
			int end = 0;
			int match = 0;
			while (start < s.length()) {
				if (refArray[s.charAt(start) - 'a'] > 0) {
					refArray[s.charAt(start) - 'a']--;
					start++;
					match++;
				} else {
					refArray[s.charAt(end) - 'a']++;
					end++;
					match--;
				}
				if (match == p.length()) {
					output.add(end);
				}
			}

		}
		return output;
	}

}
