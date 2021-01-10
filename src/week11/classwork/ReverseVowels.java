package week11.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class ReverseVowels {
	
	/*
	Write a solution to reverse only the vowels of a string.
	Input: "hello"
	Output: "holle"
	"aeiou"
	"uoiea"
	"testliaaf"
	"tastlaief"
	*/
	
	@Test
	public void example1() {
		String s = "TestLeaf"; // TastLeef
		reverseVowels(s);
	}

	@Test
	public void example2() {
		String s = "hello"; // TastLeef
		reverseVowels(s);
	}

	@Test
	public void example3() {
		String s = "aeiou"; // TastLeef
		reverseVowels(s);
	}
	
	@Test
	public void dataSetOne()
	{
		String input="hello";
		System.out.println(reverseVowels1(input));
	}

	@Test
	public void dataSetTwo()
	{
		String input="eioua";
		System.out.println(reverseVowels1(input));
	}

	@Test
	public void dataSetThree()
	{
		String input="pbcfgc";
		System.out.println(reverseVowels1(input));
	}

	@Test
	public void dataSetFour()
	{
		String input="kedfAeif";
		System.out.println(reverseVowels1(input));
	}

	private void reverseVowels(String s) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		String[] split = s.split("");
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (!vowels.contains(Character.toLowerCase(s.charAt(left))))
				left++;
			if (!vowels.contains(Character.toLowerCase(s.charAt(right))))
				right--;

			if (vowels.contains(Character.toLowerCase(s.charAt(left)))
					&& vowels.contains(Character.toLowerCase(s.charAt(right)))) {
				String temp = split[left];
				split[left++] = split[right];
				split[right--] = temp;
			}
		}
		System.out.println(String.join("", split));

	}
	
	
	
	private String reverseVowels1(String input)
	{
		List<Character> vowels=new ArrayList<>();
		vowels.add('a');	
		vowels.add('A');
		vowels.add('e');
		vowels.add('E');
		vowels.add('i');
		vowels.add('I');
		vowels.add('o');
		vowels.add('O');
		vowels.add('u');
		vowels.add('U');
		
		char[] refArray=input.toCharArray();
		int start=0;int end=refArray.length-1;
		char temp;
		while(start<end)
		{
			if(vowels.contains(refArray[start])&&vowels.contains(refArray[end]))
			{
				temp=refArray[start];
				refArray[start]=refArray[end];
				refArray[end]=temp;
				start++;end--;
			}
			if(!vowels.contains(refArray[start]))
			start++;
			if(!vowels.contains(refArray[end]))
			end--;
			
					
		}
		return String.valueOf(refArray);
		
		
	}

}
