package assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class Prob4_SubsequnceRemoval {
	
	/*
	 * Given an array of positive integers, find the minimum length ascending
	 * subsequence such that after removing this subsequence from the array, the
	 * remaining array contains only unique integers. Only one subsequence will have
	 * the minimum length (no ties). If there is no such subsequence, return [-1].
	 * 
	 * Example n = 7 arr = [2, 1, 3, 1, 4, 1, 3] After removing the subsequence [1,
	 * 1, 3], the remaining array of distinct integers is [2, 3, 4, 1]. The
	 * subsequence [1, 1, 3] is the shortest ascending subsequence with this
	 * property, so it is returned.
	 */

	@Test
	public void eg1() {

		Integer[] input = { 2, 1, 3, 1, 4, 1, 3 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(input));
		System.out.println("One: " + subsequenceRemove(list));
		}

	@Test
	public void eg2() {
		Integer[] input = { 1, 1, 1, 3 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(input));
		System.out.println("Two: " + subsequenceRemove(list));
		}

	@Test
	public void eg3() {
		Integer[] input = { 3, 2, 2, 1, 1 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(input));
		System.out.println("Three: " + subsequenceRemove(list));
		}
	
	@Test
	public void eg4() {
		Integer[] input = {2,1,3,1,4,1,3};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(input));
		System.out.println("Four: " + subsequenceRemove(list));
		}
	
	@Test
	public void eg5() {
		Integer[] input = {4,1,1,1,3};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(input));
		System.out.println("Five: " + subsequenceRemove(list));
		}
	
	@Test
	public void eg6() {
		Integer[] input = {3,2,2,1,1};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(input));
		System.out.println("Six: " + subsequenceRemove(list));
		}
	
	

	private List<Integer> subsequenceRemove(List<Integer> arr) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		List<Integer> out = new ArrayList<Integer>();
		int val = 0;

		for (Integer integer : arr) {
			if (list.contains(integer)) {
				if (output.size() >= 1) {
					if (integer >= output.get(val)) {
						output.add(integer);
						val++;
					} else {
						out.add(-1);
						return out;
					}
				} else {
					output.add(integer);
				}

			} else {
				list.add(integer);
			}
		}

		return output;

	}

}