package problems.hashing;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;


public class LongestPalindrome_39 {
	
	/*
	 * Given a string s which consists of lowercase or uppercase letters, return the
	 * length of the longest palindrome that can be built with those letters.
	 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
	 * here. Example 1: Input: s = "abccccdd" Output: 7 Explanation: One longest
	 * palindrome that can be built is "dccaccd", whose length is 7. Example 2:
	 * Input: s = "a" Output: 1 Example 3: Input: s = "bb" Output: 2
	 */

	@Test
	public void example1() {
		String s = "abccccdd";
		Assert.assertEquals(7, findLongestPalindrome(s));
	}

	@Test
	public void example2() {
		String s = "a";
		Assert.assertEquals(1, findLongestPalindrome(s));
	}

	@Test
	public void example3() {
		String s = "bb";
		Assert.assertEquals(2, findLongestPalindrome(s));
	}
	
	@Test
	public void example4() {
		String s = "Aa";
		Assert.assertEquals(1, findLongestPalindrome(s));
	}
	
	@Test
	public void example5() {
		String s = "cccc";
		Assert.assertEquals(4, findLongestPalindrome(s));
	}

	private int findLongestPalindrome(String s) {
		Set<Character> set=new HashSet<>();
		
		for(char c: s.toCharArray())
			if(!set.add(c))
				set.remove(c);
		
		if(!set.isEmpty())
			return s.length()-set.size()+1;
		
		return s.length();
	}
}
