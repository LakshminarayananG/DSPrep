package week24.classwork;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenerateBrackets {

	@Test
	public void example1() {
		int k = 3;
		findCombinations(k);
	}

	@Test
	public void example2() {
		int k = 2;
		findCombinations(k);
	}

	@Test
	public void example3() {
		int k = 1;
		findCombinations(k);
	}

	private void findCombinations(int k) {
		int openCount = 0, closeCount = 0;
		String combination = "";
		List<String> result = new ArrayList<String>();
		recursion(k, result, combination, openCount, closeCount);
		System.out.println(result);
	}

	private void recursion(int k, List<String> result, String combination, int openCount, int closeCount) {

		if ((openCount == k) && (closeCount == k)) {
			result.add(combination);
			return;
		}

		if (openCount < k)
			recursion(k, result, combination + "(", openCount + 1, closeCount);

		if (closeCount < openCount)
			recursion(k, result, combination + ")", openCount, closeCount + 1);
	}
}
