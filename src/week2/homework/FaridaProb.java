package week2.homework;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class FaridaProb {
	
	/*
	4) Once upon time there was a cute princess called Farida living in a castle with her father, mother and uncle. 
	On the way to the castle there lived many monsters. Each one of them had some gold coins. 
	Although they are monsters they will not hurt. 
	Instead they will give you the gold coins, but if and only if you didn't take any coins from the monster directly 
	before the current one. 
	To marry princess Farida you have to pass all the monsters and collect as many coins as possible. 
	Given the number of gold coins each monster has, 
	calculate the maximum number of coins you can collect on your way to the castle.
	*/
	
	@Test
	public void eg1() {
		int[] gold= {2500,1,3,2501,5,61,1,10,12,4,56};
		int noOfCoins= maxgold(gold);
		System.out.println(noOfCoins);
	}
	
	@Test
	public void eg2() {
		int[] gold= {14,1,1,14};
		int noOfCoins= maxcoins(gold);
		System.out.println(noOfCoins);
	}
	
	
	
	private Integer maxgold(int[] array) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		//Arrays.sort(a);
		int len= array.length;
		for(int i=0; i<len;i++) {
			int count=0;
			for(int j=0;j<len;j++) {
				if((i+j)%2==0) {
					count+=array[j];
				}
			}
			result.add(count);
		}
		System.out.println(result);
		return Collections.max(result);
	}
	
	
	/*
	 * Actual Soluiton given 
	 */
	private int maxcoins(int[] array) {
		int prevmax=0;
		int currmax=0;
		for (int i : array) {
			int temp=currmax;
			currmax=Math.max(prevmax+i, currmax);
			prevmax=temp;
		}
		return currmax;
	}
	
	
	

}
