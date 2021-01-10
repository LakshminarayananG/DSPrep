package assessment.week2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class P2_FindUnique {

	@Test
	public void example1() {
		String s1 = "amazon";
		String s2 = "india";
		findUnique(s1, s2);
	}

	@Test
	public void example2() {
		String s1 = "TestLeaf";
		String s2 = "testleaf";
		findUnique(s1, s2);
	}

	@Test
	public void example3() {
		String s1 = "amazon";
		String s2 = "amazon";
		findUnique(s1, s2);
	}

	public void findUnique(String s1, String s2) {

		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		List<Character> list = new ArrayList<>();

		if (s1.equals(s2))
			System.out.println(list);
		else {
			for (char c : s1.toCharArray())
				set1.add(c);

			for (char c : s2.toCharArray())
				set2.add(c);

			for (Character ch : set1)
				if (!set2.contains(ch))
					list.add(ch);
				else
					set2.remove(ch);

			list.addAll(set2);
			System.out.println(list);
		}
	}
}
