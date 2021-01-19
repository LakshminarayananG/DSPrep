package week18.weekwork;

import org.junit.Test;

public class MinDeletionsToMakeAnagram {

	
	/*
	 * Given two equal-size strings s and t. In one step you can choose any
	 * character of t and replace it with another character.
	 * 
	 * Return the minimum number of steps to make t an anagram of s.
	 * 
	 * An Anagram of a string is a string that contains the same characters with a
	 * different (or the same) ordering.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "bab", t = "aba" Output: 1 Explanation: Replace the first 'a' in t
	 * with b, t = "bba" which is anagram of s. Example 2:
	 * 
	 * Input: s = "leetcode", t = "practice" "leeoc"
	 *  Output: 5 Explanation: Replace 'p',
	 * 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
	 * Example 3:
	 * 
	 * Input: s = "anagram", t = "mangaar" Output: 0 Explanation: "anagram" and
	 * "mangaar" are anagrams. Example 4:
	 * 
	 * Input: s = "xxyyzz", t = "xxyyzz" Output: 0 Example 5:
	 * 
	 * Input: s = "friend", t = "family" Output: 4
	 */
	
	
	/* Approach
	 * 
	 * 1. Add all the number of occurences of s1 to int array and s2 to another int array
	 * 2. Since both strings are of lower case, iterate in reverse order and find the diff b/w 2 strings
	 *    if both the values are not equal and add differencce to count
	 * 3. return teh count
	 * 
	 */
	
	
	//@Test
	public void eg1() {
		String s1="bab";
		String s2="aba";
		System.out.println("Eg1 "+mindeletions(s1, s2));

	}
	
	@Test
	public void eg2() {
		String s1="practice";
		String s2="leetcode";
		System.out.println("Eg2 "+mindeletions(s1, s2));
		
		
	}
	
	//@Test
	public void eg3() {
		String s1="anagram";
		String s2="mangaar";
		System.out.println("Eg3 "+mindeletions(s1, s2));
		
	}
	
	//@Test
	public void eg4() {
		String s1="xxyyzz";
		String s2="xxyyzz";
		System.out.println("Eg4 "+mindeletions(s1, s2));
		
	}
	
	//@Test
	public void eg5() {
		String s1="friend";
		String s2="family";
		System.out.println("Eg5 "+mindeletions(s1, s2));
		
	}
	
	private int mindeletions(String s1,String s2)
	{
		if(s1.equals(s2)) return 0;
		int[] s1arr= new int[26];
		int[] s2arr= new int[26];
		int count=0;
		
		for(int i=0;i<s1.length();i++) {
			s1arr[s1.charAt(i)-'a']+=1;
			s2arr[s2.charAt(i)-'a']+=1;
		}
		
		for(int i=25;i>=0;i--) {
			if(s1arr[i]>s2arr[i]) {
			count+=(s1arr[i]-s2arr[i]);
		}
		}
		return count;
	}
	
	


}