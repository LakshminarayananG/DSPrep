package week18.weekwork;

import org.junit.Test;

public class IntegerToEnglishWords {
	
	/*
	 * Convert a non-negative integer num to its English words representation.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: num = 123 Output: "One Hundred Twenty Three" Example 2:
	 * 
	 * Input: num = 12345 Output: "Twelve Thousand Three Hundred Forty Five" Example
	 * 3:
	 * 
	 * Input: num = 1234567 Output:
	 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
	 * Example 4:
	 * 
	 * Input: num = 1234567891 Output:
	 * "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
	 * 
	 * 
	 * Constraints:
	 * 
	 * 0 <= num <= 231 - 1
	 */
	
	
	/*
	 * Using Recursion
	 * 1. Declare string array from one to 19 for ones
	 * 2. Declare another string array for tens from ten to ninenty
	 * 3. Based on the number, recursively add to output string 
	 */
	
	public String[] ones = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
			"Eighteen","Nineteen" };

	public String[] Tens = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
			"Eighty","Ninety" };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		if (num < 0)
			return "Invalid Input";
		return (recursive(num).trim().replaceAll("\\s+", " "));
	}

	private String recursive(int num) {
		if (num >= 1000000000)
			return recursive(num / 1000000000) + "Billion " + recursive(num % 1000000000);
		if (num >= 1000000)
			return recursive(num / 1000000) + "Million " + recursive(num % 1000000);
		if (num >= 1000)
			return recursive(num / 1000) + "Thousand " + recursive(num % 1000);
		if (num >= 100)
			return recursive(num / 100) + "Hundred " + recursive(num % 100);
		if (num >= 20)
			return Tens[num / 10] + " " + recursive(num % 10);
		return ones[num] + " ";
	}
		
	
	@Test
	public void eg1() {
		int num=12345;
		System.out.println(numberToWords(num));
	}
		
		

}