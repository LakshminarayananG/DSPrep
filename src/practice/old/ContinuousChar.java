package practice.old;

import org.junit.Test;

public class ContinuousChar {
	
	@Test
	public void eg1() {
		String input="ABAB";
		int k=2;
		System.out.println(maxcount(input, k));
	}
	
	@Test
	public void eg2() {
		String input="AABABBA";
		int k=1;
		System.out.println(maxcount(input, k));
	}
	
	
	
	
	private int maxcount(String input, int k) {
		int maxcount=1, left=0, right=0, replacecount=k, count=0;
		
		for(int i=0;i<input.length();i++) {
		if(right<input.length()-1) {
		if(input.charAt(left)==input.charAt(right)) {
			count++;
			right++;
		}	
		
		if(input.charAt(left)!=input.charAt(right)) {
			replacecount--;
			count++;
			right++;
		}
		
		if(replacecount==0) {
			left++;
			right=left;
			maxcount=Math.max(count, maxcount);
		}
		
		}
		}
		
		return maxcount;
		
		
		
	}

}
