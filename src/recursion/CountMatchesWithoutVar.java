package recursion;

import org.junit.Assert;
import org.junit.Test;

public class CountMatchesWithoutVar {

	@Test
	public void example1() {
		int n = 2;
		numberOfMatches(n);
		Assert.assertEquals(1, numberOfMatches(n));
	}

	@Test
	public void example2() {
		int n = 3;
		numberOfMatches(n);
		Assert.assertEquals(2, numberOfMatches(n));
	}

	@Test
	public void example3() {
		int n = 6;
		numberOfMatches(n);
		Assert.assertEquals(5, numberOfMatches(n));
	}

	@Test
	public void example4() {
		int n = 5;
		numberOfMatches(n);
		Assert.assertEquals(4, numberOfMatches(n));
	}

	@Test
	public void example5() {
		int n = 1;
		numberOfMatches(n);
		Assert.assertEquals(0, numberOfMatches(n));
	}

	private int numberOfMatches(int n) {
		return helperFunc(n);
	}

	private int helperFunc(int n) {
		if (n < 2)
			return 0;

		if (n % 2 == 0)
			return helperFunc(n / 2) + n / 2;
		else
			return helperFunc(n / 2 + 1) + n / 2;
	}
}
