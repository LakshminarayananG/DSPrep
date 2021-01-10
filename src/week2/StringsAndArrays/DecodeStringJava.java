package week2.StringsAndArrays;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;


public class DecodeStringJava {
	
	//https://zhuhan0.blogspot.com/2017/09/394-decode-string.html
	
	/*
	2) Given an encoded string, return its decoded string.

	Input: s = "3[a]2[bc]"
	Output: "aaabcbc"

	Input: s = "3[a2[c]]"
	Output: "accaccacc"
	*/
	
	@Test
	public void example1() {
		String input = "3[a]2[bc]";
		decodeString(input);
	}

	@Test
	public void example2() {
		String input = "3[a2[c]]";
		decodeString(input);
	}

	private void decodeString(String s) {

		if (s.length() == 0 || s == null) {
			System.out.println(s);
		}
		Stack<String> strStack = new Stack<String>();
		Stack<Integer> numStack = new Stack<Integer>();
		StringBuilder res = new StringBuilder();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int num = 0;
				while (Character.isDigit(s.charAt(idx))) {
					num = num * 10 + (s.charAt(idx) - '0');
					idx++;
				}
				numStack.push(num);
			} else if (s.charAt(idx) == '[') {
				strStack.push(res.toString());
				res = new StringBuilder("");
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(strStack.pop());
				int repeatTimes = numStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp;
				idx++;
			} else {
				res.append(s.charAt(idx++));
			}
		}

		System.out.println(res.toString());
	}

}
