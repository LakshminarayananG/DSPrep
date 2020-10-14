package assessment;

import java.util.Arrays;
import org.junit.Test;


/*Given an array numbers , write a function to move all odd numbers to
the end of it while maintaining the relative order of all elements.
Example:
Input: [2,1,5,3,12]
Output: [2,12,1,5,3]
Note:
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.*/


public class Prob1_MoveAllOddToRight {
	
	@Test
	public void eg1() {
		int[] input= {2,1,5,3,12};
		moveOddToRight(input);
	}
	
	@Test
	public void eg2() {
		int[] input= {2,1,5,3,12};
		System.out.println(Arrays.toString(movealloddRight(input)));
	}
	
	private int[] moveallodd(int[] input) {
		int evennum=0; int oddnum=0;
		
		while(evennum<input.length) {
			if(input[evennum]%2==0) {
				int temp=input[oddnum];
				input[oddnum++]=input[evennum];
				input[evennum++]=temp;
				
			}
			else {
				evennum++;
			}
		}
		return input;
		
	}
	
	public void moveOddToRight(int[] input) {
		int strPoint = 0;
		int endPoint = 0;
		while((strPoint < input.length)&&(endPoint<input.length)) {
			if(input[strPoint]%2 ==0) {
				strPoint ++;
				endPoint ++;
			}else {
				if(input[endPoint]%2 ==0 && !(input[endPoint] == 0)) {
					int temp = input[endPoint];
					input[endPoint] = input[strPoint];
					input[strPoint] =temp;
					strPoint ++;
					endPoint ++;
				}else {
					endPoint++;
				}
			}
		}
		System.out.println(Arrays.toString(input));
	}
	
	
	
	private int[] movealloddRight(int[] input) 	{
	int endIndex = input.length-1;
	int previousIndex = input.length-2;
	
	while(previousIndex >= 0)// 2,1,5,8,12
	{
		if(input[endIndex]%2==0 && input[previousIndex]%2!=0)//12vs8
		{
			int temp = input[endIndex];
			input[endIndex] = input[previousIndex];
			input[previousIndex] = temp;
			
		}
		else if(input[endIndex]%2==0 && input[previousIndex]%2==0)
		{
			previousIndex--;
		}
		else if(input[endIndex]%2!=0)
		{
			endIndex--;
			previousIndex--;	
		}
	}
	
	
	return input;
}

}
