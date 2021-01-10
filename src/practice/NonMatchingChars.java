package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class NonMatchingChars {

	@Test
	public void example1() {
		String s1 = "Amazon";
		String s2 = "India";
		System.out.println(findNonMatchingChars(s1, s2));
	}

	@Test
	public void example2() {
		String s1 = "Amazon";
		String s2 = "West";
		System.out.println(findNonMatchingChars(s1, s2));
	}

	@Test
	public void example3() {
		String s1 = "Amazon";
		String s2 = "Amazon";
		System.out.println(findNonMatchingChars(s1, s2));
	}

	@Test
	public void example4() {
		String s1 = "Amazon";
		String s2 = "amzon";
		System.out.println(findNonMatchingChars(s1, s2));
	}

	@Test
	public void eg2() {
		String s1 = "Amazon";
		String s2 = "India";
		char[] nonMatchingChars = nonMatchSet(s1, s2);
		System.out.println(nonMatchingChars);

	}

	// Using Map Approach
	// Complexity O[N] +O[N] +O[N]
	private char[] findNonMatchingChars(String s1, String s2) {
		ArrayList<Character> charArray = new ArrayList<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (Character character : s1.toCharArray()) {
			if (!map.containsKey(character)) {
				map.put(character, 1);
			}
		}

		for (Character character : s2.toCharArray()) {
			map.put(character, map.getOrDefault(character, 0) + 1);
		}

		for (Character character : map.keySet()) {
			if (map.get(character) == 1) {
				charArray.add(character);
			}

		}
		return charArray.toString().toCharArray();

	}

	// Alternate Approach
	public char[] nonMatchSet(String s1, String s2) {
		Set<Character> input = new HashSet<Character>();
		List<Character> inputList = new ArrayList<Character>();
		for (int i = 0; i < s1.length(); i++) {
			input.add(s1.charAt(i));
		}
		inputList.addAll(input);

		for (int j = 0; j < s2.length(); j++) {
			if (input.add(s2.charAt(j))) {
				inputList.add(s2.charAt(j));
			} else {
				inputList.remove(Character.valueOf(s2.charAt(j)));
			}
		}
		return inputList.toString().toCharArray();
	}

}
