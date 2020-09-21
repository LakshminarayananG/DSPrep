package dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

public class LuckyInteger {
	
	@Test
	public void example1() {
		int[] numbers= {2,3,4,4,4,5,5,6};
		int findLuckyNum = findLuckyNum(numbers);
		System.out.println(findLuckyNum);
	}
	
	
	@Test
	public void example2() {
		int[] numbers= {2,3,4,4,4,5,5,5,5,5,6,7,7,7,7,7,7};
		int findLuckyNum = findLuckyNumOther(numbers);
		System.out.println(findLuckyNum);
	}
	
	@Test
	public void example3() {
		int[] numbers= {2,3,4,4,4,5,5,6,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8};
		int findLuckyNum = findLuckyNumOther(numbers);
		System.out.println(findLuckyNum);
	}
	
	
	private int findLuckyNum(int[] numbers) {
		Map<Integer,Integer> num = new HashMap<Integer,Integer>();
		int temp=-1;
		for (int i = 0; i < numbers.length; i++) {
			if(num.containsKey(numbers[i])) {
				num.put(numbers[i], num.get(numbers[i])+1);
			}
			else {
				num.put(numbers[i], 1);
			}
		}
		
		for (Entry<Integer, Integer> i : num.entrySet()) {
			if(i.getKey().equals(i.getValue())&&i.getValue()>temp) {
				temp=i.getValue();
			}
		}
		return temp;
	}
	
	
	//Solution 2 --> Optimizing the if else used when adding to the map
	private int findLuckyNumOther(int[] numbers) {
		Map<Integer,Integer> num = new HashMap<Integer,Integer>(); //O[1]
		int temp=-1;
		for (int i = 0; i < numbers.length; i++) {  //O[N]
			num.put(numbers[i], num.getOrDefault(numbers[i],0)+1);
		}
		
		for (Entry<Integer, Integer> i : num.entrySet()) { //O[N]
			if(i.getKey().equals(i.getValue())&&i.getValue()>temp) {
				temp=i.getValue();
			}
		}
		return temp;
		
	}
	

}
