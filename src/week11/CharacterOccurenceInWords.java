package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CharacterOccurenceInWords {
	
	/*
	Given an array of strings made only from lowercase letters, 
	return a list of all characters that show up in all strings within the list (including duplicates).  
	For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
	You may return the answer in any order.
	Input: ["bella","label","roller"]
	Output: ["e","l","l"]
	Input: ["cool","lock","cook"]
	Output: ["c","o"]
	*/

	/*
	Very native solution. We use the first String char_count as a reference.
	for example, "bella" will count into arr[26] with all letter's count. [b]=1, [e]=1,[l]=2,[a]=1 will be the reference.
	Then we loop the rest String: for each string ,we did the same new arr[26] count, then scan reference with the new arr count. 
	If count not match, then we need to update the reference count with smaller count. 
	like "label" has same char_count, then "roller" will update reference as [e]=1, [l]=2;
	After loop the whole string array, 
	we only need to scan the reference count [e]=1, [l]=2 and add the letter into a list respectively with the count number.
	*/
	
	@Test
	public void example1() {
		String[] inp = { "bella", "label", "roller" };
		charIntersection(inp);
	}

	@Test
	public void example2() {
		String[] inp = { "cool", "lock", "cook" };
		charIntersection(inp);
	}

	private void charIntersection(String[] inp) {
		int[] farr = new int[26];

		for (char c : inp[0].toCharArray())
			farr[c - 'a']++;

		for (int k = 1; k < inp.length; k++) {
			int[] rarr = new int[26];
			for (char c : inp[k].toCharArray())
				rarr[c - 'a']++;

			for (int i = 0; i < 26; i++)
				farr[i] = Math.min(farr[i], rarr[i]);
		}
		List<Character> list = new ArrayList<>();

		for (int i = 0; i < farr.length; i++)
			if (farr[i] != 0)
				for (int j = 0; j < farr[i]; j++)
					list.add((char) (i + 'a'));

		System.out.println(list);
	}

}
