package assessment;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

//Given an array of positive integers, find the minimum length ascending
//subsequence such that after removing this subsequence from the
//array, the remaining array contains only unique integers. Only one
//subsequence will have the minimum length (no ties). If there is no such
//subsequence, return [-1].
//Example
//n = 7
//arr = [2, 1, 3, 1, 4, 1, 3]
//After removing the subsequence [1, 1, 3], the remaining array of
//distinct integers is [2, 3, 4, 1]. The subsequence [1, 1, 3] is the shortest
//ascending subsequence with this property, so it is returned.

public class A1P04 {


	@Test
	public void eg1()
	{
		int[] input= {2,1,3,1,4,1,3};
		minimumSubSequence(input);
	}

	@Test
	public void eg2()
	{
		int[] input= {4,1,1,1,3};
		minimumSubSequence(input);
	}

	@Test
	public void eg3()
	{
		int[] input= {3,2,2,1,1};
		minimumSubSequence(input);
	}

	public void minimumSubSequence(int[] input)
	{
		Boolean forwardSequence=true;
		Boolean backwardSequence=true;
		Set<Integer> tempSet=new HashSet<>();
		List<Integer> duplicateSetOne=new LinkedList<>();
		List<Integer> duplicateSetTwo=new LinkedList<>();
		for(int i=0;i<input.length;i++)
		{
			if(!tempSet.add(input[i]))
			{

				if(!duplicateSetOne.isEmpty())
				{
					if(duplicateSetOne.get(duplicateSetOne.size()-1)<=input[i])
					{
						duplicateSetOne.add(input[i]);

					}
					else
					{
						forwardSequence=false;
						break;
					}

				}
				else 
				{
					duplicateSetOne.add(input[i]);

				}

			}
		}
		tempSet.clear();
		for(int i=input.length-1;i>0;i--)
		{
			if(!tempSet.add(input[i]))
			{

				if(!duplicateSetTwo.isEmpty())
				{
					if(duplicateSetTwo.size()>=input[i])
					{
						duplicateSetTwo.add(input[i]);

					}
					else
					{
						backwardSequence=false;
						break;
					}
				}
				else 
				{
					duplicateSetTwo.add(input[i]);
				}
			}
			



		}
		if((!forwardSequence&&!backwardSequence))
		{
			System.out.println(-1);
		}
		else
		{
			if(forwardSequence)
			{
				System.out.println(duplicateSetOne);
			}

			if(backwardSequence)
			{
				System.out.println(duplicateSetTwo);
			}
		}

	}
}
