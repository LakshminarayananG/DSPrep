package stack;

import java.util.Stack;

import org.junit.Test;

public class SimplifyPath {
	
	//@Test
	public void eg1() {
		String input="/a/./b/../../c/";
		simplifyPath(input);
	}
	
	//@Test
	public void eg2() {
		String input="/../";
		simplifyPath(input);
	}
	
	//@Test
	public void eg3() {
		String input="/home/";
		simplifyPath(input);
	}
	
	//@Test
	public void eg4() {
		String input="/home//foo/";
		simplifyPath(input);
	}
	
	//@Test
	public void eg5() {
		String input="/a/./b/../../c/";
		simplifyPath(input);
	}
	
	//@Test
	public void eg6() {
		String input="/a/../../b/../c//.//";
		simplifyPath(input);
	}
	
	//@Test
	public void eg7() {
		String input="/a//b////c/d//././/..";
		simplifyPath(input);
	}
	
	@Test
	public void eg8() {
		String input="/home/../../..";
		simplifyPath(input);
	}
	
	private void simplifyPath(String input){
		String s1 =  input.replaceAll("/+", "/");		
		String[] split = s1.split("/");
		
		
		Stack<String> stack  = new Stack<>();
		
		for (String string : split) {
			if(string.equals("..")&& stack.isEmpty()==false){
				stack.pop();
			}else if(!string.equals(".")){
				stack.push(string);
			}
		}
		String output="/";
		for (String string : stack) {
			if((output.length()>0) && 
					output.charAt(output.length()-1)=='/')
				output+=string;
			else
				output+="/"+string;
					
		}
		
		System.out.println(output);
	}

}
