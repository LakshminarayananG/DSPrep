package week14.homework;

import org.junit.Test;

public class FlowerBedProblem {

	/*
	 * You have a long flowerbed in which some of the plots are planted, and
	 * some are not. However, flowers cannot be planted in adjacent plots.Given
	 * an integer array flowerbed containing 0's and 1's, where 0 means empty
	 * and 1 means not empty, and an integer n, return if n new flowers can be
	 * planted in the flowerbed without violating the no-adjacent-flowers rule.
	 * 
	 * 
	 * Example 1: Input: flowerbed = [1,0,0,0,1], n = 1 Output: true 
	 * 
	 * Example 2:
	 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: false
	 */
	
	@Test
	public void eg1() {
	int[] flowerbed= {1,0,0,0,0,1};
	int n=2;
	System.out.println(canPlaceFlowers1(flowerbed, n));
	}

	@Test
	public void eg2() {
	int[] flowerbed= {0,0,1,0,1};
	int n=1;
	System.out.println(canPlaceFlowers1(flowerbed, n));
	}

	@Test
	public void eg3() {
	int[] flowerbed= {1,0,0,0,0,1};
	int n=1;
	System.out.println(canPlaceFlowers1(flowerbed, n));
	}


	@Test
	public void eg4() {
	int[] flowerbed= {1,0,0,0,0,0,1};
	int n=2;
	System.out.println(canPlaceFlowers1(flowerbed, n));
	}

	@Test
	public void eg5() {
	int[] flowerbed= {1,0,0,0,1,0,0};
	int n=2;
	System.out.println(canPlaceFlowers(flowerbed, n));
	}
	
	@Test
	public void test1() {
		int[] input = { 1,0,0,0,1};
		int n = 1;
		System.out.println(canPlaceFlowers(input, n));
	}
	
	@Test
	public void test2() {
		int[] input = { 1,0,0,0,1};
		int n = 2;
		System.out.println(canPlaceFlowers(input, n));
	}
	
	@Test
	public void test3() {
		int[] input = { 1,0,0,0,0,1,1,0,1,0,1};
		int n = 2;
		System.out.println(canPlaceFlowers(input, n));
	}
	
	@Test
	public void test4() {
		int[] input = { 1,0,0,0,0,1,1,0,1,0,1};
		int n = 20;
		System.out.println(canPlaceFlowers(input, n));
	}
	
	
	/*
	 * 1. Derive the conditions for placing the flowers 
	 * 2. Condition 1: A flower can be placed if the current position & left & right position of the current is 0
	 * 3. Condition 2: If the current position is 0th index, only look on right for the 0 value
	 * 4. Condition 3: If the current position is last index, only look on left for the O value
	 * 5. Optimize the condition  */

	
	//O[N] - Worst case
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		
		if(n>flowerbed.length) return false;

		for (int i = 0; i < flowerbed.length; i++) {
			
			if (n == 0) break;
			
			//Conditions optimized
			if(flowerbed[i]==0 && ( i== flowerbed.length-1 || flowerbed[i+1] ==0) && ( i== 0 || flowerbed[i-1] ==0) ){
				flowerbed[i] = 1;
				n--;
			}

		}
		return n==0;
	}
	
	
	private boolean canPlaceFlowers1(int[] flowerbed, int n) {
		if(n> flowerbed.length){
		            return false;
		        }
		       
		        for(int i=0;i<flowerbed.length;i++){
		            if(flowerbed[i]==0 && (i==flowerbed.length-1 ||flowerbed[i+1]==0) && (i==0 || flowerbed[i-1]==0)){
		                flowerbed[i]=1;
		                n--;
		            }
		        }
		       
		        if(n>0) return false;
		        return true;
		    }
	
}
