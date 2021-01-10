package week12.classwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class FindUniqueCombinations {
	
	/*
	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	The same repeated number may be chosen from C unlimited number of times.
	Example,
	Given candidate set 2,3,6,7,1 and target 7,
	A solution set is:
	[2, 2, 3]
	[3,3,1]
	[2,2,2,1]
	[7]
	*/
	
	/*
	 * Leetcode Problem 39
	 * https://leetcode.com/problems/combination-sum/
	 */

	//Pseudo code
	/*
	Add all the elements in a list
	iterate through each element, and add same element multiple times until we reach target or greater than target
	parallely check if the target-sum is available in the list and add it an array accordingly
	if sum is equal to target, create an array with the number of occurance and print out the array
	if sum is greater than target, subtract the value one time with the element and decrement the count to 1
	check if target-sum is available in the list
	if yes, create an array with the number of occurance of the element and add elements both the element and target-sum and print the array
	*/
	
	@Test
	public void example1() {
		int[] arr = { 2, 3, 6, 7, 1 };
		int k = 7;
		System.out.println(uniqueCombo(arr, k));
	}
	
	@Test
	public void example2() {
		int[] arr = { 2, 3, 6, 7 };
		int k = 7;
		System.out.println(uniqueCombo(arr, k));
	}

	private List<List<Integer>> uniqueCombo(int[] arr, int k) {
		List<List<Integer>> output = new ArrayList<>();
		int sum = 0;
		// findCombo(arr, k, output, new ArrayList<>(), sum, 0);
		findCombo(arr, k, output, new ArrayList<>(), 0);
		return output;
	}

	private void findCombo(int[] arr, int k, List<List<Integer>> output, List<Integer> combo, int start) {
		if (k <= 0) {
			if (k == 0)
				output.add(new ArrayList<>(combo));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			combo.add(arr[i]);
			findCombo(arr, k - arr[i], output, combo, i);
			combo.remove(combo.size() - 1);
		}

	}

	private void findCombo1(int[] arr, int k, List<List<Integer>> output, List<Integer> combo, int sum, int start) {
		if (sum == k) {
			output.add(new ArrayList<>(combo));
			return;
		}

		if (sum > k)
			return;

		for (int i = start; i < arr.length; i++) {
			combo.add(arr[i]);
			//findCombo(arr, k, output, combo, sum + arr[i], i);
			combo.remove(combo.size() - 1);
		}

	}
	
	
	private void findcombination(int[] array,int n,int start,List<List<Integer>> output,List<Integer> current)
	{
		if(n==0)
		{
			List<Integer> temp=new ArrayList<>(current);
			Collections.sort(temp);
			if(!output.contains(temp))
			output.add(temp);
			return;
		}
		if(n<0)
		{
			return;
		}

		for(int i=start; i<array.length;i++)
		{
			current.add(array[i]);
			findcombination(array,n-array[i],start,output,current);
			current.remove(current.size()-1);
			
		}
	}


	private void findcombination1(int[] array,int n,int start,List<List<Integer>> output,List<Integer> current)
	{
		if(n==0)
		{
			List<Integer> temp=new ArrayList<>(current);
				/*
				 * Collections.sort(temp); if(!output.contains(temp)) output.add(temp);
				 */
			return;
		}
		if(n<0)
		{
			return;
		}

		for(int i=start; i<array.length;i++)
		{
			current.add(array[i]);
			findcombination(array,n-array[i],i,output,current);
			current.remove(current.size()-1);
			
		}
	}

}
