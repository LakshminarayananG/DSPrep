package practice.latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class W2_Anagrams {
	
	@Test
	public void eg1() {
		String s1="abb";
		String s2="eidbdooobab";
		System.out.println("One: "+check(s1, s2));
		System.out.println("One: " +anagramascii(s1, s2));
		System.out.println("One: " +anagram(s1, s2));
	}
	
	@Test
	public void eg2() {
		String s1="ab";
		String s2="eidboaoo";
		System.out.println("Two: " +check(s1, s2));
		System.out.println("Two: " +anagramascii(s1, s2));
		System.out.println("Two: " +anagram(s1, s2));
	}
	
	
	@Test
	public void eg3() {
		String s1="ab";
		String s2="eidaobo";
		System.out.println("Three: "+ check(s1, s2));
		System.out.println("Three: " +anagramascii(s1, s2));
		System.out.println("Three: " +anagram(s1, s2));
	}
	
	@Test
	public void eg4() {
		String s1="abc";
		String s2="bcb";
		System.out.println("Four: " +check(s1, s2));
		System.out.println("Four: " +anagramascii(s1, s2));
		System.out.println("Four: " +anagram(s1, s2));
	}
	
	@Test
	public void eg5() {
		String s1="abc";
		String s2="bcbacbh";
		System.out.println("Five: " +check(s1, s2));
		System.out.println("Five: " +anagramascii(s1, s2));
		System.out.println("Five: " +anagram(s1, s2));
		
	}
	
	
	
	private boolean check(String s1,String s2) {
		if(s1.length()>s2.length()) return false;
		if(s1.length()==0 || s2.length()==0) return false;
		
		HashMap<Character,Integer> s1map= new HashMap<Character,Integer>();
		HashMap<Character,Integer> s2map= new HashMap<Character,Integer>();
		
		for(int i=0;i<s1.length();i++) {
			s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0)+1);
		}
		
		if(s1.length()==s2.length()) {
			for(int i=0;i<s2.length();i++) {
				s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0)+1);
			}
			if(s1map.equals(s2map)) return true;
			else return false;
		}
		
		for(int i=0;i<s2.length();i++) {
			s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0)+1);
			
			if(i>=s1.length()) {
				char ch=s2.charAt(i-s1.length());
				if(s2map.get(ch)==1) 
				{
					s2map.remove(ch);
				}
				else {
					s2map.put(ch, s2map.get(ch)-1);
				}
				if(s1map.equals(s2map)) return true;
			}
		}
		
		
		return false;
	}

	
	private boolean anagramascii(String s1,String s2) {
		if(s1.length()>s2.length()) return false;
		if(s1.length()==0 || s2.length()==0) return false;
		
		int[] s1char= new int[26];
		int[] s2char= new int[26];
		
		for(int i=0;i<s1.length();i++) {
			s1char[s1.charAt(i)-'a']+=1;
		}
		
		if(s1.length()==s2.length()) {
			for (int i = 0; i < s2.length(); i++) {
				s2char[s2.charAt(i)-'a']+=1;
			}
			if(Arrays.equals(s1char, s2char)) return true;
			else return false;
		}
		
		for(int i=0;i<s2.length();i++) {
			s2char[s2.charAt(i)-'a']+=1;
			if(i>=s1.length()) {
				char ch= s2.charAt(i-s1.length());
				if(s2char[ch-'a']==1) {
					s2char[ch-'a']=0;
				}
				else s2char[ch-'a']-=1;
				
				if(Arrays.equals(s1char, s2char)) return true;
			}
		}
		
		return false;
	}
	
	
	private boolean anagram(String s1,String s2) {
		if(s1.length()==0|| s2.length()==0 || s1.length()>s2.length()) return false;
		Map<Character,Integer> s1map=new HashMap<Character,Integer>();
		for(int i=0;i<s1.length();i++) {
			s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0)+1);
		}
		
		Map<Character,Integer> s2map=new HashMap<Character,Integer>();
		if(s1.length()==s2.length()) {
			for(int i=0;i<s2.length();i++) {
				s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0)+1);
			}
			
			if(s1map.equals(s2map)) return true;
		}
		
		
		for(int i=0;i<s2.length();i++) {
			s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0)+1);
			
			if(i>=s1.length()) {
				char ch=s2.charAt(i-s1.length());
				
				if(s2map.get(ch)==1) {
					s2map.remove(ch);
				}
				else if(s2map.get(ch)>1) {
					s2map.put(ch, s2map.get(ch)-1);
				}
				
				if(s1map.equals(s2map)) return true;
			}
		}
		
		
		return false;
	}
	
	
}
