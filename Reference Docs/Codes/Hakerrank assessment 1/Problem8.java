package job;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem8 {

	public static int shortestSubstring(String givenString) {
		
        int first = 0, last = 0;
        int shortest = Integer.MAX_VALUE;
        char[] charArray = givenString.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

		Set<Character> unique = new HashSet<Character>();
		for (int i = 0; i < givenString.length(); i++) {
			unique.add(givenString.charAt(i));
		}
		
        while (charArray.length > last) {
            map.put(charArray[last], map.getOrDefault(charArray[last++], 0) + 1);
            if (map.keySet().equals(unique)) {
                shortest = Math.min(shortest, givenString.substring(first, last).length());
                last = ++first;
                map.clear();
            }
        }        
        return shortest;
	}

	public static void main(String[] args) {
		String str = "dabbcabcd";
		System.out.println(shortestSubstring(str));
	}


}
