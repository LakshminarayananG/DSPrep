package asssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;

public class CommonElements {
	
	/*
	 * Given three Integer arrays arr1, arr2, and arr3 sorted in strictly increasing
	 * order, return a sorted array of only integers that appeared in all three
	 * arrays 
	 Input: 
	 	Arr1=[1,2,3,4,5]; 
	 	Arr2=[1,2,5,7,9]; 
	 	Arr3=[1,3,4,5,8];
	  O/P 
	  	OutputArr=[1,5];
	 */
	
	/* Questions 
	 * 1. Should all the array size be of same size
	 * 2. Can it have negative numbers too
	 * 3. Can it have duplicates
	 * 
	 * 
	 * */
	
	
	@Test
	public void example1() {
		Integer[]arr1= {1,2,3,4,5,16,8,9};
		Integer[]arr2= {1,2,5,7,9,17,11,4};
		Integer[]arr3= {1,3,5,6,8,12,10,9};
		ArrayList<Integer> checkCommonElements = checkCommonElements(arr1, arr2, arr3);
		System.out.println(checkCommonElements);
	}
	
	@Test
	public void example2() {
		Integer[]arr1= {1,2,3,4,5};
		Integer[]arr2= {1,2,5,7,9};
		Integer[]arr3= {1,3,5,6,8};
		ArrayList<Integer> checkCommonElements = checkCommonElements(arr1, arr2, arr3);
		System.out.println(checkCommonElements);
	}
	
	
	@Test
	public void example3() {
		Integer[]arr1= {-7,-3,-2,2,3,4,5};
		Integer[]arr2= {-4,-2,1,1,5,7,9};
		Integer[]arr3= {-2,0,1,3,5,6,8};
		ArrayList<Integer> checkCommonElements = checkCommonElements(arr1, arr2, arr3);
		System.out.println(checkCommonElements);
	}
	
	
	@Test
	public void example4() {
		Integer[]arr1= {-4,-3,-2,2,3,4,8};
		Integer[]arr2= {-4,-2,1,1,5,8,9};
		Integer[]arr3= {-4,0,1,3,5,6,8};
		Object[] checkCommonElements = commonEleSetApproach(arr1, arr2, arr3);
		System.out.println(Arrays.toString(checkCommonElements));
	}
	
	
	
	//Worst brute force technique
	public ArrayList<Integer> checkCommonElements(Integer[]arr1,Integer[]arr2,Integer[]arr3) {
		ArrayList<Integer> commonelements= new ArrayList<Integer>();
		boolean flag=false;
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr2[j]==arr1[i])
				flag=true;
				for(int k=0;k<arr3.length;k++) {
				if(arr3[k]==arr1[i]&&flag==true) {
					commonelements.add(arr3[k]);
					flag=false;
				}
				}
			}
			flag=false;
		}
		return commonelements;
	}
	
	
	//Alternate Approach
	public Object[] commonEleSetApproach(Integer[]arr1,Integer[]arr2,Integer[]arr3) {
		HashSet<Integer> firstSet= new HashSet<Integer>();
		HashSet<Integer> secondSet= new HashSet<Integer>();
		HashSet<Integer> thirdSet= new HashSet<Integer>();
		Collections.addAll(firstSet, arr1);
		Collections.addAll(secondSet, arr2);
		Collections.addAll(thirdSet, arr3);
		firstSet.retainAll(secondSet);
		firstSet.retainAll(thirdSet);
		return firstSet.toArray();
	}

}
