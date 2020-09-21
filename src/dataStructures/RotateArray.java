package dataStructures;

import java.util.Arrays;
import org.junit.Test;

public class RotateArray {
	
	@Test
	public void rotate() {
		int [] inputarray= {1,3,5,6,8};
		int rotatetimes=3;
		rotateArr(inputarray, rotatetimes);
			}
	
	
	private void rotateArr(int[] inputarray, int rotate) {
		int[] temp= new int[rotate];
		for (int i = 0; i < temp.length; i++) {
			temp[i]=inputarray[i];
		}
		
		System.out.println(Arrays.toString(temp));
		
		
		for (int i=0;i<inputarray.length-rotate;i++) {	
			if(i!=inputarray.length) {
			inputarray[i]=inputarray[i+1];
			}
		}
		
		
		
		System.out.println(Arrays.toString(inputarray));
	}

}
