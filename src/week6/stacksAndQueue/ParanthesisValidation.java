package week6.stacksAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class ParanthesisValidation {
	
	@Test
	public void eg1() {
		String input="(({}))";
		System.out.println(isValid(input));
	}
	
	public boolean isValid(String input) {
		
		Map<Character,Character> map = new HashMap<>();
		map.put('}','{');
		map.put(')','(');
		map.put(']','[');
		
		Stack<Character> stack= new Stack<>();
		
		for (Character character : input.toCharArray()) {
			char topElement= stack.isEmpty() ? ' ' : stack.pop();			
			if(topElement!=map.get(character)) {
				return false;
				}
			else {
				stack.push(character);
			}
			}
		return stack.isEmpty();
		
		
	}

}
