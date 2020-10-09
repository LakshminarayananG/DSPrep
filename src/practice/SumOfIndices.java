package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class SumOfIndices {
	//Given an input array, return the 2 indices that match the specific sum
	@Test
	public void eg1() {
		int[] input = {1,3,4,7,10,12};
		int desiredsum = 14;
		System.out.println("One: "+Arrays.toString(targetSum(input, desiredsum)));
	}
	
	@Test
	public void eg2() {
		int[] input = {1,3,4,7,10,12};
		int desiredsum = 23;
		System.out.println("Two: " +Arrays.toString(targetSum(input, desiredsum)));
	}
	
	@Test
	public void eg3() {
		int[] input = {1,3,4,7,10,12};
		int desiredsum = 1;
		System.out.println("Three: " +Arrays.toString(targetSum(input, desiredsum)));
	}
	
	@Test
	public void eg4() {
		int[] input = {1,3,4,7,10,12};
		int desiredsum = 11;
		System.out.println("Four: "+Arrays.toString(targetSumMap(input, desiredsum)));
	}
	
		
	private int[] targetSum(int[] input, int desiredsum) {
		if(input[0]==desiredsum) {
			return new int[] {0,0};
		}
		
		for(int i=0;i<input.length;i++) {
			for (int j=i+1;j<input.length;j++) {
				if(input[i]+input[j]==desiredsum) {
					return new int[] {i,j};
				}
			}
		}
		
		throw new RuntimeException("No Matching indices found");
	}
	
	
	private int[] targetSumMap(int[] input, int desiredsum) {
		if(input[0]==desiredsum) {
			return new int[] {0,0};
		}
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		
		for(int i=0;i<input.length;i++) {
			if(map.containsKey(input[i])) {
				return new int[] {map.get(input[i]),i};
			}
			else {
				map.put(desiredsum-input[i], i);
			}
		}
		
		
		throw new RuntimeException("No Matching indices found");
	}
	
	
	//{1,3,4,7,10,12}; osum-14
	/*
	 * 14-1 ->13 key, value-->0 14-3> 11 k. val -1 10 -k, val -2 7 -k, val -3
	 * 
	 * if already available, take map value of that key and current index
	 */
	
	
	
}
