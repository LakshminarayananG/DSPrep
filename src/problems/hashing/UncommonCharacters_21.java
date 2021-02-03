package problems.hashing;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;



public class UncommonCharacters_21 {
	
	/*
	Write a function that takes 2 strings as input and returns a string with uncommon characters of the input strings.
	Example: Input: String1 = "aabde" String2 = "cbaz"
	*/

	@Test
	public void example1() {
		String str1 = "aabde";
		String str2 = "cbaz";
		uncommonChars(str1, str2);
	}

	@Test
	public void example2() {
		String str1 = "amazon";
		String str2 = "india";
		uncommonChars(str1, str2);
	}

	private void uncommonChars(String str1, String str2) {
		int s1 = 0, s2 = 0;
		Set<Character> set = new HashSet<>();
		while (s1 < str1.length() || s2 < str2.length()) {
			if (s1 < str1.length() && !str2.contains(str1.subSequence(s1, s1 + 1)))
				set.add(str1.charAt(s1));
			if (s2 < str2.length() && !str1.contains(str2.subSequence(s2, s2 + 1)))
				set.add(str2.charAt(s2));
			s1++;
			s2++;
		}
		System.out.println(set);
	}
}
