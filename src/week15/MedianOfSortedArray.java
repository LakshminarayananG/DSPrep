package week15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import org.junit.Test;

public class MedianOfSortedArray {
	
	@Test
	public void example1() {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example2() {
		int[] nums1 = { 4, 20, 32, 50, 55, 61 };
		int[] nums2 = { 1, 15, 22, 30, 70 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example3() {
		int[] nums1 = { 16, 20, 23, 50, 54, 60 };
		int[] nums2 = { 65, 72, 72, 85, 93 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example4() {
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		findMedian(nums1, nums2);
	}

	@Test
	public void example5() {
		int[] nums1 = {};
		int[] nums2 = { 1 };
		findMedian(nums1, nums2);
	}

	private void findMedian(int[] nums1, int[] nums2) {
		int nums1Len = nums1.length;
		int nums2Len = nums2.length;

		int[] merged = new int[nums1Len + nums2Len];

		int mergLen = merged.length;
		int ind = 0, p1 = 0, p2 = 0;

		while (ind < mergLen && p1 < nums1Len && p2 < nums2Len) {
			if (nums1[p1] < nums2[p2])
				merged[ind++] = nums1[p1++];
			else
				merged[ind++] = nums2[p2++];
		}

		if (p1 < nums1Len)
			for (int i = p1; i < nums1Len; i++)
				merged[ind++] = nums1[i];
		else
			for (int i = p2; i < nums2Len; i++)
				merged[ind++] = nums2[i];

		if (mergLen % 2 != 0)
			System.out.println(merged[mergLen / 2]);
		else
			System.out.println((double) (merged[mergLen / 2] + merged[(mergLen / 2) - 1]) / 2);

		System.out.println(Arrays.toString(merged));
	}
	
	
	
	//Solution 1

		//1. Create a new Array of length equal to the length of array One and Array Two
		//2. Loop through the first array and add all elements to the new array
		//3. Loop through the second array and add all elements to the new array
		//4.sort the array
		//5. Determine the length of temp array
		//6.if odd, return n/2
		//7.if even return (n/2+(n+1)/2)2, where n is the element at the respective index

		private float findMedian1(int[] arrayOne,int[] arrayTwo)
		{
			List<Integer>arrayThree=new ArrayList<>();
			float sum=0;
			for(int i=0;i<arrayOne.length;i++)//O[N]
			{
				arrayThree.add(arrayOne[i])	;	
			}
			for(int i=0;i<arrayTwo.length;i++)//O[N]
			{
				arrayThree.add(arrayTwo[i]);
			}
			Collections.sort(arrayThree);//O[nlogn]
			
			int midSize=arrayThree.size()/2;//O[1]

			if(arrayThree.size()%2==0)//O[1]
			{
				return (arrayThree.get(midSize-1)+arrayThree.get(midSize))/2;
			}
			else
			{
				return arrayThree.get(midSize);
			}
			//Total time Complexity=O[nlogn]

		}

		//Solution 2
		//1.Merge the two Sorted array
		//Assign a pointer and loop array one form 0->last
		//Assign another pointer and another array from 0->last
		//compare the elements from both arrays and put the lowest in a temp array and increment the respective pointer
		//Continue loop till the length of the smallest array
		//And the remaining element of the largest number to the temp Array
		
		//2.Determine the length of temp array
		//if odd, return n/2
		//if even return (n/2+(n+1)/2)2, where n is the element at the respective index
		
		private double findMedian2(int[] arrayOne,int[] arrayTwo)
		{
			List<Integer>arrayThree=new ArrayList<>();//O[1]
			int i=0;int j=0;int absoluteOne=0;int absolutetwo=0;

			//Merging two sorted array to get a sorted list
			while(i<arrayOne.length&&j<arrayTwo.length)//O[N]or[O[M]
			{
				absoluteOne=Math.abs(arrayOne[i]);
				absolutetwo=Math.abs(arrayTwo[j]);
				if(absoluteOne==absolutetwo)
				{
					arrayThree.add(arrayOne[i]);
					arrayThree.add(arrayTwo[j]);
					i++;j++;
				}
				else if(absoluteOne<absolutetwo)
				{
					arrayThree.add(arrayOne[i]);
					i++;
				}
				else
				{
					arrayThree.add(arrayTwo[j]);
					j++;
				}
			}
			
			//To put the remaining elemnts of longer array
			
			for(;i<arrayOne.length;i++)//O[N-M]
			{
				arrayThree.add(Math.abs(arrayOne[i]));
			}


			for(;j<arrayTwo.length;j++)//O[M-N]
			{
				arrayThree.add(Math.abs(arrayTwo[j]));
			}
			
			//To find the median

			int midSize=arrayThree.size()/2;//O[1]

			if(arrayThree.size()%2==0)//O[1]
			{
				return(double) (arrayThree.get(midSize-1)+arrayThree.get(midSize))/2;
			}
			else
			{
				return (double) arrayThree.get(midSize);
			}

		}

}
