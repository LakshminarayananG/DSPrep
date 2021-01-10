package practice.old;

import java.util.Arrays;

import org.junit.Test;

public class KthLargestElement {

	@Test
	public void dataSetOne()
	{
		int[] inputArray= {3,2,3,1,2,4,5,7,6};
		int k=3;
		System.out.println(findNumber(inputArray,k));
		
	}
	@Test
	public void dataSetTwo()
	{
		int[] inputArray= {-1,0,1,2,3,5,-2,6,8};
		int k=8;
		System.out.println(findNumber(inputArray,k));
		
	}
	@Test
	public void dataSetThree()
	{
			int[] inputArray= {1,3,5,8,9,11,12,123};
			int k=10;
			//System.out.println(findNumber(inputArray,k));
			
	}
	@Test
	public void dataSetFour()
	{
			int[] inputArray= {1,1,1,1,1};
			int k=2;
			//System.out.println(findNumber(inputArray,k));
			
	}
	@Test
	public void dataSetFive()
	{
			int[] inputArray= {-4,-5,-9,-2};
			int k=2;
			//System.out.println(findNumber(inputArray,k));
			
	}
	

	//Solution 1
	private int findNumber1(int[] array,int k)
	{
		int n=array.length;//O[1]
		if(k>n)//O[1]
		{
			throw new RuntimeException("Invalid Value of K");
		}
		Arrays.sort(array);//O[nlog(n)]
		return array[n-k];//O[1]
		
	}
	
	//Total time Complexity==>O[n* log(n)]

	//solution 2
	private int findNumber(int[] array,int k)
	{
		int n=array.length;//O[1]
		if(k>n)//O[1]
		{
			throw new RuntimeException("Invalid Value of K");
		}
		int temp=0;
		if(k<n/2)
		{
			for(int i=0;i<k;i++)
			{
				for(int j=i+1;j<array.length;j++)//O[N]
				{
					if(array[i]<array[j])//order in descending order					
					{                    //O[M] worst case:O[N*N/2]
						temp=array[i];
						array[i]=array[j];
						array[j]=temp;
						
					}
				}
			}
			return array[k-1];
		}
		else
		{
			k=n-k;
			for(int i=0;i<=k;i++)
			{
				for(int j=i+1;j<array.length;j++)
				{
					if(array[i]>array[j])//order in ascending Order
					{                    //O[M] worst case:O[N/2]
						temp=array[i];
						array[i]=array[j];
						array[j]=temp;
						
					}
						
				}
			}
			return array[k];//O[N]
			
		}
	}
	
	
}
