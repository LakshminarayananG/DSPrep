package week16;


import org.junit.Test;


public class FindOddOneOut {
	
	/*
	 * Given a non-empty array of integers nums, every element appears twice except
	 * for one. Find that single one using Binary search.
	 * 
	 * Example 1:	 * 
	 * Input: nums = [3,3,7,7,11] Output: 11 
	 * 
	 * Example 2: 
	 * Input: nums = [3,3,7,7,10,11,11] Output: 10
	 */
	
	
	@Test
	 public void setOne()
	 {
	  int[] input= {2,2,3,3,7,7,11};
	  System.out.println(findDuplicate(input));
	 }
		
	 @Test
	 public void setTwo()
	 {
	  int[] input= {2,2,3,7,7};
	  System.out.println(findDuplicate(input));
	 }
		
	 @Test
	 public void setThree()
	 {
	  int[] input= {2,3,3,7,7,11,11};
	  System.out.println(findDuplicate(input));
	 }
		
	 @Test
	 public void setFour()
	 {
	  int[] input= {2,2,3,7,7,11,11};
	  System.out.println(findDuplicate(input));
	 }
		
	 private int findDuplicate(int[] array)
	 {
	  int low=0;int high=array.length-1;int mid=0;
	  while(low<=high)
	  {
	   mid=(low+high)/2;
	   if((mid==array.length-1||array[mid]!=array[mid+1])&&(mid==0||array[mid]!=array[mid-1])) return array[mid];
	   else if((array[mid]==array[mid+1])&&( (mid-low) %2!=0))
	   {
	    high=mid-1;
	   }
	   else if((array[mid]==array[mid-1])&&( (high-mid) %2!=0)) 
	   low=mid+1;
	   
	  }
	  throw new RuntimeException("No match");
	 }

}
