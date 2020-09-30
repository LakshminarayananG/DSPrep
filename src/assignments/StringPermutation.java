package assignments;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StringPermutation {
	
	//Given two strings s1 and s2, write a function to return true if s2 contains 
	//the permutation of s1. In other words, one of the first string's permutations 
	//is the substring of the second string.

	//Input: s1 = "ab" s2 = "eidbaooo"
	//Output: True
	//Explanation: s2 contains one permutation of s1 ("ba").
	//Example 2:
	//Input:s1= "ab" s2 = "eidboaoo"
	//Output: False



		@Test
		public void TestCase1()
		{
			String s1 = "abc";
			String s2 = "eidbaooo";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
		@Test
		public void TestCase2()
		{
			String s1 = "ab";
			String s2 = "eidbaooo";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
		@Test
		public void TestCase3()
		{
			String s1 = "abc";
			String s2 = "abc";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
		@Test
		public void TestCase4()
		{
			String s1 = "abc";
			String s2 = "e";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
		
		@Test
		public void TestCase5()
		{
			String s1 = "abx";
			String s2 = "eidbaooo";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
		@Test
		public void TestCase6()
		{
			String s1 = "a";
			String s2 = "e";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
		@Test
		public void TestCase7()
		{
			String s1 = "ebanh";
			String s2 = "eba";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
		@Test
		public void TestCase8()
		{
			String s1 = "abc";
			String s2 = "ebac";
			Boolean output = findPermutation(s1, s2);
			System.out.println(output);
		}
		
	
	//Brute Force Approach
		/*
		 * 1. Declare a characterArray and iterate through String s1 
		 * 2. Get All possible combinations through another for loop and add all to list 
		 * 3. Check if length of s2 is less than s1, if so return false 
		 * 4. Check if both length are equal and if it is, check if list contains s2 and return false 
		 * 5. Iterate through the string s2 to till s2.length -s1.length 
		 * 6. Check for substring and see if resulting string is available in the list and return flag
		 */
		
		
		private Boolean findPermutation(String s1, String s2)
		{
			char[] charString = s1.toCharArray();
			List<String> output = new ArrayList<String>();
			boolean result=false;
			
			for (int i = 0; i < charString.length; i++) 
			{
				for (int j = 0; j < charString.length; j++) 
				{
					char temp = charString[i];
					charString[i] = charString[j];
					charString[j] = temp;
					if (!output.contains(String.valueOf(charString)))
					{
						output.add(String.valueOf(charString));
					}
					
				}
			}
			
			if(s2.length()<s1.length()) {
				return false;
			}
			
			else if(s2.length()==s1.length()&& output.contains(s2)) {
				return true;
			}
			
			else {
			for (int i = 0; i < (s2.length()-s1.length())+1; i++) 
			{
				if (output.contains(s2.substring(i, i+s1.length()))) 
				{
					result = true;
					break;
				}
				else
				{
					result = false;
				}
			}
			}
			return result;
		}
	}


