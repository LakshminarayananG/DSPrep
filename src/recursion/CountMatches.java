package recursion;

import org.junit.Assert;
import org.junit.Test;

public class CountMatches {
	int match = 0;

	@Test
	public void example1() {
		int n = 2;
		numberOfMatches(n);
		Assert.assertEquals(1, match);
	}

	@Test
	public void example2() {
		int n = 3;
		numberOfMatches(n);
		Assert.assertEquals(2, match);
	}

	@Test
	public void example3() {
		int n = 6;
		numberOfMatches(n);
		Assert.assertEquals(5, match);
	}
	
	@Test
	public void example4() {
		int n = 5;
		numberOfMatches(n);
		Assert.assertEquals(4, match);
	}
	
	@Test
	public void example5() {
		int n = 1;
		numberOfMatches(n);
		Assert.assertEquals(0, match);
	}

	private void numberOfMatches(int n) {
		if (n < 2)
			return;

		match += n / 2;

		if (n % 2 == 0)
			numberOfMatches(n / 2);
		else
			numberOfMatches(n / 2 + 1);
	}
}
