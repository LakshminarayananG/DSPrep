package week3.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class FindPermutations {

	@Test
	public void example1() {
		String input = "aac";
		findPermutation(input);
		permutations(input);
	}
	
	private void permutations(String input) {
		char[] cArr=input.toCharArray();
		List<String> result=new ArrayList<String>();
		recursion(cArr, result, 0);
		System.out.println(result);
	}
	
	private void recursion(char[] cArr,List<String> result,int start) {
		
		if(start==cArr.length) {
			String val = String.valueOf(cArr);
			if(!result.contains(val))
				result.add(val);
			return;
		}
		
		for (int i = start; i < cArr.length; i++) {
			swap(cArr, start, i);
			recursion(cArr, result, start+1);
			swap(cArr, start, i);
		}
	}
	
	private void swap(char[] cArr,int left,int right) {
		char temp=cArr[left];
		cArr[left]=cArr[right];
		cArr[right]=temp;
		return;
	}
	
	private void findPermutation1(String input) {
		StringBuilder sb = new StringBuilder(input);
		StringBuilder sbr = new StringBuilder(input).reverse();

		Set<String> set = new HashSet<String>();

		for (int i = 0; i < input.length(); i++) {
			sb.deleteCharAt(i);
			sbr.deleteCharAt(i);

			for (int j = 0; j < input.length(); j++) {
				sb.insert(j, input.charAt(i));
				sbr.insert(j, input.charAt(input.length() - i - 1));

				set.add(sb.toString());
				set.add(sbr.toString());

				sb.deleteCharAt(j);
				sbr.deleteCharAt(j);
			}
			sb.insert(i, input.charAt(i));
			sbr.insert(i, input.charAt(input.length() - i - 1));
		}

		System.out.println(set);
	}

	private void findPermutation3(String input) {
		StringBuilder sb;
		Set<String> set = new HashSet<String>();
		int len = input.length();
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			sb = new StringBuilder(input);
			sb.deleteCharAt(i).insert(0, input.charAt(i));
			for (int j = 0; j < len; j++) {
				char c = sb.charAt(0);
				sb.deleteCharAt(0);
				for (int k = 0; k < len; k++) {
					sb.insert(k, c);
					set.add(sb.reverse().toString());
					set.add(sb.reverse().toString());
					sb.deleteCharAt(k);
					cnt++;
				}
				sb.insert(len - 1, c);
			}
		}
		System.out.println(set);
		System.out.println(cnt);
	}

	private void findPermutation(String input) {
		StringBuilder sb;
		Set<String> set = new HashSet<String>();
		int len = input.length();

		for (int i = 0; i < len; i++) {
			sb = new StringBuilder(input);
			sb.deleteCharAt(i).insert(0, input.charAt(i));
			for (int j = 0; j < len-1; j++) {
				char c = sb.charAt(1);
				for (int k = 2; k < len; k++) {
					sb.deleteCharAt(k - 1);
					sb.insert(k, c);
					set.add(sb.toString());
				}
			}
		}
		System.out.println(set);
	}
}
