package week7.homework;

import org.junit.Test;

public class P3_ReverseSentence {

	@Test
	public void example1() {
		String input = "I am doing great";
		reverseSentence(input);
	}

	@Test
	public void example2() {
		String input = "Let’s take LeetCode contest";
		reverseSentence(input);
	}

	private void reverseSentence(String input) {
		String op = "";

		for (String s : input.split(" "))
			op += new StringBuilder(s).reverse().toString() + " ";

		System.out.println(op.trim());
	}

	private void reverseSentence1(String input) {
		String op = "";

		for (String s : input.split(" ")) {
			/*int left = 0, right = s.length() - 1;
			String[] ind = s.split("");
			while (left < right) {
				String temp = ind[left];
				ind[left++] = ind[right];
				ind[right--] = temp;
			}*/
			String[] ind = strReverse(s.split(""));
			op += String.join("", ind) + " ";
		}

		System.out.println(op.trim());
	}

	private void reverseSentence2(String input) {

		String[] s = input.split("");
		String join = String.join("", strReverse(s));
		String op = String.join(" ", strReverse(join.split(" ")));

		System.out.println(op);

	}

	public String[] strReverse(String[] s) {
		int left = 0, right = s.length - 1;

		while (left < right) {
			String temp = s[left];
			s[left++] = s[right];
			s[right--] = temp;
		}
		return s;
	}
}
