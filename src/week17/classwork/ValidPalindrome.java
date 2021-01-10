package week17.classwork;

import org.junit.Test;

public class ValidPalindrome {
	
	/*
	 * Given a non-empty string s, you may delete at most one character. Judge
	 * whether you can make it a palindrome.
	 * 
	 * Example 1: Input: "aba" Output: True 
	 * Example 2: Input: "abca" Output: True
	 * Explanation: You could delete the character 'c'.
	 */
	
	@Test
	public void eg1() {
		String s="aba";
		System.out.println(validPalindrome(s));
	}
	
	@Test
	public void eg2() {
		String s="abca";
		System.out.println(validPalindrome(s));
	}
	
	@Test
	public void eg3() {
		String s="abcba";
		System.out.println(validPalindrome(s));
	}
	
	
	
	public boolean validPalindrome(String s) {

		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
			left++;
			right--;
		}

		return true;

	}

	private boolean isPalindrome(String s, int left, int right) {

		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

}
