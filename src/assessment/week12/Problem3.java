package assessment.week12;

import org.junit.Test;

public class Problem3 {
	
	//Problemm:
	/*Write a program to print the given text by reversing the text and reversing only alternate words
	
	Example:
		Input: There is no Test
		Output: tseT no si There*/
	
	/*//Approach
	1. Reverse the input string through string buffer / builder
	2. Convert the string to string array and iterate, if index %2!=0, reverse and add to output
	3. Return the resultant string*/
	
	
	@Test
	public void eg1() {
		String input="There is no Test";
		System.out.println("Example 1: "+revrsealtwords(input));
	}
	
	@Test
	public void eg2() {
		String input="The sun rises in East";
		System.out.println("Example 1: "+revrsealtwords(input));
	}
	
	private String revrsealtwords(String input) {
		StringBuffer inputval= new StringBuffer(input).reverse();
		String[] outarr= inputval.toString().split(" ");
		String actualoutput="";
		
		for (int i = 0; i < outarr.length; i++) {
			if(i%2!=0) {
				actualoutput+=new StringBuffer(outarr[i]).reverse().toString()+" ";
			}
			else {
				actualoutput+=outarr[i]+" ";
			}
		}
		
		return actualoutput.trim();
	}
	
	
	private String reverseText(String inp) {
		if (!inp.contains(" "))
			return inp;

		String[] split = inp.split(" ");

		for (int i = 1; i < split.length; i += 2)
			split[i] = new StringBuilder(split[i]).reverse().toString();

		int left = 0, right = split.length - 1;

		while (left < right) {
			String temp = split[left];
			split[left++] = split[right];
			split[right--] = temp;
		}

		return String.join(" ", split);
	}

	// Pseudo code
	// Space complexity: O[N]
	// Time complexity: O[N]
	/*
	 * Split the input string with separator as space go from reverse word and
	 * reverse it using stringbuilder or 2 pointer append it to a new string return
	 * the string
	 */

	private String reverseText1(String inp) {
		String[] split = inp.split(" ");
		StringBuffer sb = new StringBuffer();
		sb.setCharAt(4, inp.charAt(2));
		if (split.length < 2)
			return inp;

		String op = "";
		for (int i = split.length - 1; i >= 0; i--)
			op = op.concat(new StringBuilder(split[i--]).reverse().toString()).concat(" ").concat(split[i]).concat(" ");

		return op.trim();
	}
	
	
	
	
	

}
