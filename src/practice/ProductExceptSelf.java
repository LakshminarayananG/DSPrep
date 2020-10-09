package practice;

import java.util.Arrays;
import org.junit.Test;

public class ProductExceptSelf {
	
	@Test
	public void eg1() {
		int[] input = {1,2,3,4};
		System.out.println(Arrays.toString(product(input)));
	}
	
	@Test
	public void eg2() {
		int[] input = {1,2,3,4};
		System.out.println(Arrays.toString(productOtherApp(input)));
	}
	
	private int[] product(int[] input) {
		int[] temp= new int[input.length];
		
		for(int i=0;i<input.length;i++) {
			int val=1;
			for(int j=0;j<input.length;j++) {
				if(i!=j) {
					val=val*input[j];
				}
			}
			temp[i]=val;
		}
		
		return temp;
	}
	
	
	private int[] productOtherApp(int[] input) {
		int[] temp1= new int[input.length];
		int[] temp2= new int[input.length];
		int[] out= new int[input.length];
		
		temp1[0]=1;
		temp2[temp2.length-1]=1;
		
		for(int i=0;i<temp1.length-1;i++) {
			temp1[i+1]=temp1[i]*input[i];
		}
		
		for(int j=temp2.length-1;j>0;j--) {
			temp2[j-1]=temp2[j]*input[j];
		}
		
		for(int i=0;i<input.length;i++) {
			out[i]=temp1[i]*temp2[i];
		}
		
		return out;
	}

}
