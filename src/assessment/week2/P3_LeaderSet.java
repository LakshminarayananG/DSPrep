package assessment.week2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 Given an array of int, print leader set
 Input=[3,4,2,7,1,2,4,5]
 Output=[7,5]
 
 Input=[4,9,3,5,6,5,2]
 Output=[9,6,5,2]
 
 Input=[2,1]
 Output=[2,1]
*/

public class P3_LeaderSet {

	@Test
	public void example1() {
		int[] input = { 3, 4, 2, 7, 1, 2, 4, 5 };
		leaderSet(input);
	}

	@Test
	public void example2() {
		int[] input = { 4, 9, 3, 5, 6, 5, 2 };
		leaderSet(input);
	}

	@Test
	public void example3() {
		int[] input = { 2, 1 };
		leaderSet(input);
	}

	@Test
	public void example4() {
		int[] input = { 5, 4, 3, 2, 1 };
		leaderSet(input);
	}

	private void leaderSet1(int[] input) {
		List<Integer> list = new ArrayList<>();
		boolean flag = false;
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] < input[j]) {
					flag = true;
					break;
				}
			}
			if (!flag)
				list.add(input[i]);
			else
				flag = false;
		}
		list.add(input[input.length - 1]);
		System.out.println(list);
	}

	private void leaderSet(int[] input) {
		List<Integer> list = new ArrayList<Integer>();
		int max = input[input.length - 1];
		list.add(max);
		for (int i = input.length - 2; i >= 0; i--) {
			if (input[i] > max) {
				max = input[i];
				list.add(max);
			}
		}
		System.out.println(list);
	}
}
