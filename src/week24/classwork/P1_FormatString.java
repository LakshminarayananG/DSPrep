package week24.classwork;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
n = 15,
Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/
public class P1_FormatString {

	@Test
	public void example1() {
		int n=15;
		System.out.println(formatString(n));
	}
	
	@Test
	public void example2() {
		int n=5;
		System.out.println(formatString(n));
	}
	
	@Test
	public void example3() {
		int n=-1;
		System.out.println(formatString(n));
	}
	
	//Pseudo Code
	/*
	 * check the int value as it should be greater than 1
	 * initialize a for loop for range 1 to n
	 * if the current index is only divisible by 3 add it as fizz
	 * or if current index value is only divisible by 5 add it as buzz
	 * if current index value is divisible by both 5 and 3 add it as fizz buzz
	 * if none of the above condition pass, add the current index directly to list
	 */
	//Space complexity: O[N]
	//Time complexity: O[N]
	
	private List<String> formatString(int n) {
		if(n<1)
			throw new RuntimeException("invalid input");
		
		List<String> output=new ArrayList<>();
		
		for (int ind = 1; ind <=n; ind++) {
			if(ind%3==0 && ind%5==0)
				output.add("fizzbuzz");
			else if(ind%3==0)
				output.add("fizz");
			else if(ind%5==0)
				output.add("buzz");
			else
				output.add(""+ind);
		}
		
		return output;
	}
}
