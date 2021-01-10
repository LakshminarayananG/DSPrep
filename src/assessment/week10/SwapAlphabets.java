package assessment.week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;



/*
Given a String which contains same set of alphabets in both upper and lower case
swap the alphabets to get the alphabets of both cases to appear together.
Retain the order of first occurrence of any alphabet.
*/
//result should be in set of characters. if no set then don't show in result
//duplicates should be removed
public class SwapAlphabets {

	@Test
	public void example1() {
		String inp = "BdAcbCaD"; // BbdDAacC
		System.out.println(swapAlphabets(inp));
	}

	@Test
	public void example2() {
		String inp = "BdcbCaD";
		System.out.println(swapAlphabets(inp));
	}

	@Test
	public void example3() {
		String inp = "BdcbACbaDB";
		System.out.println(swapAlphabets(inp));
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
	
	private String swapAlphabets4(String inp) {
		List<String> lst = new ArrayList<String>();

		for (String s : inp.split("")) {
			String c = Character.isUpperCase(s.charAt(0)) ? s.toLowerCase() : s.toUpperCase();
			if (lst.contains(c)) {
				int i = lst.indexOf(c);
				lst.remove(i);
				lst.add(i, c + s);
			} else {
				lst.add(s);
			}
		}

		return String.join("", lst);
	}

	private String swapAlphabets1(String inp) {
		List<String> all = new ArrayList<String>();
		List<String> unique = new ArrayList<String>();

		String op = "";

		for (String s : inp.split("")) {
			all.add(s);
			if (!unique.contains(s.toLowerCase()) && !unique.contains(s.toUpperCase()))
				unique.add(s);
		}

		for (String s : unique) {
			String t = Character.isUpperCase(s.charAt(0)) ? s.toLowerCase() : s.toUpperCase();
			if (all.contains(t)) {
				op = op.concat(s).concat(t);
				all.remove(t);
			} //else
				//op = op.concat(s);
		}

		return op;
	}

	private String swapAlphabets2(String inp) {
		if (inp.length() == 0 || inp.length() == 1 || inp == null)
			return inp;

		StringBuilder sb = new StringBuilder(inp);

		for (int i = 0; i < inp.length(); i++) {
			char c = Character.isUpperCase(sb.charAt(i)) ? Character.toLowerCase(sb.charAt(i))
					: Character.toUpperCase(sb.charAt(i));
			for (int j = i + 1; j < inp.length(); j++) {
				if (sb.charAt(j) == c) {
					sb.deleteCharAt(j);
					sb.insert(i + 1, c);
					i++;
					break;
				}
			}
		}

		return sb.toString();
	}

	// Not working
	private String swapAlphabets3(String inp) {
		String s = "";
		List<Character> list = new ArrayList<Character>();

		for (char c : inp.toCharArray()) {
			char chr = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);

			if (list.contains((Character) chr)) {
				s += Character.toString(chr) + Character.toString(c);
				list.remove((Character) chr);
			} //else {
				//list.add(c);
			//}
		}
		return s;
	}

}