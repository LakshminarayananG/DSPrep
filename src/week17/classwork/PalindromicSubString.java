package week17.classwork;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PalindromicSubString {

	/*
	 * Brute Force 
	 * 1. Iterate from 0 to len-1 in outer for loop 
	 * 2. Use inner for loop from i+1 to len-1 
	 * 3.check if substring of 1 to j is a valid palindrome (Strinb builder reverse function) 
	 * 4. if so, add the substring to the list 
	 * 5. return list
	 *
	 */

	/*
	 * Given a string, return the list of all possible substrings that are
	 * palindrome 
	 * 1. Iterate from 0 to len-1 
	 * 2. for each iteration, call the function and check if the substring is a palindrome 
	 * 3. for every value of i,iterate to left & right side and check the substring is a palindrome 
	 * 4. Add all the substring to the list and return the output list
	 *
	 */

//@Test
	public void eg2() {
		String input = "abababa";
		System.out.println(expand(input));
	}

//@Test
	public void eg3() {
		String input = "abc";
		System.out.println(bruteforce(input));
	}

	private List<String> bruteforce(String input) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				String temp = input.substring(i, j);
				String reverse = new StringBuilder(temp).reverse().toString();
				if (temp.equals(reverse)) {
					list.add(temp);
				}
			}
		}
		return list;
	}

	@Test
	public void eg1() {
		String input = "baababb";
		System.out.println(expand(input));
	}

	private List<String> expand(String input) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			expandcenter(input, i, i, list);
			expandcenter(input, i, i + 1, list);
		}
		return list;

	}

	private void expandcenter(String input, int start, int end, List<String> list) {
		while (start >= 0 && end < input.length() && input.charAt(start) == input.charAt(end)) {
			list.add(input.substring(start, end + 1));
			start--;
			end++;
		}
	}

}
