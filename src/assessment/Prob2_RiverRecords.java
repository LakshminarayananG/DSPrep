package assessment;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Prob2_RiverRecords {

	/*
	 * Given an array of integers, without reordering, determine the maximum difference between any element 
	 * and any prior smaller difference. If there is never a lower prior element, return -1. 
	 * Example arr = [5, 3, 6, 7, 4] 
	 * There are no earlier elements than arr[0]. There is no earlier reading with a value lower than arr[1]. 
	 * There are two lower earlier readings with a value 
	 * lower than arr[2] = 6: arr[2] - arr[1] = 6 - 3 = 3 arr[2] - arr[0] = 6 - 5 = 1
	 * There are three lower earlier readings with a 
	 * lower value than arr[3] = 7:arr[3] - arr[2] = 7 - 6 = 1 arr[3] - arr[1] = 7 - 3 = 4 arr[3] - arr[0] = 7-5 = 2 
	 * There is one lower earlier reading with a 
	 * lower value than arr[4] = 4:arr[4] - arr[1] = 4 - 3 = 1 The maximum trailing record is arr[3] - arr[1] =4. 
	 * Example arr = [4, 3, 2, 1] No item in arr has a lower earlier reading,
	 * therefore return -1 
	 * Function Description Complete the function
	 * maximumTrailing in the editor below. maximumTrailing has the following
	 * parameter(s): int arr[n]: an array of integers Question - 2 River Records
	 * Returns: int: the maximum trailing difference, or -1 if no element in arr has
	 * a lower earlier value Constraints 1 ≤ n ≤ 2 × 10 −10 ≤ arr[i] ≤ 10 and 0 ≤ i
	 * < n
	 */
	
	

	@Test
	public void eg1() {
		
		int[] input = { 4, 5, 6, 11, 1, 2, 10 };
		System.out.println("One " + river1(input));
	}
	


	@Test
	public void eg2() {
		Integer[] input = { 4, 3, 2, 1 };
		System.out.println("Two: " + river2(input));

	}

	@Test
	public void eg3() {
		Integer[] input = {2, 4, 5, 6, 11, 1, 2, 10 };
		System.out.println("Three : " + river2(input));
	}
	
	@Test
	public void eg4() {
		Integer[] input = {4, 5, 6, 11,2,10,1,6 };
		System.out.println("Four : " + river2(input));
	}

	private int river1(int[] input) {
		int maxdiff = -1;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] > input[i]) {
					maxdiff = Math.max(input[j] - input[i], maxdiff);
				}
			}
		}

		return maxdiff;
	}

	private int river2(Integer[] input) {
		List<Integer> list = Arrays.asList(input);
		int val = Collections.max(list);
		int maxpointer = list.indexOf(val);
		int maxdiff = -1;
		
		for (int i = 0; i < maxpointer; i++) {
			maxdiff = Math.max(val - list.get(i), maxdiff);
		}
		
		for(int i=maxpointer+1;i<input.length;i++) {
			if(list.get(i)>list.get(i-1)) {
			maxdiff=Math.max(list.get(i)-list.get(i-1), maxdiff);
			}
		}
		return maxdiff;
		}
	
	
	

}
