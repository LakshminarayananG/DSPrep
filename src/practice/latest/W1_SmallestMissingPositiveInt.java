package practice.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class W1_SmallestMissingPositiveInt {
	
	/*
	Given an unsorted integer array, find the smallest missing positive integer. // Simple 
	    [2,8,10,1,0, 2,1] => 3
	*/

	
	@Test
	public void ex1() {
		int[] arr = { 2, 8, 10, 1, 0, 2, 1 };
		int smallInt = smallMissPositiveInt(arr);
		System.out.println(smallInt);
	}

	@Test
	public void ex2() {
		int[] arr = { -3, -6, -9, -1, 0, 2 };
		int smallInt = smallMissPositiveInt(arr);
		System.out.println(smallInt);
	}

	@Test
	public void ex3() {
		int[] arr = { 6, 5, 2, 8, 10 };
		int smallInt = smallMissPositiveInt(arr);
		System.out.println(smallInt);
	}
	
	private int smallMissPositiveInt(int[] arr) {
		Set<Integer> set= new TreeSet<Integer>();
		
		for (Integer integer : arr) {
			set.add(integer);
		}
		
		List<Integer> list = new ArrayList<>(set);
		
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)-list.get(i-1)>1) return list.get(i-1)+1;
		}
		
		throw new RuntimeException("No Smallest Missing Positive Integer");
	}

	
	
}
