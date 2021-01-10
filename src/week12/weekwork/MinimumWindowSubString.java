package week12.weekwork;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MinimumWindowSubString {
	
	/*
	 * Problem 1) Given two strings s and t, return the minimum window in s which
	 * will contain all the characters in t. If there is no such window in s that
	 * covers all characters in t, return the empty string "". Note that If there is
	 * such a window, it is guaranteed that there will always be only one unique
	 * minimum window in s. Example 1: Input: s = "ADOBECODEBANC", t = "ABC" Output:
	 * "BANC" Example 2: Input: s = "a", t = "a" Output: "a"
	 */

	@Test
	public void example1() {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}

	@Test
	public void example2() {
		String s = "a";
		String t = "a";
		System.out.println(minWindow(s, t));
	}

	private String minWindow(String s, String t) {
		int slen = s.length();
		int tlen = t.length();

		if (tlen > slen)
			return "";

		int[] sarr = new int[126];
		int[] tarr = new int[126];

		for (char c : t.toCharArray())
			tarr[c]++;

		int start = 0, startind = -1, minLen = Integer.MAX_VALUE, cnt = 0;
		for (int end = 0; end < slen; end++) {
			sarr[s.charAt(end)]++;

			if (tarr[s.charAt(end)] != 0 && sarr[s.charAt(end)] <= tarr[s.charAt(end)])
				cnt++;

			if (cnt == tlen) {
				while (sarr[s.charAt(start)] > tarr[s.charAt(start)] || tarr[s.charAt(start)] == 0) {
					if (sarr[s.charAt(start)] > tarr[s.charAt(start)])
						sarr[s.charAt(start)]--;
					start++;
				}
				int winLen = end - start + 1;
				if (winLen < minLen) {
					minLen = winLen;
					startind = start;
				}
			}
		}

		if (startind == -1)
			return "";

		return s.substring(startind, startind + minLen);
	}
	
	
	
	/*//Approach
	1. Get the characters from input 2 and store in a map
	2. Declare 2 pointers left and right and iterate from 0-length-1 of 1st input
	3. Check if the current character is available in map, if available reduce value of key in map by 1
	4. Check if the value of corresponding key in map =0, if so, increment no. of matches
	5. Increment the end value when sliding through the input string 1
	6. Check if the no. of matches equals the map and if it matches, start incrementing left and move to right
	7. Get the minimum value until which the map size equals matches and
	return the substring after navigating until end of string*/



	@Test
	public void eg2() {
	String input1="ABCDEFGHIJ";
	String input2="BFH";
	System.out.println("Example2"+minsubString(input1, input2));
	}

	@Test
	public void eg4() {
	String input1="Lakshmisooraj";
	String input2="sor";
	System.out.println("Example4"+minsubString(input1, input2));
	}


	@Test
	public void eg3() {
	String input1="KASRTSRKSE";
	String input2="SST";
	System.out.println("Example3"+minsubString(input1, input2));
	System.out.println(minsubString(input1, input2));
	}




	private String minsubString(String s, String t) {
	int start=0,end=0,minvalue=Integer.MAX_VALUE, matches=0;
	Map<Character,Integer> map = new HashMap<Character,Integer>();
	String output="";

	//Add all the characters of 2nd string
	for(char ch: t.toCharArray()) {
	map.put(ch, map.getOrDefault(ch, 0)+1);
	}


	for(int i=0;i<s.length();i++) {
	//Check if the map contains the character at current index, if present, reduce value by 1
	if(map.containsKey(s.charAt(i))) {
	map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

	if(map.get(s.charAt(i))==0) {
	matches++;
	}
	}

	while(matches==map.size()) {
	if(minvalue>end-start+1) {
	minvalue=end-start+1;
	output=s.substring(start,end+1);
	}

	if(map.containsKey(s.charAt(start))){
	                   if (map.get(s.charAt(start)) == 0)
	                       matches--;
	                   map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
	               }
	               start++;
	}
	//Keep moving the end pointer
	end++;


	}

	return output;
	}
	
	
	
}
