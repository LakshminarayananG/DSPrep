package assessment;

import org.junit.Test;

//Given a string comprised of lowercase letters in the range ascii[a-z],
//find the length shortest substring that contains at least one of each of
//the letters in the string.
//Example
//givenString = dabbcabcd
//The list of all characters in the string is [a, b, c, d].
//Two of the substrings that contain all letters are dabbc and abcd.
//The shortest substring that contains all of the letters is 4 characters
//long. Return 4 as the answer.



public class A1P08 {

	
	@Test
	public void dataSetOne()
	{
	String input="asdfkjeghfalawefhaef";
	System.out.println(shortestSubString(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="dabbcabcd";
		System.out.println(shortestSubString(input));
	}
	
	private int shortestSubString(String input)
	{
		int[] referenceArray=new int[26];
		int[] currentArray=new int[26];
		int charCount=0;int currentWindowCount=0;
		int start=0;int minLength=input.length()+1;
		for(int i=0;i<input.length();i++)
		{
			if(referenceArray[input.charAt(i)-'a']<1)
			{
				referenceArray[input.charAt(i)-'a']++;
				charCount++;
			}
			
		}
		int i=0;
		while(i<input.length())
		{
			currentArray[input.charAt(i)-'a']++;
			if(currentArray[input.charAt(i)-'a']==1)
			{
			currentWindowCount++;
			}
			
			if(currentWindowCount==charCount)
			{
			
				while(currentArray[input.charAt(start)-'a']>1)
				{
					currentArray[input.charAt(start)-'a']--;
					if(currentArray[input.charAt(start)-'a']==1)
					{
						start++;
					}
				}
					
				minLength=Math.min(minLength, i-start+1);
				currentArray[input.charAt(start)-'a']--;
				start=start++;
			}
		
			i++;
			
			
		}
		return minLength;
		
	}
}
