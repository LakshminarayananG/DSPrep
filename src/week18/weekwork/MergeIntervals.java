package week18.weekwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MergeIntervals {
	
	/*
	 * Given an array of intervals where intervals[i] = [starti, endi], merge all
	 * overlapping intervals, and return an array of the non-overlapping intervals
	 * that cover all the intervals in the input.
	 * 
	 * 
	 * 
	 * Example 1: 
	 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] 
	 * Output:
	 * [[1,6],[8,10],[15,18]] 
	 * Explanation: Since intervals [1,3] and [2,6] overlaps,
	 * merge them into [1,6]. 
	 * 
	 * Example 2: 
	 * Input: intervals = [[1,4],[4,5]] 
	 * Output: [[1,5]] 
	 * Explanation: Intervals [1,4]
	 * and [4,5] are considered overlapping.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <=
	 * 104
	 */
	
	/*
	 * Similar to truck size problem
	 * 1. Sort the given array 
	 * 2. Declare previous interval as arr[0]
	 * 3. Iterate from 1 to n-1
	 * 4. Check if the previous interval[1] > current interval[0], if so these 2 intervals overlap
	 * 5. If condition satisfies, assign current interval[0] to previous interval [0] and current interval [1]
	 *    to maximum of prev & curr [1]
	 * 6. Assign current interval to previous interval and add previous interval finally
	 * 7. return the output 
	 */
	
	
	

	@Test
	public void eg1() {
		int[][] intervals= {{1,4},{0,4}};
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}
	
	@Test
	public void eg2() {
		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
	}
	
	
	private int[][] mergeIntervals(int[][] intervals){
		if(intervals.length==1) return intervals;
		
		Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
		List<int[]> output= new ArrayList<>();
		int[] previousinterval= intervals[0];
		for(int i=1;i<intervals.length;i++) {
			int[] currentinterval=intervals[i];
			if(previousinterval[1]>=currentinterval[0]) {
				currentinterval[0]=previousinterval[0];
				currentinterval[1]=Math.max(previousinterval[1], currentinterval[1]);				
			}
			else {
				output.add(previousinterval);
			}
			previousinterval=currentinterval;				
		}
		output.add(previousinterval);
		
		return output.toArray(new int[output.size()][]);
	}
	
	
	
	
	
}