package asssignments;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;


public class FindExtraChar {
	
	//Question
	/*
	 * Given 2 Strings with length n and (n+1) respectively. The second String
	 * contains all the characters of first but with an extra char. Write the code
	 * to find the extra char
	 * 
	 * Example 1:
	 * 
	 * Input:
	 * 
	 * A1 = "Test" A2 = "Test$"
	 * 
	 * Output: '$'
	 * 
	 * Example 2:
	 * 
	 * Input:
	 * 
	 * A1 = "Hello" A2 = "lloreH"
	 * 
	 * Output: 'r'
	 */


	@Test
	public void eg1() {
		String s1 = "Test";
		String s2 = "Test$";
		char ch = findExtra(s1, s2);
		System.out.println(ch);
	}

	@Test
	public void eg2() {
		String s1 = "Test";
		String s2 = "Te*st";
		char ch = extraChar(s1, s2);
		System.out.println(ch);
	}

	@Test
	public void eg3() {
		String s1 = "Hello";
		String s2 = "lloleH";
		char ch = extraChar(s1, s2);
		System.out.println(ch);
	}

	@Test
	public void eg4() {
		String s1 = "Hello";
		String s2 = "Hleslo";
		char ch = extraCharSet(s1, s2);
		System.out.println(ch);
	}
	
	

	// Approach using Map
	/*
	 * 1. Declare a hashmap with character as input and count of char as key. 
	 * 2. Iterate through string s1 and add the key values to the map 
	 * 3. Iterate through string s2 and add the key values to the map 
	 * 4. Iterate through the map and check which char has value as 1 
	 * 5. Return the specific character that has value as 1
	 */
	
	private char findExtra(String s1, String s2) {
		Map<Character, Integer> res = new HashMap<Character, Integer>();
		char ch = ' ';
		for (int i = 0; i < s1.length(); i++) {
			res.put(s1.charAt(i), res.getOrDefault(s1.charAt(i), 0) + 1);
		}

		for (int j = 0; j < s2.length(); j++) {
			res.put(s2.charAt(j), res.getOrDefault(s2.charAt(j), 0) + 1);
		}

		for (Character value : res.keySet()) {
			if (res.get(value) == 1) {
				ch = value;
				break;
			}
		}

		return ch;
	}

	// Other Approach
	/*
	 * 1.Since only String 2 has one extra character, Iterate through it and get
	 * 	 individual character. 
	 * 2.Check if String 1 doesnt have that character. 
	 * 3.Return the specific character
	 */
	
	
	private char extraChar(String s1, String s2) {
		char ch = ' ';
		for (int j = 0; j < s2.length(); j++) {
			char ch1 = s2.charAt(j);
			if (!s1.contains("" + ch1 + "")) {
				ch = s2.charAt(j);
				break;
			}
		}

		return ch;
	}

	// Other Approach using Set
	/*
	 * 1.Since String 2 has only 1 extra character, 
	 * 2.Iterate through String 1 and
	 * 	 get each character 
	 * 3.Add string 1 characters to an input set 
	 * 4.Iterate through String s2 and get each character 
	 * 5.Check if character from s2 can be added to S1, 
	 * 6.Return the specific character that can be added.
	 */
	
	
	private char extraCharSet(String s1, String s2) {
		char ch = ' ';
		Set<Character> inputSet = new HashSet<Character>();

		for (int i = 0; i < s1.length(); i++) {
			inputSet.add(s1.charAt(i));
		}

		for (int j = 0; j < s2.length(); j++) {
			if (inputSet.add(s2.charAt(j))) {
				ch = s2.charAt(j);
				break;
			}
		}

		return ch;
	}

}