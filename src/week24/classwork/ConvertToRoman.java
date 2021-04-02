package week24.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ConvertToRoman {

	Map<Integer, String> map = new HashMap<>();

	@Before
	public void before() {
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
	}

	@Test
	public void example1() {
		int num = 12;
		String convertRoman = convertRoman(num);
		System.out.println(convertRoman);
	}

	@Test
	public void example2() {
		int num = 35;
		String convertRoman = convertRoman(num);
		System.out.println(convertRoman);
	}

	private String convertRoman(int num) {
		int[] values = { 10, 9, 5, 4, 1 };
		String[] romanNumerals = { "X", "IX", "V", "IV", "I" };

		String output = "";

		for (int i = 0; i < values.length; i++) {

			while (num >= values[i]) {
				num -= values[i];
				output += romanNumerals[i];
			}
		}

		return output;

	}

}
