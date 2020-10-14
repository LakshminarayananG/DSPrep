package assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Prob3 {
	
	@Test
	public void eg1() {
		
	}
	
	
	private void charlimit(String input, int val) {
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		List<Character> list= new ArrayList<Character>();
		String out="";
		
		for (char character : input.toCharArray()) {
			map.put(character, map.getOrDefault(character, 0)+1);
			list.add(character);
		}
		
		Collections.sort(null);
		
		for (Character character : list) {
			out+=character;		
			}
		
		StringBuilder sb = new StringBuilder(out);
		sb.reverse();
	}
	
	
	private void buildString(String input,int k, Map<Character, Integer> map ) {
		for (char iterable_element : input.toCharArray()) {
			
		}
	}
	
	
	

}
