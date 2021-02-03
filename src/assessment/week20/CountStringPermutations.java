package assessment.week20;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CountStringPermutations {

	@Test
	public void example0() {
		int n = 0;
		Assert.assertEquals(0, getPermutationsCount(n));
	}

	@Test
	public void example1() {
		int n = 1;
		Assert.assertEquals(5, getPermutationsCount(n));
	}

	@Test
	public void example2() {
		int n = 2;
		Assert.assertEquals(10, getPermutationsCount(n));
	}

	@Test
	public void example3() {
		int n = 3;
		Assert.assertEquals(19, getPermutationsCount(n));
	}

	@Test
	public void example4() {
		int n = 4;
		Assert.assertEquals(35, getPermutationsCount(n));
	}

	private int getPermutationsCount(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 5;

		Map<Character, Integer> freqMap = new HashMap<>();
		freqMap.put('a', 1);
		freqMap.put('e', 1);
		freqMap.put('i', 1);
		freqMap.put('o', 1);
		freqMap.put('u', 1);

		Map<Character, char[]> matchMap = new HashMap<>();
		matchMap.put('a', new char[] { 'e' });
		matchMap.put('e', new char[] { 'a', 'i' });
		matchMap.put('i', new char[] { 'a', 'e', 'o', 'u' });
		matchMap.put('o', new char[] { 'i', 'u' });
		matchMap.put('u', new char[] { 'a' });

		for (int i = 2; i <= n; i++) {
			Map<Character, Integer> freqMapNew = new HashMap<>();
			for (Character ch : "aeiou".toCharArray()) {
				int count = freqMap.get(ch);
				for (Character ch1 : matchMap.get(ch)) {
					freqMapNew.put(ch1, (freqMapNew.getOrDefault(ch1, 0) + count) % 1000000007);
				}
			}
			freqMap = new HashMap<>(freqMapNew);
		}

		int res = 0;
		for (int freq : freqMap.values()) {
			res = (res + freq) % 1000000007;
		}

		return res;
	}
}
