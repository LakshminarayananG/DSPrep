package week6.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class Temperature {
	
	@Test
	public void test1(){
		
		int[] input = {73,74,75,71,69,72,76,73};
		
		System.out.println(Arrays.toString(findWarmer(input)));
	}
	
	private int[]  findWarmer(int[] input){
		
		int[] output = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			int val=0;
			for (int j = i+1; j < input.length; j++) {
				System.out.println("I am here");
				val++;
				if(input[j]>input[i]){
					output[i]=val;
					break;
				}
				
			}
			
		}
		return output;
	}
	
	
	private int[]  findWarmer1(int[] input){
		int[] output = new int[input.length];
		output[output.length-1]=0;
		Stack<Integer> stack = new Stack<>();
		stack.push(input[input.length-1]);
		for (int i = input.length-2; i >= input.length; i++) {
			if(input[i]>stack.peek()) {
				output[i]=stack.size();
				stack.removeAllElements();
			}
			else {
				stack.push(input[i]);
			}
			
		}
		
		return output;
		
	}
	

}
