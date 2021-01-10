package practice.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.junit.Test;

public class SecondLeastInString {
	
	@Test
	public void eg1()
	{
		String input = "Paypal";
		List<Character> inp=secondleast(input);
		System.out.println(inp);
	}
	
	@Test
	public void eg2()
	{
		String input = "Lakshmi";
		List<Character> inp=secondleast(input);
		System.out.println(inp);
	}
	
	@Test
	public void eg3()
	{
		String input = "baba";
		List<Character> inp=secondleast(input);
		System.out.println(inp);
	}
	
	
	@Test
	public void eg4()
	{
		String input = "";
		List<Character> inp=secondleast(input);
		System.out.println(inp);
	}
	
	private List<Character> secondleast(String input) {
		char[] inputChar= input.toCharArray();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		TreeSet<Integer> inputset= new TreeSet<Integer>();
		List<Integer> inputList= new ArrayList<Integer>();
		List<Character> output= new ArrayList<Character>();
		int val=0;
		
		for (char c : inputChar) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for (Entry<Character, Integer> charat : map.entrySet()) {
			inputset.add(charat.getValue());
		}
		
		inputList.addAll(inputset);
		
		if(inputList.size()>=2) {
			val=inputList.get(1);
		}
		else if(inputList.size()<2) {
			throw new RuntimeException("No least repeated character");
		}
		
		
		for (Entry<Character, Integer> charat : map.entrySet()) {
			if(charat.getValue()==val) {
				output.add(charat.getKey());
			}
		}
		
		return output;
	}
}
