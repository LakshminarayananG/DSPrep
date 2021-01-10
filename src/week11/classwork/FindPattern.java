package week11.classwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class FindPattern {
	
	/*
	Given a pattern and a string s, find if s follows the same pattern.
	Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
	Example 1:
	Input: pattern = "abba", s = "dog cat cat dog"
	Output: true
	Example 2:
	Input: pattern = "abba", s = "dog cat cat fish"
	Output: false
	Input: pattern = "abc", s = "hello world world"
	Output: false
	Algorithm: HashMap 
	*/

	/*
	 * add unique pattern chars to list
	 * iterate through each element in string s
	 * if it is in map then add to map assign the value as first char in list then remove it from list
	 * if list is empty, don't add it to map
	 * each time when key is added to map, create a format
	 * if generated format equal to given format return true else false
	 */

	/*
	 * iterate through each element in both string parallely
	 * if the map contains the word but doesn't contains the pattern character return false
	 * if map doesn't contains the word but contains the pattern character return false
	 * else add both word and pattern character to map
	 * finally return true (as it matches pattern)
	 */
	
	
	@Test
	public void example1() {
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example2() {
		String pattern = "abba";
		String s = "dog cat cat fish";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example3() {
		String pattern = "abc";
		String s = "hello world world";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example4() {
		String pattern = "abc";
		String s = "hello world World";
		System.out.println(findPattern(pattern, s));
	}

	@Test
	public void example5() {
		String pattern = "abc";
		String s = "a b c";
		System.out.println(findPattern(pattern, s));
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

	private boolean findPattern1(String pattern, String s) {
		List<Character> list = new ArrayList<>();
		for (char c : pattern.toCharArray())
			if (!list.contains(c))
				list.add(c);

		Map<String, Character> map = new HashMap<>();
		String op = "";
		for (String sp : s.split(" ")) {
			if (map.containsKey(sp))
				op += map.get(sp);
			else if (!map.containsKey(sp) && list.size() > 0) {
				map.put(sp, list.get(0));
				op += map.get(sp);
				list.remove(0);
			}
		}

		return op.equals(pattern);
	}
	
	
	/*//Approach
	1. Check for length of pattern, convert s to string array and find it length,
	throw exception in case of mismatch
	2. convert pattern to char array, for each character add corresponding index
	from string array (pattern as key and string corresponding as value)
	3. Check if map already has the pattern as key, if so,
	check the corresponding index value in string array matches with map value, if yes bool to true,if not false
	4. return exception incase length of pattern and input doesn't match
	*/


	@Test
	public void eg1() throws Exception {
		String pattern = "abba";
		String input = "dog cat cat dog";
		System.out.println("Test case 1: " + patternMatch(pattern, input));
	}

	@Test
	public void eg2() throws Exception {
		String pattern = "abba";
		String input = "dog cat cat Dog";
		System.out.println("Test case 2: " + patternMatch(pattern, input));
	}

	@Test
	public void eg3() throws Exception {
		String pattern = "abba";
		String input = "hello world world";
		System.out.println("Test case 3: " + patternMatch(pattern, input));
	}

	@Test
	public void eg4() throws Exception {
		String pattern = "abba";
		String input = "hello world world how";
		System.out.println("Test case 4: " + patternMatch(pattern, input));
	}

	@Test
	public void eg5() throws Exception {
		String pattern = "abc";
		String input = "dog dog dog";
		System.out.println("Test case 5: " + patternMatch(pattern, input));
	}

	@Test
	public void eg6() throws Exception {
		String pattern = "abc";
		String input = "cat cat cat";
		System.out.println("Test case 6: " + patternMatch(pattern, input));
	}
	
	

	private boolean patternMatch(String pattern, String input) throws Exception {
		if (pattern.length() != input.split(" ").length) {
			return false;
		}

		String[] inputarr = input.split(" ");
		Set<Character> setchar = new HashSet<Character>();
		Set<String> inpset = new HashSet<String>();
		for (String string : inputarr) {
			inpset.add(string);
		}

		for (Character ch : pattern.toCharArray()) {
			setchar.add(ch);
		}

		if (setchar.size() != inpset.size()) {
			return false;
		}

		Map<String, Character> map = new HashMap<String, Character>();
		boolean result = true;
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(inputarr[i])) {
				if (map.get(inputarr[i]).equals(pattern.charAt(i))) {
					result = true;
				} else {
					return false;
				}
			} else {
				map.put(inputarr[i], pattern.charAt(i));
			}
		}
		return result;

	}


}
