package week15;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class WordsToNumber {

		//@Test
			public void eg1() {
				String input = "Three hundred million seven hundred twenty nine thousand five hundred ninety six";
				System.out.println(determineNumber(input));
			}
		
			@Test
			public void eg2() {
				String input = "Ninety";
				System.out.println(determineNumber(input));
			}
		
			@Test
			public void eg3() {
				String input = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety";
				System.out.println(determineNumber(input));
			}
		
		//if the string contains million/thousand/hundreds
		//Split the string before and after these words
		//Final Result is equal to number equal to the preceding words * million/thousand/hundred+ number equal to the succeeding words
		
			String[] TensListArray = { " ", " ", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
					"ninety" };
			String[] OnesListArray = { " ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
					"elven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
			List<String> TensList = Arrays.asList(TensListArray);
			List<String> OnesList = Arrays.asList(OnesListArray);
		
			private int determineNumber(String input) {
				if (input.length() > 0) {
					String[] inputArray = input.split(" ");
					input = input.toLowerCase();
					return convertToNumber(input);
				}
				throw new RuntimeException("Invalid input");
			}

		private int convertToNumber(String input) {
			if (input.contains("billion")) {
				String[] temp = input.split("billion");
				if (temp.length > 1)
					return convertToNumber(temp[0]) * 1000000000 + convertToNumber(temp[1]);
				else
					return convertToNumber(temp[0]) * 1000000000;
		
			}
		
			if (input.contains("million")) {
				String[] temp = input.split("million");
				if (temp.length > 1)
					return convertToNumber(temp[0]) * 1000000 + convertToNumber(temp[1]);
				else
					return convertToNumber(temp[0]) * 1000000;
		
			}
			if (input.contains("thousand")) {
				String[] temp = input.split("thousand");
				if (temp.length > 1)
					return convertToNumber(temp[0]) * 1000 + convertToNumber(temp[1]);
				else
					return convertToNumber(temp[0]) * 1000;
			}
		
			if (input.contains("hundred")) {
				String[] temp = input.split("hundred");
				if (temp.length > 1)
					return convertToNumber(temp[0]) * 100 + convertToNumber(temp[1]);
				else
					return convertToNumber(temp[0]) * 100;
			}
		
			else if (!input.isEmpty()) {
				int result = 0;
				String[] tempTwo = input.split(" ");
				for (int i = 0; i < tempTwo.length; i++) {
					if (TensList.indexOf(tempTwo[i]) > 0)
						result = result + (TensList.indexOf(tempTwo[i]) * 10);
					else if (OnesList.indexOf(tempTwo[i]) > 0)
						result += OnesList.indexOf(tempTwo[i]);
		
				}
				return result;
			}
		
			throw new RuntimeException("Invalid Input");
		
		}

}