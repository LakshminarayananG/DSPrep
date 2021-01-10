package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class PossibleSubStrings {
	
	@Test
	public void eg1() {
		String input="abab";
		printPalindromicStrings(input);
	}
	
	@Test
	public void eg2() {
		String input="abab";
		System.out.println(remove(input));
	}
	
	
	@Test
	public void eg3() {
		String input="aaabbb";
		System.out.println(remove(input));
	}
	
	@Test
	public void eg4() {
		String input="aaabbb";
		System.out.println(removedel(input));
	}
	
	private void printPalindromicStrings(String input) {
		List<String> outputList = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				String temp = input.substring(i, j);				
					outputList.add(temp.toString());
				
			}
			String tmp = input.substring(i);
			
				outputList.add(tmp.toString());
			
		}
		System.out.println(input);
		System.out.println(outputList);
		System.out.println();
	}
	
	
	private int remove(String s) {
		char[] chararr=s.toCharArray();
		Map<Character,Integer> map= new HashMap<Character,Integer>();
		for (char c : chararr) {
			
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int delete=0;
		for (Character c : map.keySet()) {
			if(map.get(c)>1) {
				while(map.get(c)>1) {
					map.put(c, map.get(c)-1);
					delete++;
				}
			}
		}
		
		return delete;
	}
	
	private int removedel(String s) {
String output = "";
		
		for (int i = 0; i < s.length(); i++) {
			
			if(!(output.contains(s.charAt(i)+""))){
				output+=s.charAt(i);
			}
			
		}
		System.out.println(s.length()-output.length());
		return s.length()-output.length();
	}
}
