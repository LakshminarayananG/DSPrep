package practice.old;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LongestPalindromicSize {
	
	@Test
	public void eg1() {
		String input="malayalammadam";
		System.out.println(palindromicsize(input));
	}
	
	private int palindromicsize(String input) {
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<input.toCharArray().length;i++) {
			if(set.contains(input.charAt(i))) {
				set.remove(input.charAt(i));
			}
			
			else {
				set.add(input.charAt(i));
			}
		}
		
		if(set.size()<=1) {
			return input.length();
		}
		else {
			return (input.length()-set.size() +1);
		}
	}

}
