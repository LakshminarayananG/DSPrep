package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class TargetSum {
	
	
	  @Test public void example1() { int[] numbers= {1,2,4,5,3,8,10,1,5};
		int target=16;
	 // findTargetHashing(numbers, target);
	 System.out.println(Arrays.toString(findtargetSum(numbers,target)));
	  
	  }
	 
	
	@Test
	public void example2() {
		int[] numbers= {5,7,8,4,2};
		int target=12;
		 findTargetHashing(numbers, target);
		//System.out.println(Arrays.toString(findtargetSum));
		
	}
	
	private int[] findtargetSum(int[] numbers,int target) {
		for(int i=0;i<numbers.length;i++) {
			int targetsum=numbers[i];
			if(numbers[i]==target) {
				return new int[] {i,i};
			}
		for(int j=i+1;j<numbers.length;j++) {
				targetsum+=numbers[j];
				if (targetsum>target) {
					break;
				}
				if(target==targetsum) {
				return new int[] {i,j};
				}
			}
			
		}
		throw new RuntimeException("No matching values found");
	}
	
	
	private void findTargetHashing(int[] numbers, int target) {
		Map<Integer,Integer> map= new HashMap<Integer,Integer>();
		
		//Initialize the first value with negative number
		map.put(0,-1);
		
		//What is the sum so far?		
		int sum_sofar=0;
		
		for(int i=0;i<numbers.length;i++) {
			sum_sofar+=numbers[i];
			int diff= sum_sofar-target;
			if(map.containsKey(diff)) {
				System.out.println("Found the sub array :{"+(map.get(diff)+1)+","+i+"}");
			}
			map.put(sum_sofar, i);
		}
		
	}
	

}
