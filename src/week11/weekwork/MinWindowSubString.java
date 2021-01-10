package week11.weekwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MinWindowSubString {

	/*
	 * Given 2 input strings, return the minimum window in the first string which
	 * will contain all the characters in second string.
	 * 
	 * Input: str1 = "KSTRKSE", str2 = "KST" Output: "KST"
	 * 
	 * Input: str1 = "KASRTRKSE", str2 = "ST" Output: "SRT"
	 * 
	 * Input: str1="ABCDEFGHIJ", str2="BFH" o/p ="BCDEFGH"
	 * 
	 * Algorithm: Sliding Window
	 * Explanation: There are 2 matches "SRT" and "TRKS" and out of this first one is shorter window
	 */
	
	
	
	//@Test
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
	

	//@Test
	public void eg3() {
		String input1="KASRTSRKSE";
		String input2="SST";
		System.out.println(minsubString(input1, input2));
	}
	
	
	
	
	 private String minsubString(String input, String input2) {
		 int start=0,end=0,minvalue=Integer.MAX_VALUE, matches=0;
		 Map<Character,Integer> map = new HashMap<Character,Integer>();
		 String output="";
		 
		 //Add all the characters of 2nd string
		 for(char ch: input2.toCharArray()) {
			 map.put(ch, map.getOrDefault(ch, 0)+1);
		 }
		 
		 
		 for(int i=0;i<input.length();i++) {
			//Check if the map contains the character at current index, if present, reduce value by 1
			 if(map.containsKey(input.charAt(i))) {
				 map.put(input.charAt(i), map.get(input.charAt(i)) - 1);
				 
				 if(map.get(input.charAt(i))==0) {
					 matches++;
				 }
			 }
			 
			 while(matches==map.size()) {
				 if(minvalue>end-start+1) {
					 minvalue=end-start+1;
					output=input.substring(start,end+1); 
				 }
				 
				 if(map.containsKey(input.charAt(start))){
	                    if (map.get(input.charAt(start)) == 0)
	                        matches--;
	                    map.put(input.charAt(start), map.get(input.charAt(start)) + 1);
	                }
	                start++;
			 }
			 //Keep moving the end pointer
			 end++;
			 
			 
		 }
		 
		 return output;
	 }
	
	 }
