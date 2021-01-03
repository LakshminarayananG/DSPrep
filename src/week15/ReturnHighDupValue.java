package week15;

import org.junit.Test;

public class ReturnHighDupValue {

			/*
			 * Given a string S with both lowercase and uppercase letters, return the
			 * biggest ASCII letter that appears both in lowercase and uppercase. The
			 * returned letter must be in uppercase. If there is no such letter, return
			 * 'NO'. Examples: 'aaabcAbCdD', return 'D' 'aA', return 'A' 'abcdE', return
			 * 'NO' 'a', return 'NO'
			 */
		
			/*
			 * Pseudo code: 1. Check for the length of the string, if equal to 1, return No
			 * 2. Declare 2 boolean array for lower case & upper case 3. Iterate through the
			 * character array and check if the particular character is lower or upper and
			 * accordingly update the boolean array 4. Iterate from the last (to find the
			 * alphabet that appears in both upper and lower 5. If it appears in both lower
			 * & upper, return the corresponding alphabet, else return No
			 */
		
			@Test
			public void eg1() {
				String s = "aaafbcAbCFdD";
				System.out.println(biggestascii(s));
			}
		
			@Test
			public void eg2() {
				String s = "aA";
				System.out.println(biggestascii(s));
			}
		
			@Test
			public void eg3() {
				String s = "abcdE";
				System.out.println(biggestascii(s));
			}
		
			@Test
			public void eg4() {
				String s = "a";
				System.out.println(biggestascii(s));
			}


		private String biggestascii(String str) {
			if (str.length() == 1)
				return "NO";
		
			boolean[] lowerval = new boolean[26];
			boolean[] upperval = new boolean[26];
		
			for (int i = 0; i < str.length(); i++) {
				if (Character.isLowerCase(str.charAt(i)))
					lowerval[str.charAt(i) - 'a'] = true;
		
				if (Character.isUpperCase(str.charAt(i)))
					upperval[str.charAt(i) - 'A'] = true;
			}
		
			for (int i = 25; i >= 0; i--) {
				if (lowerval[i] && upperval[i])
					return (char) (i + 'A') + "";
			}
		
			return "NO";
		}


}
