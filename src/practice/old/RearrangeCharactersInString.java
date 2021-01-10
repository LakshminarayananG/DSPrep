package practice.old;

import org.junit.Test;

public class RearrangeCharactersInString {
	
	@Test
	public void example1() {
		String input = "aab";
		String rearrangeString = rearrangeString(input);
		System.out.println(rearrangeString);
	}

	@Test
	public void example2() {
		String input = "aaabc";
		String rearrangeString = rearrangeString(input);
		System.out.println(rearrangeString);
	}

	private String rearrangeString(String input) {
		String output = "";
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length - 1; i++) {
			if (charArray[i] == charArray[i + 1] && charArray[i] != charArray[i + 2]) {
				char temp = charArray[i + 1];
				charArray[i + 1] = charArray[i + 2];
				charArray[i + 2] = temp;
			} else
				break;
		}
		for (char c : charArray)
			output += c;

		return output.equals(input) ? "String can't be rearranged" : output;
	}

}
