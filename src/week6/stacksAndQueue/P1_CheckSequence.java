package week6.stacksAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class P1_CheckSequence {

	@Test
	public void example1() {
		String str = "()[{}]";
		// checkSeq(str);
		System.out.println(checkSeq(str));
	}

	@Test
	public void example2() {
		String str = "([)[{}]";
		// checkSeq(str);
		System.out.println(checkSeq(str));
	}

	private boolean checkSeq(String str) {
		StringBuilder sb = new StringBuilder(str);
		int s = 0, e = 1;

		while (sb.length() > 0) {
			int schar = (int) sb.charAt(s);
			if (schar + 1 == (int) sb.charAt(e) || schar + 2 == (int) sb.charAt(e)) {
				sb.deleteCharAt(e);
				sb.deleteCharAt(s);
				e = 1;
			} else {
				e++;
			}

			if (e == sb.length())
				return false;
		}

		return true;
	}

	private boolean checkSeq2(String str) {
		Map<Character, Integer> map = new HashMap<>();
		char[] ch = { '(', ')', '[', ']', '{', '}' };

		for (char c : str.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		for (int i = 0; i < ch.length / 2; i += 2) {
			if (map.get(ch[i]) != map.get(ch[i + 1]))
				return false;
		}
		return true;
	}

	private void checkSeq1(String str) {
		Map<Character, Character> map = new HashMap<>();

		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');

		Stack<Character> stack = new Stack<>();

		for (char c : str.toCharArray()) {

			if (!map.containsKey(c))
				stack.push(c);
			else if (map.get(c) == stack.peek())
				stack.pop();
		}

		if (stack.size() > 0)
			System.out.println("invalid");
		else
			System.out.println("valid");
	}
}
