package week17.classwork;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GenerateParanthesis {
	
	/*
	 * Approach
	 * 
	 * 1. Get the number for which we need to generate the paranthesis
	 * 2. Declare 2 variables left & right equal to the value of n
	 * 3. If value of left & right are equal, add the string to the list
	 * 4. Until value of left & right are equal to zero, call the left function recursively and add ( to the string
	 *   when calling function to add to left and call the right add recursively and add ) to the string
	 * 5. Add the string to list and return the same
	 */

	@Test
	public void eg1() {
		int num = 2;
		System.out.println(generate(num));
		System.out.println(generateParenthesis(num));
	}

	private List<String> generate(int num) {
		if (num % 2 != 0 || num < 1)
			throw new RuntimeException("Invalid value of num");
		List<String> list = new ArrayList<String>();
		recursive(num / 2, 0, 0, list, "");
		return list;
	}

	private void recursive(int num, int left, int right, List<String> list, String bracket) {
		if (left == num && right == num) {
			list.add(bracket);
			return;
		}
		if (left < num)
			recursive(num, left + 1, right, list, bracket + "(");
		if (right < left)
			recursive(num, left, right + 1, list, bracket + ")");
	}

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesisHelper(n, n, "", result);
		return result;
	}

	public void generateParenthesisHelper(int left, int right, String s, List<String> result) {
		if (left == 0 && right == 0) {
			// No more left or right brackets can be added. combination is complete
			result.add(s);
			return;
		}
		if (left > 0) {
			// safe to add a left bracket
			generateParenthesisHelper(left - 1, right, s + "(", result);
		}
		if (left < right) {
			// safe to add a right bracket
			generateParenthesisHelper(left, right - 1, s + ")", result);
		}
	}

}
