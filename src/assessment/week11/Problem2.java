package assessment.week11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.TreeSet;

import org.junit.Test;

public class Problem2 {
	
	//Question:
	/*Find the second least character in a given string
	  Example:
	  Input: "tesla-service" Output: s 
	     a) If there are more than one match, return the last match "aabbccc" -> 'b'
	     b) If there are no second match, return ''*/
	
	/*//Approach
	1. Convert input to character array
	2. Add the character & occurence to map
	3. Add occurences of each character to tree set for maintaining order
	4. Add the elements of set to an input list
	5. Based on the input list size, return output.*/
	
	@Test
	public void eg1() {
		String input="tesla-service";
		System.out.println("Test case 1:"+secondleast(input));
	}
	
	@Test
	public void eg2() {
		String input="Lakshmi";
		System.out.println("Test case 2:"+secondleast(input));
	}
	
	
	private Character secondleast(String input) {
		char[] inputChar= input.toCharArray();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		TreeSet<Integer> inputset= new TreeSet<Integer>();
		List<Integer> inputList= new ArrayList<Integer>();
		List<Character> output= new ArrayList<Character>();
		int val=0;
		
		for (char c : inputChar) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for (Entry<Character, Integer> charat : map.entrySet()) {
			inputset.add(charat.getValue());
		}
		
		inputList.addAll(inputset);
		
		if(inputList.size()>=2) {
			val=inputList.get(1);
		}
		else if(inputList.size()<2) {
			return null;
		}
		
		
		for (Entry<Character, Integer> charat : map.entrySet()) {
			if(charat.getValue()==val) {
				output.add(charat.getKey());
			}
		}
		
		
		return output.get(output.size()-1);
	}
	
	
	/*
	 * Working Solution
	 */
	
	//Pseudo code
	//Brute force:
	//Space complexity: O[1]
	//Time complexity: O[N^2]
		/*
		 * iterate through each element and find the count if count is greater than 1
		 * and less than previous minimum then add it to a variable if no repeating
		 * characters found in the string then return empty character else return the
		 * actual character
		 */

	//Efficient method: Using Map
	//Space complexity: O[N]
	//Time complexity: O[N]
		/*
		 * add each element and its corresponding occurance count to a map loop through
		 * the map and find the key with value greater than 1 but less than other
		 * character count
		 */

		@Test
		public void example1() {
			String inp = "tesla-service";
			System.out.println(leastRepeating(inp));
		}

		@Test
		public void example2() {
			String inp = "paypal";
			System.out.println(leastRepeating(inp));
		}

		@Test
		public void example3() {
			String inp = "abcd";
			System.out.println(leastRepeating(inp));
		}

		@Test
		public void example4() {
			String inp = "aabbcc";
			System.out.println(leastRepeating(inp));
		}

		@Test
		public void example5() {
			String inp = "aaabbccc";
			System.out.println(leastRepeating(inp));
		}

		private String leastRepeating(String input) {
			Map<String, Integer> map = new HashMap<>();
			// Arrays.stream(input.split("")).forEach(s->map.put(s, map.getOrDefault(s,
			// 0)+1));
			for (String s : input.split(""))
				if (input.indexOf(s.charAt(0)) != input.lastIndexOf(s.charAt(0)))
					map.put(s, map.getOrDefault(s, 0) + 1);

			if (map.isEmpty())
				return "";

			int min = Collections.min(map.values());
			List<String> collect = map.entrySet().stream().filter(m -> m.getValue() == min)
					.flatMap(s -> Stream.of(s.getKey())).collect(Collectors.toList());

			return collect.get(collect.size() - 1);
		}

		private char leastRepeating6(String input) {
			char secondLeastChar = 0, leastChar = 0;
			int secondLeast = Integer.MAX_VALUE, least = Integer.MAX_VALUE;

			LinkedHashMap<Character, Integer> counter = new LinkedHashMap<>();

			for (char eachChar : input.toCharArray())
				counter.put(eachChar, counter.getOrDefault(eachChar, 0) + 1);

			for (Entry<Character, Integer> entrySet : counter.entrySet()) {
				int currentValue = entrySet.getValue();
				char currentChar = entrySet.getKey();

				if (currentValue < least) {
					// exiting least to second least
					secondLeastChar = leastChar;
					secondLeast = least;

					// current value set to least set
					least = currentValue;
					leastChar = currentChar;
				} else if (currentValue <= secondLeast && currentValue > least) {
					// current value set to second least set
					secondLeast = currentValue;
					secondLeastChar = currentChar;
				}
			}

			if (secondLeast == Integer.MAX_VALUE)
				return 0;

			return secondLeastChar;
		}

		private char leastRepeating5(String s) {
			System.out.println('a' - '!');
			char res = ' ';
			List<Integer> list = new ArrayList<Integer>();

			int[] asChar = new int[127];

			for (int i = 0; i < s.length(); i++) {
				asChar[s.charAt(i) - '!']++;
				if (asChar[s.charAt(i) - '!'] != 0) {
					list.add(asChar[s.charAt(i) - '!']);
				}

			}
			System.out.println(list);
			return res;
		}

		private String leastRepeating4(String inp) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();

			for (char c : inp.toCharArray())
				if (inp.indexOf(c) != inp.lastIndexOf(c))
					map.put(c, map.getOrDefault(c, 0) + 1);

			if (map.isEmpty())
				return "";

			int min = Collections.min(map.values());
			char c = 0;
			for (Map.Entry<Character, Integer> m : map.entrySet())
				if (m.getValue() == min)
					c = m.getKey();

			return Character.toString(c);
		}

		private String leastRepeating3(String inp) {
			int[] arr = new int[128];

			for (char c : inp.toCharArray())
				if (inp.indexOf(c) != inp.lastIndexOf(c))
					arr[c]++;

			int f = 0, s = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[f] <= arr[i]) {
					s = f;
					f = i;
				} else if (arr[s] <= arr[i] && arr[i] != arr[f])
					s = i;
			}

			if (!inp.contains(Character.toString((char) s)))
				return "There is no second duplicate character";

			return Character.toString((char) s);
		}

		private String leastRepeating2(String inp) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();

			for (char c : inp.toCharArray())
				if (inp.indexOf(c) != inp.lastIndexOf(c))
					map.put(c, map.getOrDefault(c, 0) + 1);

			if (map.isEmpty())
				return "There is no repeating character";

			int i = 0;
			char ch = 0;
			for (char c : inp.toCharArray()) {
				if (inp.indexOf(c) != inp.lastIndexOf(c)) {
					if (i == 0 || i >= map.get(c)) {
						i = map.get(c);
						ch = c;
					}
				}
			}
			return Character.toString(ch);
		}

		private String leastRepeating1(String inp) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : inp.toCharArray())
				if (inp.indexOf(c) != inp.lastIndexOf(c))
					map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.isEmpty())
				return "";

			Object[] array = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.flatMap(m -> Stream.of(m.getKey())).toArray();
			// Object[] array2 =
			// map.entrySet().stream().filter(m->m.getValue()==(map.get(array[0]))).toArray();
			return Character.toString((char) array[0]);
		}

}
