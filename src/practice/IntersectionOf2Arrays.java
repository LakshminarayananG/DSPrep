package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class IntersectionOf2Arrays {
	
	@Test
	public void eg1() {
		int[] arr1= {1,2,5,4};
		int[] arr2= {2,4,7,9};
		System.out.println(inter(arr1, arr2));
	}
	
	
	@Test
	public void eg2() {
		Integer[] arr1= {1,2,5,4};
		Integer[] arr2= {2,4,7,9};
		System.out.println(intersection(arr1, arr2));
	}
	
	
	@Test
	public void eg3() {
		int[] arr1= {1,2,5,4};
		int[] arr2= {2,4,7,9};
		System.out.println(intersectionotherapp(arr1, arr2));
	}
	
	private Set<Integer> inter(int[] arr1, int[] arr2) {
		Set<Integer> set= new HashSet<Integer>();
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					set.add(arr1[i]);
				}
			}
		}
		
		return set;
	}
	
	private Set<Integer> intersection(Integer[] arr1, Integer[] arr2) {
		Set<Integer> set1= new HashSet<Integer>();
		Set<Integer> set2= new HashSet<Integer>();
		Collections.addAll(set1, arr1);
		Collections.addAll(set2, arr2);
		set1.retainAll(set2);
		return set1;
		
	}
	
	
	private List<Integer> intersectionotherapp(int[] arr1, int[] arr2) {
		Set<Integer> set1= new HashSet<Integer>();
		
		for (Integer integer : arr1) {
			set1.add(integer);
		}
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (Integer integer : arr2) {
			if(set1.contains(integer)) {
				list.add(integer);
				set1.remove(integer);
			}
		}
		
		return list;
		
		
	}

}
