package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

import org.junit.Test;

public class MissingNumbers {
	
	
	@Test
	public void example1() {
		Integer[] numbers= {4,3,2,7,8,2,3};
		ArrayList<Integer> findMissing = findMissing(numbers);
		System.out.println(findMissing);
	}
	
	@Test
	public void example2() {
		Integer[] numbers= {1,1,1,1,1,1,1};
		ArrayList<Integer> findMissing = findMissing(numbers);
		System.out.println(findMissing);
	}
	
	@Test
	public void example3() {
		Integer[] numbers= {-1,1,1,1,1,1,10};
		ArrayList<Integer> findMissing = findMissing(numbers);
		System.out.println(findMissing);
	}
	
	
	@Test
	public void example4() {
		Integer[] numbers= {-1,1,1,1,1,1,-10};
		ArrayList<Integer> findMissing = findMissing(numbers);
		System.out.println(findMissing);
	}
	
	@Test
	public void example5() {
		Integer[] numbers= {-1,1,1,1,1,1,-10};
		ArrayList<Integer> findMissing = findMissingnum(numbers);
		System.out.println(findMissing);
	}
	
	
	
	private ArrayList<Integer> findMissing(Integer[] array)
	{
		ArrayList<Integer> missinnum= new ArrayList<Integer>();
		TreeSet<Integer> inputSet=new TreeSet<Integer>();
		Collections.addAll(inputSet, array);
		for(int i=inputSet.first();i<inputSet.last();i++)
		{
			if(inputSet.add(i))
			{
				missinnum.add(i);
			}
		}
		
		return missinnum;
		
	}
	
	
	private ArrayList<Integer> findMissingnum(Integer[] array)
	{
		ArrayList<Integer> missinnum= new ArrayList<Integer>();
		Arrays.sort(array);
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==array[i+1]) {
				continue;
			}
			if(array[i+1]-array[i]!=1) {
				missinnum.add(array[i]+1);
			}
		}
		
		return missinnum;
		
	}

}
