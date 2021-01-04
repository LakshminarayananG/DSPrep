package week11;

import org.junit.Test;

public class MaxConsecutive {
	
	//Pseudo Code

		/*
		 * create 2 pointer one pointer in first character of the sentence and another
		 * to second character if character of second pointer is equal to the character
		 * in first pointer, then increment the second pointer and increase the count if
		 * count is greater than previous count then set it as op if character of second
		 * pointer is not equal to the character in first pointer, then move first
		 * pointer to second pointer position.
		 */
		@Test
		public void example1() {
			String str = "Amaazon is a great company as it haas AtoooZzz";
			maxConsec(str);
		}
		
		@Test
		public void example2() {
			String str = "Amazon";
			maxConsec(str);
		}
		
		@Test
		public void example3() {
			String str = "Amaazon";
			maxConsec(str);
		}
		
		@Test
		public void example4() {
			String str = "Amazon   company";
			maxConsec(str);
		}

		private void maxConsec(String str) {
			char[] c = str.toCharArray();
			int i = 0, j = i + 1;
			int cnt = 1, maxcnt = Integer.MIN_VALUE;
			char op = 0;
			while (j < c.length) {
				if (c[i] == c[j]) {
					cnt++;
					j++;
				} else {
					cnt = 1;
					j++;
					i = j - 1;
				}

				if (cnt > maxcnt && cnt>1) {
					maxcnt = cnt;
					op = c[i];
				}
			}
			
			System.out.println(op);
		}

}
