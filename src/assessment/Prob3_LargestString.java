
package assessment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
		int temp=0;int addedCount=0;
		
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

}
