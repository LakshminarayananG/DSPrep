package problems.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;


public class CheckPalindromeFormed_42 {
	
	//Given an input string, one character should be removed, such that the final string can be formed a palindrome

	@Test
	public void example1() {
		String input="test";
		Assert.assertEquals(true, isPalindromeFormed(input));
	}
	
	@Test
	public void example2() {
		String input="leaf";
		Assert.assertEquals(false, isPalindromeFormed(input));
	}
	
	@Test
	public void example3() {
		String input="aba";
		Assert.assertEquals(true, isPalindromeFormed(input));
	}
	
	@Test
	public void example4() {
		String input="ajay";
		Assert.assertEquals(true, isPalindromeFormed(input));
	}
	
	@Test
	public void example5() {
		String input="abbyd";
		Assert.assertEquals(false, isPalindromeFormed(input));
	}
	
	
	
	//Pseudo code
	/*
	 * add each char occurrence to the set
	 * if the element is already present in the set, remove from it
	 * finally, we'll have characters without pair in the set
	 * get size of set
	 	* if set size is greater than 2 return false (we'll be having more odd occurrence with which palindrome can't be formed)
	 	* if set size is less 2 and return true (1 odd will be removed and another one to form odd palindrome) 
	 */
	//Space: O[N]
	//Time: O[N]
	
	private boolean isPalindromeFormed(String input) {
		Set<Character> set=new HashSet<>();
		
		for(char c:input.toCharArray())
			if(!set.add(c))
				set.remove(c);
		
		if(set.size()>2)
			return false;
		
		return true;
	}
	
	//Space: O[N]
	//Time: O[N]
	private boolean isPalindromeFormed1(String input) {
		Map<Character, Integer> map=new HashMap<>();
		
		for(char c:input.toCharArray())
			map.put(c, map.getOrDefault(c, 0)+1);
		
		int odd=0;
		for(int eachVal:map.values()) {
			if(eachVal%2==1)
				odd++;
			
			if(odd>2)
				return false;
		}
		
		return true;
	}
}
