package ds.assignments;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class LongestSubString2 {

	@Test
	public void example1() {
		String str = "pebdbfghi";
		System.out.println(longestSubString(str));
	}

	@Test
	public void example2() {
		String str = "bbbbb";
		System.out.println(longestSubString(str));
	}

	private int longestSubString(String str) {
		int n = str.length();
		Set<Character> set = new HashSet<>();
		int i=0, j=0;
		int maxValue = 0;
		while(i < n && j < n ) { // O[2N] => O[N]
			if(set.contains(str.charAt(i))) {
				set.remove(str.charAt(j++));
			}else {
				set.add(str.charAt(i++));
				maxValue = Math.max(maxValue, i-j);
			}
		}
		return maxValue;
	}


}
