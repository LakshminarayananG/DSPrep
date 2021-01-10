package assessment.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class P3_GroupingTransactions {
	@Test
	public void example1() {
		List<String> list=new ArrayList<String>(Arrays.asList("notebook","notebook","mouse","keyboard","mouse"));
		groupingTransactions(list);
	}
	
	@Test
	public void example2() {
		List<String> list=new ArrayList<String>(Arrays.asList("bin","can","bin","bin"));
		groupingTransactions(list);
	}
	
	@Test
	public void example3() {
		List<String> list=new ArrayList<String>(Arrays.asList("banana","pear","apple"));
		groupingTransactions(list);
	}
	
	private void groupingTransactions(List<String> list) {
		Map<String, Integer> map=new TreeMap<>();
		List<String> op=new ArrayList<String>();
		
		for (String s:list) 
			map.put(s, map.getOrDefault(s, 0)+1);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
		forEach(m->{
			op.add(m.getKey()+" "+m.getValue());
		});
		
		System.out.println(op);
	}
}
