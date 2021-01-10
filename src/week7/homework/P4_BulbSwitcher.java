package week7.homework;

import java.awt.MenuComponent;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P4_BulbSwitcher {

	@Test
	public void example1() {
		String input = "001011101"; // 5
		bulbSwitch(input);
	}

	@Test
	public void example2() {
		String input = "10111"; // 3
		bulbSwitch(input);
	}

	@Test
	public void example3() {
		String input = "101"; // 3
		bulbSwitch(input);
	}

	@Test
	public void example4() {
		String input = "00000"; // 0
		bulbSwitch(input);
	}

	private void bulbSwitch(String input) {
		int cnt = 0, val = '0';

		for (char c : input.toCharArray()) {
			if (c != val) {
				cnt++;
				val = c;
			}
		}
		System.out.println(cnt);
	}

	private void bulbSwitch2(String input) {
		String temp = input;
		int cnt = 0, val = 1;
		for (int i = 0; i < input.length(); i++) {
			if (val == Character.getNumericValue(input.charAt(i))) {
				temp = temp.substring(0, i) + temp.substring(i).replaceAll("[\\d+]", Integer.toString(val));
				val = (val == 0) ? 1 : 0;
				cnt++;
				if (temp.equals(input))
					break;
			}
		}

		System.out.println(cnt);
	}

	private void bulbSwitch1(String input) {
		String temp = input;
		Map<Integer, Character> map = new HashMap<Integer, Character>();

		for (int i = 0; i < input.toCharArray().length; i++)
			map.put(i, input.charAt(i));

		int cnt = 0, val = 1;

		for (Map.Entry<Integer, Character> m : map.entrySet()) {
			if (val == Character.getNumericValue(m.getValue())) {
				temp = temp.substring(0, m.getKey())
						+ temp.substring(m.getKey()).replaceAll("[\\d+]", Integer.toString(val));
				val = (val == 0) ? 1 : 0;
				cnt++;
				if (temp.equals(input))
					break;
			}
		}

		System.out.println(cnt);

	}
}
