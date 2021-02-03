package problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;



public class GroupingTransactions_23 {
	/*
	For a given array of transactions, group all of the transactions by item name. Return an array of strings where each string contains the item name followed by a space and the number of associated transactions.
	Note: Sort the array descending by transaction count, then ascending alphabetically by item name for items with matching transaction counts.

	Example
	transactions = ['notebook', 'notebook', 'mouse', 'keyboard', 'mouse']
	There are two items with 2 transactions each: 'notebook' and 'mouse'. In alphabetical order, they are 'mouse', 'notebook'. There is one item with 1 transaction: 'keyboard'. The return array, sorted as required, is ['mouse 2', 'notebook 2', 'keyboard 1'].

	Sample Case 0
	Sample Input
	STDIN Function
	----- -----
	4 → transactions[] size n = 4
	bin → transactions = ['bin', 'can', 'bin', 'bin']
	can
	bin
	bin
	Sample Output
	bin 3
	can 1
	Explanation
	There is one item 'bin' with 3 transactions. There is one item 'can' with 1 transaction. The return array sorted descending by transaction count, then ascending by name is ['bin 3', 'can 1'].

	Sample Case 1
	Sample Input
	STDIN Function
	----- -----
	3 → transactions[] size n = 3
	banana → transactions = ['banana', 'pear', 'apple']
	pear
	apple
	Sample Output
	apple 1
	banana 1
	pear 1

	Explanation
	There is one item 'apple' with 1 transaction. There is one item 'banana' with 1 transaction. There is one item 'pear' with 1 transaction. The return array sorted descending by transaction count, then ascending by name is ['apple 1', 'banana 1', 'pear 1'].
	*/
	
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
