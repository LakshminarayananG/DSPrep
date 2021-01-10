package week15.classwork;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FormatString {

		/*
		 * 1) Write a program that outputs the string representation of numbers from 1
		 * to n. But for multiples of three it should output “Fizz” instead of the
		 * number and for the multiples of five output “Buzz”. For numbers which are
		 * multiples of both three and five output “FizzBuzz”. n = 15, Return: [ "1",
		 * "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz",
		 * "13", "14", "FizzBuzz" ]
		 */
	
		/*
		 * Pseudo code: 1. Iterate from 1 to n 2. Check if the value of n is divisible
		 * by 3 & 5, if so add fizzbuzz to the list 3. If divisible by 5 only, add buzz
		 * and if divisible by 3 add fizz to the list 4. Return the final list
		 */
	
		@Test
		public void eg1() {
			int n = 15;
			System.out.println("Eg 1: " + strRepresentation(n));
		}
	
	// @Test
		public void eg2() {
			int n = 3;
			System.out.println("Eg 2: " + strRepresentation(n));
		}
	
	// @Test
		public void eg3() {
			int n = 30;
			System.out.println("Eg 3: " + strRepresentation(n));
		}

		private List<String> strRepresentation(int n) {
			List<String> output = new ArrayList<String>();
		
			for (int i = 1; i <= n; i++) {
				if (i % 5 == 0 && i % 3 == 0) {
					output.add("FizzBuzz");
				} else if (i % 5 == 0) {
					output.add("Buzz");
				} else if (i % 3 == 0) {
					output.add("Fizz");
				} else {
					output.add(String.valueOf(i));
				}
			}
		
			return output;
		}


}
