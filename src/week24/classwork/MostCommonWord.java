package week24.classwork;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words. 
It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  
The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
*/

public class MostCommonWord {

	// Pseudo Code
	/*
	 * split the sentance using space iterate through each element in the split and
	 * add it to a map. while adding, remove the non characters and convert it to
	 * lowercase iterate through each banned element and remove it from the group
	 * return the word with max occurrences
	 */

	@Test
	public void example1() {
		String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		findCommonWord(input, banned);
	}

	@Test
	public void example2() {
		String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit", "ball" };
		findCommonWord(input, banned);
	}

	@Test
	public void example3() {
		String input = "a, a, a, a, b,b,b,c, c";
		String[] banned = { "a" };
		findCommonWord(input, banned);
	}

	@Test
	public void example4() {
		String input = "Testing is is efficient";
		String[] banned = {};
		findCommonWord(input, banned);
	}

	@Test
	public void example5() {
		String input = "Bob hit a ball, the hit BALL flew far after it was hit.\n ball is most frequent ball.";
		String[] banned = { "random", "word" };
		findCommonWord(input, banned);
	}
	
	private void findCommonWord(String input, String[] banned) {
		String[] split = input.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
		List<String> ban = Arrays.asList(banned);
		Map<String, Integer> eachOcc = new LinkedHashMap<>();
		
		for(String spt:split)
			if(!ban.contains(spt))
				eachOcc.put(spt, eachOcc.getOrDefault(spt, 0) + 1);
		
		String key = Collections.max(eachOcc.entrySet(),Map.Entry.comparingByValue()).getKey();
		
		System.out.println(key);
		
	}
	
	private void findCommonWord1(String input, String[] banned) {
		if (input.length() == 0)
			throw new RuntimeException("Invalid input");

		Map<String, Integer> eachOcc = new LinkedHashMap<>();
		List<String> ban = Arrays.asList(banned);

		input = input.replaceAll("[^a-zA-Z0-9 ]+", " ").toLowerCase();
		
		for (String each : input.split(" "))
			if (!ban.contains(each) && !each.trim().isEmpty())
				eachOcc.put(each.trim(), eachOcc.getOrDefault(each.trim(), 0) + 1);

		int max = Collections.max(eachOcc.values());
		
		//String key = Collections.max(eachOcc.entrySet(),Map.Entry.comparingByValue()).getKey();
		
		List<String> list = eachOcc.entrySet().stream().filter(mp -> mp.getValue() == max)
				.flatMap(m -> Stream.of(m.getKey())).collect(Collectors.toList());
		System.out.println(list.get(0));
	}
}
