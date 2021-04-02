package week24.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class WordsToInt {
	List<String> ones = Arrays.asList("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "foruteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
	List<String> tens = Arrays.asList("", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninety");
	Map<String, Integer> currencies = new HashMap<String, Integer>() {
		{
			put("billion", 1000000000);
			put("million", 1000000);
			put("thousand", 1000);
			//put("hundred", 100);
		}
	};

	@Test
	public void example1() {
		String s = "one hundred twenty three";
		System.out.println(convertCurrency(s));
	}

	@Test
	public void example2() {
		String s = "one million two hundred thirty four thousand five hundred sixty seven";
		System.out.println(convertCurrency(s));
	}

	@Test
	public void example3() {
		String s = "one billion eleven";
		System.out.println(convertCurrency(s));
	}

	@Test
	public void example4() {
		String s = "one million";
		System.out.println(convertCurrency(s));
	}
	
	private int convertCurrency(String s) {
		String output="";
		int converted=0;
		for (String str:s.split(" ")) {
			if(str=="hundred")
				continue;
			if(ones.contains(str))
				output=output+Integer.toString(ones.indexOf(str));
			else if(tens.contains(str))
				output=output+Integer.toString(tens.indexOf(str));
			else if(currencies.containsKey(str)){
				converted+=(Integer.valueOf(output)*currencies.get(str));
				output="";
			}
		}
		
		if(output!="")
			converted+=Integer.valueOf(output);

		return converted;
	}
	
	private int convertCurrency1(String s) {
		String[] split = s.split(" ");
		int finalAmount = 0;
		int temp=0;
		for (String str : split) {
			if (currencies.containsKey(str)) {
				finalAmount *= currencies.get(str);
			} else {
				if (ones.contains(str))
					finalAmount += ones.indexOf(str);
				else if (tens.contains(str))
					finalAmount += (tens.indexOf(str)) * 10;
			}
		}

		return finalAmount;
	}
}
