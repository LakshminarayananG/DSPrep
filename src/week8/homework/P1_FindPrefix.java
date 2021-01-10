package week8.homework;

import org.junit.Test;

/*
https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
*/

public class P1_FindPrefix {

	@Test
	public void example1() {
		String input = "i love eating burger";
		String search = "burg";
		findPrefix(input, search);
	}

	@Test
	public void example2() {
		String input = "this problem is an easy problem";
		String search = "pro";
		findPrefix(input, search);
	}

	@Test
	public void example3() {
		String input = "i am tired";
		String search = "you";
		findPrefix(input, search);
	}

	@Test
	public void example4() {
		String input = "i use triple pillow";
		String search = "pill";
		findPrefix(input, search);
	}

	@Test
	public void example5() {
		String input = "hello from the other side";
		String search = "they";
		findPrefix(input, search);
	}

	private void findPrefix(String input, String search) {
		int ind = 0;
		boolean flag = false;

		for (String s : input.split(" ")) {
			if (s.startsWith(search)) {
				flag = true;
				break;
			}
			ind++;
		}

		System.out.println(flag ? ind + 1 : -1);
	}
}