package practice.old;

import java.util.Arrays;
import org.junit.Test;

public class SquareOfNumbers {
	
	@Test
	public void eg1() {
		int[] input= {-8,-3,-2,1,2,4,10};
		System.out.println(Arrays.toString(squares(input)));
	}
	
	
	@Test
	public void eg2() {
		int[] input= {-8,-3,-2,15,2,4,10};
		System.out.println(Arrays.toString(squaresTwoPoint(input)));
	}
	
	private int[] squares(int[] input) {
		int[] temp= new int[input.length];
		for(int i=0;i<input.length;i++) {
			temp[i]=input[i]*input[i];
		}
		
		Arrays.sort(temp);
		return temp;
	}
	
	
	private int[] squaresTwoPoint(int[] input) {
		int[] temp = new int[input.length];
		int start=0; int end=input.length-1;
		int i=end;
		while(start<=end) {
			int tmp1= input[start]*input[start];
			int tmp2= input[end]* input[end];
			if(tmp1>tmp2) {
				temp[i--]=tmp1;
				start++;
			}
			else {
				temp[i--]=tmp2;
				end--;
			}
		}
		
		return temp;
	}

}
