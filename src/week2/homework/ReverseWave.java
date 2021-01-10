package week2.homework;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class ReverseWave {
	
	//Question
	/*
	 * Given a matrix, print it in Reverse Wave Form.
	 * 
	 * Input : 1 2 3 4 
	 * 		   5 6 7 8 
	 * 		   9 10 11 12 
	 * 		   13 14 15 16
	 * 			
	 * 
	 * Output : 4 8 12 16 15 11 7 3 2 6 10 14 13 9 5 1
	 */
	
	@Test
	public void eg1() {
	int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
	int rowcount = input.length;
	int colcount = input[0].length;
	List<Integer> out = reverseWave(input, rowcount, colcount);
	System.out.println(out);
	}

	@Test
	public void eg2() {
	int[][] input = new int[][] { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 }, { 13, 14, 15 } };
	int rowcount = input.length;
	int colcount = input[0].length;
	List<Integer> out = reverseWave(input, rowcount, colcount);
	System.out.println(out);
	}

	@Test
	public void eg3() {
	int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
	int rowcount = input.length;
	int colcount = input[0].length;
	List<Integer> out = reverseWave(input, rowcount, colcount);
	System.out.println(out);
	}
	
	@Test
	public void eg4() {
	int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }};
	int rowcount = input.length;
	int colcount = input[0].length;
	List<Integer> out = reverseWave(input, rowcount, colcount);
	System.out.println(out);
	}

	

	@Test
	public void eg5() {
	int[][] input = new int[][] { { 1, 2, 3,}, { 4, 5, 6},{7,8,9}};
	int rowcount = input.length;
	int colcount = input[0].length;
	twoPointerAlgorithm(input);
	
	}

	// Brute Force technique
	/*
	* 1.Pass input array along with the row and column count
	* 2.No of iterations will be equal to the column count
	* 3.Declare boolean flag with initial value of true
	* 4.Temp value declared to get the array elements and val declared for
	* no. of iteration 4. Iterate over the while loop for the no of iterations = to column count
	* 5.Inside the while loop, check if the flag is true or false
	* 6.If true, traverse from top to bottom, if false, traverse from bottom to up
	* 7.Get array elements inside for loop and add the same to the list.
	* 8.Reset flag to other value so that once loop is over, it will traverse on other direction
	* 9.Reduce temp by 1 so that we traverse to subsequent columns
	*/

	private List<Integer> reverseWave(int[][] input, int rowcount, int colcount) {
		boolean flag = true;
		int temp = colcount - 1;
		int val = 0;
		List<Integer> output = new ArrayList<Integer>();

		while (val <= colcount - 1) {
			if (flag == true) {
				for (int i = 0; i <= rowcount - 1; i++) {
					output.add(input[i][temp]);
				}
				temp -= 1;
				flag = false;
			}

			else if (flag == false) {
				for (int j = rowcount - 1; j >= 0; j--) {
					output.add(input[j][temp]);
				}
				temp -= 1;
				flag = true;
			}
			val++;
		}

		return output;

	}

	
	private void twoPointerAlgorithm(int[][] input) {
		boolean downwardDirection = false;

		for (int i = input[0].length-1 ; i >= 0; i--) {
			downwardDirection= !downwardDirection;
			if(downwardDirection) {
				int firstIndex = 0 , secondIndex=1;
				while(firstIndex < input.length || secondIndex < input.length) {
//					counter++;
					if(firstIndex < input.length )
						System.out.print(input[firstIndex][i]+",");
					if(secondIndex < input.length)
						System.out.print(input[secondIndex][i]+",");
					firstIndex+= 2;
					secondIndex+= 2;
				}
			}else {
				int firstIndex = input.length-1 , secondIndex=firstIndex-1;
				while(firstIndex >=0 || secondIndex >=0) {
//					counter++;
					if(firstIndex >=0 )
						System.out.print(input[firstIndex][i]+",");
					if(secondIndex >=0)
						System.out.print(input[secondIndex][i]+",");
					firstIndex-= 2;
					secondIndex-= 2;
				}

			}
		}		
//		System.out.println("two pointer counter "+counter);
	}	
	
	
	

}
