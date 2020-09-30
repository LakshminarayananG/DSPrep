package assignments;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
	
	public class MedianOfArray {
	
	// Given two sorted arrays A1, A2. Write a code to find median of the arrays
	//
	// Example 1:
	//
	// Input:
	//
	// A1 = [1,3]
	// A2 = [2]
	//
	// Output: 2
	//
	// Example 2:
	//
	// Input:
	//
	// A1 = [1,2]
	// A2 = [3,4]
	//
	// Output: 2.5
	
	
	//Median-Sum of all numbers/Total Number of numbers
	//Also equal to n+1/2(middle number) or n+(n+1)/2 (average of middle numbers), if the numbers are sorted.
	//DataSets
	@Test
	public void eg1() {
		int[] inputOne = { 1, 3 };
		int[] inputTwo = { 2 };
		System.out.println("One: " + String.format("%.2f", findMedian1(inputOne, inputTwo)));
	}

	@Test
	public void eg2() {
		int[] inputOne = { 1, 2 };
		int[] inputTwo = { 3, 4 };
		System.out.println("Two: " + String.format("%.2f", findMedian1(inputOne, inputTwo)));
	}

	@Test
	public void eg3() {
		int[] inputOne = { 1, 2, 7, 9, 10 };
		int[] inputTwo = { 3, 4, 11, 56, 88, 90 };
		System.out.println("Three: " + String.format("%.2f", findMedian1(inputOne, inputTwo)));

	}
	@Test
	public void eg4()
	{
	int[] inputOne= {-1,2};
	int[] inputTwo= {3,4,5};
	System.out.println("Four: "+String.format("%.2f", findMedian1(inputOne,inputTwo)));
	
	}
	@Test
	public void eg5()
	{
	int[] inputOne= {1,1};
	int[] inputTwo= {3,4};
	System.out.println("Five: "+String.format("%.2f", findMedian1(inputOne,inputTwo)));
	}
	
	//Solution 1
	
	//1. Create a new Array of length equal to the length of array One and Array Two
	//2. Loop through the first array and add all elements to the new array
	//3. Loop through the second array and add all elements to the new array
	//4. sort the array using inbuilt function from collections
	//5. Determine the length of array list
	//6. if odd, return n/2
	//7.if even return (n/2+(n+1)/2)2, where n is the element at the respective index
	
	private float findMedian1(int[] firstInput, int[] secondInput) {
		List<Integer> combinedArray = new ArrayList<>();
		for (int i = 0; i < firstInput.length; i++)// O[N]
		{
			combinedArray.add(firstInput[i]);
		}
		for (int i = 0; i < secondInput.length; i++)// O[N]
		{
			combinedArray.add(secondInput[i]);
		}
		Collections.sort(combinedArray);// O[nlogn]

		int midSize = combinedArray.size() / 2;// O[1]

		if (combinedArray.size() % 2 == 0)// O[1]
		{
			return (combinedArray.get(midSize - 1) + combinedArray.get(midSize)) / 2;
		} else {
			return combinedArray.get(midSize);
		}

	}
	
	}