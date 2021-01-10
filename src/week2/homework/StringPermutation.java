package week2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		
		
		private boolean findPermutation1(String s1, String s2) {
			if (s1.length() > s2.length())
				return false;

			Map<Character, Integer> s1map = new HashMap<>();
			for (char c : s1.toCharArray())
				s1map.put(c, s1map.getOrDefault(c, 0) + 1);

			Map<Character, Integer> s2map = new HashMap<>();

			for (int i = 0; i < s1.length(); i++)
				s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);

			if (s1map.equals(s2map))
				return true;

			for (int i = s1.length(); i < s2.length() - s1.length(); i++) {
				s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);

				if (s2map.get(s2.charAt(i - s1.length())) > 1)
					s2map.put(s2.charAt(i - s1.length()), s2map.get(s2.charAt(i - s1.length())) - 1);
				else
					s2map.remove(s2.charAt(i - s1.length()));

				if (s1map.equals(s2map))
					return true;
			}
			return false;
		}

		private boolean findPermutation2(String s1, String s2) {
			if (s1.length() > s2.length())
				return false;

			int s1len = s1.length();
			int s2len = s2.length();
			int[] s1map = new int[26];
			int[] s2map = new int[26];

			for (int i = 0; i < s1len; i++)
				s1map[s1.charAt(i) - 'a']++;

			for (int i = 0; i < s2len; i++) {
				s2map[s2.charAt(i) - 'a']++;
				if (i >= s1len)
					s2map[s2.charAt(i - s1len) - 'a']--;
				if (Arrays.equals(s1map, s2map))
					return true;
			}
			return false;
		}

		private boolean findPermutation3(String s1, String s2) {
			Map<Character, Integer> s1map = new HashMap<>();
			Map<Character, Integer> s2map = new HashMap<>();
			int l1 = s1.length();
			int l2 = s2.length();

			if (l1 > l2)
				return false;

			for (char c : s1.toCharArray())
				s1map.put(c, s1map.getOrDefault(c, 0) + 1);

			for (int i = 0; i < l2; i++) {
				s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);

				if (i >= l1) {
					char temp = s2.charAt(i - l1);
					if (s2map.get(temp) > 1)
						s2map.put(temp, s2map.get(temp) - 1);
					else
						s2map.remove(temp);

					if (s1map.equals(s2map))
						return true;
				}
			}
			return false;
		}

		private boolean findPermutation(String s1, String s2) {
			String sr1 = sortString(s1);
			boolean flag = false;
			for (int i = 0; i < s2.length(); i++) {
				for (int j = i + 1; j <= s2.length(); j++) {
					//System.out.println(s2.substring(i, j));
					if (sr1.equals(sortString(s2.substring(i, j)))) {
						// System.out.println(s2.substring(i, j));
						flag = true;
					}
				}
			}
			return flag;
		}

		public String sortString(String s) {
			String[] split = s.split("");
			Arrays.sort(split);

			return String.join("", split);
		}
		
		
		
		
		
	}


