package practice;

import java.util.Arrays;
import org.junit.Test;

public class RotateAnArray {
	
	@Test
	public void eg1(){
		int[] input= {1,4,7,8,10,12,3,2};
		int rotate=3;
		System.out.println(Arrays.toString(rotate(input, rotate)));
	}
	
	
	@Test
	public void eg2(){
		int[] input= {1,4,7,8,10,12,3,2};
		int rotate=3;
		System.out.println(Arrays.toString(alternateApp(input, rotate)));
	}
	
	private int[] rotate(int[] input, int rotate) {
		if (rotate > input.length) {
			rotate = rotate % input.length;
		}
		int[] temp = new int[input.length];

		for (int i = 0; i < rotate; i++) {
			temp[i] = input[input.length - rotate + i];
		}
		int val = 0;
		for (int i = rotate; i < input.length; i++) {
			temp[i] = input[val];
			val++;
		}
		return temp;
	}
	
	private int[] alternateApp(int[] input, int rotate) {
		if(rotate>input.length) {
			rotate = rotate%input.length;
		}
		
		int temp= input.length-rotate;
		rotate(input, 0, temp-1);
		rotate(input,temp, input.length-1);		
		rotate(input,0,input.length-1);
		
		return input;
		
	}
	
	
	private int[] rotate(int[] input, int start, int end) {
		while(start<end) {
			int temp= input[start];
			input[start]=input[end];
			input[end]=temp;
			start++;
			end--;
		}
		
		return input;
	}

}
