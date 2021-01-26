package week19.classwork;

import org.junit.Assert;
import org.junit.Test;


public class CheckAnagram {
	
	/*
	 * Given two string, check whether it is anagram or not Assumptions: String has
	 * only alphabets String is lower case
	 */

	//for all methods, check if both string length matches,else return false
	/*
	 * Brute force: Convert both string to character array Sort both the arrays
	 * compare both array Space: O[N] Time: Best: O[N] Worst: O[NlogN] Average:
	 * O[NlogN]
	 */

	/*
	Hash map:
	Add string 1 characters with its occurrence to the map
	Iterate through string 2,
	if string 2 character is already present in the map, then decrement its occurrence
	if the character occurrence is already 1, then remove the entry from map
	finally if map is empty then return true
	Space: O[N]
	Time:
	Best: O[N]
	Worst: O[N]
	Average: O[N]
	*/

	/*
	Ascii:
	Create an ASCII array of size 26
	Find occurrence of each character in the string 1
	iterate through string 2,
	if the character count in the array is greater than 0, then decrement the count
	else return false
	Space: O[N]
	Time: 
	Best: O[N]
	Worst: O[N]
	Average: O[N]
	*/

	/*
	List:
	Add each characters of s1 string to list
	remove the characters from s2 string from the list
	if the character is not available in the list or list is empty before iterating through end of the s2
	then return false
	if not return true
	Space: O[N]
	Time: 
	Best: O[N]
	Worst: O[N2]
	Average: O[N]
	*/

	/*
	calculate sum of each string
	Calculation:
	1) consider alphabets from 1-26
	2) square the value of each character and add it to sum
	3) do the same to string 2
	4) compare both sum
	Space: O[1]
	Time: 
	Best: O[N]
	Worst: O[N]
	Average: O[N]
	*/
	
	
	
	
	@Test
	public void example1(){
		String s1="anagram";
		String s2="nagaram";
		Assert.assertEquals(true,bruteForce(s1,s2));
		Assert.assertEquals(true,hashingMethod(s1,s2));
		Assert.assertEquals(true,asciiMethod(s1,s2));	
	}
	
	@Test
	public void example2(){
		String s1="abac";
		String s2="aabc";
		Assert.assertEquals(true,bruteForce(s1,s2));
		Assert.assertEquals(true,hashingMethod(s1,s2));
		Assert.assertEquals(true,asciiMethod(s1,s2));	
	}

	@Test
	public void example3(){
		
		String s1="abcd";
		String s2="dcea";
		Assert.assertEquals(true,bruteForce(s1,s2));
		Assert.assertEquals(true,hashingMethod(s1,s2));
		Assert.assertEquals(true,asciiMethod(s1,s2));	
	}

	private Object bruteForce(String s1, String s2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object hashingMethod(String s1, String s2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object asciiMethod(String s1, String s2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * create prime number int array for first 26
	 * mul each character of string with the corresponding prime number
	 * val=val*prime[s.charAt(i)-'a']
	 * compare val from both string
	 */
	private boolean usingHashCode(String s1,String s2) {
		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();
		
		int sum1=0,sum2=0;
		
		for (int i = 0; i < arr1.length; i++) {
			sum1+=(arr1[i]-'a')*arr1.length;
			sum2+=(arr2[i]-'a')*arr1.length;
		}
		
		return sum1==sum2;
	}
}
