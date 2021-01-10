package week14.homework;

import org.junit.Test;

public class CountDistinctSubStrings {
	
	/*
	* Given a string S, return the number of substrings that have only one distinct letter.
	*
	* Example 1:
	* Input S="aaaba"
	* Output : 8
	* Exp: Substring with 1 distinct letter are 'aaa', 'a','b',
	* 'aaa' occurs 1 time
	* 'aa' occurs 2 times
	* 'a' occurs 4 times
	* 'b' occurs 1 time
	*/

	/*
	* Approach:
	* 1. Convert the input to character array
	* 2. Assuming string length >=1, initialise count and output count to 1
	* 3. Iterate through the input string and check if current character and previous character are same
	* 4. If both are same, increment count and add the same to output count
	* 5. If both are different, add 1 to output count
	* 6. Return output count.
	*/

	@Test
	public void eg1() {
		String input = "aaaba";
		System.out.println(countdistinctChar(input));
	}

	@Test
	public void eg2() {
		String input = "aaaaa";
		System.out.println(countdistinctChar(input));
	}

	private int countdistinctChar(String S) {
		int count = 1;
		int outputcount = 1;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) != S.charAt(i - 1))
				count = 1;
			else
				count++;
			outputcount += count;
		}
		return outputcount;
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
