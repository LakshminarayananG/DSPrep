package week1;

import java.util.Arrays;
import org.junit.Test;

public class SmallestMissingPosInt {
	
	@Test
	public void example1() {
		int[] inputarray= {1,4,7,8,5,6};
		int findsmallestPosInt = findsmallestPosInt(inputarray);
		System.out.println(findsmallestPosInt);
	}
	
	@Test
	public void example2() {
		int[] inputarray= {0,-4,78,81,1,2};
		int findsmallestPosInt = findsmallestPosInt(inputarray);
		System.out.println(findsmallestPosInt);
	}
	
	
	
	@Test
	public void example3() {
		int[] inputarray= {0,0,0,0,0,0};
		int findsmallestPosInt = findsmallestPosInt(inputarray);
		System.out.println(findsmallestPosInt);
	}
	
	@Test
	public void example4() {
		int[] inputarray= {1,1,2,2,0,0};
		int findsmallestPosInt = findsmallestPosInt(inputarray);
		System.out.println(findsmallestPosInt);
	}
	
	
	private int findsmallestPosInt(int[] inputarray) {
		Arrays.sort(inputarray);
		for (int i = 0; i < inputarray.length; i++) {
			if(inputarray[i]>0) 
			if(inputarray[i]!=inputarray[i+1]&&inputarray[i+1]-inputarray[i]!=1) {
				return inputarray[i]+1;
			}
		}
		throw new RuntimeException("No Match");
	}

}
