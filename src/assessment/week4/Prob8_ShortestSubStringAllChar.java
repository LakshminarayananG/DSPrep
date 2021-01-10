package assessment.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;


/*	Given a string comprised of lowercase letters in the range ascii[a-z],
	find the length shortest substring that contains at least one of each of
	the letters in the string.
	Example
	givenString = dabbcabcd
	The list of all characters in the string is [a, b, c, d].
	Two of the substrings that contain all letters are dabbc and abcd.
	The shortest substring that contains all of the letters is 4 characters
	long. Return 4 as the answer.
*/

public class Prob8_ShortestSubStringAllChar {
	
	@Test
	public void eg1() {
		String input="dabbcabcd";
		System.out.println("First: "+minsub(input));
		}
	
	@Test
	public void eg2() {
		String input="bab";
		System.out.println("Two: "+minsub(input));
		}
	
	@Test
	public void eg3() {
		String input="asdfkjeghfalawefhaef";
		System.out.println("Three: "+minsub(input));
		}
	
	
	private int minsub(String input) {
		Set<Character> set = new HashSet<Character>();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int minimumvalue=256;
		
		for (int i = 0; i < input.length(); i++) {
			set.add(input.charAt(i));
		}
		
		for (Character character : set) {
			map.put(character, map.getOrDefault(character, 0)+1);
		}
		
		for (int i = 0; i < input.length(); i++) {
			minimumvalue=Math.min(minimumvalue, findmimimum(input, i,input.length(), map));
		}
		return minimumvalue;
	}
	
	
	
	private int findmimimum(String input, int start,int end, Map<Character,Integer> map) {
		Map<Character,Integer> newmap = new HashMap<Character,Integer>();
		int minvalue=256; int val=start;
		
		while(start<end) {
			newmap.put(input.charAt(start), newmap.getOrDefault(input.charAt(start), 0)+1);
			if(newmap.keySet().equals(map.keySet())) {
				minvalue=input.substring(val, start+1).length();
				break;
			}
			start++;
		}
		return minvalue;
	}
	
	
	private void shortString(String s) {
		char[] cArr = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : cArr) {
			set.add(c);
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, end = 0;
		int min = Integer.MAX_VALUE;

		while (end < cArr.length) {
			map.put(cArr[end], map.getOrDefault(cArr[end++], 0) + 1);
			boolean equals = map.keySet().equals(set);
			if (equals) {
				map.clear();
				min = Math.min(min, s.substring(start, end).length());
				start++;
				end = start;
			}
		}
		System.out.println(min);
	}
	
	
	

}
