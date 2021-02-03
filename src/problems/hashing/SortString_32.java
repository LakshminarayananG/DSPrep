package problems.hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;



public class SortString_32 {
	
	/*
	Sort based on another String
	Given one string ('abbceeeg') sort it based on another string ('egbca')
	Result will be: 'eeegbbca'
	Do it less O[N2] => O[nlogn] => O[N]
	String s1 ="abbceeeg";
	String s2 = "egbca";
	Lowercase Alphabets
	No built sort functions !!
	*/
	
	@Test
	public void example1() {
		String input="abbceeeg";
		String pattern="egbca";
		System.out.println(rearrangeString(input, pattern));
	}
	
	@Test
	public void example2() {
		String input="abbceee";
		String pattern="egbca";
		System.out.println(rearrangeString(input, pattern));
	}
	
	@Test
	public void example3() {
		String input="abbceeeg";
		String pattern="ebca";
		System.out.println(rearrangeString(input, pattern));
	}
	
	private String rearrangeString(String input, String pattern) {
		Map<Character, Integer> map = new HashMap<>();
		char[] inpArr = input.toCharArray();
		char[] patArr = pattern.toCharArray();
		for (char c : inpArr)
			map.put(c, map.getOrDefault(c, 0) + 1);
		String op = "";
		int cnt = 0;

		for (char c : patArr) {
			cnt = map.getOrDefault(c, -1);

			if (cnt < 0)
				throw new RuntimeException("Invalid input");

			if (cnt > 1)
				for (int i = 0; i < cnt; i++)
					op += c;
			else
				op += c;
		}
		return op;
	}
}
