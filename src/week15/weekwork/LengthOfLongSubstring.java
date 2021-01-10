package week15.weekwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LengthOfLongSubstring {

	@Test
	public void example1() {
		String s="abcdeafbdgcbb";
		System.out.println(returnLongSubstringLength(s));
	}
	
	private int returnLongSubstringLength(String s) {
		 int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	}
}
