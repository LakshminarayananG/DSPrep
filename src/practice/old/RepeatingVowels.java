package practice.old;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class RepeatingVowels {
	
	
	/* Given a string s and an integer k. 
	Return the maximum number of vowel letters [exact first match] in any substring of s with length k. 
	Vowel letters in English are (a, e, i, o, u). Example 1: 
	Input: s = "abciiidef", k = 3 Output: iii Explanation: The substring "iii" contains 3 vowel letters. 
	Example 2: Input: s = "aeiou", k = 2 Output: ae */
	
	/*
	 * 1. convert string to char array 
	 * 2. Declare an array list & add vowels 
	 * 3.Iterate through string (Outer for loop)
	 * 4. (Inner for loop) for each slide from i to i+k, check if the characters are available in array list, 
	 * if available, add to substring & return, else clear substring
	 */
	
	@Test
	public void eg1() {
		String input="abciiidef";
		int k=3;
		System.out.println(vowelsusString(input, k));
	}
	
	@Test
	public void eg2() {
		String input="aeiou";
		int k=2;
		System.out.println(vowelsusString(input, k));
	}
	
	
	private String vowelsusString(String input, int k) {
		int start=0, end=0;
		ArrayList<Character> vowList = new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A',
				'E','I','O','U'));
		for(int i=0;i<input.length();i++) {			
			if(vowList.contains(input.charAt(i))) {
				end++;
				if(end-start==k) {
					return input.substring(start, end);
				}
			}
			else {
				end++;
				start=end;
			}
		}
		
		throw new RuntimeException("No Matching substring of vowels found");
		
	}

}
