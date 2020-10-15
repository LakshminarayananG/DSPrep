package assessmentSolutions;

import java.util.HashMap;
import java.util.Map;
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
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int minimumvalue=128;
		
		//Add all the unique characters into a hashmap
		for (Character character : input.toCharArray()) {
			map.put(character, map.getOrDefault(character, 0)+1);
		}
		
		
		//iterate through the string with 1 character at a time and then check until keyset of map matches unique key map
		for (int i = 0; i < input.length(); i++) {
			minimumvalue=Math.min(minimumvalue, findmimimum(input, i,input.length(), map));
		}
		return minimumvalue;
	}
	
	
	
	private int findmimimum(String input, int start,int end, Map<Character,Integer> map) {
		Map<Character,Integer> newmap = new HashMap<Character,Integer>();
		int minvalue=128; int val=start;
		
		while(start<end) {
			
		//Iterate from starting to end till the key set of newmap matches the keyset of initial map
			newmap.put(input.charAt(start), newmap.getOrDefault(input.charAt(start), 0)+1);
			if(newmap.keySet().equals(map.keySet())) {
				minvalue=input.substring(val, start+1).length();
				break;
			}
			start++;
		}
		return minvalue;
	}
	
	
	
	
	
	

}
