package assessment.week16;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class LargestString {
	
	/*
	 * Given a string, construct a new String by rearranging the original string and deleting characters
	 * as needed. Return the alphabetically largest string that can be constructed respecting the limit as to how many
	 * consecutive characters can be the same
	 * 
	 * Example: s="baccc"
	 * k=2
	 * O/P: ccbca
	 * 
	 * The largest string alphabetically is cccba. But it is not allowed because it uses the character c more than
	 * 2 times consecutively, therefore answer is ccbca
	 */
	
	
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
		String s = "axxzzx";
		int k = 2;
		System.out.println(rearrangeString(s, k));
	}	
	
	
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

}
