package week24.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/*
Given a string S with both lowercase and uppercase letters, return the biggest ASCII letter that appears both in lowercase and uppercase. 
The returned letter must be in uppercase. If there is no such letter, return 'NO'.
Examples:
'aaabcAbCdD', return 'D'
'aA', return 'A'
'abcdE', return 'NO'
'a', return 'NO'
*/

public class P2_ReturnHighValDup {

	@Test
	public void example1() {
		String input = "aaabcAbCdD";
		System.out.println(findHighDup(input));
	}

	@Test
	public void example2() {
		String input = "aA";
		System.out.println(findHighDup(input));
	}

	@Test
	public void example3() {
		String input = "abcdE";
		System.out.println(findHighDup(input));
	}

	@Test
	public void example4() {
		String input = "aaabcAbCd";
		System.out.println(findHighDup(input));
	}

	// Pseudo code
	/*
	 * add each characters from the input string to a list find the max character
	 * (in terms of ascii) from the list using collections.max() 
	 * convert max character to upper case and find whether the upper case is present in the list 
	 * if present return the upper case of max duplicate 
	 * if not present, return "NO"
	 */
	// Space complexity: O[N]
	// Time complexity: O[N]
	private String findHighDup(String input) {
		if (input.length() < 2)
			return "NO";
		
		List<Character> list = new ArrayList<>();
		for (char c : input.toCharArray())
			list.add(c);

		char max = Collections.max(list);
		char uMax = Character.toUpperCase(max);
		if (list.contains(uMax))
			return ""+uMax;
		
		return "NO";
	}
}
