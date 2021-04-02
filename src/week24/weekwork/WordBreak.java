package week24.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

public class WordBreak {

	@Test
	public void example1() {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
		Assert.assertEquals(true, WordBreaks(s, wordDict));
	}

	@Test
	public void example2() {
		String s = "applepenapple";
		List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
		Assert.assertEquals(true, WordBreaks(s, wordDict));
	}

	@Test
	public void example3() {
		String s = "catsandog";
		List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
		Assert.assertEquals(false, WordBreaks(s, wordDict));
	}

	@Test
	public void example4() {
		String s = "aaaaaaa";
		List<String> wordDict = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
		Assert.assertEquals(true, WordBreaks(s, wordDict));
	}
	
	@Test
	public void example5() {
		String s = "goalspecial";
		List<String> wordDict = new ArrayList<>(Arrays.asList("go","goal","goals","special"));
		Assert.assertEquals(true, WordBreaks(s, wordDict));
	}


	private boolean WordBreaks(String s, List<String> wordDict) {
		Set<String> set=new HashSet<>(wordDict);
        int maxLength=0;
        
        for(String word:wordDict){
            maxLength=Math.max(maxLength,word.length());
        }
    
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i=0;i<s.length();i++){
            int j=i;
            while(j>=0 && j>i-maxLength){
                if(set.contains(s.substring(j,i+1)) && dp[j]){
                    dp[i+1]=true;
                }
                j--;
            }
        }
        
        return dp[s.length()];
	}
}
