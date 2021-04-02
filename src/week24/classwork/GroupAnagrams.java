package week24.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/

public class GroupAnagrams {

	@Test
	public void example1() {
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		// System.out.println(bruteForce(input));
		System.out.println(groupAnagrams(input));
	}

	@Test
	public void example2() {
		String[] input = { "eat", "teea", "tan", "ate", "nat", "bat" };
		// System.out.println(bruteForce(input));
		System.out.println(groupAnagrams(input));
	}

	private List<List<String>> bruteForce(String[] input) {
		String[] output = new String[input.length];

		for (int i = 0; i < input.length; i++) {
			String[] split = input[i].split("");
			Arrays.sort(split);
			output[i] = String.join("", split);
		}

		System.out.println(Arrays.toString(output));
		List<List<String>> foutput = new ArrayList<>();

		for (int i = 0; i < output.length; i++) {
			if (output[i] == "")
				continue;
			List<String> temp = new ArrayList<>();
			temp.add(input[i]);
			for (int j = i + 1; j < output.length; j++) {
				if (output[i].equals(output[j])) {
					temp.add(input[j]);
					output[j] = "";
				}
			}
			foutput.add(temp);
		}

		return foutput;
	}

	private List<List<String>> groupAnagrams(String[] input) {
		List<List<String>> output = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		
		for (int i = 0; i < input.length; i++) {
			char[] temp = input[i].toCharArray();
			Arrays.sort(temp);
			String key = String.valueOf(temp);

			List<String> list = new ArrayList<>();
			
			if (map.containsKey(key))
				list = map.get(key);

			list.add(input[i]);
			map.put(key, list);

		}

		for (Map.Entry<String, List<String>> m : map.entrySet())
			output.add(m.getValue());

		return output;
	}

}
