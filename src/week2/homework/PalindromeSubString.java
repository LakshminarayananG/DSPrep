package week2.homework;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PalindromeSubString {
	
	/*
	6) Given a string, how many palindromic substrings in this string.
	Example 1:
	Input: "aaa"
	Output: 6
	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
	Example 2:
	Input: "aabc"
	Output: 5
	Explanation: Three palindromic strings: "a", "a", "b", "c", "aa".
	*/
	
	@Test
	public void example1() {
		String input = "aaa";
		List<String> max=palindrome(input);
		System.out.println(max);
		System.out.println(max.size());
	}

	@Test
	public void example2() {
		String input = "aabc";
		List<String> max=palindrome(input);
		System.out.println(max);
		System.out.println(max.size());
	}

	@Test
	public void example3() {
		String input = "abcd";
		List<String> max=palindrome(input);
		System.out.println(max);
		System.out.println(max.size());
	}

	@Test
	public void example4() {
		String input = "aabcad";
		List<String> max=palindrome(input);
		System.out.println(max);
		System.out.println(max.size());
	}

	private List<String>  palindrome(String input) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String str = input.substring(i, j);
				if (str.equals(new StringBuilder(str).reverse().toString()))
					list.add(str);
			}
		}
		//System.out.println(list.size());
		//System.out.println(list);
		return list;
	}
	
	
	/*
	 * Using expand around center
	 */
	
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
