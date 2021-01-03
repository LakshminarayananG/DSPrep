package week15;
import org.junit.Test;

public class MaxPossibleValue {

			/*
			 * 3) Find the maximum possible value by inserting '5' Examples: input: 1234 ->
			 * output: 51234 input: 7643 -> output 76543 input: 0 -> output 50 input: -661
			 * -> output -5661
			 */
		
			/*
			 * Pseudo code: 1. Iterate through the
			 */
		
			@Test
			public void eg1() {
				int number = 7143;
				int insertnumber = 5;
				System.out.println(maxfive(number, insertnumber));
			}
		
			@Test
			public void eg2() {
				int number = -661;
				int insertnumber = 1;
				System.out.println(maxfive(number, insertnumber));
		
			}

		private int maxfive(int number, int insertnumber) {
			if (number == 0)
				return insertnumber * 10;
		
			int neg = number / Math.abs(number);
			number = Math.abs(number);
			int n = number;
		
			int counter = 0;
			while (n > 0) {
				counter++;
				n = n / 10;
			}
		
			int maxval = Integer.MIN_VALUE;
			int position = 1;
			for (int i = 0; i <= counter; i++) {
				int newval = ((number / position) * (position * 10) + (insertnumber * position) + (number % position));
				if (newval * neg > maxval) {
					maxval = newval * neg;
					position = position * 10;
				}
			}
			return maxval;
		}

}

