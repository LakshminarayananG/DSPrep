package week19.weekwork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FW_ProductOfTwoNumbers {
	
	
	/*1) Given list of integers, find 2 numbers which matches the productwithout using map*/
	
	@Test
	public void eg1() {
		int[] input= {1,4,6,8,2,3,4,5};
		int target=16;
		System.out.println(Arrays.toString(retprodIndices(input, target)));
	}
	
	
	@Test
	public void eg2() {
		int[] input= {1,2};
		int target=2;
		System.out.println(Arrays.toString(retprodIndices(input, target)));
	}
	
	
	/* Using Set
	 * 1. Iterate from 0 to n-1
	 * 2. Check if index value is 0, if so continue to next element (to avoid divide by 0 exception)
	 * 3. Add index value to set and check if set contains target / index value, if present return both the 
	 *    values
	 * 
	 */
	
	private int[] retprodIndices(int[] input, int target) {
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < input.length; i++) {
			if(input[i]==0) continue;
			else if(set.contains(target/input[i]) && target%input[i]==0) {
				return new int[] {target/input[i],input[i]};
			}
			else if(target%input[i]==0){
				set.add(input[i]);
			}
		}
		throw new RuntimeException("No Matching Numbers");
	}

}
