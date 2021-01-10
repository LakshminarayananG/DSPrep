package assessment.week5;

import org.junit.Test;

public class P1_CharacterReprogramming {

	@Test
	public void example1() {
		String input = "URDR";
		charReprogramming(input); // 2
	}

	@Test
	public void example2() {
		String input = "RRR";
		charReprogramming(input); // 0
	}

	@Test
	public void example3() {
		String input = "RUDRL";
		charReprogramming(input); // 4
	}
	
	@Test
	public void example4() {
		String input = "UDUD";
		charReprogramming(input); // 4
	}

	private void charReprogramming(String input) {
		int r = 0, l = 0, u = 0, d = 0;

		for (char c : input.toCharArray()) {
			switch (c) {
			case 'U': {
				if (d > 0)
					d--;
				else
					u++;
				break;
			}
			case 'D': {
				if (u > 0)
					u--;
				else
					d++;
				break;
			}
			case 'R': {
				if (l > 0)
					l--;
				else
					r++;
				break;
			}
			case 'L': {
				if (r > 0)
					r--;
				else
					l++;
				break;
			}
			}
		}

		System.out.println(input.length() - (u + d + r + l));
	}
}
