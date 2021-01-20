package week19.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;

public class ClosestNumber {
	
	/*
	 * Find the closest number for each element in array
	 * 
	 * Input: [2,1,5,8,3]
	 * Output: [-1,2,2,5,2]
	 * 
	 * Explanation:
	 * [2] is the only number in this prefix. Hence ans is -1
	 * [2,1], the closest number in this prefix is 2
	 * [2,1,5] closest number in this prefix is 5
	 * [2,1,5,8] closest number to 8 in this prefix is 5
	 * [2,1,5,8,3] closest number to 3 in this prefix is 2 
	 */
	
	@Test
	public void eg1() {
		int[] input= {2,1,5,8,3};
		System.out.println(Arrays.toString(closestnum(input)));
		System.out.println(Arrays.toString(closestnumber(input)));
	}
	
	@Test
	public void eg2() {
		int[] input= {2,1,5,8,3,4,7,1};
		System.out.println(Arrays.toString(closestnum(input)));
		System.out.println(Arrays.toString(closestnumber(input)));
	}
	
	
	
	/*
	 * Brute Force Approach
	 * 1. Use 2 for loops, outer loop to iterate from 1 to n-1 and inner loop from 0 to outer loop val
	 * 2. For each iteration of inner loop, check the abs diff b/w current outer index element and inner index
	 *    element. Assign the value with minimum differene
	 * 3. return the list / array
	 */
		
	private int[] closestnum(int [] input) {
		int[] output= new int[input.length];
		output[0]=-1;
		output[1]=input[0];
		for(int i=2;i<input.length;i++) {
			int mindiff=Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				int val=Math.abs(input[i]-input[j]);
				if(val<=mindiff && val >0) {
					mindiff=val;
					output[i]=input[j];
				}
			}
		}
		return output;
	}
	
	
	
	
	/* Alternate Approach
	 * 1. Iterate from index 2 to n-1
	 * 2. Add each element to set and then to list
	 * 3. Check the index of added element, depending on which calculate the closest element and assign the 
	 *    same to output array
	 */
	
	
	private int[] closestnumber(int[] input) {
		int[] output= new int[input.length];
		output[0]=-1;
		output[1]=input[0];
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(input[0]);
		set.add(input[1]);
		for(int i=2;i<input.length;i++) {
			set.add(input[i]);
			ArrayList<Integer> list = new ArrayList<Integer>(set);
			int index=list.indexOf(input[i]);
			if(index==list.size()-1) output[i]=list.get(index-1);
			else if(index<list.size()-1 && index >0) {
				int leftdiff= Math.abs(input[i]- list.get(index-1));
				int rightdiff= Math.abs(input[i]-list.get(index+1));
				if(leftdiff<=rightdiff) output[i]=list.get(index-1);
				else output[i]=list.get(index+1);
			}
			else output[i]=list.get(index+1);
		}
		return output;
	}
	
	
	
	//Red-Black Tree implementation
		private void findEachClosestNumbers(int[] arr) {
			TreeSet<Integer> set = new TreeSet<>();
			int up, down;
			//O[N log N]
			for (int i = 0; i < arr.length; i++) {
				set.remove(arr[i]);	//O[log N]
				try {
					up = set.ceiling(arr[i]);	//O[log N] 
				} catch (Exception e) {
					up = -1;
				}
				try {
					down = set.floor(arr[i]);	//O[log N]
				} catch (Exception e) {
					down = -1;
				}

				if (up == arr[i])
					up = -1;
				if (down == arr[i])
					down = -1;

				set.add(arr[i]);

				if (up == -1 && down == -1)
					arr[i] = -1;
				else if ((up == -1 && down != -1) || arr[i] - down < up - arr[i])
					arr[i] = down;
				else if ((down == -1 && up != -1) || arr[i] - down > up - arr[i])
					arr[i] = up;
				else
					arr[i] = Math.min(up, down);
			}

			System.out.println(Arrays.toString(arr));
		}
	
	

}