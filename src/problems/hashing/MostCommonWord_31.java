package problems.hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;



public class MostCommonWord_31 {
	
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
}
