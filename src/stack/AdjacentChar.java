package stack;

import java.util.Stack;

import org.junit.Test;

public class AdjacentChar {
	
	@Test
	public void eg1() {
		String input="abbaca";
		System.out.println("Example 1: "+retadjnew(input));
	}
	
	@Test
	public void eg2() {
		String input="lakshmi";
		System.out.println("Example 2: "+retadj(input));
	}
	
	@Test
	public void eg3() {
		String input="ababccba";
		System.out.println("Example 3: "+retadj(input));
	}
	
	
	private String retadj(String S) {
		Stack<Character> stack = new Stack<>();
		stack.push(S.charAt(0));
		for(int i=1;i<S.toCharArray().length;i++) {
			if(stack.isEmpty()) {
			stack.push(S.charAt(i));	
			}
			else {
			char firstel=stack.peek();
			if(firstel==S.charAt(i)) {
				stack.pop();
			}
			else {
				stack.push(S.charAt(i));
			}
			}
		}
		String output="";
		for (Character character : stack) {
			output+=character;
		}
		
		return output;
	}
	
	
	
	private String retadjnew(String input) {
		Stack<Character> stack = new Stack<>();
		stack.push(input.charAt(0));
		for (Character c : input.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().equals(c)) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (Character character : stack) {
			sb.append(character);
		}

		return stack.toString();

	}

}
