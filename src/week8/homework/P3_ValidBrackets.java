package week8.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class P3_ValidBrackets {

	@Test
	public void example1() {
		int k = 3;
		validBrackets(k);
	}

	@Test
	public void example2() {
		int k = 2;
		validBrackets(k);
	}

	@Test
	public void example3() {
		int k = 1;
		validBrackets(k);
	}

	@Test
	public void example4() {
		int k = 5;
		validBrackets(k);
	}

	private void validBrackets(int k) {
		int left = 0, right = 0;
		List<String> genBracket = genBrackets("", left, right, k, new ArrayList<String>());
		System.out.println(genBracket);
	}

	public List<String> genBrackets(String str, int left, int right, int k, List<String> lst) {
		if (left == k && right==k) {
			lst.add(str);
			return lst;
		}

		if (left != k)
			genBrackets(str + "(", left + 1, right, k, lst);
		if (left>right)
			genBrackets(str + ")", left, right + 1, k, lst);

		return lst;
	}
}

/*
 * private void validBrackets(int k) { StringBuilder sb = new StringBuilder("");
 * 
 * for (int i = 0; i < k * 2; i++) sb.append((i < k) ? "(" : ")");
 * 
 * LinkedList<String> list = new LinkedList<String>(); list.add(sb.toString());
 * int ind = k;
 * 
 * while (ind > 0) { sb = new StringBuilder(list.peekLast()); sb.delete(ind - 1,
 * ind + 1); for (int i = 0; i < 2 * k - 1; i++) { sb.insert(i, "()");
 * 
 * if (!list.contains(sb.toString())) list.add(sb.toString());
 * 
 * sb.delete(i, i + 2); } ind--; }
 * 
 * System.out.println(list); }
 * 
 * private void validBrackets1(int k) { StringBuilder sb = new
 * StringBuilder("");
 * 
 * for (int i = 0; i < k * 2; i++) sb.append((i < k) ? "(" : ")");
 * 
 * String br = ""; for (int i = 0; i < k * 2; i++) br += (i % 2 == 0) ? "(" :
 * ")";
 * 
 * LinkedList<String> list = new LinkedList<String>(); list.add(sb.toString());
 * 
 * while (!list.peekLast().equals(br)) { sb = new
 * StringBuilder(list.peekLast()); int ind = sb.lastIndexOf("(");
 * sb.deleteCharAt(ind); sb.insert(ind + 1, "("); list.add(sb.toString());
 * String[] split = sb.reverse().toString().split("");
 * 
 * for (int i = 0; i < split.length; i++) split[i] = (split[i].equals("(")) ?
 * ")" : "(";
 * 
 * if (!String.join("", split).equals(list.peekLast())) list.add(String.join("",
 * split)); }
 * 
 * System.out.println(list); }
 */