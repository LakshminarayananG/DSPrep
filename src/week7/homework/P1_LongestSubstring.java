package week7.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class P1_LongestSubstring {

	@Test
	public void example1() {
		String input = "eceba";
		longSubstring(input);
	}

	@Test
	public void example2() {
		String input = "ccaabbb";
		longSubstring(input);
	}

	@Test
	public void example3() {
		String input = "aaabbbb";
		longSubstring(input);
	}

	@Test
	public void example4() {
		String input = "abcd";
		longSubstring(input);
	}

	@Test
	public void example5() {
		String input = "caccabbbb";
		longSubstring(input);
	}

	@Test
	public void example6() {
		String input = "bbbb";
		longSubstring(input);
	}

	private void longSubstring(String input) {
		// Set<Character> set = new HashSet<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0;
		String op = "";

		while (end < input.length()) {
			map.put(input.charAt(end), map.getOrDefault(input.charAt(end++), 0) + 1);

			if (map.size() == 2) {
				op = op.length() >= input.substring(start, end).length() ? op : input.substring(start, end);
			} else if (map.size() > 2) {
				if (map.get(input.charAt(start)) > 1)
					map.put(input.charAt(start), map.get(input.charAt(start)) - 1);
				else
					map.remove(input.charAt(start));

				start++;
			}
		}

		if (op.length() > 0)
			System.out.println(op);
		else
			System.out.println("NO RESULT");

		/*
		 * for (int i = 0; i < input.length(); i++) { set.add(input.charAt(i));
		 * 
		 * if (set.size() == 2) { temp = input.indexOf(input.charAt(i)); op =
		 * op.length() >= input.substring(start, i + 1).length() ? op :
		 * input.substring(start, i + 1); } else if (set.size() > 2) {
		 * set.remove(input.charAt(start)); start = temp; } }
		 * 
		 * System.out.println(op);
		 */
	}

	private void longSubstring2(String input) {
		Set<Character> set;
		String op = "";

		for (int i = 0; i < input.length(); i++) {
			set = new HashSet<Character>();
			for (int j = i; j < input.length(); j++) {
				set.add(input.charAt(j));

				if (set.size() > 2) {
					op = op.length() >= input.substring(i, j).length() ? op : input.substring(i, j);
					break;
				}
			}

			if (set.size() == 2)
				op = op.length() >= input.substring(i, input.length()).length() ? op
						: input.substring(i, input.length());
		}

		System.out.println(op);
	}

	private void longSubstring1(String input) {
		int l = input.length();
		String op = "";
		Set<String> set;

		for (int i = 0; i <= l; i++) {
			String temp = input.substring(i, l);
			set = new HashSet<>(Arrays.asList(temp.split("")));

			if (set.size() == 2 && op.length() < temp.length())
				op = temp;
		}

		for (int i = l; i > 0; i--) {
			String temp = input.substring(0, i);
			set = new HashSet<>(Arrays.asList(temp.split("")));

			if (set.size() == 2 && op.length() < temp.length())
				op = temp;
		}

		System.out.println(op);
	}
}
