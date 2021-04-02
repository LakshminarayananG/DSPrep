package week24.classwork;

import org.junit.Test;

/*
Find the maximum possible value by inserting '5'
Examples:
input: 1234 -> output: 51234
input: 7643 -> output 76543
input: 0 -> output 50
input: -661 -> output -5661
*/

public class P3_MaxPossibleValue {

	@Test
	public void example1() {
		String inp="1234";
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example2() {
		String inp="7643";
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example3() {
		String inp="0";
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example4() {
		String inp="-661";
		System.out.println(findMaxValue(inp));
	}
	
	@Test
	public void example5() {
		String inp="-1";
		System.out.println(findMaxValue(inp));
	}
	
	//Pseudo Code
	
	/*
	 * if the input is negative, add 5 at first of the string and return it
	 * convert the string to string builder
	 * iterate through each element in the string from reverse direction and compare to 5 with its numerical value
	 * current element is less than 5, continue the loop
	 * if it is greater than or equal to 5, add 5 at index "current index+1" and return the string
	 * if 5 is greater than every element in the string, then add 5 at beginning and return the updated string
	 */
	
	// Space complexity: O[N]
	// Time complexity: O[N]
	private String findMaxValue(String inp) {
		StringBuilder sb = new StringBuilder(inp);

		if (inp.charAt(0) == '-')
			return sb.insert(1, 5).toString();

		for (int i = inp.length() - 1; i >= 0; i--) {
			if (Character.getNumericValue(inp.charAt(i)) >= 5)
				return sb.insert(i + 1, 5).toString();
		}

		return sb.insert(0, 5).toString();

	}
}
