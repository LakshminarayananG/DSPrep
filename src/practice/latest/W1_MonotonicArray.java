package practice.latest;

import org.junit.Test;


public class W1_MonotonicArray {
	
	/*
	 * Given an array, return true if and only if the given array A is monotonic An
	 * array is monotonic if it is either monotone increasing or monotone
	 * decreasing.
	 * 
	 * Input: [1,2,3,3,4,4,4,4,5] Output: true
	 * 
	 * Input: [1,2,5,3,4,4,4,4,5] Output: false
	 * 
	 * Input: [5,4,4,2,1] Output: true
	 */
	
	@Test
	public void eg1() {
		int[] input = { 1, 2, 3, 3, 4, 4, 4, 4, 5 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg2() {
		int[] input = { 1, 2, 5, 3, 4, 4, 4, 4, 5 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg3() {
		int[] input = { 5, 4, 4, 2, 1 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg4() {
		int[] input = { 5 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg5() {
		int[] input = { 7, 7, 7 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg6() {
		int[] input = { -7, -3, 0, 5, 7, 11 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg7() {
		int[] input = { 8, 5, 3, 1, 0, -6, -5, -4 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg8() {
		int[] input = { 8, 5, 3, 1, 0, -2, -7, -10 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg9() {
		int[] input = { -9, -9, -6, -3, -3, -2, -1, 0 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	@Test
	public void eg10() {
		int[] input = { -2, -2, -2, -3, -5, -6, -7, -8, -8, -9, -9, -9, -9 };
		System.out.println(isMonotone(input));
		System.out.println(monotonic(input));
	}
	
	
	private boolean isMonotone(int[] A) {
		boolean flag=false;
		
		if(A.length==1) return false;
		
		if(A[1]>A[0]) {
			for(int i=1;i<A.length;i++) {
				if(A[i]>=A[i-1]) {
					flag=true;
				}
				else
					return false;
			}
		}
		
		else if(A[0]>A[1]) {
			for(int i=1;i<A.length;i++) {
				if(A[i]<=A[i-1]) flag=true;
				else return false;
			}
		}
		
		return flag;
	}
	
	
	
	/*
	 * 1. Check if the array [0] is less than array [len-1], if so array is increasing (assumption)
	 * 2. Based on condition 1, set increasing flag to true
	 * 3. Iterate through the array
	 * 4. Check if the current element is greater than next element and flag is true, 
	 */
	
	private boolean monotonic(int[] A) {
		boolean isIncreasing = A[0] < A[A.length-1];
        for(int i =0; i<A.length-1;i++){
            if(isIncreasing  && A[i] > A[i+1]){
                return false;
        }else if(!isIncreasing && A[i] < A[i+1]) {
                return false;
        }
  
    }
        return true;
	}	

}
