package assessmentSolutions;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;


/*	Given a string, reduce it in such a way that all of its substrings are
	distinct. To do so, you may delete any characters at any index. What is
	the minimum number of deletions needed?
	Note: A substring is a contiguous group of 1 or more characters within
	a string.
	Example
	s = "abab"
	Substrings in s are { 'a', 'b', 'a', 'b', 'ab', 'ba', 'ab', 'aba', 'bab', 'abab'}. By
	deleting one "a" and one "b", the string becomes "ab" or "ba" and all of
	its substrings are distinct. This required 2 deletions.
*/

public class Prob6_StringReduction {

	@Test
	public void eg1() {
		String input = "abab";
		System.out.println("One :" + remove(input));
	}
	
	@Test
	public void eg2() {
		String input = "ababcvf";
		System.out.println("Two :" + mindelete(input));
	}

	
	//Alternate Approach
	private int remove(String s) {
		char[] chararr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		//Add all the occurences in the string to a hashmap
		for (char c : chararr) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int delete = 0;
		
		//No of deletions will be until all the characters have a value / occurence of 1
		for (char c : map.keySet()) {
			if (map.get(c) > 1) {
				while (map.get(c) > 1) {
					map.put(c, map.get(c) - 1);
					delete++;
				}
			}
		}
		return delete;
	}
	
	
	private int mindelete(String s) {
		String output="";
		for (int i = 0; i < s.length(); i++) {
			if(!(output.contains(s.charAt(i)+""))) {
				output+=s.charAt(i);
			}
		}
		
		//No of deletions will be string length and the total number of repititions
		return s.length()-output.length();
	}
}