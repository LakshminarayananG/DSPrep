package week7.homework;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class TwoDistinctChar {
	
	@Test
	public void eg1() {
		String input="eecccabbbcccccbbbb";
		System.out.println(logestLength(input));
	}
	
	

	@Test
	public void eg2() {
		String input="eecccabbbcccccbbbb";
		System.out.println(longestLength(input));
	}
	
	
	@Test
	public void eg3() {
		String input="aaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println("Logest: "+logestLength(input));
		System.out.println(longestLength(input));
	}
	
	
	public int logestLength(String input) {
		Map<Character, Integer> map = new LinkedHashMap<Character,Integer>();
		int maxval=0;  //eecccabbbbb
		int temp=0;
		for(int i=0;i<input.length();i++) {			
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);			
			if(map.size()>2) {
				maxval=Math.max(maxval, i-temp);
				
			while(map.size()>2) {
				char ch= input.charAt(temp);
				if(map.get(ch)==1) {
					map.remove(ch);
				}
				else {
					map.put(ch, map.get(ch)-1);
				}
				temp++;
			}
			}
		
		}
		return Math.max(maxval, input.length()-temp);
	}
	
	
	public int longestLength(String input) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		int maxval = 0;
		int temp = 0;
		for (int i = 0; i < input.length(); i++) {
			int currentMax=0;
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
			if (map.size() == 2) {
				 Collection<Integer> values = map.values();
				 for (Integer integer : values) {
					currentMax+=integer;
				}
				maxval = Math.max(maxval, currentMax);

			} else if (map.size() > 2) {
				map.put(input.charAt(temp), map.get(input.charAt(temp)) - 1);
				if(map.get(input.charAt(temp))==0){
					map.remove(input.charAt(temp));
				}
				temp++;
			}

		}

		return maxval;
	}

}
