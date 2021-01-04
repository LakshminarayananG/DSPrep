package week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

public class GroupTransactions {
	
	/*
	 * For a given array of transactions, group all of the transactions by item name.
	 * Return an array of Strings where each String contains the item name followed by a space and the number 
	 * of associated transactions.
	 * 
	 * Note: Soer the array in descending count, then ascending alphabetically by item name for items matching
	 * transaction counts
	 * 
	 * Example:
	 * transactions = ["notebook","notebook","mouse","keyboard","mouse"]
	 * There are 2 items with 2 transactions each. Notebook and mouse. In alphabetical order, they are mouse
	 * followed by notebook. There is one item with 1 transaction Keyboard.
	 * 
	 * Output:["mouse 2","Notebook 2","Keyboard 1"]
	 */
	
	/*
	 * Approach
	 * 1. Add the elements to treemap and iterate through tree map and added key+ values to list
	 * 2. Returned the list
	 */
	
	@Test
	public void eg1() {
		List<String> transactions= new ArrayList<>(Arrays.asList("notebook","notebook","mouse","keyboard","mouse"));
		System.out.println(group(transactions));
	}
	
	
	
	private List<String> group(List<String> transactions){
		
		Map<String,Integer> map = new TreeMap<String,Integer>();
		List<String> oplist= new ArrayList<>();
		
		for(String str: transactions) {
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		for (Entry<String, Integer> string : map.entrySet()) {
			oplist.add(string.getKey()+" "+string.getValue());
		}
		
		return oplist;
	}

}
