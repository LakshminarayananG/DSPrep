package practice.old;

import org.junit.Test;

public class SlidingWindow {
	
	@Test
	public void eg1()
	{
		int[] input= {1,4,5,22,6,9,10,3,12};
		int k= 3;
		System.out.println((slideWndBrute(input, k)));
	}
	
	
	@Test
	public void eg2()
	{
		int[] input= {1,4,5,22,6,9,10,3,12};
		int k= 3;
		System.out.println((slidingWindow(input, k)));
	}
	
	private int slideWndBrute(int[] input, int k) {
		if(k>input.length|| k==1) {
			throw new RuntimeException("Value is outside of acceptable range");
		}
		int highestsum=0;
		for(int i=0; i<input.length-k;i++) {
			int val=0;
			int temp=i+k;
			for (int j=i;j<temp;j++) {
				val+=input[j];
			}
			if(val>highestsum) {
				highestsum=val;
			}
		}
		
		return highestsum;
	}
	
	
	private int slidingWindow(int[] input, int k) {
		if(k>input.length|| k==1) {
			throw new RuntimeException("Value is outside of acceptable range");
		}
		
		int maxsum=0; int currentsum = 0;
		for(int i=0;i<k;i++) {
			currentsum+=input[i];
		}
		
		for(int j=k;j<input.length;j++) {
			currentsum+=input[j]-input[j-k];
			maxsum=Math.max(maxsum, currentsum);
		}
		return maxsum;
		
	}
	
	
	
	
	
}
