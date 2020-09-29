package strings;

import org.junit.Test;

public class RemoveVowels {
	
	
	@Test
	public void e() {
		String sa="Testleaf";
		System.out.println(remove(sa));
	}
	
		
	
	private String remove(String s) {
		return s.replaceAll("[aeiouAEIOU]","");
		
		
	}

}
