package assignments;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class LongestPalindromicSubString {
	
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
	
	
	@Test
	public void example5() {
		String input = "acbcacba";
		int longest=palindromelongest(input);
		System.out.println(longest);
	}

	
	
	
	private List<String>  palindrome(String input) {
		int longest=0;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String str = input.substring(i, j);
				if (str.equals(new StringBuilder(str).reverse().toString()))
					list.add(str);
			}
		}
		for (String string : list) {
			if(string.length()>longest) {
				longest=string.length();
			}
		}
		return list;
	}


	private int  palindromelongest(String input) {
		int longest=0;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String str = input.substring(i, j);
				if (str.equals(new StringBuilder(str).reverse().toString()))
					list.add(str);
			}
		}
		for (String string : list) {
			if(string.length()>longest) {
				longest=string.length();
			}
		}
		return longest;
	}

}
