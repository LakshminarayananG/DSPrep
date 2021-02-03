package assessment.week20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Test;

public class AncestralNames {
	
	@Test
	public void example1() {
		List<String> names= Arrays.asList(new String[] {"Steven XL","Steven XVI","David IX","Mary XV","Mary XIII","Mary XX"});
		System.out.println(sortNames(names));
	}
	
	@Test
	public void example2() {
		List<String> names= Arrays.asList(new String[] {"Zack XL","Steven XVI","Rachel L","Rachel II","Zack IX"});
		System.out.println(sortNames(names));
	}
	
	@Test
	public void example3() {
		List<String> names = Arrays.asList(new String[] { "Bruce XVIII", "Bruce XXVII", "Bruce XXVI", "Bruce XLI",
				"Francois VI", "Francois XL", "Francois XX", "Francois XXIII", "Francois XXIV", "Francois XXV", "Louis XLI",
				"Louis XLIII", "Louis XV", "Louis XXIX", "Luka I", "Luka XLII", "Luka XVII", "Luka XXII", "Luka XXXVII",
				"Maru XLI", "Maru XVIII", "Maru XXXIV", "Maru XXXV", "Mary XLII", "Mary XXIV", "Mary XXVIII", "Mary XXX",
				"Mary XXXV", "Mimino XXXVIII", "Paul VI", "Paul VIII", "Paul XLIX", "Paul XVII", "Paul XX", "Petrzlen I",
				"Petrzlen XVI", "Petrzlen XX", "Petrzlen XXXIV", "Petrzlen XXXVII", "Philippe L", "Philippe VII",
				"Philippe XV", "Philippe XXXVIII", "Rasto XV", "Tomek IX", "Tomek V", "Tomek VIII" });
		System.out.println(sortNames(names));
	}
	
	private List<String> sortNames(List<String> names) {
		Map<String, List<String>> map = new TreeMap<>();

		for (String str : names) {
			String[] split = str.split(" ");

			map.putIfAbsent(split[0], new ArrayList<>());
			map.get(split[0]).add(split[1]);
		}

		List<String> output = new ArrayList<>();

		for (Map.Entry<String, List<String>> mp : map.entrySet()) {
			List<String> temp = mp.getValue();
			Collections.sort(temp,(a,b)->convertRoman(a)-convertRoman(b));

			for (String str : temp)
				output.add(mp.getKey() + " " + str);
		}

		return output;
	}
	
	private List<String> sortNames1(List<String> names) {
		Map<String, Integer> map=new TreeMap<>();
		
		for(String str:names)
			map.put(str, convertRoman(str.split(" ")[1]));
		System.out.println(map);
		//PriorityQueue<String> pq = new PriorityQueue<>(
			//	(entA, entB) -> entA.split(" ")[0].equals(entB.split(" ")[0]) ? map.get(entA) - map.get(entB)
				//		: entA.split(" ")[0].compareTo(entB.split(" ")[0]));
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
				(a, b) -> a.getKey().split(" ")[0].equals(b.getKey().split(" ")[0]) ? a.getValue() - b.getValue()
						: a.getKey().split(" ")[0].compareTo(b.getKey().split(" ")[0]));
		
		for(Map.Entry<String, Integer> mp:map.entrySet())
			pq.offer(mp);
		System.out.println(pq);
		return new ArrayList<>();
	}
	
	public int convertRoman(String s) {
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
