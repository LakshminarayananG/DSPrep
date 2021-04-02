package assessment.week15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
Given an array of positive integers, find the minimum length ascending subsequence such that after removing this subsequence from the array, the remaining array contains only unique integers. Only one subsequence will have the minimum length (no ties). If there is no such subsequence, return [-1].

Example
n = 7
arr = [2, 1, 3, 1, 4, 1, 3]
After removing the subsequence [1, 1, 3], the remaining array of distinct integers is [2, 3, 4, 1]. The subsequence [1, 1, 3] is the shortest ascending subsequence with this property, so it is returned.

Sample Case 0
Sample Input For Custom Testing
STDIN Function
----- --------
4 → arr[] size n = 4
1 → arr[] = [1, 1, 1, 3]
1
1
3
Sample Output
1
1
Explanation
The input array is [1, 1, 1, 3]. After removing the subsequence [1, 1], the remaining array is [1, 3] which contains only unique integers. There is no shorter subsequence with that property.

Sample Case 1
Sample Input For Custom Testing
STDIN Function
----- --------
5 → arr[] size n = 5
3 → arr[] = [3, 2, 2, 1, 1]
2
2
1
1
Sample Output
-1
Explanation
The input array is [3, 2, 2, 1, 1]. The example does not contain any ascending subsequence such that after removing it, the array contains only unique integers.
*/

public class SubsequenceRemoval {
	@Test
	public void example1() {
		int[] arr = { 2, 1, 3, 1, 4, 1, 3 };
		System.out.println(subsequenceRemoval(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 1, 1, 1, 3 };
		System.out.println(subsequenceRemoval(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 3, 2, 2, 1, 1 };
		System.out.println(subsequenceRemoval(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 100, 2, 7, 2, 100 };
		System.out.println(subsequenceRemoval(arr));
	}

	private List<Integer> subsequenceRemoval(int[] arr) {
		Set<Integer> unique = new HashSet<Integer>();
		List<Integer> duplicate = new ArrayList<Integer>();
		int size = 0;

		for (int eachEl : arr) {
			if (!unique.add(eachEl)) {
				duplicate.add(eachEl);
				size = duplicate.size();
				if (size > 1 && eachEl < duplicate.get(size - 2)) {
					duplicate.clear();
					duplicate.add(-1);
					return duplicate;
				}
			}
		}
		return duplicate;
	}
}
