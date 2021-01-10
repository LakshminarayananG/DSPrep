package week2.homework;
	
import java.util.Arrays;
import org.junit.Test;
	
	public class RotateImage {
		
		/*
		 * Rotate an image
		 * 
		 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]] Output: [[7,4,1],
		 * 													  [8,5,2],
		 * 										              [9,6,3]]
		 */
	
		@Test
		public void eg1() {
			int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			int[][] output = rotateImage(input);
			System.out.println(Arrays.deepToString(input));
			System.out.println(Arrays.deepToString(output));
		}
	
	
		@Test
		public void eg2() {
			int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
			int[][] output = rotateImage(input);
			System.out.println(Arrays.deepToString(input));
			System.out.println(Arrays.deepToString(output));
		}
	
	
		@Test
		public void eg3() {
			int[][] input = new int[][] { { 1, 2 }, { 3, 4 } };
			int[][] output = rotateImage(input);
			System.out.println(Arrays.deepToString(input));
			System.out.println(Arrays.deepToString(output));
		}
		
		
		
		@Test
		public void eg5() {
			int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			int[][] output = rotateImage1(input);
			System.out.println(Arrays.deepToString(input));
			System.out.println(Arrays.deepToString(output));
		}
	
		
		@Test
		public void eg6() {
			int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }};
			int[][] output = rotateImage1(input);
			System.out.println(Arrays.deepToString(output));
		}
	
	
	
	
	//Brute Force Technique
	/*  1. Pass the input array to the function
	2. Declare a new array that has the same size of input array
	3. Declare a temp variable with 0
	4. No of iterations will be equal to no. of columns
	5. 1st for loop to start from the length of columns
	6. 2nd for loop inside it to iterate for the number of rows
	7. Get corresponding elements from array and store in the new array
	8. Return the resulting array*/
	
		// Complexity --> O[N^2]
		private int[][] rotateImage(int[][] input) {
			int[][] newarr = new int[input.length][input[0].length];
			int temp = 0;
			for (int i = input.length - 1; i >= 0; i--) {
				for (int j = 0; j < input.length; j++) {
					newarr[temp][j] = input[j][i];
				}
				temp++;
			}
			return newarr;
		}
		
		
		private int[][] rotateImage1(int[][] input) {
			int[][] newarr = new int[input[0].length][input.length];
			
			for (int i = 0; i <input[0].length; i++) {
				int temp = 0;
				for (int j = input.length-1; j >=0; j--) {
					newarr[i][temp] = input[j][i];
					temp++;
				}
			}
			return newarr;
		}
		
		
		
		private void rotateImage2(int[][] matrix) {
			int[][] output = new int[matrix.length][matrix.length];
			int a = 0, b = 0;
			for (int i = 0; i < matrix.length; i++) {
				for (int j = matrix.length - 1; j >= 0; j--) {
					// System.out.print(matrix[j][i]);
					output[a][b++] = matrix[j][i];
				}
				a++;
				b = 0;
			}
			System.out.println(Arrays.deepToString(output));
		}

		private void rotateImage11(int[][] matrix) {

			int start = 0;
			int end = 0;
			int temp;
			while (start < matrix.length && end < matrix.length) {
				temp = matrix[start][end];
				matrix[start][end] = matrix[end][start];
				matrix[end++][start] = temp;
				if (end == matrix.length) {
					start++;
					end = start;
				}
			}
			//System.out.println(Arrays.deepToString(matrix));
			start = 0;
			end = matrix.length - 1;
			int s1 = 0;
			while (start < matrix.length) {
				temp = matrix[start][s1];
				matrix[start][s1++] = matrix[start][end];
				matrix[start][end--] = temp;

				if (s1 == end) {
					start++;
					s1 = 0;
					end = matrix.length - 1;
				}
			}
			System.out.println(Arrays.deepToString(matrix));
		}
		
		
		
		
		
		
	}