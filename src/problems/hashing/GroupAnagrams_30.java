package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;



public class GroupAnagrams_30 {
	
	/*
	Given an array of strings strs, group the anagrams together. You can return the answer in any order.
	Example 1:
	Input: strs = ["eat","tea","tan","ate","nat","bat"]
	Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	*/

	@Test
	public void example1() {
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(input));
	}

	@Test
	public void example2() {
		String[] input = { "eat", "teea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(input));
	}

	private List<List<String>> groupAnagrams(String[] input) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : input) {
			String ascii = findCharOcc(str);
			map.putIfAbsent(ascii, new ArrayList<>());
			map.get(ascii).add(str);
		}

		List<List<String>> output = map.entrySet().stream().flatMap(fm -> Stream.of(fm.getValue()))
				.collect(Collectors.toList());

		return output;
	}

	private String findCharOcc(String str) {
		char[] carr = str.toCharArray();
		int[] ascii = new int[26];
		for (char ch : carr)
			ascii[ch - 'a']++;

		return Arrays.toString(ascii);
	}

}
