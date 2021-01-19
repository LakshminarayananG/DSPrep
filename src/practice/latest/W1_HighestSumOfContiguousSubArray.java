package practice.latest;

import org.junit.Test;

public class W1_HighestSumOfContiguousSubArray {
	
	/*
	 * Given an integer array and number n, return the highest sum of contiguous subarray of size n
	 * Input: [1, 4, 7, 1, 1, 5, 2 ] Number: 5
	 * Output: 14 [Sub array of 1,4,7,1,1 is having the highest sum of 14
	 */
	
	
	@Test
	public void example1() {
		int[] inputarray = { 1, 1, 1, 1, 1, 90, 25 };
		int num = 1;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg1 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg1 :"+highsumsliding);
	}

	@Test
	public void example2() {
		int[] inputarray = { 1, 4, 7, 1, 1, 5, 2 };
		int num = 5;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg2 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg2 :"+highsumsliding);
	}

	@Test
	public void example3() {
		int[] inputarray = { 1, 1, 1, 1, 1, 1, 1 };
		int num = 3;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg3 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg3 :"+highsumsliding);
	}

	@Test
	public void example5() {
		int[] inputarray = { 12,24,48,64,100,1,1,1,2 };;
		int num = 4;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Example 5 is "+ highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg5 :"+highsumsliding);
	}

	
	@Test
	public void example4() {
		int[] inputarray = { 280, 1, 0, -111, 1, 90, 25, 38, 27 };
		int num = 4;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg4 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg4 :"+highsumsliding);
	}

	@Test
	public void example6() {
		int[] inputarray = { -169, 0, 0, 530, 0, 0, 0, 0, 3, 0, 2, 90, 25, 38, 25 };
		int num = 14;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg6 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg6 :"+highsumsliding);
	}

	@Test
	public void example7() {
		int[] inputarray = { -280, -1, 0, -111, -1, -90, -25, -38, -27 };
		int num = 3;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg7 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg7 :"+highsumsliding);
	}
	 
	
	
	@Test
	public void example8() {
		int[] inputarray = { 12,24,48,64,100,1,1,1,2 };
		int num = 4;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg8 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg8 :"+highsumsliding);
	}
	
	
	@Test
	public void example9() {
		int[] inputarray = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int num = 3;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Eg9 :"+highestSum);
		int highsumsliding=highestSumSliding(inputarray, num);
		System.out.println("Eg9 :"+highsumsliding);
	}
	
	
	/*
	 * Brute Force Approach
	 * 
	 * 1. Check if the window size given is > 1 and less than the size of the array
	 * 2. Use 2 for loops, one outer loop to Iterate through the array and inner for loop to calculate the sum
	 * 3. Find current window size sum and also the max sum and finally return the max sum
	 */
	
	private int highestSum(int[] inputarray, int num) {
		int currentsum=0;
		int maxsum=Integer.MIN_VALUE;
		while(num>1 && num<inputarray.length) {
		for(int i=0;i<inputarray.length-num+1;i++) {
			currentsum=inputarray[i];
			for(int j=i+1;j<i+num;j++) {
				currentsum+=inputarray[j];
			}
			maxsum=Math.max(maxsum, currentsum);
		}		
		return maxsum;
	}
		throw new RuntimeException("Value of num is outside of acceptable range");
	}
	
	
	/*
	 * Sliding Window Approach
	 * 1. Get sum of the initial window size and assign it to max sum
	 * 2. Slide through the array, add next element and remove the first element to find current sum,
	 * 3. Get maximum of current sum and max sum and finally return the max sum
	 * 
	 */
	
	private int highestSumSliding(int[] inputarray, int num) {
		int maxsum=0,currentsum=0;
		if(num<2 && num >inputarray.length) throw new RuntimeException("Value of num is outside of acceptable range");
		
		for(int i=0;i<num;i++) {
			currentsum+=inputarray[i];
		}
		maxsum=currentsum;
		for(int i=num;i<inputarray.length;i++) {
			currentsum+=inputarray[i]-inputarray[i-num];
			maxsum=Math.max(maxsum, currentsum);
		}
		
		return maxsum;
	}
	
	

}
