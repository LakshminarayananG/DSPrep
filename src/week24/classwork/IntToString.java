package week24.classwork;

import org.junit.Test;

/*
1) Convert a Integer to its English words representation.
Input: num = 123
Output: "One Hundred Twenty Three"

Input: num = 1,234,567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

public class IntToString {

	String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "foruteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	String[] tens = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	@Test
	public void example1() {
		int num = 123;
		System.out.println(formatInteger(num));
	}

	@Test
	public void example2() {
		int num = 1234567;
		System.out.println(formatInteger(num));
	}

	@Test
	public void example3() {
		int num = 1000000011;
		System.out.println(formatInteger(num));
	}

	@Test
	public void example4() {
		int num = 0;
		System.out.println(formatInteger(num));
	}

	@Test
	public void example5() {
		int num = -1234;
		System.out.println(formatInteger(num));
	}
	
	@Test
	public void example6() {
		int num = 12300001;
		System.out.println(formatInteger(num));
	}

	private String formatInteger(int num) {
		if (num == 0)
			return "zero";
		if (num < 0)
			return "Invalid integer";

		return helper(num);
	}

	private String helper(int num) {
		if (num >= 1000000000)
			return helper(num / 1000000000) + " billion " + helper(num % 1000000000);
		if (num >= 1000000)
			return helper(num / 1000000) + " million " + helper(num % 1000000);
		if (num >= 1000)
			return helper(num / 1000) + " thousand " + helper(num % 1000);
		if (num >= 100)
			return helper(num / 100) + " hundred " + helper(num % 100);
		if (num >= 20)
			return tens[num / 10] + " " + helper(num % 10);
		return ones[num];
	}

}
