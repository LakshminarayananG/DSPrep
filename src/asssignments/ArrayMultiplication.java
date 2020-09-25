package asssignments;

import java.util.Arrays;

import org.junit.Test;

public class ArrayMultiplication {

	/*
	 * Given an array nums of n integer where n is >1, return an array output such
	 * that output[i] is equal to the product of all the elements of nums except
	 * nums[i]
	 */

	@Test
	public void example1() {
		int[] numbers= {1,2,3,4};
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));

	}
	
	
	@Test
	public void example2() {
		int[] numbers= {1,1,1,1};
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}
	
	@Test
	public void example3() {
		int[] numbers= {0,0,0,0};
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}
	
	@Test
	public void example4() {
		int[] numbers= {6,5,2,8,5,2,0,6};
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}
	
	@Test
	public void example5() {
		int[] numbers= {6,-5,2,8,5,-2,1,6};
		int[] multiplyArrayElements = multiplyArrayElements(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}
	
	
	@Test
	public void example6() {
		int[] numbers= {1,2,3,4};
		int[] multiplyArrayElements = productExceptSelf(numbers);
		System.out.println(Arrays.toString(multiplyArrayElements));
	}
	
	
	
	//Brute Force Approach 
	//Complexity --> O[N^2]
	public int[] multiplyArrayElements(int[] numbers) {
		int[] multipliedArr= new int[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			int val=1;
			for(int j=0;j<numbers.length;j++) {
				if(i!=j) {
					val=val*numbers[j];
				}
			}
			multipliedArr[i]=val;
		}
		return multipliedArr;
	}
	
	
	private int[] productExceptSelf(int[] nums) {
	    int[] result = new int[nums.length];
	 
	    int[] t1 = new int[nums.length];
	    int[] t2 = new int[nums.length];
	 
	    t1[0]=1;
	    t2[nums.length-1]=1;
	 
	    //scan from left to right
	    for(int i=0; i<nums.length-1; i++){
	        t1[i+1] = nums[i] * t1[i];
	    }
	 
	    //scan from right to left
	    for(int i=nums.length-1; i>0; i--){
	        t2[i-1] = t2[i] * nums[i];
	    }
	 
	    //multiply
	    for(int i=0; i<nums.length; i++){
	        result[i] = t1[i] * t2[i];
	    }
	 
	    return result;
	}
	
	
	
	

}
