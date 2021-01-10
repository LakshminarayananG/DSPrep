
package assessment.week4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

////Given a string, construct a new string by rearranging the original string
//and deleting characters as needed. Return the alphabetically largest
//string that can be constructed respecting a limit as to how many
//consecutive characters can be the same.

//Example
//s = 'baccc'
//k = 2
//The largest string, alphabetically, is 'cccba' but it is not allowed because
//it uses the character 'c' more than 2 times consecutively. Therefore, the
//answer is 'ccbca'.


public class Prob3_LargestString {

	//DataSets

	@Test
	public void SetOne()
	{
		String input="zzzazz";
		int k=2;
		System.out.println(largestString(input,k));
	}

	@Test
	public void SetTwo()
	{
		String input="axxzzx";
		int k=2;
		System.out.println(largestString(input,k));
	}

	@Test
	public void SetThree()
	{
		String input="cccbaccccdddddxxyyyyyy";
		int k=3;
		System.out.println(largestString(input,k));   
	}


	private String largestString(String input, int k)

	{
		char[] charArray=input.toCharArray();
		List<Character>resultArray=new LinkedList<Character>();
		Map<Character,Integer> referenceMap=new HashMap<Character,Integer>();
		
		
		//1. Put all the elements and their occurence in a map
		for(int i=0;i<input.length();i++)
		{
			referenceMap.put(charArray[i], referenceMap.getOrDefault(charArray[i], 0)+1);
			
		}
		
		//To get the distinct elements , add the key set to an array
		Character[] tempArray= new Character[referenceMap.keySet().size()];
		referenceMap.keySet().toArray(tempArray);
		//Sort the array
		Arrays.sort(tempArray);
	int addedCount=0;
		
		//Loop over the array of distinct elements(Form last to zero index)
		for(int i=tempArray.length-1;i>0;i--)
		{
			//keep track of occurence of character in result array using addedCount
			addedCount=0;
			//Check if the remaining occurance of the character is greater than zero
			//else can't add the character to the result string
			if(referenceMap.get(tempArray[i])!=0)
			{
			

			while(referenceMap.get(tempArray[i])!=0)
			{

				//If added count is multiples of k, check if any next element is there,
				//if it is there add the next element and continue, 
				
				if(addedCount%k==0&&addedCount!=0)
				{
					int nextElement=1;
					while(i-nextElement>=0)
					{
						if(referenceMap.get(tempArray[i-nextElement])>0)
						{
							resultArray.add(tempArray[i-nextElement]);
							referenceMap.put(tempArray[i-nextElement], referenceMap.get(tempArray[i-nextElement])-1);
							break;
						}
						else
						{
							nextElement++;
						}
					}
					//If there are no next elements delete all remaining occurences and break the inner loop
					if(i-nextElement<0)
					{
					referenceMap.put(tempArray[i], 0);
					break;
					}
					
				}

				resultArray.add(tempArray[i]);
				addedCount++;
				referenceMap.put(tempArray[i], referenceMap.get(tempArray[i])-1);

			}
		}
		}
		return(resultArray.toString());
	}
	
	/*
	 * 
	 * pseudo-code:
	 * 
	 * step 1: Find occurence of each charcter using HashMap 
	 * step 2: Sort the unique keySet using Arrays.sort
	 * 
	 * step 3: initialize consecutiveCount 
	 * step 4: Traverse each keys(use sorted char array for key reference) in the map 
	 * step 5:    Loop till each keys occurrence > 0
	 * step 6: 		check if consecutiveCount is multiples of k
	 * 					Loop till next char - value is there?
	 * 						 if next char occurrence is present, print once and decrement occurrence value
	 * 						 if next char occurrence is not present, then delete current char remaining values.
	 * step 7: 	    add the current key to Output and increment consecutiveCount, decrement occurrence value	
	 * 
	 */

	private String rearrangeString(String s, int k) {

		StringBuffer output = new StringBuffer();

		char[] input = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : input) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		Set<Character> set = map.keySet();

		Character[] inputKeySet = new Character[set.size()];
		set.toArray(inputKeySet);
		Arrays.sort(inputKeySet, Collections.reverseOrder()); // o log n

		int inputKeySetSize = inputKeySet.length;
		
					// o(n* n)
		
		for (int i = 0; i < inputKeySetSize; i++) {   // o(m)
			
			int consecutiveCount = 0;
			char currentChar = inputKeySet[i];

			while (map.get(currentChar) > 0) {		// o(n)
				
				if (consecutiveCount % k == 0 && consecutiveCount != 0) {

					// Loop till next char - value is there?
					int j = 1;
					while ((i+j) < inputKeySetSize) {  // o(n)
						
						char nextChar = inputKeySet[i + j];
						
						// if next char occurrence is present, print once and decrement value
						if(map.get(inputKeySet[i+j]) > 0){
							output.append(nextChar);
							map.put(nextChar, map.get(nextChar) - 1);
							break;
						}else{
							j++;
						}
					}
					 
					// if next char occurrence is not present, then delete current char remaining values.
					if((i + j) >= inputKeySetSize ) {
						map.put(currentChar, 0);
						break;
					}

				}
				
				output.append(currentChar);
				map.put(currentChar, map.get(currentChar) - 1);
				consecutiveCount++;

			}
		}

		return output.toString();
	}

	@Test
	public void inputData1() {
		String s = "cccba";
		int k = 2;

		System.out.println(rearrangeString(s, k));

	}
	
	@Test
	public void inputData2() {
		String s = "zzzazz";
		int k = 2;

		System.out.println(rearrangeString(s, k));

	}
	
	@Test
	public void inputData3() {
		String s = "zzyyyy";
		int k = 2;

		System.out.println(rearrangeString(s, k));

	}
	
	

}
