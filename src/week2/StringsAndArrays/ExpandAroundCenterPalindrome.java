package week2.StringsAndArrays;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class ExpandAroundCenterPalindrome {
	
	@Test
	public void eg1() {
		String input="google";
		System.out.println(palind(input));
	}
	
	
	@Test
	public void eg2() {
		String input="madam";
		System.out.println(palind(input));
	}
	

	
	
	private Set<String> palind(String input) {
		Set<String> set = new HashSet<String>();
		
		for(int i=0;i<input.length();i++) {
			//Odd no of palindrome
			expand(input,i,i,set);
			
			//even no. of palindrome
			expand(input,i,i+1,set);
		}
		return set;
	}
	
	
	private void expand(String input, int low, int high, Set<String> set) {
		while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
			set.add(input.substring(low, high + 1));
				low--;
				high++;
		}
	}

}
