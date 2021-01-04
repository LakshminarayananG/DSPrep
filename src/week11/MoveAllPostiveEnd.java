package week11;

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
	
	//Pseudo code
	/*
	create 2 pointer p and n and both in same position
	if negative, swap elements in pth and nth position and increment both
	else increment n
	loop till n reaches end of the array
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
	
	
	private void movePositive(int[] arr) {
		int start=0,left=0;
		int end=arr.length-1,right=arr.length-1;
		int[] op=new int[arr.length];
		
		while(start<arr.length) {
			if(arr[start++]<1)
				op[left++]=arr[start-1];
			if(arr[end--]>0)
				op[right--]=arr[end+1];
		}
		System.out.println(Arrays.toString(op));
	}
	
	private void movePositive1(int[] arr) {
		int p = 0, n = 0;

		while (n < arr.length) {
			if (arr[n] <= 0) {
				int temp = arr[p];
				arr[p++] = arr[n];
				arr[n++] = temp;
			} else
				n++;
		}

		System.out.println(Arrays.toString(arr));
	}
	
	
	private int[] maintainOrder(int[] input) {
		int start=0,left=0;
		int end=input.length-1,right=input.length-1;
		int[] output = new int[input.length];

		while(start<input.length) {
			if(input[start++]<1)
				output[left++]=input[start-1];

			if(input[end--]>0)
				output[right--]=input[end+1];

		}
		return output;
	}
	
	
}
