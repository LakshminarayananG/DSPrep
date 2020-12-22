package assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Prob3 {

	@Test
	public void eg1() {
		String input = "xzaazz";
		int k = 2;
		charlimit(input, k);
	}

	private void charlimit(String input, int k) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		List<Character> list = new ArrayList<Character>();
		String out = "";
		int[] samp = new int[128];
		for (char character : input.toCharArray()) {
			/*
			 * map.put(character, map.getOrDefault(character, 0)+1); list.add(character);
			 */
			list.add(character);
			samp[(int) character] += 1;
		}
		// System.out.println(Arrays.toString(samp));

		Collections.sort(list);

		for (Character character : list) {
			out += character;
		}

		StringBuilder sb = new StringBuilder(out);
		// sb.reverse();
		// System.out.println(sb.reverse().toString());

		buildString(sb.reverse().toString(), k, samp);
	}

	private void buildString(String input, int k, int[] samp) {
		// Input String ="ZZZXXA"
		// Expected op= "ZZXZXA";
		// 1st iter:

		Map<Character, Integer> countermap = new HashMap<Character, Integer>();

		String out = "";

		for (int i = 0; i < input.length(); i++) {
			countermap.put(input.charAt(i), countermap.getOrDefault(input.charAt(i), 0) + 1);

			/*
			 * if (countermap.get(input.charAt(i)) == 1) { out += input.charAt(i);
			 * samp[(int) input.charAt(i)] -= 1; }
			 * 
			 * else
			 */ if (countermap.get(input.charAt(i)) <= k) {
				// check if there is any greater ascii value
				int x = i - 1;
				while (x >= 0) {
					if (samp[(int) input.charAt(x)] != 0) {
						out += input.charAt(x);
						samp[(int) input.charAt(x)] -= 1;
						
					}
					x--;

				}

				if (countermap.get(input.charAt(i)) == 1) {
					out += input.charAt(i);
					samp[(int) input.charAt(i)] -= 1;
					
				}
				//countermap.put(input.charAt(i), countermap.get(input.charAt(i))-1);

				//out += input.charAt(i);
			}

		}

		System.out.println(out);

	}

}
