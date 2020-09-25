package dataStructures;

import org.junit.Test;

public class HighestSum {

	@Test
	public void example1() {
		int[] inputarray = { 1, 1, 1, 1, 1, 90, 25 };
		int num = 1;
		int highestSum = highestSum(inputarray, num);
		System.out.println(highestSum);
	}

	@Test
	public void example2() {
		int[] inputarray = { 1, 4, 7, 1, 1, 5, 2 };
		int num = 5;
		int highestSum = highestSum(inputarray, num);
		System.out.println(highestSum);
	}

	@Test
	public void example3() {
		int[] inputarray = { 1, 1, 1, 1, 1, 1, 1 };
		int num = 3;
		int highestSum = highestSum(inputarray, num);
		System.out.println(highestSum);
	}

	@Test
	public void example5() {
		int[] inputarray = { 12,24,48,64,100,1,1,1,2 };;
		int num = 4;
		int highestSum = highestSum(inputarray, num);
		System.out.println("Example 5 is "+ highestSum);
	}

	/*
	 * @Test public void example4() { int[] inputarray = { 280, 1, 0, -111, 1, 90,
	 * 25, 38, 27 }; int num = 4; int highestSum = highestSumSlide(inputarray, num);
	 * System.out.println(highestSum); }
	 * 
	 * @Test public void example6() { int[] inputarray =
	 * {-169,0,0,530,0,0,0,0,3,0,2,90,25,38,25 }; int num = 14; int highestSum =
	 * highestSumSlide(inputarray, num); System.out.println(highestSum); }
	 * 
	 * @Test public void example7() { int[] inputarray = { -280, -1, 0, -111, -1,
	 * -90, -25, -38, -27 }; int num = 3; int highestSum =
	 * highestSumSlide(inputarray, num); System.out.println(highestSum); }
	 */
	
	
	@Test
	public void example8() {
		int[] inputarray = { 12,24,48,64,100,1,1,1,2 };
		int num = 4;
		int highestSum = highestSumSlide(inputarray, num);
		System.out.println(highestSum);
	}
	
	
	private int highestSum(int[] inputarray, int num) {
		int temp1, highestvalue = 0; //o[1]
		while (num < inputarray.length && num > 1) { //O[1]
			for (int i = 0; i < inputarray.length-num+1;) {				
					temp1 = i + num;
					int temp = 0;
					for (int j = i; j < temp1; j++) {
						temp = temp + inputarray[j];
					}
					if (temp > highestvalue)
						highestvalue = temp;
					break;
				}
			
			return highestvalue;
		}
		throw new RuntimeException("The value of num is outside of acceptable range");
	}
	
	
	private int highestSumSlide(int[] numbers, int num) {
		if(num>1 && num>numbers.length) {
			throw new RuntimeException("Value of the number is outside of expected range");
		}
		int max_sum=0,window_sum=0;
			for(int i=0;i<num;i++) {
				window_sum+=numbers[i];
			}
			
			for(int i=num;i<numbers.length;i++) {
				window_sum+=numbers[i]-numbers[i-num];
				max_sum=Math.max(max_sum, window_sum);
			}
			
			return max_sum;
		}
	

	
	

}
