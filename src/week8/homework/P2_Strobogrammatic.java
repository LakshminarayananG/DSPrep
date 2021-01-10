package week8.homework;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P2_Strobogrammatic {

	@Test
	public void example1() {
		String input = "69";
		System.out.println(isStobogrammatic(input));
	}

	@Test
	public void example2() {
		String input = "81";
		System.out.println(isStobogrammatic(input));
	}

	@Test
	public void example3() {
		String input = "80";
		System.out.println(isStobogrammatic(input));
	}

	@Test
	public void example4() {
		String input = "88";
		System.out.println(isStobogrammatic(input));
	}

	private boolean isStobogrammatic(String input) {
		String[] in = input.split("");
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "0");
		map.put("1", "1");
		map.put("6", "9");
		map.put("8", "8");
		map.put("9", "6");

		int l = 0, r = in.length - 1;
		while (l < r) {
			if (!map.containsKey(in[l]) || !map.containsKey(in[r]))
				return false;

			String temp = map.get(in[l]);
			in[l++] = map.get(in[r]);
			in[r--] = temp;
		}
		return String.join("", in).equals(input);
	}
}
