package week6.stacksAndQueue;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Test;

public class P3_SimplifyPath {

	@Test
	public void example1() {
		String str = "/home/";
		simplifyPath(str);
	}

	@Test
	public void example2() {
		String str = "/../";
		simplifyPath(str);
	}

	@Test
	public void example3() {
		String str = "/home//foo/";
		simplifyPath(str);
	}

	@Test
	public void example4() {
		String str = "/a/./b/../../c/";
		simplifyPath(str);
	}

	@Test
	public void example5() {
		String str = "/a/../../b/../c//.//";
		simplifyPath(str);
	}

	@Test
	public void example6() {
		String str = "/a//b////c/d//././/..";
		simplifyPath(str);
	}

	@Test
	public void example7() {
		String str = "/.";
		simplifyPath(str);
	}

	private void simplifyPath1(String str) {
		Stack<String> stack = new Stack<>();
		String[] col = str.split("/");

		for (String s : col) {
			if (s.equals(".") || s.isEmpty())
				continue;
			else if (s.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.push(s);
		}

		String op = "/";
		if (stack.size() < 1)
			System.out.println(op);
		else {
			for (String st : stack)
				op += st + "/";
			System.out.println(op.substring(0, op.length() - 1));
		}
	}

	private void simplifyPath(String str) {
		Stack<Character> stack = new Stack<>();

		for (char c : str.toCharArray()) {
			if (stack.isEmpty())
				stack.push(c);
			else if (stack.peek() == '/' && c == '/')
				continue;
			else if (stack.peek() == '.' && c == '/')
				stack.pop();
			else if (stack.peek() == '.' && c == '.') {
				stack.pop();
				stack.pop();
				if (stack.isEmpty())
					stack.push('/');
				else
					stack.pop();
			} else
				stack.push(c);
		}

		String op = "";
		Iterator<Character> it = stack.iterator();
		while (it.hasNext())
			op += it.next();

		if (op.length() > 1 && (op.charAt(op.length() - 1) == '/' || op.charAt(op.length() - 1) == '.'))
			op = op.substring(0, op.length() - 1);

		System.out.println(op);

	}
}
