package week15.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class GroupAnagrams {
	
	/*
	* Given an array of strings strs, group the anagrams together. You can return
	* the answer in any order. Example 1: Input: strs =
	* ["eat","tea","tan","ate","nat","bat"] Output:
	* [["bat"],["nat","tan"],["ate","eat","tea"]] List<List<String>>
	*/

	/*
	* Pseudo code:
	* 1. Iterate through the string array
	* 2. Get individual string and convert to character array
	* 3. Sort the character array
	* 4. Check if the map contains the sorted char as key, if it does not contain, put sorted string as key and
	* corresponding index value as string in the list
	* 5. If it already contains, add the string to the list
	* 6. return map values
	*/

	@Test
	public void eg1() {
	String[] input= {"eat","tea","tan","ate","nat","bat"};
	System.out.println("Eg1 :"+groupanag(input));

	}

	@Test
	public void eg2() {
	String[] input = {"eat","tea","ate"};
	System.out.println("Eg2 :"+groupanag(input));
	}

	@Test
	public void eg3() {
	String[] input= {"test", "rest", "mist"};
	System.out.println("Eg3 :"+groupsanag(input));
	}

	@Test
	public void eg4() {
	String[] input= {"eat","tea","tan","ate","nat","bat"};
	System.out.println("Eg4 :"+groupsanag(input));
	}


	//Complexity --> O[nlogn]
	private ArrayList<ArrayList<String>> groupanag(String[] input) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < input.length; i++) {
			char[] chararr = input[i].toCharArray();
			Arrays.sort(chararr);
			String temp = String.valueOf(chararr);
			map.computeIfAbsent(temp, k -> new ArrayList<>()).add(input[i]);
		}
		return new ArrayList(map.values());
	}


	//Complexity --> O[N*M]
	private ArrayList<ArrayList<String>> groupsanag(String[] input) {
		Map<Map<Character, Integer>, ArrayList<String>> map = new HashMap<Map<Character, Integer>, ArrayList<String>>();

		for (int i = 0; i < input.length; i++) {
			char[] chararr = input[i].toCharArray();
			Map<Character, Integer> temp = new HashMap<Character, Integer>();
			for (int j = 0; j < chararr.length; j++) {
				temp.put(chararr[j], temp.getOrDefault(chararr[j], 0) + 1);
			}
			map.computeIfAbsent(temp, k -> new ArrayList<>()).add(input[i]);
		}
		return new ArrayList(map.values());
	}

}
