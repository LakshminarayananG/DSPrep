package week19.weekwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class FW_ValidateBracket {
	
	
	
	
	/*
	 * 2) seq of paranthesis, validate whether it is valid or not(){}[]<>* char
	 * count odd then falseisLeftChar(char)isRightChar(char)isPair()
	 */
	
	@Test
	public void eg1() {
		String s="{{}}";
		System.out.println(validatebrackets(s));
		System.out.println(isvalidParanthesis(s));
		
	}
	
	@Test
	public void eg2() {
		String s="{[>>]}";
		System.out.println(validatebrackets(s));
		System.out.println(isvalidParanthesis(s));
	}
	
	@Test
	public void eg3() {
		String s="{}[<>]({})";
		System.out.println(validatebrackets(s));
		System.out.println(isvalidParanthesis(s));
	}
	
	@Test
	public void eg4() {
		String s="{}}";
		System.out.println(validatebrackets(s));
		System.out.println(isvalidParanthesis(s));
	}
	
	
	private boolean validatebrackets(String s) {
		if(s.length()%2!=0) return false;
		Map<Character,Character> map = new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		map.put('<', '>');
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			char ch =s.charAt(i);
			if(map.containsKey(ch)) {
				stack.push(map.get(ch));
			}
			else if(map.containsValue(ch)) {
				if(stack.isEmpty()||stack.pop()!=ch) return false;
			}
		}
		return true;
	}
	
	/*
	 * 1. CHeck the length of the string and if its odd, return false
	 * 2. Iterate through the string
	 * 3. If its an opening bracket, add to stack
	 * 4. If not, check if top element of stack is opening bracket and current char is closing bracket and 
	 *    the 2 chars put together make a valid string pair of bracket. if so, remove teh top element from stack
	 * 5. Check if stack is empty & return teh same
	 */
	
	
	private boolean isvalidParanthesis(String s) {
		if(s.length()%2!=0) return false;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(stack.isEmpty()||isLeft(ch)) stack.add(ch);
			else if(isLeft(stack.peek()) && isRight(ch) && isPair(""+stack.peek()+ch)) stack.pop();
			else return false;
		}
		
		return stack.isEmpty();
	}
	
	
	
	
	private boolean isLeft(char openchar) {
		Set<Character> set = new HashSet<Character>(Arrays.asList('[','{','<','('));
		return set.contains(openchar);
	}

	
	private boolean isRight(char closechar) {
		Set<Character> set = new HashSet<Character>(Arrays.asList(']','}','>',')'));
		return set.contains(closechar);
	}
	
	private boolean isPair(String pair) {
		Set<String> set = new HashSet<String>(Arrays.asList("[]","{}","()","<>")) ;
		return set.contains(pair);
	}

}
