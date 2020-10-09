package assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


	private int  palindromelongest(String str) {
		Set<Character> set= new HashSet<Character>();
		
		for(int i=0;i<str.length();i++) {
			if(set.contains(str.charAt(i))) {
				set.remove(str.charAt(i));
			}
			else {
				set.add(str.charAt(i));
			}
		}
		
		if(set.size()<=1) {
			return str.length();
		}
		
		else {
			return str.length()-set.size()+1;
		}
	}

}
