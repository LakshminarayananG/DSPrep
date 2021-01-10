package week15.classwork;

import org.junit.Test;

public class IntegerToRoman {

	/*
	* Similar approach to Integer to words
	* Defining the ones, tens, hundreds and 1000's
	* Since number is <4000, recursively divide it based on the value (>10 or 100 or 1000) and assign
	* number to be remainder of num % (10 or 100 or 1000) and finally return the roman value
	*/

	public String [] Thousands= {"","M","MM","MMM"};
	public String [] Hundreds= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	public String[] Tens= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	public String[] Ones= {"","I","II","III","IV","V","VI","VII","VIII","IX"};

	@Test
	public void eg1() {
	int num=1;
	System.out.println("Eg 1 : "+intToRoman(num));
	}


	@Test
	public void eg2() {
	int num=1000;
	System.out.println("Eg 2 : "+intToRoman(num));
	}

	@Test
	public void eg3() {
	int num=899;
	System.out.println("Eg 3 : "+intToRoman(num));
	}

	@Test
	public void eg4() {
	int num=3999;
	System.out.println("Eg 4 : "+intToRoman(num));
	}

	@Test
	public void eg5() {
	int num=0;
	System.out.println("Eg 5 : "+intToRoman(num));
	}

	@Test
	public void eg6() {
	int num=58;
	System.out.println("Eg 6 : "+intToRoman(num));
	}

	@Test
	public void eg7() {
	int num=1994;
	System.out.println("Eg 7 : "+intToRoman(num));
	}


	private String intToRoman(int num) {
	if(num==0) return "zero";
	if(num<0 || num >3999) return "Invalid Input";
	return recursive(num);
	}


	private String recursive(int num) {
	if(num>=1000) return Thousands[num/1000] + recursive(num%1000);
	if(num>=100) return Hundreds[num/100] + recursive(num%100);
	if(num>=10) return Tens[num/10] +recursive(num%10);
	return Ones[num];
	}
}
