package practice;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class FaridaProb {
	
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
