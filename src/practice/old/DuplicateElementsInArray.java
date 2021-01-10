package practice.old;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class DuplicateElementsInArray {
	
	@Test
	public void eg1() {
		int[] input= {1,1,3,4,2,6,7,10,3,44,44};
		System.out.println(dup(input));
	}
	
	

	@Test
	public void eg2() {
		Integer[] input= {1,1,3,4,2,6,7,10,3,44,44};
		System.out.println(dupOtherApp(input));
	}
	
	private Set<Integer> dup(int[] input) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<input.length;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[i]==input[j]) {
					set.add(input[i]);
				}
			}
		}
		
		return set;
	}
	
	
	private Set<Integer> dupOtherApp(Integer[] input) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> dupset = new HashSet<Integer>();
		
		for (Integer integer : input) {
			if(!set.add(integer)) {
				dupset.add(integer);
			}
		}
		return dupset;
	}
	
	

}
