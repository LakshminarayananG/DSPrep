package problems.hashing;


import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;




public class SwapAlphabet_17 {
	
	/*
	Given a string which contains same set of alphabets in both upper and lower case, swap the alphabets to get the alphabets of both the cases to appear together. Retain the order of first occurrence of any alphabet.
	e.g.: 
	Input: BdAcbCaD
	Output: BbdDAacC
	*/

	@Test
	public void example1() {
		String inp = "BdAcbCaD";
		Assert.assertEquals("BbdDAacC", swapAlphabets(inp));
	}

	@Test
	public void example2() {
		String inp = "BdcbCaDA";
		Assert.assertEquals("BbdDcCaA", swapAlphabets(inp));
	}

	@Test
	public void example3() {
		String inp = "BdcbACbaDB";
		Assert.assertEquals("BbdDcCAa", swapAlphabets(inp));
	}
	
	private String swapAlphabets(String inp) {
		String returnStr="";
		Set<Character> set=new LinkedHashSet<>();
		for (int i = 0; i < inp.length(); i++) {
			boolean add=set.add(inp.charAt(i));
			if(add) returnStr+=Character.toString(inp.charAt(i));
			
			if(Character.isUpperCase(inp.charAt(i))) {
				add=set.add(Character.toLowerCase(inp.charAt(i)));
				if(add) returnStr+=Character.toString(Character.toLowerCase(inp.charAt(i)));
			}else {
				add=set.add(Character.toUpperCase(inp.charAt(i)));
				if(add) returnStr+=Character.toString(Character.toUpperCase(inp.charAt(i)));
			}
		}
		
		return returnStr;
	}
}