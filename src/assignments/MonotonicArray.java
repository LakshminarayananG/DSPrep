package assignments;

import org.junit.Test;

public class MonotonicArray {
	
	@Test
	public void dataSetOne()
	{
		int[] array= {1,2,3,3,4,4,4,4,5};
		System.out.println("One:"+checkMonotone(array));
	}
	@Test
	public void dataSetTwo()
	{
		int[] array= {1,2,5,3,4,4,4,5};
		System.out.println("Two:"+checkMonotone(array));
	}
	@Test
	public void dataSetThree()
	{
		int[] array= {5,4,4,2,1};
		System.out.println("Three:"+checkMonotone(array));
	}
	@Test
	public void dataSetFour()
	{
		int[] array= {1,1,1,1,1};
		System.out.println("Four:"+checkMonotone(array));
	}
	@Test
	public void dataSetFive()
	{
		int[] array= {-4,-3,-2,0,1,2,5};
		System.out.println("five:"+checkMonotone(array));
	}
	

//Solution 1
private boolean checkMonotone1(int[] array)
{
	if(array[0]==array[array.length-1])//O[1]
		return false;
	else
	{
		Boolean increasingArray=true;
		Boolean decreasingArray=true;
		for(int i=0;i<array.length-1;i++)//O[N]
		{
			if(array[i]<array[i+1])
			{
				decreasingArray=false;
				
			}
			if(array[i]>array[i+1])
			{
				increasingArray=false;
				
			}
		}
		return increasingArray||decreasingArray;//O[1]
	}
	
}
//Solution 2

private boolean checkMonotone(int[] array)
{
	if(array[0]==array[array.length-1])//O[1]
	return false;
	else
	{
		boolean decreasing;
		if(array[0]>array[array.length-1])//O[1]
		{
			decreasing=true;
		}
		else
		{
			decreasing=false;
		}
		int i=0;
		if(decreasing)	
		{
		for(;i<array.length-1;i++)//O[M]( Worst Case O[N]
		{
			if(array[i]<array[i+1])
			break;
		}
		}
		else
		{
			for(;i<array.length-1;i++)
			{
				if(array[i]>array[i+1])					
				break;
			}
			
		}
		if(i==array.length-1)//O[1]
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}

}
