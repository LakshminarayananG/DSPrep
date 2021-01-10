package week15.weekwork;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
Given a string S, return the number of substrings that have only one distinct letter.

Example 1:

Input: S = "aaaba"
Output: 8
Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
"aaa" occurs 1 time.
"aa" occurs 2 times.
"a" occurs 4 times.
"b" occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.
Example 2:

Input: S = "aaaaaaaaaa"
Output: 55

Constraints:
1 <= S.length <= 1000
S[i] consists of only lowercase English letters.
*/

public class SubstringCount {

	@Test
	public void example1() {
		String input = "aaaba";
		numberOfSubstrings(input);

	}

	@Test
	public void example2() {
		String input = "aaaaaaaaaa";
		numberOfSubstrings(input);
	}

	public void numberOfSubstrings(String input) {
		int start = 0;
		int sum = 0;
		for (int end = 0; end < input.length(); end++) {
			if (input.charAt(start) == input.charAt(end))
				sum += end - start + 1;
			else {
				start = end;
				sum += 1;
			}
		}
		System.out.println(sum);
	}

	public void numberOfSubstrings1(String input) {
		int sum = 0;

		for (int i = 0; i < input.length(); i++) {
			int cnt = 1;
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(j) == input.charAt(i))
					cnt++;
				else
					break;
			}
			sum += cnt;
		}

		System.out.println(sum);
	}
}
