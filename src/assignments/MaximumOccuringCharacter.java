package assignments;

import org.junit.Test;

public class MaximumOccuringCharacter {
	
	
	/*
	 * 1. Assign 2 variables start & end with index 0 & length -1 
	 * 2. Assign 2 characters ch1 (index 0) & ch2 (length -1)
	 * 3. Assign 2 integer variables st & en and initialise with 1
	 * 4. Assign 2 variables maxstart & end max and initialise with 1
	 * 5. If current start & start +1 is same, increment st by 1 and find max of st & maxstart, same for end.
	 * Assign ch1 to char of start & ch2 to end char. if not reassign st to 1
	 * 6. return ch1 or ch2 based on whether maxstart or endmax is greater
	 */
			
	@Test
	public void eg1() {
		String input="tooo work ass its amaaaa";
		System.out.println(maxoccurence(input));
	}
	
	private char maxoccurence(String input) {
		String modified = input.replaceAll("\\s+", "");
		// toooworkasitsamaaaa
		int start = 0;
		int end = modified.length() - 1;
		char ch1 = input.charAt(0), ch2 = input.charAt(end);
		int startval = 1, endval = 1;
		int maxstart = 1;
		int endmax = 1;

		while (start < end) {
			if (modified.charAt(start) == modified.charAt(start + 1)) {
				startval += 1;
				if (startval > maxstart) {
					ch1 = modified.charAt(start);
				}
				maxstart = Math.max(maxstart, startval);
			}

			else {
				startval = 1;
			}

			if (modified.charAt(end) == modified.charAt(end - 1)) {
				endval += 1;
				if (endval > endmax) {
					ch2 = modified.charAt(end);
				}

				endmax = Math.max(endmax, endval);
			}

			else {
				endval = 1;
			}

			start++;
			end--;
		}

		if (endmax > maxstart) {
			return ch2;
		}

		else {
			return ch1;
		}

	}
			

}
