package practice.old;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;
import org.junit.Test;

public class SmallestMissingPositiveInt {
	
	@Test
	public void eg1()
	{
		int arr[]= {1,2,6,10,4,8};
		System.out.println(missingInt(arr));
	}
	
	@Test
	public void eg2()
	{
		int arr[]= {1,2,3,4,5,6};
		System.out.println(missingInt(arr));
	}
	
	
	public void eg3()
	{
		Integer[] arr= {1,2,3,4,5,8};
		System.out.println(missingInteger(arr));
	}
	
	private int missingInt(int[] input) {
		Arrays.sort(input);
		
		for (int i = 0; i < input.length-1; i++) {
			if(input[i+1]-input[i]>1) {
				return input[i]+1;
			}
		}
		
		throw new RuntimeException("No Missing values");
	}
	
	
	private int missingInteger(Integer[] input) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		Collections.addAll(set, input);
		
		for(int i=1; i<set.last();i++) {
			if(set.add(i)) {
				return i;
			}
		}
		
		throw new RuntimeException("No missing values");
		
	}
}
