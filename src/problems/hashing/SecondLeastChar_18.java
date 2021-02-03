package problems.hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;



public class SecondLeastChar_18 {
	
	/*
	Find the second least character in a given string
	  Example:
	  Input: "tesla-service" Output: s 
	     a) If there are more than one match, return the last match "aabbccc" -> 'b'
	     b) If there are no second match, return ''
	*/

	@Test
	public void example1() {
		String inp = "tesla-service";
		Assert.assertEquals("s", leastRepeating(inp));
	}

	@Test
	public void example2() {
		String inp = "paypal";
		Assert.assertEquals("a", leastRepeating(inp));
	}

	@Test
	public void example3() {
		String inp = "abcd";
		Assert.assertEquals("", leastRepeating(inp));
	}

	@Test
	public void example4() {
		String inp = "aabbcc";
		Assert.assertEquals("c", leastRepeating(inp));
	}

	@Test
	public void example5() {
		String inp = "aaabbccc";
		Assert.assertEquals("b", leastRepeating(inp));
	}

	private String leastRepeating(String input) {
		Map<String, Integer> map = new HashMap<>();
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
}
