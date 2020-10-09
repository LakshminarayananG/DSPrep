package practice;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LongestPalindromicSubString {
	
	@Test
	public void eg1() {
		String str="malayalammadam";
		System.out.println(palind(str));
	}
	
	@Test
	public void eg2() {
		String str="babad";
		System.out.println(palind(str));
	}
	
	
	private int palind(String input) {
		Set<String> set = new HashSet<String>();
		int maxcount=0;int currentlen=0;
		for(int i=0;i<input.length();i++) {
			//For odd number of Palindrome
			String str=expand(input,i,i,set);
			currentlen=str.length();
			if(currentlen>maxcount) {
				maxcount=currentlen;
			}
			
			//For even number of palindrome
			expand(input,i,i+1,set);
			currentlen=str.length();
			if(currentlen>maxcount) {
				maxcount=currentlen;
			}
			
		}
		return maxcount;
	}
	
	
	private String expand(String input, int low, int high, Set<String> set) {
		while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
			set.add(input.substring(low, high + 1));
				low--;
				high++;
		}
		
		return input.substring(low+1, high);
	}

}
