package week18.weekwork;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LongestPalindromicSubString {
	
	/*
	 * Given a string s, return the longest palindromic substring in s.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer. Example
	 * 2:
	 * 
	 * Input: s = "cbbd" Output: "bb" Example 3:
	 * 
	 * Input: s = "a" Output: "a" Example 4:
	 * 
	 * Input: s = "ac" Output: "a"
	 */
	
	
	/* Approach 1
	 * 1. Using substring method
	 * 2. One outer for loop to iterate from 0 to n-1 
	 * 3. Inner for loop to iterate from outer index value to n-1
	 * 4. Using substring function, check if its a palindrome
	 * 5. check for length of the string and return the string with largest string
	 * 
	 */
	
	/*
	 * Approach 2
	 * 1. Expand around center
	 * 2. Iterate from 0 to n-1
	 * 3. For each iteration, expand on both sides to check if the string is a palindrome and return the 
	 *    string with largest length
	 */
	
	@Test
	public void eg1() {
		String s="babad";
		System.out.println(palindromicsubstring(s));
		System.out.println(palindromicsubstringExpand(s));
	}
	
	@Test
	public void eg2() {
		String s="cbbd";
		System.out.println(palindromicsubstring(s));
		System.out.println(palindromicsubstringExpand(s));
	}
	
	@Test
	public void eg3() {
		String s="a";
		System.out.println(palindromicsubstring(s));
		System.out.println(palindromicsubstringExpand(s));
	}
	
	@Test
	public void eg4() {
		String s="ac";
		System.out.println(palindromicsubstring(s));
		System.out.println(palindromicsubstringExpand(s));
	}
	
	
	private String palindromicsubstring(String s) {
		if(s.length()==0) return "";
		if(s.length()==1) return s;
		String output = ""; int len=1;String temp;
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<s.length();j++) {
				temp=s.substring(i, j+1);
				StringBuilder sb = new StringBuilder(temp);
				if(temp.equals(sb.reverse().toString()) && temp.length()>=len) {
					output=temp;
					len=temp.length();
				}
			}
		}
		return output;
	}
	
	
	private String palindromicsubstringExpand(String s) {
		if(s.length()==0) return "";
		if(s.length()==1) return s;
		List<String> list = new ArrayList<String>();
		list.add(s.charAt(0)+"");
		
		for(int i=0;i<s.length();i++) {
			expand(s,i,i,list.get(0).length(),list);
			expand(s,i,i+1,list.get(0).length(),list);
		}
		
		return list.get(0);
	}
	
	private List<String> expand(String s, int start, int end, int len,List<String> output) {
		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)) {
			if(s.substring(start, end+1).length()>=len) {
				output.clear();
				output.add(s.substring(start, end+1));
			}
			
			start--;
			end++;
		}
		
		return output;
	}

}