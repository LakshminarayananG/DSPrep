package week3.homework;
/*
2) Write a function that takes a string as input and reverse only the vowels of the string
Input: Babu
Output: Buba

Input: winnerofcode
Output: wennorofcedi
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P2_ReverseVowels {

	@Test
	public void example1() {
		String input="Babu";
		reverseVowels(input);
	}
	
	@Test
	public void example2() {
		String input="winnerofcode";
		reverseVowels(input);
	}
	
	private void reverseVowels(String input) {
		char[] charArray = input.toCharArray();
		Set<Character> vowels=new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
		int left=0,right=charArray.length-1;
		
		while(left<right) {
			if(vowels.contains(charArray[left]) && vowels.contains(charArray[right])) {
				char temp=charArray[left];
				charArray[left++]=charArray[right];
				charArray[right--]=temp;
			}
			else if(vowels.contains(charArray[left]) && !vowels.contains(charArray[right]))
				right--;
			else
				left++;
		}
		
		System.out.println(Arrays.toString(charArray));
	}
}
