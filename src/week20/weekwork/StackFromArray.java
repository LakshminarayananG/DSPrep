package week20.weekwork;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.Test;



public class StackFromArray {
	
	//Create a stack from array

	@Test
	public void example1() {
		int[] nums = { 5, 6, 7, 6, 5, 1 };
		createStackFromArray(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 'a', 'c', 'd', 'k' };
		createStackFromArray(nums);
	}

	private void createStackFromArray(int[] nums) {
		//Stack<Integer> stack = new Stack<>();
		//Arrays.stream(nums).forEach(each -> stack.push(each));
		Stack<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toCollection(Stack::new));
		System.out.println(collect);
	}

}
