package week6.stacksAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/*
Given a list of daily temperatures T, return a list such that, for each day in the input, 
tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 

your output should be [1, 1, 4, 2, 1, 1, 0, 0]
*/

public class P1_Temperature {

	@Test
	public void example1() {
		List<Integer> list = new ArrayList<>(Arrays.asList(73, 74, 75, 71, 69, 72, 76, 73));
		checkTemp(list);
	}

	@Test
	public void example2() {
		List<Integer> list = new ArrayList<>(Arrays.asList(68, 69, 71, 70, 69, 72, 69, 68, 70));
		checkTemp(list);
	}

	private void checkTemp(List<Integer> list) {

		Stack<Integer> stack = new Stack<>();
		//List<Integer> op = new ArrayList<>();
		int[] op=new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			while(!stack.isEmpty()  && list.get(i) > list.get(stack.peek())){
				int top = stack.pop();
				op[top] = i-top;
			}			
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			int top = stack.pop();
			op[top] = 0; //nothing
		}
		
		System.out.println(Arrays.toString(op));
	}

	private void checkTemp1(List<Integer> list) {
		List<Integer> op = new ArrayList<>();
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) > list.get(i)) {
					op.add(j - i);
					flag = true;
					break;
				}
			}
			if (flag)
				flag = false;
			else
				op.add(0);
		}

		System.out.println(op);
	}
}
