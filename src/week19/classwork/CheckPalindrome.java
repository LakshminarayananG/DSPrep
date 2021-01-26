package week19.classwork;

import java.util.ArrayDeque;
import org.junit.Assert;
import org.junit.Test;

public class CheckPalindrome {

	//Check if the given String is palindrome or not
	/*
	 * Constraints:
	 * String should be alphanumeric
	 * ignore cases
	 */

	//Pseudo code
	//Using string
	/*
	 * Create another string
	 * traverse the input string from reverse and add each character to the string
	 * finally check whether this string and input string matches
	 * 
	 * Space: O[N]
	 * Time:
	 * Best: O[1]
	 * Worst: O[N]
	 * Average: O[N]
	 */

	//Using string builder
	/*
	 * create a string builder initialized as the input string
	 * reverse the string using .reverse() method
	 * compare both reversed and input string
	 * 
	 * Space: O[N]
	 * Time:
	 * Best: O[1]
	 * Worst: O[N]
	 * Average: O[N]
	 */

	//Array dequeue
	/*
	* add all characters to the array dequeue
	* pop and poll the queue and check if both the characters are equal
		* if not equal, then return as false
	* if the queue is empty or in size of 1 then return as true
	* 
	* Space: O[N]
	* Time:
	* Best: O[1]
	* Worst: O[N]
	* Average: O[N]
	*/

	//Two pointer
	/*
	 * create 2 pointers left and right
	 * traverse left from 0 and right from end of the string
	 * compare the left and right characters
	 	* if the character doesn't match, return false
	 * if the loop completed, then the given string is a palindrome
	 * 
	 * Space: O[1]
	 * Time: 
	 * Best: O[1]
	 * Worst: O[N/2]
	 * Average: O[N/2]
	 */
	
	
	
	@Test
	public void example1() {
		String input = "abcba";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example2() {
		String input = "AazXXzaA";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example3() {
		String input = "12321";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example4() {
		String input = "Aa";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example5() {
		String input = "a";
		Assert.assertEquals(true, stringMethod(input));
		Assert.assertEquals(true, stringBuilderMethod(input));
		Assert.assertEquals(true, usingQueue(input));
		Assert.assertEquals(true, twoPointer(input));
	}

	@Test
	public void example6() {
		String input = "abc";
		Assert.assertEquals(false, stringMethod(input));
		Assert.assertEquals(false, stringBuilderMethod(input));
		Assert.assertEquals(false, usingQueue(input));
		Assert.assertEquals(false, twoPointer(input));
	}

	private boolean stringMethod(String input) {
		input = input.toLowerCase();
		String reversed = "";

		for (int i = input.length() - 1; i >= 0; i--)
			reversed += input.charAt(i);

		return input.equals(reversed);
	}

	private boolean stringBuilderMethod(String input) {
		input = input.toLowerCase();
		return new StringBuilder(input).reverse().toString().equals(input);
	}

	private boolean usingQueue(String input) {
		input = input.toLowerCase();
		ArrayDeque<Character> queue = new ArrayDeque<>();
		char[] carr = input.toCharArray();

		for (char ch : carr)
			queue.offer(ch);

		while (queue.size() > 2)
			if (queue.poll() != queue.pollLast())
				return false;

		return true;
	}

	private boolean twoPointer(String input) {
		input = input.toLowerCase();
		int left = 0, right = input.length() - 1;

		while (left < right)
			if (input.charAt(left++) != input.charAt(right--))
				return false;

		return true;
	}
	
	
	@Test
	public void data1() {
		String input="21ababa12";
		System.out.println(checkPalindromeBF(input));
		System.out.println(checkPalindromeTP(input));
		System.out.println(checkPalindromeLinear(input));
	}
	
	@Test
	public void data2() {
		String input="vinoth123";
		System.out.println(checkPalindromeBF(input));
		System.out.println(checkPalindromeTP(input));
		System.out.println(checkPalindromeLinear(input));
	}
	
	@Test
	public void data3() {
		String input="";
		System.out.println(checkPalindromeBF(input));
		System.out.println(checkPalindromeTP(input));
		System.out.println(checkPalindromeLinear(input));
	}
	
	@Test
	public void data4() {
		String input="12321";
		System.out.println(checkPalindromeBF(input));
		System.out.println(checkPalindromeTP(input));
		System.out.println(checkPalindromeLinear(input));
	}
	
	/* Pseudo Code - Brute Force - Two for loops
	 * 
	 * Two for loops
	 * Outer for loop - Incremental from 0 to length
	 * Inner for loop - Decremental from length to 0
	 * 		Check the characters in both i and j are equals
	 * 		Yes -> continue;
	 * 		No -> return false;
	 * 
	 * return true;
	 * 
	 * O(N2)
	 * O(1)
	 */
	
	/* Pseudo Code - Brute Force - StringBuffer
	 * 
	 * Reverse the input string using stringBuffer
	 * Check the input and reversed string 
	 * 		If it matches -> return true
	 * 		else -> false
	 *
	 *
	 *Time - O(N)
	 * Space - O(1) 
	 */
	
	public boolean checkPalindromeBF(String input) {
		
		if(input.length()== 0) return false;
		
		if(input.length()== 1) return true;
		
		StringBuffer sb=new StringBuffer(input);
		sb.reverse();
		if(sb.toString().equals(input)) {
			return true;
		}
		
		return false;
	}
	
	/* Pseudo Code - Two Pointer approach
	 * 
	 * Declare left=0 and right=lengh-1
	 * 
	 * Using while loop - left<right
	 * 	check if char[left] equals char[right]
	 * 		left++ and right--
	 * 	Else return false;
	 * 
	 * Time - O(N/2)
	 * Space - O(1)
	 * 
	 */
	public boolean checkPalindromeTP(String input) {
		
		if(input.length()== 0) return false;
		
		if(input.length()== 1) return true;
		
		int left=0; int right=input.length()-1;
		
		while(left<right) {
			if(input.charAt(left) == input.charAt(right)) {
				left++;right--;
				continue;
			}else {return false;}
		}
		
		return true;
	}
	/* Pseudo Code - Linear approach
	 * 
	 * Declare an empty string ""
	 * 
	 * Break the input to characters
	 * 
	 * Using for loop decremental
	 * 		Adding the characters to String
	 * 
	 * check input.equals(tempStr)
	 * 
	 * Time - O(N)
	 * Space - O(1)
	 * 
	 */
	
	public boolean checkPalindromeLinear(String input) {
		
		if(input.length()== 0) return false;
		
		if(input.length()== 1) return true;
		
		String temp="";
		
		for (int i = input.length()-1; i >= 0 ; i--) {
			temp=temp+input.charAt(i);
		}
		
		return temp.equals(input);
	}
	
}
