package week15.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MostWords {

		/*
		* Given a paragraph and a list of banned words, return the most frequent word
		* that is not in the list of banned words. It is guaranteed there is at least
		* one word that isn't banned, and that the answer is unique.
		*
		* Words in the list of banned words are given in lowercase, and free of
		* punctuation. Words in the paragraph are not case sensitive. The answer is in
		* lowercase.
		*
		*
		*
		* Example:
		*
		* Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
		* banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3 times, but it is
		* a banned word. "ball" occurs twice (and no other word does), so it is the
		* most frequent non-banned word in the paragraph. Note that words in the
		* paragraph are not case sensitive, that punctuation is ignored (even if
		* adjacent to words, such as "ball,"), and that "hit" isn't the answer even
		* though it occurs more because it is banned.
		*/
		
		/*
		* Pseudo code
		* 1. Convert the paragraph to lower case and remove spl characters
		* 2. Split the sentence into string array and have the banned words in a list, initialise maxval as 0
		* 3. Iterate through the array and check if current word is not part of the list
		* 4. If not part of the banned words, add to map and get current value of the word from map
		* 5. Check if its greater than or equal to max val, if so, the current word is max and return the same
		*/

	@Test
	public void eg1() {
		String paragraph = "Bob's hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		System.out.println("Eg1 :" + mostCommonWord(paragraph, banned));
	}
	
	//@Test
	public void eg2() {
		String paragraph = "Given a paragraph and a list of banned words,"
				+ " return the most frequent word that is not in the list of banned words.  "
				+ "It is guaranteed there is at least one word that isn't banned, and that the answer is unique.";
		String[] banned = { "the", "a" };
		System.out.println("Eg2 :" + mostCommonWord(paragraph, banned));
	}
	
	//@Test
	public void eg3() {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit", "ball" };
		System.out.println("Eg3 :" + mostCommonWord(paragraph, banned));
	}
	
	//@Test
	public void eg4() {
		String paragraph = "Bob. hIt, baLl";
		String[] banned = { "bob", "hit" };
		System.out.println("Eg4 :" + mostCommonWord(paragraph, banned));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		String maxword = "";
		List<String> list = Arrays.asList(banned);
		String removespl = paragraph.replaceAll("\\W+", " ").toLowerCase().trim();
		String[] sentence = removespl.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		int maxval = 0;
		for (int i = 0; i < sentence.length; i++) {
			if (!list.contains(sentence[i])) {
				map.put(sentence[i], map.getOrDefault(sentence[i], 0) + 1);
				if (map.get(sentence[i]) >= maxval) {
					maxword = sentence[i];
					maxval = map.get(sentence[i]);
				}
			}
		}
		return maxword;
	}



}
