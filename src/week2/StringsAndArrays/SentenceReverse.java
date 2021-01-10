package week2.StringsAndArrays;

import org.junit.Test;

public class SentenceReverse {
	
	@Test
	public void example1() {
		String s= "I am doing great";
		String reverseSentence = reverseSentence(s);
		System.out.println(reverseSentence);
	}
	
	@Test
	public void example2() {
		String s= "I am doing great";
		String reverseSentence = reverseSentences(s);
		System.out.println(reverseSentence);
	}
	
	
	
	
	private String reverseSentence(String s) {
		String[] splitsentence=s.split(" ");
		String modified_sentence="";
		for (int i = 0; i < splitsentence.length; i++) {
			modified_sentence+=new StringBuffer(splitsentence[i]).reverse().toString()+" ";
		}
		return modified_sentence;
	}
	
	
	private String reverseSentences(String s) {
		String[] splitsentence=s.split(" ");
		String modified_sentence="";
		for (int i = 0; i < splitsentence.length; i++) {
			char[] charArray=splitsentence[i].toCharArray();
			int left=0;
			int right=charArray.length-1;
			while(left<right) {
				char temp=charArray[left];
				charArray[left++]=charArray[right];
				charArray[right--]=temp;
			}
			modified_sentence+=String.valueOf(charArray)+" ";
		}
		return modified_sentence;
	}
	
	
	
	

}
