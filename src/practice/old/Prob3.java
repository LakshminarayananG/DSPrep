package practice.old;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Prob3 {
	
	/*
	 * Write a function that takes 2 strings as input and returns a string with
	 * uncommon characters of the input strings. Example: Input: String1 = "aabde"
	 * String2 = "cbaz"
	 */
	
	/*
	 * 1. add all characters of string 1 to a list 
	 * 2. check if 1st list is having the character, if it has add it to separate list, if not add to original list
	 * 3. Find common elements between 2 lists and remove the same
	 */

	/*
	 * 1. create map1, map2 of occurance of string 1 & string 2 characters
	 * 2. declare a string output 
	 * 3. iterate thru map1 and if map2!contains map1.key add to output string 
	 * 4. iterate thru map2 and if map1!contains map1.key add to output string
	 */
	
	/*
	 * 1. Add characters from string 1 to set 
	 * 2. If able to characters from string 2 to set 1, not duplicate, else its duplicate
	 */
	
	/*
	 * take 1 string and convert them to characters add it to list..
	 * 
	 * iterate through the String 2 and add them to set using if condition below
	 * 
	 * if set doesn't contain that character then add it to set.. or else add it to
	 * another another list..
	 * 
	 * now the set Will have only uncommon characters.
	 */
	
	
	@Test
	public void eg1() {
		
	}
	
	private void uncommon(String s1,String s2) {
		char[] ch1=s1.toCharArray();
		char[] ch2= s2.toCharArray();
		Set<Character> set1= new HashSet<Character>();
		Set<Character> set2= new HashSet<Character>();
		
		
		
	}
	


}
