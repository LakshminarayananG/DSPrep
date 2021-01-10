package recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class FindSubstringCount {
	@Test
	public void example1() {
		String s1 = "welcome to world, to do something great to everyone";
		String s2 = "to";
		Assert.assertEquals(3, helperFunc(s1, s2));
	}

	private int helperFunc(String s1, String s2) {
		if(!s1.contains(s2))
			return 0;
		return helperFunc(s1.replaceFirst(s2, ""), s2)+1;
	}
}
