package week19.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GroupChars {
	
	/*
	 * Given an array of string, group the strings that are composed by the same
	 * character, returning an array of arrays. For example, given: ["124", "412",
	 * "425", "241", "524", "324", "2141"], Return: [ ["241", "124","412"],
	 * ["524","425"], ["324"], ["2141"] ]
	 */
	
	@Test
	public void eg1() {
		String[] input= {"124","412","425","241","524","324","2141"};
		System.out.println(groupschar(input));
		System.out.println(groupchar(input));
	}
	
	@Test
	public void eg2() {
		String[] input= {"121","211","425","241","524","178","112"};
		System.out.println(groupschar(input));
		System.out.println(groupchar(input));
	}

	
	
		private ArrayList<ArrayList<String>> groupschar(String[] strs) {
			Map<Map<Character, Integer>, ArrayList<String>> map = new HashMap<Map<Character, Integer>, ArrayList<String>>();

			for (int i = 0; i < strs.length; i++) {
				char[] chararr = strs[i].toCharArray();
				Map<Character, Integer> temp = new HashMap<Character, Integer>();
				for (int j = 0; j < chararr.length; j++) {
					temp.put(chararr[j], temp.getOrDefault(chararr[j], 0) + 1);
				}
				map.computeIfAbsent(temp, k -> new ArrayList<>()).add(strs[i]);
			}
			return new ArrayList(map.values());
		}
		
		public List<List<String>> groupAnagrams(String[] strs) {
	        Map<String, List> ans = new HashMap<String, List>();
			for (String s : strs) {
				String temp = "";
				int sum=0;
				int prod = 1;
				for (int i = 0; i < s.length(); i++) {
					sum = sum + (int)s.charAt(i);
					prod = prod * (int)s.charAt(i);
				}
				temp = sum+"|"+prod;
				if (!ans.containsKey(temp)) ans.put(temp, new ArrayList());
				ans.get(temp).add(s);
			}
			return new ArrayList(ans.values());
	    }	
		
		
		private ArrayList<ArrayList<String>> groupchar(String[] input) {
			Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

			for (int i = 0; i < input.length; i++) {
				char[] chararr = input[i].toCharArray();
				Arrays.sort(chararr);
				String temp = String.valueOf(chararr);
				map.computeIfAbsent(temp, k -> new ArrayList<>()).add(input[i]);
			}
			return new ArrayList(map.values());
		}
}