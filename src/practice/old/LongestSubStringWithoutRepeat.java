package practice.old;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class LongestSubStringWithoutRepeat {
	//@Test
	public void example1() {
		String str = "pebdbfghi";
		System.out.println(longestSubString(str));
	}

	@Test
	public void example2() {
		String str = "pebdbfghibwqtuolk";
		System.out.println("long: "+longestSubString(str));
	}
	
	@Test
	public void example3() {
		String str = "pebdbfghi";
		System.out.println(longestSubStringasc(str));
	}
	
	public void example4() {
		String str = "pebdbfghi";
		longestsub(str);
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
	
	
		
	
	private int longestSubStringasc(String str) {
		int n = str.length();
		int maxValue = 0;
		int i = 0; 
        int[] index = new int[128];
        for (int j = 1; j <= n; j++) {
            i = Math.max(index[str.charAt(j-1)], i);
            maxValue = Math.max(maxValue, j - i );
            index[str.charAt(j-1)] = j;
        }
        return maxValue;
	}
	
	
	private void longestsub(String s) {
		int max=0;
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(list.contains(s.charAt(i))) {
				max=Math.max(max, list.size());
				list.clear();
			}
			list.add(s.charAt(i));
			max=Math.max(max, list.size());
			
		}
		System.out.println(max);
	}

}
