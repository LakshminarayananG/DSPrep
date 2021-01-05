package week16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class DuplicateNumber {

	/*
	* Integer array, with only +ve no's. Only 1 number that is duplicate.
	* Find the only duplicate number.
	*
	*/

	/*
	* 1. Iterate through the array and add the numbers to set
	* 2. If unable to add to set, return the number
	*/

	/*
	* 1. Iterate through the array and add numbers to list
	* 2. If list already contains input, return the number
	*/


	/*
	* Alternate approach
	* 1. Sort the given input using collections.sort
	* 2. Declare 2 variables low & high (Low-0, high len-1)
	* 3. Iterate until low< high
	* 4. for every iteration, declare mid--> (low+high)/2
	* 5. check if array[mid] != mid+1 or array[mid] != mid-1, return mid value
	* 6. if mid & mid -1 are equal and (mid index - low)%2!=0, value is in left, high->mid-1
	* 7. if mid& mid+1 are equal & high-mid %2!=0, value in right, low->mid+1
	*/

	public void eg1() {
	int[] input= {1,2,3,3,4,5};

	}

	@Test
	public void eg2() {
	int[] input= {2,3,5,7,7,4};
	System.out.println(dupnum2ptr(input));
	}

	private int dupnum(int[] input) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (!set.add(input[i]))
				return input[i];
		}
		throw new RuntimeException("No Dups");
	}
	
	private int dupsnum(int[] input) {
		Arrays.sort(input);
		for(int i=1;i<input.length;i++) {
			if(input[i]==input[i-1]) return input[i];
		}
		
		throw new RuntimeException("No Duplicates");
	}


	private int dupnum2ptr(int[] input) {
		int start = 0, end = input.length - 1;

		while (start < end) {
			if (input[start] == input[end] || (input[start + 1] == input[start]))
				return input[start];
			else if (input[end] == input[end - 1])
				return input[end];
			else {
				start++;
				end--;
			}
		}
		throw new RuntimeException("No Dups");

	}
	
}
