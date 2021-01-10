package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class VowelsReversal {
	
	@Test
	public void eg1() {
		String input="testleaf";
		System.out.println(reverse(input));
	}
	
	
	@Test
	public void eg2() {
		String input="testleaf";
		System.out.println(reverse2Point(input));
	}
	
	private String reverse(String input) {
		char[] ch= input.toCharArray();
		List<Character> inputlist= new ArrayList<Character>();		
		
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'||ch[i]=='a'||
					ch[i]=='A'||ch[i]=='E'||ch[i]=='I'||ch[i]=='O'||ch[i]=='U') {
				inputlist.add(ch[i]);
			}
		}
		
		Collections.reverse(inputlist);
		
		int val=0;
		String out="";
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'||ch[i]=='a'||
					ch[i]=='A'||ch[i]=='E'||ch[i]=='I'||ch[i]=='O'||ch[i]=='U') {
				out+=inputlist.get(val);
				val++;
			}
			else {
				out+=ch[i];
			}
		}
		
		return out;
		
	}
	
	
	//Using 2 pointer approach
	private String reverse2Point(String input) {
		int i=0;
		int j=input.length()-1;
		char[] inputcharArr=input.toCharArray();
		
		ArrayList<Character> vowList = new ArrayList<Character>(Arrays.asList('a','e','i','o','u','A',
				'E','I','O','U'));
	    
	    while(i<j) {
	    	if(!vowList.contains(inputcharArr[i])){
	            i++;
	            continue;
	        }
	 
	        if(!vowList.contains(inputcharArr[j])){
	            j--;
	            continue;
	        }	 
	        char t = inputcharArr[i];
	        inputcharArr[i]=inputcharArr[j];
	        inputcharArr[j]=t;	 
	        i++;
	        j--; 
	    }	 
	    return new String(inputcharArr);
	    }
	}


