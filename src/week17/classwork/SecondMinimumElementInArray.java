package week17.classwork;

import java.util.Arrays;
import org.junit.Test;

public class SecondMinimumElementInArray {
	
	/*
	 * Given an Integer array, find the second minimum element in the array
	 *  Array can have positive & negative integers.
	 */
	
	@Test
	public void dataSetOne()
	{
		int[] array= {1,4,5,0,-8};
		System.out.println(findSecondMin(array));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {1,4,5,0,-8,-8};
		System.out.println(findSecondMin(array));
	}
	

	@Test
	public void dataSetThree()
	{
		int[] array= {1,4,5,0,8,8};
		System.out.println(findSecondMin(array));
		System.out.println(secondmin(array));
		
	}
	
	//Bruteforce
	
	//Loop through the array twice
	//Find the minimum numbers by comparing against each other element
	//return the second minimum
	
	private int findSecondMin1(int[] array)
	{
		int temp=0;
		for(int i=0;i<2;i++)
		{
			for(int j=i;j<array.length;j++)
			{
				if(array[i]>array[j])
				{
				temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				}
			}
		}
		return array[1];
	}
	
	//Solution 2 
	//Using Arrays.sort
	private int findSecondMin2(int[] array)
	{
		Arrays.sort(array);
		return array[1];
	}
	
	//Solution 3
	
	//Declare two variables min and second Min
	
	//Loop through the length of array
	//Find min  comparing current element and min
	//Find second min by comparing second min and current element
	
	private int  findSecondMin(int[]array)
	{
		int min=Integer.MAX_VALUE,secondMin=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]<=min)
			{
				secondMin=min;
				min=array[i];
			}
			if(array[i]>min&&array[i]<=secondMin)
			{
				secondMin=array[i];
			}
		}
		return secondMin;
	}

	
	
	/*
	 * 1. Use a loop to iterate through the array
	 * 2. Declare min and 2nd min value with max values
	 * 3. Check if current index value is less than min, if so assign min to 2nd min and arr[i] to min
	 * 4. If input[i] is less than second min, 2nd min is input[i]
	 */
	
	private int secondmin(int[] input) {
		int min=Integer.MAX_VALUE;
		int secondmin=Integer.MAX_VALUE;
		
		for(int i=0;i<input.length;i++) {
			if(input[i]<min) {
				secondmin=min;
				min=input[i];
			}
			else if(input[i]<secondmin) secondmin=input[i];
		}
		
		return secondmin;
	}
	
	
	
	
}
