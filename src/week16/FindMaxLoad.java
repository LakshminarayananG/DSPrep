package week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FindMaxLoad {
	
	/*
	mobileTypes=[type of mobile,number of mobile]
	Input: mobileTypes = [[1,3],[2,2],[3,1]], truckSize = 4 mobileSizes
	Output: 8
	1*3=3 (4-1=3)
	2*2=4 (3-2=1)
	1*1=1 (1-1=0)
	Output: 3+4+1=8
	int[][] mobileTypes, int truckSize
	int -> maxNumberOfMobiles
	*/
	
	@Test
	public void example1() {
		Integer[][] mobileTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		int truckSize = 4;
		System.out.println(CalculateMaxMobileNum(mobileTypes, truckSize));
	}

	@Test
	public void example2() {
		Integer[][] mobileTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 }, { 4, 5 } };
		int truckSize = 4;
		System.out.println(CalculateMaxMobileNum(mobileTypes, truckSize));
	}
	
	@Test
	public void example3() {
		Integer[][] mobileTypes = { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } };
		int truckSize = 10;
		System.out.println(CalculateMaxMobileNum(mobileTypes, truckSize));
	}
	
	@Test
	public void example4() {
		int[][] mobileTypes = { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } };
		int truckSize = 10;
		System.out.println(findMax(mobileTypes, truckSize));
	}
	
	/*
	 * Pseudo code:
	 * 1. Convert the array to list of lists
	 * 2. From the list of lists, get the values and store in a list
	 * 3. Sort the list values
	 * 4. Get last element from the list and iterate through the input list and if list[1] matches the value,
	 *    check if trucksize > list[0], if so reduce trucksize-list[0] and multiply list[1] * list[0]. remove
	 *    list[0] and list[1] and also the last element from the list.
	 * 5. if trucksize<list[0], multiply list[1]* trucksize and make truck size=0. remove list[0] and list[1] 
	 *    and also the last element from the list.
	 * 6. Add to max & do so until truck size becomes zero and break, return max value
	 */
	
	private int CalculateMaxMobileNum(Integer[][] mobileTypes, int truckSize) {
		List<List<Integer>> lists = new ArrayList<>();
		for(Integer[] ints: mobileTypes) {
			lists.add(Arrays.asList(ints));
		}
		
		List<Integer> count = new ArrayList<Integer>();
		
		for(List<Integer> integer: lists) {
			count.add(integer.get(1));
		}
		
		Collections.sort(count);
		int max=0;
		
		while(truckSize>0) {
			int val= count.get(count.size()-1);
			for (List<Integer> integer : lists) {
				if(integer.get(1)==val) {
					int tmp=integer.get(0);
					if(truckSize>tmp) {
						truckSize-=tmp;
						max+=tmp*integer.get(1);
						lists.remove(integer);
						count.remove(count.size()-1);
						break;
					}
					else {
						max+=truckSize*integer.get(1);
						truckSize=0;
						lists.remove(integer);
						count.remove(count.size()-1);
						break;
					}
				}
				
			}
		}
		
		return max;
	}
	
	
	/*
	 * Alternate Approach - Simpler one
	 * 1. Using Arrays.sort, sort the given input array based on values
	 * 2. Iterate through it and multiply the number of possible combinations
	 * 3. Reduce the truck size and when trucksize ==0, break the loop and return max value
	 * 
	 */
	
	private int findMax(int[][] mobile,int truck) {
		//Sort the given 2D Array by second index
		Arrays.sort(mobile,(a,b) -> b[1] - a[1]);
		int count=0;
		
		for (int[] is : mobile) {
			int mobiletypecount=Math.min(truck, is[0]);
			count+=mobiletypecount*is[1];
			truck-=mobiletypecount;
			if(truck==0) break;
		}
		
		return count;
	}

}
