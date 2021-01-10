package assessment.week16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Counting_Pairs {
	
	/*
	 * Given an integer k and a list of integersm count the number of distinct valid pairs of integers (a,b)
	 * in the list for which a+k=b. Two pairs of integers (a,b) and (c,d) are considered distinct if atleast
	 * one element of (a,b) does not also belong to (c,d)
	 * 
	 * Example:
	 * n=4
	 * numbers=[1,1,1,2]
	 * k=1
	 * 
	 * The array has two different valid pairs (1,1) and (1,2) for k=1, there is only 1 valid pair which 
	 * satisfies a+k=b, the pair (a,b) =(1,2)
	 */
	
	/*
	 * Approach Using 2 Pointers
	 * 1. Convert the input list to a set and sort it
	 * 2. Iterate through the list
	 * 3. Declare 2 variables left,right=0
	 * 4. Iterate until right<= list size
	 * 5. If list.get[right] - list.get[left] =k, increment counter, left & right
	 * 6. If list.get[right] - list.get[left] <k, increment right
	 * 7. Else increment left
	 * 8. return counter
	 */
	
	@Test
	public void eg1() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,1,1,2));
		int k=1;
		System.out.println(countPairs(list, k));
	}
	
	@Test
	public void eg2() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		int k=2;
		System.out.println(countPair(list, k));
	}
	
	private int countPairs(List<Integer> list, int k ) {
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(list);
		List<Integer> oplist = new ArrayList<Integer>();
		oplist.addAll(set);
		Collections.sort(oplist);
		int left=0, right=0, count=0;
		while(right<=oplist.size()-1) {
			if(oplist.get(right)-oplist.get(left)==k) {
				count++;
				left++;
				right++;
			}
			else if(oplist.get(right)-oplist.get(left)<k) {
				right++;
			}
			else {
				left++;
			}
		}
		return count;
		
	}
	
	
	private int countPair(List<Integer> list, int k) {
		int count = 0;
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        for (Integer integer : list) {
            if (set.contains(integer + k)) {
                count++;
                set.remove(integer+k);
            }
        }
        return count;

    
	}

}
