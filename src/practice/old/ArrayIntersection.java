package practice.old;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class ArrayIntersection {
	
	@Test
	public void example1() {
	Integer[] firstArray= {1,3,5,4,6,7,9,10,1,5};
	Integer[] secondArray= {0,2,4,8,9,27,4,5,0,2};
	Object[] findIntersection = findIntersection(firstArray, secondArray);
	System.out.println(Arrays.toString(findIntersection));
	}
	
	@Test
	public void example2() {
	Integer[] firstArray= {1,3,5,3,10,0,89,0,-2,5,-1,7,-2};
	Integer[] secondArray= {0,2,4,8,9,27,4,5,0,2,-1};
	Object[] findIntersection = findCommonElements(firstArray, secondArray);
	System.out.println(Arrays.toString(findIntersection));
	
	}
	
	@Test
	public void example3() {
	Integer[] firstArray= {1,3,4,5,7,6,9,19,14,29};
	Integer[] secondArray= {0,2,16,27,51,44,78,90};
	Object[] findIntersection = findIntersection(firstArray, secondArray);
	System.out.println(Arrays.toString(findIntersection));
	
	}
	
	@Test
	public void example4() {
	Integer[] firstArray= {1,1,3,4,5,7,6,9,19,14,29};
	Integer[] secondArray= {1,3,4,5,7,6,9,19,14,29,1};
	Object[] findIntersection = findIntersection(firstArray, secondArray);
	System.out.println(Arrays.toString(findIntersection));
	
	}
	
	private Object[] findIntersection(Integer[] firstArray,Integer[] secondArray) {
		Set<Integer> firstset=new HashSet<Integer>();
		Set<Integer> secondset=new HashSet<Integer>();
		Collections.addAll(firstset, firstArray);
		Collections.addAll(secondset, secondArray);
		firstset.retainAll(secondset);	
		return firstset.toArray();
	}
	
	
	private Object[] findCommonElements(Integer[] firstArray, Integer[] secondArray) {
		Set<Integer> common = new HashSet<Integer>();
		if(firstArray.equals(secondArray)) {
			return firstArray;
		}
		
		for(int i=0;i<firstArray.length;i++) {			
			for (int j = 0; j < secondArray.length; j++) {
				if(firstArray[i]==secondArray[j])
					common.add(firstArray[i]);
			}
		}
		return common.toArray();
	}
	
	

}
