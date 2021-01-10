package ds.assignments;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class LongestSubString3 {

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

	// Using ASCII 
	private int longestSubString(String str) {
		int n = str.length();
		int maxValue = 0;
		int i = 0; 
        int[] index = new int[128];
        for (int j = 0; j < n; j++) {
            i = Math.max(index[str.charAt(j)], i);
            maxValue = Math.max(maxValue, j - i + 1);
            index[str.charAt(j)] = j + 1;
        }
        return maxValue;
	}


}
