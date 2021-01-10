package week2.StringsAndArrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class P1_PrimeNumber {

	@Test
	public void example1() {
		int num = 111111;
		//boolean primeNumber = primeNumber(num);
		//System.out.println(primeNumber);
		checkPrime(num);
	}
	
	@Test
	public void example2() {
		int num = 38;
		checkPrime(num);
	}
	
	@Test
	public void example3() {
		int num = 403198305;
		checkPrime(num);
	}
	
	@Test
	public void example4() {
		int num = 444444;
		checkPrime(num);
	}
	
	@Test
	public void example5() {
		int num = 23;
		checkPrime(num);
	}

	private void checkPrime1(int num) {
		String string = Integer.toString(num);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j <= string.length(); j++) {
				int val=Integer.parseInt(string.substring(i, j));
				if (primeNumber(val))
					set.add(val);
			}
		}
		System.out.println(set);
	}
	
	private void checkPrime(int num) {
		String string = Integer.toString(num);
		Set<Integer> set=new HashSet<>();
		int start=0,end=start+1;
		while(start<string.length()) {
			int numb=Integer.parseInt(string.substring(start, end++));
			if(primeNumber(numb))
				set.add(numb);
			
			if(end>string.length()) {
				start++;
				end=start+1;
			}
		}
		System.out.println(set);
	}

	public boolean primeNumber(int num) {
		if (num == 0 || num == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	
	private Set<Integer> getSubString(String input) {
		List<Integer> subStringList = new ArrayList<Integer>();
		Set<Integer> outputList = new HashSet<Integer>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String subString = input.subSequence(i, j).toString();
				subStringList.add(Integer.parseInt(subString));
			}
		}
		
		for (Integer integer : subStringList) {
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
