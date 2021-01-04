package week13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ShortestFormOfArrayRank {
	
	/*
	 * Shortest form of array with rank
	 * 
	 * Sample input#1:
	 * 
	 * input : [10,2,1,4,10,2,5,13,5]
	 * 
	 * output : 1) you should get all the duplicates form of array first
	 * [10,2,1,4,10] [2,1,4,10,2] [5,13,5]
	 * 
	 * 2) then you should cut down to [5,13,5] (here all have same repetitions in
	 * the array thats why we are going with less count)
	 * 
	 * 3) final output should be: [5,13,5] with rank 2 (rank is repeation of digits
	 * in the shortest array)
	 * 
	 * Sample input #2:
	 * 
	 * input : [2,1,2,3,5,3,3]
	 * 
	 * here output should be [3,5,3,3] with rank 3
	 * 
	 * the most preference is rank than array size.
	 */
	
	@Test
	public void dataSetOne()
	{
		int[] array= {10,2,1,4,10,2,5,13,5};
		System.out.println(Arrays.toString(rankArray(array)));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {2,1,2,3,5,3,3};
		System.out.println(findArrayRank(array));
	}
	
	private int[]  rankArray(int[] input)
	{
		Map<Integer,List<Integer>> refMap=new HashMap<>();
		int start=0; int end=0;
		int maxRank=0;int minSize=input.length;int temp=0;
		for(int i=0;i<input.length;i++)
		{
			refMap.computeIfAbsent(input[i], k -> new ArrayList<>()).add(i);
			//maxRank=Math.max(refMap.get(input[i]).size(),maxRank);
			temp=refMap.get(input[i]).size();
			if(temp>1&&temp>=maxRank)
			{
				
				if(refMap.get(input[i]).get(temp-1)-refMap.get(input[i]).get(0)<=minSize||temp>=maxRank)
				{
					minSize=refMap.get(input[i]).get(temp-1)-refMap.get(input[i]).get(0);
					start=refMap.get(input[i]).get(0);
					end=refMap.get(input[i]).get(temp-1);
				}
				maxRank=temp;
			}
		}
		return Arrays.copyOfRange(input, start, end+1);
	}
	
	
	// Space complexity: O[N]
		// Time complexity: O[N]
		private int findArrayRank(int[] arr) {
			int rank = 0;

			if (arr.length < 1)
				return rank;

			Map<Integer, int[]> map = new LinkedHashMap<>(); // Storing element as key and int array having start index,
			// end index and occurrence as value

			for (int curr = 0; curr < arr.length; curr++) {
				if (map.containsKey(arr[curr])) { // Checking if the element is already present in the Map
					int[] js = map.get(arr[curr]); // get array having previous index and count
					js[1] = curr; // update end index to current index
					js[2]++; // increment the occurrence
					map.put(arr[curr], js); // update the map
				} else {
					map.put(arr[curr], new int[] { curr, curr, 1 }); // if element is not present,
					// add it map with both start and end index as current index and occurrence as 1
				}
			}

			int minLen = Integer.MAX_VALUE;
			int maxOcc = 0;
			int[] copy = null;
			for (Map.Entry<Integer, int[]> m : map.entrySet()) { // iterate through each key in the map
				int[] val = m.getValue();
				if (val[2] > 1) { // if occurrence is greater than one then it is a duplicate
					if (val[2] > maxOcc) { // if the sub array has max number of duplicates, then
						maxOcc = val[2]; // assign new max
						copy = Arrays.copyOfRange(arr, val[0], val[1] + 1); // get copy of the array
						rank = val[2]; // and its rank i.e. max occurrence
					} else if (val[2] == maxOcc && (val[1] - val[0]) + 1 <= minLen) {
						// if occurrence equals max occurrence and also less than or equal to previous
						// minimum array length, then consider this sub array
						minLen = val[1] - val[0] + 1;
						copy = Arrays.copyOfRange(arr, val[0], val[1] + 1);
						rank = val[2];
					}

				}
			}
			System.out.println(Arrays.toString(copy));
			return rank; // finally return the rank of the minimum subarray

			// map.forEach((k,v)->{System.out.println(k+" - "+Arrays.toString(v));});
		}

}
