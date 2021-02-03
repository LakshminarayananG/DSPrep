package problems.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SubsequenceRemoval_20 {
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
