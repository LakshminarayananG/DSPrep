package practice.old;

import java.util.Arrays;

import org.junit.Test;

public class MoveAllPostiveEnd {
	
	/*
	 * 1) Write a program to move all the positive numbers to end.
	 * 
	 * Input: [4, -1, 9, 0, 2, -4, 5] Output: [-1, 0, -4, 4, 9, 2, 5]
	 * 
	 * Algorithm: Use 2 Pointer
	 */

	@Test
	public void eg1() {
		int[] input= {4, -1, 9, 0, 2, -4, 5};
		System.out.println(Arrays.toString(arrange(input)));
	}
	
	//@Test
	public void eg2() {
		int[] input= {4, -1, 9, 0, 2, -4, 5};
		System.out.println(Arrays.toString(movepos(input)));
	}
	
	
	private int[] movepos(int[] input) {
		 int start=0,end=0;
		while(end<input.length) {
			if(input[end]<=0) {
				int temp=input[start];
				input[start]=input[end];
				input[end]=temp;
				start++;
				end++;
			}
			else {
				end++;
			}
		} 
		
		return input;
		}
	
	private int[] arrange(int[] array)
	{
		int[] output=new int[array.length];
		int i=0;int j=array.length-1;
		int negative=i;int positive=j;
		while(negative<=positive)
		{
			if(array[i]<=0)
			{
			output[negative]=array[i];
			negative++;
			}
			if(array[j]>0)
			{
			output[positive]=array[j];
			positive--;
			}
			j--;i++;
			
			
		}
		return output;
	}
	
	
}
