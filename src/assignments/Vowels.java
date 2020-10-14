package assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Vowels {
	@Test
public void eg1() {
		int[] input= {5,3,6,7,4};
		System.out.println("One: "+diff(input));
		
		int[] input1= {4,3,2,1};
		System.out.println("Two: "+diff(input1));
		
		List<Integer> input2= new ArrayList<Integer>();
		input2.add(2);
		input2.add(3);
		input2.add(10);
		input2.add(2);
		input2.add(4);
		input2.add(8);
		input2.add(1);
		System.out.println("Three: "+difference(input2));
		
		List<Integer> input3= new ArrayList<Integer>();
		input2.add(4);
		input2.add(3);
		input2.add(2);
		input2.add(1);
		System.out.println("Four: "+difference(input3));
		
		/*
		 * List<Integer> input4= new ArrayList<Integer>(); input2.add(4); input2.add(3);
		 * input2.add(2); input2.add(1);
		 * System.out.println("Five: "+difference1(input4));
		 */
		List<Integer> input5= new ArrayList<Integer>();
		input2.add(2);
		input2.add(3);
		input2.add(10);
		input2.add(2);
		input2.add(4);
		input2.add(8);
		input2.add(1);
		System.out.println("Max is "+Collections.max(input5));
		System.out.println("Six: "+difference1(input5));
}
	
	
	private int diff(int[] input) {
		int maxdiff=-1;
		for(int i=0;i<input.length;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[j]>input[i]) {
					maxdiff=Math.max(input[j]-input[i], maxdiff);
				}
			}
		}
		
		return maxdiff;
	}
	
	
	private int difference(List<Integer> input) {
		int maxdiff=-1;		
		for(int i=0;i<input.size();i++) {
			for(int j=i+1;j<input.size();j++) {
				if(input.get(j)>input.get(i)) {
					maxdiff=Math.max(input.get(j)-input.get(i), maxdiff);
				}
			}
		}
		
		return maxdiff;
	}
	
	private int difference1(List<Integer> input) {
		int maxdiff=-1;		
		int val=Collections.max(input);
		int position = input.indexOf(val);
		for (Integer integer : input) {
			if(integer<val && integer!=val&& input.indexOf(integer)<position) {
				maxdiff=Math.max(val-integer, maxdiff);
			}
		}
		
		return maxdiff;
	}
}
