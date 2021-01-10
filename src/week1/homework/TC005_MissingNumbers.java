package week1.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
 Find all the missing numbers in the given array
 
 Input: [4,3,2,7,8,2,3,1]
 Output: [5,6]
*/

/*ques:
	1. to find the missing numbers between the min and max in the array?
	*/
public class TC005_MissingNumbers {

	@Test
	public void example1() {
		int[] input = { 4, 3, 2, 7, 8, 2, 3, 1 };
		//bruteforce_1(input);
		bruteforce_3(input);
	}

	private void bruteforce_1(int[] input) {
		Arrays.sort(input);
		boolean flag;
		for (int i = input[0]; i < input[input.length - 1]; i++) {
			flag = false;
			for (int a : input) {
				if (a == i) {
					flag = true;
					break;
				}
			}
			if (!flag)
				System.out.println(i);
		}
	}

	private void bruteforce_2(int[] input) {
		Arrays.sort(input);
		for (int i = input[0]; i < input[input.length - 1]; i++)
			if (Arrays.binarySearch(input, i) < 0)
				System.out.println(i);
	}
	
	private void bruteforce_3(int input[]) {
		Set<Integer> set=new TreeSet<Integer>();
		for (int a : input) {
			set.add(a);
		}
		List<Integer> list=new ArrayList<Integer>(set);
		int number=list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if(number+1==list.get(i))
				number=list.get(i);
			else {
				System.out.println(number+1);
				number++;
			}
		}
		
	}

	
}