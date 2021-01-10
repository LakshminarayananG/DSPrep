package assessment.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
A subsequence is a sequence of letters in a string, in order, but with any
number of characters removed. Vowels in order are the letters in the
string aeiou. Given a string, determine the length of the longest
subsequence that contains all of the vowels, in order, and no vowels
out of order.

Examples
s = 'aeeiiouu'
All 5 vowels are present in the correct order, so the length of the
entire string, 8, is returned.

s = 'aeeiiaouu'
Again, all 5 vowels are present in the correct order, though they don't
make the entire string. The 'a' at position 5 must be removed since it is
out of order, leaving 'aeeiiouu' with length 8.
*/

public class P5_FunWithVowels {

	@Test
	public void example1() {
		String input = "aeeiiouu";
		funWithVowels(input);
	}

	@Test
	public void example2() {
		String input = "aeeiiaouu";
		funWithVowels(input);
	}

	@Test
	public void example3() {
		String input = "aeiaaioooaauuaeiu";
		funWithVowels(input);
	}

	@Test
	public void example4() {
		String input = "aeiaaiooaa";
		funWithVowels(input);
	}

	@Test
	public void example5() {
		String input = "eouiuaaeiaoauaoaeauieeoiuiuiu";
		funWithVowels(input);
	}

	private void funWithVowels1(String input) {
		int start = input.indexOf('a'), end = input.lastIndexOf('u');
		List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int ind = 0, size = end - start + 1, i = start;

		while (i <= end) {
			if (input.charAt(i) == list.get(ind)) {
				i++;
				continue;
			} else if (input.charAt(i) >= list.get(ind) && input.charAt(i) == list.get(ind + 1)) {
				ind++;
			} else {
				size--;
				i++;
			}
		}

		System.out.println(size > 0 ? size : 0);
	}

	private void funWithVowels2(String input) {
		int start = input.indexOf('a'), end = input.lastIndexOf('u');
		char[] vow = { 'a', 'e', 'i', 'o', 'u' };
		// aouiiuaeeuuiuuauuauaeaeuauaeaaiuoiouaeuiuuoooaeeaioeieoeooaeu

		int ind = 0;
		int max = vow[ind++];
		// int max=input.charAt(start);
		int count = 1;
		for (int i = start + 1; i <= end; i++) {
			if (input.charAt(i) >= max) {
				if (input.charAt(i) == max) {
					count++;
				} else if (vow[ind] == input.charAt(i)) {
					count++;
					max = vow[ind++];
				}
			}
		}

		System.out.println(count > 1 ? count : 0);

	}

	private void funWithVowel3(String input) {
		int start = input.indexOf('a'), end = input.lastIndexOf('u');
		int count = 1;
		int max = input.charAt(start);
		for (int i = start + 1; i <= end; i++) {
			if (input.charAt(i) >= max) {
				count++;
				max = Math.max(max, input.charAt(i));
			}
		}

		System.out.println(count > 1 ? count : 0);
	}

	private void funWithVowels(String input) {
		// eouiuaaeiaoauaoaeauieeoiuiuiu
		int end = input.lastIndexOf('u');
		int maxcount = 0;
		int cnt=0;
		List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		for (int i = 0; i < input.length(); i++) {
			int count = 0;
			int ind = 0;
			if (input.charAt(i) == 'a') {
				for (int j = i; j <= end; j++) {
					cnt++;
					if (input.charAt(j) == list.get(ind)) {
						count++;
					} else {
						if (input.charAt(j)>list.get(ind) && input.charAt(j) == list.get(ind + 1)) {
							ind++;
							count++;
						}
					}
				}
				maxcount = Math.max(maxcount, count);
			}
		}
		System.out.println(maxcount);
		System.out.println(cnt++);
	}
}
