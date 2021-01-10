package week12.classwork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ValidCombinations {
	
	/*
	Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
	1) Only numbers 1 through 9 are used.
	2) Each number is used at most once.
	Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
	Example 1:
	Input: k = 3, n = 7
	Output: [[1,2,4]]
	Explanation:
	1 + 2 + 4 = 7
	There are no other valid combinations.
	Example 2:
	Input: k = 3, n = 9
	Output: [[1,2,6],[1,3,5],[2,3,4]]
	Explanation:
	1 + 2 + 6 = 9
	1 + 3 + 5 = 9
	2 + 3 + 4 = 9
	There are no other valid combinations.
	*/

	//Pseudo code
	/*
	iterate through each element from 1 to 9
	take first number and add it to next consecutive numbers and add those numbers to the set say 1+2=3
	take the sum of first 2 numbers and subtract it with target say 7-3=4
	add this number to the set (4)
	if set size not equal to 3, don't consider
	iterate the second loop until it reaches greater than or equal to target
	*/

	/*
	1) Pick first element in the combination [1, 2, 3, 4, 5, 6, 7, 8, 9]
	2) We need two more elements to fill in the final combination.
	3) Since we've already picked the digit 1, we should exclude 1, in order to ensure that the combination does not contain any duplicate
	4) The sum of the remaining two elements should be 9 - 1 = 8.
	5) Based on the above conditions,  second element => several choices. 
	    a) Let us pick the digit 2, which is not a duplicate of the first element, plus it does not exceed the desired sum (i.e. 8) neither. 
	    b) The combination now becomes [1, 2].
	    c) Now for the third element, optionless but to pick the digit 6 as the final element in the combination of [1, 2, 6].
	6) As we mentioned before, for the second element, we could have several choices. 
	    For instance, we could have picked the digit 3, instead of the digit 2. Eventually, it could lead us to another solution as [1, 3, 5].
	7) For each element in the combination, we could revisit choices, and try out other possibilities to see if it leads to a valid solution.
	*/
	
	@Test
	public void example1() {
		int k = 3, n = 9;
		validCombo(k, n);
	}

	@Test
	public void example2() {
		int k = 3, n = 7;
		validCombo(k, n);
	}

	@Test
	public void example3() {
		int k = 4, n = 12;
		validCombo(k, n);
	}

	private void validCombo(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		comboRecur(k, n, list, new ArrayList<>(), 1);
		System.out.println(list);
	}

	private void comboRecur(int k, int n, List<List<Integer>> list, List<Integer> combo, int start) {
		if (combo.size() == k && n == 0) {
			List<Integer> temp = new ArrayList<>(combo);
			list.add(temp);
			return;
		}

		for (int i = start; i < 10; i++) {
			combo.add(i);
			comboRecur(k, n - i, list, combo, i + 1);
			combo.remove(combo.size() - 1);
		}
	}

	private void validCombo1(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp;
		int sum = 0;
		for (int i = 1; i < 10; i++) {
			temp = new ArrayList<>();
			temp.add(i);
			sum = n - i;
			for (int j = i + 1; j < 10; j++) {
				sum -= j;
				temp.add(j);
				if (sum <= j)
					break;
				if (sum > j && temp.size() == k - 1) {
					temp.add(sum);
					list.add(new ArrayList<>(temp));
					temp.clear();
					temp.add(i);
					sum = n - i;

				}
			}
		}
		System.out.println(list);
	}
	
	
	@Test
	public void dataSetOne()
	{
	int k=3;
	int n=9;
	System.out.println(findCombinations(k,n));
	System.out.println(j);


	}


	@Test
	public void dataSetTwo()
	{
	int k=4;
	int n=9;
	System.out.println(findCombinations(k,n));
	System.out.println(j);

	}

	@Test
	public void dataSetThree()
	{
	int k=3;
	int n=7;
	System.out.println(findCombinations(k,n));
	System.out.println(j);

	}

	int j=0;
	private List<List<Integer>> findCombinations(int k,int n)
	{

	List<List<Integer>> output=new ArrayList<>();
	findcombination(k,n,1,output,new ArrayList<>());
	return output;



	}
	    private void findcombination(int k,int n,int start,List<List<Integer>> output,List<Integer> current)
	    {
	    if(current.size()==k&& n==0)
	    {
	    List<Integer> temp=new ArrayList<>(current);
	    output.add(temp);
	    return;
	    }

	if((n<start)) return;
	   
	   
	    for(int i=start;i<10;i++)
	    {
	    current.add(i);j++;
	    findcombination(k,n-i,i+1,output,current);
	    current.remove(current.size()-1);
	    }
	   
	    }

}
