package problems.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;


public class KFrequentWords_36 {
	
	/*
	 * Given a non-empty list of words, return the k most frequent elements.
	 * 
	 * Your answer should be sorted by frequency from highest to lowest. If two
	 * words have the same frequency, then the word with the lower alphabetical
	 * order comes first.
	 * 
	 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
	 * Output: ["i", "love"] Explanation: "i" and "love" are the two most frequent
	 * words.
	 * 
	 * Example 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny",
	 * "is", "is"], k = 4 Output: ["the", "is", "sunny", "day"] Explanation: "the",
	 * "is", "sunny" and "day" are the four most frequent words
	 */

	@Test
	public void example1() {
		String[] input= {"i", "love", "leetcode", "i", "love", "coding"};
		int k=2;
		findKFrequentWords(input,k);
	}
	
	@Test
	public void example2() {
		String[] input= {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k=4;
		findKFrequentWords(input,k);
	}
	
	private void findKFrequentWords(String[] input, int k) {
		Map<String, Integer> map = new HashMap<>();
		List<String> output = new ArrayList<>();
		for (String str : input) 
			map.put(str, map.getOrDefault(str, 0) + 1);
		
		 PriorityQueue<String> que=new PriorityQueue<>((entryA,entryB)->map.get(entryA)==map.get(entryB)?entryA.compareTo(entryB):map.get(entryB)-map.get(entryA));
		 que.addAll(map.keySet());
		 while(k--!=0)
			 output.add(que.poll());
		 System.out.println(output);
	}
}
