package strings;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

public class UniqueChars {
	
	@Test
	public void te() {
		String s="Lakshminarayanan";
		getUnique(s);
	}
	
	private void getUnique(String s) {
		HashMap<Character,Integer> charmap= new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			charmap.put(s.charAt(i), charmap.getOrDefault(s.charAt(i), 0)+1);
			
		}
		
		for (Entry<Character, Integer> chars : charmap.entrySet()) {
			if(chars.getValue()==1) {
				System.out.println("The character "+chars.getKey()+ " is occuring only once");
			}
		}
		
		
	}
	
	
	
	

}
