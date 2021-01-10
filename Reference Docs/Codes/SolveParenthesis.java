package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class SolveParenthesis {
	
	@Test
	public void example() {
		
		String str = "(({}))";
		boolean valid = isValid(str);
		System.out.println(valid);
	}
	
	private boolean isValid(String str) {

		/*
		 *  1) Map -> } -> { , ) -> ( , ] -> [
		 *  2) String -> each char -> traverse
		 *  3) Key exist -> stack -> pop -> popped value matches the -> no match -> STOP
		 *  4) key no exist -> stack -> push
		 */
		

		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');
		
		Stack<Character> stack = new Stack<>();
		for (Character character : str.toCharArray()) {
			char topElement = stack.isEmpty() ? ' ' : stack.pop();
			if(topElement != map.get(character)) {
				return false;
			} else {
				stack.push(character);
			}
		}
		return stack.isEmpty();
	}
}
