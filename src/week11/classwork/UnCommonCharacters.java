package week11.classwork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class UnCommonCharacters {
	
	/*
	Write a function that takes 2 strings as input and returns a string with uncommon characters of the input strings.
	Example: Input: String1 = "aabde" String2 = "cbaz"
	 */

	//Pseudocode
	 /*
	 * iterate through each character in 2 string
	 * if string2 character is not available in string1 then add to list
	 * if string1 character is not available in string2 then add to list
	 * finally return the list
	 */

	 /*
	 * create 2 set and add all characters from both string in each set
	 * add set2 character to set1, if set2 char is available in set1 then remove it from set1 else add it
	 * return the set1
	 */

	/*
	 * add all characters in str1 to set
	 * only unique characters available in set1. if yes then remove it else add to set
	 * return the set
	 */
	
	@Test
	public void example1() {
		String str1="aabde";
		String str2="cbaz";
		uncommonChars(str1, str2);
	}
	
	private void uncommonChars(String str1,String str2) {
		System.out.println(str1.replaceAll("["+str2+"]+", "").concat(str2.replaceAll("["+str1+"]+", "")));
	}
	
	private void uncommonChars1(String str1,String str2) {
		int s1=0,s2=0;
		Set<Character> set=new HashSet<>();
		while(s1<str1.length() || s2<str2.length()) {
			if(s1<str1.length() && !str2.contains(str1.subSequence(s1, s1+1)))
				set.add(str1.charAt(s1));
			if(s2<str2.length() && !str1.contains(str2.subSequence(s2, s2+1)))
				set.add(str2.charAt(s2));
			s1++;
			s2++;	
		}
		System.out.println(set);
	}

}
