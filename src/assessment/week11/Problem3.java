package assessment.week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem3 {
	
	//Problem
	/*3) Given an input array and two unique numbers, find the smallest distance between those 2 numbers
Example:a

Input1: [5,6,8,9,1,4,1] Input2: 8,1 Output: 2
   a) If there are no occurances of the unique numbers, then throw exception
   b) If there are multiple matches, the least distance should be considered*/
	
	
	/*//Approach Using list contains 
	2. Iterate through the array
	3. check if the input element is part of the list / can be added to set
	4. if it is containing in list, get index and remove element from list
	5. Continue further and if other element is present, get difference in index & return the same
	6. if second element is not present, throw exception*/
	
	@Test
	public void eg1() throws Exception {
		int[] input1= {5,6,8,9,1,4,1};
		Integer[] input2= {8,4};
		System.out.println("Test case 1: "+distbetweenvalues(input1, input2));
	}
	
	@Test
	public void eg2() throws Exception {
		int[] input1= {5,6,8,9,1,4,1};
		Integer[] input2= {8,16};
		System.out.println("Test case 2: " +distbetweenvalues(input1, input2));
	}
	
	private int distbetweenvalues(int[] input1, Integer[] input2) throws Exception
	{
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(input2));
		int j = 0;
		for(int i=0;i<input1.length;i++) {
			if(list.contains(input1[i])&&list.size()>1) {
				j=i;
				list.remove(list.indexOf(input1[i]));
			}
			else if(list.contains(input1[i])) {
				return i-j;
			}
		}
		
		throw new Exception("Second unique value not found");
		
	}
	
	
	
	private int minDist(int[] arr, int x, int y) {
		int start = 0, end = 0;
		int dit = Integer.MAX_VALUE;

		for (end = 0; end < arr.length; end++) {
			if (arr[end] == x || arr[end] == y) {
				if (arr[end] != arr[start])
					dit = Math.min(dit, end - start);

				start = end;
			}
		}
		if (dit == Integer.MAX_VALUE)
			throw new RuntimeException("There is no occurance");

		return dit;
	}

	@Test
	public void example() {
		int[] arr = { 5, 6, 8, 9, 1, 4, 1 };
		int[] inp = { 8, 1 };
		// System.out.println(findMindistance(arr, inp));
	}

	private int findMindistance(int[] arr, int[] inp) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < inp.length; i++)
			list.add(inp[i]);
		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (list.contains(arr[i])) {
				int end = list.get(list.indexOf(arr[i]) == 0 ? 1 : 0);
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] == end)
						minDist = Math.min(minDist, j - i);
				}
			}
		}

		if (minDist < 0)
			throw new RuntimeException("No min distance found");

		return minDist;
	}
	
	

}
