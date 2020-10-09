package assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class PossiblePrime {
	
	@Test
	public void eg1() {
		int num=703198305;
		Set<Integer>output=listOfPrime(num);
		System.out.println(output);
	}
	
	@Test
	public void testSet1() {
		int input = 8713;
		System.out.println(listOfPrime(input));
		System.out.println(getPrime(input));
	}
	
	
	@Test
	public void testSet3() {
		int input = 44;
		System.out.println(listOfPrime(input));
		System.out.println(getPrime(input));
	}
	
	
	
	
	//Brute Force APproach
	/*
	 * 1. COnvert the given number into a string 
	 * 2. Declare an array list to store all combinations of prime numbers 
	 * 3. Iterate through the string length through the first for loop 
	 * 4. Iterate through the sub string in inner for loop to get list of numbers 
	 * 5. Check if the number is prime and if it is, add the number to the list
	 */
	
	
	private Set<Integer> listOfPrime(int num) {
		String s = Integer.toString(num);
		List<Integer> input = new ArrayList<Integer>();
		Set<Integer> output = new HashSet<Integer>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				input.add(Integer.parseInt(s.substring(i, j + 1)));
			}
		}

		for (Integer integer : input) {
			boolean flag = true;
			if (!(integer < 2)) {
				for (int i = 2; i<=integer / 2; i++) {
					if (integer % i == 0) {
						flag = false;
					}
				}
				if (flag == true) {
					output.add(integer);
				}
			}
		}

		return output;
	}
	
	
	
	private Set<Integer> getPrime(int number){
		List<Integer> inputList = new ArrayList<Integer>();
		Set<Integer> outputList = new HashSet<Integer>();
		
		int temp;
		int count = 0;
		temp = number;
		
		while(temp != 0){
			temp = temp / 10;
            ++count;
        }
		
		int[] inputArray = new int[count];
		temp = number;
		
		for (int i = count-1; i >= 0; i--) {
			inputArray[i] = temp % 10;
			temp = temp / 10;
		}

		temp = number;
        for (int i = 0; i < inputArray.length; i++) {
        	int divisor = (int) Math.pow(10, count-1);
        	int lclDivisor = divisor;
        	for (int j = 0; j < inputArray.length -i; j++) {	
    			inputList.add(temp/lclDivisor);
    			lclDivisor = lclDivisor/10;
			}
        	temp = temp % divisor;
			count --;			
		}
        
        for (Integer integer : inputList) {
			boolean isLoopContinue = true;
			if (!(integer < 2)) {
				for (int i = 2; i <= integer / 2; i++) {
					if(integer%i == 0) {
						isLoopContinue = false;
						break;
					}
				}
				if(isLoopContinue) 
				outputList.add(integer);
			}
		}
		return outputList;
	
	}
	
	
			
		
	
	
}
