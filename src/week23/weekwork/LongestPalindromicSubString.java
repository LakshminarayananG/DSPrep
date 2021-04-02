package week23.weekwork;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LongestPalindromicSubString {
	
	/**
	 * Problem 2)
	 * 
	 * Given a string s, return the longest palindromic substring in s.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer.
	 * 
	 * Constraint: Use expand around center with O(n^2)
	 */
	
	@Test
	public void eg1() {
		String s="babad";
		System.out.println(longestPalindromicSubString(s));
		
	}
	
	@Test
	public void eg2() {
		String s="madam";
		System.out.println(longestPalindromicSubString(s));		
	}
	
	@Test
	public void eg3() {
		String s="malayalam";
		System.out.println(longestPalindromicSubString(s));		
	}
	
	@Test
	public void eg4() {
		String s="laks";
		System.out.println(longestPalindromicSubString(s));		
	}
	
	private String longestPalindromicSubString(String s) {
		List<String> output = new ArrayList<String>();
		output.add(s.charAt(0)+"");
		for(int i=0;i<s.length();i++) {
			expand(s,i,i,output.get(0).length(),output);
			expand(s,i,i+1,output.get(0).length(),output);
		}
		
		return output.get(0);
		
	}
	
	private List<String> expand(String s, int start, int end,int len, List<String> output){
		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)) {
			if(s.substring(start, end+1).length()>len) {
				output.clear();
				output.add(s.substring(start, end+1));
			}
			start--;
			end++;
		}
		return output;
		
	}

}
