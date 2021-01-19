package practice.old;

import java.util.Arrays;
import java.util.HashMap;
import org.junit.Test;

public class PermutationOfString {
	
	@Test
	public void eg1() {
		String s1="abb";
		String s2="eidbdooobab";
		System.out.println("One: "+check(s1, s2));
	}
	
	@Test
	public void eg2() {
		String s1="ab";
		String s2="eidboaoo";
		System.out.println("Two: " +check(s1, s2));
	}
	
	
	@Test
	public void eg3() {
		String s1="ab";
		String s2="eidaobo";
		System.out.println("Three: "+ check(s1, s2));
	}
	
	@Test
	public void eg4() {
		String s1="abc";
		String s2="bcb";
		System.out.println("Four: " +check(s1, s2));
	}
	
	@Test
	public void eg5() {
		String s1="abc";
		String s2="bcbacbh";
		System.out.println("Five: " +check(s1, s2));
	}
	
	
	
	
	public boolean checkInclusion(String s1, String s2) {
	    HashMap<Character, Integer> dict = new HashMap<>();
	    for (int i = 0; i < s1.length(); i++) {
	        int feq = dict.getOrDefault(s1.charAt(i), 0);
	        dict.put(s1.charAt(i), feq + 1);
	    }
	 
	    HashMap<Character, Integer> temp = new HashMap<>();
	    int i = 0;
	    for (int j = 0; j < s2.length(); j++) {
	        if (!dict.containsKey(s2.charAt(j))) {
	            i = j + 1;
	            temp.clear(); //clear counter
	            continue;
	        }
	 
	        int count = temp.getOrDefault(s2.charAt(j), 0);
	        if (count == 0 || count < dict.get(s2.charAt(j))) {
	            temp.put(s2.charAt(j), count + 1);
	 
	            if (j - i + 1 == s1.length()) {
	                return true;
	            }
	        } else {
	            while (i < j) {
	                if (s2.charAt(i) == s2.charAt(j)) {
	                    i++;
	                    break;
	                }
	 
	                temp.put(s2.charAt(i), temp.get(s2.charAt(i)) - 1);
	                i++;
	            }
	        }
	    }
	 
	    return false;
	}
	
	
	
	public boolean checkExist(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
        	s1map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
	
	
	
	private boolean check(String s1,String s2) {
		HashMap<Character, Integer> map1= new HashMap<Character,Integer>();
		HashMap<Character, Integer> map2= new HashMap<Character,Integer>();
		boolean value=false;
		if(s1.length()>s2.length()) {
			return false;
		}
		
		for(int i=0;i<s1.length();i++) {
			map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
		}
		
		if(s1.length()==s2.length()) {
			for(int i=0;i<s2.length();i++) {
				map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
			}
			if(map1.equals(map2))
				return true;
		}
		
		
		for(int j=0;j<s2.length();j++) {
			char ch=s2.charAt(j);
			map2.put(ch, map2.getOrDefault(ch, 0)+1);
			
			if(j>=s1.length()) {
				ch=s2.charAt(j-s1.length());			
			if(map2.get(ch)==1) {
				map2.remove(ch);
			}
			else {
				map2.put(ch, map2.get(ch)-1);
			}
			}
			if(map2.equals(map1)) {
				return true;
			}
		}	
		return value;
	}
	
	
	private Boolean detectAnagrams2(String inputOne,String inputTwo)
	{
		Boolean result=false;
		System.out.println(inputOne.length());
		System.out.println(inputTwo.length());
		if(inputOne.length()>inputTwo.length())
		{
		int[] referenceArray=new int[26];
		int[] currentArray=new int[26];
		inputTwo = inputTwo.toLowerCase();
		int length = inputTwo.length();
		
		for(int i=0;i<length;i++)//O[M]
		{
			referenceArray[inputTwo.charAt(i)-'a']++;
		}
		
		//Initial Window
		for(int i=0;i<length;i++)//O[M]
		{
			currentArray[inputOne.charAt(i)-'a']++;
		}
		
		if(Arrays.equals(referenceArray, currentArray))
		{
			result=true;
			
		}
		
		//Other Windows
		int i=length;
		do
		{
			
			currentArray[inputOne.charAt(i-length)-'a']--;
			currentArray[inputOne.charAt(i)-'a']++;
			if(Arrays.equals(referenceArray, currentArray))//O[M]
			{
				result=true;
				break;
			}
			i++;
			
			
		}while(i<inputOne.length());//O[N-M]
		}

		return result;


	}
	
	

}
