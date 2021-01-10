package practice.old;

import org.junit.Test;

public class StringReversal {
	
	@Test
	public void eg1() {
		String input="Laks";
		System.out.println(reverse(input));
	}
	
	@Test
	public void eg2() {
		String input="Laks";
		System.out.println(reversestr(input));
	}
	
	@Test
	public void eg3() {
		String input="Laks";
		System.out.println(rev(input));
	}
	
	private StringBuffer reverse(String input) {
		StringBuffer sb = new StringBuffer(input);
		return sb.reverse();
	}
	
	private String reversestr(String input) {
		char[] charArray= input.toCharArray();
		String out="";
		for (int i = charArray.length-1; i >=0; i--) {
			out=out+charArray[i];
		}
		
		return out;
	}
	
	//Using 2 pointer Approach
	private String rev(String input) {
		char[] charArray = input.toCharArray();
		int start=0;
		int end=charArray.length-1;
		while(start<end) {
			char ch= charArray[start];
			charArray[start]=charArray[end];
			charArray[end]=ch;
			start++;
			end--;
		}
		
		return String.valueOf(charArray);
	}

}
