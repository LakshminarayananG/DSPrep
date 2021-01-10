package week17.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.Test;

public class ValidParanthesis {
	
	/*
	 * Given a string s containing just the characters '(',')','{','}','[', and ']',
	 * determine if the input string is valid.
	 */
	
	/*
	 *  Approach
	 *  1. Add all the starting bracket as key and ending as value to map
	 *  2. Declare a stack and iterate from the start to end of string
	 *  3. Check if current character is either a key or value of map
	 *  4. If its a key, add the value to stack
	 *  5. If its value, check if stack contains the key on top (() or if the stack is empty. if any of the above
	 *  two is true, return false
	 *  6. Return true finally
	 */

	@Test
	public void eg1() {
		String input = "())";
		System.out.println(validbrackets(input));
	}

	@Test
	public void eg2() {
		String input = "()()";
		System.out.println(validbrackets(input));
	}

	@Test
	public void eg3() {
		String input = "{}";
		System.out.println(validbrackets(input));
	}

	@Test
	public void eg4() {
		String input = "())}";
		System.out.println(validbrackets(input));
	}

	private boolean validbrackets(String input) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (map.containsKey(ch)) {
				stack.push(map.get(ch));
			} else if (map.containsValue(ch)) {
				if (stack.isEmpty() || stack.peek() != ch) {
					return false;
				}
				stack.pop();
			}
		}
		return true;
	}
	
	private boolean validate(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if(c=='(') stack.push(')');
			else if(c=='{') stack.push('}');
			else if(c=='[') stack.push(']');
			else if(stack.isEmpty() || stack.pop()!=c) return false;
		}		
		return true;
	}

}
