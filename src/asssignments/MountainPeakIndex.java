package asssignments;

import org.junit.Test;

public class MountainPeakIndex {
	
	/*
	 * Considerations for test data. Only 1 peak was considered since it was
	 * mentioned in group that this is a single mountain peak
	 */
	
	@Test
	public void example1() {
		int[]numbers= {0,1,0};
		int peakElement = peakElement(numbers);
		System.out.println(peakElement);
	}
	
	
	@Test
	public void example2() {
		int[]numbers= {0,10,5,2};
		int peakElement = peakElement(numbers);
		System.out.println(peakElement);
	}
	

	@Test
	public void example3() {
		int[]numbers= {0,2,6,4};
		int peakElement = peakElement(numbers);
		System.out.println(peakElement);
	}
	
	@Test
	public void example4() {
		int[]numbers= {0,2,3,4,6,8,7,5,1};
		int peakElement = peakElement(numbers);
		System.out.println(peakElement);
	}
	
	@Test
	public void example5() {
		int[]numbers= {0,1,1,1,2,2,2,1,1};
		int peakElement = peakElement(numbers);
		System.out.println(peakElement);
	}
	
	//Brute Force Approach
	public int peakElement(int[] numbers) {
		int index=0;
		for(int i=1;i<=numbers.length-2;i++) {
			int previousval = numbers[i-1];
			int currentval=numbers[i];
			int nextval=numbers[i+1];
			if(currentval>previousval&&currentval>nextval) {
				index=i;
			}
		}
		
		if(index==0) {
			throw new RuntimeException("No Peak Element");
		}
		
		return index;
	}

}

