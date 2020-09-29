package strings;

import java.util.Arrays;

public class CharSwap {
	
	/*
	 * Given a string, check if the letters can be rearranged so that two characters
	 * that are adjacent to each other are not the same.
	 * 
	 * Input: "aab" Output: "aba"
	 * 
	 * Input: "aaab" Output: ""
	 */
	
	
	
	
	private void swapchar(String input) {
		char[] temp=input.toCharArray();
		Arrays.sort(temp);
		System.out.println(String.valueOf(temp));
		int val=input.length();
		
		
	}
	
	

	  
	

}
