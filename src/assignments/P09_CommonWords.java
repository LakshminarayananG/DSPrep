package assignments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class P09_CommonWords {
	
	/*Write a program that tells all the words containing same letters (anagrams)

	Input: "Stale are there in tesla and you can steal the pears";
	Output: [Stale, Tesla, Steal]*/

	// @Test
	public void eg1() {
		String s1 = "this stale are there in tesla and you can steal the pears";
		Set<String> output = possiblewords(s1);
		System.out.println(output);
	}
	
	

	@Test
	public void eg2() {

	String s1="stale are there in tesla and you can steal the pears";
	Set<String> output=sameWords(s1);
	System.out.println(output);
	}



	//Brute Force Technique
	/*  1. Convert the given string into a string array
	2. Create a new list to store the ascii value of each string present in string array
	3. Iterate through the string array
	4. Iterate through each string within the array and get ascii value of each string
	5. Store the ascii value in the list
	6. Create a new set and a map
	7. Iterate through the string array
	8. Check if the map is already having the element with corresponding ascii value
	9. If it already has, add both the current element and also the element from the map to set
	10. return the set*/

	//Complexity is o[n^2]
	private Set<String> sameWords(String input) {
		String[] split = input.toLowerCase().split(" ");
		List<Integer> asc = new ArrayList<Integer>();

		for (int i = 0; i < split.length; i++) { // O[N]
			int ascii = 0;
			for (int j = 0; j < split[i].length(); j++) { // O[N]
				ascii += split[i].charAt(j);
			}
			asc.add(ascii);

		}

		Map<Integer, String> resultmap = new HashMap<Integer, String>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < split.length; i++) { // O[N]
			if (resultmap.containsKey(asc.get(i))) {
				set.add(resultmap.get(asc.get(i)));
				set.add(split[i]);
			} else {
				resultmap.put(asc.get(i), split[i]);

			}
		}

		return set;
	}
	
	

	//Alternate Approach
	/*  1. Convert string into string array removing the spaces
	2. Iterate over the string array and sort each string
	3. Create a new set and a map
	4. Iterate through the string array
	5. Check if the map is already having the element with corresponding ascii value
	6. If it already has, add both the current element and also the element from the map to set
	7. return the set*/

	private Set<String> possiblewords(String input) {
		String[] split = input.toLowerCase().split(" ");

		for (int i = 0; i < split.length; i++) {
			String[] spt = split[i].split("");
			Arrays.sort(spt);
			split[i] = String.join("", spt);
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < split.length; i++) {
			if (map.containsKey(split[i])) {
				set.add(input.split(" ")[map.get(split[i])]);
				set.add(input.split(" ")[i]);
			} else
				map.put(split[i], i);

		}
		return set;
	}

}
