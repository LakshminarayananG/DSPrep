package week2.StringsAndArrays;

import java.util.HashMap;
import org.junit.Test;

public class Anagrams {
	
	@Test
	public void eg1() {
		String samp="abccbaccbbaacbbcacb";
		String anagram="abc";
		findanagram(samp,anagram);
	}
	
	private void findanagram(String input,String anag) {
		HashMap<Character,Integer> anagram= new HashMap<Character,Integer>();
		HashMap<Character,Integer> inputtext= new HashMap<Character,Integer>();
		for(int i=0;i<anag.length();i++) {
			anagram.put(anag.charAt(i), anagram.getOrDefault(anag.charAt(i), 0)+1);
		}
		
		for(int i=0;i<input.length();i++) {
			char ch=input.charAt(i);
			inputtext.put(ch, inputtext.getOrDefault(ch, 0)+1);
			
			if(i>=anag.length()) {
				ch=input.charAt(i-anag.length());
				if(inputtext.get(ch)==1) {
					inputtext.remove(ch);
				}
				else {
					inputtext.put(ch, inputtext.get(ch)-1);
				}
				}
			
			if(inputtext.equals(anagram)) {
				System.out.println("I got it "+(i-anag.length()));
			}
		}
		
	}

}
