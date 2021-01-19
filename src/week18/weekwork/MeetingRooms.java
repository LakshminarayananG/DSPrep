package week18.weekwork;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class MeetingRooms {

	// 253 Meeting Rooms II
	/*
	 * Given an array of meeting time intervals consisting of start and end
	 * times[[s1,e1],[s2,e2],...](si< ei), 
	 * find the minimum number of conference
	 * rooms required. 
	 * 
	 * Example 1: 
	 * Input: [[0, 30],[5, 10],[15, 20]] 
	 * Output: 2
	 * Explanation: We need two meeting rooms room1: (0,30) room2: (5,10),(15,20)
	 * 
	 * Example 2: 
	 * Input: [[7,10],[2,4]] 
	 * Output:1 
	 * 
	 * Example 3: Input: intervals =
	 * [(2,7)] Output: 1 Explanation: Only need one meeting room
	 */
	
	
	
	/* Similar to merge intervals problem
	 * 1. SOrt the given array
	 * 2. Iterate from 1 to n-1
	 * 3. Check if there is overlap, if there are any, Increment number of meeting rooms
	 * 
	 */
	
	@Test
	public void eg1() {
		int[][] intervals= {{0,30},{5,10},{15,20}};
		System.out.println(meetingrooms(intervals));
		System.out.println(meetingroomaltapp(intervals));
		
	}
	
	@Test
	public void eg2() {
		int[][] intervals= {{7,10},{2,4}};
		System.out.println(meetingrooms(intervals));
		System.out.println(meetingroomaltapp(intervals));
	}
	
	@Test
	public void eg3() {
		int[][] intervals= {{2,7}};
		System.out.println(meetingrooms(intervals));
		System.out.println(meetingroomaltapp(intervals));
	}
	
	
	private int meetingrooms(int[][] intervals) {
		if(intervals.length==1) return 1;
		int meetingrooms=1;
		Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
		int[] previnterval= intervals[0];
		for(int i=1;i<intervals.length;i++) {
			int[] currentinterval=intervals[i];
			if(previnterval[1]>currentinterval[0]) {
				meetingrooms++;			
			}
			
			previnterval=currentinterval;
		}
		
		return meetingrooms;
	}
	
	
	private int meetingroomaltapp(int[][] intervals) {
		if(intervals.length==1) return 1;
		Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
		
		PriorityQueue<int[]> pq= new PriorityQueue<int[]> ((a,b)-> a[1]-b[1]);
		pq.add(intervals[0]);
		
		for(int i=1;i<intervals.length;i++) {
			int[] curr= intervals[i];
			int[] prev = pq.poll();
			
			if(curr[0]<prev[1]) {
				pq.add(prev);
				pq.add(curr);
			}
			else {
				prev[1]=curr[1];
				pq.add(prev);
			}
			
		}
		
		return pq.size();
	}

}