package week17.weekwork;

import org.junit.Test;

public class ClosestPrimeNumber {
	
	/*
	 * Given an Integer, return the closest prime number to it
	 */
	
	/*
	 * declare 2 varaibles front=num-1, back=num+1
	if front is a prime return the front break else if not prime front--, 
	if back is prime return back break else if not prime back++
	 */
	
	@Test
	public void eg1() {
		int num=73;
		System.out.println(closestPrime(num));
	}
	
	
	public int closestPrime(int n) {

		int front = n - 1, back = n + 1;
		int output = 0;
		if (isPrime(n))
			return n;
		while (n > 0) {
			if (isPrime(front)) {
				output = front;
				break;
			} else {
				front--;
			}
			if (isPrime(back)) {
				output = back;
				break;
			} else {
				back++;
			}
		}
		return output;
	}
	
	public boolean isPrime(int num){
		for(int i =2; i<=Math.sqrt(num); i ++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}

}
