package week15;

import org.junit.Test;

public class IntegerToString {

	public String[] ones = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	public String[] Tens = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	@Test
	public void eg1() {
		int input = 1000000;
		System.out.println(numtowords(input));
	}

	@Test
	public void eg2() {
		int input = 123;
		System.out.println(numtowords(input));
	}

	@Test
	public void eg3() {
		int input = 1234567890;
		System.out.println(numtowords(input));
	}

	private String numtowords(int num) {
		if (num == 0)
			return "Zero";
		if (num < 0)
			return "Invalid Input";
		return recursive(num).trim();
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
	
	
	
}
