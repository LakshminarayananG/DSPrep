package week15;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RomanToInteger {
	
	@Test
	public void eg1() {
		String s="III";
		System.out.println(romanToInt(s));
	}
	
	@Test
	public void eg2() {
		String s="IV";
		System.out.println(romanToInt(s));
	}
	
	@Test
	public void eg3() {
		String s="IX";
		System.out.println(romanToInt(s));
	}
	
	@Test
	public void eg4() {
		String s="VIII";
		System.out.println(romanToInt(s));
	}
	
	@Test
	public void eg5() {
		String s="MCMXCIV";
		System.out.println(romanToInt(s));
	}
	
	
	public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
		map.put('M',1000);
	    map.put('D', 500);
	    map.put('C', 100);
	    map.put('L', 50);
	    map.put('X', 10);
	    map.put('V', 5);
	    map.put('I', 1);
		int previous=0;
		int current=0;
		int val=0;
		int i=s.length()-1;
		while(i>=0) {
			current=map.get(s.charAt(i));
			
			if(current>=previous) val+=current;
			else val-=current;
		previous=current;
		i--;
		}
		
		return val;
        
    }

}
