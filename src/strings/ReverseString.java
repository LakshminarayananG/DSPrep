package strings;

import java.util.Arrays;

import org.junit.Test;

public class ReverseString {
	
	@Test
	public void example1() {
	String input="Laks";
	StringBuffer sb = new StringBuffer(input);
	System.out.println(sb.reverse());
	}
	
	
	@Test
	public void example2() {
	String input="Laks";
	StringBuilder sb= new StringBuilder(input);
	System.out.println(sb.reverse());
	}
	
	@Test
	public void example3() {
	String input="Laks";
	reverseString(input);
	}
	
	@Test
	public void example4() {
	String input="Laks";
	reverse(input);
	}
	
	
	
	
	private void reverse(String input) {
		for(int i=input.length()-1;i>=0;i--) {
			System.out.print(input.charAt(i));
		}
	}
	
	private String reverseString(String input) {
		char[] charArray=input.toCharArray();
		int left=0;
		int right=charArray.length-1;
		while(left<right) {
			char temp=charArray[left];
			charArray[left++]=charArray[right];
			charArray[right--]=temp;
		}
		return Arrays.toString(charArray);
	}
	



}
